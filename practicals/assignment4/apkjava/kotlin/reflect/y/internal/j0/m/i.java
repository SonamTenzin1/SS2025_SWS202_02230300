package kotlin.reflect.y.internal.j0.m;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ArrayMap.kt */
/* loaded from: classes3.dex */
public final class i extends c {

    /* renamed from: f, reason: collision with root package name */
    public static final i f24904f = new i();

    /* compiled from: ArrayMap.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator, KMappedMarker {
        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private i() {
        super(null);
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    public int c() {
        return 0;
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Void get(int i2) {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.m.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void f(int i2, Void r2) {
        m.f(r2, "value");
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.y.internal.j0.m.c, java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }
}
