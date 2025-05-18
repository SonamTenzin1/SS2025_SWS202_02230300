package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbof implements zzdti<zzcjv<zzbnf>> {
    private final zzdtu<Boolean> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcmo> f14611b;

    /* renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcoe<zzbnf, zzams, zzcla>> f14612c;

    public zzbof(zzdtu<Boolean> zzdtuVar, zzdtu<zzcmo> zzdtuVar2, zzdtu<zzcoe<zzbnf, zzams, zzcla>> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14611b = zzdtuVar2;
        this.f14612c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        boolean booleanValue = this.a.get().booleanValue();
        zzcjv zzcjvVar = (zzcmo) this.f14611b.get();
        zzcjv zzcjvVar2 = (zzcoe) this.f14612c.get();
        if (!booleanValue) {
            zzcjvVar = zzcjvVar2;
        }
        return (zzcjv) zzdto.b(zzcjvVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
