package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.d.a.l0.c;
import kotlin.reflect.y.internal.j0.d.a.l0.m.f;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.l0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.p1;
import kotlin.reflect.y.internal.j0.l.q0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.y;

/* compiled from: typeEnhancement.kt */
/* loaded from: classes3.dex */
public final class d {
    private final c a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private final e0 a;

        /* renamed from: b, reason: collision with root package name */
        private final int f23610b;

        public a(e0 e0Var, int i2) {
            this.a = e0Var;
            this.f23610b = i2;
        }

        public final int a() {
            return this.f23610b;
        }

        public final e0 b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: typeEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private final m0 a;

        /* renamed from: b, reason: collision with root package name */
        private final int f23611b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f23612c;

        public b(m0 m0Var, int i2, boolean z) {
            this.a = m0Var;
            this.f23611b = i2;
            this.f23612c = z;
        }

        public final boolean a() {
            return this.f23612c;
        }

        public final int b() {
            return this.f23611b;
        }

        public final m0 c() {
            return this.a;
        }
    }

    public d(c cVar) {
        m.f(cVar, "javaResolverSettings");
        this.a = cVar;
    }

    private final b b(m0 m0Var, Function1<? super Integer, e> function1, int i2, o oVar, boolean z, boolean z2) {
        h g2;
        Boolean h2;
        e1 O0;
        int u;
        int u2;
        c cVar;
        c cVar2;
        List o;
        g f2;
        int u3;
        int u4;
        boolean z3;
        boolean z4;
        a aVar;
        g1 s;
        Function1<? super Integer, e> function12 = function1;
        boolean a2 = p.a(oVar);
        boolean z5 = (z2 && z) ? false : true;
        e0 e0Var = null;
        if (!a2 && m0Var.M0().isEmpty()) {
            return new b(null, 1, false);
        }
        h w = m0Var.O0().w();
        if (w == null) {
            return new b(null, 1, false);
        }
        e invoke = function12.invoke(Integer.valueOf(i2));
        g2 = r.g(w, invoke, oVar);
        h2 = r.h(invoke, oVar);
        if (g2 == null || (O0 = g2.h()) == null) {
            O0 = m0Var.O0();
        }
        e1 e1Var = O0;
        m.e(e1Var, "enhancedClassifier?.typeConstructor ?: constructor");
        int i3 = i2 + 1;
        List<g1> M0 = m0Var.M0();
        List<kotlin.reflect.jvm.internal.impl.descriptors.e1> parameters = e1Var.getParameters();
        m.e(parameters, "typeConstructor.parameters");
        Iterator<T> it = M0.iterator();
        Iterator<T> it2 = parameters.iterator();
        u = v.u(M0, 10);
        u2 = v.u(parameters, 10);
        ArrayList arrayList = new ArrayList(Math.min(u, u2));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var2 = (kotlin.reflect.jvm.internal.impl.descriptors.e1) it2.next();
            g1 g1Var = (g1) next;
            if (!z5) {
                z4 = z5;
                aVar = new a(e0Var, 0);
            } else {
                z4 = z5;
                if (!g1Var.c()) {
                    aVar = d(g1Var.getType().R0(), function12, i3, z2);
                } else if (function12.invoke(Integer.valueOf(i3)).d() == h.FORCE_FLEXIBILITY) {
                    q1 R0 = g1Var.getType().R0();
                    aVar = new a(f0.d(b0.c(R0).S0(false), b0.d(R0).S0(true)), 1);
                } else {
                    aVar = new a(null, 1);
                }
            }
            i3 += aVar.a();
            if (aVar.b() != null) {
                e0 b2 = aVar.b();
                r1 a3 = g1Var.a();
                m.e(a3, "arg.projectionKind");
                s = kotlin.reflect.y.internal.j0.l.x1.a.e(b2, a3, e1Var2);
            } else if (g2 == null || g1Var.c()) {
                s = g2 != null ? n1.s(e1Var2) : null;
            } else {
                e0 type = g1Var.getType();
                m.e(type, "arg.type");
                r1 a4 = g1Var.a();
                m.e(a4, "arg.projectionKind");
                s = kotlin.reflect.y.internal.j0.l.x1.a.e(type, a4, e1Var2);
            }
            arrayList.add(s);
            function12 = function1;
            z5 = z4;
            e0Var = null;
        }
        int i4 = i3 - i2;
        if (g2 == null && h2 == null) {
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    if (!(((g1) it3.next()) == null)) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (z3) {
                return new b(null, i4, false);
            }
        }
        g[] gVarArr = new g[3];
        gVarArr[0] = m0Var.getAnnotations();
        cVar = r.f23682b;
        if (!(g2 != null)) {
            cVar = null;
        }
        gVarArr[1] = cVar;
        cVar2 = r.a;
        if (!(h2 != null)) {
            cVar2 = null;
        }
        gVarArr[2] = cVar2;
        o = u.o(gVarArr);
        f2 = r.f(o);
        a1 b3 = b1.b(f2);
        List<g1> M02 = m0Var.M0();
        Iterator it4 = arrayList.iterator();
        Iterator<T> it5 = M02.iterator();
        u3 = v.u(arrayList, 10);
        u4 = v.u(M02, 10);
        ArrayList arrayList2 = new ArrayList(Math.min(u3, u4));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            g1 g1Var2 = (g1) it5.next();
            g1 g1Var3 = (g1) next2;
            if (g1Var3 != null) {
                g1Var2 = g1Var3;
            }
            arrayList2.add(g1Var2);
        }
        m0 i5 = f0.i(b3, e1Var, arrayList2, h2 != null ? h2.booleanValue() : m0Var.P0(), null, 16, null);
        if (invoke.b()) {
            i5 = e(i5);
        }
        return new b(i5, i4, h2 != null && invoke.e());
    }

    static /* synthetic */ b c(d dVar, m0 m0Var, Function1 function1, int i2, o oVar, boolean z, boolean z2, int i3, Object obj) {
        return dVar.b(m0Var, function1, i2, oVar, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
    
        if (r13 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final a d(q1 q1Var, Function1<? super Integer, e> function1, int i2, boolean z) {
        e0 c2;
        e0 e0Var = null;
        if (g0.a(q1Var)) {
            return new a(null, 1);
        }
        if (q1Var instanceof y) {
            boolean z2 = q1Var instanceof l0;
            y yVar = (y) q1Var;
            b b2 = b(yVar.W0(), function1, i2, o.FLEXIBLE_LOWER, z2, z);
            b b3 = b(yVar.X0(), function1, i2, o.FLEXIBLE_UPPER, z2, z);
            b2.b();
            b3.b();
            if (b2.c() != null || b3.c() != null) {
                if (b2.a() || b3.a()) {
                    m0 c3 = b3.c();
                    if (c3 != null) {
                        m0 c4 = b2.c();
                        if (c4 == null) {
                            c4 = c3;
                        }
                        c2 = f0.d(c4, c3);
                    }
                    c2 = b2.c();
                    m.c(c2);
                    e0Var = p1.d(q1Var, c2);
                } else if (z2) {
                    m0 c5 = b2.c();
                    if (c5 == null) {
                        c5 = yVar.W0();
                    }
                    m0 c6 = b3.c();
                    if (c6 == null) {
                        c6 = yVar.X0();
                    }
                    e0Var = new f(c5, c6);
                } else {
                    m0 c7 = b2.c();
                    if (c7 == null) {
                        c7 = yVar.W0();
                    }
                    m0 c8 = b3.c();
                    if (c8 == null) {
                        c8 = yVar.X0();
                    }
                    e0Var = f0.d(c7, c8);
                }
            }
            return new a(e0Var, b2.b());
        }
        if (!(q1Var instanceof m0)) {
            throw new NoWhenBranchMatchedException();
        }
        b c9 = c(this, (m0) q1Var, function1, i2, o.INFLEXIBLE, false, z, 8, null);
        return new a(c9.a() ? p1.d(q1Var, c9.c()) : c9.c(), c9.b());
    }

    private final m0 e(m0 m0Var) {
        if (this.a.a()) {
            return q0.h(m0Var, true);
        }
        return new g(m0Var);
    }

    public final e0 a(e0 e0Var, Function1<? super Integer, e> function1, boolean z) {
        m.f(e0Var, "<this>");
        m.f(function1, "qualifiers");
        return d(e0Var.R0(), function1, 0, z).b();
    }
}
