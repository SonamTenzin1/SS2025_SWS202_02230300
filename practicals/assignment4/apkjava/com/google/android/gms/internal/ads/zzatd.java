package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzatd extends zzfm implements zzatb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void l1(zzasr zzasrVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzasrVar);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdClosed() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdFailedToLoad(int i2) throws RemoteException {
        Parcel H = H();
        H.writeInt(i2);
        k0(7, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        k0(6, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoAdOpened() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoCompleted() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatb
    public final void onRewardedVideoStarted() throws RemoteException {
        k0(3, H());
    }
}
