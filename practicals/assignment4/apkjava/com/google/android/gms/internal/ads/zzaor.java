package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaor extends zzfm implements zzaop {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaor(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void E4(zzang zzangVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzangVar);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void p(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        k0(2, H);
    }
}
