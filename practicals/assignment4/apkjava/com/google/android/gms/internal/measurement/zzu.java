package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzu extends zza implements zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final int a() throws RemoteException {
        Parcel P = P(2, H());
        int readInt = P.readInt();
        P.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void q4(String str, String str2, Bundle bundle, long j2) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzb.c(H, bundle);
        H.writeLong(j2);
        k0(1, H);
    }
}
