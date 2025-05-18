package h.a;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes2.dex */
public abstract class r {
    static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    public static final class a implements h.a.x.c, Runnable {

        /* renamed from: f, reason: collision with root package name */
        final Runnable f21440f;

        /* renamed from: g, reason: collision with root package name */
        final b f21441g;

        /* renamed from: h, reason: collision with root package name */
        Thread f21442h;

        a(Runnable runnable, b bVar) {
            this.f21440f = runnable;
            this.f21441g = bVar;
        }

        @Override // h.a.x.c
        public void k() {
            if (this.f21442h == Thread.currentThread()) {
                b bVar = this.f21441g;
                if (bVar instanceof h.a.z.g.g) {
                    ((h.a.z.g.g) bVar).f();
                    return;
                }
            }
            this.f21441g.k();
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21441g.q();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21442h = Thread.currentThread();
            try {
                this.f21440f.run();
            } finally {
                k();
                this.f21442h = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    public static abstract class b implements h.a.x.c {
        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public h.a.x.c b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit);
    }

    public abstract b a();

    public h.a.x.c b(Runnable runnable) {
        return c(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
        b a2 = a();
        a aVar = new a(h.a.a0.a.q(runnable), a2);
        a2.c(aVar, j2, timeUnit);
        return aVar;
    }
}
