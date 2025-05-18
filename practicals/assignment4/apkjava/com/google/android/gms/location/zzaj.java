package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f17669f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f17670g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f17671h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final long f17672i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaj(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) long j3) {
        this.f17669f = i2;
        this.f17670g = i3;
        this.f17671h = j2;
        this.f17672i = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaj.class == obj.getClass()) {
            zzaj zzajVar = (zzaj) obj;
            if (this.f17669f == zzajVar.f17669f && this.f17670g == zzajVar.f17670g && this.f17671h == zzajVar.f17671h && this.f17672i == zzajVar.f17672i) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(Integer.valueOf(this.f17670g), Integer.valueOf(this.f17669f), Long.valueOf(this.f17672i), Long.valueOf(this.f17671h));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f17669f + " Cell status: " + this.f17670g + " elapsed time NS: " + this.f17672i + " system time ms: " + this.f17671h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17669f);
        SafeParcelWriter.l(parcel, 2, this.f17670g);
        SafeParcelWriter.p(parcel, 3, this.f17671h);
        SafeParcelWriter.p(parcel, 4, this.f17672i);
        SafeParcelWriter.b(parcel, a);
    }
}
