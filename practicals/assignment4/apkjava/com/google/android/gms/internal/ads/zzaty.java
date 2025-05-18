package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaty extends zzfm implements zzatw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void S1() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void o1() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void p6(int i2) throws RemoteException {
        Parcel H = H();
        H.writeInt(i2);
        k0(4, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatw
    public final void v0(zzatq zzatqVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzatqVar);
        k0(3, H);
    }
}
