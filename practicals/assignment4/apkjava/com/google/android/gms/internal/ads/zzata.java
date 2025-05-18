package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzata extends zzfm implements zzasz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzasz
    public final IBinder V5(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        Parcel P = P(1, H);
        IBinder readStrongBinder = P.readStrongBinder();
        P.recycle();
        return readStrongBinder;
    }
}
