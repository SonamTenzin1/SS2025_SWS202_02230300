package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaro extends zzfm implements zzarm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaro(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void I5(zzarx zzarxVar, zzarr zzarrVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzarxVar);
        zzfo.c(H, zzarrVar);
        k0(4, H);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void X6(zzarx zzarxVar, zzarr zzarrVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzarxVar);
        zzfo.c(H, zzarrVar);
        k0(5, H);
    }
}
