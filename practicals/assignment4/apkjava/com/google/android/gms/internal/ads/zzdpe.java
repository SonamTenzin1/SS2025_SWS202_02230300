package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzdpe<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: f, reason: collision with root package name */
    private static final zzdpe f16049f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f16050g;

    static {
        zzdpe zzdpeVar = new zzdpe();
        f16049f = zzdpeVar;
        zzdpeVar.f16050g = false;
    }

    private zzdpe() {
        this.f16050g = true;
    }

    private static int e(Object obj) {
        if (obj instanceof byte[]) {
            return zzdod.b((byte[]) obj);
        }
        if (!(obj instanceof zzdoe)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static <K, V> zzdpe<K, V> h() {
        return f16049f;
    }

    private final void j() {
        if (!this.f16050g) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean b() {
        return this.f16050g;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        j();
        super.clear();
    }

    public final void d(zzdpe<K, V> zzdpeVar) {
        j();
        if (zzdpeVar.isEmpty()) {
            return;
        }
        putAll(zzdpeVar);
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

    public final void f() {
        this.f16050g = false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i2 += e(entry.getValue()) ^ e(entry.getKey());
        }
        return i2;
    }

    public final zzdpe<K, V> i() {
        return isEmpty() ? new zzdpe<>() : new zzdpe<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v) {
        j();
        zzdod.a(k2);
        zzdod.a(v);
        return (V) super.put(k2, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        j();
        for (K k2 : map.keySet()) {
            zzdod.a(k2);
            zzdod.a(map.get(k2));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        j();
        return (V) super.remove(obj);
    }

    private zzdpe(Map<K, V> map) {
        super(map);
        this.f16050g = true;
    }
}
