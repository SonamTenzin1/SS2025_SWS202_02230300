package rx.n.a;

import rx.e;

/* compiled from: EmptyObservableHolder.java */
/* loaded from: classes3.dex */
public enum g implements e.a<Object> {
    INSTANCE;


    /* renamed from: g, reason: collision with root package name */
    static final rx.e<Object> f26218g = rx.e.b1(INSTANCE);

    public static <T> rx.e<T> k() {
        return (rx.e<T>) f26218g;
    }

    @Override // rx.m.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super Object> jVar) {
        jVar.onCompleted();
    }
}
