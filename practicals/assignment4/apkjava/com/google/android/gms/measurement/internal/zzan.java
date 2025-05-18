package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new zzaq();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18067f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzam f18068g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f18069h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f18070i;

    @SafeParcelable.Constructor
    public zzan(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) zzam zzamVar, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j2) {
        this.f18067f = str;
        this.f18068g = zzamVar;
        this.f18069h = str2;
        this.f18070i = j2;
    }

    public final String toString() {
        String str = this.f18069h;
        String str2 = this.f18067f;
        String valueOf = String.valueOf(this.f18068g);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + valueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f18067f, false);
        SafeParcelWriter.s(parcel, 3, this.f18068g, i2, false);
        SafeParcelWriter.u(parcel, 4, this.f18069h, false);
        SafeParcelWriter.p(parcel, 5, this.f18070i);
        SafeParcelWriter.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(zzan zzanVar, long j2) {
        Preconditions.k(zzanVar);
        this.f18067f = zzanVar.f18067f;
        this.f18068g = zzanVar.f18068g;
        this.f18069h = zzanVar.f18069h;
        this.f18070i = j2;
    }
}
