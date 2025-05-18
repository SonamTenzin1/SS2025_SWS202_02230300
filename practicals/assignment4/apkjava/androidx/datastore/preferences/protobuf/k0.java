package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a0;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: MapFieldLite.java */
/* loaded from: classes.dex */
public final class k0<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private static final k0 f1362f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1363g;

    static {
        k0 k0Var = new k0();
        f1362f = k0Var;
        k0Var.l();
    }

    private k0() {
        this.f1363g = true;
    }

    static <K, V> int b(Map<K, V> map) {
        int i2 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i2 += d(entry.getValue()) ^ d(entry.getKey());
        }
        return i2;
    }

    private static int d(Object obj) {
        if (obj instanceof byte[]) {
            return a0.d((byte[]) obj);
        }
        if (!(obj instanceof a0.c)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private static void e(Map<?, ?> map) {
        for (Object obj : map.keySet()) {
            a0.a(obj);
            a0.a(map.get(obj));
        }
    }

    public static <K, V> k0<K, V> f() {
        return f1362f;
    }

    private void h() {
        if (!k()) {
            throw new UnsupportedOperationException();
        }
    }

    private static boolean i(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return obj.equals(obj2);
    }

    static <K, V> boolean j(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !i(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && j(this, (Map) obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return b(this);
    }

    public boolean k() {
        return this.f1363g;
    }

    public void l() {
        this.f1363g = false;
    }

    public void m(k0<K, V> k0Var) {
        h();
        if (k0Var.isEmpty()) {
            return;
        }
        putAll(k0Var);
    }

    public k0<K, V> n() {
        return isEmpty() ? new k0<>() : new k0<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        h();
        a0.a(k2);
        a0.a(v);
        return (V) super.put(k2, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        h();
        e(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        return (V) super.remove(obj);
    }

    private k0(Map<K, V> map) {
        super(map);
        this.f1363g = true;
    }
}
