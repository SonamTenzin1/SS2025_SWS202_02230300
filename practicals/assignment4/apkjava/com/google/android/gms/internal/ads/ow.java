package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ow<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private final int f13120f;

    /* renamed from: g, reason: collision with root package name */
    private List<vw> f13121g;

    /* renamed from: h, reason: collision with root package name */
    private Map<K, V> f13122h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f13123i;

    /* renamed from: j, reason: collision with root package name */
    private volatile xw f13124j;

    /* renamed from: k, reason: collision with root package name */
    private Map<K, V> f13125k;
    private volatile rw l;

    private ow(int i2) {
        this.f13120f = i2;
        this.f13121g = Collections.emptyList();
        this.f13122h = Collections.emptyMap();
        this.f13125k = Collections.emptyMap();
    }

    private final int b(K k2) {
        int size = this.f13121g.size() - 1;
        if (size >= 0) {
            int compareTo = k2.compareTo((Comparable) this.f13121g.get(size).getKey());
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
            int compareTo2 = k2.compareTo((Comparable) this.f13121g.get(i3).getKey());
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
    public final void k() {
        if (this.f13123i) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> l() {
        k();
        if (this.f13122h.isEmpty() && !(this.f13122h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f13122h = treeMap;
            this.f13125k = treeMap.descendingMap();
        }
        return (SortedMap) this.f13122h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends zzdnu<FieldDescriptorType>> ow<FieldDescriptorType, Object> p(int i2) {
        return new pw(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V r(int i2) {
        k();
        V v = (V) this.f13121g.remove(i2).getValue();
        if (!this.f13122h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = l().entrySet().iterator();
            this.f13121g.add(new vw(this, it.next()));
            it.remove();
        }
        return v;
    }

    public final boolean a() {
        return this.f13123i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        k();
        if (!this.f13121g.isEmpty()) {
            this.f13121g.clear();
        }
        if (this.f13122h.isEmpty()) {
            return;
        }
        this.f13122h.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.f13122h.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final V put(K k2, V v) {
        k();
        int b2 = b(k2);
        if (b2 >= 0) {
            return (V) this.f13121g.get(b2).setValue(v);
        }
        k();
        if (this.f13121g.isEmpty() && !(this.f13121g instanceof ArrayList)) {
            this.f13121g = new ArrayList(this.f13120f);
        }
        int i2 = -(b2 + 1);
        if (i2 >= this.f13120f) {
            return l().put(k2, v);
        }
        int size = this.f13121g.size();
        int i3 = this.f13120f;
        if (size == i3) {
            vw remove = this.f13121g.remove(i3 - 1);
            l().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f13121g.add(i2, new vw(this, k2, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13124j == null) {
            this.f13124j = new xw(this, null);
        }
        return this.f13124j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ow)) {
            return super.equals(obj);
        }
        ow owVar = (ow) obj;
        int size = size();
        if (size != owVar.size()) {
            return false;
        }
        int h2 = h();
        if (h2 != owVar.h()) {
            return entrySet().equals(owVar.entrySet());
        }
        for (int i2 = 0; i2 < h2; i2++) {
            if (!q(i2).equals(owVar.q(i2))) {
                return false;
            }
        }
        if (h2 != size) {
            return this.f13122h.equals(owVar.f13122h);
        }
        return true;
    }

    public void f() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f13123i) {
            return;
        }
        if (this.f13122h.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f13122h);
        }
        this.f13122h = unmodifiableMap;
        if (this.f13125k.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f13125k);
        }
        this.f13125k = unmodifiableMap2;
        this.f13123i = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) this.f13121g.get(b2).getValue();
        }
        return this.f13122h.get(comparable);
    }

    public final int h() {
        return this.f13121g.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int h2 = h();
        int i2 = 0;
        for (int i3 = 0; i3 < h2; i3++) {
            i2 += this.f13121g.get(i3).hashCode();
        }
        return this.f13122h.size() > 0 ? i2 + this.f13122h.hashCode() : i2;
    }

    public final Iterable<Map.Entry<K, V>> i() {
        if (this.f13122h.isEmpty()) {
            return sw.a();
        }
        return this.f13122h.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> j() {
        if (this.l == null) {
            this.l = new rw(this, null);
        }
        return this.l;
    }

    public final Map.Entry<K, V> q(int i2) {
        return this.f13121g.get(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        k();
        Comparable comparable = (Comparable) obj;
        int b2 = b(comparable);
        if (b2 >= 0) {
            return (V) r(b2);
        }
        if (this.f13122h.isEmpty()) {
            return null;
        }
        return this.f13122h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13121g.size() + this.f13122h.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ow(int i2, pw pwVar) {
        this(i2);
    }
}
