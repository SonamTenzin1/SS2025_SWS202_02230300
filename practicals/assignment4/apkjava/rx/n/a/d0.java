package rx.n.a;

import rx.e;

/* compiled from: OnSubscribeThrow.java */
/* loaded from: classes3.dex */
public final class d0<T> implements e.a<T> {

    /* renamed from: f, reason: collision with root package name */
    private final Throwable f26169f;

    public d0(Throwable th) {
        this.f26169f = th;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        jVar.onError(this.f26169f);
    }
}
