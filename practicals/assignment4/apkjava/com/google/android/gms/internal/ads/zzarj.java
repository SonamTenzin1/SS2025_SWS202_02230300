package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzarj implements Parcelable.Creator<zzari> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzari createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        zzaru zzaruVar = null;
        String str7 = null;
        String str8 = null;
        zzato zzatoVar = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        zzark zzarkVar = null;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        String str10 = null;
        zzauy zzauyVar = null;
        String str11 = null;
        Bundle bundle = null;
        ArrayList<String> arrayList7 = null;
        String str12 = null;
        String str13 = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int i5 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 1:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 4:
                    arrayList = SafeParcelReader.r(parcel, C);
                    break;
                case 5:
                    i3 = SafeParcelReader.E(parcel, C);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.r(parcel, C);
                    break;
                case 7:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                case 8:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 9:
                    j3 = SafeParcelReader.G(parcel, C);
                    break;
                case 10:
                    arrayList3 = SafeParcelReader.r(parcel, C);
                    break;
                case 11:
                    j4 = SafeParcelReader.G(parcel, C);
                    break;
                case 12:
                    i4 = SafeParcelReader.E(parcel, C);
                    break;
                case 13:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 14:
                    j5 = SafeParcelReader.G(parcel, C);
                    break;
                case 15:
                    str4 = SafeParcelReader.p(parcel, C);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
                case 18:
                    z2 = SafeParcelReader.w(parcel, C);
                    break;
                case 19:
                    str5 = SafeParcelReader.p(parcel, C);
                    break;
                case 21:
                    str6 = SafeParcelReader.p(parcel, C);
                    break;
                case 22:
                    z3 = SafeParcelReader.w(parcel, C);
                    break;
                case 23:
                    z4 = SafeParcelReader.w(parcel, C);
                    break;
                case 24:
                    z5 = SafeParcelReader.w(parcel, C);
                    break;
                case 25:
                    z6 = SafeParcelReader.w(parcel, C);
                    break;
                case 26:
                    z7 = SafeParcelReader.w(parcel, C);
                    break;
                case 28:
                    zzaruVar = (zzaru) SafeParcelReader.o(parcel, C, zzaru.CREATOR);
                    break;
                case 29:
                    str7 = SafeParcelReader.p(parcel, C);
                    break;
                case 30:
                    str8 = SafeParcelReader.p(parcel, C);
                    break;
                case 31:
                    z8 = SafeParcelReader.w(parcel, C);
                    break;
                case 32:
                    z9 = SafeParcelReader.w(parcel, C);
                    break;
                case 33:
                    zzatoVar = (zzato) SafeParcelReader.o(parcel, C, zzato.CREATOR);
                    break;
                case 34:
                    arrayList4 = SafeParcelReader.r(parcel, C);
                    break;
                case 35:
                    arrayList5 = SafeParcelReader.r(parcel, C);
                    break;
                case 36:
                    z10 = SafeParcelReader.w(parcel, C);
                    break;
                case 37:
                    zzarkVar = (zzark) SafeParcelReader.o(parcel, C, zzark.CREATOR);
                    break;
                case 38:
                    z11 = SafeParcelReader.w(parcel, C);
                    break;
                case 39:
                    str9 = SafeParcelReader.p(parcel, C);
                    break;
                case 40:
                    arrayList6 = SafeParcelReader.r(parcel, C);
                    break;
                case 42:
                    z12 = SafeParcelReader.w(parcel, C);
                    break;
                case 43:
                    str10 = SafeParcelReader.p(parcel, C);
                    break;
                case 44:
                    zzauyVar = (zzauy) SafeParcelReader.o(parcel, C, zzauy.CREATOR);
                    break;
                case 45:
                    str11 = SafeParcelReader.p(parcel, C);
                    break;
                case 46:
                    z13 = SafeParcelReader.w(parcel, C);
                    break;
                case 47:
                    z14 = SafeParcelReader.w(parcel, C);
                    break;
                case 48:
                    bundle = SafeParcelReader.f(parcel, C);
                    break;
                case 49:
                    z15 = SafeParcelReader.w(parcel, C);
                    break;
                case 50:
                    i5 = SafeParcelReader.E(parcel, C);
                    break;
                case 51:
                    z16 = SafeParcelReader.w(parcel, C);
                    break;
                case 52:
                    arrayList7 = SafeParcelReader.r(parcel, C);
                    break;
                case 53:
                    z17 = SafeParcelReader.w(parcel, C);
                    break;
                case 54:
                    str12 = SafeParcelReader.p(parcel, C);
                    break;
                case 55:
                    str13 = SafeParcelReader.p(parcel, C);
                    break;
                case 56:
                    z18 = SafeParcelReader.w(parcel, C);
                    break;
                case 57:
                    z19 = SafeParcelReader.w(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzari(i2, str, str2, arrayList, i3, arrayList2, j2, z, j3, arrayList3, j4, i4, str3, j5, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzaruVar, str7, str8, z8, z9, zzatoVar, arrayList4, arrayList5, z10, zzarkVar, z11, str9, arrayList6, z12, str10, zzauyVar, str11, z13, z14, bundle, z15, i5, z16, arrayList7, z17, str12, str13, z18, z19);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzari[] newArray(int i2) {
        return new zzari[i2];
    }
}
