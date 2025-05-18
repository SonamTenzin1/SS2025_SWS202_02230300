package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzagi extends zzfm implements zzagg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void D6() throws RemoteException {
        k0(28, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean E(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        Parcel P = P(16, H);
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void G0(zzaag zzaagVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzaagVar);
        k0(26, H);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void L(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        k0(17, H);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void W() throws RemoteException {
        k0(22, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void d0(zzagd zzagdVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzagdVar);
        k0(21, H);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void destroy() throws RemoteException {
        k0(13, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void e0(zzaak zzaakVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzaakVar);
        k0(25, H);
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaea f() throws RemoteException {
        zzaea zzaecVar;
        Parcel P = P(14, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzaecVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (queryLocalInterface instanceof zzaea) {
                zzaecVar = (zzaea) queryLocalInterface;
            } else {
                zzaecVar = new zzaec(readStrongBinder);
            }
        }
        P.recycle();
        return zzaecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String g() throws RemoteException {
        Parcel P = P(2, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final Bundle getExtras() throws RemoteException {
        Parcel P = P(20, H());
        Bundle bundle = (Bundle) zzfo.b(P, Bundle.CREATOR);
        P.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel P = P(12, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String getStore() throws RemoteException {
        Parcel P = P(9, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaar getVideoController() throws RemoteException {
        Parcel P = P(11, H());
        zzaar h7 = zzaas.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String h() throws RemoteException {
        Parcel P = P(6, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String i() throws RemoteException {
        Parcel P = P(4, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper j() throws RemoteException {
        Parcel P = P(19, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void j0() throws RemoteException {
        k0(27, H());
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List k() throws RemoteException {
        Parcel P = P(3, H());
        ArrayList f2 = zzfo.f(P);
        P.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaei n() throws RemoteException {
        zzaei zzaekVar;
        Parcel P = P(5, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzaekVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaei) {
                zzaekVar = (zzaei) queryLocalInterface;
            } else {
                zzaekVar = new zzaek(readStrongBinder);
            }
        }
        P.recycle();
        return zzaekVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final zzaee n2() throws RemoteException {
        zzaee zzaegVar;
        Parcel P = P(29, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzaegVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            if (queryLocalInterface instanceof zzaee) {
                zzaegVar = (zzaee) queryLocalInterface;
            } else {
                zzaegVar = new zzaeg(readStrongBinder);
            }
        }
        P.recycle();
        return zzaegVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String o() throws RemoteException {
        Parcel P = P(10, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final IObjectWrapper r() throws RemoteException {
        Parcel P = P(18, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final double t() throws RemoteException {
        Parcel P = P(8, H());
        double readDouble = P.readDouble();
        P.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final boolean u2() throws RemoteException {
        Parcel P = P(24, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final List u4() throws RemoteException {
        Parcel P = P(23, H());
        ArrayList f2 = zzfo.f(P);
        P.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final String w() throws RemoteException {
        Parcel P = P(7, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void z(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        k0(15, H);
    }
}
