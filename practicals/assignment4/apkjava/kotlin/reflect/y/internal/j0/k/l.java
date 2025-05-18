package kotlin.reflect.y.internal.j0.k;

/* compiled from: SingleThreadValue.java */
/* loaded from: classes3.dex */
class l<T> {
    private final T a;

    /* renamed from: b, reason: collision with root package name */
    private final Thread f24671b = Thread.currentThread();

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(T t) {
        this.a = t;
    }

    public T a() {
        if (b()) {
            return this.a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f24671b == Thread.currentThread();
    }
}
