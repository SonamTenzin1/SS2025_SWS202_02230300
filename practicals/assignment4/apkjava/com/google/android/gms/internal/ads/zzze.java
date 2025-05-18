package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzze extends zzfm implements zzzc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void F5(zzxz zzxzVar, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzxzVar);
        H.writeInt(i2);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final String c0() throws RemoteException {
        Parcel P = P(4, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void j2(zzxz zzxzVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzxzVar);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean p0() throws RemoteException {
        Parcel P = P(3, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }
}
