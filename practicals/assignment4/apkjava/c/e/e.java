package c.e;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<K, V> {
    private final LinkedHashMap<K, V> a;

    /* renamed from: b, reason: collision with root package name */
    private int f2923b;

    /* renamed from: c, reason: collision with root package name */
    private int f2924c;

    /* renamed from: d, reason: collision with root package name */
    private int f2925d;

    /* renamed from: e, reason: collision with root package name */
    private int f2926e;

    /* renamed from: f, reason: collision with root package name */
    private int f2927f;

    /* renamed from: g, reason: collision with root package name */
    private int f2928g;

    /* renamed from: h, reason: collision with root package name */
    private int f2929h;

    public e(int i2) {
        if (i2 > 0) {
            this.f2924c = i2;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int e(K k2, V v) {
        int f2 = f(k2, v);
        if (f2 >= 0) {
            return f2;
        }
        throw new IllegalStateException("Negative size: " + k2 + "=" + v);
    }

    protected V a(K k2) {
        return null;
    }

    protected void b(boolean z, K k2, V v, V v2) {
    }

    public final V c(K k2) {
        V v;
        if (k2 != null) {
            synchronized (this) {
                V v2 = this.a.get(k2);
                if (v2 != null) {
                    this.f2928g++;
                    return v2;
                }
                this.f2929h++;
                V a = a(k2);
                if (a == null) {
                    return null;
                }
                synchronized (this) {
                    this.f2926e++;
                    v = (V) this.a.put(k2, a);
                    if (v != null) {
                        this.a.put(k2, v);
                    } else {
                        this.f2923b += e(k2, a);
                    }
                }
                if (v != null) {
                    b(false, k2, a, v);
                    return v;
                }
                g(this.f2924c);
                return a;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V d(K k2, V v) {
        V put;
        if (k2 != null && v != null) {
            synchronized (this) {
                this.f2925d++;
                this.f2923b += e(k2, v);
                put = this.a.put(k2, v);
                if (put != null) {
                    this.f2923b -= e(k2, put);
                }
            }
            if (put != null) {
                b(false, k2, put, v);
            }
            g(this.f2924c);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }

    protected int f(K k2, V v) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(int i2) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f2923b >= 0 && (!this.a.isEmpty() || this.f2923b == 0)) {
                    if (this.f2923b <= i2 || this.a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.a.remove(key);
                    this.f2923b -= e(key, value);
                    this.f2927f++;
                } else {
                    break;
                }
            }
            b(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        int i2;
        int i3;
        i2 = this.f2928g;
        i3 = this.f2929h + i2;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f2924c), Integer.valueOf(this.f2928g), Integer.valueOf(this.f2929h), Integer.valueOf(i3 != 0 ? (i2 * 100) / i3 : 0));
    }
}
