package rx.n.e.o;

import java.util.Iterator;

/* compiled from: ConcurrentCircularArrayQueue.java */
/* loaded from: classes3.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: f, reason: collision with root package name */
    protected static final int f26815f;

    /* renamed from: g, reason: collision with root package name */
    private static final long f26816g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f26817h;

    /* renamed from: i, reason: collision with root package name */
    protected final long f26818i;

    /* renamed from: j, reason: collision with root package name */
    protected final E[] f26819j;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        f26815f = intValue;
        int arrayIndexScale = z.a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f26817h = intValue + 2;
        } else if (8 == arrayIndexScale) {
            f26817h = intValue + 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        f26816g = r2.arrayBaseOffset(Object[].class) + (32 << (f26817h - intValue));
    }

    public f(int i2) {
        int b2 = j.b(i2);
        this.f26818i = b2 - 1;
        this.f26819j = (E[]) new Object[(b2 << f26815f) + 64];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long c(long j2) {
        return f(j2, this.f26818i);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    protected final long f(long j2, long j3) {
        return f26816g + ((j2 & j3) << f26817h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E g(E[] eArr, long j2) {
        return (E) z.a.getObject(eArr, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E h(long j2) {
        return i(this.f26819j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E i(E[] eArr, long j2) {
        return (E) z.a.getObjectVolatile(eArr, j2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(E[] eArr, long j2, E e2) {
        z.a.putOrderedObject(eArr, j2, e2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(E[] eArr, long j2, E e2) {
        z.a.putObject(eArr, j2, e2);
    }
}
