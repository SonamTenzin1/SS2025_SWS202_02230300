package com.squareup.moshi;

import com.squareup.moshi.f;
import com.squareup.moshi.i;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardJsonAdapters.java */
/* loaded from: classes2.dex */
public final class t {
    public static final f.e a = new c();

    /* renamed from: b, reason: collision with root package name */
    static final com.squareup.moshi.f<Boolean> f20614b = new d();

    /* renamed from: c, reason: collision with root package name */
    static final com.squareup.moshi.f<Byte> f20615c = new e();

    /* renamed from: d, reason: collision with root package name */
    static final com.squareup.moshi.f<Character> f20616d = new f();

    /* renamed from: e, reason: collision with root package name */
    static final com.squareup.moshi.f<Double> f20617e = new g();

    /* renamed from: f, reason: collision with root package name */
    static final com.squareup.moshi.f<Float> f20618f = new h();

    /* renamed from: g, reason: collision with root package name */
    static final com.squareup.moshi.f<Integer> f20619g = new i();

    /* renamed from: h, reason: collision with root package name */
    static final com.squareup.moshi.f<Long> f20620h = new j();

    /* renamed from: i, reason: collision with root package name */
    static final com.squareup.moshi.f<Short> f20621i = new k();

    /* renamed from: j, reason: collision with root package name */
    static final com.squareup.moshi.f<String> f20622j = new a();

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class a extends com.squareup.moshi.f<String> {
        a() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String fromJson(com.squareup.moshi.i iVar) throws IOException {
            return iVar.y();
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, String str) throws IOException {
            oVar.N(str);
        }

        public String toString() {
            return "JsonAdapter(String)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.b.values().length];
            a = iArr;
            try {
                iArr[i.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[i.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class c implements f.e {
        c() {
        }

        @Override // com.squareup.moshi.f.e
        public com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return t.f20614b;
            }
            if (type == Byte.TYPE) {
                return t.f20615c;
            }
            if (type == Character.TYPE) {
                return t.f20616d;
            }
            if (type == Double.TYPE) {
                return t.f20617e;
            }
            if (type == Float.TYPE) {
                return t.f20618f;
            }
            if (type == Integer.TYPE) {
                return t.f20619g;
            }
            if (type == Long.TYPE) {
                return t.f20620h;
            }
            if (type == Short.TYPE) {
                return t.f20621i;
            }
            if (type == Boolean.class) {
                return t.f20614b.nullSafe();
            }
            if (type == Byte.class) {
                return t.f20615c.nullSafe();
            }
            if (type == Character.class) {
                return t.f20616d.nullSafe();
            }
            if (type == Double.class) {
                return t.f20617e.nullSafe();
            }
            if (type == Float.class) {
                return t.f20618f.nullSafe();
            }
            if (type == Integer.class) {
                return t.f20619g.nullSafe();
            }
            if (type == Long.class) {
                return t.f20620h.nullSafe();
            }
            if (type == Short.class) {
                return t.f20621i.nullSafe();
            }
            if (type == String.class) {
                return t.f20622j.nullSafe();
            }
            if (type == Object.class) {
                return new m(rVar).nullSafe();
            }
            Class<?> g2 = u.g(type);
            com.squareup.moshi.f<?> d2 = com.squareup.moshi.w.c.d(rVar, type, g2);
            if (d2 != null) {
                return d2;
            }
            if (g2.isEnum()) {
                return new l(g2).nullSafe();
            }
            return null;
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class d extends com.squareup.moshi.f<Boolean> {
        d() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Boolean.valueOf(iVar.k());
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Boolean bool) throws IOException {
            oVar.Q(bool.booleanValue());
        }

        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class e extends com.squareup.moshi.f<Byte> {
        e() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Byte.valueOf((byte) t.a(iVar, "a byte", -128, 255));
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Byte b2) throws IOException {
            oVar.J(b2.intValue() & 255);
        }

        public String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class f extends com.squareup.moshi.f<Character> {
        f() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character fromJson(com.squareup.moshi.i iVar) throws IOException {
            String y = iVar.y();
            if (y.length() <= 1) {
                return Character.valueOf(y.charAt(0));
            }
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", "a char", '\"' + y + '\"', iVar.g()));
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Character ch) throws IOException {
            oVar.N(ch.toString());
        }

        public String toString() {
            return "JsonAdapter(Character)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class g extends com.squareup.moshi.f<Double> {
        g() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Double.valueOf(iVar.l());
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Double d2) throws IOException {
            oVar.I(d2.doubleValue());
        }

        public String toString() {
            return "JsonAdapter(Double)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class h extends com.squareup.moshi.f<Float> {
        h() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float fromJson(com.squareup.moshi.i iVar) throws IOException {
            float l = (float) iVar.l();
            if (!iVar.j() && Float.isInfinite(l)) {
                throw new JsonDataException("JSON forbids NaN and infinities: " + l + " at path " + iVar.g());
            }
            return Float.valueOf(l);
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Float f2) throws IOException {
            f2.getClass();
            oVar.K(f2);
        }

        public String toString() {
            return "JsonAdapter(Float)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class i extends com.squareup.moshi.f<Integer> {
        i() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Integer.valueOf(iVar.m());
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Integer num) throws IOException {
            oVar.J(num.intValue());
        }

        public String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class j extends com.squareup.moshi.f<Long> {
        j() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Long.valueOf(iVar.p());
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Long l) throws IOException {
            oVar.J(l.longValue());
        }

        public String toString() {
            return "JsonAdapter(Long)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    class k extends com.squareup.moshi.f<Short> {
        k() {
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Short.valueOf((short) t.a(iVar, "a short", -32768, 32767));
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Short sh) throws IOException {
            oVar.J(sh.intValue());
        }

        public String toString() {
            return "JsonAdapter(Short)";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    static final class l<T extends Enum<T>> extends com.squareup.moshi.f<T> {
        private final Class<T> a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f20623b;

        /* renamed from: c, reason: collision with root package name */
        private final T[] f20624c;

        /* renamed from: d, reason: collision with root package name */
        private final i.a f20625d;

        l(Class<T> cls) {
            this.a = cls;
            try {
                T[] enumConstants = cls.getEnumConstants();
                this.f20624c = enumConstants;
                this.f20623b = new String[enumConstants.length];
                int i2 = 0;
                while (true) {
                    T[] tArr = this.f20624c;
                    if (i2 < tArr.length) {
                        String name = tArr[i2].name();
                        this.f20623b[i2] = com.squareup.moshi.w.c.m(name, cls.getField(name));
                        i2++;
                    } else {
                        this.f20625d = i.a.a(this.f20623b);
                        return;
                    }
                }
            } catch (NoSuchFieldException e2) {
                AssertionError assertionError = new AssertionError("Missing field in " + cls.getName());
                assertionError.initCause(e2);
                throw assertionError;
            }
        }

        @Override // com.squareup.moshi.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public T fromJson(com.squareup.moshi.i iVar) throws IOException {
            int I = iVar.I(this.f20625d);
            if (I != -1) {
                return this.f20624c[I];
            }
            String g2 = iVar.g();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.f20623b) + " but was " + iVar.y() + " at path " + g2);
        }

        @Override // com.squareup.moshi.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, T t) throws IOException {
            oVar.N(this.f20623b[t.ordinal()]);
        }

        public String toString() {
            return "JsonAdapter(" + this.a.getName() + ")";
        }
    }

    /* compiled from: StandardJsonAdapters.java */
    /* loaded from: classes2.dex */
    static final class m extends com.squareup.moshi.f<Object> {
        private final r a;

        /* renamed from: b, reason: collision with root package name */
        private final com.squareup.moshi.f<List> f20626b;

        /* renamed from: c, reason: collision with root package name */
        private final com.squareup.moshi.f<Map> f20627c;

        /* renamed from: d, reason: collision with root package name */
        private final com.squareup.moshi.f<String> f20628d;

        /* renamed from: e, reason: collision with root package name */
        private final com.squareup.moshi.f<Double> f20629e;

        /* renamed from: f, reason: collision with root package name */
        private final com.squareup.moshi.f<Boolean> f20630f;

        m(r rVar) {
            this.a = rVar;
            this.f20626b = rVar.c(List.class);
            this.f20627c = rVar.c(Map.class);
            this.f20628d = rVar.c(String.class);
            this.f20629e = rVar.c(Double.class);
            this.f20630f = rVar.c(Boolean.class);
        }

        private Class<?> a(Class<?> cls) {
            return Map.class.isAssignableFrom(cls) ? Map.class : Collection.class.isAssignableFrom(cls) ? Collection.class : cls;
        }

        @Override // com.squareup.moshi.f
        public Object fromJson(com.squareup.moshi.i iVar) throws IOException {
            switch (b.a[iVar.A().ordinal()]) {
                case 1:
                    return this.f20626b.fromJson(iVar);
                case 2:
                    return this.f20627c.fromJson(iVar);
                case 3:
                    return this.f20628d.fromJson(iVar);
                case 4:
                    return this.f20629e.fromJson(iVar);
                case 5:
                    return this.f20630f.fromJson(iVar);
                case 6:
                    return iVar.x();
                default:
                    throw new IllegalStateException("Expected a value but was " + iVar.A() + " at path " + iVar.g());
            }
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls == Object.class) {
                oVar.b();
                oVar.e();
            } else {
                this.a.e(a(cls), com.squareup.moshi.w.c.a).toJson(oVar, (o) obj);
            }
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    static int a(com.squareup.moshi.i iVar, String str, int i2, int i3) throws IOException {
        int m2 = iVar.m();
        if (m2 < i2 || m2 > i3) {
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", str, Integer.valueOf(m2), iVar.g()));
        }
        return m2;
    }
}
