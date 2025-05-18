package com.bumptech.glide.r;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class g<T, Y> {
    private final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    private final long f9550b;

    /* renamed from: c, reason: collision with root package name */
    private long f9551c;

    /* renamed from: d, reason: collision with root package name */
    private long f9552d;

    public g(long j2) {
        this.f9550b = j2;
        this.f9551c = j2;
    }

    private void f() {
        m(this.f9551c);
    }

    public void b() {
        m(0L);
    }

    public synchronized Y g(T t) {
        return this.a.get(t);
    }

    public synchronized long h() {
        return this.f9551c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i(Y y) {
        return 1;
    }

    protected void j(T t, Y y) {
    }

    public synchronized Y k(T t, Y y) {
        long i2 = i(y);
        if (i2 >= this.f9551c) {
            j(t, y);
            return null;
        }
        if (y != null) {
            this.f9552d += i2;
        }
        Y put = this.a.put(t, y);
        if (put != null) {
            this.f9552d -= i(put);
            if (!put.equals(y)) {
                j(t, put);
            }
        }
        f();
        return put;
    }

    public synchronized Y l(T t) {
        Y remove;
        remove = this.a.remove(t);
        if (remove != null) {
            this.f9552d -= i(remove);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void m(long j2) {
        while (this.f9552d > j2) {
            Iterator<Map.Entry<T, Y>> it = this.a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f9552d -= i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
