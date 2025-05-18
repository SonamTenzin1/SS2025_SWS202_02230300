package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzx;
import com.google.android.gms.location.zzy;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzbf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbf> CREATOR = new zzbg();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private int f17099f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private zzbd f17100g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private zzx f17101h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private PendingIntent f17102i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private zzu f17103j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private zzaj f17104k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbf(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) zzbd zzbdVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) PendingIntent pendingIntent, @SafeParcelable.Param(id = 5) IBinder iBinder2, @SafeParcelable.Param(id = 6) IBinder iBinder3) {
        this.f17099f = i2;
        this.f17100g = zzbdVar;
        zzaj zzajVar = null;
        this.f17101h = iBinder == null ? null : zzy.P(iBinder);
        this.f17102i = pendingIntent;
        this.f17103j = iBinder2 == null ? null : zzv.P(iBinder2);
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzajVar = queryLocalInterface instanceof zzaj ? (zzaj) queryLocalInterface : new zzal(iBinder3);
        }
        this.f17104k = zzajVar;
    }

    public static zzbf y(zzu zzuVar, zzaj zzajVar) {
        return new zzbf(2, null, null, null, zzuVar.asBinder(), zzajVar != null ? zzajVar.asBinder() : null);
    }

    public static zzbf z(zzx zzxVar, zzaj zzajVar) {
        return new zzbf(2, null, zzxVar.asBinder(), null, null, zzajVar != null ? zzajVar.asBinder() : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f17099f);
        SafeParcelWriter.s(parcel, 2, this.f17100g, i2, false);
        zzx zzxVar = this.f17101h;
        SafeParcelWriter.k(parcel, 3, zzxVar == null ? null : zzxVar.asBinder(), false);
        SafeParcelWriter.s(parcel, 4, this.f17102i, i2, false);
        zzu zzuVar = this.f17103j;
        SafeParcelWriter.k(parcel, 5, zzuVar == null ? null : zzuVar.asBinder(), false);
        zzaj zzajVar = this.f17104k;
        SafeParcelWriter.k(parcel, 6, zzajVar != null ? zzajVar.asBinder() : null, false);
        SafeParcelWriter.b(parcel, a);
    }
}
