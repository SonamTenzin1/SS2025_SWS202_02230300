package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzasa implements Parcelable.Creator<zzarz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzarz createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(C) != 2) {
                SafeParcelReader.K(parcel, C);
            } else {
                str = SafeParcelReader.p(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzarz(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzarz[] newArray(int i2) {
        return new zzarz[i2];
    }
}
