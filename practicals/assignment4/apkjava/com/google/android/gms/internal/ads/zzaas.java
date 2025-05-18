package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public abstract class zzaas extends zzfn implements zzaar {
    public zzaas() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzaar h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzaar) {
            return (zzaar) queryLocalInterface;
        }
        return new zzaat(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzaau zzaawVar;
        switch (i2) {
            case 1:
                k5();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                o2(zzfo.e(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                boolean G1 = G1();
                parcel2.writeNoException();
                zzfo.a(parcel2, G1);
                return true;
            case 5:
                int F = F();
                parcel2.writeNoException();
                parcel2.writeInt(F);
                return true;
            case 6:
                float Q6 = Q6();
                parcel2.writeNoException();
                parcel2.writeFloat(Q6);
                return true;
            case 7:
                float S5 = S5();
                parcel2.writeNoException();
                parcel2.writeFloat(S5);
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaawVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzaau) {
                        zzaawVar = (zzaau) queryLocalInterface;
                    } else {
                        zzaawVar = new zzaaw(readStrongBinder);
                    }
                }
                R1(zzaawVar);
                parcel2.writeNoException();
                return true;
            case 9:
                float T = T();
                parcel2.writeNoException();
                parcel2.writeFloat(T);
                return true;
            case 10:
                boolean l5 = l5();
                parcel2.writeNoException();
                zzfo.a(parcel2, l5);
                return true;
            case 11:
                zzaau a5 = a5();
                parcel2.writeNoException();
                zzfo.c(parcel2, a5);
                return true;
            case 12:
                boolean d1 = d1();
                parcel2.writeNoException();
                zzfo.a(parcel2, d1);
                return true;
            default:
                return false;
        }
    }
}
