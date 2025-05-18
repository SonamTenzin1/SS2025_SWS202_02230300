package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaol extends zzfm implements zzaoj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaol(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void c1(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void p(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        k0(2, H);
    }
}
