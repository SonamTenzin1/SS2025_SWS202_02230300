package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<Location> f17641g;

    /* renamed from: f, reason: collision with root package name */
    static final List<Location> f17640f = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzac();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public LocationResult(@SafeParcelable.Param(id = 1) List<Location> list) {
        this.f17641g = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f17641g.size() != this.f17641g.size()) {
            return false;
        }
        Iterator<Location> it = locationResult.f17641g.iterator();
        Iterator<Location> it2 = this.f17641g.iterator();
        while (it.hasNext()) {
            if (it2.next().getTime() != it.next().getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Iterator<Location> it = this.f17641g.iterator();
        int i2 = 17;
        while (it.hasNext()) {
            long time = it.next().getTime();
            i2 = (i2 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f17641g);
        StringBuilder sb = new StringBuilder(valueOf.length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.y(parcel, 1, y(), false);
        SafeParcelWriter.b(parcel, a);
    }

    public final List<Location> y() {
        return this.f17641g;
    }
}
