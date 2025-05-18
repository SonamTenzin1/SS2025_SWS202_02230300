package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class tl extends zzaot {

    /* renamed from: f, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f13356f;

    private tl(zzcnd zzcndVar, zzcjy zzcjyVar) {
        this.f13356f = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void K0() throws RemoteException {
        this.f13356f.f15314c.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void p(String str) throws RemoteException {
        this.f13356f.f15314c.onAdFailedToLoad(0);
    }
}
