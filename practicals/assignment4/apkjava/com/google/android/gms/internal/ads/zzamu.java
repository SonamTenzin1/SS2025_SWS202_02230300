package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzamu extends zzfm implements zzams {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void G4(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzaiqVar);
        H.writeTypedList(list);
        k0(31, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void H4(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.c(H, zzatkVar);
        H.writeStringList(list);
        k0(23, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void M3(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        H.writeString(str2);
        zzfo.c(H, zzamvVar);
        zzfo.d(H, zzadyVar);
        H.writeStringList(list);
        k0(14, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang P1() throws RemoteException {
        zzang zzaniVar;
        Parcel P = P(27, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzaniVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (queryLocalInterface instanceof zzang) {
                zzaniVar = (zzang) queryLocalInterface;
            } else {
                zzaniVar = new zzani(readStrongBinder);
            }
        }
        P.recycle();
        return zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void Y2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        zzfo.c(H, zzamvVar);
        k0(3, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void a4(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(30, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzana b7() throws RemoteException {
        zzana zzancVar;
        Parcel P = P(15, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzancVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (queryLocalInterface instanceof zzana) {
                zzancVar = (zzana) queryLocalInterface;
            } else {
                zzancVar = new zzanc(readStrongBinder);
            }
        }
        P.recycle();
        return zzancVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void c6(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        H.writeString(str2);
        zzfo.c(H, zzamvVar);
        k0(7, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        k0(5, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzand e6() throws RemoteException {
        zzand zzanfVar;
        Parcel P = P(16, H());
        IBinder readStrongBinder = P.readStrongBinder();
        if (readStrongBinder == null) {
            zzanfVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (queryLocalInterface instanceof zzand) {
                zzanfVar = (zzand) queryLocalInterface;
            } else {
                zzanfVar = new zzanf(readStrongBinder);
            }
        }
        P.recycle();
        return zzanfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void f2(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        zzfo.c(H, zzamvVar);
        k0(28, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaar getVideoController() throws RemoteException {
        Parcel P = P(26, H());
        zzaar h7 = zzaas.h7(P.readStrongBinder());
        P.recycle();
        return h7;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void h4(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        zzfo.c(H, zzatkVar);
        H.writeString(str2);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() throws RemoteException {
        Parcel P = P(13, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void o6(zzxz zzxzVar, String str) throws RemoteException {
        Parcel H = H();
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        k0(11, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        k0(8, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        k0(9, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void s4(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzydVar);
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        H.writeString(str2);
        zzfo.c(H, zzamvVar);
        k0(6, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel H = H();
        zzfo.a(H, z);
        k0(25, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        k0(4, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() throws RemoteException {
        k0(12, H());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void w0(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        k0(21, H);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper x1() throws RemoteException {
        Parcel P = P(2, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean x3() throws RemoteException {
        Parcel P = P(22, H());
        boolean e2 = zzfo.e(P);
        P.recycle();
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void y2(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel H = H();
        zzfo.c(H, iObjectWrapper);
        zzfo.d(H, zzydVar);
        zzfo.d(H, zzxzVar);
        H.writeString(str);
        zzfo.c(H, zzamvVar);
        k0(1, H);
    }
}
