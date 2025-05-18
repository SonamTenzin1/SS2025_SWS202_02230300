package rx.n.e.n;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.n.e.o.j;

/* compiled from: AtomicReferenceArrayQueue.java */
/* loaded from: classes3.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: f, reason: collision with root package name */
    protected final AtomicReferenceArray<E> f26788f;

    /* renamed from: g, reason: collision with root package name */
    protected final int f26789g;

    public a(int i2) {
        int b2 = j.b(i2);
        this.f26789g = b2 - 1;
        this.f26788f = new AtomicReferenceArray<>(b2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int c(long j2) {
        return this.f26789g & ((int) j2);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f(long j2, int i2) {
        return ((int) j2) & i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E g(int i2) {
        return h(this.f26788f, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E h(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        atomicReferenceArray.lazySet(i2, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
