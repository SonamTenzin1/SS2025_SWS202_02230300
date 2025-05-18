package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzzo extends zzfm implements zzzn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzzn
    public final IBinder o5(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2, int i3) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzydVar);
        H.writeString(str);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        H.writeInt(i3);
        Parcel P = P(2, H);
        IBinder readStrongBinder = P.readStrongBinder();
        P.recycle();
        return readStrongBinder;
    }
}
