package rx.n.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.h;

/* compiled from: OperatorSampleWithTime.java */
/* loaded from: classes3.dex */
public final class v0<T> implements e.b<T, T> {

    /* renamed from: f, reason: collision with root package name */
    final long f26517f;

    /* renamed from: g, reason: collision with root package name */
    final TimeUnit f26518g;

    /* renamed from: h, reason: collision with root package name */
    final rx.h f26519h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSampleWithTime.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.j<T> implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        private static final Object f26520f = new Object();

        /* renamed from: g, reason: collision with root package name */
        private final rx.j<? super T> f26521g;

        /* renamed from: h, reason: collision with root package name */
        final AtomicReference<Object> f26522h = new AtomicReference<>(f26520f);

        public a(rx.j<? super T> jVar) {
            this.f26521g = jVar;
        }

        private void c() {
            AtomicReference<Object> atomicReference = this.f26522h;
            Object obj = f26520f;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.f26521g.onNext(andSet);
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        @Override // rx.m.a
        public void call() {
            c();
        }

        @Override // rx.f
        public void onCompleted() {
            c();
            this.f26521g.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26521g.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26522h.set(t);
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public v0(long j2, TimeUnit timeUnit, rx.h hVar) {
        this.f26517f = j2;
        this.f26518g = timeUnit;
        this.f26519h = hVar;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        rx.p.e eVar = new rx.p.e(jVar);
        h.a createWorker = this.f26519h.createWorker();
        jVar.add(createWorker);
        a aVar = new a(eVar);
        jVar.add(aVar);
        long j2 = this.f26517f;
        createWorker.e(aVar, j2, j2, this.f26518g);
        return aVar;
    }
}
