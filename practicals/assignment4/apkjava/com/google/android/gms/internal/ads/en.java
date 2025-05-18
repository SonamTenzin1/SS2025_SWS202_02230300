package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class en extends zzaap {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzaao f12538f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzcqf f12539g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(zzcqf zzcqfVar, zzaao zzaaoVar) {
        this.f12539g = zzcqfVar;
        this.f12538f = zzaaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaao
    public final void onAdMetadataChanged() throws RemoteException {
        boolean z;
        zzaao zzaaoVar;
        z = this.f12539g.o;
        if (!z || (zzaaoVar = this.f12538f) == null) {
            return;
        }
        zzaaoVar.onAdMetadataChanged();
    }
}
