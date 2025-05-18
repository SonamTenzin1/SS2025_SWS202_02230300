package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbaj implements Parcelable.Creator<zzbai> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbai createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 2) {
                str = SafeParcelReader.p(parcel, C);
            } else if (v == 3) {
                i2 = SafeParcelReader.E(parcel, C);
            } else if (v == 4) {
                i3 = SafeParcelReader.E(parcel, C);
            } else if (v == 5) {
                z = SafeParcelReader.w(parcel, C);
            } else if (v != 6) {
                SafeParcelReader.K(parcel, C);
            } else {
                z2 = SafeParcelReader.w(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzbai(str, i2, i3, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbai[] newArray(int i2) {
        return new zzbai[i2];
    }
}
