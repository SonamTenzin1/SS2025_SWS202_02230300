package com.squareup.moshi;

import com.squareup.moshi.f;
import com.squareup.moshi.i;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: ClassJsonAdapter.java */
/* loaded from: classes2.dex */
final class c<T> extends f<T> {
    public static final f.e a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final com.squareup.moshi.b<T> f20545b;

    /* renamed from: c, reason: collision with root package name */
    private final b<?>[] f20546c;

    /* renamed from: d, reason: collision with root package name */
    private final i.a f20547d;

    /* compiled from: ClassJsonAdapter.java */
    /* loaded from: classes2.dex */
    class a implements f.e {
        a() {
        }

        private void b(r rVar, Type type, Map<String, b<?>> map) {
            e eVar;
            Class<?> g2 = u.g(type);
            boolean i2 = com.squareup.moshi.w.c.i(g2);
            for (Field field : g2.getDeclaredFields()) {
                if (c(i2, field.getModifiers()) && ((eVar = (e) field.getAnnotation(e.class)) == null || !eVar.ignore())) {
                    Type p = com.squareup.moshi.w.c.p(type, g2, field.getGenericType());
                    Set<? extends Annotation> j2 = com.squareup.moshi.w.c.j(field);
                    String name = field.getName();
                    f<T> f2 = rVar.f(p, j2, name);
                    field.setAccessible(true);
                    String l = com.squareup.moshi.w.c.l(name, eVar);
                    b<?> bVar = new b<>(l, field, f2);
                    b<?> put = map.put(l, bVar);
                    if (put != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + put.f20548b + "\n    " + bVar.f20548b);
                    }
                }
            }
        }

        private boolean c(boolean z, int i2) {
            if (Modifier.isStatic(i2) || Modifier.isTransient(i2)) {
                return false;
            }
            return Modifier.isPublic(i2) || Modifier.isProtected(i2) || !z;
        }

        private void d(Type type, Class<?> cls) {
            Class<?> g2 = u.g(type);
            if (cls.isAssignableFrom(g2)) {
                throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + g2.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            }
        }

        @Override // com.squareup.moshi.f.e
        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> g2 = u.g(type);
            if (g2.isInterface() || g2.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (com.squareup.moshi.w.c.i(g2)) {
                d(type, List.class);
                d(type, Set.class);
                d(type, Map.class);
                d(type, Collection.class);
                String str = "Platform " + g2;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(str + " requires explicit JsonAdapter to be registered");
            }
            if (!g2.isAnonymousClass()) {
                if (!g2.isLocalClass()) {
                    if (g2.getEnclosingClass() != null && !Modifier.isStatic(g2.getModifiers())) {
                        throw new IllegalArgumentException("Cannot serialize non-static nested class " + g2.getName());
                    }
                    if (!Modifier.isAbstract(g2.getModifiers())) {
                        if (!com.squareup.moshi.w.c.h(g2)) {
                            com.squareup.moshi.b a = com.squareup.moshi.b.a(g2);
                            TreeMap treeMap = new TreeMap();
                            while (type != Object.class) {
                                b(rVar, type, treeMap);
                                type = u.f(type);
                            }
                            return new c(a, treeMap).nullSafe();
                        }
                        throw new IllegalArgumentException("Cannot serialize Kotlin type " + g2.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
                    }
                    throw new IllegalArgumentException("Cannot serialize abstract class " + g2.getName());
                }
                throw new IllegalArgumentException("Cannot serialize local class " + g2.getName());
            }
            throw new IllegalArgumentException("Cannot serialize anonymous class " + g2.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassJsonAdapter.java */
    /* loaded from: classes2.dex */
    public static class b<T> {
        final String a;

        /* renamed from: b, reason: collision with root package name */
        final Field f20548b;

        /* renamed from: c, reason: collision with root package name */
        final f<T> f20549c;

        b(String str, Field field, f<T> fVar) {
            this.a = str;
            this.f20548b = field;
            this.f20549c = fVar;
        }

        void a(i iVar, Object obj) throws IOException, IllegalAccessException {
            this.f20548b.set(obj, this.f20549c.fromJson(iVar));
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(o oVar, Object obj) throws IllegalAccessException, IOException {
            this.f20549c.toJson(oVar, (o) this.f20548b.get(obj));
        }
    }

    c(com.squareup.moshi.b<T> bVar, Map<String, b<?>> map) {
        this.f20545b = bVar;
        this.f20546c = (b[]) map.values().toArray(new b[map.size()]);
        this.f20547d = i.a.a((String[]) map.keySet().toArray(new String[map.size()]));
    }

    @Override // com.squareup.moshi.f
    public T fromJson(i iVar) throws IOException {
        try {
            T b2 = this.f20545b.b();
            try {
                iVar.b();
                while (iVar.f()) {
                    int H = iVar.H(this.f20547d);
                    if (H == -1) {
                        iVar.N();
                        iVar.Q();
                    } else {
                        this.f20546c[H].a(iVar, b2);
                    }
                }
                iVar.d();
                return b2;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw com.squareup.moshi.w.c.s(e3);
        }
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, T t) throws IOException {
        try {
            oVar.b();
            for (b<?> bVar : this.f20546c) {
                oVar.l(bVar.a);
                bVar.b(oVar, t);
            }
            oVar.e();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.f20545b + ")";
    }
}
