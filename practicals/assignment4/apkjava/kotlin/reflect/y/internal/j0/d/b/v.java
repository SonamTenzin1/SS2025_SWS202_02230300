package kotlin.reflect.y.internal.j0.d.b;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.b.q.c;
import kotlin.reflect.y.internal.j0.d.a.f;
import kotlin.reflect.y.internal.j0.d.a.g0;
import kotlin.reflect.y.internal.j0.d.b.l;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: classes3.dex */
public final class v {
    private static final void a(StringBuilder sb, e0 e0Var) {
        sb.append(g(e0Var));
    }

    public static final String b(y yVar, boolean z, boolean z2) {
        String k2;
        m.f(yVar, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (yVar instanceof l) {
                k2 = "<init>";
            } else {
                k2 = yVar.getName().k();
                m.e(k2, "name.asString()");
            }
            sb.append(k2);
        }
        sb.append("(");
        w0 m0 = yVar.m0();
        if (m0 != null) {
            e0 type = m0.getType();
            m.e(type, "it.type");
            a(sb, type);
        }
        Iterator<i1> it = yVar.f().iterator();
        while (it.hasNext()) {
            e0 type2 = it.next().getType();
            m.e(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(")");
        if (z) {
            if (d.c(yVar)) {
                sb.append("V");
            } else {
                e0 returnType = yVar.getReturnType();
                m.c(returnType);
                a(sb, returnType);
            }
        }
        String sb2 = sb.toString();
        m.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String c(y yVar, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return b(yVar, z, z2);
    }

    public static final String d(a aVar) {
        m.f(aVar, "<this>");
        x xVar = x.a;
        if (d.E(aVar)) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = aVar.b();
        e eVar = b2 instanceof e ? (e) b2 : null;
        if (eVar == null || eVar.getName().y()) {
            return null;
        }
        a a = aVar.a();
        y0 y0Var = a instanceof y0 ? (y0) a : null;
        if (y0Var == null) {
            return null;
        }
        return u.a(xVar, eVar, c(y0Var, false, false, 3, null));
    }

    public static final boolean e(a aVar) {
        y k2;
        m.f(aVar, "f");
        if (!(aVar instanceof y)) {
            return false;
        }
        y yVar = (y) aVar;
        if (!m.a(yVar.getName().k(), "remove") || yVar.f().size() != 1 || g0.h((b) aVar)) {
            return false;
        }
        List<i1> f2 = yVar.a().f();
        m.e(f2, "f.original.valueParameters");
        e0 type = ((i1) s.s0(f2)).getType();
        m.e(type, "f.original.valueParameters.single().type");
        l g2 = g(type);
        l.d dVar = g2 instanceof l.d ? (l.d) g2 : null;
        if ((dVar != null ? dVar.i() : null) != kotlin.reflect.y.internal.j0.i.u.e.INT || (k2 = f.k(yVar)) == null) {
            return false;
        }
        List<i1> f3 = k2.a().f();
        m.e(f3, "overridden.original.valueParameters");
        e0 type2 = ((i1) s.s0(f3)).getType();
        m.e(type2, "overridden.original.valueParameters.single().type");
        l g3 = g(type2);
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = k2.b();
        m.e(b2, "overridden.containingDeclaration");
        return m.a(kotlin.reflect.y.internal.j0.i.t.a.i(b2), k.a.c0.j()) && (g3 instanceof l.c) && m.a(((l.c) g3).i(), "java/lang/Object");
    }

    public static final String f(e eVar) {
        m.f(eVar, "<this>");
        c cVar = c.a;
        kotlin.reflect.y.internal.j0.f.d j2 = kotlin.reflect.y.internal.j0.i.t.a.h(eVar).j();
        m.e(j2, "fqNameSafe.toUnsafe()");
        kotlin.reflect.y.internal.j0.f.b n = cVar.n(j2);
        if (n != null) {
            String f2 = kotlin.reflect.y.internal.j0.i.u.d.b(n).f();
            m.e(f2, "byClassId(it).internalName");
            return f2;
        }
        return d.b(eVar, null, 2, null);
    }

    public static final l g(e0 e0Var) {
        m.f(e0Var, "<this>");
        return (l) d.e(e0Var, n.a, a0.f23725e, z.a, null, null, 32, null);
    }
}
