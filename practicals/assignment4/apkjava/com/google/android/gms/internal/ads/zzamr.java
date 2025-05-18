package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzamr extends zzfm implements zzamp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final boolean N6(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        Parcel P = P(2, H);
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzaov P2(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        Parcel P = P(3, H);
        zzaov h7 = zzaow.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzams l6(String str) throws RemoteException {
        zzams zzamuVar;
        Parcel H = H();
        H.writeString(str);
        Parcel P = P(1, H);
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzamuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (queryLocalInterface instanceof zzams) {
                zzamuVar = (zzams) queryLocalInterface;
            } else {
                zzamuVar = new zzamu(readStrongBinder);
            }
        }
        P.recycle();
        return zzamuVar;
    }
}
