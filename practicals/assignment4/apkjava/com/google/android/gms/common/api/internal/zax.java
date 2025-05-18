package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class zax implements zabs {

    /* renamed from: h, reason: collision with root package name */
    private final Map<Api<?>, Boolean> f11883h;

    /* renamed from: i, reason: collision with root package name */
    private final GoogleApiManager f11884i;

    /* renamed from: j, reason: collision with root package name */
    private final zaaw f11885j;

    /* renamed from: k, reason: collision with root package name */
    private final Lock f11886k;
    private final Looper l;
    private final GoogleApiAvailabilityLight m;
    private final Condition n;
    private final ClientSettings o;
    private final boolean p;
    private final boolean q;
    private boolean s;
    private Map<zai<?>, ConnectionResult> t;
    private Map<zai<?>, ConnectionResult> u;
    private a v;
    private ConnectionResult w;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Api.AnyClientKey<?>, zaw<?>> f11881f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Map<Api.AnyClientKey<?>, zaw<?>> f11882g = new HashMap();
    private final Queue<BaseImplementation.ApiMethodImpl<?, ?>> r = new LinkedList();

    public zax(Context context, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zaaw zaawVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f11886k = lock;
        this.l = looper;
        this.n = lock.newCondition();
        this.m = googleApiAvailabilityLight;
        this.f11885j = zaawVar;
        this.f11883h = map2;
        this.o = clientSettings;
        this.p = z;
        HashMap hashMap = new HashMap();
        for (Api<?> api : map2.keySet()) {
            hashMap.put(api.a(), api);
        }
        HashMap hashMap2 = new HashMap();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zaq zaqVar = arrayList.get(i2);
            i2++;
            zaq zaqVar2 = zaqVar;
            hashMap2.put(zaqVar2.f11876f, zaqVar2);
        }
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api api2 = (Api) hashMap.get(entry.getKey());
            Api.Client value = entry.getValue();
            if (value.requiresGooglePlayServices()) {
                z4 = z6;
                if (this.f11883h.get(api2).booleanValue()) {
                    z3 = z7;
                    z2 = true;
                } else {
                    z2 = true;
                    z3 = true;
                }
            } else {
                z2 = z5;
                z3 = z7;
                z4 = false;
            }
            zaw<?> zawVar = new zaw<>(context, api2, looper, value, (zaq) hashMap2.get(api2), clientSettings, abstractClientBuilder);
            this.f11881f.put(entry.getKey(), zawVar);
            if (value.requiresSignIn()) {
                this.f11882g.put(entry.getKey(), zawVar);
            }
            z5 = z2;
            z6 = z4;
            z7 = z3;
        }
        this.q = (!z5 || z6 || z7) ? false : true;
        this.f11884i = GoogleApiManager.n();
    }

    private final ConnectionResult h(Api.AnyClientKey<?> anyClientKey) {
        this.f11886k.lock();
        try {
            zaw<?> zawVar = this.f11881f.get(anyClientKey);
            Map<zai<?>, ConnectionResult> map = this.t;
            if (map != null && zawVar != null) {
                return map.get(zawVar.l());
            }
            this.f11886k.unlock();
            return null;
        } finally {
            this.f11886k.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(zaw<?> zawVar, ConnectionResult connectionResult) {
        return !connectionResult.e0() && !connectionResult.Y() && this.f11883h.get(zawVar.e()).booleanValue() && zawVar.m().requiresGooglePlayServices() && this.m.m(connectionResult.y());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean n(zax zaxVar, boolean z) {
        zaxVar.s = false;
        return false;
    }

    private final boolean o() {
        this.f11886k.lock();
        try {
            if (this.s && this.p) {
                Iterator<Api.AnyClientKey<?>> it = this.f11882g.keySet().iterator();
                while (it.hasNext()) {
                    ConnectionResult h2 = h(it.next());
                    if (h2 == null || !h2.e0()) {
                        return false;
                    }
                }
                this.f11886k.unlock();
                return true;
            }
            return false;
        } finally {
            this.f11886k.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (this.o == null) {
            this.f11885j.q = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(this.o.k());
        Map<Api<?>, ClientSettings.OptionalApiSettings> h2 = this.o.h();
        for (Api<?> api : h2.keySet()) {
            ConnectionResult f2 = f(api);
            if (f2 != null && f2.e0()) {
                hashSet.addAll(h2.get(api).a);
            }
        }
        this.f11885j.q = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        while (!this.r.isEmpty()) {
            l0(this.r.remove());
        }
        this.f11885j.b(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectionResult r() {
        int i2 = 0;
        ConnectionResult connectionResult = null;
        ConnectionResult connectionResult2 = null;
        int i3 = 0;
        for (zaw<?> zawVar : this.f11881f.values()) {
            Api<?> e2 = zawVar.e();
            ConnectionResult connectionResult3 = this.t.get(zawVar.l());
            if (!connectionResult3.e0() && (!this.f11883h.get(e2).booleanValue() || connectionResult3.Y() || this.m.m(connectionResult3.y()))) {
                if (connectionResult3.y() == 4 && this.p) {
                    int b2 = e2.c().b();
                    if (connectionResult2 == null || i3 > b2) {
                        connectionResult2 = connectionResult3;
                        i3 = b2;
                    }
                } else {
                    int b3 = e2.c().b();
                    if (connectionResult == null || i2 > b3) {
                        connectionResult = connectionResult3;
                        i2 = b3;
                    }
                }
            }
        }
        return (connectionResult == null || connectionResult2 == null || i2 <= i3) ? connectionResult : connectionResult2;
    }

    private final <T extends BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient>> boolean t(T t) {
        Api.AnyClientKey<?> u = t.u();
        ConnectionResult h2 = h(u);
        if (h2 == null || h2.y() != 4) {
            return false;
        }
        t.y(new Status(4, null, this.f11884i.c(this.f11881f.get(u).l(), System.identityHashCode(this.f11885j))));
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void a() {
        this.f11886k.lock();
        try {
            if (this.s) {
                return;
            }
            this.s = true;
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = null;
            this.f11884i.A();
            this.f11884i.e(this.f11881f.values()).c(new HandlerExecutor(this.l), new w0(this));
        } finally {
            this.f11886k.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean b(SignInConnectionListener signInConnectionListener) {
        this.f11886k.lock();
        try {
            if (this.s && !o()) {
                this.f11884i.A();
                this.v = new a(this, signInConnectionListener);
                this.f11884i.e(this.f11882g.values()).c(new HandlerExecutor(this.l), this.v);
                this.f11886k.unlock();
                return true;
            }
            this.f11886k.unlock();
            return false;
        } catch (Throwable th) {
            this.f11886k.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void c() {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void d() {
        this.f11886k.lock();
        try {
            this.f11884i.a();
            a aVar = this.v;
            if (aVar != null) {
                aVar.b();
                this.v = null;
            }
            if (this.u == null) {
                this.u = new c.e.a(this.f11882g.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            Iterator<zaw<?>> it = this.f11882g.values().iterator();
            while (it.hasNext()) {
                this.u.put(it.next().l(), connectionResult);
            }
            Map<zai<?>, ConnectionResult> map = this.t;
            if (map != null) {
                map.putAll(this.u);
            }
        } finally {
            this.f11886k.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        this.f11886k.lock();
        try {
            this.s = false;
            this.t = null;
            this.u = null;
            a aVar = this.v;
            if (aVar != null) {
                aVar.b();
                this.v = null;
            }
            this.w = null;
            while (!this.r.isEmpty()) {
                BaseImplementation.ApiMethodImpl<?, ?> remove = this.r.remove();
                remove.n(null);
                remove.d();
            }
            this.n.signalAll();
        } finally {
            this.f11886k.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult e() {
        a();
        while (g()) {
            try {
                this.n.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f11619f;
        }
        ConnectionResult connectionResult = this.w;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    public final ConnectionResult f(Api<?> api) {
        return h(api.a());
    }

    public final boolean g() {
        boolean z;
        this.f11886k.lock();
        try {
            if (this.t == null) {
                if (this.s) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f11886k.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnected() {
        boolean z;
        this.f11886k.lock();
        try {
            if (this.t != null) {
                if (this.w == null) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.f11886k.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l0(T t) {
        Api.AnyClientKey<A> u = t.u();
        if (this.p && t(t)) {
            return t;
        }
        this.f11885j.y.b(t);
        return (T) this.f11881f.get(u).d(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T m0(T t) {
        if (this.p && t(t)) {
            return t;
        }
        if (!isConnected()) {
            this.r.add(t);
            return t;
        }
        this.f11885j.y.b(t);
        return (T) this.f11881f.get(t.u()).c(t);
    }
}
