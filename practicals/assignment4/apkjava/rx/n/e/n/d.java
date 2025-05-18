package rx.n.e.n;

/* compiled from: MpscLinkedAtomicQueue.java */
/* loaded from: classes3.dex */
public final class d<E> extends b<E> {
    public d() {
        c<E> cVar = new c<>();
        h(cVar);
        i(cVar);
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            c<E> cVar = new c<>(e2);
            i(cVar).d(cVar);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        c<E> c2;
        c<E> c3 = c();
        c<E> c4 = c3.c();
        if (c4 != null) {
            return c4.b();
        }
        if (c3 == g()) {
            return null;
        }
        do {
            c2 = c3.c();
        } while (c2 == null);
        return c2.b();
    }

    @Override // java.util.Queue
    public E poll() {
        c<E> c2;
        c<E> c3 = c();
        c<E> c4 = c3.c();
        if (c4 != null) {
            E a = c4.a();
            h(c4);
            return a;
        }
        if (c3 == g()) {
            return null;
        }
        do {
            c2 = c3.c();
        } while (c2 == null);
        E a2 = c2.a();
        h(c2);
        return a2;
    }
}
