package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcdh implements zzdti<zzcjv<zzcdb>> {
    private final zzdtu<zzcoe<zzcdb, zzams, zzclb>> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcoe<zzcdb, zzams, zzcla>> f15093b;

    /* renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15094c;

    public zzcdh(zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtuVar, zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15093b = zzdtuVar2;
        this.f15094c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzcoe<zzcdb, zzams, zzclb> zzcoeVar;
        zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtuVar = this.a;
        zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtuVar2 = this.f15093b;
        if (this.f15094c.get().o.contains("new_rewarded")) {
            zzcoeVar = zzdtuVar2.get();
        } else {
            zzcoeVar = zzdtuVar.get();
        }
        return (zzcjv) zzdto.b(zzcoeVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
