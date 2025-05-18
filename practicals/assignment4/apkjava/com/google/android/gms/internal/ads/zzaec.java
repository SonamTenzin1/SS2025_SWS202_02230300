package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzaec extends zzfm implements zzaea {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaec(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final List<zzaei> M0() throws RemoteException {
        Parcel P = P(3, H());
        ArrayList f2 = zzfo.f(P);
        P.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final String m1() throws RemoteException {
        Parcel P = P(2, H());
        String readString = P.readString();
        P.recycle();
        return readString;
    }
}
