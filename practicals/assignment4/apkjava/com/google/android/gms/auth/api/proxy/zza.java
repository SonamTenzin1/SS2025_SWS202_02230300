package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zza implements Parcelable.Creator<ProxyRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        String str = null;
        byte[] bArr = null;
        Bundle bundle = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, C);
            } else if (v == 2) {
                i3 = SafeParcelReader.E(parcel, C);
            } else if (v == 3) {
                j2 = SafeParcelReader.G(parcel, C);
            } else if (v == 4) {
                bArr = SafeParcelReader.g(parcel, C);
            } else if (v == 5) {
                bundle = SafeParcelReader.f(parcel, C);
            } else if (v != 1000) {
                SafeParcelReader.K(parcel, C);
            } else {
                i2 = SafeParcelReader.E(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new ProxyRequest(i2, str, i3, j2, bArr, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest[] newArray(int i2) {
        return new ProxyRequest[i2];
    }
}
