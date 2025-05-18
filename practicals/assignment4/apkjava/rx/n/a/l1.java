package rx.n.a;

/* compiled from: SingleLiftObservableOperator.java */
/* loaded from: classes3.dex */
final class l1<T> extends rx.i<T> {

    /* renamed from: g, reason: collision with root package name */
    final rx.j<? super T> f26331g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l1(rx.j<? super T> jVar) {
        this.f26331g = jVar;
    }

    @Override // rx.i
    public void c(T t) {
        this.f26331g.setProducer(new rx.n.b.c(this.f26331g, t));
    }

    @Override // rx.i
    public void onError(Throwable th) {
        this.f26331g.onError(th);
    }
}
