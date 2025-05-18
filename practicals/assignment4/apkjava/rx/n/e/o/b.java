package rx.n.e.o;

/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes3.dex */
abstract class b<E> extends d<E> {

    /* renamed from: g, reason: collision with root package name */
    protected static final long f26813g = z.a(b.class, "consumerNode");
    protected rx.n.e.n.c<E> consumerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final rx.n.e.n.c<E> f() {
        return this.consumerNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final rx.n.e.n.c<E> g() {
        return (rx.n.e.n.c) z.a.getObjectVolatile(this, f26813g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(rx.n.e.n.c<E> cVar) {
        this.consumerNode = cVar;
    }
}
