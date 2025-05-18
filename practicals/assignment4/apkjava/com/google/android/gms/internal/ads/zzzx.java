package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzzx extends zzfm implements zzzv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2) throws RemoteException {
        zzzk zzzmVar;
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzydVar);
        H.writeString(str);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        Parcel P = P(1, H);
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzmVar = (zzzk) queryLocalInterface;
            } else {
                zzzmVar = new zzzm(readStrongBinder);
            }
        }
        P.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zzb(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, zzamp zzampVar, int i2) throws RemoteException {
        zzzk zzzmVar;
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzydVar);
        H.writeString(str);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        Parcel P = P(2, H);
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzmVar = (zzzk) queryLocalInterface;
            } else {
                zzzmVar = new zzzm(readStrongBinder);
            }
        }
        P.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaem zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, iObjectWrapper2);
        Parcel P = P(5, H);
        zzaem h7 = zzaen.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaqg zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        Parcel P = P(8, H);
        zzaqg zzac = zzaqh.zzac(P.readStrongBinder());
        P.recycle();
        return zzac;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzf zza(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) throws RemoteException {
        zzzf zzzhVar;
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeString(str);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        Parcel P = P(3, H);
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzzhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzzf) {
                zzzhVar = (zzzf) queryLocalInterface;
            } else {
                zzzhVar = new zzzh(readStrongBinder);
            }
        }
        P.recycle();
        return zzzhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzatt zzb(IObjectWrapper iObjectWrapper, String str, zzamp zzampVar, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeString(str);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        Parcel P = P(12, H);
        zzatt h7 = zzatu.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzasw zza(IObjectWrapper iObjectWrapper, zzamp zzampVar, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzampVar);
        H.writeInt(i2);
        Parcel P = P(6, H);
        zzasw h7 = zzasx.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaab zza(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        zzaab zzaadVar;
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeInt(i2);
        Parcel P = P(9, H);
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzaadVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzaab) {
                zzaadVar = (zzaab) queryLocalInterface;
            } else {
                zzaadVar = new zzaad(readStrongBinder);
            }
        }
        P.recycle();
        return zzaadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, String str, int i2) throws RemoteException {
        zzzk zzzmVar;
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzydVar);
        H.writeString(str);
        H.writeInt(i2);
        Parcel P = P(10, H);
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzzmVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzmVar = (zzzk) queryLocalInterface;
            } else {
                zzzmVar = new zzzm(readStrongBinder);
            }
        }
        P.recycle();
        return zzzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzv
    public final zzaer zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, iObjectWrapper2);
        zzfo.c(H, iObjectWrapper3);
        Parcel P = P(11, H);
        zzaer h7 = zzaes.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }
}
