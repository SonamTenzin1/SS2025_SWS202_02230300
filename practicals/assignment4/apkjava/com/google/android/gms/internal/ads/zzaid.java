package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzaid implements Parcelable.Creator<zzaic> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaic createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        byte[] bArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        long j2 = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 1:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 3:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 4:
                    bArr = SafeParcelReader.g(parcel, C);
                    break;
                case 5:
                    strArr = SafeParcelReader.q(parcel, C);
                    break;
                case 6:
                    strArr2 = SafeParcelReader.q(parcel, C);
                    break;
                case 7:
                    z2 = SafeParcelReader.w(parcel, C);
                    break;
                case 8:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzaic(z, str, i2, bArr, strArr, strArr2, z2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaic[] newArray(int i2) {
        return new zzaic[i2];
    }
}
