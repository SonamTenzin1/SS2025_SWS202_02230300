package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcac implements zzbrw {

    /* renamed from: f, reason: collision with root package name */
    private final zzbyt f14957f;

    /* renamed from: g, reason: collision with root package name */
    private final zzbyx f14958g;

    public zzcac(zzbyt zzbytVar, zzbyx zzbyxVar) {
        this.f14957f = zzbytVar;
        this.f14958g = zzbyxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void onAdImpression() {
        if (this.f14957f.C() == null) {
            return;
        }
        zzbgz B = this.f14957f.B();
        zzbgz A = this.f14957f.A();
        if (B == null) {
            B = A != null ? A : null;
        }
        if (!this.f14958g.d() || B == null) {
            return;
        }
        B.y("onSdkImpression", new c.e.a());
    }
}
