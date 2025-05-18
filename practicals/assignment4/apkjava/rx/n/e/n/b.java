package rx.n.e.n;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BaseLinkedAtomicQueue.java */
/* loaded from: classes3.dex */
abstract class b<E> extends AbstractQueue<E> {

    /* renamed from: f, reason: collision with root package name */
    private final AtomicReference<c<E>> f26790f = new AtomicReference<>();

    /* renamed from: g, reason: collision with root package name */
    private final AtomicReference<c<E>> f26791g = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public final c<E> c() {
        return this.f26791g.get();
    }

    protected final c<E> f() {
        return this.f26791g.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c<E> g() {
        return this.f26790f.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(c<E> cVar) {
        this.f26791g.lazySet(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c<E> i(c<E> cVar) {
        return this.f26790f.getAndSet(cVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return f() == g();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        c<E> c2;
        c<E> f2 = f();
        c<E> g2 = g();
        int i2 = 0;
        while (f2 != g2 && i2 < Integer.MAX_VALUE) {
            do {
                c2 = f2.c();
            } while (c2 == null);
            i2++;
            f2 = c2;
        }
        return i2;
    }
}
