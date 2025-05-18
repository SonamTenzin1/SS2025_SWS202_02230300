package io.sentry;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: SynchronizedCollection.java */
/* loaded from: classes2.dex */
class l5<E> implements Collection<E>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final Collection<E> f22491f;

    /* renamed from: g, reason: collision with root package name */
    final Object f22492g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l5(Collection<E> collection) {
        if (collection != null) {
            this.f22491f = collection;
            this.f22492g = this;
            return;
        }
        throw new NullPointerException("Collection must not be null.");
    }

    @Override // java.util.Collection
    public boolean add(E e2) {
        boolean add;
        synchronized (this.f22492g) {
            add = c().add(e2);
        }
        return add;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.f22492g) {
            addAll = c().addAll(collection);
        }
        return addAll;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<E> c() {
        return this.f22491f;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.f22492g) {
            c().clear();
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f22492g) {
            contains = c().contains(obj);
        }
        return contains;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.f22492g) {
            containsAll = c().containsAll(collection);
        }
        return containsAll;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f22492g) {
            isEmpty = c().isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return c().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f22492g) {
            remove = c().remove(obj);
        }
        return remove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.f22492g) {
            removeAll = c().removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.f22492g) {
            retainAll = c().retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.f22492g) {
            size = c().size();
        }
        return size;
    }

    public String toString() {
        String obj;
        synchronized (this.f22492g) {
            obj = c().toString();
        }
        return obj;
    }
}
