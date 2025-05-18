package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f18284f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private int f18285g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private Intent f18286h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zaa(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) Intent intent) {
        this.f18284f = i2;
        this.f18285g = i3;
        this.f18286h = intent;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.f18285g == 0) {
            return Status.f11688g;
        }
        return Status.f11692k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f18284f);
        SafeParcelWriter.l(parcel, 2, this.f18285g);
        SafeParcelWriter.s(parcel, 3, this.f18286h, i2, false);
        SafeParcelWriter.b(parcel, a);
    }

    public zaa() {
        this(0, null);
    }

    private zaa(int i2, Intent intent) {
        this(2, 0, null);
    }
}
