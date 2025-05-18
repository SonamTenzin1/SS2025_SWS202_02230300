package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzaou extends zzfm implements zzaos {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaou(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void K0() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaos
    public final void p(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        k0(3, H);
    }
}
