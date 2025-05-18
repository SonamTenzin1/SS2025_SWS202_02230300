package com.google.gson.t;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: LinkedTreeMap.java */
/* loaded from: classes2.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    private static final Comparator<Comparable> f20202f = new a();

    /* renamed from: g, reason: collision with root package name */
    Comparator<? super K> f20203g;

    /* renamed from: h, reason: collision with root package name */
    e<K, V> f20204h;

    /* renamed from: i, reason: collision with root package name */
    int f20205i;

    /* renamed from: j, reason: collision with root package name */
    int f20206j;

    /* renamed from: k, reason: collision with root package name */
    final e<K, V> f20207k;
    private h<K, V>.b l;
    private h<K, V>.c m;

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes2.dex */
        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return b();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> c2;
            if (!(obj instanceof Map.Entry) || (c2 = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(c2, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f20205i;
        }
    }

    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    final class c extends AbstractSet<K> {

        /* compiled from: LinkedTreeMap.java */
        /* loaded from: classes2.dex */
        class a extends h<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return b().f20221k;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.h(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f20205i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: f, reason: collision with root package name */
        e<K, V> f20212f;

        /* renamed from: g, reason: collision with root package name */
        e<K, V> f20213g = null;

        /* renamed from: h, reason: collision with root package name */
        int f20214h;

        d() {
            this.f20212f = h.this.f20207k.f20219i;
            this.f20214h = h.this.f20206j;
        }

        final e<K, V> b() {
            e<K, V> eVar = this.f20212f;
            h hVar = h.this;
            if (eVar != hVar.f20207k) {
                if (hVar.f20206j == this.f20214h) {
                    this.f20212f = eVar.f20219i;
                    this.f20213g = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f20212f != h.this.f20207k;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f20213g;
            if (eVar != null) {
                h.this.f(eVar, true);
                this.f20213g = null;
                this.f20214h = h.this.f20206j;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f20202f);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void e(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f20217g;
            e<K, V> eVar3 = eVar.f20218h;
            int i2 = eVar2 != null ? eVar2.m : 0;
            int i3 = eVar3 != null ? eVar3.m : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f20217g;
                e<K, V> eVar5 = eVar3.f20218h;
                int i5 = (eVar4 != null ? eVar4.m : 0) - (eVar5 != null ? eVar5.m : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    k(eVar3);
                    j(eVar);
                } else {
                    j(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f20217g;
                e<K, V> eVar7 = eVar2.f20218h;
                int i6 = (eVar6 != null ? eVar6.m : 0) - (eVar7 != null ? eVar7.m : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    j(eVar2);
                    k(eVar);
                } else {
                    k(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.m = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.m = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f20216f;
        }
    }

    private void i(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f20216f;
        eVar.f20216f = null;
        if (eVar2 != null) {
            eVar2.f20216f = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f20217g == eVar) {
                eVar3.f20217g = eVar2;
                return;
            } else {
                eVar3.f20218h = eVar2;
                return;
            }
        }
        this.f20204h = eVar2;
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f20217g;
        e<K, V> eVar3 = eVar.f20218h;
        e<K, V> eVar4 = eVar3.f20217g;
        e<K, V> eVar5 = eVar3.f20218h;
        eVar.f20218h = eVar4;
        if (eVar4 != null) {
            eVar4.f20216f = eVar;
        }
        i(eVar, eVar3);
        eVar3.f20217g = eVar;
        eVar.f20216f = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.m : 0, eVar4 != null ? eVar4.m : 0) + 1;
        eVar.m = max;
        eVar3.m = Math.max(max, eVar5 != null ? eVar5.m : 0) + 1;
    }

    private void k(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f20217g;
        e<K, V> eVar3 = eVar.f20218h;
        e<K, V> eVar4 = eVar2.f20217g;
        e<K, V> eVar5 = eVar2.f20218h;
        eVar.f20217g = eVar5;
        if (eVar5 != null) {
            eVar5.f20216f = eVar;
        }
        i(eVar, eVar2);
        eVar2.f20218h = eVar;
        eVar.f20216f = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.m : 0, eVar5 != null ? eVar5.m : 0) + 1;
        eVar.m = max;
        eVar2.m = Math.max(max, eVar4 != null ? eVar4.m : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    e<K, V> b(K k2, boolean z) {
        int i2;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f20203g;
        e<K, V> eVar2 = this.f20204h;
        if (eVar2 != null) {
            Comparable comparable = comparator == f20202f ? (Comparable) k2 : null;
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(eVar2.f20221k);
                } else {
                    i2 = comparator.compare(k2, eVar2.f20221k);
                }
                if (i2 == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i2 < 0 ? eVar2.f20217g : eVar2.f20218h;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.f20207k;
        if (eVar2 == null) {
            if (comparator == f20202f && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k2, eVar4, eVar4.f20220j);
            this.f20204h = eVar;
        } else {
            eVar = new e<>(eVar2, k2, eVar4, eVar4.f20220j);
            if (i2 < 0) {
                eVar2.f20217g = eVar;
            } else {
                eVar2.f20218h = eVar;
            }
            e(eVar2, true);
        }
        this.f20205i++;
        this.f20206j++;
        return eVar;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> d2 = d(entry.getKey());
        if (d2 != null && a(d2.l, entry.getValue())) {
            return d2;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f20204h = null;
        this.f20205i = 0;
        this.f20206j++;
        e<K, V> eVar = this.f20207k;
        eVar.f20220j = eVar;
        eVar.f20219i = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.l;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.l = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f20220j;
            eVar2.f20219i = eVar.f20219i;
            eVar.f20219i.f20220j = eVar2;
        }
        e<K, V> eVar3 = eVar.f20217g;
        e<K, V> eVar4 = eVar.f20218h;
        e<K, V> eVar5 = eVar.f20216f;
        int i3 = 0;
        if (eVar3 != null && eVar4 != null) {
            e<K, V> b2 = eVar3.m > eVar4.m ? eVar3.b() : eVar4.a();
            f(b2, false);
            e<K, V> eVar6 = eVar.f20217g;
            if (eVar6 != null) {
                i2 = eVar6.m;
                b2.f20217g = eVar6;
                eVar6.f20216f = b2;
                eVar.f20217g = null;
            } else {
                i2 = 0;
            }
            e<K, V> eVar7 = eVar.f20218h;
            if (eVar7 != null) {
                i3 = eVar7.m;
                b2.f20218h = eVar7;
                eVar7.f20216f = b2;
                eVar.f20218h = null;
            }
            b2.m = Math.max(i2, i3) + 1;
            i(eVar, b2);
            return;
        }
        if (eVar3 != null) {
            i(eVar, eVar3);
            eVar.f20217g = null;
        } else if (eVar4 != null) {
            i(eVar, eVar4);
            eVar.f20218h = null;
        } else {
            i(eVar, null);
        }
        e(eVar5, false);
        this.f20205i--;
        this.f20206j++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            return d2.l;
        }
        return null;
    }

    e<K, V> h(Object obj) {
        e<K, V> d2 = d(obj);
        if (d2 != null) {
            f(d2, true);
        }
        return d2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.m;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.m = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        if (k2 != null) {
            e<K, V> b2 = b(k2, true);
            V v2 = b2.l;
            b2.l = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> h2 = h(obj);
        if (h2 != null) {
            return h2.l;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f20205i;
    }

    public h(Comparator<? super K> comparator) {
        this.f20205i = 0;
        this.f20206j = 0;
        this.f20207k = new e<>();
        this.f20203g = comparator == null ? f20202f : comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinkedTreeMap.java */
    /* loaded from: classes2.dex */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: f, reason: collision with root package name */
        e<K, V> f20216f;

        /* renamed from: g, reason: collision with root package name */
        e<K, V> f20217g;

        /* renamed from: h, reason: collision with root package name */
        e<K, V> f20218h;

        /* renamed from: i, reason: collision with root package name */
        e<K, V> f20219i;

        /* renamed from: j, reason: collision with root package name */
        e<K, V> f20220j;

        /* renamed from: k, reason: collision with root package name */
        final K f20221k;
        V l;
        int m;

        e() {
            this.f20221k = null;
            this.f20220j = this;
            this.f20219i = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f20217g; eVar2 != null; eVar2 = eVar2.f20217g) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f20218h; eVar2 != null; eVar2 = eVar2.f20218h) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f20221k;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.l;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f20221k;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.l;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f20221k;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.l;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.l;
            this.l = v;
            return v2;
        }

        public String toString() {
            return this.f20221k + "=" + this.l;
        }

        e(e<K, V> eVar, K k2, e<K, V> eVar2, e<K, V> eVar3) {
            this.f20216f = eVar;
            this.f20221k = k2;
            this.m = 1;
            this.f20219i = eVar2;
            this.f20220j = eVar3;
            eVar3.f20219i = this;
            eVar2.f20220j = this;
        }
    }
}
