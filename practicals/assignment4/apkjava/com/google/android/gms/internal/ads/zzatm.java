package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzatm extends zzfm implements zzatk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void F1(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeInt(i2);
        k0(2, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void G6(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(8, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void Y3(IObjectWrapper iObjectWrapper, zzato zzatoVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzatoVar);
        k0(7, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void Y5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(6, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void a2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void b5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(11, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void c3(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void e4(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void f1(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(4, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void q2(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeInt(i2);
        k0(9, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void w3(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        k0(12, H);
    }
}
