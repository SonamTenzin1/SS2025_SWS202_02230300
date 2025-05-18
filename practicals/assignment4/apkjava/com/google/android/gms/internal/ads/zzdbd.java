package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbp;

@SafeParcelable.Class
/* loaded from: classes2.dex */
public final class zzdbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdbd> CREATOR = new zzdbe();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f15854f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private zzbp.zza f15855g = null;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f15856h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzdbd(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.f15854f = i2;
        this.f15856h = bArr;
        z();
    }

    private final void z() {
        zzbp.zza zzaVar = this.f15855g;
        if (zzaVar != null || this.f15856h == null) {
            if (zzaVar == null || this.f15856h != null) {
                if (zzaVar != null && this.f15856h != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzaVar == null && this.f15856h == null) {
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Impossible");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f15854f);
        byte[] bArr = this.f15856h;
        if (bArr == null) {
            bArr = this.f15855g.g();
        }
        SafeParcelWriter.f(parcel, 2, bArr, false);
        SafeParcelWriter.b(parcel, a);
    }

    public final zzbp.zza y() {
        if (!(this.f15855g != null)) {
            try {
                this.f15855g = zzbp.zza.m0(this.f15856h, zzdno.e());
                this.f15856h = null;
            } catch (zzdok e2) {
                throw new IllegalStateException(e2);
            }
        }
        z();
        return this.f15855g;
    }
}
