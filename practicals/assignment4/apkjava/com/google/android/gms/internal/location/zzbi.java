package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbi implements Parcelable.Creator<zzbh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbh createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        String str = null;
        long j2 = 0;
        int i2 = 0;
        short s = 0;
        float f2 = 0.0f;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 1:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 2:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                case 3:
                    s = SafeParcelReader.I(parcel, C);
                    break;
                case 4:
                    d2 = SafeParcelReader.y(parcel, C);
                    break;
                case 5:
                    d3 = SafeParcelReader.y(parcel, C);
                    break;
                case 6:
                    f2 = SafeParcelReader.A(parcel, C);
                    break;
                case 7:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 8:
                    i3 = SafeParcelReader.E(parcel, C);
                    break;
                case 9:
                    i4 = SafeParcelReader.E(parcel, C);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzbh(str, i2, s, d2, d3, f2, j2, i3, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbh[] newArray(int i2) {
        return new zzbh[i2];
    }
}
