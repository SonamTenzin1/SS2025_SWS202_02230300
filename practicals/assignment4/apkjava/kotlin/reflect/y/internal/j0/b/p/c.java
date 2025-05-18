package kotlin.reflect.y.internal.j0.b.p;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.text.u;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'i' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: FunctionClassKind.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public static final a f23232f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f23233g = new c("Function", 0, k.r, "Function", false, false);

    /* renamed from: h, reason: collision with root package name */
    public static final c f23234h = new c("SuspendFunction", 1, k.f23199j, "SuspendFunction", true, false);

    /* renamed from: i, reason: collision with root package name */
    public static final c f23235i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f23236j;

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ c[] f23237k;
    private final kotlin.reflect.y.internal.j0.f.c l;
    private final String m;
    private final boolean n;
    private final boolean o;

    /* compiled from: FunctionClassKind.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: FunctionClassKind.kt */
        /* renamed from: kotlin.f0.y.e.j0.b.p.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0323a {
            private final c a;

            /* renamed from: b, reason: collision with root package name */
            private final int f23238b;

            public C0323a(c cVar, int i2) {
                m.f(cVar, "kind");
                this.a = cVar;
                this.f23238b = i2;
            }

            public final c a() {
                return this.a;
            }

            public final int b() {
                return this.f23238b;
            }

            public final c c() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0323a)) {
                    return false;
                }
                C0323a c0323a = (C0323a) obj;
                return this.a == c0323a.a && this.f23238b == c0323a.f23238b;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.f23238b;
            }

            public String toString() {
                return "KindWithArity(kind=" + this.a + ", arity=" + this.f23238b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int charAt = str.charAt(i3) - '0';
                if (!(charAt >= 0 && charAt < 10)) {
                    return null;
                }
                i2 = (i2 * 10) + charAt;
            }
            return Integer.valueOf(i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[LOOP:0: B:2:0x0011->B:10:0x0032, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0030 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final c a(kotlin.reflect.y.internal.j0.f.c cVar, String str) {
            boolean z;
            boolean E;
            m.f(cVar, "packageFqName");
            m.f(str, "className");
            for (c cVar2 : c.values()) {
                if (m.a(cVar2.q(), cVar)) {
                    E = u.E(str, cVar2.k(), false, 2, null);
                    if (E) {
                        z = true;
                        if (!z) {
                            return cVar2;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            }
            return null;
        }

        public final c b(String str, kotlin.reflect.y.internal.j0.f.c cVar) {
            m.f(str, "className");
            m.f(cVar, "packageFqName");
            C0323a c2 = c(str, cVar);
            if (c2 != null) {
                return c2.c();
            }
            return null;
        }

        public final C0323a c(String str, kotlin.reflect.y.internal.j0.f.c cVar) {
            m.f(str, "className");
            m.f(cVar, "packageFqName");
            c a = a(cVar, str);
            if (a == null) {
                return null;
            }
            String substring = str.substring(a.k().length());
            m.e(substring, "this as java.lang.String).substring(startIndex)");
            Integer d2 = d(substring);
            if (d2 != null) {
                return new C0323a(a, d2.intValue());
            }
            return null;
        }
    }

    static {
        kotlin.reflect.y.internal.j0.f.c cVar = k.o;
        f23235i = new c("KFunction", 2, cVar, "KFunction", false, true);
        f23236j = new c("KSuspendFunction", 3, cVar, "KSuspendFunction", true, true);
        f23237k = g();
        f23232f = new a(null);
    }

    private c(String str, int i2, kotlin.reflect.y.internal.j0.f.c cVar, String str2, boolean z, boolean z2) {
        this.l = cVar;
        this.m = str2;
        this.n = z;
        this.o = z2;
    }

    private static final /* synthetic */ c[] g() {
        return new c[]{f23233g, f23234h, f23235i, f23236j};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f23237k.clone();
    }

    public final String k() {
        return this.m;
    }

    public final kotlin.reflect.y.internal.j0.f.c q() {
        return this.l;
    }

    public final f u(int i2) {
        f x = f.x(this.m + i2);
        m.e(x, "identifier(\"$classNamePrefix$arity\")");
        return x;
    }
}
