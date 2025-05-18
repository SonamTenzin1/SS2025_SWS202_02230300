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
public final class zzr extends zza implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final IObjectWrapper E0(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        k0.writeInt(i2);
        zzc.f(k0, iObjectWrapper2);
        Parcel H = H(2, k0);
        IObjectWrapper P = IObjectWrapper.Stub.P(H.readStrongBinder());
        H.recycle();
        return P;
    }

    public final IObjectWrapper E3(IObjectWrapper iObjectWrapper, String str, int i2, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel k0 = k0();
        zzc.f(k0, iObjectWrapper);
        k0.writeString(str);
        k0.writeInt(i2);
        zzc.f(k0, iObjectWrapper2);
        Parcel H = H(3, k0);
        IObjectWrapper P = IObjectWrapper.Stub.P(H.readStrongBinder());
        H.recycle();
        return P;
    }
}
