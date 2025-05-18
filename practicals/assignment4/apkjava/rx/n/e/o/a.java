package rx.n.e.o;

import java.util.Iterator;

/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes3.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return g() == c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        rx.n.e.n.c<E> c2;
        rx.n.e.n.c<E> g2 = g();
        rx.n.e.n.c<E> c3 = c();
        int i2 = 0;
        while (g2 != c3 && i2 < Integer.MAX_VALUE) {
            do {
                c2 = g2.c();
            } while (c2 == null);
            i2++;
            g2 = c2;
        }
        return i2;
    }
}
