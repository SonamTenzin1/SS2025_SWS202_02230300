package rx.n.e;

import rx.Single;
import rx.h;

/* compiled from: ScalarSynchronousSingle.java */
/* loaded from: classes3.dex */
public final class k<T> extends Single<T> {

    /* renamed from: b, reason: collision with root package name */
    final T f26770b;

    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    class a implements Single.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f26771f;

        a(Object obj) {
            this.f26771f = obj;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            iVar.c((Object) this.f26771f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    public class b<R> implements Single.j<R> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.e f26772f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ScalarSynchronousSingle.java */
        /* loaded from: classes3.dex */
        public class a extends rx.i<R> {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ rx.i f26774g;

            a(rx.i iVar) {
                this.f26774g = iVar;
            }

            @Override // rx.i
            public void c(R r) {
                this.f26774g.c(r);
            }

            @Override // rx.i
            public void onError(Throwable th) {
                this.f26774g.onError(th);
            }
        }

        b(rx.m.e eVar) {
            this.f26772f = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super R> iVar) {
            Single single = (Single) this.f26772f.call(k.this.f26770b);
            if (single instanceof k) {
                iVar.c(((k) single).f26770b);
                return;
            }
            a aVar = new a(iVar);
            iVar.b(aVar);
            single.t(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    public static final class c<T> implements Single.j<T> {

        /* renamed from: f, reason: collision with root package name */
        private final rx.n.c.b f26776f;

        /* renamed from: g, reason: collision with root package name */
        private final T f26777g;

        c(rx.n.c.b bVar, T t) {
            this.f26776f = bVar;
            this.f26777g = t;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            iVar.b(this.f26776f.a(new e(iVar, this.f26777g)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    public static final class d<T> implements Single.j<T> {

        /* renamed from: f, reason: collision with root package name */
        private final rx.h f26778f;

        /* renamed from: g, reason: collision with root package name */
        private final T f26779g;

        d(rx.h hVar, T t) {
            this.f26778f = hVar;
            this.f26779g = t;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.i<? super T> iVar) {
            h.a createWorker = this.f26778f.createWorker();
            iVar.b(createWorker);
            createWorker.c(new e(iVar, this.f26779g));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    public static final class e<T> implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        private final rx.i<? super T> f26780f;

        /* renamed from: g, reason: collision with root package name */
        private final T f26781g;

        e(rx.i<? super T> iVar, T t) {
            this.f26780f = iVar;
            this.f26781g = t;
        }

        @Override // rx.m.a
        public void call() {
            try {
                this.f26780f.c(this.f26781g);
            } catch (Throwable th) {
                this.f26780f.onError(th);
            }
        }
    }

    protected k(T t) {
        super(new a(t));
        this.f26770b = t;
    }

    public static <T> k<T> D(T t) {
        return new k<>(t);
    }

    public <R> Single<R> E(rx.m.e<? super T, ? extends Single<? extends R>> eVar) {
        return Single.b(new b(eVar));
    }

    public Single<T> F(rx.h hVar) {
        if (hVar instanceof rx.n.c.b) {
            return Single.b(new c((rx.n.c.b) hVar, this.f26770b));
        }
        return Single.b(new d(hVar, this.f26770b));
    }
}
