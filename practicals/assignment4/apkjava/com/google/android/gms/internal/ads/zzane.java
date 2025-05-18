package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzane extends zzfn implements zzand {
    public zzane() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
                zzaei D0 = D0();
                parcel2.writeNoException();
                zzfo.c(parcel2, D0);
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
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 9:
                N(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                C0(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                boolean C = C();
                parcel2.writeNoException();
                zzfo.a(parcel2, C);
                return true;
            case 12:
                boolean M = M();
                parcel2.writeNoException();
                zzfo.a(parcel2, M);
                return true;
            case 13:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 14:
                A(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper K = K();
                parcel2.writeNoException();
                zzfo.c(parcel2, K);
                return true;
            case 16:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 17:
            case 18:
            default:
                return false;
            case 19:
                zzaea f2 = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, f2);
                return true;
            case 20:
                IObjectWrapper I = I();
                parcel2.writeNoException();
                zzfo.c(parcel2, I);
                return true;
            case 21:
                IObjectWrapper j2 = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, j2);
                return true;
            case 22:
                D(IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
