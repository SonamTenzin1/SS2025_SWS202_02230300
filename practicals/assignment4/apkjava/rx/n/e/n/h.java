package rx.n.e.n;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.n.e.o.j;

/* compiled from: SpscUnboundedAtomicArrayQueue.java */
/* loaded from: classes3.dex */
public final class h<T> implements Queue<T> {

    /* renamed from: f, reason: collision with root package name */
    static final int f26807f = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT).intValue();

    /* renamed from: g, reason: collision with root package name */
    private static final Object f26808g = new Object();

    /* renamed from: h, reason: collision with root package name */
    final AtomicLong f26809h;

    /* renamed from: i, reason: collision with root package name */
    int f26810i;

    /* renamed from: j, reason: collision with root package name */
    long f26811j;

    /* renamed from: k, reason: collision with root package name */
    int f26812k;
    AtomicReferenceArray<Object> l;
    int m;
    AtomicReferenceArray<Object> n;
    final AtomicLong o;

    public h(int i2) {
        int b2 = j.b(Math.max(8, i2));
        int i3 = b2 - 1;
        this.f26809h = new AtomicLong();
        this.o = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b2 + 1);
        this.l = atomicReferenceArray;
        this.f26812k = i3;
        c(b2);
        this.n = atomicReferenceArray;
        this.m = i3;
        this.f26811j = i3 - 1;
        y(0L);
    }

    private void c(int i2) {
        this.f26810i = Math.min(i2 / 4, f26807f);
    }

    private static int f(int i2) {
        return i2;
    }

    private static int g(long j2, int i2) {
        return f(((int) j2) & i2);
    }

    private long h() {
        return this.o.get();
    }

    private long i() {
        return this.f26809h.get();
    }

    private long n() {
        return this.o.get();
    }

    private static <E> Object o(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> q(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) o(atomicReferenceArray, f(atomicReferenceArray.length() - 1));
    }

    private long r() {
        return this.f26809h.get();
    }

    private T s(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.n = atomicReferenceArray;
        return (T) o(atomicReferenceArray, g(j2, i2));
    }

    private T t(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.n = atomicReferenceArray;
        int g2 = g(j2, i2);
        T t = (T) o(atomicReferenceArray, g2);
        if (t == null) {
            return null;
        }
        v(j2 + 1);
        w(atomicReferenceArray, g2, null);
        return t;
    }

    private void u(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.l = atomicReferenceArray2;
        this.f26811j = (j3 + j2) - 1;
        y(j2 + 1);
        w(atomicReferenceArray2, i2, t);
        x(atomicReferenceArray, atomicReferenceArray2);
        w(atomicReferenceArray, i2, f26808g);
    }

    private void v(long j2) {
        this.o.lazySet(j2);
    }

    private static void w(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void x(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        w(atomicReferenceArray, f(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void y(long j2) {
        this.f26809h.lazySet(j2);
    }

    private boolean z(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        y(j2 + 1);
        w(atomicReferenceArray, i2, t);
        return true;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return r() == n();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        t.getClass();
        AtomicReferenceArray<Object> atomicReferenceArray = this.l;
        long i2 = i();
        int i3 = this.f26812k;
        int g2 = g(i2, i3);
        if (i2 < this.f26811j) {
            return z(atomicReferenceArray, t, i2, g2);
        }
        long j2 = this.f26810i + i2;
        if (o(atomicReferenceArray, g(j2, i3)) == null) {
            this.f26811j = j2 - 1;
            return z(atomicReferenceArray, t, i2, g2);
        }
        if (o(atomicReferenceArray, g(1 + i2, i3)) != null) {
            return z(atomicReferenceArray, t, i2, g2);
        }
        u(atomicReferenceArray, i2, g2, t, i3);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.n;
        long h2 = h();
        int i2 = this.m;
        T t = (T) o(atomicReferenceArray, g(h2, i2));
        return t == f26808g ? s(q(atomicReferenceArray), h2, i2) : t;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.n;
        long h2 = h();
        int i2 = this.m;
        int g2 = g(h2, i2);
        T t = (T) o(atomicReferenceArray, g2);
        boolean z = t == f26808g;
        if (t == null || z) {
            if (z) {
                return t(q(atomicReferenceArray), h2, i2);
            }
            return null;
        }
        v(h2 + 1);
        w(atomicReferenceArray, g2, null);
        return t;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long n = n();
        while (true) {
            long r = r();
            long n2 = n();
            if (n == n2) {
                return (int) (r - n2);
            }
            n = n2;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
