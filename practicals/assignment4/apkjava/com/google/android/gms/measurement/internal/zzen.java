package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzen extends zza implements zzel {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzen(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzv> A2(String str, String str2, zzm zzmVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        Parcel P = P(16, H);
        ArrayList createTypedArrayList = P.createTypedArrayList(zzv.CREATOR);
        P.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkj> K1(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        H.writeString(str3);
        com.google.android.gms.internal.measurement.zzb.d(H, z);
        Parcel P = P(15, H);
        ArrayList createTypedArrayList = P.createTypedArrayList(zzkj.CREATOR);
        P.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final String P4(zzm zzmVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        Parcel P = P(11, H);
        String readString = P.readString();
        P.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void R6(zzv zzvVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzvVar);
        k0(13, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final byte[] T1(zzan zzanVar, String str) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzanVar);
        H.writeString(str);
        Parcel P = P(9, H);
        byte[] createByteArray = P.createByteArray();
        P.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void U3(zzm zzmVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        k0(6, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void Z5(zzan zzanVar, zzm zzmVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzanVar);
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        k0(1, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void b4(zzkj zzkjVar, zzm zzmVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzkjVar);
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        k0(2, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzkj> f3(String str, String str2, boolean z, zzm zzmVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.d(H, z);
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        Parcel P = P(14, H);
        ArrayList createTypedArrayList = P.createTypedArrayList(zzkj.CREATOR);
        P.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void h2(zzv zzvVar, zzm zzmVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzvVar);
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        k0(12, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void j3(long j2, String str, String str2, String str3) throws RemoteException {
        Parcel H = H();
        H.writeLong(j2);
        H.writeString(str);
        H.writeString(str2);
        H.writeString(str3);
        k0(10, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void j6(zzan zzanVar, String str, String str2) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzanVar);
        H.writeString(str);
        H.writeString(str2);
        k0(5, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void r2(zzm zzmVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        k0(18, H);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final List<zzv> r3(String str, String str2, String str3) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        H.writeString(str3);
        Parcel P = P(17, H);
        ArrayList createTypedArrayList = P.createTypedArrayList(zzv.CREATOR);
        P.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    public final void s6(zzm zzmVar) throws RemoteException {
        Parcel H = H();
        com.google.android.gms.internal.measurement.zzb.c(H, zzmVar);
        k0(4, H);
    }
}
