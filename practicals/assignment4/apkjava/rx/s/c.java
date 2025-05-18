package rx.s;

import rx.e;
import rx.j;

/* compiled from: SerializedSubject.java */
/* loaded from: classes3.dex */
public class c<T, R> extends d<T, R> {

    /* renamed from: g, reason: collision with root package name */
    private final rx.p.d<T> f26873g;

    /* renamed from: h, reason: collision with root package name */
    private final d<T, R> f26874h;

    /* compiled from: SerializedSubject.java */
    /* loaded from: classes3.dex */
    class a implements e.a<R> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f26875f;

        a(d dVar) {
            this.f26875f = dVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(j<? super R> jVar) {
            this.f26875f.c1(jVar);
        }
    }

    public c(d<T, R> dVar) {
        super(new a(dVar));
        this.f26874h = dVar;
        this.f26873g = new rx.p.d<>(dVar);
    }

    @Override // rx.f
    public void onCompleted() {
        this.f26873g.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f26873g.onError(th);
    }

    @Override // rx.f
    public void onNext(T t) {
        this.f26873g.onNext(t);
    }
}
