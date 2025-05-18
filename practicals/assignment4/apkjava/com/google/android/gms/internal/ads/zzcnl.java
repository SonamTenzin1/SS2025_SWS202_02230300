package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcnl implements zzcjv<zzcdb> {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcdn f15442b;

    /* renamed from: c, reason: collision with root package name */
    private final zzcdf f15443c;

    /* renamed from: d, reason: collision with root package name */
    private final zzcxv f15444d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f15445e;

    /* renamed from: f, reason: collision with root package name */
    private final zzbai f15446f;

    public zzcnl(Context context, zzbai zzbaiVar, zzcxv zzcxvVar, Executor executor, zzcdf zzcdfVar, zzcdn zzcdnVar) {
        this.a = context;
        this.f15444d = zzcxvVar;
        this.f15443c = zzcdfVar;
        this.f15445e = executor;
        this.f15446f = zzbaiVar;
        this.f15442b = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzcdb> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        final zzced zzcedVar = new zzced();
        zzbbh<zzcdb> c2 = zzbar.c(zzbar.o(null), new zzbal(this, zzcxmVar, zzcedVar, zzcxuVar) { // from class: com.google.android.gms.internal.ads.ul
            private final zzcnl a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcxm f13402b;

            /* renamed from: c, reason: collision with root package name */
            private final zzced f13403c;

            /* renamed from: d, reason: collision with root package name */
            private final zzcxu f13404d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f13402b = zzcxmVar;
                this.f13403c = zzcedVar;
                this.f13404d = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.c(this.f13402b, this.f13403c, this.f13404d, obj);
            }
        }, this.f15445e);
        c2.k(vl.a(zzcedVar), this.f15445e);
        return c2;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzcxq zzcxqVar = zzcxmVar.p;
        return (zzcxqVar == null || zzcxqVar.a == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh c(final zzcxm zzcxmVar, zzced zzcedVar, zzcxu zzcxuVar, Object obj) throws Exception {
        final zzbgz b2 = this.f15442b.b(this.f15444d.f15751e);
        b2.x(zzcxmVar.M);
        zzcedVar.a(this.a, b2.getView());
        final zzbbr zzbbrVar = new zzbbr();
        final zzcdc a = this.f15443c.a(new zzbpr(zzcxuVar, zzcxmVar, null), new zzcdd(new zzbwz(this, b2, zzcxmVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.yl
            private final zzcnl a;

            /* renamed from: b, reason: collision with root package name */
            private final zzbgz f13647b;

            /* renamed from: c, reason: collision with root package name */
            private final zzcxm f13648c;

            /* renamed from: d, reason: collision with root package name */
            private final zzbbr f13649d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f13647b = b2;
                this.f13648c = zzcxmVar;
                this.f13649d = zzbbrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                this.a.d(this.f13647b, this.f13648c, this.f13649d, z, context);
            }
        }, b2));
        zzbbrVar.a(a);
        zzahx.b(b2, a.k());
        zzbrt d2 = a.d();
        zzbrw zzbrwVar = new zzbrw(b2) { // from class: com.google.android.gms.internal.ads.zl

            /* renamed from: f, reason: collision with root package name */
            private final zzbgz f13716f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13716f = b2;
            }

            @Override // com.google.android.gms.internal.ads.zzbrw
            public final void onAdImpression() {
                zzbgz zzbgzVar = this.f13716f;
                if (zzbgzVar.p() != null) {
                    zzbgzVar.p().e();
                }
            }
        };
        Executor executor = zzbbm.f14331b;
        d2.V(zzbrwVar, executor);
        a.g().i(b2, true);
        a.g();
        zzcxq zzcxqVar = zzcxmVar.p;
        zzbbh<?> a2 = zzcdp.a(b2, zzcxqVar.f15741b, zzcxqVar.a);
        if (zzcxmVar.E) {
            a2.k(new Runnable(b2) { // from class: com.google.android.gms.internal.ads.am

                /* renamed from: f, reason: collision with root package name */
                private final zzbgz f12260f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12260f = b2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12260f.l0();
                }
            }, this.f15445e);
        }
        a2.k(new Runnable(b2) { // from class: com.google.android.gms.internal.ads.bm

            /* renamed from: f, reason: collision with root package name */
            private final zzbgz f12355f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12355f = b2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12355f.O();
            }
        }, this.f15445e);
        return zzbar.d(a2, new zzbam(a) { // from class: com.google.android.gms.internal.ads.cm
            private final zzcdc a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = a;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj2) {
                return this.a.j();
            }
        }, executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(zzbgz zzbgzVar, zzcxm zzcxmVar, zzbbr zzbbrVar, boolean z, Context context) {
        zzbgz zzbgzVar2;
        try {
            zzcdc zzcdcVar = (zzcdc) zzbbrVar.get();
            if (zzbgzVar.p0()) {
                if (((Boolean) zzyt.e().c(zzacu.X0)).booleanValue()) {
                    final zzbgz b2 = this.f15442b.b(this.f15444d.f15751e);
                    zzahx.b(b2, zzcdcVar.k());
                    final zzced zzcedVar = new zzced();
                    zzcedVar.a(this.a, b2.getView());
                    zzcdcVar.g().i(b2, true);
                    b2.p().i(new zzbij(zzcedVar, b2) { // from class: com.google.android.gms.internal.ads.wl
                        private final zzced a;

                        /* renamed from: b, reason: collision with root package name */
                        private final zzbgz f13515b;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = zzcedVar;
                            this.f13515b = b2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbij
                        public final void zzae(boolean z2) {
                            zzced zzcedVar2 = this.a;
                            zzbgz zzbgzVar3 = this.f13515b;
                            zzcedVar2.b();
                            zzbgzVar3.O();
                            zzbgzVar3.p().e();
                        }
                    });
                    b2.p().j(xl.b(b2));
                    zzcxq zzcxqVar = zzcxmVar.p;
                    b2.G(zzcxqVar.f15741b, zzcxqVar.a, null);
                    zzbgzVar2 = b2;
                    zzbgzVar2.j0(true);
                    zzk.zzlg();
                    com.google.android.gms.ads.internal.zzh zzhVar = new com.google.android.gms.ads.internal.zzh(false, zzaxi.H(this.a), false, 0.0f, -1, z, zzcxmVar.F, zzcxmVar.G);
                    zzk.zzlf();
                    com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzcdc) zzbbrVar.get()).i(), null, zzbgzVar2, zzcxmVar.H, this.f15446f, zzcxmVar.y, zzhVar), true);
                }
            }
            zzbgzVar2 = zzbgzVar;
            zzbgzVar2.j0(true);
            zzk.zzlg();
            com.google.android.gms.ads.internal.zzh zzhVar2 = new com.google.android.gms.ads.internal.zzh(false, zzaxi.H(this.a), false, 0.0f, -1, z, zzcxmVar.F, zzcxmVar.G);
            zzk.zzlf();
            com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzcdc) zzbbrVar.get()).i(), null, zzbgzVar2, zzcxmVar.H, this.f15446f, zzcxmVar.y, zzhVar2), true);
        } catch (Exception unused) {
        }
    }
}
