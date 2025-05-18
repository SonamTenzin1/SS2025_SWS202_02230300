package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaat extends zzfm implements zzaar {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaat(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int F() throws RemoteException {
        Parcel P = P(5, H());
        int readInt = P.readInt();
        P.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean G1() throws RemoteException {
        Parcel P = P(4, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void R1(zzaau zzaauVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzaauVar);
        k0(8, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float T() throws RemoteException {
        Parcel P = P(9, H());
        float readFloat = P.readFloat();
        P.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau a5() throws RemoteException {
        zzaau zzaawVar;
        Parcel P = P(11, H());
        IBinder readStrongBinder = P.readStrongBinder();
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
        P.recycle();
        return zzaawVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean d1() throws RemoteException {
        Parcel P = P(12, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void k5() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean l5() throws RemoteException {
        Parcel P = P(10, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void o2(boolean z) throws RemoteException {
        Parcel H = H();
        zzfo.a(H, z);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() throws RemoteException {
        k0(2, H());
    }
}
