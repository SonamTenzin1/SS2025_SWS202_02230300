package kotlin.reflect.y.internal.k0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ConsPStack.java */
/* loaded from: classes3.dex */
final class a<E> implements Iterable<E> {

    /* renamed from: f, reason: collision with root package name */
    private static final a<Object> f24942f = new a<>();

    /* renamed from: g, reason: collision with root package name */
    final E f24943g;

    /* renamed from: h, reason: collision with root package name */
    final a<E> f24944h;

    /* renamed from: i, reason: collision with root package name */
    private final int f24945i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConsPStack.java */
    /* renamed from: kotlin.f0.y.e.k0.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0403a<E> implements Iterator<E> {

        /* renamed from: f, reason: collision with root package name */
        private a<E> f24946f;

        public C0403a(a<E> aVar) {
            this.f24946f = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return ((a) this.f24946f).f24945i > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.f24946f;
            E e2 = aVar.f24943g;
            this.f24946f = aVar.f24944h;
            return e2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private a() {
        this.f24945i = 0;
        this.f24943g = null;
        this.f24944h = null;
    }

    public static <E> a<E> f() {
        return (a<E>) f24942f;
    }

    private Iterator<E> g(int i2) {
        return new C0403a(o(i2));
    }

    private a<E> i(Object obj) {
        if (this.f24945i == 0) {
            return this;
        }
        if (this.f24943g.equals(obj)) {
            return this.f24944h;
        }
        a<E> i2 = this.f24944h.i(obj);
        return i2 == this.f24944h ? this : new a<>(this.f24943g, i2);
    }

    private a<E> o(int i2) {
        if (i2 < 0 || i2 > this.f24945i) {
            throw new IndexOutOfBoundsException();
        }
        return i2 == 0 ? this : this.f24944h.o(i2 - 1);
    }

    public E get(int i2) {
        if (i2 >= 0 && i2 <= this.f24945i) {
            try {
                return g(i2).next();
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException("Index: " + i2);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public a<E> h(int i2) {
        return i(get(i2));
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return g(0);
    }

    public a<E> n(E e2) {
        return new a<>(e2, this);
    }

    public int size() {
        return this.f24945i;
    }

    private a(E e2, a<E> aVar) {
        this.f24943g = e2;
        this.f24944h = aVar;
        this.f24945i = aVar.f24945i + 1;
    }
}
