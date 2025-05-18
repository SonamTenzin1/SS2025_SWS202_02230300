package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        boolean z = false;
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
                case 7:
                case 9:
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 5:
                    i4 = SafeParcelReader.E(parcel, C);
                    break;
                case 6:
                    arrayList = SafeParcelReader.r(parcel, C);
                    break;
                case 8:
                    j3 = SafeParcelReader.G(parcel, C);
                    break;
                case 10:
                    str3 = SafeParcelReader.p(parcel, C);
                    break;
                case 11:
                    i3 = SafeParcelReader.E(parcel, C);
                    break;
                case 12:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
                case 13:
                    str4 = SafeParcelReader.p(parcel, C);
                    break;
                case 14:
                    i5 = SafeParcelReader.E(parcel, C);
                    break;
                case 15:
                    f2 = SafeParcelReader.A(parcel, C);
                    break;
                case 16:
                    j4 = SafeParcelReader.G(parcel, C);
                    break;
                case 17:
                    str5 = SafeParcelReader.p(parcel, C);
                    break;
                case 18:
                    z = SafeParcelReader.w(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new WakeLockEvent(i2, j2, i3, str, i4, arrayList, str2, j3, i5, str3, str4, f2, j4, str5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
