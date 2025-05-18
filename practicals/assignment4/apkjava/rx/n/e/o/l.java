package rx.n.e.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
public abstract class l<E> extends n<E> {
    protected static final long l = z.a(l.class, "consumerIndex");
    private volatile long consumerIndex;

    public l(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean s(long j2, long j3) {
        return z.a.compareAndSwapLong(this, l, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long t() {
        return this.consumerIndex;
    }
}
