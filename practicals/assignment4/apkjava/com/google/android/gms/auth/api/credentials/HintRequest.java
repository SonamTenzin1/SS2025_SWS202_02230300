package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzj();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11472f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final CredentialPickerConfig f11473g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11474h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11475i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final String[] f11476j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f11477k;

    @SafeParcelable.Field
    private final String l;

    @SafeParcelable.Field
    private final String m;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private CredentialPickerConfig a = new CredentialPickerConfig.Builder().a();

        /* renamed from: b, reason: collision with root package name */
        private boolean f11478b = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public HintRequest(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String[] strArr, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) String str2) {
        this.f11472f = i2;
        this.f11473g = (CredentialPickerConfig) Preconditions.k(credentialPickerConfig);
        this.f11474h = z;
        this.f11475i = z2;
        this.f11476j = (String[]) Preconditions.k(strArr);
        if (i2 < 2) {
            this.f11477k = true;
            this.l = null;
            this.m = null;
        } else {
            this.f11477k = z3;
            this.l = str;
            this.m = str2;
        }
    }

    public final String W() {
        return this.m;
    }

    public final String Y() {
        return this.l;
    }

    public final boolean e0() {
        return this.f11474h;
    }

    public final boolean i0() {
        return this.f11477k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, z(), i2, false);
        SafeParcelWriter.c(parcel, 2, e0());
        SafeParcelWriter.c(parcel, 3, this.f11475i);
        SafeParcelWriter.v(parcel, 4, y(), false);
        SafeParcelWriter.c(parcel, 5, i0());
        SafeParcelWriter.u(parcel, 6, Y(), false);
        SafeParcelWriter.u(parcel, 7, W(), false);
        SafeParcelWriter.l(parcel, 1000, this.f11472f);
        SafeParcelWriter.b(parcel, a);
    }

    public final String[] y() {
        return this.f11476j;
    }

    public final CredentialPickerConfig z() {
        return this.f11473g;
    }
}
