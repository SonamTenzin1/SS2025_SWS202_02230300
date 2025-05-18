package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class sq implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private final zzdba f13330f;

    /* renamed from: g, reason: collision with root package name */
    private final zzdau f13331g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f13332h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private boolean f13333i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13334j = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sq(Context context, Looper looper, zzdau zzdauVar) {
        this.f13331g = zzdauVar;
        this.f13330f = new zzdba(context, looper, this, this);
    }

    private final void a() {
        synchronized (this.f13332h) {
            if (this.f13330f.isConnected() || this.f13330f.isConnecting()) {
                this.f13330f.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        synchronized (this.f13332h) {
            if (this.f13334j) {
                return;
            }
            this.f13334j = true;
            try {
                this.f13330f.e().s3(new zzday(this.f13331g.g()));
                a();
            } catch (Exception unused) {
                a();
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        synchronized (this.f13332h) {
            if (!this.f13333i) {
                this.f13333i = true;
                this.f13330f.checkAvailabilityAndConnect();
            }
        }
    }
}
