package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzafb extends zzfn implements zzafa {
    public zzafb() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 2:
                IObjectWrapper r = r();
                parcel2.writeNoException();
                zzfo.c(parcel2, r);
                return true;
            case 3:
                String g2 = g();
                parcel2.writeNoException();
                parcel2.writeString(g2);
                return true;
            case 4:
                List k2 = k();
                parcel2.writeNoException();
                parcel2.writeList(k2);
                return true;
            case 5:
                String i4 = i();
                parcel2.writeNoException();
                parcel2.writeString(i4);
                return true;
            case 6:
                zzaei D0 = D0();
                parcel2.writeNoException();
                zzfo.c(parcel2, D0);
                return true;
            case 7:
                String h2 = h();
                parcel2.writeNoException();
                parcel2.writeString(h2);
                return true;
            case 8:
                String w = w();
                parcel2.writeNoException();
                parcel2.writeString(w);
                return true;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzfo.g(parcel2, extras);
                return true;
            case 10:
                destroy();
                parcel2.writeNoException();
                return true;
            case 11:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 12:
                z((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean E = E((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.a(parcel2, E);
                return true;
            case 14:
                L((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzaea f2 = f();
                parcel2.writeNoException();
                zzfo.c(parcel2, f2);
                return true;
            case 16:
                IObjectWrapper j2 = j();
                parcel2.writeNoException();
                zzfo.c(parcel2, j2);
                return true;
            case 17:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            default:
                return false;
        }
    }
}
