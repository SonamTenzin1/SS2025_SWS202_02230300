package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaev extends zzfm implements zzaeu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaev(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final IBinder y5(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, iObjectWrapper2);
        zzfo.c(H, iObjectWrapper3);
        Parcel P = P(1, H);
        IBinder readStrongBinder = P.readStrongBinder();
        P.recycle();
        return readStrongBinder;
    }
}
