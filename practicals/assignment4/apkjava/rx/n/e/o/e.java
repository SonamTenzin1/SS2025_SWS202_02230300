package rx.n.e.o;

/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes3.dex */
abstract class e<E> extends c<E> {

    /* renamed from: f, reason: collision with root package name */
    protected static final long f26814f = z.a(e.class, "producerNode");
    protected rx.n.e.n.c<E> producerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final rx.n.e.n.c<E> c() {
        return (rx.n.e.n.c) z.a.getObjectVolatile(this, f26814f);
    }
}
