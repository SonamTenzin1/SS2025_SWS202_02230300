package rx.n.a;

import rx.e;
import rx.exceptions.OnErrorThrowable;

/* compiled from: OnSubscribeMap.java */
/* loaded from: classes3.dex */
public final class w<T, R> implements e.a<R> {

    /* renamed from: f, reason: collision with root package name */
    final rx.e<T> f26523f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, ? extends R> f26524g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        final rx.j<? super R> f26525f;

        /* renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends R> f26526g;

        /* renamed from: h, reason: collision with root package name */
        boolean f26527h;

        public a(rx.j<? super R> jVar, rx.m.e<? super T, ? extends R> eVar) {
            this.f26525f = jVar;
            this.f26526g = eVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26527h) {
                return;
            }
            this.f26525f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26527h) {
                rx.q.c.j(th);
            } else {
                this.f26527h = true;
                this.f26525f.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                this.f26525f.onNext(this.f26526g.call(t));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.a(th, t));
            }
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26525f.setProducer(gVar);
        }
    }

    public w(rx.e<T> eVar, rx.m.e<? super T, ? extends R> eVar2) {
        this.f26523f = eVar;
        this.f26524g = eVar2;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.f26524g);
        jVar.add(aVar);
        this.f26523f.c1(aVar);
    }
}
