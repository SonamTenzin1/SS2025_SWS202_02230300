package rx.n.a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: OnSubscribeFlatMapCompletable.java */
/* loaded from: classes3.dex */
public final class p<T> implements e.a<T> {

    /* renamed from: f, reason: collision with root package name */
    final rx.e<T> f26374f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, ? extends rx.b> f26375g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f26376h;

    /* renamed from: i, reason: collision with root package name */
    final int f26377i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFlatMapCompletable.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26378f;

        /* renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends rx.b> f26379g;

        /* renamed from: h, reason: collision with root package name */
        final boolean f26380h;

        /* renamed from: i, reason: collision with root package name */
        final int f26381i;

        /* renamed from: j, reason: collision with root package name */
        final AtomicInteger f26382j = new AtomicInteger(1);
        final AtomicReference<Throwable> l = new AtomicReference<>();

        /* renamed from: k, reason: collision with root package name */
        final rx.t.b f26383k = new rx.t.b();

        /* compiled from: OnSubscribeFlatMapCompletable.java */
        /* renamed from: rx.n.a.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0445a extends AtomicReference<rx.k> implements rx.c, rx.k {
            C0445a() {
            }

            @Override // rx.c
            public void a(rx.k kVar) {
                if (compareAndSet(null, kVar)) {
                    return;
                }
                kVar.unsubscribe();
                if (get() != this) {
                    rx.q.c.j(new IllegalStateException("Subscription already set!"));
                }
            }

            @Override // rx.k
            public boolean isUnsubscribed() {
                return get() == this;
            }

            @Override // rx.c
            public void onCompleted() {
                a.this.d(this);
            }

            @Override // rx.c
            public void onError(Throwable th) {
                a.this.e(this, th);
            }

            @Override // rx.k
            public void unsubscribe() {
                rx.k andSet = getAndSet(this);
                if (andSet == null || andSet == this) {
                    return;
                }
                andSet.unsubscribe();
            }
        }

        a(rx.j<? super T> jVar, rx.m.e<? super T, ? extends rx.b> eVar, boolean z, int i2) {
            this.f26378f = jVar;
            this.f26379g = eVar;
            this.f26380h = z;
            this.f26381i = i2;
            request(i2 != Integer.MAX_VALUE ? i2 : Long.MAX_VALUE);
        }

        boolean c() {
            if (this.f26382j.decrementAndGet() != 0) {
                return false;
            }
            Throwable q = rx.n.e.e.q(this.l);
            if (q != null) {
                this.f26378f.onError(q);
                return true;
            }
            this.f26378f.onCompleted();
            return true;
        }

        public void d(a<T>.C0445a c0445a) {
            this.f26383k.d(c0445a);
            if (c() || this.f26381i == Integer.MAX_VALUE) {
                return;
            }
            request(1L);
        }

        public void e(a<T>.C0445a c0445a, Throwable th) {
            this.f26383k.d(c0445a);
            if (this.f26380h) {
                rx.n.e.e.g(this.l, th);
                if (c() || this.f26381i == Integer.MAX_VALUE) {
                    return;
                }
                request(1L);
                return;
            }
            this.f26383k.unsubscribe();
            unsubscribe();
            if (this.l.compareAndSet(null, th)) {
                this.f26378f.onError(rx.n.e.e.q(this.l));
            } else {
                rx.q.c.j(th);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            c();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26380h) {
                rx.n.e.e.g(this.l, th);
                onCompleted();
                return;
            }
            this.f26383k.unsubscribe();
            if (this.l.compareAndSet(null, th)) {
                this.f26378f.onError(rx.n.e.e.q(this.l));
            } else {
                rx.q.c.j(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                rx.b call = this.f26379g.call(t);
                if (call != null) {
                    C0445a c0445a = new C0445a();
                    this.f26383k.a(c0445a);
                    this.f26382j.getAndIncrement();
                    call.P(c0445a);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Completable");
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public p(rx.e<T> eVar, rx.m.e<? super T, ? extends rx.b> eVar2, boolean z, int i2) {
        if (eVar2 == null) {
            throw new NullPointerException("mapper is null");
        }
        if (i2 > 0) {
            this.f26374f = eVar;
            this.f26375g = eVar2;
            this.f26376h = z;
            this.f26377i = i2;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i2);
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.f26375g, this.f26376h, this.f26377i);
        jVar.add(aVar);
        jVar.add(aVar.f26383k);
        this.f26374f.c1(aVar);
    }
}
