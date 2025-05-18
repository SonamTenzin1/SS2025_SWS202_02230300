package com.airbnb.epoxy;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModelList.java */
/* loaded from: classes.dex */
public class c0 extends ArrayList<s<?>> {

    /* renamed from: f, reason: collision with root package name */
    private boolean f8410f;

    /* renamed from: g, reason: collision with root package name */
    private d f8411g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelList.java */
    /* loaded from: classes.dex */
    public class b implements Iterator<s<?>> {

        /* renamed from: f, reason: collision with root package name */
        int f8412f;

        /* renamed from: g, reason: collision with root package name */
        int f8413g;

        /* renamed from: h, reason: collision with root package name */
        int f8414h;

        private b() {
            this.f8413g = -1;
            this.f8414h = ((ArrayList) c0.this).modCount;
        }

        final void b() {
            if (((ArrayList) c0.this).modCount != this.f8414h) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public s<?> next() {
            b();
            int i2 = this.f8412f;
            this.f8412f = i2 + 1;
            this.f8413g = i2;
            return c0.this.get(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8412f != c0.this.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f8413g >= 0) {
                b();
                try {
                    c0.this.remove(this.f8413g);
                    this.f8412f = this.f8413g;
                    this.f8413g = -1;
                    this.f8414h = ((ArrayList) c0.this).modCount;
                    return;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelList.java */
    /* loaded from: classes.dex */
    public class c extends b implements ListIterator<s<?>> {
        c(int i2) {
            super();
            this.f8412f = i2;
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void add(s<?> sVar) {
            b();
            try {
                int i2 = this.f8412f;
                c0.this.add(i2, sVar);
                this.f8412f = i2 + 1;
                this.f8413g = -1;
                this.f8414h = ((ArrayList) c0.this).modCount;
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public s<?> previous() {
            b();
            int i2 = this.f8412f - 1;
            if (i2 >= 0) {
                this.f8412f = i2;
                this.f8413g = i2;
                return c0.this.get(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void set(s<?> sVar) {
            if (this.f8413g >= 0) {
                b();
                try {
                    c0.this.set(this.f8413g, sVar);
                    return;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f8412f != 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f8412f;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f8412f - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelList.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(int i2, int i3);

        void b(int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(int i2) {
        super(i2);
    }

    private void P(int i2, int i3) {
        d dVar;
        if (this.f8410f || (dVar = this.f8411g) == null) {
            return;
        }
        dVar.a(i2, i3);
    }

    private void R(int i2, int i3) {
        d dVar;
        if (this.f8410f || (dVar = this.f8411g) == null) {
            return;
        }
        dVar.b(i2, i3);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void add(int i2, s<?> sVar) {
        P(i2, 1);
        super.add(i2, sVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public boolean add(s<?> sVar) {
        P(size(), 1);
        return super.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() {
        if (!this.f8410f) {
            this.f8410f = true;
            return;
        }
        throw new IllegalStateException("Notifications already paused");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public s<?> remove(int i2) {
        R(i2, 1);
        return (s) super.remove(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        if (this.f8410f) {
            this.f8410f = false;
            return;
        }
        throw new IllegalStateException("Notifications already resumed");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public s<?> set(int i2, s<?> sVar) {
        s<?> sVar2 = (s) super.set(i2, sVar);
        if (sVar2.id() != sVar.id()) {
            R(i2, 1);
            P(i2, 1);
        }
        return sVar2;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends s<?>> collection) {
        P(size(), collection.size());
        return super.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(d dVar) {
        this.f8411g = dVar;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (isEmpty()) {
            return;
        }
        R(0, size());
        super.clear();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<s<?>> iterator() {
        return new b();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<s<?>> listIterator() {
        return new c(0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        Iterator<s<?>> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        R(i2, i3 - i2);
        super.removeRange(i2, i3);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        Iterator<s<?>> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<s<?>> subList(int i2, int i3) {
        if (i2 < 0 || i3 > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 <= i3) {
            return new e(this, i2, i3);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<s<?>> listIterator(int i2) {
        return new c(i2);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        R(indexOf, 1);
        super.remove(indexOf);
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends s<?>> collection) {
        P(i2, collection.size());
        return super.addAll(i2, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelList.java */
    /* loaded from: classes.dex */
    public static class e extends AbstractList<s<?>> {

        /* renamed from: f, reason: collision with root package name */
        private final c0 f8417f;

        /* renamed from: g, reason: collision with root package name */
        private int f8418g;

        /* renamed from: h, reason: collision with root package name */
        private int f8419h;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ModelList.java */
        /* loaded from: classes.dex */
        public static final class a implements ListIterator<s<?>> {

            /* renamed from: f, reason: collision with root package name */
            private final e f8420f;

            /* renamed from: g, reason: collision with root package name */
            private final ListIterator<s<?>> f8421g;

            /* renamed from: h, reason: collision with root package name */
            private int f8422h;

            /* renamed from: i, reason: collision with root package name */
            private int f8423i;

            a(ListIterator<s<?>> listIterator, e eVar, int i2, int i3) {
                this.f8421g = listIterator;
                this.f8420f = eVar;
                this.f8422h = i2;
                this.f8423i = i2 + i3;
            }

            @Override // java.util.ListIterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void add(s<?> sVar) {
                this.f8421g.add(sVar);
                this.f8420f.i(true);
                this.f8423i++;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public s<?> next() {
                if (this.f8421g.nextIndex() < this.f8423i) {
                    return this.f8421g.next();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public s<?> previous() {
                if (this.f8421g.previousIndex() >= this.f8422h) {
                    return this.f8421g.previous();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void set(s<?> sVar) {
                this.f8421g.set(sVar);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f8421g.nextIndex() < this.f8423i;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f8421g.previousIndex() >= this.f8422h;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f8421g.nextIndex() - this.f8422h;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                int previousIndex = this.f8421g.previousIndex();
                int i2 = this.f8422h;
                if (previousIndex >= i2) {
                    return previousIndex - i2;
                }
                return -1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                this.f8421g.remove();
                this.f8420f.i(false);
                this.f8423i--;
            }
        }

        e(c0 c0Var, int i2, int i3) {
            this.f8417f = c0Var;
            ((AbstractList) this).modCount = ((ArrayList) c0Var).modCount;
            this.f8418g = i2;
            this.f8419h = i3 - i2;
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i2, Collection<? extends s<?>> collection) {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                if (i2 >= 0 && i2 <= this.f8419h) {
                    boolean addAll = this.f8417f.addAll(i2 + this.f8418g, collection);
                    if (addAll) {
                        this.f8419h += collection.size();
                        ((AbstractList) this).modCount = ((ArrayList) this.f8417f).modCount;
                    }
                    return addAll;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void add(int i2, s<?> sVar) {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                if (i2 >= 0 && i2 <= this.f8419h) {
                    this.f8417f.add(i2 + this.f8418g, sVar);
                    this.f8419h++;
                    ((AbstractList) this).modCount = ((ArrayList) this.f8417f).modCount;
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public s<?> get(int i2) {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                if (i2 >= 0 && i2 < this.f8419h) {
                    return this.f8417f.get(i2 + this.f8418g);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public s<?> remove(int i2) {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                if (i2 >= 0 && i2 < this.f8419h) {
                    s<?> remove = this.f8417f.remove(i2 + this.f8418g);
                    this.f8419h--;
                    ((AbstractList) this).modCount = ((ArrayList) this.f8417f).modCount;
                    return remove;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public s<?> set(int i2, s<?> sVar) {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                if (i2 >= 0 && i2 < this.f8419h) {
                    return this.f8417f.set(i2 + this.f8418g, sVar);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        void i(boolean z) {
            if (z) {
                this.f8419h++;
            } else {
                this.f8419h--;
            }
            ((AbstractList) this).modCount = ((ArrayList) this.f8417f).modCount;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<s<?>> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<s<?>> listIterator(int i2) {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                if (i2 >= 0 && i2 <= this.f8419h) {
                    return new a(this.f8417f.listIterator(i2 + this.f8418g), this, this.f8418g, this.f8419h);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i2, int i3) {
            if (i2 != i3) {
                if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                    c0 c0Var = this.f8417f;
                    int i4 = this.f8418g;
                    c0Var.removeRange(i2 + i4, i4 + i3);
                    this.f8419h -= i3 - i2;
                    ((AbstractList) this).modCount = ((ArrayList) this.f8417f).modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                return this.f8419h;
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends s<?>> collection) {
            if (((AbstractList) this).modCount == ((ArrayList) this.f8417f).modCount) {
                boolean addAll = this.f8417f.addAll(this.f8418g + this.f8419h, collection);
                if (addAll) {
                    this.f8419h += collection.size();
                    ((AbstractList) this).modCount = ((ArrayList) this.f8417f).modCount;
                }
                return addAll;
            }
            throw new ConcurrentModificationException();
        }
    }
}
