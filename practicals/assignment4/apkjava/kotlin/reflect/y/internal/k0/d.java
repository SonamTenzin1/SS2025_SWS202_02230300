package kotlin.reflect.y.internal.k0;

/* compiled from: IntTreePMap.java */
/* loaded from: classes3.dex */
final class d<V> {
    private static final d<Object> a = new d<>(c.a);

    /* renamed from: b, reason: collision with root package name */
    private final c<V> f24954b;

    private d(c<V> cVar) {
        this.f24954b = cVar;
    }

    public static <V> d<V> a() {
        return (d<V>) a;
    }

    private d<V> d(c<V> cVar) {
        return cVar == this.f24954b ? this : new d<>(cVar);
    }

    public V b(int i2) {
        return this.f24954b.a(i2);
    }

    public d<V> c(int i2, V v) {
        return d(this.f24954b.b(i2, v));
    }
}
