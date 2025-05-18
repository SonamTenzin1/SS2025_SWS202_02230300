package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzf extends zza implements zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzd
    public final Bundle J(Bundle bundle) throws RemoteException {
        Parcel H = H();
        zzb.c(H, bundle);
        Parcel P = P(1, H);
        Bundle bundle2 = (Bundle) zzb.a(P, Bundle.CREATOR);
        P.recycle();
        return bundle2;
    }
}
