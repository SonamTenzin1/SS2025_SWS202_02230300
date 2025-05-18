package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzbpk {
    private final Executor a;

    /* renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f14666b;

    /* renamed from: c, reason: collision with root package name */
    private final zzbbh<zzbph> f14667c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f14668d = true;

    public zzbpk(Executor executor, ScheduledExecutorService scheduledExecutorService, zzbbh<zzbph> zzbbhVar) {
        this.a = executor;
        this.f14666b = scheduledExecutorService;
        this.f14667c = zzbbhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(List<? extends zzbbh<? extends zzbpc>> list, final zzban<zzbpc> zzbanVar) {
        if (list != null && !list.isEmpty()) {
            zzbbh o = zzbar.o(null);
            for (final zzbbh<? extends zzbpc> zzbbhVar : list) {
                o = zzbar.c(zzbar.e(o, Throwable.class, new zzbal(zzbanVar) { // from class: com.google.android.gms.internal.ads.id
                    private final zzban a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = zzbanVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbal
                    public final zzbbh zzf(Object obj) {
                        this.a.a((Throwable) obj);
                        return zzbar.o(null);
                    }
                }, this.a), new zzbal(this, zzbanVar, zzbbhVar) { // from class: com.google.android.gms.internal.ads.jd
                    private final zzbpk a;

                    /* renamed from: b, reason: collision with root package name */
                    private final zzban f12824b;

                    /* renamed from: c, reason: collision with root package name */
                    private final zzbbh f12825c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                        this.f12824b = zzbanVar;
                        this.f12825c = zzbbhVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbal
                    public final zzbbh zzf(Object obj) {
                        return this.a.b(this.f12824b, this.f12825c, (zzbpc) obj);
                    }
                }, this.a);
            }
            zzbar.f(o, new ld(this, zzbanVar), this.a);
            return;
        }
        this.a.execute(new Runnable(zzbanVar) { // from class: com.google.android.gms.internal.ads.hd

            /* renamed from: f, reason: collision with root package name */
            private final zzban f12713f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12713f = zzbanVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12713f.a(new zzcgm(3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.f14668d = false;
    }

    public final boolean a() {
        return this.f14668d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh b(zzban zzbanVar, zzbbh zzbbhVar, zzbpc zzbpcVar) throws Exception {
        if (zzbpcVar != null) {
            zzbanVar.b(zzbpcVar);
        }
        return zzbar.b(zzbbhVar, ((Long) zzyt.e().c(zzacu.e2)).longValue(), TimeUnit.MILLISECONDS, this.f14666b);
    }

    public final void c(zzban<zzbpc> zzbanVar) {
        zzbar.f(this.f14667c, new kd(this, zzbanVar), this.a);
    }
}
