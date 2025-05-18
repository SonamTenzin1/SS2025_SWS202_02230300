package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzdaz implements Parcelable.Creator<zzday> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzday createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        int i2 = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 1) {
                i2 = SafeParcelReader.E(parcel, C);
            } else if (v != 2) {
                SafeParcelReader.K(parcel, C);
            } else {
                bArr = SafeParcelReader.g(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzday(i2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzday[] newArray(int i2) {
        return new zzday[i2];
    }
}
