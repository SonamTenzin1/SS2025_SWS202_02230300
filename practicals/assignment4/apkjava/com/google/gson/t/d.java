package com.google.gson.t;

import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Excluder.java */
/* loaded from: classes2.dex */
public final class d implements r, Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public static final d f20190f = new d();

    /* renamed from: j, reason: collision with root package name */
    private boolean f20194j;

    /* renamed from: g, reason: collision with root package name */
    private double f20191g = -1.0d;

    /* renamed from: h, reason: collision with root package name */
    private int f20192h = 136;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20193i = true;

    /* renamed from: k, reason: collision with root package name */
    private List<com.google.gson.a> f20195k = Collections.emptyList();
    private List<com.google.gson.a> l = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Excluder.java */
    /* loaded from: classes2.dex */
    class a<T> extends q<T> {
        private q<T> a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f20196b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f20197c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f20198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.google.gson.u.a f20199e;

        a(boolean z, boolean z2, com.google.gson.e eVar, com.google.gson.u.a aVar) {
            this.f20196b = z;
            this.f20197c = z2;
            this.f20198d = eVar;
            this.f20199e = aVar;
        }

        private q<T> e() {
            q<T> qVar = this.a;
            if (qVar != null) {
                return qVar;
            }
            q<T> l = this.f20198d.l(d.this, this.f20199e);
            this.a = l;
            return l;
        }

        @Override // com.google.gson.q
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (this.f20196b) {
                aVar.n0();
                return null;
            }
            return e().b(aVar);
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.c cVar, T t) throws IOException {
            if (this.f20197c) {
                cVar.y();
            } else {
                e().d(cVar, t);
            }
        }
    }

    private boolean f(Class<?> cls) {
        if (this.f20191g == -1.0d || n((com.google.gson.s.d) cls.getAnnotation(com.google.gson.s.d.class), (com.google.gson.s.e) cls.getAnnotation(com.google.gson.s.e.class))) {
            return (!this.f20193i && j(cls)) || i(cls);
        }
        return true;
    }

    private boolean g(Class<?> cls, boolean z) {
        Iterator<com.google.gson.a> it = (z ? this.f20195k : this.l).iterator();
        while (it.hasNext()) {
            if (it.next().b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean j(Class<?> cls) {
        return cls.isMemberClass() && !k(cls);
    }

    private boolean k(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean l(com.google.gson.s.d dVar) {
        return dVar == null || dVar.value() <= this.f20191g;
    }

    private boolean m(com.google.gson.s.e eVar) {
        return eVar == null || eVar.value() > this.f20191g;
    }

    private boolean n(com.google.gson.s.d dVar, com.google.gson.s.e eVar) {
        return l(dVar) && m(eVar);
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        boolean f2 = f(rawType);
        boolean z = f2 || g(rawType, true);
        boolean z2 = f2 || g(rawType, false);
        if (z || z2) {
            return new a(z2, z, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean e(Class<?> cls, boolean z) {
        return f(cls) || g(cls, z);
    }

    public boolean h(Field field, boolean z) {
        com.google.gson.s.a aVar;
        if ((this.f20192h & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f20191g != -1.0d && !n((com.google.gson.s.d) field.getAnnotation(com.google.gson.s.d.class), (com.google.gson.s.e) field.getAnnotation(com.google.gson.s.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f20194j && ((aVar = (com.google.gson.s.a) field.getAnnotation(com.google.gson.s.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f20193i && j(field.getType())) || i(field.getType())) {
            return true;
        }
        List<com.google.gson.a> list = z ? this.f20195k : this.l;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.b bVar = new com.google.gson.b(field);
        Iterator<com.google.gson.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(bVar)) {
                return true;
            }
        }
        return false;
    }
}
