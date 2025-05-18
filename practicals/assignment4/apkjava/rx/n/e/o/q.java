package rx.n.e.o;

/* compiled from: SpmcArrayQueue.java */
/* loaded from: classes3.dex */
abstract class q<E> extends m<E> {

    /* renamed from: k, reason: collision with root package name */
    protected static final long f26820k = z.a(q.class, "producerIndex");
    private volatile long producerIndex;

    public q(int i2) {
        super(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long q() {
        return this.producerIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(long j2) {
        z.a.putOrderedLong(this, f26820k, j2);
    }
}
