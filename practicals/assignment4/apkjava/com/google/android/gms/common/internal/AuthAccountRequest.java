package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zaa();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11935f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private final IBinder f11936g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final Scope[] f11937h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private Integer f11938i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private Integer f11939j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private Account f11940k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AuthAccountRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) Scope[] scopeArr, @SafeParcelable.Param(id = 4) Integer num, @SafeParcelable.Param(id = 5) Integer num2, @SafeParcelable.Param(id = 6) Account account) {
        this.f11935f = i2;
        this.f11936g = iBinder;
        this.f11937h = scopeArr;
        this.f11938i = num;
        this.f11939j = num2;
        this.f11940k = account;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11935f);
        SafeParcelWriter.k(parcel, 2, this.f11936g, false);
        SafeParcelWriter.x(parcel, 3, this.f11937h, i2, false);
        SafeParcelWriter.o(parcel, 4, this.f11938i, false);
        SafeParcelWriter.o(parcel, 5, this.f11939j, false);
        SafeParcelWriter.s(parcel, 6, this.f11940k, i2, false);
        SafeParcelWriter.b(parcel, a);
    }
}
