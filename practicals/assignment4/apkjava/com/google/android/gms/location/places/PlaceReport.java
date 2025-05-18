package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zza();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f17662f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17663g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17664h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17665i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PlaceReport(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3) {
        this.f17662f = i2;
        this.f17663g = str;
        this.f17664h = str2;
        this.f17665i = str3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return Objects.a(this.f17663g, placeReport.f17663g) && Objects.a(this.f17664h, placeReport.f17664h) && Objects.a(this.f17665i, placeReport.f17665i);
    }

    public int hashCode() {
        return Objects.b(this.f17663g, this.f17664h, this.f17665i);
    }

    public String toString() {
        Objects.ToStringHelper c2 = Objects.c(this);
        c2.a("placeId", this.f17663g);
        c2.a(StoreTabGridRecyclerFragment.BundleCons.TAG, this.f17664h);
        if (!"unknown".equals(this.f17665i)) {
            c2.a("source", this.f17665i);
        }
        return c2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17662f);
        SafeParcelWriter.u(parcel, 2, y(), false);
        SafeParcelWriter.u(parcel, 3, z(), false);
        SafeParcelWriter.u(parcel, 4, this.f17665i, false);
        SafeParcelWriter.b(parcel, a);
    }

    public String y() {
        return this.f17663g;
    }

    public String z() {
        return this.f17664h;
    }
}
