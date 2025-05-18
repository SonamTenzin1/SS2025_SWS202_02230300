package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzam extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzam> CREATOR = new zzao();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final Bundle f18066f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzam(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f18066f = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object W(String str) {
        return this.f18066f.get(str);
    }

    public final Bundle Y() {
        return new Bundle(this.f18066f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long e0(String str) {
        return Long.valueOf(this.f18066f.getLong(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double i0(String str) {
        return Double.valueOf(this.f18066f.getDouble(str));
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new i(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String p0(String str) {
        return this.f18066f.getString(str);
    }

    public final String toString() {
        return this.f18066f.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.e(parcel, 2, Y(), false);
        SafeParcelWriter.b(parcel, a);
    }

    public final int y() {
        return this.f18066f.size();
    }
}
