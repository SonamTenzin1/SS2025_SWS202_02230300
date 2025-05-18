package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzacb implements Parcelable.Creator<zzaca> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaca createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(C) != 15) {
                SafeParcelReader.K(parcel, C);
            } else {
                str = SafeParcelReader.p(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzaca(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaca[] newArray(int i2) {
        return new zzaca[i2];
    }
}
