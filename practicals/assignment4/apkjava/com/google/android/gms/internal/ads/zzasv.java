package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzasv extends zzfm implements zzasu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzasu
    public final void y3(zzasr zzasrVar, String str, String str2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzasrVar);
        H.writeString(str);
        H.writeString(str2);
        k0(2, H);
    }
}
