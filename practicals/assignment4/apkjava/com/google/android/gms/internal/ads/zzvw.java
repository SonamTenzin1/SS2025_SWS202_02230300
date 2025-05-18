package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzvw implements Parcelable.Creator<zzvv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvv createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 2:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 3:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                case 4:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 5:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 6:
                    str4 = SafeParcelReader.p(parcel, C);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, C);
                    break;
                case 8:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 9:
                    j3 = SafeParcelReader.G(parcel, C);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzvv(str, j2, str2, str3, str4, bundle, z, j3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvv[] newArray(int i2) {
        return new zzvv[i2];
    }
}
