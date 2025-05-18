package kotlin.reflect.y.internal.j0.b;

import cm.aptoide.pt.root.execution.Command;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: StandardNames.kt */
/* loaded from: classes2.dex */
public final class k {
    public static final k a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final f f23191b;

    /* renamed from: c, reason: collision with root package name */
    public static final f f23192c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f23193d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f23194e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f23195f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f23196g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f23197h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f23198i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f23199j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f23200k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final List<String> p;
    public static final f q;
    public static final c r;
    public static final c s;
    public static final c t;
    public static final c u;
    public static final c v;
    private static final c w;
    public static final Set<c> x;

    /* compiled from: StandardNames.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        public static final c A;
        public static final b A0;
        public static final c B;
        public static final b B0;
        public static final c C;
        public static final c C0;
        public static final c D;
        public static final c D0;
        public static final c E;
        public static final c E0;
        public static final b F;
        public static final c F0;
        public static final c G;
        public static final Set<f> G0;
        public static final c H;
        public static final Set<f> H0;
        public static final b I;
        public static final Map<d, i> I0;
        public static final c J;
        public static final Map<d, i> J0;
        public static final c K;
        public static final c L;
        public static final b M;
        public static final c N;
        public static final b O;
        public static final c P;
        public static final c Q;
        public static final c R;
        public static final c S;
        public static final c T;
        public static final c U;
        public static final c V;
        public static final c W;
        public static final c X;
        public static final c Y;
        public static final c Z;
        public static final a a;
        public static final c a0;

        /* renamed from: b, reason: collision with root package name */
        public static final d f23201b;
        public static final c b0;

        /* renamed from: c, reason: collision with root package name */
        public static final d f23202c;
        public static final c c0;

        /* renamed from: d, reason: collision with root package name */
        public static final d f23203d;
        public static final c d0;

        /* renamed from: e, reason: collision with root package name */
        public static final c f23204e;
        public static final c e0;

        /* renamed from: f, reason: collision with root package name */
        public static final d f23205f;
        public static final c f0;

        /* renamed from: g, reason: collision with root package name */
        public static final d f23206g;
        public static final c g0;

        /* renamed from: h, reason: collision with root package name */
        public static final d f23207h;
        public static final c h0;

        /* renamed from: i, reason: collision with root package name */
        public static final d f23208i;
        public static final d i0;

        /* renamed from: j, reason: collision with root package name */
        public static final d f23209j;
        public static final d j0;

        /* renamed from: k, reason: collision with root package name */
        public static final d f23210k;
        public static final d k0;
        public static final d l;
        public static final d l0;
        public static final d m;
        public static final d m0;
        public static final d n;
        public static final d n0;
        public static final d o;
        public static final d o0;
        public static final d p;
        public static final d p0;
        public static final d q;
        public static final d q0;
        public static final d r;
        public static final d r0;
        public static final d s;
        public static final b s0;
        public static final d t;
        public static final d t0;
        public static final c u;
        public static final c u0;
        public static final c v;
        public static final c v0;
        public static final d w;
        public static final c w0;
        public static final d x;
        public static final c x0;
        public static final c y;
        public static final b y0;
        public static final c z;
        public static final b z0;

