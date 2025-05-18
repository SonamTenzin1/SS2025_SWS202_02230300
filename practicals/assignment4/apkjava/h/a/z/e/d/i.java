package h.a.z.e.d;

import android.R;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapMaybe.java */
/* loaded from: classes2.dex */
public final class i<T, R> extends h.a.z.e.d.a<T, R> {

    /* renamed from: g, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends h.a.l<? extends R>> f21551g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f21552h;

    /* compiled from: ObservableFlatMapMaybe.java */
    /* loaded from: classes2.dex */
    static final class a<T, R> extends AtomicInteger implements h.a.q<T>, h.a.x.c {

        /* renamed from: f, reason: collision with root package name */
        final h.a.q<? super R> f21553f;

        /* renamed from: g, reason: collision with root package name */
        final boolean f21554g;

        /* renamed from: k, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends h.a.l<? extends R>> f21558k;
        h.a.x.c m;
        volatile boolean n;

        /* renamed from: h, reason: collision with root package name */
        final h.a.x.b f21555h = new h.a.x.b();

        /* renamed from: j, reason: collision with root package name */
        final h.a.z.j.a f21557j = new h.a.z.j.a();

        /* renamed from: i, reason: collision with root package name */
        final AtomicInteger f21556i = new AtomicInteger(1);
        final AtomicReference<h.a.z.f.c<R>> l = new AtomicReference<>();

        /* compiled from: ObservableFlatMapMaybe.java */
        /* renamed from: h.a.z.e.d.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        final class C0295a extends AtomicReference<h.a.x.c> implements h.a.k<R>, h.a.x.c {
            C0295a() {
            }

            @Override // h.a.k
            public void a() {
                a.this.g(this);
            }

            @Override // h.a.k
            public void b(h.a.x.c cVar) {
                h.a.z.a.c.A(this, cVar);
            }

            @Override // h.a.x.c
            public void k() {
                h.a.z.a.c.g(this);
            }

            @Override // h.a.k
            public void onError(Throwable th) {
                a.this.h(this, th);
            }

            @Override // h.a.k
            public void onSuccess(R r) {
                a.this.i(this, r);
            }

            @Override // h.a.x.c
            public boolean q() {
                return h.a.z.a.c.u(get());
            }
        }

        a(h.a.q<? super R> qVar, h.a.y.f<? super T, ? extends h.a.l<? extends R>> fVar, boolean z) {
            this.f21553f = qVar;
            this.f21558k = fVar;
            this.f21554g = z;
        }

        @Override // h.a.q
        public void a() {
            this.f21556i.decrementAndGet();
            d();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.m, cVar)) {
                this.m = cVar;
                this.f21553f.b(this);
            }
        }

        void c() {
            h.a.z.f.c<R> cVar = this.l.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        void e() {
            h.a.q<? super R> qVar = this.f21553f;
            AtomicInteger atomicInteger = this.f21556i;
            AtomicReference<h.a.z.f.c<R>> atomicReference = this.l;
            int i2 = 1;
            while (!this.n) {
                if (!this.f21554g && this.f21557j.get() != null) {
                    Throwable b2 = this.f21557j.b();
                    c();
                    qVar.onError(b2);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                h.a.z.f.c<R> cVar = atomicReference.get();
                R.bool poll = cVar != null ? cVar.poll() : null;
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable b3 = this.f21557j.b();
                    if (b3 != null) {
                        qVar.onError(b3);
                        return;
                    } else {
                        qVar.a();
                        return;
                    }
                }
                if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    qVar.onNext(poll);
                }
            }
            c();
        }

        h.a.z.f.c<R> f() {
            h.a.z.f.c<R> cVar;
            do {
                h.a.z.f.c<R> cVar2 = this.l.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new h.a.z.f.c<>(h.a.m.b());
            } while (!this.l.compareAndSet(null, cVar));
            return cVar;
        }

        void g(a<T, R>.C0295a c0295a) {
            this.f21555h.c(c0295a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.f21556i.decrementAndGet() == 0;
                    h.a.z.f.c<R> cVar = this.l.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable b2 = this.f21557j.b();
                        if (b2 != null) {
                            this.f21553f.onError(b2);
                            return;
                        } else {
                            this.f21553f.a();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    e();
                    return;
                }
            }
            this.f21556i.decrementAndGet();
            d();
        }

        void h(a<T, R>.C0295a c0295a, Throwable th) {
            this.f21555h.c(c0295a);
            if (this.f21557j.a(th)) {
                if (!this.f21554g) {
                    this.m.k();
                    this.f21555h.k();
                }
                this.f21556i.decrementAndGet();
                d();
                return;
            }
            h.a.a0.a.o(th);
        }

        void i(a<T, R>.C0295a c0295a, R r) {
            this.f21555h.c(c0295a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.f21553f.onNext(r);
                    boolean z = this.f21556i.decrementAndGet() == 0;
                    h.a.z.f.c<R> cVar = this.l.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable b2 = this.f21557j.b();
                        if (b2 != null) {
                            this.f21553f.onError(b2);
                            return;
                        } else {
                            this.f21553f.a();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    e();
                }
            }
            h.a.z.f.c<R> f2 = f();
            synchronized (f2) {
                f2.offer(r);
            }
            this.f21556i.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            e();
        }

        @Override // h.a.x.c
        public void k() {
            this.n = true;
            this.m.k();
            this.f21555h.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            this.f21556i.decrementAndGet();
            if (this.f21557j.a(th)) {
                if (!this.f21554g) {
                    this.f21555h.k();
                }
                d();
                return;
            }
            h.a.a0.a.o(th);
        }

        @Override // h.a.q
        public void onNext(T t) {
            try {
                h.a.l lVar = (h.a.l) h.a.z.b.b.c(this.f21558k.a(t), "The mapper returned a null MaybeSource");
                this.f21556i.getAndIncrement();
                C0295a c0295a = new C0295a();
                if (this.n || !this.f21555h.b(c0295a)) {
                    return;
                }
                lVar.a(c0295a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.m.k();
                onError(th);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.n;
        }
    }

    public i(h.a.p<T> pVar, h.a.y.f<? super T, ? extends h.a.l<? extends R>> fVar, boolean z) {
        super(pVar);
        this.f21551g = fVar;
        this.f21552h = z;
    }

    @Override // h.a.m
    protected void x(h.a.q<? super R> qVar) {
        this.f21503f.a(new a(qVar, this.f21551g, this.f21552h));
    }
}
