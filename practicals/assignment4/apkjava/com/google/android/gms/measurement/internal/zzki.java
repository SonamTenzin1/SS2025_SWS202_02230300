package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzki implements Parcelable.Creator<zzkj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkj createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        Long l = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 1:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 3:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                case 4:
                    l = SafeParcelReader.H(parcel, C);
                    break;
                case 5:
                    f2 = SafeParcelReader.B(parcel, C);
                    break;
                case 6:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 7:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 8:
                    d2 = SafeParcelReader.z(parcel, C);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzkj(i2, str, j2, l, f2, str2, str3, d2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkj[] newArray(int i2) {
        return new zzkj[i2];
    }
}
