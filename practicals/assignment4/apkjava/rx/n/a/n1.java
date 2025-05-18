package rx.n.a;

import rx.Single;

/* compiled from: SingleOnErrorReturn.java */
/* loaded from: classes3.dex */
public final class n1<T> implements Single.j<T> {

    /* renamed from: f, reason: collision with root package name */
    final Single.j<T> f26356f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.e<Throwable, ? extends T> f26357g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnErrorReturn.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends rx.i<T> {

        /* renamed from: g, reason: collision with root package name */
        final rx.i<? super T> f26358g;

        /* renamed from: h, reason: collision with root package name */
        final rx.m.e<Throwable, ? extends T> f26359h;

        public a(rx.i<? super T> iVar, rx.m.e<Throwable, ? extends T> eVar) {
            this.f26358g = iVar;
            this.f26359h = eVar;
        }

        @Override // rx.i
        public void c(T t) {
            this.f26358g.c(t);
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                this.f26358g.c(this.f26359h.call(th));
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                this.f26358g.onError(th2);
            }
        }
    }

    public n1(Single.j<T> jVar, rx.m.e<Throwable, ? extends T> eVar) {
        this.f26356f = jVar;
        this.f26357g = eVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar, this.f26357g);
        iVar.b(aVar);
        this.f26356f.call(aVar);
    }
}
