package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@zzard
@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class zzaia extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaia> CREATOR = new zzaib();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f13905f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String[] f13906g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String[] f13907h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaia(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) String[] strArr2) {
        this.f13905f = str;
        this.f13906g = strArr;
        this.f13907h = strArr2;
    }

    public static zzaia y(zzr zzrVar) throws zza {
        Map<String, String> g2 = zzrVar.g();
        int size = g2.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i2 = 0;
        for (Map.Entry<String, String> entry : g2.entrySet()) {
            strArr[i2] = entry.getKey();
            strArr2[i2] = entry.getValue();
            i2++;
        }
        return new zzaia(zzrVar.q(), strArr, strArr2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f13905f, false);
        SafeParcelWriter.v(parcel, 2, this.f13906g, false);
        SafeParcelWriter.v(parcel, 3, this.f13907h, false);
        SafeParcelWriter.b(parcel, a);
    }
}
