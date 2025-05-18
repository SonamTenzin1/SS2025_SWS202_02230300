package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzanf extends zzfm implements zzand {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void A(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(14, H);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean C() throws RemoteException {
        Parcel P = P(11, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void C0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, iObjectWrapper2);
        zzfo.c(H, iObjectWrapper3);
        k0(22, H);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaei D0() throws RemoteException {
        Parcel P = P(5, H());
        zzaei h7 = zzaej.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper I() throws RemoteException {
        Parcel P = P(20, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper K() throws RemoteException {
        Parcel P = P(15, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final boolean M() throws RemoteException {
        Parcel P = P(12, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void N(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(9, H);
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaea f() throws RemoteException {
        Parcel P = P(19, H());
        zzaea h7 = zzaeb.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String g() throws RemoteException {
        Parcel P = P(2, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final Bundle getExtras() throws RemoteException {
        Parcel P = P(13, H());
        Bundle bundle = (Bundle) zzfo.b(P, Bundle.CREATOR);
        P.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final zzaar getVideoController() throws RemoteException {
        Parcel P = P(16, H());
        zzaar h7 = zzaas.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String h() throws RemoteException {
        Parcel P = P(6, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String i() throws RemoteException {
        Parcel P = P(4, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final IObjectWrapper j() throws RemoteException {
        Parcel P = P(21, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final List k() throws RemoteException {
        Parcel P = P(3, H());
        ArrayList f2 = zzfo.f(P);
        P.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final void recordImpression() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzand
    public final String w() throws RemoteException {
        Parcel P = P(7, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }
}
