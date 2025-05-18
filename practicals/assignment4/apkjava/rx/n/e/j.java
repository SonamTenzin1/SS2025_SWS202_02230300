package rx.n.e;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;
import rx.h;

/* compiled from: ScalarSynchronousObservable.java */
/* loaded from: classes3.dex */
public final class j<T> extends rx.e<T> {

    /* renamed from: g, reason: collision with root package name */
    static final boolean f26750g = Boolean.valueOf(System.getProperty("rx.just.strong-mode", AdultContentAnalytics.UNLOCK)).booleanValue();

    /* renamed from: h, reason: collision with root package name */
    final T f26751h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public class a implements rx.m.e<rx.m.a, rx.k> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.n.c.b f26752f;

        a(rx.n.c.b bVar) {
            this.f26752f = bVar;
        }

        @Override // rx.m.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.k call(rx.m.a aVar) {
            return this.f26752f.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public class b implements rx.m.e<rx.m.a, rx.k> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.h f26754f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ScalarSynchronousObservable.java */
        /* loaded from: classes3.dex */
        public class a implements rx.m.a {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.m.a f26756f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ h.a f26757g;

            a(rx.m.a aVar, h.a aVar2) {
                this.f26756f = aVar;
                this.f26757g = aVar2;
            }

            @Override // rx.m.a
            public void call() {
                try {
                    this.f26756f.call();
                } finally {
                    this.f26757g.unsubscribe();
                }
            }
        }

        b(rx.h hVar) {
            this.f26754f = hVar;
        }

        @Override // rx.m.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public rx.k call(rx.m.a aVar) {
            h.a createWorker = this.f26754f.createWorker();
            createWorker.c(new a(aVar, createWorker));
            return createWorker;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public class c<R> implements e.a<R> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.e f26759f;

        c(rx.m.e eVar) {
            this.f26759f = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super R> jVar) {
            rx.e eVar = (rx.e) this.f26759f.call(j.this.f26751h);
            if (eVar instanceof j) {
                jVar.setProducer(j.g1(jVar, ((j) eVar).f26751h));
            } else {
                eVar.c1(rx.p.f.c(jVar));
            }
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    static final class d<T> implements e.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final T f26761f;

        d(T t) {
            this.f26761f = t;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super T> jVar) {
            jVar.setProducer(j.g1(jVar, this.f26761f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public static final class e<T> implements e.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final T f26762f;

        /* renamed from: g, reason: collision with root package name */
        final rx.m.e<rx.m.a, rx.k> f26763g;

        e(T t, rx.m.e<rx.m.a, rx.k> eVar) {
            this.f26762f = t;
            this.f26763g = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super T> jVar) {
            jVar.setProducer(new f(jVar, this.f26762f, this.f26763g));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public static final class f<T> extends AtomicBoolean implements rx.g, rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26764f;

        /* renamed from: g, reason: collision with root package name */
        final T f26765g;

        /* renamed from: h, reason: collision with root package name */
        final rx.m.e<rx.m.a, rx.k> f26766h;

        public f(rx.j<? super T> jVar, T t, rx.m.e<rx.m.a, rx.k> eVar) {
            this.f26764f = jVar;
            this.f26765g = t;
            this.f26766h = eVar;
        }

        @Override // rx.m.a
        public void call() {
            rx.j<? super T> jVar = this.f26764f;
            if (jVar.isUnsubscribed()) {
                return;
            }
            T t = this.f26765g;
            try {
                jVar.onNext(t);
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, jVar, t);
            }
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 >= 0) {
                if (j2 == 0 || !compareAndSet(false, true)) {
                    return;
                }
                this.f26764f.add(this.f26766h.call(this));
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j2);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.f26765g + ", " + get() + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public static final class g<T> implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26767f;

        /* renamed from: g, reason: collision with root package name */
        final T f26768g;

        /* renamed from: h, reason: collision with root package name */
        boolean f26769h;

        public g(rx.j<? super T> jVar, T t) {
            this.f26767f = jVar;
            this.f26768g = t;
        }

        @Override // rx.g
        public void request(long j2) {
            if (this.f26769h) {
                return;
            }
            if (j2 < 0) {
                throw new IllegalStateException("n >= required but it was " + j2);
            }
            if (j2 == 0) {
                return;
            }
            this.f26769h = true;
            rx.j<? super T> jVar = this.f26767f;
            if (jVar.isUnsubscribed()) {
                return;
            }
            T t = this.f26768g;
            try {
                jVar.onNext(t);
                if (jVar.isUnsubscribed()) {
                    return;
                }
                jVar.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, jVar, t);
            }
        }
    }

    protected j(T t) {
        super(rx.q.c.h(new d(t)));
        this.f26751h = t;
    }

    public static <T> j<T> f1(T t) {
        return new j<>(t);
    }

    static <T> rx.g g1(rx.j<? super T> jVar, T t) {
        if (f26750g) {
            return new rx.n.b.c(jVar, t);
        }
        return new g(jVar, t);
    }

    public T h1() {
        return this.f26751h;
    }

    public <R> rx.e<R> i1(rx.m.e<? super T, ? extends rx.e<? extends R>> eVar) {
        return rx.e.b1(new c(eVar));
    }

    public rx.e<T> j1(rx.h hVar) {
        rx.m.e bVar;
        if (hVar instanceof rx.n.c.b) {
            bVar = new a((rx.n.c.b) hVar);
        } else {
            bVar = new b(hVar);
        }
        return rx.e.b1(new e(this.f26751h, bVar));
    }
}
