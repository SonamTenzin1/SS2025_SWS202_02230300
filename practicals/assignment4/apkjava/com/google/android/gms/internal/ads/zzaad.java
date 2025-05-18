package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaad extends zzfm implements zzaab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void B2(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        zzfo.c(H, iObjectWrapper);
        k0(6, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final float C4() throws RemoteException {
        Parcel P = P(7, H());
        float readFloat = P.readFloat();
        P.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final String H3() throws RemoteException {
        Parcel P = P(9, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final boolean J3() throws RemoteException {
        Parcel P = P(8, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void N2(String str) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void O0(zzamp zzampVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzampVar);
        k0(11, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void a() throws RemoteException {
        k0(1, H());
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void c2(boolean z) throws RemoteException {
        Parcel H = H();
        zzfo.a(H, z);
        k0(4, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void t6(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeString(str);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void v5(float f2) throws RemoteException {
        Parcel H = H();
        H.writeFloat(f2);
        k0(2, H);
    }
}
