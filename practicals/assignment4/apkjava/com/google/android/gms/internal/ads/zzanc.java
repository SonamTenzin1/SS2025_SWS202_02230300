package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzanc extends zzfm implements zzana {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void A(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(16, H);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean C() throws RemoteException {
        Parcel P = P(13, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void C0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(12, H);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void D(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, iObjectWrapper2);
        zzfo.c(H, iObjectWrapper3);
        k0(22, H);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper I() throws RemoteException {
        Parcel P = P(20, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper K() throws RemoteException {
        Parcel P = P(18, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final boolean M() throws RemoteException {
        Parcel P = P(14, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void N(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(11, H);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaea f() throws RemoteException {
        Parcel P = P(19, H());
        zzaea h7 = zzaeb.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String g() throws RemoteException {
        Parcel P = P(2, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final Bundle getExtras() throws RemoteException {
        Parcel P = P(15, H());
        Bundle bundle = (Bundle) zzfo.b(P, Bundle.CREATOR);
        P.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String getStore() throws RemoteException {
        Parcel P = P(8, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaar getVideoController() throws RemoteException {
        Parcel P = P(17, H());
        zzaar h7 = zzaas.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String h() throws RemoteException {
        Parcel P = P(6, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String i() throws RemoteException {
        Parcel P = P(4, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final IObjectWrapper j() throws RemoteException {
        Parcel P = P(21, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final List k() throws RemoteException {
        Parcel P = P(3, H());
        ArrayList f2 = zzfo.f(P);
        P.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final zzaei n() throws RemoteException {
        Parcel P = P(5, H());
        zzaei h7 = zzaej.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final String o() throws RemoteException {
        Parcel P = P(9, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void recordImpression() throws RemoteException {
        k0(10, H());
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final double t() throws RemoteException {
        Parcel P = P(7, H());
        double readDouble = P.readDouble();
        P.recycle();
        return readDouble;
    }
}
