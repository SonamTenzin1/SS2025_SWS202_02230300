package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzo implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j7 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
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
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, C);
                    break;
                case 6:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                case 7:
                    j3 = SafeParcelReader.G(parcel, C);
                    break;
                case 8:
                    str5 = SafeParcelReader.p(parcel, C);
                    break;
                case 9:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 10:
                    z2 = SafeParcelReader.w(parcel, C);
                    break;
                case 11:
                    j7 = SafeParcelReader.G(parcel, C);
                    break;
                case 12:
                    str6 = SafeParcelReader.p(parcel, C);
                    break;
                case 13:
                    j4 = SafeParcelReader.G(parcel, C);
                    break;
                case 14:
                    j5 = SafeParcelReader.G(parcel, C);
                    break;
                case 15:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 16:
                    z3 = SafeParcelReader.w(parcel, C);
                    break;
                case 17:
                    z4 = SafeParcelReader.w(parcel, C);
                    break;
                case 18:
                    z5 = SafeParcelReader.w(parcel, C);
                    break;
                case 19:
                    str7 = SafeParcelReader.p(parcel, C);
                    break;
                case 20:
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
                case 21:
                    bool = SafeParcelReader.x(parcel, C);
                    break;
                case 22:
                    j6 = SafeParcelReader.G(parcel, C);
                    break;
                case 23:
                    arrayList = SafeParcelReader.r(parcel, C);
                    break;
                case 24:
                    str8 = SafeParcelReader.p(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzm(str, str2, str3, str4, j2, j3, str5, z, z2, j7, str6, j4, j5, i2, z3, z4, z5, str7, bool, j6, arrayList, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i2) {
        return new zzm[i2];
    }
}
