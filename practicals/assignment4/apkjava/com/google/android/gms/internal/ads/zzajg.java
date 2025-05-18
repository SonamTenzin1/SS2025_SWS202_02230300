package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzajg extends zzfm implements zzaje {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void g6(zzaja zzajaVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzajaVar);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void h3(int i2) throws RemoteException {
        Parcel H = H();
        H.writeInt(i2);
        k0(2, H);
    }
}
