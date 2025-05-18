package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzx extends zza implements zzz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final int c() throws RemoteException {
        Parcel H = H(2, k0());
        int readInt = H.readInt();
        H.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final IObjectWrapper d() throws RemoteException {
        Parcel H = H(1, k0());
        IObjectWrapper P = IObjectWrapper.Stub.P(H.readStrongBinder());
        H.recycle();
        return P;
    }
}
