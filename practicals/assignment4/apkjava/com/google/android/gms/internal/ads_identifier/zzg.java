package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzg extends zza implements zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean c() throws RemoteException {
        Parcel P = P(6, H());
        boolean b2 = zzc.b(P);
        P.recycle();
        return b2;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final boolean g0(boolean z) throws RemoteException {
        Parcel H = H();
        zzc.a(H, true);
        Parcel P = P(2, H);
        boolean b2 = zzc.b(P);
        P.recycle();
        return b2;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final String getId() throws RemoteException {
        Parcel P = P(1, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }
}
