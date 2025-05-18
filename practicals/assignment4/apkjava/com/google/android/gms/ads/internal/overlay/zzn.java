package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzbai;

/* loaded from: classes2.dex */
public final class zzn implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        zzc zzcVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        zzbai zzbaiVar = null;
        String str4 = null;
        com.google.android.gms.ads.internal.zzh zzhVar = null;
        IBinder iBinder6 = null;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 2:
                    zzcVar = (zzc) SafeParcelReader.o(parcel, C, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.D(parcel, C);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.D(parcel, C);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.D(parcel, C);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.D(parcel, C);
                    break;
                case 7:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 8:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 9:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.D(parcel, C);
                    break;
                case 11:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 12:
                    i3 = SafeParcelReader.E(parcel, C);
                    break;
                case 13:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 14:
                    zzbaiVar = (zzbai) SafeParcelReader.o(parcel, C, zzbai.CREATOR);
                    break;
                case 15:
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
                case 16:
                    str4 = SafeParcelReader.p(parcel, C);
                    break;
                case 17:
                    zzhVar = (com.google.android.gms.ads.internal.zzh) SafeParcelReader.o(parcel, C, com.google.android.gms.ads.internal.zzh.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.D(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new AdOverlayInfoParcel(zzcVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, zzbaiVar, str4, zzhVar, iBinder6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i2) {
        return new AdOverlayInfoParcel[i2];
    }
}
