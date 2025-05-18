package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzaa implements Parcelable.Creator<LocationAvailability> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j2 = 0;
        zzaj[] zzajVarArr = null;
        int i2 = 1000;
        int i3 = 1;
        int i4 = 1;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 1) {
                i3 = SafeParcelReader.E(parcel, C);
            } else if (v == 2) {
                i4 = SafeParcelReader.E(parcel, C);
            } else if (v == 3) {
                j2 = SafeParcelReader.G(parcel, C);
            } else if (v == 4) {
                i2 = SafeParcelReader.E(parcel, C);
            } else if (v != 5) {
                SafeParcelReader.K(parcel, C);
            } else {
                zzajVarArr = (zzaj[]) SafeParcelReader.s(parcel, C, zzaj.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new LocationAvailability(i2, i3, i4, j2, zzajVarArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationAvailability[] newArray(int i2) {
        return new LocationAvailability[i2];
    }
}
