package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
/* loaded from: classes2.dex */
public class GoogleApiManager implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    public static final Status f11711f = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: g, reason: collision with root package name */
    private static final Status f11712g = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: h, reason: collision with root package name */
    private static final Object f11713h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static GoogleApiManager f11714i;
    private final Context m;
    private final GoogleApiAvailability n;
    private final GoogleApiAvailabilityCache o;
    private final Handler v;

    /* renamed from: j, reason: collision with root package name */
    private long f11715j = 5000;

    /* renamed from: k, reason: collision with root package name */
    private long f11716k = LocalNotificationSyncManager.TWO_MINUTES;
    private long l = 10000;
    private final AtomicInteger p = new AtomicInteger(1);
    private final AtomicInteger q = new AtomicInteger(0);
    private final Map<zai<?>, zaa<?>> r = new ConcurrentHashMap(5, 0.75f, 1);
    private zaae s = null;
    private final Set<zai<?>> t = new c.e.b();
    private final Set<zai<?>> u = new c.e.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements zach, BaseGmsClient.ConnectionProgressReportCallbacks {
        private final Api.Client a;

        /* renamed from: b, reason: collision with root package name */
        private final zai<?> f11718b;

        /* renamed from: c, reason: collision with root package name */
        private IAccountAccessor f11719c = null;

        /* renamed from: d, reason: collision with root package name */
        private Set<Scope> f11720d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f11721e = false;

        public b(Api.Client client, zai<?> zaiVar) {
            this.a = client;
            this.f11718b = zaiVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean e(b bVar, boolean z) {
            bVar.f11721e = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            IAccountAccessor iAccountAccessor;
            if (!this.f11721e || (iAccountAccessor = this.f11719c) == null) {
                return;
            }
            this.a.getRemoteService(iAccountAccessor, this.f11720d);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void a(ConnectionResult connectionResult) {
            GoogleApiManager.this.v.post(new e0(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void b(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor != null && set != null) {
                this.f11719c = iAccountAccessor;
                this.f11720d = set;
                g();
            } else {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                c(new ConnectionResult(4));
            }
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void c(ConnectionResult connectionResult) {
            ((zaa) GoogleApiManager.this.r.get(this.f11718b)).I(connectionResult);
        }
    }

    /* loaded from: classes2.dex */
    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {

        /* renamed from: g, reason: collision with root package name */
        private final Api.Client f11724g;

        /* renamed from: h, reason: collision with root package name */
        private final Api.AnyClient f11725h;

        /* renamed from: i, reason: collision with root package name */
        private final zai<O> f11726i;

        /* renamed from: j, reason: collision with root package name */
        private final zaab f11727j;
        private final int m;
        private final zace n;
        private boolean o;

        /* renamed from: f, reason: collision with root package name */
        private final Queue<zab> f11723f = new LinkedList();

        /* renamed from: k, reason: collision with root package name */
        private final Set<zak> f11728k = new HashSet();
        private final Map<ListenerHolder.ListenerKey<?>, zabw> l = new HashMap();
        private final List<a> p = new ArrayList();
        private ConnectionResult q = null;

        public zaa(GoogleApi<O> googleApi) {
            Api.Client i2 = googleApi.i(GoogleApiManager.this.v.getLooper(), this);
            this.f11724g = i2;
            if (i2 instanceof SimpleClientAdapter) {
                this.f11725h = ((SimpleClientAdapter) i2).j();
            } else {
                this.f11725h = i2;
            }
            this.f11726i = googleApi.l();
            this.f11727j = new zaab();
            this.m = googleApi.g();
            if (i2.requiresSignIn()) {
                this.n = googleApi.k(GoogleApiManager.this.m, GoogleApiManager.this.v);
            } else {
                this.n = null;
            }
        }

        private final void C(zab zabVar) {
            zabVar.d(this.f11727j, d());
            try {
                zabVar.c(this);
            } catch (DeadObjectException unused) {
                H(1);
                this.f11724g.disconnect();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean D(boolean z) {
            Preconditions.d(GoogleApiManager.this.v);
            if (!this.f11724g.isConnected() || this.l.size() != 0) {
                return false;
            }
            if (!this.f11727j.e()) {
                this.f11724g.disconnect();
                return true;
            }
            if (z) {
                y();
            }
            return false;
        }

        private final boolean J(ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.f11713h) {
                if (GoogleApiManager.this.s == null || !GoogleApiManager.this.t.contains(this.f11726i)) {
                    return false;
                }
                GoogleApiManager.this.s.m(connectionResult, this.m);
                return true;
            }
        }

        private final void K(ConnectionResult connectionResult) {
            for (zak zakVar : this.f11728k) {
                String str = null;
                if (Objects.a(connectionResult, ConnectionResult.f11619f)) {
                    str = this.f11724g.getEndpointPackageName();
                }
                zakVar.b(this.f11726i, connectionResult, str);
            }
            this.f11728k.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Feature f(Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] availableFeatures = this.f11724g.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                c.e.a aVar = new c.e.a(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    aVar.put(feature.y(), Long.valueOf(feature.z()));
                }
                for (Feature feature2 : featureArr) {
                    if (!aVar.containsKey(feature2.y()) || ((Long) aVar.get(feature2.y())).longValue() < feature2.z()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(a aVar) {
            if (this.p.contains(aVar) && !this.o) {
                if (!this.f11724g.isConnected()) {
                    a();
                } else {
                    s();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o(a aVar) {
            Feature[] g2;
            if (this.p.remove(aVar)) {
                GoogleApiManager.this.v.removeMessages(15, aVar);
                GoogleApiManager.this.v.removeMessages(16, aVar);
                Feature feature = aVar.f11717b;
                ArrayList arrayList = new ArrayList(this.f11723f.size());
                for (zab zabVar : this.f11723f) {
                    if ((zabVar instanceof zac) && (g2 = ((zac) zabVar).g(this)) != null && ArrayUtils.b(g2, feature)) {
                        arrayList.add(zabVar);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    zab zabVar2 = (zab) obj;
                    this.f11723f.remove(zabVar2);
                    zabVar2.e(new UnsupportedApiCallException(feature));
                }
            }
        }

        private final boolean p(zab zabVar) {
            if (!(zabVar instanceof zac)) {
                C(zabVar);
                return true;
            }
            zac zacVar = (zac) zabVar;
            Feature f2 = f(zacVar.g(this));
            if (f2 == null) {
                C(zabVar);
                return true;
            }
            if (zacVar.h(this)) {
                a aVar = new a(this.f11726i, f2, null);
                int indexOf = this.p.indexOf(aVar);
                if (indexOf >= 0) {
                    a aVar2 = this.p.get(indexOf);
                    GoogleApiManager.this.v.removeMessages(15, aVar2);
                    GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 15, aVar2), GoogleApiManager.this.f11715j);
                    return false;
                }
                this.p.add(aVar);
                GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 15, aVar), GoogleApiManager.this.f11715j);
                GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 16, aVar), GoogleApiManager.this.f11716k);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (J(connectionResult)) {
                    return false;
                }
                GoogleApiManager.this.s(connectionResult, this.m);
                return false;
            }
            zacVar.e(new UnsupportedApiCallException(f2));
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q() {
            v();
            K(ConnectionResult.f11619f);
            x();
            Iterator<zabw> it = this.l.values().iterator();
            while (it.hasNext()) {
                zabw next = it.next();
                if (f(next.a.c()) != null) {
                    it.remove();
                } else {
                    try {
                        next.a.d(this.f11725h, new TaskCompletionSource<>());
                    } catch (DeadObjectException unused) {
                        H(1);
                        this.f11724g.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            s();
            y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r() {
            v();
            this.o = true;
            this.f11727j.g();
            GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 9, this.f11726i), GoogleApiManager.this.f11715j);
            GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 11, this.f11726i), GoogleApiManager.this.f11716k);
            GoogleApiManager.this.o.a();
        }

        private final void s() {
            ArrayList arrayList = new ArrayList(this.f11723f);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                zab zabVar = (zab) obj;
                if (!this.f11724g.isConnected()) {
                    return;
                }
                if (p(zabVar)) {
                    this.f11723f.remove(zabVar);
                }
            }
        }

        private final void x() {
            if (this.o) {
                GoogleApiManager.this.v.removeMessages(11, this.f11726i);
                GoogleApiManager.this.v.removeMessages(9, this.f11726i);
                this.o = false;
            }
        }

        private final void y() {
            GoogleApiManager.this.v.removeMessages(12, this.f11726i);
            GoogleApiManager.this.v.sendMessageDelayed(GoogleApiManager.this.v.obtainMessage(12, this.f11726i), GoogleApiManager.this.l);
        }

        final zad A() {
            zace zaceVar = this.n;
            if (zaceVar == null) {
                return null;
            }
            return zaceVar.Y4();
        }

        public final void B(Status status) {
            Preconditions.d(GoogleApiManager.this.v);
            Iterator<zab> it = this.f11723f.iterator();
            while (it.hasNext()) {
                it.next().b(status);
            }
            this.f11723f.clear();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void E0(ConnectionResult connectionResult) {
            Preconditions.d(GoogleApiManager.this.v);
            zace zaceVar = this.n;
            if (zaceVar != null) {
                zaceVar.p5();
            }
            v();
            GoogleApiManager.this.o.a();
            K(connectionResult);
            if (connectionResult.y() == 4) {
                B(GoogleApiManager.f11712g);
                return;
            }
            if (this.f11723f.isEmpty()) {
                this.q = connectionResult;
                return;
            }
            if (J(connectionResult) || GoogleApiManager.this.s(connectionResult, this.m)) {
                return;
            }
            if (connectionResult.y() == 18) {
                this.o = true;
            }
            if (this.o) {
                GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 9, this.f11726i), GoogleApiManager.this.f11715j);
                return;
            }
            String c2 = this.f11726i.c();
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 38);
            sb.append("API: ");
            sb.append(c2);
            sb.append(" is not available on this device.");
            B(new Status(17, sb.toString()));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void H(int i2) {
            if (Looper.myLooper() != GoogleApiManager.this.v.getLooper()) {
                GoogleApiManager.this.v.post(new a0(this));
            } else {
                r();
            }
        }

        public final void I(ConnectionResult connectionResult) {
            Preconditions.d(GoogleApiManager.this.v);
            this.f11724g.disconnect();
            E0(connectionResult);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void P(Bundle bundle) {
            if (Looper.myLooper() != GoogleApiManager.this.v.getLooper()) {
                GoogleApiManager.this.v.post(new z(this));
            } else {
                q();
            }
        }

        public final void a() {
            Preconditions.d(GoogleApiManager.this.v);
            if (this.f11724g.isConnected() || this.f11724g.isConnecting()) {
                return;
            }
            int b2 = GoogleApiManager.this.o.b(GoogleApiManager.this.m, this.f11724g);
            if (b2 != 0) {
                E0(new ConnectionResult(b2, null));
                return;
            }
            b bVar = new b(this.f11724g, this.f11726i);
            if (this.f11724g.requiresSignIn()) {
                this.n.S4(bVar);
            }
            this.f11724g.connect(bVar);
        }

        public final int b() {
            return this.m;
        }

        final boolean c() {
            return this.f11724g.isConnected();
        }

        public final boolean d() {
            return this.f11724g.requiresSignIn();
        }

        public final void e() {
            Preconditions.d(GoogleApiManager.this.v);
            if (this.o) {
                a();
            }
        }

        public final void i(zab zabVar) {
            Preconditions.d(GoogleApiManager.this.v);
            if (this.f11724g.isConnected()) {
                if (p(zabVar)) {
                    y();
                    return;
                } else {
                    this.f11723f.add(zabVar);
                    return;
                }
            }
            this.f11723f.add(zabVar);
            ConnectionResult connectionResult = this.q;
            if (connectionResult != null && connectionResult.Y()) {
                E0(this.q);
            } else {
                a();
            }
        }

        public final void j(zak zakVar) {
            Preconditions.d(GoogleApiManager.this.v);
            this.f11728k.add(zakVar);
        }

        @Override // com.google.android.gms.common.api.internal.zar
        public final void k0(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() != GoogleApiManager.this.v.getLooper()) {
                GoogleApiManager.this.v.post(new b0(this, connectionResult));
            } else {
                E0(connectionResult);
            }
        }

        public final Api.Client l() {
            return this.f11724g;
        }

        public final void m() {
            Status status;
            Preconditions.d(GoogleApiManager.this.v);
            if (this.o) {
                x();
                if (GoogleApiManager.this.n.i(GoogleApiManager.this.m) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                B(status);
                this.f11724g.disconnect();
            }
        }

        public final void t() {
            Preconditions.d(GoogleApiManager.this.v);
            B(GoogleApiManager.f11711f);
            this.f11727j.f();
            for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.l.keySet().toArray(new ListenerHolder.ListenerKey[this.l.size()])) {
                i(new zah(listenerKey, new TaskCompletionSource()));
            }
            K(new ConnectionResult(4));
            if (this.f11724g.isConnected()) {
                this.f11724g.onUserSignOut(new c0(this));
            }
        }

        public final Map<ListenerHolder.ListenerKey<?>, zabw> u() {
            return this.l;
        }

        public final void v() {
            Preconditions.d(GoogleApiManager.this.v);
            this.q = null;
        }

        public final ConnectionResult w() {
            Preconditions.d(GoogleApiManager.this.v);
            return this.q;
        }

        public final boolean z() {
            return D(true);
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.m = context;
        zap zapVar = new zap(looper, this);
        this.v = zapVar;
        this.n = googleApiAvailability;
        this.o = new GoogleApiAvailabilityCache(googleApiAvailability);
        zapVar.sendMessage(zapVar.obtainMessage(6));
    }

    @KeepForSdk
    public static void b() {
        synchronized (f11713h) {
            GoogleApiManager googleApiManager = f11714i;
            if (googleApiManager != null) {
                googleApiManager.q.incrementAndGet();
                Handler handler = googleApiManager.v;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static GoogleApiManager k(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (f11713h) {
            if (f11714i == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f11714i = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.q());
            }
            googleApiManager = f11714i;
        }
        return googleApiManager;
    }

    private final void l(GoogleApi<?> googleApi) {
        zai<?> l = googleApi.l();
        zaa<?> zaaVar = this.r.get(l);
        if (zaaVar == null) {
            zaaVar = new zaa<>(googleApi);
            this.r.put(l, zaaVar);
        }
        if (zaaVar.d()) {
            this.u.add(l);
        }
        zaaVar.a();
    }

    public static GoogleApiManager n() {
        GoogleApiManager googleApiManager;
        synchronized (f11713h) {
            Preconditions.l(f11714i, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = f11714i;
        }
        return googleApiManager;
    }

    public final void A() {
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.q.incrementAndGet();
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PendingIntent c(zai<?> zaiVar, int i2) {
        zad A;
        zaa<?> zaaVar = this.r.get(zaiVar);
        if (zaaVar == null || (A = zaaVar.A()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.m, i2, A.getSignInIntent(), 134217728);
    }

    public final Task<Map<zai<?>, String>> e(Iterable<? extends GoogleApi<?>> iterable) {
        zak zakVar = new zak(iterable);
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(2, zakVar));
        return zakVar.a();
    }

    public final void f(ConnectionResult connectionResult, int i2) {
        if (s(connectionResult, i2)) {
            return;
        }
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
    }

    public final void g(GoogleApi<?> googleApi) {
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final <O extends Api.ApiOptions> void h(GoogleApi<O> googleApi, int i2, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zaeVar = new zae(i2, apiMethodImpl);
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zaeVar, this.q.get(), googleApi)));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        long j2 = LocalNotificationSyncManager.FIVE_MINUTES;
        zaa<?> zaaVar = null;
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.l = j2;
                this.v.removeMessages(12);
                for (zai<?> zaiVar : this.r.keySet()) {
                    Handler handler = this.v;
                    handler.sendMessageDelayed(handler.obtainMessage(12, zaiVar), this.l);
                }
                return true;
            case 2:
                zak zakVar = (zak) message.obj;
                Iterator<zai<?>> it = zakVar.c().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zai<?> next = it.next();
                        zaa<?> zaaVar2 = this.r.get(next);
                        if (zaaVar2 == null) {
                            zakVar.b(next, new ConnectionResult(13), null);
                        } else if (zaaVar2.c()) {
                            zakVar.b(next, ConnectionResult.f11619f, zaaVar2.l().getEndpointPackageName());
                        } else if (zaaVar2.w() != null) {
                            zakVar.b(next, zaaVar2.w(), null);
                        } else {
                            zaaVar2.j(zakVar);
                            zaaVar2.a();
                        }
                    }
                }
                return true;
            case 3:
                for (zaa<?> zaaVar3 : this.r.values()) {
                    zaaVar3.v();
                    zaaVar3.a();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zabv zabvVar = (zabv) message.obj;
                zaa<?> zaaVar4 = this.r.get(zabvVar.f11835c.l());
                if (zaaVar4 == null) {
                    l(zabvVar.f11835c);
                    zaaVar4 = this.r.get(zabvVar.f11835c.l());
                }
                if (zaaVar4.d() && this.q.get() != zabvVar.f11834b) {
                    zabvVar.a.b(f11711f);
                    zaaVar4.t();
                } else {
                    zaaVar4.i(zabvVar.a);
                }
                return true;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zaa<?>> it2 = this.r.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zaa<?> next2 = it2.next();
                        if (next2.b() == i3) {
                            zaaVar = next2;
                        }
                    }
                }
                if (zaaVar != null) {
                    String g2 = this.n.g(connectionResult.y());
                    String z = connectionResult.z();
                    StringBuilder sb = new StringBuilder(String.valueOf(g2).length() + 69 + String.valueOf(z).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(g2);
                    sb.append(": ");
                    sb.append(z);
                    zaaVar.B(new Status(17, sb.toString()));
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                }
                return true;
            case 6:
                if (PlatformVersion.a() && (this.m.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.c((Application) this.m.getApplicationContext());
                    BackgroundDetector.b().a(new y(this));
                    if (!BackgroundDetector.b().e(true)) {
                        this.l = LocalNotificationSyncManager.FIVE_MINUTES;
                    }
                }
                return true;
            case 7:
                l((GoogleApi) message.obj);
                return true;
            case 9:
                if (this.r.containsKey(message.obj)) {
                    this.r.get(message.obj).e();
                }
                return true;
            case 10:
                Iterator<zai<?>> it3 = this.u.iterator();
                while (it3.hasNext()) {
                    this.r.remove(it3.next()).t();
                }
                this.u.clear();
                return true;
            case 11:
                if (this.r.containsKey(message.obj)) {
                    this.r.get(message.obj).m();
                }
                return true;
            case 12:
                if (this.r.containsKey(message.obj)) {
                    this.r.get(message.obj).z();
                }
                return true;
            case 14:
                d dVar = (d) message.obj;
                zai<?> b2 = dVar.b();
                if (!this.r.containsKey(b2)) {
                    dVar.a().c(Boolean.FALSE);
                } else {
                    dVar.a().c(Boolean.valueOf(this.r.get(b2).D(false)));
                }
                return true;
            case 15:
                a aVar = (a) message.obj;
                if (this.r.containsKey(aVar.a)) {
                    this.r.get(aVar.a).h(aVar);
                }
                return true;
            case 16:
                a aVar2 = (a) message.obj;
                if (this.r.containsKey(aVar2.a)) {
                    this.r.get(aVar2.a).o(aVar2);
                }
                return true;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
    }

    public final void i(zaae zaaeVar) {
        synchronized (f11713h) {
            if (this.s != zaaeVar) {
                this.s = zaaeVar;
                this.t.clear();
            }
            this.t.addAll(zaaeVar.p());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(zaae zaaeVar) {
        synchronized (f11713h) {
            if (this.s == zaaeVar) {
                this.s = null;
                this.t.clear();
            }
        }
    }

    public final int o() {
        return this.p.getAndIncrement();
    }

    final boolean s(ConnectionResult connectionResult, int i2) {
        return this.n.A(this.m, connectionResult, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private final zai<?> a;

        /* renamed from: b, reason: collision with root package name */
        private final Feature f11717b;

        private a(zai<?> zaiVar, Feature feature) {
            this.a = zaiVar;
            this.f11717b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                if (Objects.a(this.a, aVar.a) && Objects.a(this.f11717b, aVar.f11717b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.b(this.a, this.f11717b);
        }

        public final String toString() {
            return Objects.c(this).a(RoomNotification.KEY, this.a).a(DeepLinkIntentReceiver.DeepLinksTargets.FEATURE, this.f11717b).toString();
        }

        /* synthetic */ a(zai zaiVar, Feature feature, y yVar) {
            this(zaiVar, feature);
        }
    }
}
