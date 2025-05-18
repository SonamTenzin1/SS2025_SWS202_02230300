package h.a.z.g;

import h.a.r;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes2.dex */
public final class m extends r {

    /* renamed from: b, reason: collision with root package name */
    private static final m f21717b = new m();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes2.dex */
    static final class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final Runnable f21718f;

        /* renamed from: g, reason: collision with root package name */
        private final c f21719g;

        /* renamed from: h, reason: collision with root package name */
        private final long f21720h;

        a(Runnable runnable, c cVar, long j2) {
            this.f21718f = runnable;
            this.f21719g = cVar;
            this.f21720h = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21719g.f21728i) {
                return;
            }
            long a = this.f21719g.a(TimeUnit.MILLISECONDS);
            long j2 = this.f21720h;
            if (j2 > a) {
                try {
                    Thread.sleep(j2 - a);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    h.a.a0.a.o(e2);
                    return;
                }
            }
            if (this.f21719g.f21728i) {
                return;
            }
            this.f21718f.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes2.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: f, reason: collision with root package name */
        final Runnable f21721f;

        /* renamed from: g, reason: collision with root package name */
        final long f21722g;

        /* renamed from: h, reason: collision with root package name */
        final int f21723h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f21724i;

        b(Runnable runnable, Long l, int i2) {
            this.f21721f = runnable;
            this.f21722g = l.longValue();
            this.f21723h = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int b2 = h.a.z.b.b.b(this.f21722g, bVar.f21722g);
            return b2 == 0 ? h.a.z.b.b.a(this.f21723h, bVar.f21723h) : b2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes2.dex */
    static final class c extends r.b implements h.a.x.c {

        /* renamed from: f, reason: collision with root package name */
        final PriorityBlockingQueue<b> f21725f = new PriorityBlockingQueue<>();

        /* renamed from: g, reason: collision with root package name */
        private final AtomicInteger f21726g = new AtomicInteger();

        /* renamed from: h, reason: collision with root package name */
        final AtomicInteger f21727h = new AtomicInteger();

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f21728i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes2.dex */
        public final class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final b f21729f;

            a(b bVar) {
                this.f21729f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f21729f.f21724i = true;
                c.this.f21725f.remove(this.f21729f);
            }
        }

        c() {
        }

        @Override // h.a.r.b
        public h.a.x.c b(Runnable runnable) {
            return d(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // h.a.r.b
        public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return d(new a(runnable, this, a2), a2);
        }

        h.a.x.c d(Runnable runnable, long j2) {
            if (this.f21728i) {
                return h.a.z.a.d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j2), this.f21727h.incrementAndGet());
            this.f21725f.add(bVar);
            if (this.f21726g.getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f21728i) {
                    b poll = this.f21725f.poll();
                    if (poll == null) {
                        i2 = this.f21726g.addAndGet(-i2);
                        if (i2 == 0) {
                            return h.a.z.a.d.INSTANCE;
                        }
                    } else if (!poll.f21724i) {
                        poll.f21721f.run();
                    }
                }
                this.f21725f.clear();
                return h.a.z.a.d.INSTANCE;
            }
            return h.a.x.d.d(new a(bVar));
        }

        @Override // h.a.x.c
        public void k() {
            this.f21728i = true;
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21728i;
        }
    }

    m() {
    }

    public static m d() {
        return f21717b;
    }

    @Override // h.a.r
    public r.b a() {
        return new c();
    }

    @Override // h.a.r
    public h.a.x.c b(Runnable runnable) {
        h.a.a0.a.q(runnable).run();
        return h.a.z.a.d.INSTANCE;
    }

    @Override // h.a.r
    public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            h.a.a0.a.q(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            h.a.a0.a.o(e2);
        }
        return h.a.z.a.d.INSTANCE;
    }
}