        static {
            a aVar = new a();
            a = aVar;
            f23201b = aVar.d("Any");
            f23202c = aVar.d("Nothing");
            f23203d = aVar.d("Cloneable");
            f23204e = aVar.c("Suppress");
            f23205f = aVar.d("Unit");
            f23206g = aVar.d("CharSequence");
            f23207h = aVar.d("String");
            f23208i = aVar.d("Array");
            f23209j = aVar.d("Boolean");
            f23210k = aVar.d("Char");
            l = aVar.d("Byte");
            m = aVar.d("Short");
            n = aVar.d("Int");
            o = aVar.d("Long");
            p = aVar.d("Float");
            q = aVar.d("Double");
            r = aVar.d("Number");
            s = aVar.d("Enum");
            t = aVar.d("Function");
            u = aVar.c("Throwable");
            v = aVar.c("Comparable");
            w = aVar.e("IntRange");
            x = aVar.e("LongRange");
            y = aVar.c("Deprecated");
            z = aVar.c("DeprecatedSinceKotlin");
            A = aVar.c("DeprecationLevel");
            B = aVar.c("ReplaceWith");
            C = aVar.c("ExtensionFunctionType");
            D = aVar.c("ContextFunctionTypeParams");
            c c2 = aVar.c("ParameterName");
            E = c2;
            b m2 = b.m(c2);
            m.e(m2, "topLevel(parameterName)");
            F = m2;
            G = aVar.c("Annotation");
            c a2 = aVar.a("Target");
            H = a2;
            b m3 = b.m(a2);
            m.e(m3, "topLevel(target)");
            I = m3;
            J = aVar.a("AnnotationTarget");
            K = aVar.a("AnnotationRetention");
            c a3 = aVar.a("Retention");
            L = a3;
            b m4 = b.m(a3);
            m.e(m4, "topLevel(retention)");
            M = m4;
            c a4 = aVar.a("Repeatable");
            N = a4;
            b m5 = b.m(a4);
            m.e(m5, "topLevel(repeatable)");
            O = m5;
            P = aVar.a("MustBeDocumented");
            Q = aVar.c("UnsafeVariance");
            R = aVar.c("PublishedApi");
            S = aVar.b("Iterator");
            T = aVar.b("Iterable");
            U = aVar.b("Collection");
            V = aVar.b("List");
            W = aVar.b("ListIterator");
            X = aVar.b("Set");
            c b2 = aVar.b("Map");
            Y = b2;
            c c3 = b2.c(f.x("Entry"));
            m.e(c3, "map.child(Name.identifier(\"Entry\"))");
            Z = c3;
            a aVar2 = a;
            a0 = aVar2.b("MutableIterator");
            b0 = aVar2.b("MutableIterable");
            c0 = aVar2.b("MutableCollection");
            d0 = aVar2.b("MutableList");
            e0 = aVar2.b("MutableListIterator");
            f0 = aVar2.b("MutableSet");
            c b3 = aVar2.b("MutableMap");
            g0 = b3;
            c c4 = b3.c(f.x("MutableEntry"));
            m.e(c4, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            h0 = c4;
            i0 = f("KClass");
            j0 = f("KCallable");
            k0 = f("KProperty0");
            l0 = f("KProperty1");
            m0 = f("KProperty2");
            n0 = f("KMutableProperty0");
            o0 = f("KMutableProperty1");
            p0 = f("KMutableProperty2");
            d f2 = f("KProperty");
            q0 = f2;
            r0 = f("KMutableProperty");
            b m6 = b.m(f2.l());
            m.e(m6, "topLevel(kPropertyFqName.toSafe())");
            s0 = m6;
            t0 = f("KDeclarationContainer");
            c c5 = aVar2.c("UByte");
            u0 = c5;
            c c6 = aVar2.c("UShort");
            v0 = c6;
            c c7 = aVar2.c("UInt");
            w0 = c7;
            c c8 = aVar2.c("ULong");
            x0 = c8;
            b m7 = b.m(c5);
            m.e(m7, "topLevel(uByteFqName)");
            y0 = m7;
            b m8 = b.m(c6);
            m.e(m8, "topLevel(uShortFqName)");
            z0 = m8;
            b m9 = b.m(c7);
            m.e(m9, "topLevel(uIntFqName)");
            A0 = m9;
            b m10 = b.m(c8);
            m.e(m10, "topLevel(uLongFqName)");
            B0 = m10;
            C0 = aVar2.c("UByteArray");
            D0 = aVar2.c("UShortArray");
            E0 = aVar2.c("UIntArray");
            F0 = aVar2.c("ULongArray");
            HashSet f3 = kotlin.reflect.jvm.internal.impl.utils.a.f(i.values().length);
            for (i iVar : i.values()) {
                f3.add(iVar.v());
            }
            G0 = f3;
            HashSet f4 = kotlin.reflect.jvm.internal.impl.utils.a.f(i.values().length);
            for (i iVar2 : i.values()) {
                f4.add(iVar2.q());
            }
            H0 = f4;
            HashMap e2 = kotlin.reflect.jvm.internal.impl.utils.a.e(i.values().length);
            for (i iVar3 : i.values()) {
                a aVar3 = a;
                String k2 = iVar3.v().k();
                m.e(k2, "primitiveType.typeName.asString()");
                e2.put(aVar3.d(k2), iVar3);
            }
            I0 = e2;
            HashMap e3 = kotlin.reflect.jvm.internal.impl.utils.a.e(i.values().length);
            for (i iVar4 : i.values()) {
                a aVar4 = a;
                String k3 = iVar4.q().k();
                m.e(k3, "primitiveType.arrayTypeName.asString()");
                e3.put(aVar4.d(k3), iVar4);
            }
            J0 = e3;
        }

        private a() {
        }

        private final c a(String str) {
            c c2 = k.s.c(f.x(str));
            m.e(c2, "ANNOTATION_PACKAGE_FQ_NA…e.identifier(simpleName))");
            return c2;
        }

        private final c b(String str) {
            c c2 = k.t.c(f.x(str));
            m.e(c2, "COLLECTIONS_PACKAGE_FQ_N…e.identifier(simpleName))");
            return c2;
        }

        private final c c(String str) {
            c c2 = k.r.c(f.x(str));
            m.e(c2, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(simpleName))");
            return c2;
        }

        private final d d(String str) {
            d j2 = c(str).j();
            m.e(j2, "fqName(simpleName).toUnsafe()");
            return j2;
        }

        private final d e(String str) {
            d j2 = k.u.c(f.x(str)).j();
            m.e(j2, "RANGES_PACKAGE_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return j2;
        }

        public static final d f(String str) {
            m.f(str, "simpleName");
            d j2 = k.o.c(f.x(str)).j();
            m.e(j2, "KOTLIN_REFLECT_FQ_NAME.c…r(simpleName)).toUnsafe()");
            return j2;
        }
    }

    static {
        List<String> m2;
        Set<c> i2;
        f x2 = f.x("field");
        m.e(x2, "identifier(\"field\")");
        f23191b = x2;
        f x3 = f.x("value");
        m.e(x3, "identifier(\"value\")");
        f23192c = x3;
        f x4 = f.x("values");
        m.e(x4, "identifier(\"values\")");
        f23193d = x4;
        f x5 = f.x("valueOf");
        m.e(x5, "identifier(\"valueOf\")");
        f23194e = x5;
        f x6 = f.x("copy");
        m.e(x6, "identifier(\"copy\")");
        f23195f = x6;
        f x7 = f.x("hashCode");
        m.e(x7, "identifier(\"hashCode\")");
        f23196g = x7;
        f x8 = f.x("code");
        m.e(x8, "identifier(\"code\")");
        f23197h = x8;
        f x9 = f.x("count");
        m.e(x9, "identifier(\"count\")");
        f23198i = x9;
        c cVar = new c("kotlin.coroutines");
        f23199j = cVar;
        f23200k = new c("kotlin.coroutines.jvm.internal");
        l = new c("kotlin.coroutines.intrinsics");
        c c2 = cVar.c(f.x("Continuation"));
        m.e(c2, "COROUTINES_PACKAGE_FQ_NA…entifier(\"Continuation\"))");
        m = c2;
        n = new c("kotlin.Result");
        c cVar2 = new c("kotlin.reflect");
        o = cVar2;
        m2 = u.m("KProperty", "KMutableProperty", "KFunction", "KSuspendFunction");
        p = m2;
        f x10 = f.x("kotlin");
        m.e(x10, "identifier(\"kotlin\")");
        q = x10;
        c k2 = c.k(x10);
        m.e(k2, "topLevel(BUILT_INS_PACKAGE_NAME)");
        r = k2;
        c c3 = k2.c(f.x("annotation"));
        m.e(c3, "BUILT_INS_PACKAGE_FQ_NAM…identifier(\"annotation\"))");
        s = c3;
        c c4 = k2.c(f.x("collections"));
        m.e(c4, "BUILT_INS_PACKAGE_FQ_NAM…dentifier(\"collections\"))");
        t = c4;
        c c5 = k2.c(f.x("ranges"));
        m.e(c5, "BUILT_INS_PACKAGE_FQ_NAM…ame.identifier(\"ranges\"))");
        u = c5;
        c c6 = k2.c(f.x(Command.CommandHandler.TEXT));
        m.e(c6, "BUILT_INS_PACKAGE_FQ_NAM…(Name.identifier(\"text\"))");
        v = c6;
        c c7 = k2.c(f.x("internal"));
        m.e(c7, "BUILT_INS_PACKAGE_FQ_NAM…e.identifier(\"internal\"))");
        w = c7;
        i2 = w0.i(k2, c4, c5, c3, cVar2, c7, cVar);
        x = i2;
    }

    private k() {
    }

    public static final b a(int i2) {
        return new b(r, f.x(b(i2)));
    }

    public static final String b(int i2) {
        return "Function" + i2;
    }

    public static final c c(i iVar) {
        m.f(iVar, "primitiveType");
        c c2 = r.c(iVar.v());
        m.e(c2, "BUILT_INS_PACKAGE_FQ_NAM…d(primitiveType.typeName)");
        return c2;
    }

    public static final String d(int i2) {
        return kotlin.reflect.y.internal.j0.b.p.c.f23234h.k() + i2;
    }

    public static final boolean e(d dVar) {
        m.f(dVar, "arrayFqName");
        return a.J0.get(dVar) != null;
    }
}
