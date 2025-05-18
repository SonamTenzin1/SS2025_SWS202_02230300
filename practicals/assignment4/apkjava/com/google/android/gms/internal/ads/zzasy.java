package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzasy extends zzfm implements zzasw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void M6(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(9, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void T5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void d2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(11, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel P = P(15, H());
        Bundle bundle = (Bundle) zzfo.b(P, Bundle.CREATOR);
        P.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel P = P(12, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void h0(zzatb zzatbVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzatbVar);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void i4(zzath zzathVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzathVar);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final boolean isLoaded() throws RemoteException {
        Parcel P = P(5, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setCustomData(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        k0(19, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel H = H();
        zzfo.a(H, z);
        k0(34, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void setUserId(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        k0(13, H);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void show() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void z0(zzzp zzzpVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzzpVar);
        k0(14, H);
    }
}
