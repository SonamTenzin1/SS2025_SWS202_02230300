package kotlin.reflect.y.internal.j0.m;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ArrayMap.kt */
/* loaded from: classes3.dex */
public final class o<T> extends c<T> {

    /* renamed from: f, reason: collision with root package name */
    private final T f24909f;

    /* renamed from: g, reason: collision with root package name */
    private final int f24910g;

    /* compiled from: ArrayMap.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, KMappedMarker {

        /* renamed from: f, reason: collision with root package name */
        private boolean f24911f = true;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ o<T> f24912g;

        a(o<T> oVar) {
            this.f24912g = oVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24911f;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f24911f) {
                this.f24911f = false;
                return this.f24912g.i();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(T t, int i2) {
        super(null);
        m.f(t, "value");
        this.f24909f = t;
        this.f24910g = i2;
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    public int c() {
        return 1;
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    public void f(int i2, T t) {
        m.f(t, "value");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    public T get(int i2) {
        if (i2 == this.f24910g) {
            return this.f24909f;
        }
        return null;
    }

    public final int h() {
        return this.f24910g;
    }

    public final T i() {
        return this.f24909f;
    }

    @Override // kotlin.reflect.y.internal.j0.m.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this);
    }
}
