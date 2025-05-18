package rx.n.e.o;

/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
public final class k<E> extends o<E> {
    public k(int i2) {
        super(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return t() == q();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            E[] eArr = this.f26819j;
            long j2 = this.f26818i;
            long q = q();
            long c2 = c(q);
            if (i(eArr, c2) != null) {
                if (q - t() > j2) {
                    return false;
                }
                do {
                } while (i(eArr, c2) != null);
            }
            o(eArr, c2, e2);
            r(q + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public E peek() {
        E h2;
        long u = u();
        do {
            long t = t();
            if (t >= u) {
                long q = q();
                if (t >= q) {
                    return null;
                }
                v(q);
            }
            h2 = h(c(t));
        } while (h2 == null);
        return h2;
    }

    @Override // java.util.Queue, rx.n.e.o.h
    public E poll() {
        long t;
        long u = u();
        do {
            t = t();
            if (t >= u) {
                long q = q();
                if (t >= q) {
                    return null;
                }
                v(q);
            }
        } while (!s(t, 1 + t));
        long c2 = c(t);
        E[] eArr = this.f26819j;
        E g2 = g(eArr, c2);
        n(eArr, c2, null);
        return g2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long t = t();
        while (true) {
            long q = q();
            long t2 = t();
            if (t == t2) {
                return (int) (q - t2);
            }
            t = t2;
        }
    }
}
