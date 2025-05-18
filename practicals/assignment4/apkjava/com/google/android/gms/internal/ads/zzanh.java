package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzanh extends zzfn implements zzang {
    public zzanh() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzang h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        if (queryLocalInterface instanceof zzang) {
            return (zzang) queryLocalInterface;
        }
        return new zzani(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 2:
                String g2 = g();
                parcel2.writeNoException();
                parcel2.writeString(g2);
                return true;
            case 3:
                List k2 = k();
                parcel2.writeNoException();
                parcel2.writeList(k2);
                return true;
            case 4:
                String i4 = i();
                parcel2.writeNoException();
                parcel2.writeString(i4);
                return true;
            case 5:
                zzaei n = n();
                parcel2.writeNoException();
                zzfo.c(parcel2, n);
                return true;
            case 6:
                String h2 = h();
                parcel2.writeNoException();
                parcel2.writeString(h2);
                return true;
            case 7:
                String w = w();
                parcel2.writeNoException();
                parcel2.writeString(w);
                return true;
            case 8:
                double t = t();
                parcel2.writeNoException();
                parcel2.writeDouble(t);
                return true;
            case 9:
                String store = getStore();
                parcel2.writeNoException();
                parcel2.writeString(store);
                return true;
            case 10:
                String o = o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                return true;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 12:
                zzaea f2 = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, f2);
                return true;
            case 13:
                IObjectWrapper K = K();
                parcel2.writeNoException();
                zzfo.c(parcel2, K);
                return true;
            case 14:
                IObjectWrapper I = I();
                parcel2.writeNoException();
                zzfo.c(parcel2, I);
                return true;
            case 15:
                IObjectWrapper j2 = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, j2);
                return true;
            case 16:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 17:
                boolean C = C();
                parcel2.writeNoException();
                zzfo.a(parcel2, C);
                return true;
            case 18:
                boolean M = M();
                parcel2.writeNoException();
                zzfo.a(parcel2, M);
                return true;
            case 19:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 20:
                N(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                D(IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                A(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                float X3 = X3();
                parcel2.writeNoException();
                parcel2.writeFloat(X3);
                return true;
            default:
                return false;
        }
    }
}
