package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class zzbjg extends zzfn implements zzbjf {
    public zzbjg() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                e1((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                Bundle s2 = s2((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzfo.g(parcel2, s2);
                return true;
            case 3:
                m0(parcel.readString(), parcel.readString(), (Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                N5(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                Map d4 = d4(parcel.readString(), parcel.readString(), zzfo.e(parcel));
                parcel2.writeNoException();
                parcel2.writeMap(d4);
                return true;
            case 6:
                int I3 = I3(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(I3);
                return true;
            case 7:
                Q4((Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzfo.b(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                List L4 = L4(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeList(L4);
                return true;
            case 10:
                String g2 = g2();
                parcel2.writeNoException();
                parcel2.writeString(g2);
                return true;
            case 11:
                String o4 = o4();
                parcel2.writeNoException();
                parcel2.writeString(o4);
                return true;
            case 12:
                long E2 = E2();
                parcel2.writeNoException();
                parcel2.writeLong(E2);
                return true;
            case 13:
                O5(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 14:
                V6(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 15:
                z4(IObjectWrapper.Stub.P(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
                String J2 = J2();
                parcel2.writeNoException();
                parcel2.writeString(J2);
                return true;
            case 17:
                String O4 = O4();
                parcel2.writeNoException();
                parcel2.writeString(O4);
                return true;
            case 18:
                String l4 = l4();
                parcel2.writeNoException();
                parcel2.writeString(l4);
                return true;
            default:
                return false;
        }
    }
}
