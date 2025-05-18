package com.bumptech.glide.load.engine.z;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class j implements com.bumptech.glide.load.engine.z.b {
    private final h<a, Object> a = new h<>();

    /* renamed from: b, reason: collision with root package name */
    private final b f9228b = new b();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f9229c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.engine.z.a<?>> f9230d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final int f9231e;

    /* renamed from: f, reason: collision with root package name */
    private int f9232f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class a implements m {
        private final b a;

        /* renamed from: b, reason: collision with root package name */
        int f9233b;

        /* renamed from: c, reason: collision with root package name */
        private Class<?> f9234c;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        void b(int i2, Class<?> cls) {
            this.f9233b = i2;
            this.f9234c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9233b == aVar.f9233b && this.f9234c == aVar.f9234c;
        }

        public int hashCode() {
            int i2 = this.f9233b * 31;
            Class<?> cls = this.f9234c;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f9233b + "array=" + this.f9234c + '}';
        }
    }

    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    private static final class b extends d<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.z.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i2, Class<?> cls) {
            a b2 = b();
            b2.b(i2, cls);
            return b2;
        }
    }

    public j(int i2) {
        this.f9231e = i2;
    }

    private void f(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> m = m(cls);
        Integer num = (Integer) m.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                m.remove(Integer.valueOf(i2));
                return;
            } else {
                m.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private void g() {
        h(this.f9231e);
    }

    private void h(int i2) {
        while (this.f9232f > i2) {
            Object f2 = this.a.f();
            com.bumptech.glide.r.j.d(f2);
            com.bumptech.glide.load.engine.z.a i3 = i(f2);
            this.f9232f -= i3.b(f2) * i3.a();
            f(i3.b(f2), f2.getClass());
            if (Log.isLoggable(i3.getTag(), 2)) {
                Log.v(i3.getTag(), "evicted: " + i3.b(f2));
            }
        }
    }

    private <T> com.bumptech.glide.load.engine.z.a<T> i(T t) {
        return j(t.getClass());
    }

    private <T> com.bumptech.glide.load.engine.z.a<T> j(Class<T> cls) {
        com.bumptech.glide.load.engine.z.a<T> aVar = (com.bumptech.glide.load.engine.z.a) this.f9230d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new i();
            } else if (cls.equals(byte[].class)) {
                aVar = new g();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f9230d.put(cls, aVar);
        }
        return aVar;
    }

    private <T> T k(a aVar) {
        return (T) this.a.a(aVar);
    }

    private <T> T l(a aVar, Class<T> cls) {
        com.bumptech.glide.load.engine.z.a<T> j2 = j(cls);
        T t = (T) k(aVar);
        if (t != null) {
            this.f9232f -= j2.b(t) * j2.a();
            f(j2.b(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(j2.getTag(), 2)) {
            Log.v(j2.getTag(), "Allocated " + aVar.f9233b + " bytes");
        }
        return j2.newArray(aVar.f9233b);
    }

    private NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f9229c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9229c.put(cls, treeMap);
        return treeMap;
    }

    private boolean n() {
        int i2 = this.f9232f;
        return i2 == 0 || this.f9231e / i2 >= 2;
    }

    private boolean o(int i2) {
        return i2 <= this.f9231e / 2;
    }

    private boolean p(int i2, Integer num) {
        return num != null && (n() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void a(int i2) {
        try {
            if (i2 >= 40) {
                b();
            } else if (i2 >= 20 || i2 == 15) {
                h(this.f9231e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized void b() {
        h(0);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T c(int i2, Class<T> cls) {
        return (T) l(this.f9228b.e(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> void d(T t) {
        Class<?> cls = t.getClass();
        com.bumptech.glide.load.engine.z.a<T> j2 = j(cls);
        int b2 = j2.b(t);
        int a2 = j2.a() * b2;
        if (o(a2)) {
            a e2 = this.f9228b.e(b2, cls);
            this.a.d(e2, t);
            NavigableMap<Integer, Integer> m = m(cls);
            Integer num = (Integer) m.get(Integer.valueOf(e2.f9233b));
            Integer valueOf = Integer.valueOf(e2.f9233b);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            m.put(valueOf, Integer.valueOf(i2));
            this.f9232f += a2;
            g();
        }
    }

    @Override // com.bumptech.glide.load.engine.z.b
    public synchronized <T> T e(int i2, Class<T> cls) {
        a e2;
        Integer ceilingKey = m(cls).ceilingKey(Integer.valueOf(i2));
        if (p(i2, ceilingKey)) {
            e2 = this.f9228b.e(ceilingKey.intValue(), cls);
        } else {
            e2 = this.f9228b.e(i2, cls);
        }
        return (T) l(e2, cls);
    }
}
