package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzq extends zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int E0() throws RemoteException {
        Parcel H = H(6, k0());
        int readInt = H.readInt();
        H.recycle();
        return readInt;
    }

    public final int E3(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        zzc.c(k0, z);
        Parcel H = H(3, k0);
        int readInt = H.readInt();
        H.recycle();
        return readInt;
    }

    public final IObjectWrapper S4(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        k0.writeInt(i2);
        zzc.f(k0, iObjectWrapper2);
        Parcel H = H(8, k0);
        IObjectWrapper P = IObjectWrapper.Stub.P(H.readStrongBinder());
        H.recycle();
        return P;
    }

    public final int V3(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        zzc.c(k0, z);
        Parcel H = H(5, k0);
        int readInt = H.readInt();
        H.recycle();
        return readInt;
    }

    public final IObjectWrapper Y4(IObjectWrapper iObjectWrapper, String str, int i2) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        k0.writeInt(i2);
        Parcel H = H(4, k0);
        IObjectWrapper P = IObjectWrapper.Stub.P(H.readStrongBinder());
        H.recycle();
        return P;
    }

    public final IObjectWrapper p5(IObjectWrapper iObjectWrapper, String str, boolean z, long j2) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        zzc.c(k0, z);
        k0.writeLong(j2);
        Parcel H = H(7, k0);
        IObjectWrapper P = IObjectWrapper.Stub.P(H.readStrongBinder());
        H.recycle();
        return P;
    }

    public final IObjectWrapper y4(IObjectWrapper iObjectWrapper, String str, int i2) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        k0.writeInt(i2);
        Parcel H = H(2, k0);
        IObjectWrapper P = IObjectWrapper.Stub.P(H.readStrongBinder());
        H.recycle();
        return P;
    }
}
