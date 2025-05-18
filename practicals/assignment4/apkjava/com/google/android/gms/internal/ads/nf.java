package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class nf implements zzbpe<zzbph> {
    private final Map<String, zzcjv<zzbph>> a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, zzcjv<zzbyn>> f13050b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, zzclw<zzbyn>> f13051c;

    /* renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbpe<zzbnf>> f13052d;

    /* renamed from: e, reason: collision with root package name */
    private final zzbzc f13053e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public nf(Map<String, zzcjv<zzbph>> map, Map<String, zzcjv<zzbyn>> map2, Map<String, zzclw<zzbyn>> map3, zzdtu<zzbpe<zzbnf>> zzdtuVar, zzbzc zzbzcVar) {
        this.a = map;
        this.f13050b = map2;
        this.f13051c = map3;
        this.f13052d = zzdtuVar;
        this.f13053e = zzbzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final zzcjv<zzbph> a(int i2, String str) {
        zzcjv<zzbnf> a;
        zzcjv<zzbph> zzcjvVar = this.a.get(str);
        if (zzcjvVar != null) {
            return zzcjvVar;
        }
        if (i2 == 1) {
            if (this.f13053e.d() == null || (a = this.f13052d.get().a(i2, str)) == null) {
                return null;
            }
            return zzbph.a(a);
        }
        if (i2 != 4) {
            return null;
        }
        zzclw<zzbyn> zzclwVar = this.f13051c.get(str);
        if (zzclwVar != null) {
            return zzbph.b(zzclwVar);
        }
        zzcjv<zzbyn> zzcjvVar2 = this.f13050b.get(str);
        if (zzcjvVar2 != null) {
            return zzbph.a(zzcjvVar2);
        }
        return null;
    }
}
