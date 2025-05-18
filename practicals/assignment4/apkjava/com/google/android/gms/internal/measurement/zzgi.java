package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzgi<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private static final zzgi f17424f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17425g;

    static {
        zzgi zzgiVar = new zzgi();
        f17424f = zzgiVar;
        zzgiVar.f17425g = false;
    }

    private zzgi() {
        this.f17425g = true;
    }

    private static int b(Object obj) {
        if (obj instanceof byte[]) {
            return zzff.j((byte[]) obj);
        }
        if (!(obj instanceof zzfi)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static <K, V> zzgi<K, V> d() {
        return f17424f;
    }

    private final void j() {
        if (!this.f17425g) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        j();
        super.clear();
    }

    public final void e(zzgi<K, V> zzgiVar) {
        j();
        if (zzgiVar.isEmpty()) {
            return;
        }
        putAll(zzgiVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean z;
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Map.Entry<K, V> entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            V value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                                equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                            } else {
                                equals = value.equals(obj2);
                            }
                            if (!equals) {
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
            z = true;
            if (!z) {
            }
        }
        return false;
    }

    public final zzgi<K, V> f() {
        return isEmpty() ? new zzgi<>() : new zzgi<>(this);
    }

    public final void h() {
        this.f17425g = false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i2 += b(entry.getValue()) ^ b(entry.getKey());
        }
        return i2;
    }

    public final boolean i() {
        return this.f17425g;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v) {
        j();
        zzff.d(k2);
        zzff.d(v);
        return (V) super.put(k2, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        j();
        for (K k2 : map.keySet()) {
            zzff.d(k2);
            zzff.d(map.get(k2));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        j();
        return (V) super.remove(obj);
    }

    private zzgi(Map<K, V> map) {
        super(map);
        this.f17425g = true;
    }
}
