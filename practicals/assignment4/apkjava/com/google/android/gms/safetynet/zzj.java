package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes2.dex */
public final class zzj implements Parcelable.Creator<SafeBrowsingData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, safeBrowsingData.Y(), false);
        SafeParcelWriter.s(parcel, 3, safeBrowsingData.y(), i2, false);
        SafeParcelWriter.s(parcel, 4, safeBrowsingData.z(), i2, false);
        SafeParcelWriter.p(parcel, 5, safeBrowsingData.W());
        SafeParcelWriter.f(parcel, 6, safeBrowsingData.e0(), false);
        SafeParcelWriter.b(parcel, a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArr = null;
        long j2 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 2) {
                str = SafeParcelReader.p(parcel, C);
            } else if (v == 3) {
                dataHolder = (DataHolder) SafeParcelReader.o(parcel, C, DataHolder.CREATOR);
            } else if (v == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.o(parcel, C, ParcelFileDescriptor.CREATOR);
            } else if (v == 5) {
                j2 = SafeParcelReader.G(parcel, C);
            } else if (v != 6) {
                SafeParcelReader.K(parcel, C);
            } else {
                bArr = SafeParcelReader.g(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new SafeBrowsingData(str, dataHolder, parcelFileDescriptor, j2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i2) {
        return new SafeBrowsingData[i2];
    }
}
