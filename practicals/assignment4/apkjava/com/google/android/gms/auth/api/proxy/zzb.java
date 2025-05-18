package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<ProxyResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundle = null;
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < L) {
            int C = SafeParcelReader.C(parcel);
            int v = SafeParcelReader.v(C);
            if (v == 1) {
                i3 = SafeParcelReader.E(parcel, C);
            } else if (v == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.o(parcel, C, PendingIntent.CREATOR);
            } else if (v == 3) {
                i4 = SafeParcelReader.E(parcel, C);
            } else if (v == 4) {
                bundle = SafeParcelReader.f(parcel, C);
            } else if (v == 5) {
                bArr = SafeParcelReader.g(parcel, C);
            } else if (v != 1000) {
                SafeParcelReader.K(parcel, C);
            } else {
                i2 = SafeParcelReader.E(parcel, C);
            }
        }
        SafeParcelReader.u(parcel, L);
        return new ProxyResponse(i2, i3, pendingIntent, i4, bundle, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse[] newArray(int i2) {
        return new ProxyResponse[i2];
    }
}
