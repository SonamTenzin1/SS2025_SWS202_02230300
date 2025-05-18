package com.bumptech.glide.r.l;

import android.util.Log;
import c.i.j.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class a {
    private static final g<Object> a = new C0143a();

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.r.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0143a implements g<Object> {
        C0143a() {
        }

        @Override // com.bumptech.glide.r.l.a.g
        public void a(Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public class b<T> implements d<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.r.l.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.r.l.a.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public static final class e<T> implements c.i.j.f<T> {
        private final d<T> a;

        /* renamed from: b, reason: collision with root package name */
        private final g<T> f9557b;

        /* renamed from: c, reason: collision with root package name */
        private final c.i.j.f<T> f9558c;

        e(c.i.j.f<T> fVar, d<T> dVar, g<T> gVar) {
            this.f9558c = fVar;
            this.a = dVar;
            this.f9557b = gVar;
        }

        @Override // c.i.j.f
        public boolean a(T t) {
            if (t instanceof f) {
                ((f) t).u().b(true);
            }
            this.f9557b.a(t);
            return this.f9558c.a(t);
        }

        @Override // c.i.j.f
        public T b() {
            T b2 = this.f9558c.b();
            if (b2 == null) {
                b2 = this.a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + b2.getClass());
                }
            }
            if (b2 instanceof f) {
                b2.u().b(false);
            }
            return (T) b2;
        }
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface f {
        com.bumptech.glide.r.l.c u();
    }

    /* compiled from: FactoryPools.java */
    /* loaded from: classes.dex */
    public interface g<T> {
        void a(T t);
    }

    private static <T extends f> c.i.j.f<T> a(c.i.j.f<T> fVar, d<T> dVar) {
        return b(fVar, dVar, c());
    }

    private static <T> c.i.j.f<T> b(c.i.j.f<T> fVar, d<T> dVar, g<T> gVar) {
        return new e(fVar, dVar, gVar);
    }

    private static <T> g<T> c() {
        return (g<T>) a;
    }

    public static <T extends f> c.i.j.f<T> d(int i2, d<T> dVar) {
        return a(new h(i2), dVar);
    }

    public static <T> c.i.j.f<List<T>> e() {
        return f(20);
    }

    public static <T> c.i.j.f<List<T>> f(int i2) {
        return b(new h(i2), new b(), new c());
    }
}
