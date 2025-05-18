package h.a.z.g;

import h.a.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes2.dex */
public class g extends r.b implements h.a.x.c {

    /* renamed from: f, reason: collision with root package name */
    private final ScheduledExecutorService f21697f;

    /* renamed from: g, reason: collision with root package name */
    volatile boolean f21698g;

    public g(ThreadFactory threadFactory) {
        this.f21697f = k.a(threadFactory);
    }

    @Override // h.a.r.b
    public h.a.x.c b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // h.a.r.b
    public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (this.f21698g) {
            return h.a.z.a.d.INSTANCE;
        }
        return d(runnable, j2, timeUnit, null);
    }

    public j d(Runnable runnable, long j2, TimeUnit timeUnit, h.a.z.a.b bVar) {
        Future<?> schedule;
        j jVar = new j(h.a.a0.a.q(runnable), bVar);
        if (bVar != null && !bVar.b(jVar)) {
            return jVar;
        }
        try {
            if (j2 <= 0) {
                schedule = this.f21697f.submit((Callable) jVar);
            } else {
                schedule = this.f21697f.schedule((Callable) jVar, j2, timeUnit);
            }
            jVar.a(schedule);
        } catch (RejectedExecutionException e2) {
            if (bVar != null) {
                bVar.a(jVar);
            }
            h.a.a0.a.o(e2);
        }
        return jVar;
    }

    public h.a.x.c e(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        i iVar = new i(h.a.a0.a.q(runnable));
        try {
            if (j2 <= 0) {
                schedule = this.f21697f.submit(iVar);
            } else {
                schedule = this.f21697f.schedule(iVar, j2, timeUnit);
            }
            iVar.a(schedule);
            return iVar;
        } catch (RejectedExecutionException e2) {
            h.a.a0.a.o(e2);
            return h.a.z.a.d.INSTANCE;
        }
    }

    public void f() {
        if (this.f21698g) {
            return;
        }
        this.f21698g = true;
        this.f21697f.shutdown();
    }

    @Override // h.a.x.c
    public void k() {
        if (this.f21698g) {
            return;
        }
        this.f21698g = true;
        this.f21697f.shutdownNow();
    }

    @Override // h.a.x.c
    public boolean q() {
        return this.f21698g;
    }
}
