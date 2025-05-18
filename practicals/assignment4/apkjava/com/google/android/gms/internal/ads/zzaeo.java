package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaeo extends zzfm implements zzaem {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void V(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void X0(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeInt(i2);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void d5(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        zzfo.c(H, iObjectWrapper);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void destroy() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final IObjectWrapper n4(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        Parcel P = P(2, H);
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void x0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(6, H);
    }
}
