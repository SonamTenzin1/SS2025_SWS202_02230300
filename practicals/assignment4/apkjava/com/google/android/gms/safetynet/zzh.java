package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f18269f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f18270g;

    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z) {
        this.f18269f = i2;
        this.f18270g = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 2, this.f18269f);
        SafeParcelWriter.c(parcel, 3, this.f18270g);
        SafeParcelWriter.b(parcel, a);
    }
}
