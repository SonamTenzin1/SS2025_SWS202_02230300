package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbe implements Parcelable.Creator<zzbd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        List<ClientIdentity> list = zzbd.f17093f;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v != 1) {
                switch (v) {
                    case 5:
                        list = SafeParcelReader.t(parcel, C, ClientIdentity.CREATOR);
                        break;
                    case 6:
                        str = SafeParcelReader.p(parcel, C);
                        break;
                    case 7:
                        z = SafeParcelReader.w(parcel, C);
                        break;
                    case 8:
                        z2 = SafeParcelReader.w(parcel, C);
                        break;
                    case 9:
                        z3 = SafeParcelReader.w(parcel, C);
                        break;
                    case 10:
                        str2 = SafeParcelReader.p(parcel, C);
                        break;
                    default:
                        SafeParcelReader.K(parcel, C);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.o(parcel, C, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new zzbd(locationRequest, list, str, z, z2, z3, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd[] newArray(int i2) {
        return new zzbd[i2];
    }
}
