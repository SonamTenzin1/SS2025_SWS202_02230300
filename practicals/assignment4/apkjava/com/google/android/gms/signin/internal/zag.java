package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* loaded from: classes2.dex */
public final class zag extends com.google.android.gms.internal.base.zaa implements zaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void B1(int i2) throws RemoteException {
        Parcel H = H();
        H.writeInt(i2);
        k0(7, H);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void V2(IAccountAccessor iAccountAccessor, int i2, boolean z) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.base.zac.c(H, iAccountAccessor);
        H.writeInt(i2);
        com.google.android.gms.internal.base.zac.a(H, z);
        k0(9, H);
    }

    @Override // com.google.android.gms.signin.internal.zaf
    public final void n3(zah zahVar, zad zadVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.base.zac.d(H, zahVar);
        com.google.android.gms.internal.base.zac.c(H, zadVar);
        k0(12, H);
    }
}
