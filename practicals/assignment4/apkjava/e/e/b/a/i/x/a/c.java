package e.e.b.a.i.x.a;

/* compiled from: InstanceFactory.java */
/* loaded from: classes2.dex */
public final class c<T> implements b<T> {
    private static final c<Object> a = new c<>(null);

    /* renamed from: b, reason: collision with root package name */
    private final T f20857b;

    private c(T t) {
        this.f20857b = t;
    }

    public static <T> b<T> a(T t) {
        return new c(d.c(t, "instance cannot be null"));
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.f20857b;
    }
}
