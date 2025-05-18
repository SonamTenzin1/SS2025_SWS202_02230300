package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class in extends zzzq {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzzp f12778f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzcqj f12779g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public in(zzcqj zzcqjVar, zzzp zzzpVar) {
        this.f12779g = zzcqjVar;
        this.f12778f = zzzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void onAdMetadataChanged() throws RemoteException {
        boolean z;
        zzzp zzzpVar;
        z = this.f12779g.n;
        if (!z || (zzzpVar = this.f12778f) == null) {
            return;
        }
        zzzpVar.onAdMetadataChanged();
    }
}
