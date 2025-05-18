package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzr;
import com.google.android.gms.location.zzs;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17118f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private zzm f17119g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private zzr f17120h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private zzaj f17121i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) zzm zzmVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2) {
        this.f17118f = i2;
        this.f17119g = zzmVar;
        zzaj zzajVar = null;
        this.f17120h = iBinder == null ? null : zzs.P(iBinder);
        if (iBinder2 != null) {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzajVar = queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzal(iBinder2);
        }
        this.f17121i = zzajVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17118f);
        SafeParcelWriter.s(parcel, 2, this.f17119g, i2, false);
        zzr zzrVar = this.f17120h;
        SafeParcelWriter.k(parcel, 3, zzrVar == null ? null : zzrVar.asBinder(), false);
        zzaj zzajVar = this.f17121i;
        SafeParcelWriter.k(parcel, 4, zzajVar != null ? zzajVar.asBinder() : null, false);
        SafeParcelWriter.b(parcel, a);
    }
}
