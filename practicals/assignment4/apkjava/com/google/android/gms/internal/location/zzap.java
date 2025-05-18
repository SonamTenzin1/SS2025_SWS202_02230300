package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzap extends zza implements zzao {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void A3(zzo zzoVar) throws RemoteException {
        Parcel H = H();
        zzc.b(H, zzoVar);
        P(75, H);
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void B0(boolean z) throws RemoteException {
        Parcel H = H();
        zzc.c(H, z);
        P(12, H);
    }

    @Override // com.google.android.gms.internal.location.zzao
    public final void B5(zzbf zzbfVar) throws RemoteException {
        Parcel H = H();
        zzc.b(H, zzbfVar);
        P(59, H);
    }
}
