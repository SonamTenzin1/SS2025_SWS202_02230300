package io.sentry;

import java.util.Queue;

/* compiled from: SynchronizedQueue.java */
/* loaded from: classes2.dex */
final class m5<E> extends l5<E> implements Queue<E> {
    private m5(Queue<E> queue) {
        super(queue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> m5<E> g(Queue<E> queue) {
        return new m5<>(queue);
    }

    @Override // java.util.Queue
    public E element() {
        E element;
        synchronized (this.f22492g) {
            element = c().element();
        }
        return element;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f22492g) {
            equals = c().equals(obj);
        }
        return equals;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.sentry.l5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Queue<E> c() {
        return (Queue) super.c();
    }

    @Override // java.util.Collection
    public int hashCode() {
        int hashCode;
        synchronized (this.f22492g) {
            hashCode = c().hashCode();
        }
        return hashCode;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        boolean offer;
        synchronized (this.f22492g) {
            offer = c().offer(e2);
        }
        return offer;
    }

    @Override // java.util.Queue
    public E peek() {
        E peek;
        synchronized (this.f22492g) {
            peek = c().peek();
        }
        return peek;
    }

    @Override // java.util.Queue
    public E poll() {
        E poll;
        synchronized (this.f22492g) {
            poll = c().poll();
        }
        return poll;
    }

    @Override // java.util.Queue
    public E remove() {
        E remove;
        synchronized (this.f22492g) {
            remove = c().remove();
        }
        return remove;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] array;
        synchronized (this.f22492g) {
            array = c().toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.f22492g) {
            tArr2 = (T[]) c().toArray(tArr);
        }
        return tArr2;
    }
}
