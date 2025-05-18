package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldDescriptor.java */
/* loaded from: classes2.dex */
public final class b {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Object> f19580b;

    /* compiled from: FieldDescriptor.java */
    /* renamed from: com.google.firebase.encoders.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0228b {
        private final String a;

        /* renamed from: b, reason: collision with root package name */
        private Map<Class<?>, Object> f19581b = null;

        C0228b(String str) {
            this.a = str;
        }

        public b a() {
            Map unmodifiableMap;
            String str = this.a;
            if (this.f19581b == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(this.f19581b));
            }
            return new b(str, unmodifiableMap);
        }

        public <T extends Annotation> C0228b b(T t) {
            if (this.f19581b == null) {
                this.f19581b = new HashMap();
            }
            this.f19581b.put(t.annotationType(), t);
            return this;
        }
    }

    public static C0228b a(String str) {
        return new C0228b(str);
    }

    public static b d(String str) {
        return new b(str, Collections.emptyMap());
    }

    public String b() {
        return this.a;
    }

    public <T extends Annotation> T c(Class<T> cls) {
        return (T) this.f19580b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.f19580b.equals(bVar.f19580b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f19580b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.a + ", properties=" + this.f19580b.values() + "}";
    }

    private b(String str, Map<Class<?>, Object> map) {
        this.a = str;
        this.f19580b = map;
    }
}
