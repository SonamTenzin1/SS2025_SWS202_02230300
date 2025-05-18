package rx.n.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.h;

/* compiled from: ExecutorScheduler.java */
/* loaded from: classes3.dex */
public final class c extends rx.h {
    final Executor a;

    /* compiled from: ExecutorScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends h.a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final Executor f26651f;

        /* renamed from: h, reason: collision with root package name */
        final ConcurrentLinkedQueue<j> f26653h = new ConcurrentLinkedQueue<>();

        /* renamed from: i, reason: collision with root package name */
        final AtomicInteger f26654i = new AtomicInteger();

        /* renamed from: g, reason: collision with root package name */
        final rx.t.b f26652g = new rx.t.b();

        /* renamed from: j, reason: collision with root package name */
        final ScheduledExecutorService f26655j = d.a();

        /* compiled from: ExecutorScheduler.java */
        /* renamed from: rx.n.c.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0460a implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.t.c f26656f;

            C0460a(rx.t.c cVar) {
                this.f26656f = cVar;
            }

            @Override // rx.m.a
            public void call() {
                a.this.f26652g.d(this.f26656f);
            }
        }

        /* compiled from: ExecutorScheduler.java */
        /* loaded from: classes3.dex */
        class b implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.t.c f26658f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.m.a f26659g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ rx.k f26660h;

            b(rx.t.c cVar, rx.m.a aVar, rx.k kVar) {
                this.f26658f = cVar;
                this.f26659g = aVar;
                this.f26660h = kVar;
            }

            @Override // rx.m.a
            public void call() {
                if (this.f26658f.isUnsubscribed()) {
                    return;
                }
                rx.k c2 = a.this.c(this.f26659g);
                this.f26658f.a(c2);
                if (c2.getClass() == j.class) {
                    ((j) c2).b(this.f26660h);
                }
            }
        }

        public a(Executor executor) {
            this.f26651f = executor;
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            if (isUnsubscribed()) {
                return rx.t.e.c();
            }
            j jVar = new j(rx.q.c.q(aVar), this.f26652g);
            this.f26652g.a(jVar);
            this.f26653h.offer(jVar);
            if (this.f26654i.getAndIncrement() == 0) {
                try {
                    this.f26651f.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f26652g.d(jVar);
                    this.f26654i.decrementAndGet();
                    rx.q.c.j(e2);
                    throw e2;
                }
            }
            return jVar;
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            if (j2 <= 0) {
                return c(aVar);
            }
            if (isUnsubscribed()) {
                return rx.t.e.c();
            }
            rx.m.a q = rx.q.c.q(aVar);
            rx.t.c cVar = new rx.t.c();
            rx.t.c cVar2 = new rx.t.c();
            cVar2.a(cVar);
            this.f26652g.a(cVar2);
            rx.k a = rx.t.e.a(new C0460a(cVar2));
            j jVar = new j(new b(cVar2, q, a));
            cVar.a(jVar);
            try {
                jVar.a(this.f26655j.schedule(jVar, j2, timeUnit));
                return a;
            } catch (RejectedExecutionException e2) {
                rx.q.c.j(e2);
                throw e2;
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26652g.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f26652g.isUnsubscribed()) {
                j poll = this.f26653h.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f26652g.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f26653h.clear();
                        return;
                    }
                }
                if (this.f26654i.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f26653h.clear();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f26652g.unsubscribe();
            this.f26653h.clear();
        }
    }

    public c(Executor executor) {
        this.a = executor;
    }

    @Override // rx.h
    public h.a createWorker() {
        return new a(this.a);
    }
}
