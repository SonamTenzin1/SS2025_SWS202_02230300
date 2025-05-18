package rx.n.c;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;

/* compiled from: CachedThreadScheduler.java */
/* loaded from: classes3.dex */
public final class a extends rx.h implements k {

    /* renamed from: f, reason: collision with root package name */
    private static final long f26616f;

    /* renamed from: g, reason: collision with root package name */
    private static final TimeUnit f26617g = TimeUnit.SECONDS;

    /* renamed from: h, reason: collision with root package name */
    static final c f26618h;

    /* renamed from: i, reason: collision with root package name */
    static final C0454a f26619i;

    /* renamed from: j, reason: collision with root package name */
    final ThreadFactory f26620j;

    /* renamed from: k, reason: collision with root package name */
    final AtomicReference<C0454a> f26621k = new AtomicReference<>(f26619i);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: rx.n.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0454a {
        private final ThreadFactory a;

        /* renamed from: b, reason: collision with root package name */
        private final long f26622b;

        /* renamed from: c, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f26623c;

        /* renamed from: d, reason: collision with root package name */
        private final rx.t.b f26624d;

        /* renamed from: e, reason: collision with root package name */
        private final ScheduledExecutorService f26625e;

        /* renamed from: f, reason: collision with root package name */
        private final Future<?> f26626f;

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.n.c.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class ThreadFactoryC0455a implements ThreadFactory {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ ThreadFactory f26627f;

            ThreadFactoryC0455a(ThreadFactory threadFactory) {
                this.f26627f = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f26627f.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.n.c.a$a$b */
        /* loaded from: classes3.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0454a.this.a();
            }
        }

        C0454a(ThreadFactory threadFactory, long j2, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f26622b = nanos;
            this.f26623c = new ConcurrentLinkedQueue<>();
            this.f26624d = new rx.t.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC0455a(threadFactory));
                h.m(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f26625e = scheduledExecutorService;
            this.f26626f = scheduledFuture;
        }

        void a() {
            if (this.f26623c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f26623c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.n() > c2) {
                    return;
                }
                if (this.f26623c.remove(next)) {
                    this.f26624d.d(next);
                }
            }
        }

        c b() {
            if (this.f26624d.isUnsubscribed()) {
                return a.f26618h;
            }
            while (!this.f26623c.isEmpty()) {
                c poll = this.f26623c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.a);
            this.f26624d.a(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.o(c() + this.f26622b);
            this.f26623c.offer(cVar);
        }

        void e() {
            try {
                Future<?> future = this.f26626f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f26625e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.f26624d.unsubscribe();
            }
        }
    }

    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: classes3.dex */
    static final class b extends h.a implements rx.m.a {

        /* renamed from: g, reason: collision with root package name */
        private final C0454a f26631g;

        /* renamed from: h, reason: collision with root package name */
        private final c f26632h;

        /* renamed from: f, reason: collision with root package name */
        private final rx.t.b f26630f = new rx.t.b();

        /* renamed from: i, reason: collision with root package name */
        final AtomicBoolean f26633i = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.n.c.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0456a implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.m.a f26634f;

            C0456a(rx.m.a aVar) {
                this.f26634f = aVar;
            }

            @Override // rx.m.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f26634f.call();
            }
        }

        b(C0454a c0454a) {
            this.f26631g = c0454a;
            this.f26632h = c0454a.b();
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            return d(aVar, 0L, null);
        }

        @Override // rx.m.a
        public void call() {
            this.f26631g.d(this.f26632h);
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            if (this.f26630f.isUnsubscribed()) {
                return rx.t.e.c();
            }
            j j3 = this.f26632h.j(new C0456a(aVar), j2, timeUnit);
            this.f26630f.a(j3);
            j3.c(this.f26630f);
            return j3;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26630f.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.f26633i.compareAndSet(false, true)) {
                this.f26632h.c(this);
            }
            this.f26630f.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends h {
        private long n;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.n = 0L;
        }

        public long n() {
            return this.n;
        }

        public void o(long j2) {
            this.n = j2;
        }
    }

    static {
        c cVar = new c(rx.n.e.i.f26748f);
        f26618h = cVar;
        cVar.unsubscribe();
        C0454a c0454a = new C0454a(null, 0L, null);
        f26619i = c0454a;
        c0454a.e();
        f26616f = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f26620j = threadFactory;
        start();
    }

    @Override // rx.h
    public h.a createWorker() {
        return new b(this.f26621k.get());
    }

    @Override // rx.n.c.k
    public void shutdown() {
        C0454a c0454a;
        C0454a c0454a2;
        do {
            c0454a = this.f26621k.get();
            c0454a2 = f26619i;
            if (c0454a == c0454a2) {
                return;
            }
        } while (!this.f26621k.compareAndSet(c0454a, c0454a2));
        c0454a.e();
    }

    @Override // rx.n.c.k
    public void start() {
        C0454a c0454a = new C0454a(this.f26620j, f26616f, f26617g);
        if (this.f26621k.compareAndSet(f26619i, c0454a)) {
            return;
        }
        c0454a.e();
    }
}
