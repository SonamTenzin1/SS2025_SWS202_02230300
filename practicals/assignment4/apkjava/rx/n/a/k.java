package rx.n.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* compiled from: OnSubscribeConcatMap.java */
/* loaded from: classes3.dex */
public final class k<T, R> implements e.a<R> {

    /* renamed from: f, reason: collision with root package name */
    final rx.e<? extends T> f26282f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, ? extends rx.e<? extends R>> f26283g;

    /* renamed from: h, reason: collision with root package name */
    final int f26284h;

    /* renamed from: i, reason: collision with root package name */
    final int f26285i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public class a implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f26286f;

        a(d dVar) {
            this.f26286f = dVar;
        }

        @Override // rx.g
        public void request(long j2) {
            this.f26286f.i(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        final R f26288f;

        /* renamed from: g, reason: collision with root package name */
        final d<T, R> f26289g;

        /* renamed from: h, reason: collision with root package name */
        boolean f26290h;

        public b(R r, d<T, R> dVar) {
            this.f26288f = r;
            this.f26289g = dVar;
        }

        @Override // rx.g
        public void request(long j2) {
            if (this.f26290h || j2 <= 0) {
                return;
            }
            this.f26290h = true;
            d<T, R> dVar = this.f26289g;
            dVar.g(this.f26288f);
            dVar.e(1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class c<T, R> extends rx.j<R> {

        /* renamed from: f, reason: collision with root package name */
        final d<T, R> f26291f;

        /* renamed from: g, reason: collision with root package name */
        long f26292g;

        public c(d<T, R> dVar) {
            this.f26291f = dVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26291f.e(this.f26292g);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26291f.f(th, this.f26292g);
        }

        @Override // rx.f
        public void onNext(R r) {
            this.f26292g++;
            this.f26291f.g(r);
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26291f.f26296i.c(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class d<T, R> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super R> f26293f;

        /* renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends rx.e<? extends R>> f26294g;

        /* renamed from: h, reason: collision with root package name */
        final int f26295h;

        /* renamed from: j, reason: collision with root package name */
        final Queue<Object> f26297j;
        final rx.t.d m;
        volatile boolean n;
        volatile boolean o;

        /* renamed from: i, reason: collision with root package name */
        final rx.n.b.a f26296i = new rx.n.b.a();

        /* renamed from: k, reason: collision with root package name */
        final AtomicInteger f26298k = new AtomicInteger();
        final AtomicReference<Throwable> l = new AtomicReference<>();

        public d(rx.j<? super R> jVar, rx.m.e<? super T, ? extends rx.e<? extends R>> eVar, int i2, int i3) {
            Queue<Object> eVar2;
            this.f26293f = jVar;
            this.f26294g = eVar;
            this.f26295h = i3;
            if (rx.n.e.o.z.b()) {
                eVar2 = new rx.n.e.o.s<>(i2);
            } else {
                eVar2 = new rx.n.e.n.e<>(i2);
            }
            this.f26297j = eVar2;
            this.m = new rx.t.d();
            request(i2);
        }

        void c() {
            if (this.f26298k.getAndIncrement() != 0) {
                return;
            }
            int i2 = this.f26295h;
            while (!this.f26293f.isUnsubscribed()) {
                if (!this.o) {
                    if (i2 == 1 && this.l.get() != null) {
                        Throwable q = rx.n.e.e.q(this.l);
                        if (rx.n.e.e.k(q)) {
                            return;
                        }
                        this.f26293f.onError(q);
                        return;
                    }
                    boolean z = this.n;
                    Object poll = this.f26297j.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable q2 = rx.n.e.e.q(this.l);
                        if (q2 == null) {
                            this.f26293f.onCompleted();
                            return;
                        } else {
                            if (rx.n.e.e.k(q2)) {
                                return;
                            }
                            this.f26293f.onError(q2);
                            return;
                        }
                    }
                    if (!z2) {
                        try {
                            rx.e<? extends R> call = this.f26294g.call((Object) h.e(poll));
                            if (call == null) {
                                d(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (call != rx.e.B()) {
                                if (call instanceof rx.n.e.j) {
                                    this.o = true;
                                    this.f26296i.c(new b(((rx.n.e.j) call).h1(), this));
                                } else {
                                    c cVar = new c(this);
                                    this.m.b(cVar);
                                    if (cVar.isUnsubscribed()) {
                                        return;
                                    }
                                    this.o = true;
                                    call.c1(cVar);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            d(th);
                            return;
                        }
                    }
                }
                if (this.f26298k.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void d(Throwable th) {
            unsubscribe();
            if (rx.n.e.e.g(this.l, th)) {
                Throwable q = rx.n.e.e.q(this.l);
                if (rx.n.e.e.k(q)) {
                    return;
                }
                this.f26293f.onError(q);
                return;
            }
            h(th);
        }

        void e(long j2) {
            if (j2 != 0) {
                this.f26296i.b(j2);
            }
            this.o = false;
            c();
        }

        void f(Throwable th, long j2) {
            if (!rx.n.e.e.g(this.l, th)) {
                h(th);
                return;
            }
            if (this.f26295h == 0) {
                Throwable q = rx.n.e.e.q(this.l);
                if (!rx.n.e.e.k(q)) {
                    this.f26293f.onError(q);
                }
                unsubscribe();
                return;
            }
            if (j2 != 0) {
                this.f26296i.b(j2);
            }
            this.o = false;
            c();
        }

        void g(R r) {
            this.f26293f.onNext(r);
        }

        void h(Throwable th) {
            rx.q.c.j(th);
        }

        void i(long j2) {
            if (j2 > 0) {
                this.f26296i.request(j2);
            } else {
                if (j2 >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j2);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.n = true;
            c();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (rx.n.e.e.g(this.l, th)) {
                this.n = true;
                if (this.f26295h == 0) {
                    Throwable q = rx.n.e.e.q(this.l);
                    if (!rx.n.e.e.k(q)) {
                        this.f26293f.onError(q);
                    }
                    this.m.unsubscribe();
                    return;
                }
                c();
                return;
            }
            h(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            if (!this.f26297j.offer(h.g(t))) {
                unsubscribe();
                onError(new MissingBackpressureException());
            } else {
                c();
            }
        }
    }

    public k(rx.e<? extends T> eVar, rx.m.e<? super T, ? extends rx.e<? extends R>> eVar2, int i2, int i3) {
        this.f26282f = eVar;
        this.f26283g = eVar2;
        this.f26284h = i2;
        this.f26285i = i3;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        d dVar = new d(this.f26285i == 0 ? new rx.p.e<>(jVar) : jVar, this.f26283g, this.f26284h, this.f26285i);
        jVar.add(dVar);
        jVar.add(dVar.m);
        jVar.setProducer(new a(dVar));
        if (jVar.isUnsubscribed()) {
            return;
        }
        this.f26282f.c1(dVar);
    }
}
