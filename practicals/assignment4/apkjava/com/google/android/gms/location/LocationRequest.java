package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzab();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17634f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17635g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17636h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private boolean f17637i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private long f17638j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17639k;

    @SafeParcelable.Field
    private float l;

    @SafeParcelable.Field
    private long m;

    public LocationRequest() {
        this.f17634f = 102;
        this.f17635g = 3600000L;
        this.f17636h = 600000L;
        this.f17637i = false;
        this.f17638j = Long.MAX_VALUE;
        this.f17639k = Integer.MAX_VALUE;
        this.l = 0.0f;
        this.m = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public LocationRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) long j3, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) long j4, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) float f2, @SafeParcelable.Param(id = 8) long j5) {
        this.f17634f = i2;
        this.f17635g = j2;
        this.f17636h = j3;
        this.f17637i = z;
        this.f17638j = j4;
        this.f17639k = i3;
        this.l = f2;
        this.m = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f17634f == locationRequest.f17634f && this.f17635g == locationRequest.f17635g && this.f17636h == locationRequest.f17636h && this.f17637i == locationRequest.f17637i && this.f17638j == locationRequest.f17638j && this.f17639k == locationRequest.f17639k && this.l == locationRequest.l && y() == locationRequest.y();
    }

    public final int hashCode() {
        return Objects.b(Integer.valueOf(this.f17634f), Long.valueOf(this.f17635g), Float.valueOf(this.l), Long.valueOf(this.m));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i2 = this.f17634f;
        sb.append(i2 != 100 ? i2 != 102 ? i2 != 104 ? i2 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f17634f != 105) {
            sb.append(" requested=");
            sb.append(this.f17635g);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.f17636h);
        sb.append("ms");
        if (this.m > this.f17635g) {
            sb.append(" maxWait=");
            sb.append(this.m);
            sb.append("ms");
        }
        if (this.l > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.l);
            sb.append("m");
        }
        long j2 = this.f17638j;
        if (j2 != Long.MAX_VALUE) {
            long elapsedRealtime = j2 - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime);
            sb.append("ms");
        }
        if (this.f17639k != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.f17639k);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17634f);
        SafeParcelWriter.p(parcel, 2, this.f17635g);
        SafeParcelWriter.p(parcel, 3, this.f17636h);
        SafeParcelWriter.c(parcel, 4, this.f17637i);
        SafeParcelWriter.p(parcel, 5, this.f17638j);
        SafeParcelWriter.l(parcel, 6, this.f17639k);
        SafeParcelWriter.i(parcel, 7, this.l);
        SafeParcelWriter.p(parcel, 8, this.m);
        SafeParcelWriter.b(parcel, a);
    }

    public final long y() {
        long j2 = this.m;
        long j3 = this.f17635g;
        return j2 < j3 ? j3 : j2;
    }
}
