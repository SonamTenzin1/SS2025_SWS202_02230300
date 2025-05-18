package com.google.gson.t.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes2.dex */
public final class i implements r {

    /* renamed from: f, reason: collision with root package name */
    private final com.google.gson.t.c f20240f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.gson.d f20241g;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.gson.t.d f20242h;

    /* renamed from: i, reason: collision with root package name */
    private final d f20243i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.gson.t.o.b f20244j = com.google.gson.t.o.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public class a extends c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Field f20245d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f20246e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ q f20247f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f20248g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.u.a f20249h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f20250i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, Field field, boolean z3, q qVar, com.google.gson.e eVar, com.google.gson.u.a aVar, boolean z4) {
            super(str, z, z2);
            this.f20245d = field;
            this.f20246e = z3;
            this.f20247f = qVar;
            this.f20248g = eVar;
            this.f20249h = aVar;
            this.f20250i = z4;
        }

        @Override // com.google.gson.t.n.i.c
        void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException {
            Object b2 = this.f20247f.b(aVar);
            if (b2 == null && this.f20250i) {
                return;
            }
            this.f20245d.set(obj, b2);
        }

        @Override // com.google.gson.t.n.i.c
        void b(com.google.gson.stream.c cVar, Object obj) throws IOException, IllegalAccessException {
            (this.f20246e ? this.f20247f : new m(this.f20248g, this.f20247f, this.f20249h.getType())).d(cVar, this.f20245d.get(obj));
        }

        @Override // com.google.gson.t.n.i.c
        public boolean c(Object obj) throws IOException, IllegalAccessException {
            return this.f20253b && this.f20245d.get(obj) != obj;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public static final class b<T> extends q<T> {
        private final com.google.gson.t.i<T> a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, c> f20252b;

        b(com.google.gson.t.i<T> iVar, Map<String, c> map) {
            this.a = iVar;
            this.f20252b = map;
        }

        @Override // com.google.gson.q
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            T a = this.a.a();
            try {
                aVar.b();
                while (aVar.l()) {
                    c cVar = this.f20252b.get(aVar.D());
                    if (cVar != null && cVar.f20254c) {
                        cVar.a(aVar, a);
                    }
                    aVar.n0();
                }
                aVar.j();
                return a;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.y();
                return;
            }
            cVar.d();
            try {
                for (c cVar2 : this.f20252b.values()) {
                    if (cVar2.c(t)) {
                        cVar.p(cVar2.a);
                        cVar2.b(cVar, t);
                    }
                }
                cVar.j();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes2.dex */
    public static abstract class c {
        final String a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f20253b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f20254c;

        protected c(String str, boolean z, boolean z2) {
            this.a = str;
            this.f20253b = z;
            this.f20254c = z2;
        }

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IOException, IllegalAccessException;

        abstract void b(com.google.gson.stream.c cVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean c(Object obj) throws IOException, IllegalAccessException;
    }

    public i(com.google.gson.t.c cVar, com.google.gson.d dVar, com.google.gson.t.d dVar2, d dVar3) {
        this.f20240f = cVar;
        this.f20241g = dVar;
        this.f20242h = dVar2;
        this.f20243i = dVar3;
    }

    private c a(com.google.gson.e eVar, Field field, String str, com.google.gson.u.a<?> aVar, boolean z, boolean z2) {
        boolean b2 = com.google.gson.t.k.b(aVar.getRawType());
        com.google.gson.s.b bVar = (com.google.gson.s.b) field.getAnnotation(com.google.gson.s.b.class);
        q<?> a2 = bVar != null ? this.f20243i.a(this.f20240f, eVar, aVar, bVar) : null;
        boolean z3 = a2 != null;
        if (a2 == null) {
            a2 = eVar.j(aVar);
        }
        return new a(str, z, z2, field, z3, a2, eVar, aVar, b2);
    }

    static boolean d(Field field, boolean z, com.google.gson.t.d dVar) {
        return (dVar.e(field.getType(), z) || dVar.h(field, z)) ? false : true;
    }

    private Map<String, c> e(com.google.gson.e eVar, com.google.gson.u.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.u.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean c2 = c(field, true);
                boolean c3 = c(field, z);
                if (c2 || c3) {
                    this.f20244j.b(field);
                    Type p = com.google.gson.t.b.p(aVar2.getType(), cls2, field.getGenericType());
                    List<String> f2 = f(field);
                    int size = f2.size();
                    c cVar = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = f2.get(i3);
                        boolean z2 = i3 != 0 ? false : c2;
                        int i4 = i3;
                        c cVar2 = cVar;
                        int i5 = size;
                        List<String> list = f2;
                        Field field2 = field;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, a(eVar, field, str, com.google.gson.u.a.get(p), z2, c3)) : cVar2;
                        i3 = i4 + 1;
                        c2 = z2;
                        f2 = list;
                        size = i5;
                        field = field2;
                    }
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar3.a);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = com.google.gson.u.a.get(com.google.gson.t.b.p(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        com.google.gson.s.c cVar = (com.google.gson.s.c) field.getAnnotation(com.google.gson.s.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f20241g.g(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new b(this.f20240f.a(aVar), e(eVar, aVar, rawType));
        }
        return null;
    }

    public boolean c(Field field, boolean z) {
        return d(field, z, this.f20242h);
    }
}
