package rx.n.a;

import rx.e;

/* compiled from: OnSubscribeLift.java */
/* loaded from: classes3.dex */
public final class v<T, R> implements e.a<R> {

    /* renamed from: f, reason: collision with root package name */
    final e.a<T> f26515f;

    /* renamed from: g, reason: collision with root package name */
    final e.b<? extends R, ? super T> f26516g;

    public v(e.a<T> aVar, e.b<? extends R, ? super T> bVar) {
        this.f26515f = aVar;
        this.f26516g = bVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        try {
            rx.j<? super T> call = rx.q.c.n(this.f26516g).call(jVar);
            try {
                call.onStart();
                this.f26515f.call(call);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                call.onError(th);
            }
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            jVar.onError(th2);
        }
    }
}
