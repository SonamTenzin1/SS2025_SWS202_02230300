package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzad extends zza implements zzaf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean C1(com.google.android.gms.common.zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel k0 = k0();
        com.google.android.gms.internal.common.zzc.d(k0, zzsVar);
        com.google.android.gms.internal.common.zzc.f(k0, iObjectWrapper);
        Parcel H = H(5, k0);
        boolean g2 = com.google.android.gms.internal.common.zzc.g(H);
        H.recycle();
        return g2;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq c4(zzo zzoVar) throws RemoteException {
        Parcel k0 = k0();
        com.google.android.gms.internal.common.zzc.d(k0, zzoVar);
        Parcel H = H(8, k0);
        zzq zzqVar = (zzq) com.google.android.gms.internal.common.zzc.a(H, zzq.CREATOR);
        H.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean l() throws RemoteException {
        Parcel H = H(7, k0());
        boolean g2 = com.google.android.gms.internal.common.zzc.g(H);
        H.recycle();
        return g2;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final zzq q3(zzo zzoVar) throws RemoteException {
        Parcel k0 = k0();
        com.google.android.gms.internal.common.zzc.d(k0, zzoVar);
        Parcel H = H(6, k0);
        zzq zzqVar = (zzq) com.google.android.gms.internal.common.zzc.a(H, zzq.CREATOR);
        H.recycle();
        return zzqVar;
    }
}
