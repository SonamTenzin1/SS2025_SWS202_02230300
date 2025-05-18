package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class zaak implements zabd {
    private final zabe a;

    /* renamed from: b, reason: collision with root package name */
    private final Lock f11805b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f11806c;

    /* renamed from: d, reason: collision with root package name */
    private final GoogleApiAvailabilityLight f11807d;

    /* renamed from: e, reason: collision with root package name */
    private ConnectionResult f11808e;

    /* renamed from: f, reason: collision with root package name */
    private int f11809f;

    /* renamed from: h, reason: collision with root package name */
    private int f11811h;

    /* renamed from: k, reason: collision with root package name */
    private zad f11814k;
    private boolean l;
    private boolean m;
    private boolean n;
    private IAccountAccessor o;
    private boolean p;
    private boolean q;
    private final ClientSettings r;
    private final Map<Api<?>, Boolean> s;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> t;

    /* renamed from: g, reason: collision with root package name */
    private int f11810g = 0;

    /* renamed from: i, reason: collision with root package name */
    private final Bundle f11812i = new Bundle();

    /* renamed from: j, reason: collision with root package name */
    private final Set<Api.AnyClientKey> f11813j = new HashSet();
    private ArrayList<Future<?>> u = new ArrayList<>();

    public zaak(zabe zabeVar, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.a = zabeVar;
        this.r = clientSettings;
        this.s = map;
        this.f11807d = googleApiAvailabilityLight;
        this.t = abstractClientBuilder;
        this.f11805b = lock;
        this.f11806c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(com.google.android.gms.signin.internal.zaj zajVar) {
        if (t(0)) {
            ConnectionResult y = zajVar.y();
            if (y.e0()) {
                ResolveAccountResponse z = zajVar.z();
                ConnectionResult z2 = z.z();
                if (!z2.e0()) {
                    String valueOf = String.valueOf(z2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    x(z2);
                    return;
                }
                this.n = true;
                this.o = z.y();
                this.p = z.W();
                this.q = z.Y();
                j();
                return;
            }
            if (w(y)) {
                l();
                j();
            } else {
                x(y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        int i2 = this.f11811h - 1;
        this.f11811h = i2;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            Log.w("GoogleApiClientConnecting", this.a.s.G());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            x(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f11808e;
        if (connectionResult == null) {
            return true;
        }
        this.a.r = this.f11809f;
        x(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (this.f11811h != 0) {
            return;
        }
        if (!this.m || this.n) {
            ArrayList arrayList = new ArrayList();
            this.f11810g = 1;
            this.f11811h = this.a.f11830k.size();
            for (Api.AnyClientKey<?> anyClientKey : this.a.f11830k.keySet()) {
                if (this.a.l.containsKey(anyClientKey)) {
                    if (i()) {
                        k();
                    }
                } else {
                    arrayList.add(this.a.f11830k.get(anyClientKey));
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.u.add(zabh.a().submit(new l(this, arrayList)));
        }
    }

    private final void k() {
        this.a.l();
        zabh.a().execute(new g(this));
        zad zadVar = this.f11814k;
        if (zadVar != null) {
            if (this.p) {
                zadVar.b(this.o, this.q);
            }
            q(false);
        }
        Iterator<Api.AnyClientKey<?>> it = this.a.l.keySet().iterator();
        while (it.hasNext()) {
            this.a.f11830k.get(it.next()).disconnect();
        }
        this.a.t.b(this.f11812i.isEmpty() ? null : this.f11812i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        this.m = false;
        this.a.s.q = Collections.emptySet();
        for (Api.AnyClientKey<?> anyClientKey : this.f11813j) {
            if (!this.a.l.containsKey(anyClientKey)) {
                this.a.l.put(anyClientKey, new ConnectionResult(17, null));
            }
        }
    }

    private final void m() {
        ArrayList<Future<?>> arrayList = this.u;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Future<?> future = arrayList.get(i2);
            i2++;
            future.cancel(true);
        }
        this.u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<Scope> n() {
        if (this.r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.r.k());
        Map<Api<?>, ClientSettings.OptionalApiSettings> h2 = this.r.h();
        for (Api<?> api : h2.keySet()) {
            if (!this.a.l.containsKey(api.a())) {
                hashSet.addAll(h2.get(api).a);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if ((r5.Y() || r4.f11807d.c(r5.y()) != null) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(ConnectionResult connectionResult, Api<?> api, boolean z) {
        int b2 = api.c().b();
        boolean z2 = false;
        if (z) {
        }
        if (this.f11808e == null || b2 < this.f11809f) {
            z2 = true;
        }
        if (z2) {
            this.f11808e = connectionResult;
            this.f11809f = b2;
        }
        this.a.l.put(api.a(), connectionResult);
    }

    private final void q(boolean z) {
        zad zadVar = this.f11814k;
        if (zadVar != null) {
            if (zadVar.isConnected() && z) {
                this.f11814k.c();
            }
            this.f11814k.disconnect();
            if (this.r.m()) {
                this.f11814k = null;
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t(int i2) {
        if (this.f11810g == i2) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.a.s.G());
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(valueOf.length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        Log.w("GoogleApiClientConnecting", sb.toString());
        int i3 = this.f11811h;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i3);
        Log.w("GoogleApiClientConnecting", sb2.toString());
        String v = v(this.f11810g);
        String v2 = v(i2);
        StringBuilder sb3 = new StringBuilder(String.valueOf(v).length() + 70 + String.valueOf(v2).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(v);
        sb3.append(" but received callback for step ");
        sb3.append(v2);
        Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
        x(new ConnectionResult(8, null));
        return false;
    }

    private static String v(int i2) {
        return i2 != 0 ? i2 != 1 ? "UNKNOWN" : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w(ConnectionResult connectionResult) {
        return this.l && !connectionResult.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(ConnectionResult connectionResult) {
        m();
        q(!connectionResult.Y());
        this.a.m(connectionResult);
        this.a.t.a(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void H(int i2) {
        x(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void P(Bundle bundle) {
        if (t(1)) {
            if (bundle != null) {
                this.f11812i.putAll(bundle);
            }
            if (i()) {
                k();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void d() {
        this.a.l.clear();
        this.m = false;
        g gVar = null;
        this.f11808e = null;
        this.f11810g = 0;
        this.l = true;
        this.n = false;
        this.p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.s.keySet()) {
            Api.Client client = this.a.f11830k.get(api.a());
            z |= api.c().b() == 1;
            boolean booleanValue = this.s.get(api).booleanValue();
            if (client.requiresSignIn()) {
                this.m = true;
                if (booleanValue) {
                    this.f11813j.add(api.a());
                } else {
                    this.l = false;
                }
            }
            hashMap.put(client, new h(this, api, booleanValue));
        }
        if (z) {
            this.m = false;
        }
        if (this.m) {
            this.r.n(Integer.valueOf(System.identityHashCode(this.a.s)));
            o oVar = new o(this, gVar);
            Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.t;
            Context context = this.f11806c;
            Looper o = this.a.s.o();
            ClientSettings clientSettings = this.r;
            this.f11814k = abstractClientBuilder.c(context, o, clientSettings, clientSettings.l(), oVar, oVar);
        }
        this.f11811h = this.a.f11830k.size();
        this.u.add(zabh.a().submit(new i(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        m();
        q(true);
        this.a.m(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void k0(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (t(1)) {
            p(connectionResult, api, z);
            if (i()) {
                k();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l0(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T m0(T t) {
        this.a.s.f11822i.add(t);
        return t;
    }
}
