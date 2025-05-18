package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class zzn extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private final BlockingQueue<zzr<?>> f16490f;

    /* renamed from: g, reason: collision with root package name */
    private final zzm f16491g;

    /* renamed from: h, reason: collision with root package name */
    private final zzb f16492h;

    /* renamed from: i, reason: collision with root package name */
    private final zzab f16493i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f16494j = false;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm zzmVar, zzb zzbVar, zzab zzabVar) {
        this.f16490f = blockingQueue;
        this.f16491g = zzmVar;
        this.f16492h = zzbVar;
        this.f16493i = zzabVar;
    }

    private final void a() throws InterruptedException {
        zzr<?> take = this.f16490f.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.A(3);
        try {
            take.I("network-queue-take");
            take.u();
            TrafficStats.setThreadStatsTag(take.K());
            zzp a = this.f16491g.a(take);
            take.I("network-http-complete");
            if (a.f16555e && take.T()) {
                take.J("not-modified");
                take.U();
                return;
            }
            zzy<?> y = take.y(a);
            take.I("network-parse-complete");
            if (take.P() && y.f16974b != null) {
                this.f16492h.v(take.M(), y.f16974b);
                take.I("network-cache-written");
            }
            take.S();
            this.f16493i.c(take, y);
            take.E(y);
        } catch (Exception e2) {
            zzag.e(e2, "Unhandled exception %s", e2.toString());
            zzaf zzafVar = new zzaf(e2);
            zzafVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f16493i.a(take, zzafVar);
            take.U();
        } catch (zzaf e3) {
            e3.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.f16493i.a(take, e3);
            take.U();
        } finally {
            take.A(4);
        }
    }

    public final void b() {
        this.f16494j = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.f16494j) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.b("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
