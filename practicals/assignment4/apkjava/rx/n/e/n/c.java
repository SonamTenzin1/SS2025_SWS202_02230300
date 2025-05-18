package rx.n.e.n;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LinkedQueueNode.java */
/* loaded from: classes3.dex */
public final class c<E> extends AtomicReference<c<E>> {

    /* renamed from: f, reason: collision with root package name */
    private E f26792f;

    public c() {
    }

    public E a() {
        E b2 = b();
        e(null);
        return b2;
    }

    public E b() {
        return this.f26792f;
    }

    public c<E> c() {
        return get();
    }

    public void d(c<E> cVar) {
        lazySet(cVar);
    }

    public void e(E e2) {
        this.f26792f = e2;
    }

    public c(E e2) {
        e(e2);
    }
}
