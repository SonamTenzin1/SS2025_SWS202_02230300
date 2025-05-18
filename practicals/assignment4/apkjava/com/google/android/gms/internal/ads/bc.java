package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class bc extends zzcvs {
    private zzcwx a;

    /* renamed from: b, reason: collision with root package name */
    private zzdtu<zzcvo> f12340b;

    /* renamed from: c, reason: collision with root package name */
    private zzdtu<String> f12341c;

    /* renamed from: d, reason: collision with root package name */
    private zzdtu<zzcvy> f12342d;

    /* renamed from: e, reason: collision with root package name */
    private zzdtu<zzcwc> f12343e;

    /* renamed from: f, reason: collision with root package name */
    private zzdtu<zzcwj> f12344f;

    /* renamed from: g, reason: collision with root package name */
    private zzdtu<Boolean> f12345g;

    /* renamed from: h, reason: collision with root package name */
    private zzdtu<ApplicationInfo> f12346h;

    /* renamed from: i, reason: collision with root package name */
    private zzdtu<zzcwq> f12347i;

    /* renamed from: j, reason: collision with root package name */
    private zzdtu<zzcwu> f12348j;

    /* renamed from: k, reason: collision with root package name */
    private zzdtu<zzcxh> f12349k;
    private zzdtu<String> l;
    private zzdtu<zzcez> m;
    private zzdtu<zzcez> n;
    private zzdtu<zzcez> o;
    private zzdtu<zzcez> p;
    private zzdtu<Map<zzczs, zzcez>> q;
    private zzdtu<Set<zzbuz<zzczz>>> r;
    private zzdtu<Set<zzbuz<zzczz>>> s;
    private zzdtu t;
    private zzdtu<zzczt> u;
    private final /* synthetic */ zzbkc v;

    private bc(zzbkc zzbkcVar, zzcwx zzcwxVar) {
        zzdtu zzdtuVar;
        zzdtu zzdtuVar2;
        zzdtu zzdtuVar3;
        zzdtu zzdtuVar4;
        zzdtu zzdtuVar5;
        zzdtu zzdtuVar6;
        zzdtu zzdtuVar7;
        zzdtu zzdtuVar8;
        zzdtu zzdtuVar9;
        this.v = zzbkcVar;
        this.a = zzcwxVar;
        zzbln a = zzbln.a();
        zzdtuVar = zzbkcVar.f14503i;
        zzdtuVar2 = zzbkcVar.f14499e;
        this.f12340b = new zzcvr(a, zzdtuVar, zzdtuVar2, zzcyx.a());
        this.f12341c = new zzcwy(zzcwxVar);
        zzbjy a2 = zzbjy.a();
        zzdtuVar3 = zzbkcVar.f14503i;
        this.f12342d = new zzcwa(a2, zzdtuVar3, this.f12341c, zzcyx.a());
        zzblj a3 = zzblj.a();
        zzcyx a4 = zzcyx.a();
        zzdtuVar4 = zzbkcVar.f14503i;
        this.f12343e = new zzcwe(a3, a4, zzdtuVar4);
        this.f12344f = new zzcwl(zzblk.a(), zzcyx.a(), this.f12341c);
        this.f12345g = new zzcxa(zzcwxVar);
        this.f12346h = new zzcwz(zzcwxVar);
        zzbll a5 = zzbll.a();
        zzdtuVar5 = zzbkcVar.f14499e;
        this.f12347i = new zzcws(a5, zzdtuVar5, this.f12345g, this.f12346h);
        zzblm a6 = zzblm.a();
        zzdtuVar6 = zzbkcVar.f14499e;
        zzdtuVar7 = zzbkcVar.f14503i;
        this.f12348j = new zzcww(a6, zzdtuVar6, zzdtuVar7);
        this.f12349k = new zzcxj(zzcyx.a());
        this.l = new zzcxb(zzcwxVar);
        this.m = zzdth.a(zzcet.a());
        this.n = zzdth.a(zzces.a());
        this.o = zzdth.a(zzceu.a());
        this.p = zzdth.a(zzcev.a());
        this.q = zzdtk.a(4).a(zzczs.GMS_SIGNALS, this.m).a(zzczs.BUILD_URL, this.n).a(zzczs.HTTP, this.o).a(zzczs.PRE_PROCESS, this.p).b();
        zzdtu<String> zzdtuVar10 = this.l;
        zzdtuVar8 = zzbkcVar.f14503i;
        this.r = zzdth.a(new zzcew(zzdtuVar10, zzdtuVar8, zzcyx.a(), this.q));
        zzdtq c2 = zzdtq.a(0, 1).b(this.r).c();
        this.s = c2;
        this.t = zzdab.a(c2);
        zzcyx a7 = zzcyx.a();
        zzdtuVar9 = zzbkcVar.f14499e;
        this.u = zzdth.a(zzdaa.a(a7, zzdtuVar9, this.t));
    }

    private final zzcwn d() {
        return new zzcwn(zzbli.a(), zzcyx.b(), (List) zzdto.b(this.a.e(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzcvu e() {
        return new zzcvu(zzbln.b(), zzcyx.b(), (String) zzdto.b(this.a.b(), "Cannot return null from a non-@Nullable @Provides method"), this.a.c());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzcvb<JSONObject> a() {
        zzdtu zzdtuVar;
        zzdtu zzdtuVar2;
        zzdtu zzdtuVar3;
        zzdtu zzdtuVar4;
        zzbjn zzbjnVar;
        zzdtu zzdtuVar5;
        zzbjn zzbjnVar2;
        zzdtu zzdtuVar6;
        zzdtu zzdtuVar7;
        zzdtu zzdtuVar8;
        zzbjn zzbjnVar3;
        zzbjn zzbjnVar4;
        zzdtu zzdtuVar9;
        zzbbl b2 = zzcyx.b();
        zzdtp d2 = zzdtp.d(11);
        zzcwj zzcwjVar = new zzcwj(zzblk.b(), zzcyx.b(), zzcwy.a(this.a));
        zzdtuVar = this.v.f14499e;
        zzdtp a = d2.a((zzcva) zzdto.b(new zzctz(zzcwjVar, 0L, (ScheduledExecutorService) zzdtuVar.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzamh b3 = zzbll.b();
        zzdtuVar2 = this.v.f14499e;
        zzcwq zzcwqVar = new zzcwq(b3, (ScheduledExecutorService) zzdtuVar2.get(), this.a.d(), zzcwz.a(this.a));
        zzdtuVar3 = this.v.f14499e;
        zzdtp a2 = a.a((zzcva) zzdto.b(new zzctz(zzcwqVar, ((Long) zzyt.e().c(zzacu.X2)).longValue(), (ScheduledExecutorService) zzdtuVar3.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzaql b4 = zzblm.b();
        zzdtuVar4 = this.v.f14499e;
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzdtuVar4.get();
        zzbjnVar = this.v.f14496b;
        zzcwu zzcwuVar = new zzcwu(b4, scheduledExecutorService, zzbjq.a(zzbjnVar));
        zzdtuVar5 = this.v.f14499e;
        zzdtp a3 = a2.a((zzcva) zzdto.b(new zzctz(zzcwuVar, ((Long) zzyt.e().c(zzacu.n3)).longValue(), (ScheduledExecutorService) zzdtuVar5.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzawi b5 = zzbln.b();
        zzbjnVar2 = this.v.f14496b;
        Context a4 = zzbjq.a(zzbjnVar2);
        zzdtuVar6 = this.v.f14499e;
        zzcvo zzcvoVar = new zzcvo(b5, a4, (ScheduledExecutorService) zzdtuVar6.get(), zzcyx.b());
        zzdtuVar7 = this.v.f14499e;
        zzdtp a5 = a3.a((zzcva) zzdto.b(new zzctz(zzcvoVar, 0L, (ScheduledExecutorService) zzdtuVar7.get()), "Cannot return null from a non-@Nullable @Provides method"));
        zzcxh zzcxhVar = new zzcxh(zzcyx.b());
        zzdtuVar8 = this.v.f14499e;
        zzdtp a6 = a5.a((zzcva) zzdto.b(new zzctz(zzcxhVar, 0L, (ScheduledExecutorService) zzdtuVar8.get()), "Cannot return null from a non-@Nullable @Provides method")).a(zzcxe.a());
        zzbjnVar3 = this.v.f14496b;
        zzdtp a7 = a6.a(new zzcvy(null, zzbjq.a(zzbjnVar3), zzcwy.a(this.a), zzcyx.b()));
        zzwa b6 = zzblj.b();
        zzbbl b7 = zzcyx.b();
        zzbjnVar4 = this.v.f14496b;
        zzdtp a8 = a7.a(new zzcwc(b6, b7, zzbjq.a(zzbjnVar4))).a(d()).a(e());
        zzdtuVar9 = this.v.r;
        return new zzcvb<>(b2, a8.a((zzcva) zzdtuVar9.get()).c());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzcvb<JSONObject> b() {
        zzdtu zzdtuVar;
        zzdtuVar = this.v.r;
        return zzcxf.a(zzdtuVar.get(), e(), d(), zzdth.b(this.f12340b), zzdth.b(this.f12342d), zzdth.b(this.f12343e), zzdth.b(this.f12344f), zzdth.b(this.f12347i), zzdth.b(this.f12348j), zzdth.b(this.f12349k), zzcyx.b());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzczt c() {
        return this.u.get();
    }
}
