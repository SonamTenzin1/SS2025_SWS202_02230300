package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaet extends zzfm implements zzaer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void V(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void x0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void z5() throws RemoteException {
        k0(2, H());
    }
}
