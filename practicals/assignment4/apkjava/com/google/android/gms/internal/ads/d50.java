package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d50 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbbr f12450f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzwb f12451g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d50(zzwb zzwbVar, zzbbr zzbbrVar) {
        this.f12451g = zzwbVar;
        this.f12450f = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        Object obj;
        obj = this.f12451g.f16871d;
        synchronized (obj) {
            this.f12450f.c(new RuntimeException("Connection failed."));
        }
    }
}
