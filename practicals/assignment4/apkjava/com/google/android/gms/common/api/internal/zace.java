package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zace extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private static Api.AbstractClientBuilder<? extends zad, SignInOptions> f11837f = com.google.android.gms.signin.zaa.f18293c;

    /* renamed from: g, reason: collision with root package name */
    private final Context f11838g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f11839h;

    /* renamed from: i, reason: collision with root package name */
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> f11840i;

    /* renamed from: j, reason: collision with root package name */
    private Set<Scope> f11841j;

    /* renamed from: k, reason: collision with root package name */
    private ClientSettings f11842k;
    private zad l;
    private zach m;

    public zace(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, f11837f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A5(com.google.android.gms.signin.internal.zaj zajVar) {
        ConnectionResult y = zajVar.y();
        if (y.e0()) {
            ResolveAccountResponse z = zajVar.z();
            ConnectionResult z2 = z.z();
            if (!z2.e0()) {
                String valueOf = String.valueOf(z2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.m.c(z2);
                this.l.disconnect();
                return;
            }
            this.m.b(z.y(), this.f11841j);
        } else {
            this.m.c(y);
        }
        this.l.disconnect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        this.m.c(connectionResult);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void H(int i2) {
        this.l.disconnect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void P(Bundle bundle) {
        this.l.d(this);
    }

    public final void S4(zach zachVar) {
        zad zadVar = this.l;
        if (zadVar != null) {
            zadVar.disconnect();
        }
        this.f11842k.n(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.f11840i;
        Context context = this.f11838g;
        Looper looper = this.f11839h.getLooper();
        ClientSettings clientSettings = this.f11842k;
        this.l = abstractClientBuilder.c(context, looper, clientSettings, clientSettings.l(), this, this);
        this.m = zachVar;
        Set<Scope> set = this.f11841j;
        if (set != null && !set.isEmpty()) {
            this.l.a();
        } else {
            this.f11839h.post(new f0(this));
        }
    }

    public final zad Y4() {
        return this.l;
    }

    public final void p5() {
        zad zadVar = this.l;
        if (zadVar != null) {
            zadVar.disconnect();
        }
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zad
    public final void w1(com.google.android.gms.signin.internal.zaj zajVar) {
        this.f11839h.post(new g0(this, zajVar));
    }

    public zace(Context context, Handler handler, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        this.f11838g = context;
        this.f11839h = handler;
        this.f11842k = (ClientSettings) Preconditions.l(clientSettings, "ClientSettings must not be null");
        this.f11841j = clientSettings.k();
        this.f11840i = abstractClientBuilder;
    }
}
