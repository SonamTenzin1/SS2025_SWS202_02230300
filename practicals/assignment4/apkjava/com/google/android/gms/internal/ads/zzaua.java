package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaua extends zzfm implements zzatz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaua(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final IBinder L6(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeString(str);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        Parcel P = P(1, H);
        IBinder readStrongBinder = P.readStrongBinder();
        P.recycle();
        return readStrongBinder;
    }
}
