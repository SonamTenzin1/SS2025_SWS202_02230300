package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t0 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13340f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(zzaii zzaiiVar, zzbbr zzbbrVar) {
        this.f13340f = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        this.f13340f.c(new RuntimeException("Connection failed."));
    }
}
