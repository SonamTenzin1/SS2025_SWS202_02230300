package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* loaded from: classes2.dex */
public final class zzzh extends zzfm implements zzzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void D5(String str, zzafr zzafrVar, zzafo zzafoVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        zzfo.c(H, zzafrVar);
        zzfo.c(H, zzafoVar);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void G3(zzafi zzafiVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzafiVar);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final zzzc J1() throws RemoteException {
        zzzc zzzeVar;
        Parcel P = P(1, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzzeVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzzc) {
                zzzeVar = (zzzc) queryLocalInterface;
            } else {
                zzzeVar = new zzze(readStrongBinder);
            }
        }
        P.recycle();
        return zzzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void X1(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, publisherAdViewOptions);
        k0(9, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void Z3(zzafx zzafxVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzafxVar);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void e2(zzyz zzyzVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzyzVar);
        k0(2, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void i1(zzafu zzafuVar, zzyd zzydVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzafuVar);
        zzfo.d(H, zzydVar);
        k0(8, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void k6(zzady zzadyVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzadyVar);
        k0(6, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void q5(zzzy zzzyVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzzyVar);
        k0(7, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final void y1(zzafl zzaflVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzaflVar);
        k0(4, H);
    }
}
