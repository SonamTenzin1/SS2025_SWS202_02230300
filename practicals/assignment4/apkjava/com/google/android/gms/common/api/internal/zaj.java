package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class zaj extends zal {

    /* renamed from: k, reason: collision with root package name */
    private final SparseArray<a> f11863k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: f, reason: collision with root package name */
        public final int f11864f;

        /* renamed from: g, reason: collision with root package name */
        public final GoogleApiClient f11865g;

        /* renamed from: h, reason: collision with root package name */
        public final GoogleApiClient.OnConnectionFailedListener f11866h;

        public a(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f11864f = i2;
            this.f11865g = googleApiClient;
            this.f11866h = onConnectionFailedListener;
            googleApiClient.t(this);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void E0(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            zaj.this.m(connectionResult, this.f11864f);
        }
    }

    private zaj(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f11863k = new SparseArray<>();
        this.f11734f.a("AutoManageHelper", this);
    }

    public static zaj p(LifecycleActivity lifecycleActivity) {
        LifecycleFragment c2 = LifecycleCallback.c(lifecycleActivity);
        zaj zajVar = (zaj) c2.b("AutoManageHelper", zaj.class);
        return zajVar != null ? zajVar : new zaj(c2);
    }

    private final a s(int i2) {
        if (this.f11863k.size() <= i2) {
            return null;
        }
        SparseArray<a> sparseArray = this.f11863k;
        return sparseArray.get(sparseArray.keyAt(i2));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.f11863k.size(); i2++) {
            a s = s(i2);
            if (s != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(s.f11864f);
                printWriter.println(":");
                s.f11865g.i(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        super.i();
        boolean z = this.f11872g;
        String valueOf = String.valueOf(this.f11863k);
        StringBuilder sb = new StringBuilder(valueOf.length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f11873h.get() == null) {
            for (int i2 = 0; i2 < this.f11863k.size(); i2++) {
                a s = s(i2);
                if (s != null) {
                    s.f11865g.f();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        for (int i2 = 0; i2 < this.f11863k.size(); i2++) {
            a s = s(i2);
            if (s != null) {
                s.f11865g.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zal
    public final void l(ConnectionResult connectionResult, int i2) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = this.f11863k.get(i2);
        if (aVar != null) {
            q(i2);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = aVar.f11866h;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.E0(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void n() {
        for (int i2 = 0; i2 < this.f11863k.size(); i2++) {
            a s = s(i2);
            if (s != null) {
                s.f11865g.f();
            }
        }
    }

    public final void q(int i2) {
        a aVar = this.f11863k.get(i2);
        this.f11863k.remove(i2);
        if (aVar != null) {
            aVar.f11865g.u(aVar);
            aVar.f11865g.h();
        }
    }

    public final void r(int i2, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.l(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.f11863k.indexOfKey(i2) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i2);
        Preconditions.o(z, sb.toString());
        n0 n0Var = this.f11873h.get();
        boolean z2 = this.f11872g;
        String valueOf = String.valueOf(n0Var);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i2);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        this.f11863k.put(i2, new a(i2, googleApiClient, onConnectionFailedListener));
        if (this.f11872g && n0Var == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            Log.d("AutoManageHelper", sb3.toString());
            googleApiClient.f();
        }
    }
}
