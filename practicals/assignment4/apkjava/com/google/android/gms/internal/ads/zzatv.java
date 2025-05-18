package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzatv extends zzfm implements zzatt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void G5(zzaao zzaaoVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzaaoVar);
        k0(8, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void L5(zzatw zzatwVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzatwVar);
        k0(2, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final zzatq O6() throws RemoteException {
        zzatq zzatsVar;
        Parcel P = P(11, H());
        IBinder readStrongBinder = P.readStrongBinder();
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
        P.recycle();
        return zzatsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void W1(zzxz zzxzVar, zzaub zzaubVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzxzVar);
        zzfo.c(H, zzaubVar);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void e7(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.a(H, z);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void f5(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel P = P(9, H());
        Bundle bundle = (Bundle) zzfo.b(P, Bundle.CREATOR);
        P.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel P = P(4, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final boolean isLoaded() throws RemoteException {
        Parcel P = P(3, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzatt
    public final void m2(zzaum zzaumVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzaumVar);
        k0(7, H);
    }
}
