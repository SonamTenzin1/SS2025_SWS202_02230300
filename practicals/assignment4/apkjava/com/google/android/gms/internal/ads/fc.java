package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
final class fc implements zzboo {
    private zzbop a;

    /* renamed from: b, reason: collision with root package name */
    private zzdtu<zzaga> f12580b;

    /* renamed from: c, reason: collision with root package name */
    private zzdtu<Runnable> f12581c;

    /* renamed from: d, reason: collision with root package name */
    private zzdtu<zzcxu> f12582d;

    /* renamed from: e, reason: collision with root package name */
    private zzdtu<zzcxm> f12583e;

    /* renamed from: f, reason: collision with root package name */
    private zzdtu<Set<zzbuz<zzbrx>>> f12584f;

    /* renamed from: g, reason: collision with root package name */
    private zzdtu<zzbry> f12585g;

    /* renamed from: h, reason: collision with root package name */
    private zzdtu<Set<zzbuz<zzbsr>>> f12586h;

    /* renamed from: i, reason: collision with root package name */
    private zzdtu<zzbso> f12587i;

    /* renamed from: j, reason: collision with root package name */
    private zzdtu<String> f12588j;

    /* renamed from: k, reason: collision with root package name */
    private zzdtu<zzbol> f12589k;
    private final /* synthetic */ dc l;

    private fc(dc dcVar, zzbpr zzbprVar, zzbop zzbopVar) {
        zzdtu zzdtuVar;
        this.l = dcVar;
        this.a = zzbopVar;
        this.f12580b = new zzbor(zzbopVar);
        this.f12581c = new zzboq(zzbopVar);
        this.f12582d = zzbpu.a(zzbprVar);
        this.f12583e = zzbps.a(zzbprVar);
        zzdtq c2 = zzdtq.a(0, 2).b(dc.E(dcVar)).b(dc.D(dcVar)).c();
        this.f12584f = c2;
        this.f12585g = zzdth.a(zzbsd.a(c2));
        zzdtq c3 = zzdtq.a(4, 3).a(dc.A(dcVar)).a(dc.z(dcVar)).a(dc.y(dcVar)).b(dc.l(dcVar)).b(dc.j(dcVar)).b(dc.i(dcVar)).a(dc.v(dcVar)).c();
        this.f12586h = c3;
        this.f12587i = zzdth.a(zzbsq.a(c3));
        this.f12588j = zzbpt.a(zzbprVar);
        zzdtu<zzaga> zzdtuVar2 = this.f12580b;
        zzdtu<Runnable> zzdtuVar3 = this.f12581c;
        zzdtuVar = dcVar.n2.f14497c;
        this.f12589k = zzdth.a(new zzbos(zzdtuVar2, zzdtuVar3, zzdtuVar, this.f12582d, this.f12583e, this.f12585g, this.f12587i, this.f12588j));
    }

    @Override // com.google.android.gms.internal.ads.zzboo
    public final zzbnf a() {
        return (zzbnf) zzdto.b(this.f12589k.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
