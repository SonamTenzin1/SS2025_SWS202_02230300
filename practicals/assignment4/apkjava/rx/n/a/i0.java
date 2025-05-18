package rx.n.a;

import rx.e;

/* compiled from: OperatorAsObservable.java */
/* loaded from: classes3.dex */
public final class i0<T> implements e.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorAsObservable.java */
    /* loaded from: classes3.dex */
    public static final class a {
        static final i0<Object> a = new i0<>();
    }

    i0() {
    }

    public static <T> i0<T> b() {
        return (i0<T>) a.a;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        return jVar;
    }
}
