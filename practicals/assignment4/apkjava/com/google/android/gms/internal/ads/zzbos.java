package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzbos implements zzdti<zzbol> {
    private final zzdtu<zzaga> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdtu<Runnable> f14623b;

    /* renamed from: c, reason: collision with root package name */
    private final zzdtu<Executor> f14624c;

    /* renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcxu> f14625d;

    /* renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcxm> f14626e;

    /* renamed from: f, reason: collision with root package name */
    private final zzdtu<zzbry> f14627f;

    /* renamed from: g, reason: collision with root package name */
    private final zzdtu<zzbso> f14628g;

    /* renamed from: h, reason: collision with root package name */
    private final zzdtu<String> f14629h;

    public zzbos(zzdtu<zzaga> zzdtuVar, zzdtu<Runnable> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<zzcxu> zzdtuVar4, zzdtu<zzcxm> zzdtuVar5, zzdtu<zzbry> zzdtuVar6, zzdtu<zzbso> zzdtuVar7, zzdtu<String> zzdtuVar8) {
        this.a = zzdtuVar;
        this.f14623b = zzdtuVar2;
        this.f14624c = zzdtuVar3;
        this.f14625d = zzdtuVar4;
        this.f14626e = zzdtuVar5;
        this.f14627f = zzdtuVar6;
        this.f14628g = zzdtuVar7;
        this.f14629h = zzdtuVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbol zzbolVar = new zzbol(this.a.get(), this.f14623b.get(), this.f14624c.get());
        zzbql.d(zzbolVar, this.f14625d.get());
        zzbql.c(zzbolVar, this.f14626e.get());
        zzbql.a(zzbolVar, this.f14627f.get());
        zzbql.b(zzbolVar, this.f14628g.get());
        zzbql.e(zzbolVar, this.f14629h.get());
        return zzbolVar;
    }
}
