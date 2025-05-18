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
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzl();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final RootTelemetryConfiguration f11962f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11963g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11964h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final int[] f11965i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11966j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final int[] f11967k;

    @SafeParcelable.Constructor
    public ConnectionTelemetryConfiguration(@SafeParcelable.Param(id = 1) RootTelemetryConfiguration rootTelemetryConfiguration, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) int[] iArr, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) int[] iArr2) {
        this.f11962f = rootTelemetryConfiguration;
        this.f11963g = z;
        this.f11964h = z2;
        this.f11965i = iArr;
        this.f11966j = i2;
        this.f11967k = iArr2;
    }

    @KeepForSdk
    public int[] W() {
        return this.f11967k;
    }

    @KeepForSdk
    public boolean Y() {
        return this.f11963g;
    }

    @KeepForSdk
    public boolean e0() {
        return this.f11964h;
    }

    public final RootTelemetryConfiguration i0() {
        return this.f11962f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.f11962f, i2, false);
        SafeParcelWriter.c(parcel, 2, Y());
        SafeParcelWriter.c(parcel, 3, e0());
        SafeParcelWriter.m(parcel, 4, z(), false);
        SafeParcelWriter.l(parcel, 5, y());
        SafeParcelWriter.m(parcel, 6, W(), false);
        SafeParcelWriter.b(parcel, a);
    }

    @KeepForSdk
    public int y() {
        return this.f11966j;
    }

    @KeepForSdk
    public int[] z() {
        return this.f11965i;
    }
}
