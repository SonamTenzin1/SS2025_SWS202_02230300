package e.g.b;

import e.g.b.e;
import rx.e;

/* compiled from: PublishRelay.java */
/* loaded from: classes.dex */
public class c<T> extends d<T, T> {

    /* renamed from: g, reason: collision with root package name */
    private final e<T> f21196g;

    protected c(e.a<T> aVar, e<T> eVar) {
        super(aVar);
        this.f21196g = eVar;
    }

    public static <T> c<T> f1() {
        e eVar = new e();
        return new c<>(eVar, eVar);
    }

    @Override // rx.m.b
    public void call(T t) {
        for (e.b<T> bVar : this.f21196g.f()) {
            bVar.onNext(t);
        }
    }
}
