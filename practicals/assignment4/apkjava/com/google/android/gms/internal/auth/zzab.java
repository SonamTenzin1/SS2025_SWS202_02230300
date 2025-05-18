package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f17027f = 1;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17028g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f17029h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzab(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        this.f17028g = (String) Preconditions.k(str);
        this.f17029h = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17027f);
        SafeParcelWriter.u(parcel, 2, this.f17028g, false);
        SafeParcelWriter.l(parcel, 3, this.f17029h);
        SafeParcelWriter.b(parcel, a);
    }
}
