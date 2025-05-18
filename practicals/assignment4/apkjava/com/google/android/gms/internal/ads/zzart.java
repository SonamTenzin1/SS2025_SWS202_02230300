package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzart extends zzfm implements zzarr {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzart(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void K5(zzaym zzaymVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzaymVar);
        k0(2, H);
    }

    @Override // com.google.android.gms.internal.ads.zzarr
    public final void V0(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, parcelFileDescriptor);
        k0(1, H);
    }
}
