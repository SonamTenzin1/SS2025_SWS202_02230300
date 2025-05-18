package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzdbg extends zzfm implements zzdbf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdbg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final zzdbd B4(zzdbb zzdbbVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzdbbVar);
        Parcel P = P(1, H);
        zzdbd zzdbdVar = (zzdbd) zzfo.b(P, zzdbd.CREATOR);
        P.recycle();
        return zzdbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbf
    public final void s3(zzday zzdayVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzdayVar);
        k0(2, H);
    }
}
