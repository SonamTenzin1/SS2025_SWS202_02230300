package rx.n.e.o;

/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
abstract class r<E> extends p<E> {
    private volatile long m;

    public r(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long u() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v(long j2) {
        this.m = j2;
    }
}
