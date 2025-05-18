package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzf();

    /* renamed from: f, reason: collision with root package name */
    public static final Comparator<ActivityTransition> f17608f = new c();

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<ActivityTransition> f17609g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f17610h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<ClientIdentity> f17611i;

    @SafeParcelable.Constructor
    public ActivityTransitionRequest(@SafeParcelable.Param(id = 1) List<ActivityTransition> list, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List<ClientIdentity> list2) {
        Preconditions.l(list, "transitions can't be null");
        Preconditions.b(list.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(f17608f);
        for (ActivityTransition activityTransition : list) {
            Preconditions.b(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", activityTransition));
        }
        this.f17609g = Collections.unmodifiableList(list);
        this.f17610h = str;
        this.f17611i = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (Objects.a(this.f17609g, activityTransitionRequest.f17609g) && Objects.a(this.f17610h, activityTransitionRequest.f17610h) && Objects.a(this.f17611i, activityTransitionRequest.f17611i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f17609g.hashCode() * 31;
        String str = this.f17610h;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.f17611i;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f17609g);
        String str = this.f17610h;
        String valueOf2 = String.valueOf(this.f17611i);
        StringBuilder sb = new StringBuilder(valueOf.length() + 61 + String.valueOf(str).length() + valueOf2.length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(valueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append('\'');
        sb.append(", mClients=");
        sb.append(valueOf2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.y(parcel, 1, this.f17609g, false);
        SafeParcelWriter.u(parcel, 2, this.f17610h, false);
        SafeParcelWriter.y(parcel, 3, this.f17611i, false);
        SafeParcelWriter.b(parcel, a);
    }
}
