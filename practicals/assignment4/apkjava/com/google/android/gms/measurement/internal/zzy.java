package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzy implements Parcelable.Creator<zzv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        zzkj zzkjVar = null;
        String str3 = null;
        zzan zzanVar = null;
        zzan zzanVar2 = null;
        zzan zzanVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 2:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 4:
                    zzkjVar = (zzkj) SafeParcelReader.o(parcel, C, zzkj.CREATOR);
                    break;
                case 5:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                case 6:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 7:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 8:
                    zzanVar = (zzan) SafeParcelReader.o(parcel, C, zzan.CREATOR);
                    break;
                case 9:
                    j3 = SafeParcelReader.G(parcel, C);
                    break;
                case 10:
                    zzanVar2 = (zzan) SafeParcelReader.o(parcel, C, zzan.CREATOR);
                    break;
                case 11:
                    j4 = SafeParcelReader.G(parcel, C);
                    break;
                case 12:
                    zzanVar3 = (zzan) SafeParcelReader.o(parcel, C, zzan.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzv(str, str2, zzkjVar, j2, z, str3, zzanVar, j3, zzanVar2, j4, zzanVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv[] newArray(int i2) {
        return new zzv[i2];
    }
}
