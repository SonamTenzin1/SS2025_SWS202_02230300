package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaox extends zzfm implements zzaov {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaox(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void K4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaoj zzaojVar, zzamv zzamvVar, zzyd zzydVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzfo.d(H, zzxzVar);
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzaojVar);
        zzfo.c(H, zzamvVar);
        zzfo.d(H, zzydVar);
        k0(13, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean L2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        Parcel P = P(17, H);
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj a6() throws RemoteException {
        Parcel P = P(2, H());
        zzapj zzapjVar = (zzapj) zzfo.b(P, zzapj.CREATOR);
        P.recycle();
        return zzapjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void g4(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaop zzaopVar, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzfo.d(H, zzxzVar);
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzaopVar);
        zzfo.c(H, zzamvVar);
        k0(18, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzaar getVideoController() throws RemoteException {
        Parcel P = P(5, H());
        zzaar h7 = zzaas.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void h5(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaos zzaosVar, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzfo.d(H, zzxzVar);
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzaosVar);
        zzfo.c(H, zzamvVar);
        k0(16, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj i5() throws RemoteException {
        Parcel P = P(3, H());
        zzapj zzapjVar = (zzapj) zzfo.b(P, zzapj.CREATOR);
        P.recycle();
        return zzapjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void u3(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzydVar, zzaoy zzaoyVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        H.writeString(str);
        zzfo.d(H, bundle);
        zzfo.d(H, bundle2);
        zzfo.d(H, zzydVar);
        zzfo.c(H, zzaoyVar);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean x2(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        Parcel P = P(15, H);
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void y6(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaom zzaomVar, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzfo.d(H, zzxzVar);
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzaomVar);
        zzfo.c(H, zzamvVar);
        k0(14, H);
    }
}
