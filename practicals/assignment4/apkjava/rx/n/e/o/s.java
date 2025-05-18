package rx.n.e.o;

/* compiled from: SpscArrayQueue.java */
/* loaded from: classes3.dex */
public final class s<E> extends x<E> {
    public s(int i2) {
        super(i2);
    }

    private long q() {
        return z.a.getLongVolatile(this, u.n);
    }

    private long r() {
        return z.a.getLongVolatile(this, y.m);
    }

    private void s(long j2) {
        z.a.putOrderedLong(this, u.n, j2);
    }

    private void t(long j2) {
        z.a.putOrderedLong(this, y.m, j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return r() == q();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            E[] eArr = this.f26819j;
            long j2 = this.producerIndex;
            long c2 = c(j2);
            if (i(eArr, c2) != null) {
                return false;
            }
            n(eArr, c2, e2);
            t(j2 + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        return h(c(this.consumerIndex));
    }

    @Override // java.util.Queue, rx.n.e.o.h
    public E poll() {
        long j2 = this.consumerIndex;
        long c2 = c(j2);
        E[] eArr = this.f26819j;
        E i2 = i(eArr, c2);
        if (i2 == null) {
            return null;
        }
        n(eArr, c2, null);
        s(j2 + 1);
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long q = q();
        while (true) {
            long r = r();
            long q2 = q();
            if (q == q2) {
                return (int) (r - q2);
            }
            q = q2;
        }
    }
}
