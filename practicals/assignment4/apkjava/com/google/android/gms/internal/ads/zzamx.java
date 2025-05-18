package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzamx extends zzfm implements zzamv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void F0(zzafe zzafeVar, String str) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzafeVar);
        H.writeString(str);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void I6() throws RemoteException {
        k0(18, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void R(int i2) throws RemoteException {
        Parcel H = H();
        H.writeInt(i2);
        k0(17, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void b1() throws RemoteException {
        k0(13, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void k1(zzamy zzamyVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzamyVar);
        k0(7, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void m3(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        k0(12, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void n0() throws RemoteException {
        k0(11, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClicked() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdClosed() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdFailedToLoad(int i2) throws RemoteException {
        Parcel H = H();
        H.writeInt(i2);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdImpression() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLeftApplication() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdLoaded() throws RemoteException {
        k0(6, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAdOpened() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        k0(9, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPause() throws RemoteException {
        k0(15, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void onVideoPlay() throws RemoteException {
        k0(20, H());
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void t5(zzato zzatoVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzatoVar);
        k0(14, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void v0(zzatq zzatqVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzatqVar);
        k0(16, H);
    }

    @Override // com.google.android.gms.internal.ads.zzamv
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        k0(19, H);
    }
}
