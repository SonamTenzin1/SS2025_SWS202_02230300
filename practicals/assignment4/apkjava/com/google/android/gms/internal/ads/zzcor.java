package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcor<AdT> implements zzcjv<AdT> {
    private final zzado a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbbl f15481b;

    /* renamed from: c, reason: collision with root package name */
    private final zzczt f15482c;

    /* renamed from: d, reason: collision with root package name */
    private final zzcou<AdT> f15483d;

    public zzcor(zzczt zzcztVar, zzbbl zzbblVar, zzado zzadoVar, zzcou<AdT> zzcouVar) {
        this.f15482c = zzcztVar;
        this.f15481b = zzbblVar;
        this.a = zzadoVar;
        this.f15483d = zzcouVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdT> a(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzbbr zzbbrVar = new zzbbr();
        zzcoz zzcozVar = new zzcoz();
        zzcozVar.a(new pm(this, zzbbrVar, zzcxuVar, zzcxmVar, zzcozVar));
        zzcxq zzcxqVar = zzcxmVar.p;
        final zzadj zzadjVar = new zzadj(zzcozVar, zzcxqVar.f15741b, zzcxqVar.a);
        return this.f15482c.g(zzczs.CUSTOM_RENDER_SYN).a(new zzczd(this, zzadjVar) { // from class: com.google.android.gms.internal.ads.om
            private final zzcor a;

            /* renamed from: b, reason: collision with root package name */
            private final zzadj f13110b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f13110b = zzadjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczd
            public final void run() {
                this.a.d(this.f13110b);
            }
        }, this.f15481b).j(zzczs.CUSTOM_RENDER_ACK).g(zzbbrVar).f();
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzcxq zzcxqVar;
        return (this.a == null || (zzcxqVar = zzcxmVar.p) == null || zzcxqVar.a == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(zzadj zzadjVar) throws Exception {
        this.a.O2(zzadjVar);
    }
}
