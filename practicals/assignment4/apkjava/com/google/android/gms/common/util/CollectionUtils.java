package com.google.android.gms.common.util;

import c.e.a;
import c.e.b;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> a() {
        return Collections.emptyList();
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> b(T t) {
        return Collections.singletonList(t);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> c(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return a();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return b(tArr[0]);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> d(K k2, V v, K k3, V v2, K k4, V v3) {
        Map h2 = h(3, false);
        h2.put(k2, v);
        h2.put(k3, v2);
        h2.put(k4, v3);
        return Collections.unmodifiableMap(h2);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> e(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length != 1) {
            Map h2 = h(length, false);
            for (int i2 = 0; i2 < kArr.length; i2++) {
                h2.put(kArr[i2], vArr[i2]);
            }
            return Collections.unmodifiableMap(h2);
        }
        return Collections.singletonMap(kArr[0], vArr[0]);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> f(T t, T t2, T t3) {
        Set i2 = i(3, false);
        i2.add(t);
        i2.add(t2);
        i2.add(t3);
        return Collections.unmodifiableSet(i2);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> g(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set i2 = i(2, false);
            i2.add(t);
            i2.add(t2);
            return Collections.unmodifiableSet(i2);
        }
        if (length == 3) {
            return f(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set i3 = i(length, false);
            Collections.addAll(i3, tArr);
            return Collections.unmodifiableSet(i3);
        }
        T t3 = tArr[0];
        T t4 = tArr[1];
        T t5 = tArr[2];
        T t6 = tArr[3];
        Set i4 = i(4, false);
        i4.add(t3);
        i4.add(t4);
        i4.add(t5);
        i4.add(t6);
        return Collections.unmodifiableSet(i4);
    }

    private static Map h(int i2, boolean z) {
        if (i2 <= 256) {
            return new a(i2);
        }
        return new HashMap(i2, 1.0f);
    }

    private static Set i(int i2, boolean z) {
        float f2 = true != z ? 1.0f : 0.75f;
        if (i2 <= (true != z ? 256 : 128)) {
            return new b(i2);
        }
        return new HashSet(i2, f2);
    }
}
