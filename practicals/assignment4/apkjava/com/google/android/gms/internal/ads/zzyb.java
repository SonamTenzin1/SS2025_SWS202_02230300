package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzyb implements Parcelable.Creator<zzxz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzxz createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzaca zzacaVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzxt zzxtVar = null;
        String str5 = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i5 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 1:
                    i2 = SafeParcelReader.E(parcel, C);
                    break;
                case 2:
                    j2 = SafeParcelReader.G(parcel, C);
                    break;
                case 3:
                    bundle = SafeParcelReader.f(parcel, C);
                    break;
                case 4:
                    i3 = SafeParcelReader.E(parcel, C);
                    break;
                case 5:
                    arrayList = SafeParcelReader.r(parcel, C);
                    break;
                case 6:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 7:
                    i4 = SafeParcelReader.E(parcel, C);
                    break;
                case 8:
                    z2 = SafeParcelReader.w(parcel, C);
                    break;
                case 9:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 10:
                    zzacaVar = (zzaca) SafeParcelReader.o(parcel, C, zzaca.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.o(parcel, C, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.f(parcel, C);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.f(parcel, C);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.r(parcel, C);
                    break;
                case 16:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 17:
                    str4 = SafeParcelReader.p(parcel, C);
                    break;
                case 18:
                    z3 = SafeParcelReader.w(parcel, C);
                    break;
                case 19:
                    zzxtVar = (zzxt) SafeParcelReader.o(parcel, C, zzxt.CREATOR);
                    break;
                case 20:
                    i5 = SafeParcelReader.E(parcel, C);
                    break;
                case 21:
                    str5 = SafeParcelReader.p(parcel, C);
                    break;
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzxz(i2, j2, bundle, i3, arrayList, z, i4, z2, str, zzacaVar, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3, zzxtVar, i5, str5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzxz[] newArray(int i2) {
        return new zzxz[i2];
    }
}
