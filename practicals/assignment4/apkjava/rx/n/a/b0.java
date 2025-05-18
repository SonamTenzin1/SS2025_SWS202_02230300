package rx.n.a;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: OnSubscribeSkipTimed.java */
/* loaded from: classes3.dex */
public final class b0<T> implements e.a<T> {

    /* renamed from: f, reason: collision with root package name */
    final long f26131f;

    /* renamed from: g, reason: collision with root package name */
    final TimeUnit f26132g;

    /* renamed from: h, reason: collision with root package name */
    final rx.h f26133h;

    /* renamed from: i, reason: collision with root package name */
    final rx.e<T> f26134i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeSkipTimed.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.j<T> implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26135f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f26136g;

        a(rx.j<? super T> jVar) {
            this.f26135f = jVar;
        }

        @Override // rx.m.a
        public void call() {
            this.f26136g = true;
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f26135f.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f26135f.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26136g) {
                this.f26135f.onNext(t);
            }
        }
    }

    public b0(rx.e<T> eVar, long j2, TimeUnit timeUnit, rx.h hVar) {
        this.f26134i = eVar;
        this.f26131f = j2;
        this.f26132g = timeUnit;
        this.f26133h = hVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        h.a createWorker = this.f26133h.createWorker();
        a aVar = new a(jVar);
        aVar.add(createWorker);
        jVar.add(aVar);
        createWorker.d(aVar, this.f26131f, this.f26132g);
        this.f26134i.c1(aVar);
    }
}
