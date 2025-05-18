package h.a.x;

/* compiled from: RunnableDisposable.java */
/* loaded from: classes2.dex */
final class f extends e<Runnable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Runnable runnable) {
        super(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.a.x.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + q() + ", " + get() + ")";
    }
}
