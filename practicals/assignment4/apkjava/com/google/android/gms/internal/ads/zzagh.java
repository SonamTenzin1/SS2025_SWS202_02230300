package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzagh extends zzfn implements zzagg {
    public zzagh() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzagd zzagfVar;
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
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 13:
                destroy();
                parcel2.writeNoException();
                return true;
            case 14:
                zzaea f2 = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, f2);
                return true;
            case 15:
                z((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                boolean E = E((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.a(parcel2, E);
                return true;
            case 17:
                L((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper r = r();
                parcel2.writeNoException();
                zzfo.c(parcel2, r);
                return true;
            case 19:
                IObjectWrapper j2 = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, j2);
                return true;
            case 20:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 21:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzagfVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    if (queryLocalInterface instanceof zzagd) {
                        zzagfVar = (zzagd) queryLocalInterface;
                    } else {
                        zzagfVar = new zzagf(readStrongBinder);
                    }
                }
                d0(zzagfVar);
                parcel2.writeNoException();
                return true;
            case 22:
                W();
                parcel2.writeNoException();
                return true;
            case 23:
                List u4 = u4();
                parcel2.writeNoException();
                parcel2.writeList(u4);
                return true;
            case 24:
                boolean u2 = u2();
                parcel2.writeNoException();
                zzfo.a(parcel2, u2);
                return true;
            case 25:
                e0(zzaal.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                G0(zzaah.h7(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                j0();
                parcel2.writeNoException();
                return true;
            case 28:
                D6();
                parcel2.writeNoException();
                return true;
            case 29:
                zzaee n2 = n2();
                parcel2.writeNoException();
                zzfo.c(parcel2, n2);
                return true;
            default:
                return false;
        }
    }
}
