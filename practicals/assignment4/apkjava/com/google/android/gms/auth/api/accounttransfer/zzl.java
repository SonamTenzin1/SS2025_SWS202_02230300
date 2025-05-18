package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class zzl extends zzaz {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f11426f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Indicator
    private final Set<Integer> f11427g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11428h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private ArrayList<zzr> f11429i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private int f11430j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private zzo f11431k;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f11426f = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.W("authenticatorData", 2, zzr.class));
        hashMap.put("progress", FastJsonResponse.Field.z("progress", 4, zzo.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<zzr> arrayList, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) zzo zzoVar) {
        this.f11427g = set;
        this.f11428h = i2;
        this.f11429i = arrayList;
        this.f11430j = i3;
        this.f11431k = zzoVar;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map a() {
        return f11426f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object b(FastJsonResponse.Field field) {
        int p0 = field.p0();
        if (p0 == 1) {
            return Integer.valueOf(this.f11428h);
        }
        if (p0 == 2) {
            return this.f11429i;
        }
        if (p0 == 4) {
            return this.f11431k;
        }
        int p02 = field.p0();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(p02);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean d(FastJsonResponse.Field field) {
        return this.f11427g.contains(Integer.valueOf(field.p0()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        Set<Integer> set = this.f11427g;
        if (set.contains(1)) {
            SafeParcelWriter.l(parcel, 1, this.f11428h);
        }
        if (set.contains(2)) {
            SafeParcelWriter.y(parcel, 2, this.f11429i, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.l(parcel, 3, this.f11430j);
        }
        if (set.contains(4)) {
            SafeParcelWriter.s(parcel, 4, this.f11431k, i2, true);
        }
        SafeParcelWriter.b(parcel, a);
    }

    public zzl() {
        this.f11427g = new HashSet(1);
        this.f11428h = 1;
    }
}
