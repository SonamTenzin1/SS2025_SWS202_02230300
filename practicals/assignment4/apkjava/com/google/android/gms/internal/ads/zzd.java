package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class zzd extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f15810f = zzag.f13871b;

    /* renamed from: g, reason: collision with root package name */
    private final BlockingQueue<zzr<?>> f15811g;

    /* renamed from: h, reason: collision with root package name */
    private final BlockingQueue<zzr<?>> f15812h;

    /* renamed from: i, reason: collision with root package name */
    private final zzb f15813i;

    /* renamed from: j, reason: collision with root package name */
    private final zzab f15814j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f15815k = false;
    private final uy l = new uy(this);

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb zzbVar, zzab zzabVar) {
        this.f15811g = blockingQueue;
        this.f15812h = blockingQueue2;
        this.f15813i = zzbVar;
        this.f15814j = zzabVar;
    }

    private final void a() throws InterruptedException {
        zzr<?> take = this.f15811g.take();
        take.I("cache-queue-take");
        take.A(1);
        try {
            take.u();
            zzc u = this.f15813i.u(take.M());
            if (u == null) {
                take.I("cache-miss");
                if (!uy.c(this.l, take)) {
                    this.f15812h.put(take);
                }
                return;
            }
            if (u.a()) {
                take.I("cache-hit-expired");
                take.v(u);
                if (!uy.c(this.l, take)) {
                    this.f15812h.put(take);
                }
                return;
            }
            take.I("cache-hit");
            zzy<?> y = take.y(new zzp(u.a, u.f14951g));
            take.I("cache-hit-parsed");
            if (!(u.f14950f < System.currentTimeMillis())) {
                this.f15814j.c(take, y);
            } else {
                take.I("cache-hit-refresh-needed");
                take.v(u);
                y.f16976d = true;
                if (!uy.c(this.l, take)) {
                    this.f15814j.b(take, y, new my(this, take));
                } else {
                    this.f15814j.c(take, y);
                }
            }
        } finally {
            take.A(2);
        }
    }

    public final void b() {
        this.f15815k = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (f15810f) {
            zzag.c("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f15813i.a();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f15815k) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.b("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
