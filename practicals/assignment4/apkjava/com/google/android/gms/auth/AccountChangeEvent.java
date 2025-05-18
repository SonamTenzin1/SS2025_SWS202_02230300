package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11377f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f11378g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11379h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11380i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11381j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11382k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AccountChangeEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) String str2) {
        this.f11377f = i2;
        this.f11378g = j2;
        this.f11379h = (String) Preconditions.k(str);
        this.f11380i = i3;
        this.f11381j = i4;
        this.f11382k = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.f11377f == accountChangeEvent.f11377f && this.f11378g == accountChangeEvent.f11378g && Objects.a(this.f11379h, accountChangeEvent.f11379h) && this.f11380i == accountChangeEvent.f11380i && this.f11381j == accountChangeEvent.f11381j && Objects.a(this.f11382k, accountChangeEvent.f11382k)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f11377f), Long.valueOf(this.f11378g), this.f11379h, Integer.valueOf(this.f11380i), Integer.valueOf(this.f11381j), this.f11382k);
    }

    public String toString() {
        int i2 = this.f11380i;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.f11379h;
        String str3 = this.f11382k;
        int i3 = this.f11381j;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + str.length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11377f);
        SafeParcelWriter.p(parcel, 2, this.f11378g);
        SafeParcelWriter.u(parcel, 3, this.f11379h, false);
        SafeParcelWriter.l(parcel, 4, this.f11380i);
        SafeParcelWriter.l(parcel, 5, this.f11381j);
        SafeParcelWriter.u(parcel, 6, this.f11382k, false);
        SafeParcelWriter.b(parcel, a);
    }
}
