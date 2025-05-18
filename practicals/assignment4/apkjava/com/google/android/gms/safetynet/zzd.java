package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f18264f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final HarmfulAppsData[] f18265g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f18266h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f18267i;

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) HarmfulAppsData[] harmfulAppsDataArr, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z) {
        this.f18264f = j2;
        this.f18265g = harmfulAppsDataArr;
        this.f18267i = z;
        if (z) {
            this.f18266h = i2;
        } else {
            this.f18266h = -1;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.p(parcel, 2, this.f18264f);
        SafeParcelWriter.x(parcel, 3, this.f18265g, i2, false);
        SafeParcelWriter.l(parcel, 4, this.f18266h);
        SafeParcelWriter.c(parcel, 5, this.f18267i);
        SafeParcelWriter.b(parcel, a);
    }
}
