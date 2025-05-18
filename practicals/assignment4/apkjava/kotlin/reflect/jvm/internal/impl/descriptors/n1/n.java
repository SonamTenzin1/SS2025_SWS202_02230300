package kotlin.reflect.jvm.internal.impl.descriptors.n1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.s;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'z' uses external variables
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
/* compiled from: KotlinTarget.kt */
/* loaded from: classes2.dex */
public final class n {
    public static final n A;
    public static final n B;
    public static final n C;
    public static final n D;
    public static final n E;
    public static final n F;
    public static final n G;

    /* renamed from: h, reason: collision with root package name */
    private static final Set<n> f25198h;

    /* renamed from: i, reason: collision with root package name */
    private static final Set<n> f25199i;

    /* renamed from: j, reason: collision with root package name */
    private static final List<n> f25200j;

    /* renamed from: k, reason: collision with root package name */
    private static final List<n> f25201k;
    private static final List<n> l;
    private static final List<n> m;
    private static final List<n> n;
    private static final List<n> o;
    private static final List<n> p;
    private static final List<n> q;
    private static final List<n> r;
    private static final List<n> s;
    private static final List<n> t;
    private static final List<n> u;
    private static final Map<e, n> v;
    public static final n z;
    private final String n0;
    private final boolean o0;
    public static final n w = new n("CLASS", 0, "class", false, 2, null);
    public static final n x = new n("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
    public static final n y = new n("TYPE_PARAMETER", 2, "type parameter", false);
    public static final n H = new n("TYPE", 11, "type usage", false);
    public static final n I = new n("EXPRESSION", 12, "expression", false);
    public static final n J = new n("FILE", 13, "file", false);
    public static final n K = new n("TYPEALIAS", 14, "typealias", false);
    public static final n L = new n("TYPE_PROJECTION", 15, "type projection", false);
    public static final n M = new n("STAR_PROJECTION", 16, "star projection", false);
    public static final n N = new n("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    public static final n O = new n("CLASS_ONLY", 18, "class", false);
    public static final n P = new n("OBJECT", 19, "object", false);
    public static final n Q = new n("COMPANION_OBJECT", 20, "companion object", false);
    public static final n R = new n("INTERFACE", 21, "interface", false);
    public static final n S = new n("ENUM_CLASS", 22, "enum class", false);
    public static final n T = new n("ENUM_ENTRY", 23, "enum entry", false);
    public static final n U = new n("LOCAL_CLASS", 24, "local class", false);
    public static final n V = new n("LOCAL_FUNCTION", 25, "local function", false);
    public static final n W = new n("MEMBER_FUNCTION", 26, "member function", false);
    public static final n X = new n("TOP_LEVEL_FUNCTION", 27, "top level function", false);
    public static final n Y = new n("MEMBER_PROPERTY", 28, "member property", false);
    public static final n Z = new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
    public static final n a0 = new n("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
    public static final n b0 = new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
    public static final n c0 = new n("TOP_LEVEL_PROPERTY", 32, "top level property", false);
    public static final n d0 = new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
    public static final n e0 = new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
    public static final n f0 = new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
    public static final n g0 = new n("BACKING_FIELD", 36, "backing field", false, 2, null);
    public static final n h0 = new n("INITIALIZER", 37, "initializer", false);
    public static final n i0 = new n("DESTRUCTURING_DECLARATION", 38, "destructuring declaration", false);
    public static final n j0 = new n("LAMBDA_EXPRESSION", 39, "lambda expression", false);
    public static final n k0 = new n("ANONYMOUS_FUNCTION", 40, "anonymous function", false);
    public static final n l0 = new n("OBJECT_LITERAL", 41, "object literal", false);
    private static final /* synthetic */ n[] m0 = g();

    /* renamed from: f, reason: collision with root package name */
    public static final a f25196f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<String, n> f25197g = new HashMap<>();

    /* compiled from: KotlinTarget.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    static {
        Set<n> I0;
        Set<n> l02;
        List<n> m2;
        List<n> m3;
        List<n> m4;
        List<n> m5;
        List<n> m6;
        List<n> m7;
        List<n> m8;
        List<n> m9;
        List<n> e2;
        List<n> e3;
        List<n> e4;
        List<n> e5;
        Map<e, n> l2;
        boolean z2 = false;
        int i2 = 2;
        kotlin.jvm.internal.g gVar = null;
        z = new n("PROPERTY", 3, "property", z2, i2, gVar);
        boolean z3 = false;
        int i3 = 2;
        kotlin.jvm.internal.g gVar2 = null;
        A = new n("FIELD", 4, "field", z3, i3, gVar2);
        B = new n("LOCAL_VARIABLE", 5, "local variable", z2, i2, gVar);
        C = new n("VALUE_PARAMETER", 6, "value parameter", z3, i3, gVar2);
        D = new n("CONSTRUCTOR", 7, "constructor", z2, i2, gVar);
        E = new n("FUNCTION", 8, "function", z3, i3, gVar2);
        F = new n("PROPERTY_GETTER", 9, "getter", z2, i2, gVar);
        G = new n("PROPERTY_SETTER", 10, "setter", z3, i3, gVar2);
        for (n nVar : values()) {
            f25197g.put(nVar.name(), nVar);
        }
        n[] values = values();
        ArrayList arrayList = new ArrayList();
        for (n nVar2 : values) {
            if (nVar2.o0) {
                arrayList.add(nVar2);
            }
        }
        I0 = c0.I0(arrayList);
        f25198h = I0;
        l02 = kotlin.collections.n.l0(values());
        f25199i = l02;
        n nVar3 = w;
        m2 = u.m(x, nVar3);
        f25200j = m2;
        m3 = u.m(U, nVar3);
        f25201k = m3;
        m4 = u.m(O, nVar3);
        l = m4;
        n nVar4 = P;
        m5 = u.m(Q, nVar4, nVar3);
        m = m5;
        m6 = u.m(nVar4, nVar3);
        n = m6;
        m7 = u.m(R, nVar3);
        o = m7;
        m8 = u.m(S, nVar3);
        p = m8;
        n nVar5 = z;
        n nVar6 = A;
        m9 = u.m(T, nVar5, nVar6);
        q = m9;
        n nVar7 = G;
        e2 = t.e(nVar7);
        r = e2;
        n nVar8 = F;
        e3 = t.e(nVar8);
        s = e3;
        e4 = t.e(E);
        t = e4;
        n nVar9 = J;
        e5 = t.e(nVar9);
        u = e5;
        e eVar = e.CONSTRUCTOR_PARAMETER;
        n nVar10 = C;
        l2 = q0.l(s.a(eVar, nVar10), s.a(e.FIELD, nVar6), s.a(e.PROPERTY, nVar5), s.a(e.FILE, nVar9), s.a(e.PROPERTY_GETTER, nVar8), s.a(e.PROPERTY_SETTER, nVar7), s.a(e.RECEIVER, nVar10), s.a(e.SETTER_PARAMETER, nVar10), s.a(e.PROPERTY_DELEGATE_FIELD, nVar6));
        v = l2;
    }

    private n(String str, int i2, String str2, boolean z2) {
        this.n0 = str2;
        this.o0 = z2;
    }

    private static final /* synthetic */ n[] g() {
        return new n[]{w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0, e0, f0, g0, h0, i0, j0, k0, l0};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) m0.clone();
    }

    /* synthetic */ n(String str, int i2, String str2, boolean z2, int i3, kotlin.jvm.internal.g gVar) {
        this(str, i2, str2, (i3 & 2) != 0 ? true : z2);
    }
}
