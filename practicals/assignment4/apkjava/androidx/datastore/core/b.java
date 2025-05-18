package androidx.datastore.core;

/* compiled from: SingleProcessDataStore.kt */
/* loaded from: classes.dex */
final class b<T> extends m<T> {
    private final T a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1128b;

    public b(T t, int i2) {
        super(null);
        this.a = t;
        this.f1128b = i2;
    }

    public final void a() {
        T t = this.a;
        if (!((t != null ? t.hashCode() : 0) == this.f1128b)) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final T b() {
        return this.a;
    }
}
