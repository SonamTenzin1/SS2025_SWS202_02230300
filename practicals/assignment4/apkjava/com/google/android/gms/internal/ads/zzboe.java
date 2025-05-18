package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzboe implements zzdti<zzcjv<zzbnf>> {
    private final zzdtu<zzcxv> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdtu<zzckv> f14609b;

    /* renamed from: c, reason: collision with root package name */
    private final zzdtu<zzckb> f14610c;

    public zzboe(zzdtu<zzcxv> zzdtuVar, zzdtu<zzckv> zzdtuVar2, zzdtu<zzckb> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14609b = zzdtuVar2;
        this.f14610c = zzdtuVar3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x002e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzyt.e().c(com.google.android.gms.internal.ads.zzacu.t1)).booleanValue() != false) goto L8;
     */
    @Override // com.google.android.gms.internal.ads.zzdtu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object get() {
        zzcxv zzcxvVar = this.a.get();
        zzcjv zzcjvVar = (zzckv) this.f14609b.get();
        zzcjv zzcjvVar2 = (zzckb) this.f14610c.get();
        if (zzcxvVar.a() != null) {
        }
        zzcjvVar = zzcjvVar2;
        return (zzcjv) zzdto.b(zzcjvVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
