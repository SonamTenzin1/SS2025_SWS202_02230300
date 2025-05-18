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
public final class zzafc extends zzfm implements zzafa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaei D0() throws RemoteException {
        zzaei zzaekVar;
        Parcel P = P(6, H());
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

    @Override // com.google.android.gms.internal.ads.zzafa
    public final boolean E(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        Parcel P = P(13, H);
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void L(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        k0(14, H);
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void destroy() throws RemoteException {
        k0(10, H());
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaea f() throws RemoteException {
        zzaea zzaecVar;
        Parcel P = P(15, H());
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

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String g() throws RemoteException {
        Parcel P = P(3, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final Bundle getExtras() throws RemoteException {
        Parcel P = P(9, H());
        Bundle bundle = (Bundle) zzfo.b(P, Bundle.CREATOR);
        P.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel P = P(17, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final zzaar getVideoController() throws RemoteException {
        Parcel P = P(11, H());
        zzaar h7 = zzaas.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String h() throws RemoteException {
        Parcel P = P(7, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String i() throws RemoteException {
        Parcel P = P(5, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final List k() throws RemoteException {
        Parcel P = P(4, H());
        ArrayList f2 = zzfo.f(P);
        P.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final IObjectWrapper r() throws RemoteException {
        Parcel P = P(2, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final String w() throws RemoteException {
        Parcel P = P(8, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafa
    public final void z(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, bundle);
        k0(12, H);
    }
}
