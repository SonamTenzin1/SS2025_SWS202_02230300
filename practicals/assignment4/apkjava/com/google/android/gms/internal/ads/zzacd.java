package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzacd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzacd> CREATOR = new zzace();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f13785f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f13786g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f13787h;

    public zzacd(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.c(parcel, 2, this.f13785f);
        SafeParcelWriter.c(parcel, 3, this.f13786g);
        SafeParcelWriter.c(parcel, 4, this.f13787h);
        SafeParcelWriter.b(parcel, a);
    }

    @SafeParcelable.Constructor
    public zzacd(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.f13785f = z;
        this.f13786g = z2;
        this.f13787h = z3;
    }
}
