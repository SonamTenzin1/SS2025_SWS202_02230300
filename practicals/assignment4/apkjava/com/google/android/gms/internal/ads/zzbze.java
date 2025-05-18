package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbze {
    zzafl a;

    /* renamed from: b, reason: collision with root package name */
    zzafi f14900b;

    /* renamed from: c, reason: collision with root package name */
    zzafx f14901c;

    /* renamed from: d, reason: collision with root package name */
    zzafu f14902d;

    /* renamed from: e, reason: collision with root package name */
    zzaje f14903e;

    /* renamed from: f, reason: collision with root package name */
    final c.e.g<String, zzafr> f14904f = new c.e.g<>();

    /* renamed from: g, reason: collision with root package name */
    final c.e.g<String, zzafo> f14905g = new c.e.g<>();

    public final zzbze a(zzafu zzafuVar) {
        this.f14902d = zzafuVar;
        return this;
    }

    public final zzbzc b() {
        return new zzbzc(this);
    }

    public final zzbze c(zzafi zzafiVar) {
        this.f14900b = zzafiVar;
        return this;
    }

    public final zzbze d(zzafl zzaflVar) {
        this.a = zzaflVar;
        return this;
    }

    public final zzbze e(zzafx zzafxVar) {
        this.f14901c = zzafxVar;
        return this;
    }

    public final zzbze f(zzaje zzajeVar) {
        this.f14903e = zzajeVar;
        return this;
    }

    public final zzbze g(String str, zzafr zzafrVar, zzafo zzafoVar) {
        this.f14904f.put(str, zzafrVar);
        this.f14905g.put(str, zzafoVar);
        return this;
    }
}
