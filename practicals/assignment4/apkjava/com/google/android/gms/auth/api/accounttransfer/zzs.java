package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzs implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        zzt zztVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 1) {
                i2 = SafeParcelReader.E(parcel, C);
                hashSet.add(1);
            } else if (v == 2) {
                zztVar = (zzt) SafeParcelReader.o(parcel, C, zzt.CREATOR);
                hashSet.add(2);
            } else if (v == 3) {
                str = SafeParcelReader.p(parcel, C);
                hashSet.add(3);
            } else if (v == 4) {
                str2 = SafeParcelReader.p(parcel, C);
                hashSet.add(4);
            } else if (v != 5) {
                SafeParcelReader.K(parcel, C);
            } else {
                str3 = SafeParcelReader.p(parcel, C);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == L) {
            return new zzr(hashSet, i2, zztVar, str, str2, str3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(L);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i2) {
        return new zzr[i2];
    }
}
