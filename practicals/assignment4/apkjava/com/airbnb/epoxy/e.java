package com.airbnb.epoxy;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BoundViewHolders.java */
/* loaded from: classes.dex */
public class e implements Iterable<u> {

    /* renamed from: f, reason: collision with root package name */
    private final c.e.d<u> f8429f = new c.e.d<>();

    /* compiled from: BoundViewHolders.java */
    /* loaded from: classes.dex */
    private class b implements Iterator<u> {

        /* renamed from: f, reason: collision with root package name */
        private int f8430f;

        private b() {
            this.f8430f = 0;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u next() {
            if (hasNext()) {
                c.e.d dVar = e.this.f8429f;
                int i2 = this.f8430f;
                this.f8430f = i2 + 1;
                return (u) dVar.o(i2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8430f < e.this.f8429f.n();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void f(u uVar) {
        this.f8429f.k(uVar.getItemId(), uVar);
    }

    public void g(u uVar) {
        this.f8429f.l(uVar.getItemId());
    }

    @Override // java.lang.Iterable
    public Iterator<u> iterator() {
        return new b();
    }

    public int size() {
        return this.f8429f.n();
    }
}
