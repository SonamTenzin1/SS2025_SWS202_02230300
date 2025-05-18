package com.google.gson.t.n;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters.java */
/* loaded from: classes2.dex */
public final class n {
    public static final com.google.gson.q<String> A;
    public static final com.google.gson.q<BigDecimal> B;
    public static final com.google.gson.q<BigInteger> C;
    public static final com.google.gson.r D;
    public static final com.google.gson.q<StringBuilder> E;
    public static final com.google.gson.r F;
    public static final com.google.gson.q<StringBuffer> G;
    public static final com.google.gson.r H;
    public static final com.google.gson.q<URL> I;
    public static final com.google.gson.r J;
    public static final com.google.gson.q<URI> K;
    public static final com.google.gson.r L;
    public static final com.google.gson.q<InetAddress> M;
    public static final com.google.gson.r N;
    public static final com.google.gson.q<UUID> O;
    public static final com.google.gson.r P;
    public static final com.google.gson.q<Currency> Q;
    public static final com.google.gson.r R;
    public static final com.google.gson.r S;
    public static final com.google.gson.q<Calendar> T;
    public static final com.google.gson.r U;
    public static final com.google.gson.q<Locale> V;
    public static final com.google.gson.r W;
    public static final com.google.gson.q<com.google.gson.j> X;
    public static final com.google.gson.r Y;
    public static final com.google.gson.r Z;
    public static final com.google.gson.q<Class> a;

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.gson.r f20265b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.gson.q<BitSet> f20266c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.google.gson.r f20267d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f20268e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.gson.q<Boolean> f20269f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.gson.r f20270g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.google.gson.q<Number> f20271h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.gson.r f20272i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.google.gson.q<Number> f20273j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.google.gson.r f20274k;
    public static final com.google.gson.q<Number> l;
    public static final com.google.gson.r m;
    public static final com.google.gson.q<AtomicInteger> n;
    public static final com.google.gson.r o;
    public static final com.google.gson.q<AtomicBoolean> p;
    public static final com.google.gson.r q;
    public static final com.google.gson.q<AtomicIntegerArray> r;
    public static final com.google.gson.r s;
    public static final com.google.gson.q<Number> t;
    public static final com.google.gson.q<Number> u;
    public static final com.google.gson.q<Number> v;
    public static final com.google.gson.q<Number> w;
    public static final com.google.gson.r x;
    public static final com.google.gson.q<Character> y;
    public static final com.google.gson.r z;

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class a extends com.google.gson.q<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.l()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.A()));
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }
            aVar.f();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.c();
            int length = atomicIntegerArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.Q(atomicIntegerArray.get(i2));
            }
            cVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class a0 implements com.google.gson.r {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f20275f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f20276g;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* compiled from: TypeAdapters.java */
        /* loaded from: classes2.dex */
        class a<T1> extends com.google.gson.q<T1> {
            final /* synthetic */ Class a;

            a(Class cls) {
                this.a = cls;
            }

            @Override // com.google.gson.q
            public T1 b(com.google.gson.stream.a aVar) throws IOException {
                T1 t1 = (T1) a0.this.f20276g.b(aVar);
                if (t1 == null || this.a.isInstance(t1)) {
                    return t1;
                }
                throw new JsonSyntaxException("Expected a " + this.a.getName() + " but was " + t1.getClass().getName());
            }

            @Override // com.google.gson.q
            public void d(com.google.gson.stream.c cVar, T1 t1) throws IOException {
                a0.this.f20276g.d(cVar, t1);
            }
        }

        a0(Class cls, com.google.gson.q qVar) {
            this.f20275f = cls;
            this.f20276g = qVar;
        }

        @Override // com.google.gson.r
        public <T2> com.google.gson.q<T2> b(com.google.gson.e eVar, com.google.gson.u.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (this.f20275f.isAssignableFrom(rawType)) {
                return new a(rawType);
            }
            return null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f20275f.getName() + ",adapter=" + this.f20276g + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class b extends com.google.gson.q<Number> {
        b() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            try {
                return Long.valueOf(aVar.B());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.W(number);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b0 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.gson.stream.b.values().length];
            a = iArr;
            try {
                iArr[com.google.gson.stream.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.gson.stream.b.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.gson.stream.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.gson.stream.b.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.gson.stream.b.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.gson.stream.b.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.google.gson.stream.b.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.google.gson.stream.b.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.google.gson.stream.b.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.google.gson.stream.b.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class c extends com.google.gson.q<Number> {
        c() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return Float.valueOf((float) aVar.z());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.W(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class c0 extends com.google.gson.q<Boolean> {
        c0() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b Q = aVar.Q();
            if (Q == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            if (Q == com.google.gson.stream.b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.K()));
            }
            return Boolean.valueOf(aVar.y());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            cVar.T(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class d extends com.google.gson.q<Number> {
        d() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return Double.valueOf(aVar.z());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.W(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class d0 extends com.google.gson.q<Boolean> {
        d0() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return Boolean.valueOf(aVar.K());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Boolean bool) throws IOException {
            cVar.Y(bool == null ? "null" : bool.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class e extends com.google.gson.q<Number> {
        e() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b Q = aVar.Q();
            int i2 = b0.a[Q.ordinal()];
            if (i2 == 1 || i2 == 3) {
                return new com.google.gson.t.g(aVar.K());
            }
            if (i2 == 4) {
                aVar.I();
                return null;
            }
            throw new JsonSyntaxException("Expecting number, got: " + Q);
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.W(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class e0 extends com.google.gson.q<Number> {
        e0() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.W(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class f extends com.google.gson.q<Character> {
        f() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            String K = aVar.K();
            if (K.length() == 1) {
                return Character.valueOf(K.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + K);
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Character ch) throws IOException {
            cVar.Y(ch == null ? null : String.valueOf(ch));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class f0 extends com.google.gson.q<Number> {
        f0() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.W(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class g extends com.google.gson.q<String> {
        g() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b Q = aVar.Q();
            if (Q == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            if (Q == com.google.gson.stream.b.BOOLEAN) {
                return Boolean.toString(aVar.y());
            }
            return aVar.K();
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, String str) throws IOException {
            cVar.Y(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class g0 extends com.google.gson.q<Number> {
        g0() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            try {
                return Integer.valueOf(aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            cVar.W(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class h extends com.google.gson.q<BigDecimal> {
        h() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            try {
                return new BigDecimal(aVar.K());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.W(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class h0 extends com.google.gson.q<AtomicInteger> {
        h0() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.A());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.Q(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class i extends com.google.gson.q<BigInteger> {
        i() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            try {
                return new BigInteger(aVar.K());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, BigInteger bigInteger) throws IOException {
            cVar.W(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class i0 extends com.google.gson.q<AtomicBoolean> {
        i0() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.y());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.Z(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class j extends com.google.gson.q<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return new StringBuilder(aVar.K());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, StringBuilder sb) throws IOException {
            cVar.Y(sb == null ? null : sb.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    private static final class j0<T extends Enum<T>> extends com.google.gson.q<T> {
        private final Map<String, T> a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private final Map<T, String> f20278b = new HashMap();

        public j0(Class<T> cls) {
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    com.google.gson.s.c cVar = (com.google.gson.s.c) cls.getField(name).getAnnotation(com.google.gson.s.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.a.put(str, t);
                        }
                    }
                    this.a.put(name, t);
                    this.f20278b.put(t, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return this.a.get(aVar.K());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, T t) throws IOException {
            cVar.Y(t == null ? null : this.f20278b.get(t));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class k extends com.google.gson.q<Class> {
        k() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Class b(com.google.gson.stream.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class l extends com.google.gson.q<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return new StringBuffer(aVar.K());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.Y(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class m extends com.google.gson.q<URL> {
        m() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URL b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            String K = aVar.K();
            if ("null".equals(K)) {
                return null;
            }
            return new URL(K);
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, URL url) throws IOException {
            cVar.Y(url == null ? null : url.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: com.google.gson.t.n.n$n, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0245n extends com.google.gson.q<URI> {
        C0245n() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URI b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            try {
                String K = aVar.K();
                if ("null".equals(K)) {
                    return null;
                }
                return new URI(K);
            } catch (URISyntaxException e2) {
                throw new JsonIOException(e2);
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, URI uri) throws IOException {
            cVar.Y(uri == null ? null : uri.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class o extends com.google.gson.q<InetAddress> {
        o() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public InetAddress b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return InetAddress.getByName(aVar.K());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, InetAddress inetAddress) throws IOException {
            cVar.Y(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class p extends com.google.gson.q<UUID> {
        p() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public UUID b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            return UUID.fromString(aVar.K());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, UUID uuid) throws IOException {
            cVar.Y(uuid == null ? null : uuid.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class q extends com.google.gson.q<Currency> {
        q() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Currency b(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.K());
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Currency currency) throws IOException {
            cVar.Y(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class r implements com.google.gson.r {

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes2.dex */
        class a extends com.google.gson.q<Timestamp> {
            final /* synthetic */ com.google.gson.q a;

            a(com.google.gson.q qVar) {
                this.a = qVar;
            }

            @Override // com.google.gson.q
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Timestamp b(com.google.gson.stream.a aVar) throws IOException {
                Date date = (Date) this.a.b(aVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gson.q
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public void d(com.google.gson.stream.c cVar, Timestamp timestamp) throws IOException {
                this.a.d(cVar, timestamp);
            }
        }

        r() {
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            return new a(eVar.k(Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class s extends com.google.gson.q<Calendar> {
        s() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Calendar b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            aVar.b();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (aVar.Q() != com.google.gson.stream.b.END_OBJECT) {
                String D = aVar.D();
                int A = aVar.A();
                if ("year".equals(D)) {
                    i2 = A;
                } else if ("month".equals(D)) {
                    i3 = A;
                } else if ("dayOfMonth".equals(D)) {
                    i4 = A;
                } else if ("hourOfDay".equals(D)) {
                    i5 = A;
                } else if ("minute".equals(D)) {
                    i6 = A;
                } else if ("second".equals(D)) {
                    i7 = A;
                }
            }
            aVar.j();
            return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.y();
                return;
            }
            cVar.d();
            cVar.p("year");
            cVar.Q(calendar.get(1));
            cVar.p("month");
            cVar.Q(calendar.get(2));
            cVar.p("dayOfMonth");
            cVar.Q(calendar.get(5));
            cVar.p("hourOfDay");
            cVar.Q(calendar.get(11));
            cVar.p("minute");
            cVar.Q(calendar.get(12));
            cVar.p("second");
            cVar.Q(calendar.get(13));
            cVar.j();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class t extends com.google.gson.q<Locale> {
        t() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Locale b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() == com.google.gson.stream.b.NULL) {
                aVar.I();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.K(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Locale locale) throws IOException {
            cVar.Y(locale == null ? null : locale.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class u extends com.google.gson.q<com.google.gson.j> {
        u() {
        }

        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.gson.j b(com.google.gson.stream.a aVar) throws IOException {
            switch (b0.a[aVar.Q().ordinal()]) {
                case 1:
                    return new com.google.gson.m(new com.google.gson.t.g(aVar.K()));
                case 2:
                    return new com.google.gson.m(Boolean.valueOf(aVar.y()));
                case 3:
                    return new com.google.gson.m(aVar.K());
                case 4:
                    aVar.I();
                    return com.google.gson.k.a;
                case 5:
                    com.google.gson.g gVar = new com.google.gson.g();
                    aVar.a();
                    while (aVar.l()) {
                        gVar.q(b(aVar));
                    }
                    aVar.f();
                    return gVar;
                case 6:
                    com.google.gson.l lVar = new com.google.gson.l();
                    aVar.b();
                    while (aVar.l()) {
                        lVar.q(aVar.D(), b(aVar));
                    }
                    aVar.j();
                    return lVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, com.google.gson.j jVar) throws IOException {
            if (jVar != null && !jVar.i()) {
                if (jVar.o()) {
                    com.google.gson.m g2 = jVar.g();
                    if (g2.z()) {
                        cVar.W(g2.v());
                        return;
                    } else if (g2.x()) {
                        cVar.Z(g2.q());
                        return;
                    } else {
                        cVar.Y(g2.w());
                        return;
                    }
                }
                if (jVar.h()) {
                    cVar.c();
                    Iterator<com.google.gson.j> it = jVar.c().iterator();
                    while (it.hasNext()) {
                        d(cVar, it.next());
                    }
                    cVar.f();
                    return;
                }
                if (jVar.n()) {
                    cVar.d();
                    for (Map.Entry<String, com.google.gson.j> entry : jVar.f().r()) {
                        cVar.p(entry.getKey());
                        d(cVar, entry.getValue());
                    }
                    cVar.j();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + jVar.getClass());
            }
            cVar.y();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class v extends com.google.gson.q<BitSet> {
        v() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        
            if (java.lang.Integer.parseInt(r1) != 0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
        
            if (r8.A() != 0) goto L23;
         */
        @Override // com.google.gson.q
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BitSet b(com.google.gson.stream.a aVar) throws IOException {
            BitSet bitSet = new BitSet();
            aVar.a();
            com.google.gson.stream.b Q = aVar.Q();
            int i2 = 0;
            while (Q != com.google.gson.stream.b.END_ARRAY) {
                int i3 = b0.a[Q.ordinal()];
                boolean z = true;
                if (i3 != 1) {
                    if (i3 == 2) {
                        z = aVar.y();
                    } else if (i3 == 3) {
                        String K = aVar.K();
                        try {
                        } catch (NumberFormatException unused) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + K);
                        }
                    } else {
                        throw new JsonSyntaxException("Invalid bitset value type: " + Q);
                    }
                    if (z) {
                        bitSet.set(i2);
                    }
                    i2++;
                    Q = aVar.Q();
                }
            }
            aVar.f();
            return bitSet;
        }

        @Override // com.google.gson.q
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, BitSet bitSet) throws IOException {
            cVar.c();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                cVar.Q(bitSet.get(i2) ? 1L : 0L);
            }
            cVar.f();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    static class w implements com.google.gson.r {
        w() {
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                return null;
            }
            if (!rawType.isEnum()) {
                rawType = rawType.getSuperclass();
            }
            return new j0(rawType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class x implements com.google.gson.r {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f20280f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f20281g;

        x(Class cls, com.google.gson.q qVar) {
            this.f20280f = cls;
            this.f20281g = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            if (aVar.getRawType() == this.f20280f) {
                return this.f20281g;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f20280f.getName() + ",adapter=" + this.f20281g + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class y implements com.google.gson.r {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f20282f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Class f20283g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f20284h;

        y(Class cls, Class cls2, com.google.gson.q qVar) {
            this.f20282f = cls;
            this.f20283g = cls2;
            this.f20284h = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f20282f || rawType == this.f20283g) {
                return this.f20284h;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f20283g.getName() + "+" + this.f20282f.getName() + ",adapter=" + this.f20284h + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeAdapters.java */
    /* loaded from: classes2.dex */
    public static class z implements com.google.gson.r {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f20285f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Class f20286g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.q f20287h;

        z(Class cls, Class cls2, com.google.gson.q qVar) {
            this.f20285f = cls;
            this.f20286g = cls2;
            this.f20287h = qVar;
        }

        @Override // com.google.gson.r
        public <T> com.google.gson.q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType == this.f20285f || rawType == this.f20286g) {
                return this.f20287h;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f20285f.getName() + "+" + this.f20286g.getName() + ",adapter=" + this.f20287h + "]";
        }
    }

    static {
        com.google.gson.q<Class> a2 = new k().a();
        a = a2;
        f20265b = a(Class.class, a2);
        com.google.gson.q<BitSet> a3 = new v().a();
        f20266c = a3;
        f20267d = a(BitSet.class, a3);
        c0 c0Var = new c0();
        f20268e = c0Var;
        f20269f = new d0();
        f20270g = b(Boolean.TYPE, Boolean.class, c0Var);
        e0 e0Var = new e0();
        f20271h = e0Var;
        f20272i = b(Byte.TYPE, Byte.class, e0Var);
        f0 f0Var = new f0();
        f20273j = f0Var;
        f20274k = b(Short.TYPE, Short.class, f0Var);
        g0 g0Var = new g0();
        l = g0Var;
        m = b(Integer.TYPE, Integer.class, g0Var);
        com.google.gson.q<AtomicInteger> a4 = new h0().a();
        n = a4;
        o = a(AtomicInteger.class, a4);
        com.google.gson.q<AtomicBoolean> a5 = new i0().a();
        p = a5;
        q = a(AtomicBoolean.class, a5);
        com.google.gson.q<AtomicIntegerArray> a6 = new a().a();
        r = a6;
        s = a(AtomicIntegerArray.class, a6);
        t = new b();
        u = new c();
        v = new d();
        e eVar = new e();
        w = eVar;
        x = a(Number.class, eVar);
        f fVar = new f();
        y = fVar;
        z = b(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        B = new h();
        C = new i();
        D = a(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = a(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = a(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        J = a(URL.class, mVar);
        C0245n c0245n = new C0245n();
        K = c0245n;
        L = a(URI.class, c0245n);
        o oVar = new o();
        M = oVar;
        N = d(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = a(UUID.class, pVar);
        com.google.gson.q<Currency> a7 = new q().a();
        Q = a7;
        R = a(Currency.class, a7);
        S = new r();
        s sVar = new s();
        T = sVar;
        U = c(Calendar.class, GregorianCalendar.class, sVar);
        t tVar = new t();
        V = tVar;
        W = a(Locale.class, tVar);
        u uVar = new u();
        X = uVar;
        Y = d(com.google.gson.j.class, uVar);
        Z = new w();
    }

    public static <TT> com.google.gson.r a(Class<TT> cls, com.google.gson.q<TT> qVar) {
        return new x(cls, qVar);
    }

    public static <TT> com.google.gson.r b(Class<TT> cls, Class<TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new y(cls, cls2, qVar);
    }

    public static <TT> com.google.gson.r c(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.q<? super TT> qVar) {
        return new z(cls, cls2, qVar);
    }

    public static <T1> com.google.gson.r d(Class<T1> cls, com.google.gson.q<T1> qVar) {
        return new a0(cls, qVar);
    }
}
