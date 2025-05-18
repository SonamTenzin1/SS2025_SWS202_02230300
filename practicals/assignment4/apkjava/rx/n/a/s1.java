package rx.n.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.h;

/* compiled from: SingleTimeout.java */
/* loaded from: classes3.dex */
public final class s1<T> implements Single.j<T> {

    /* renamed from: f, reason: collision with root package name */
    final Single.j<T> f26479f;

    /* renamed from: g, reason: collision with root package name */
    final long f26480g;

    /* renamed from: h, reason: collision with root package name */
    final TimeUnit f26481h;

    /* renamed from: i, reason: collision with root package name */
    final rx.h f26482i;

    /* renamed from: j, reason: collision with root package name */
    final Single.j<? extends T> f26483j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleTimeout.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.i<T> implements rx.m.a {

        /* renamed from: g, reason: collision with root package name */
        final rx.i<? super T> f26484g;

        /* renamed from: h, reason: collision with root package name */
        final AtomicBoolean f26485h = new AtomicBoolean();

        /* renamed from: i, reason: collision with root package name */
        final Single.j<? extends T> f26486i;

        /* compiled from: SingleTimeout.java */
        /* renamed from: rx.n.a.s1$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0449a<T> extends rx.i<T> {

            /* renamed from: g, reason: collision with root package name */
            final rx.i<? super T> f26487g;

            C0449a(rx.i<? super T> iVar) {
                this.f26487g = iVar;
            }

            @Override // rx.i
            public void c(T t) {
                this.f26487g.c(t);
            }

            @Override // rx.i
            public void onError(Throwable th) {
                this.f26487g.onError(th);
            }
        }

        a(rx.i<? super T> iVar, Single.j<? extends T> jVar) {
            this.f26484g = iVar;
            this.f26486i = jVar;
        }

        @Override // rx.i
        public void c(T t) {
            if (this.f26485h.compareAndSet(false, true)) {
                try {
                    this.f26484g.c(t);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.m.a
        public void call() {
            if (this.f26485h.compareAndSet(false, true)) {
                try {
                    Single.j<? extends T> jVar = this.f26486i;
                    if (jVar == null) {
                        this.f26484g.onError(new TimeoutException());
                    } else {
                        C0449a c0449a = new C0449a(this.f26484g);
                        this.f26484g.b(c0449a);
                        jVar.call(c0449a);
                    }
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.i
        public void onError(Throwable th) {
            if (this.f26485h.compareAndSet(false, true)) {
                try {
                    this.f26484g.onError(th);
                    return;
                } finally {
                    unsubscribe();
                }
            }
            rx.q.c.j(th);
        }
    }

    public s1(Single.j<T> jVar, long j2, TimeUnit timeUnit, rx.h hVar, Single.j<? extends T> jVar2) {
        this.f26479f = jVar;
        this.f26480g = j2;
        this.f26481h = timeUnit;
        this.f26482i = hVar;
        this.f26483j = jVar2;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.f26483j);
        h.a createWorker = this.f26482i.createWorker();
        aVar.b(createWorker);
        iVar.b(aVar);
        createWorker.d(aVar, this.f26480g, this.f26481h);
        this.f26479f.call(aVar);
    }
}
