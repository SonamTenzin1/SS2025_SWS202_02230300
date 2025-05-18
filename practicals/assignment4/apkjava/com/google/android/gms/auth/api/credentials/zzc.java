package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<Credential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        String str2 = null;
        Uri uri = null;
        ArrayList arrayList = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(C)) {
                case 1:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 2:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 3:
                    uri = (Uri) SafeParcelReader.o(parcel, C, Uri.CREATOR);
                    break;
                case 4:
                    arrayList = SafeParcelReader.t(parcel, C, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 6:
                    str4 = SafeParcelReader.p(parcel, C);
                    break;
                case 7:
                case 8:
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
                case 9:
                    str5 = SafeParcelReader.p(parcel, C);
                    break;
                case 10:
                    str6 = SafeParcelReader.p(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new Credential(str, str2, uri, arrayList, str3, str4, str5, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential[] newArray(int i2) {
        return new Credential[i2];
    }
}
