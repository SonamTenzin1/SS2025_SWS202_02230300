package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcle implements zzcjv<zzbvx> {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcdn f15361b;

    /* renamed from: c, reason: collision with root package name */
    private final zzbws f15362c;

    /* renamed from: d, reason: collision with root package name */
    private final zzcxv f15363d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f15364e;

    /* renamed from: f, reason: collision with root package name */
    private final zzbai f15365f;

    public zzcle(Context context, zzbai zzbaiVar, zzcxv zzcxvVar, Executor executor, zzbws zzbwsVar, zzcdn zzcdnVar) {
        this.a = context;
        this.f15363d = zzcxvVar;
        this.f15362c = zzbwsVar;
        this.f15364e = executor;
        this.f15365f = zzbaiVar;
        this.f15361b = zzcdnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<zzbvx> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        final zzced zzcedVar = new zzced();
        zzbbh<zzbvx> c2 = zzbar.c(zzbar.o(null), new zzbal(this, zzcxmVar, zzcedVar, zzcxuVar) { // from class: com.google.android.gms.internal.ads.uk
            private final zzcle a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcxm f13399b;

            /* renamed from: c, reason: collision with root package name */
            private final zzced f13400c;

            /* renamed from: d, reason: collision with root package name */
            private final zzcxu f13401d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f13399b = zzcxmVar;
                this.f13400c = zzcedVar;
                this.f13401d = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.c(this.f13399b, this.f13400c, this.f13401d, obj);
            }
        }, this.f15364e);
        c2.k(vk.a(zzcedVar), this.f15364e);
        return c2;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzcxq zzcxqVar = zzcxmVar.p;
        return (zzcxqVar == null || zzcxqVar.a == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh c(final zzcxm zzcxmVar, zzced zzcedVar, zzcxu zzcxuVar, Object obj) throws Exception {
        final zzbgz b2 = this.f15361b.b(this.f15363d.f15751e);
        b2.x(zzcxmVar.M);
        zzcedVar.a(this.a, b2.getView());
        final zzbbr zzbbrVar = new zzbbr();
        final zzbvy a = this.f15362c.a(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbvz(new zzbwz(this, b2, zzcxmVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.wk
            private final zzcle a;

            /* renamed from: b, reason: collision with root package name */
            private final zzbgz f13512b;

            /* renamed from: c, reason: collision with root package name */
            private final zzcxm f13513c;

            /* renamed from: d, reason: collision with root package name */
            private final zzbbr f13514d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f13512b = b2;
                this.f13513c = zzcxmVar;
                this.f13514d = zzbbrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                this.a.d(this.f13512b, this.f13513c, this.f13514d, z, context);
            }
        }, b2));
        zzbbrVar.a(a);
        zzbrt d2 = a.d();
        zzbrw zzbrwVar = new zzbrw(b2) { // from class: com.google.android.gms.internal.ads.xk

            /* renamed from: f, reason: collision with root package name */
            private final zzbgz f13582f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13582f = b2;
            }

            @Override // com.google.android.gms.internal.ads.zzbrw
            public final void onAdImpression() {
                zzbgz zzbgzVar = this.f13582f;
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
            a2.k(new Runnable(b2) { // from class: com.google.android.gms.internal.ads.yk

                /* renamed from: f, reason: collision with root package name */
                private final zzbgz f13646f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13646f = b2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13646f.l0();
                }
            }, this.f15364e);
        }
        a2.k(new Runnable(b2) { // from class: com.google.android.gms.internal.ads.zk

            /* renamed from: f, reason: collision with root package name */
            private final zzbgz f13715f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13715f = b2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13715f.O();
            }
        }, this.f15364e);
        return zzbar.d(a2, new zzbam(a) { // from class: com.google.android.gms.internal.ads.al
            private final zzbvy a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = a;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj2) {
                return this.a.h();
            }
        }, executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(zzbgz zzbgzVar, zzcxm zzcxmVar, zzbbr zzbbrVar, boolean z, Context context) {
        try {
            zzbgzVar.j0(true);
            zzk.zzlg();
            com.google.android.gms.ads.internal.zzh zzhVar = new com.google.android.gms.ads.internal.zzh(false, zzaxi.H(this.a), false, 0.0f, -1, z, zzcxmVar.F, false);
            zzk.zzlf();
            com.google.android.gms.ads.internal.overlay.zzm.zza(context, new AdOverlayInfoParcel(null, ((zzbvy) zzbbrVar.get()).j(), null, zzbgzVar, zzcxmVar.H, this.f15365f, zzcxmVar.y, zzhVar), true);
        } catch (Exception unused) {
        }
    }
}
