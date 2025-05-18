package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzatx extends zzfn implements zzatw {
    public zzatx() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzatq zzatsVar;
        if (i2 == 1) {
            S1();
        } else if (i2 == 2) {
            o1();
        } else if (i2 == 3) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzatsVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                if (queryLocalInterface instanceof zzatq) {
                    zzatsVar = (zzatq) queryLocalInterface;
                } else {
                    zzatsVar = new zzats(readStrongBinder);
                }
            }
            v0(zzatsVar);
        } else {
            if (i2 != 4) {
                return false;
            }
            p6(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}
