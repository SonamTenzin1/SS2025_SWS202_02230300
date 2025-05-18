package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzo extends zza implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void beginAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeLong(j2);
        k0(23, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzb.c(H, bundle);
        k0(9, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void endAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeLong(j2);
        k0(24, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void generateEventId(zzn zznVar) throws RemoteException {
        Parcel H = H();
        zzb.b(H, zznVar);
        k0(22, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCachedAppInstanceId(zzn zznVar) throws RemoteException {
        Parcel H = H();
        zzb.b(H, zznVar);
        k0(19, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getConditionalUserProperties(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzb.b(H, zznVar);
        k0(10, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCurrentScreenClass(zzn zznVar) throws RemoteException {
        Parcel H = H();
        zzb.b(H, zznVar);
        k0(17, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCurrentScreenName(zzn zznVar) throws RemoteException {
        Parcel H = H();
        zzb.b(H, zznVar);
        k0(16, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getGmpAppId(zzn zznVar) throws RemoteException {
        Parcel H = H();
        zzb.b(H, zznVar);
        k0(21, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getMaxUserProperties(String str, zzn zznVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        zzb.b(H, zznVar);
        k0(6, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getUserProperties(String str, String str2, boolean z, zzn zznVar) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzb.d(H, z);
        zzb.b(H, zznVar);
        k0(5, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void initialize(IObjectWrapper iObjectWrapper, zzv zzvVar, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        zzb.c(H, zzvVar);
        H.writeLong(j2);
        k0(1, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzb.c(H, bundle);
        zzb.d(H, z);
        zzb.d(H, z2);
        H.writeLong(j2);
        k0(2, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void logHealthData(int i2, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel H = H();
        H.writeInt(i2);
        H.writeString(str);
        zzb.b(H, iObjectWrapper);
        zzb.b(H, iObjectWrapper2);
        zzb.b(H, iObjectWrapper3);
        k0(33, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        zzb.c(H, bundle);
        H.writeLong(j2);
        k0(27, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        H.writeLong(j2);
        k0(28, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        H.writeLong(j2);
        k0(29, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        H.writeLong(j2);
        k0(30, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zznVar, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        zzb.b(H, zznVar);
        H.writeLong(j2);
        k0(31, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        H.writeLong(j2);
        k0(25, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        H.writeLong(j2);
        k0(26, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void performAction(Bundle bundle, zzn zznVar, long j2) throws RemoteException {
        Parcel H = H();
        zzb.c(H, bundle);
        zzb.b(H, zznVar);
        H.writeLong(j2);
        k0(32, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void registerOnMeasurementEventListener(zzs zzsVar) throws RemoteException {
        Parcel H = H();
        zzb.b(H, zzsVar);
        k0(35, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        Parcel H = H();
        zzb.c(H, bundle);
        H.writeLong(j2);
        k0(8, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j2) throws RemoteException {
        Parcel H = H();
        zzb.b(H, iObjectWrapper);
        H.writeString(str);
        H.writeString(str2);
        H.writeLong(j2);
        k0(15, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel H = H();
        zzb.d(H, z);
        k0(39, H);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j2) throws RemoteException {
        Parcel H = H();
        H.writeString(str);
        H.writeString(str2);
        zzb.b(H, iObjectWrapper);
        zzb.d(H, z);
        H.writeLong(j2);
        k0(4, H);
    }
}
