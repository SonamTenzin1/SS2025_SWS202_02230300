package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbzg implements zzdti<zzavf> {
    private final zzbzf a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f14906b;

    /* renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f14907c;

    private zzbzg(zzbzf zzbzfVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.a = zzbzfVar;
        this.f14906b = zzdtuVar;
        this.f14907c = zzdtuVar2;
    }

    public static zzbzg a(zzbzf zzbzfVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        return new zzbzg(zzbzfVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.b(new zzavf(this.f14906b.get(), this.f14907c.get().f15752f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
