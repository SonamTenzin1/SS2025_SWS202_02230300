package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzzm extends zzfm implements zzzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean B() throws RemoteException {
        Parcel P = P(3, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void C2(zzyd zzydVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzydVar);
        k0(13, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd C5() throws RemoteException {
        Parcel P = P(12, H());
        zzyd zzydVar = (zzyd) zzfo.b(P, zzyd.CREATOR);
        P.recycle();
        return zzydVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void H6(zzado zzadoVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzadoVar);
        k0(19, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs I4() throws RemoteException {
        zzzs zzzuVar;
        Parcel P = P(32, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzzuVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (queryLocalInterface instanceof zzzs) {
                zzzuVar = (zzzs) queryLocalInterface;
            } else {
                zzzuVar = new zzzu(readStrongBinder);
            }
        }
        P.recycle();
        return zzzuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean J4(zzxz zzxzVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzxzVar);
        Parcel P = P(4, H);
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void L0(zzyz zzyzVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzyzVar);
        k0(7, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void P5(zzzs zzzsVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzzsVar);
        k0(8, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper S0() throws RemoteException {
        Parcel P = P(1, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void W6(zzacd zzacdVar) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzacdVar);
        k0(29, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String c0() throws RemoteException {
        Parcel P = P(35, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void destroy() throws RemoteException {
        k0(2, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final String f6() throws RemoteException {
        Parcel P = P(31, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel P = P(37, H());
        Bundle bundle = (Bundle) zzfo.b(P, Bundle.CREATOR);
        P.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() throws RemoteException {
        zzaar zzaatVar;
        Parcel P = P(26, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzaatVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (queryLocalInterface instanceof zzaar) {
                zzaatVar = (zzaar) queryLocalInterface;
            } else {
                zzaatVar = new zzaat(readStrongBinder);
            }
        }
        P.recycle();
        return zzaatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void h0(zzatb zzatbVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzatbVar);
        k0(24, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final boolean p0() throws RemoteException {
        Parcel P = P(23, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void pause() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void resume() throws RemoteException {
        k0(6, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel H = H();
        zzfo.a(H, z);
        k0(34, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void showInterstitial() throws RemoteException {
        k0(9, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void t1(boolean z) throws RemoteException {
        Parcel H = H();
        zzfo.a(H, z);
        k0(22, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void v4(zzzy zzzyVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzzyVar);
        k0(21, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void w4(zzyw zzywVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzywVar);
        k0(20, H);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz x5() throws RemoteException {
        zzyz zzzbVar;
        Parcel P = P(33, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzzbVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (queryLocalInterface instanceof zzyz) {
                zzzbVar = (zzyz) queryLocalInterface;
            } else {
                zzzbVar = new zzzb(readStrongBinder);
            }
        }
        P.recycle();
        return zzzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void x6() throws RemoteException {
        k0(11, H());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void z0(zzzp zzzpVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, zzzpVar);
        k0(36, H);
    }
}
