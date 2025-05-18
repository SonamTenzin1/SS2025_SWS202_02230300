package kotlin.reflect.y.internal.j0.e.z;

import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.j;
import kotlin.reflect.y.internal.j0.e.k;
import kotlin.reflect.y.internal.j0.e.x;

/* compiled from: Flags.java */
/* loaded from: classes3.dex */
public class b {
    public static final C0370b A;
    public static final C0370b B;
    public static final C0370b C;
    public static final C0370b D;
    public static final C0370b E;
    public static final C0370b F;
    public static final C0370b G;
    public static final C0370b H;
    public static final C0370b I;
    public static final C0370b J;
    public static final C0370b K;
    public static final C0370b L;
    public static final C0370b M;
    public static final C0370b N;
    public static final C0370b O;
    public static final C0370b a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0370b f24182b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0370b f24183c;

    /* renamed from: d, reason: collision with root package name */
    public static final d<x> f24184d;

    /* renamed from: e, reason: collision with root package name */
    public static final d<k> f24185e;

    /* renamed from: f, reason: collision with root package name */
    public static final d<c.EnumC0365c> f24186f;

    /* renamed from: g, reason: collision with root package name */
    public static final C0370b f24187g;

    /* renamed from: h, reason: collision with root package name */
    public static final C0370b f24188h;

    /* renamed from: i, reason: collision with root package name */
    public static final C0370b f24189i;

    /* renamed from: j, reason: collision with root package name */
    public static final C0370b f24190j;

    /* renamed from: k, reason: collision with root package name */
    public static final C0370b f24191k;
    public static final C0370b l;
    public static final C0370b m;
    public static final C0370b n;
    public static final d<j> o;
    public static final C0370b p;
    public static final C0370b q;
    public static final C0370b r;
    public static final C0370b s;
    public static final C0370b t;
    public static final C0370b u;
    public static final C0370b v;
    public static final C0370b w;
    public static final C0370b x;
    public static final C0370b y;
    public static final C0370b z;

    /* compiled from: Flags.java */
    /* renamed from: kotlin.f0.y.e.j0.e.z.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0370b extends d<Boolean> {
        public C0370b(int i2) {
            super(i2, 1);
        }

        private static /* synthetic */ void f(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i2) {
            Boolean valueOf = Boolean.valueOf((i2 & (1 << this.a)) != 0);
            if (valueOf == null) {
                f(0);
            }
            return valueOf;
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Flags.java */
    /* loaded from: classes3.dex */
    public static class c<E extends i.a> extends d<E> {

        /* renamed from: c, reason: collision with root package name */
        private final E[] f24192c;

        public c(int i2, E[] eArr) {
            super(i2, g(eArr));
            this.f24192c = eArr;
        }

        private static /* synthetic */ void f(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i2 = 31; i2 >= 0; i2--) {
                if (((1 << i2) & length) != 0) {
                    return i2 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public E d(int i2) {
            int i3 = (1 << this.f24193b) - 1;
            int i4 = this.a;
            int i5 = (i2 & (i3 << i4)) >> i4;
            for (E e2 : this.f24192c) {
                if (e2.f() == i5) {
                    return e2;
                }
            }
            return null;
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(E e2) {
            return e2.f() << this.a;
        }
    }

    /* compiled from: Flags.java */
    /* loaded from: classes3.dex */
    public static abstract class d<E> {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f24193b;

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/i$a;>(Lkotlin/f0/y/e/j0/e/z/b$d<*>;[TE;)Lkotlin/f0/y/e/j0/e/z/b$d<TE;>; */
        public static d a(d dVar, i.a[] aVarArr) {
            return new c(dVar.a + dVar.f24193b, aVarArr);
        }

        public static C0370b b(d<?> dVar) {
            return new C0370b(dVar.a + dVar.f24193b);
        }

        public static C0370b c() {
            return new C0370b(0);
        }

        public abstract E d(int i2);

        public abstract int e(E e2);

        private d(int i2, int i3) {
            this.a = i2;
            this.f24193b = i3;
        }
    }

    static {
        C0370b c2 = d.c();
        a = c2;
        f24182b = d.b(c2);
        C0370b c3 = d.c();
        f24183c = c3;
        d<x> a2 = d.a(c3, x.values());
        f24184d = a2;
        d<k> a3 = d.a(a2, k.values());
        f24185e = a3;
        d<c.EnumC0365c> a4 = d.a(a3, c.EnumC0365c.values());
        f24186f = a4;
        C0370b b2 = d.b(a4);
        f24187g = b2;
        C0370b b3 = d.b(b2);
        f24188h = b3;
        C0370b b4 = d.b(b3);
        f24189i = b4;
        C0370b b5 = d.b(b4);
        f24190j = b5;
        C0370b b6 = d.b(b5);
        f24191k = b6;
        l = d.b(b6);
        C0370b b7 = d.b(a2);
        m = b7;
        n = d.b(b7);
        d<j> a5 = d.a(a3, j.values());
        o = a5;
        C0370b b8 = d.b(a5);
        p = b8;
        C0370b b9 = d.b(b8);
        q = b9;
        C0370b b10 = d.b(b9);
        r = b10;
        C0370b b11 = d.b(b10);
        s = b11;
        C0370b b12 = d.b(b11);
        t = b12;
        C0370b b13 = d.b(b12);
        u = b13;
        C0370b b14 = d.b(b13);
        v = b14;
        w = d.b(b14);
        C0370b b15 = d.b(a5);
        x = b15;
        C0370b b16 = d.b(b15);
        y = b16;
        C0370b b17 = d.b(b16);
        z = b17;
        C0370b b18 = d.b(b17);
        A = b18;
        C0370b b19 = d.b(b18);
        B = b19;
        C0370b b20 = d.b(b19);
        C = b20;
        C0370b b21 = d.b(b20);
        D = b21;
        C0370b b22 = d.b(b21);
        E = b22;
        F = d.b(b22);
        C0370b b23 = d.b(c3);
        G = b23;
        C0370b b24 = d.b(b23);
        H = b24;
        I = d.b(b24);
        C0370b b25 = d.b(a3);
        J = b25;
        C0370b b26 = d.b(b25);
        K = b26;
        L = d.b(b26);
        C0370b c4 = d.c();
        M = c4;
        N = d.b(c4);
        O = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 != 1) {
            if (i2 == 2) {
                objArr[0] = "kind";
            } else if (i2 != 5) {
                if (i2 != 6) {
                    if (i2 != 8) {
                        if (i2 != 9) {
                            if (i2 != 11) {
                                objArr[0] = "visibility";
                            }
                        }
                    }
                }
                objArr[0] = "memberKind";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
            switch (i2) {
                case 3:
                    objArr[2] = "getConstructorFlags";
                    break;
                case 4:
                case 5:
                case 6:
                    objArr[2] = "getFunctionFlags";
                    break;
                case 7:
                case 8:
                case 9:
                    objArr[2] = "getPropertyFlags";
                    break;
                case 10:
                case 11:
                    objArr[2] = "getAccessorFlags";
                    break;
                default:
                    objArr[2] = "getClassFlags";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        objArr[0] = "modality";
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i2) {
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static int b(boolean z2, x xVar, k kVar, boolean z3, boolean z4, boolean z5) {
        if (xVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return f24183c.e(Boolean.valueOf(z2)) | f24185e.e(kVar) | f24184d.e(xVar) | J.e(Boolean.valueOf(z3)) | K.e(Boolean.valueOf(z4)) | L.e(Boolean.valueOf(z5));
    }
}
