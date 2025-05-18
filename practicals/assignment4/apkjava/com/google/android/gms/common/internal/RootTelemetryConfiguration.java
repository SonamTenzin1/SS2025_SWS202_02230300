package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes2.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzai();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12005f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12006g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12007h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12008i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f12009j;

    @SafeParcelable.Constructor
    public RootTelemetryConfiguration(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) int i4) {
        this.f12005f = i2;
        this.f12006g = z;
        this.f12007h = z2;
        this.f12008i = i3;
        this.f12009j = i4;
    }

    @KeepForSdk
    public boolean W() {
        return this.f12006g;
    }

    @KeepForSdk
    public boolean Y() {
        return this.f12007h;
    }

    @KeepForSdk
    public int e0() {
        return this.f12005f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, e0());
        SafeParcelWriter.c(parcel, 2, W());
        SafeParcelWriter.c(parcel, 3, Y());
        SafeParcelWriter.l(parcel, 4, y());
        SafeParcelWriter.l(parcel, 5, z());
        SafeParcelWriter.b(parcel, a);
    }

    @KeepForSdk
    public int y() {
        return this.f12008i;
    }

    @KeepForSdk
    public int z() {
        return this.f12009j;
    }
}
