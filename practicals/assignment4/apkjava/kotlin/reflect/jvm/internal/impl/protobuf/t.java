package kotlin.reflect.jvm.internal.impl.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.reflect.jvm.internal.impl.protobuf.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmallSortedMap.java */
/* loaded from: classes3.dex */
public class t<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private final int f25470f;

    /* renamed from: g, reason: collision with root package name */
    private List<t<K, V>.c> f25471g;

    /* renamed from: h, reason: collision with root package name */
    private Map<K, V> f25472h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f25473i;

    /* renamed from: j, reason: collision with root package name */
    private volatile t<K, V>.e f25474j;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes3.dex */
    static class a<FieldDescriptorType> extends t<FieldDescriptorType, Object> {
        a(int i2) {
            super(i2, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.t
        public void n() {
            if (!m()) {
                for (int i2 = 0; i2 < j(); i2++) {
                    Map.Entry<FieldDescriptorType, Object> i3 = i(i2);
                    if (((g.b) i3.getKey()).h()) {
                        i3.setValue(Collections.unmodifiableList((List) i3.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : k()) {
                    if (((g.b) entry.getKey()).h()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.n();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.p((g.b) obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes3.dex */
    public static class b {
        private static final Iterator<Object> a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f25475b = new C0415b();

        /* compiled from: SmallSortedMap.java */
        /* loaded from: classes3.dex */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: SmallSortedMap.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.t$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static class C0415b implements Iterable<Object> {
            C0415b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f25475b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes3.dex */
    public class c implements Comparable<t<K, V>.c>, Map.Entry<K, V> {

        /* renamed from: f, reason: collision with root package name */
        private final K f25476f;

        /* renamed from: g, reason: collision with root package name */
        private V f25477g;

        c(t tVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean k(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return k(this.f25476f, entry.getKey()) && k(this.f25477g, entry.getValue());
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(t<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f25477g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f25476f;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f25477g;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f25476f;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            t.this.f();
            V v2 = this.f25477g;
            this.f25477g = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.f25476f);
            String valueOf2 = String.valueOf(this.f25477g);
            StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb.append(valueOf);
            sb.append("=");
            sb.append(valueOf2);
            return sb.toString();
        }

        c(K k2, V v) {
            this.f25476f = k2;
            this.f25477g = v;
        }
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes3.dex */
    private class e extends AbstractSet<Map.Entry<K, V>> {
        private e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            t.this.p(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            t.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = t.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(t.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            t.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return t.this.size();
        }

        /* synthetic */ e(t tVar, a aVar) {
            this();
        }
    }

    /* synthetic */ t(int i2, a aVar) {
        this(i2);
    }

    private int e(K k2) {
        int size = this.f25471g.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.f25471g.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo(this.f25471g.get(i3).getKey());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f25473i) {
            throw new UnsupportedOperationException();
        }
    }

    private void h() {
        f();
        if (!this.f25471g.isEmpty() || (this.f25471g instanceof ArrayList)) {
            return;
        }
        this.f25471g = new ArrayList(this.f25470f);
    }

    private SortedMap<K, V> l() {
        f();
        if (this.f25472h.isEmpty() && !(this.f25472h instanceof TreeMap)) {
            this.f25472h = new TreeMap();
        }
        return (SortedMap) this.f25472h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends g.b<FieldDescriptorType>> t<FieldDescriptorType, Object> o(int i2) {
        return new a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V q(int i2) {
        f();
        V value = this.f25471g.remove(i2).getValue();
        if (!this.f25472h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = l().entrySet().iterator();
            this.f25471g.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f25471g.isEmpty()) {
            this.f25471g.clear();
        }
        if (this.f25472h.isEmpty()) {
            return;
        }
        this.f25472h.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.f25472h.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f25474j == null) {
            this.f25474j = new e(this, null);
        }
        return this.f25474j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int e2 = e(comparable);
        if (e2 >= 0) {
            return this.f25471g.get(e2).getValue();
        }
        return this.f25472h.get(comparable);
    }

    public Map.Entry<K, V> i(int i2) {
        return this.f25471g.get(i2);
    }

    public int j() {
        return this.f25471g.size();
    }

    public Iterable<Map.Entry<K, V>> k() {
        return this.f25472h.isEmpty() ? b.b() : this.f25472h.entrySet();
    }

    public boolean m() {
        return this.f25473i;
    }

    public void n() {
        if (this.f25473i) {
            return;
        }
        this.f25472h = this.f25472h.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f25472h);
        this.f25473i = true;
    }

    public V p(K k2, V v) {
        f();
        int e2 = e(k2);
        if (e2 >= 0) {
            return this.f25471g.get(e2).setValue(v);
        }
        h();
        int i2 = -(e2 + 1);
        if (i2 >= this.f25470f) {
            return l().put(k2, v);
        }
        int size = this.f25471g.size();
        int i3 = this.f25470f;
        if (size == i3) {
            t<K, V>.c remove = this.f25471g.remove(i3 - 1);
            l().put(remove.getKey(), remove.getValue());
        }
        this.f25471g.add(i2, new c(k2, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int e2 = e(comparable);
        if (e2 >= 0) {
            return (V) q(e2);
        }
        if (this.f25472h.isEmpty()) {
            return null;
        }
        return this.f25472h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f25471g.size() + this.f25472h.size();
    }

    /* compiled from: SmallSortedMap.java */
    /* loaded from: classes3.dex */
    private class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: f, reason: collision with root package name */
        private int f25479f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f25480g;

        /* renamed from: h, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f25481h;

        private d() {
            this.f25479f = -1;
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f25481h == null) {
                this.f25481h = t.this.f25472h.entrySet().iterator();
            }
            return this.f25481h;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f25480g = true;
            int i2 = this.f25479f + 1;
            this.f25479f = i2;
            if (i2 < t.this.f25471g.size()) {
                return (Map.Entry) t.this.f25471g.get(this.f25479f);
            }
            return b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25479f + 1 < t.this.f25471g.size() || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f25480g) {
                this.f25480g = false;
                t.this.f();
                if (this.f25479f < t.this.f25471g.size()) {
                    t tVar = t.this;
                    int i2 = this.f25479f;
                    this.f25479f = i2 - 1;
                    tVar.q(i2);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ d(t tVar, a aVar) {
            this();
        }
    }

    private t(int i2) {
        this.f25470f = i2;
        this.f25471g = Collections.emptyList();
        this.f25472h = Collections.emptyMap();
    }
}
