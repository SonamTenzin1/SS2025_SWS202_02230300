package rx.n.e;

/* compiled from: ActionSubscriber.java */
/* loaded from: classes3.dex */
public final class b<T> extends rx.j<T> {

    /* renamed from: f, reason: collision with root package name */
    final rx.m.b<? super T> f26727f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.b<Throwable> f26728g;

    /* renamed from: h, reason: collision with root package name */
    final rx.m.a f26729h;

    public b(rx.m.b<? super T> bVar, rx.m.b<Throwable> bVar2, rx.m.a aVar) {
        this.f26727f = bVar;
        this.f26728g = bVar2;
        this.f26729h = aVar;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f26729h.call();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f26728g.call(th);
    }

    @Override // rx.f
    public void onNext(T t) {
        this.f26727f.call(t);
    }
}
