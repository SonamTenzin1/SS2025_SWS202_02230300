package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public abstract class zzzw extends zzfn implements zzzv {
    public zzzw() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                zzzk zza = zza(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (zzyd) zzfo.b(parcel, zzyd.CREATOR), parcel.readString(), zzamq.h7(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.c(parcel2, zza);
                return true;
            case 2:
                zzzk zzb = zzb(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (zzyd) zzfo.b(parcel, zzyd.CREATOR), parcel.readString(), zzamq.h7(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.c(parcel2, zzb);
                return true;
            case 3:
                zzzf zza2 = zza(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readString(), zzamq.h7(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.c(parcel2, zza2);
                return true;
            case 4:
                zzaab zzg = zzg(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.c(parcel2, zzg);
                return true;
            case 5:
                zzaem zzc = zzc(IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.c(parcel2, zzc);
                return true;
            case 6:
                zzasw zza3 = zza(IObjectWrapper.Stub.P(parcel.readStrongBinder()), zzamq.h7(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.c(parcel2, zza3);
                return true;
            case 7:
                zzaqq zzh = zzh(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.c(parcel2, zzh);
                return true;
            case 8:
                zzaqg zzf = zzf(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.c(parcel2, zzf);
                return true;
            case 9:
                zzaab zza4 = zza(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.c(parcel2, zza4);
                return true;
            case 10:
                zzzk zza5 = zza(IObjectWrapper.Stub.P(parcel.readStrongBinder()), (zzyd) zzfo.b(parcel, zzyd.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzfo.c(parcel2, zza5);
                return true;
            case 11:
                zzaer zza6 = zza(IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.c(parcel2, zza6);
                return true;
            case 12:
                zzatt zzb2 = zzb(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readString(), zzamq.h7(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.c(parcel2, zzb2);
                return true;
            default:
                return false;
        }
    }
}
