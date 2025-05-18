package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzaix implements Parcelable.Creator<zzaiw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiw createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, C);
            } else if (v != 2) {
                SafeParcelReader.K(parcel, C);
            } else {
                bundle = SafeParcelReader.f(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzaiw(str, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiw[] newArray(int i2) {
        return new zzaiw[i2];
    }
}
