package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaek extends zzfm implements zzaei {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final Uri I0() throws RemoteException {
        Parcel P = P(2, H());
        Uri uri = (Uri) zzfo.b(P, Uri.CREATOR);
        P.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final double T3() throws RemoteException {
        Parcel P = P(3, H());
        double readDouble = P.readDouble();
        P.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getHeight() throws RemoteException {
        Parcel P = P(5, H());
        int readInt = P.readInt();
        P.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final int getWidth() throws RemoteException {
        Parcel P = P(4, H());
        int readInt = P.readInt();
        P.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final IObjectWrapper t4() throws RemoteException {
        Parcel P = P(1, H());
        IObjectWrapper P2 = IObjectWrapper.Stub.P(P.readStrongBinder());
        P.recycle();
        return P2;
    }
}
