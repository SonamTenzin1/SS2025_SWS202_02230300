package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzye implements Parcelable.Creator<zzyd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzyd createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        zzyd[] zzydVarArr = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 2:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 3:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 4:
                    i3 = SafeParcelReader.E(parcel, C);
                    break;
                case 5:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 6:
                    i4 = SafeParcelReader.E(parcel, C);
                    break;
                case 7:
                    i5 = SafeParcelReader.E(parcel, C);
                    break;
                case 8:
                    zzydVarArr = (zzyd[]) SafeParcelReader.s(parcel, C, zzyd.CREATOR);
                    break;
                case 9:
                    z2 = SafeParcelReader.w(parcel, C);
                    break;
                case 10:
                    z3 = SafeParcelReader.w(parcel, C);
                    break;
                case 11:
                    z4 = SafeParcelReader.w(parcel, C);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzyd(str, i2, i3, z, i4, i5, zzydVarArr, z2, z3, z4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzyd[] newArray(int i2) {
        return new zzyd[i2];
    }
}
