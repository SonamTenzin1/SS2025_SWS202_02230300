package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzm implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, getServiceRequest.f11972h);
        SafeParcelWriter.l(parcel, 2, getServiceRequest.f11973i);
        SafeParcelWriter.l(parcel, 3, getServiceRequest.f11974j);
        SafeParcelWriter.u(parcel, 4, getServiceRequest.f11975k, false);
        SafeParcelWriter.k(parcel, 5, getServiceRequest.l, false);
        SafeParcelWriter.x(parcel, 6, getServiceRequest.m, i2, false);
        SafeParcelWriter.e(parcel, 7, getServiceRequest.n, false);
        SafeParcelWriter.s(parcel, 8, getServiceRequest.o, i2, false);
        SafeParcelWriter.x(parcel, 10, getServiceRequest.p, i2, false);
        SafeParcelWriter.x(parcel, 11, getServiceRequest.q, i2, false);
        SafeParcelWriter.c(parcel, 12, getServiceRequest.r);
        SafeParcelWriter.l(parcel, 13, getServiceRequest.s);
        SafeParcelWriter.c(parcel, 14, getServiceRequest.t);
        SafeParcelWriter.u(parcel, 15, getServiceRequest.y(), false);
        SafeParcelWriter.b(parcel, a);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int L = SafeParcelReader.L(parcel);
        Scope[] scopeArr = GetServiceRequest.f11970f;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f11971g;
        Feature[] featureArr2 = featureArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        boolean z2 = false;
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
                    i4 = SafeParcelReader.E(parcel, C);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, C);
                    break;
                case 5:
                    iBinder = SafeParcelReader.D(parcel, C);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.s(parcel, C, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, C);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.o(parcel, C, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.K(parcel, C);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.s(parcel, C, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.s(parcel, C, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.w(parcel, C);
                    break;
                case 13:
                    i5 = SafeParcelReader.E(parcel, C);
                    break;
                case 14:
                    z2 = SafeParcelReader.w(parcel, C);
                    break;
                case 15:
                    str2 = SafeParcelReader.p(parcel, C);
                    break;
            }
        }
        SafeParcelReader.u(parcel, L);
        return new GetServiceRequest(i2, i3, i4, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i5, z2, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }
}
