package rx.n.c;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: ScheduledAction.java */
/* loaded from: classes3.dex */
public final class j extends AtomicReference<Thread> implements Runnable, rx.k {

    /* renamed from: f, reason: collision with root package name */
    final rx.n.e.l f26683f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.a f26684g;

    /* compiled from: ScheduledAction.java */
    /* loaded from: classes3.dex */
    final class a implements rx.k {

        /* renamed from: f, reason: collision with root package name */
        private final Future<?> f26685f;

        a(Future<?> future) {
            this.f26685f = future;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26685f.isCancelled();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (j.this.get() != Thread.currentThread()) {
                this.f26685f.cancel(true);
            } else {
                this.f26685f.cancel(false);
            }
        }
    }

    /* compiled from: ScheduledAction.java */
    /* loaded from: classes3.dex */
    static final class b extends AtomicBoolean implements rx.k {

        /* renamed from: f, reason: collision with root package name */
        final j f26687f;

        /* renamed from: g, reason: collision with root package name */
        final rx.n.e.l f26688g;

        public b(j jVar, rx.n.e.l lVar) {
            this.f26687f = jVar;
            this.f26688g = lVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26687f.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f26688g.b(this.f26687f);
            }
        }
    }

    /* compiled from: ScheduledAction.java */
    /* loaded from: classes3.dex */
    static final class c extends AtomicBoolean implements rx.k {

        /* renamed from: f, reason: collision with root package name */
        final j f26689f;

        /* renamed from: g, reason: collision with root package name */
        final rx.t.b f26690g;

        public c(j jVar, rx.t.b bVar) {
            this.f26689f = jVar;
            this.f26690g = bVar;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26689f.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f26690g.d(this.f26689f);
            }
        }
    }

    public j(rx.m.a aVar) {
        this.f26684g = aVar;
        this.f26683f = new rx.n.e.l();
    }

    public void a(Future<?> future) {
        this.f26683f.a(new a(future));
    }

    public void b(rx.k kVar) {
        this.f26683f.a(kVar);
    }

    public void c(rx.t.b bVar) {
        this.f26683f.a(new c(this, bVar));
    }

    void d(Throwable th) {
        rx.q.c.j(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26683f.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.f26684g.call();
            } finally {
                unsubscribe();
            }
        } catch (OnErrorNotImplementedException e2) {
            d(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e2));
        } catch (Throwable th) {
            d(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
        }
    }

    @Override // rx.k
    public void unsubscribe() {
        if (this.f26683f.isUnsubscribed()) {
            return;
        }
        this.f26683f.unsubscribe();
    }

    public j(rx.m.a aVar, rx.t.b bVar) {
        this.f26684g = aVar;
        this.f26683f = new rx.n.e.l(new c(this, bVar));
    }

    public j(rx.m.a aVar, rx.n.e.l lVar) {
        this.f26684g = aVar;
        this.f26683f = new rx.n.e.l(new b(this, lVar));
    }
}
