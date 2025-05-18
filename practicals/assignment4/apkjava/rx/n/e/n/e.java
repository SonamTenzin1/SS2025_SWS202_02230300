package rx.n.e.n;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscAtomicArrayQueue.java */
/* loaded from: classes3.dex */
public final class e<E> extends a<E> {

    /* renamed from: h, reason: collision with root package name */
    private static final Integer f26793h = Integer.getInteger("jctools.spsc.max.lookahead.step", RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);

    /* renamed from: i, reason: collision with root package name */
    final AtomicLong f26794i;

    /* renamed from: j, reason: collision with root package name */
    long f26795j;

    /* renamed from: k, reason: collision with root package name */
    final AtomicLong f26796k;
    final int l;

    public e(int i2) {
        super(i2);
        this.f26794i = new AtomicLong();
        this.f26796k = new AtomicLong();
        this.l = Math.min(i2 / 4, f26793h.intValue());
    }

    private long n() {
        return this.f26796k.get();
    }

    private long o() {
        return this.f26794i.get();
    }

    private void q(long j2) {
        this.f26796k.lazySet(j2);
    }

    private void r(long j2) {
        this.f26794i.lazySet(j2);
    }

    @Override // rx.n.e.n.a, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return o() == n();
    }

    @Override // rx.n.e.n.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f26788f;
            int i2 = this.f26789g;
            long j2 = this.f26794i.get();
            int f2 = f(j2, i2);
            if (j2 >= this.f26795j) {
                long j3 = this.l + j2;
                if (h(atomicReferenceArray, f(j3, i2)) == null) {
                    this.f26795j = j3;
                } else if (h(atomicReferenceArray, f2) != null) {
                    return false;
                }
            }
            i(atomicReferenceArray, f2, e2);
            r(j2 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public E peek() {
        return g(c(this.f26796k.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j2 = this.f26796k.get();
        int c2 = c(j2);
        AtomicReferenceArray<E> atomicReferenceArray = this.f26788f;
        E h2 = h(atomicReferenceArray, c2);
        if (h2 == null) {
            return null;
        }
        i(atomicReferenceArray, c2, null);
        q(j2 + 1);
        return h2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long n = n();
        while (true) {
            long o = o();
            long n2 = n();
            if (n == n2) {
                return (int) (o - n2);
            }
            n = n2;
        }
    }
}
