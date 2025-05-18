package h.a.z.f;

import h.a.z.c.e;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MpscLinkedQueue.java */
/* loaded from: classes2.dex */
public final class a<T> implements e<T> {

    /* renamed from: f, reason: collision with root package name */
    private final AtomicReference<C0299a<T>> f21623f = new AtomicReference<>();

    /* renamed from: g, reason: collision with root package name */
    private final AtomicReference<C0299a<T>> f21624g = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MpscLinkedQueue.java */
    /* renamed from: h.a.z.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0299a<E> extends AtomicReference<C0299a<E>> {

        /* renamed from: f, reason: collision with root package name */
        private E f21625f;

        C0299a() {
        }

        public E a() {
            E b2 = b();
            e(null);
            return b2;
        }

        public E b() {
            return this.f21625f;
        }

        public C0299a<E> c() {
            return get();
        }

        public void d(C0299a<E> c0299a) {
            lazySet(c0299a);
        }

        public void e(E e2) {
            this.f21625f = e2;
        }

        C0299a(E e2) {
            e(e2);
        }
    }

    public a() {
        C0299a<T> c0299a = new C0299a<>();
        d(c0299a);
        e(c0299a);
    }

    C0299a<T> a() {
        return this.f21624g.get();
    }

    C0299a<T> b() {
        return this.f21624g.get();
    }

    C0299a<T> c() {
        return this.f21623f.get();
    }

    @Override // h.a.z.c.f
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void d(C0299a<T> c0299a) {
        this.f21624g.lazySet(c0299a);
    }

    C0299a<T> e(C0299a<T> c0299a) {
        return this.f21623f.getAndSet(c0299a);
    }

    @Override // h.a.z.c.f
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // h.a.z.c.f
    public boolean offer(T t) {
        if (t != null) {
            C0299a<T> c0299a = new C0299a<>(t);
            e(c0299a).d(c0299a);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // h.a.z.c.e, h.a.z.c.f
    public T poll() {
        C0299a<T> c2;
        C0299a<T> a = a();
        C0299a<T> c3 = a.c();
        if (c3 != null) {
            T a2 = c3.a();
            d(c3);
            return a2;
        }
        if (a == c()) {
            return null;
        }
        do {
            c2 = a.c();
        } while (c2 == null);
        T a3 = c2.a();
        d(c2);
        return a3;
    }
}
