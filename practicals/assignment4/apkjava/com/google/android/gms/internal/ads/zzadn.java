package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzadn extends zzfm implements zzadl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzadn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String M5() throws RemoteException {
        Parcel P = P(1, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String getContent() throws RemoteException {
        Parcel P = P(2, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordClick() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordImpression() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void z1(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(3, H);
    }
}
