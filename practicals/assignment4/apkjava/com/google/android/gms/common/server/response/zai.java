package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes2.dex */
public final class zai implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        String str2 = null;
        zaa zaaVar = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 1:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 2:
                    i3 = SafeParcelReader.E(parcel, C);
                    break;
                case 3:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 4:
                    i4 = SafeParcelReader.E(parcel, C);
                    break;
                case 5:
                    z2 = SafeParcelReader.w(parcel, C);
                    break;
                case 6:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 7:
                    i5 = SafeParcelReader.E(parcel, C);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.o(parcel, C, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new FastJsonResponse.Field(i2, i3, z, i4, z2, str, i5, str2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i2) {
        return new FastJsonResponse.Field[i2];
    }
}
