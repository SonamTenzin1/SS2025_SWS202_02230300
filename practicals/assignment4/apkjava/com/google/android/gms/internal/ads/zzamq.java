package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzamq extends zzfn implements zzamp {
    public zzamq() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzamp h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzamp) {
            return (zzamp) queryLocalInterface;
        }
        return new zzamr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzams l6 = l6(parcel.readString());
            parcel2.writeNoException();
            zzfo.c(parcel2, l6);
        } else if (i2 == 2) {
            boolean N6 = N6(parcel.readString());
            parcel2.writeNoException();
            zzfo.a(parcel2, N6);
        } else {
            if (i2 != 3) {
                return false;
            }
            zzaov P2 = P2(parcel.readString());
            parcel2.writeNoException();
            zzfo.c(parcel2, P2);
        }
        return true;
    }
}
