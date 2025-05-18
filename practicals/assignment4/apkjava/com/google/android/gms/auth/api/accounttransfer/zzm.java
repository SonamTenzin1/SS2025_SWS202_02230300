package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzm implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        ArrayList arrayList = null;
        zzo zzoVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 1) {
                i2 = SafeParcelReader.E(parcel, C);
                hashSet.add(1);
            } else if (v == 2) {
                arrayList = SafeParcelReader.t(parcel, C, zzr.CREATOR);
                hashSet.add(2);
            } else if (v == 3) {
                i3 = SafeParcelReader.E(parcel, C);
                hashSet.add(3);
            } else if (v != 4) {
                SafeParcelReader.K(parcel, C);
            } else {
                zzoVar = (zzo) SafeParcelReader.o(parcel, C, zzo.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == L) {
            return new zzl(hashSet, i2, arrayList, i3, zzoVar);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(L);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i2) {
        return new zzl[i2];
    }
}
