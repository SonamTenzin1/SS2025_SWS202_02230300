package kotlin.reflect.y.internal.j0.i.u;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: inlineClassManglingRules.kt */
/* loaded from: classes3.dex */
public final class b {
    private static final boolean a(e eVar) {
        return m.a(a.h(eVar), k.n);
    }

    public static final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return f.b(mVar) && !a((e) mVar);
    }

    public static final boolean c(e0 e0Var) {
        m.f(e0Var, "<this>");
        h w = e0Var.O0().w();
        return w != null && b(w);
    }

    private static final boolean d(e0 e0Var) {
        h w = e0Var.O0().w();
        e1 e1Var = w instanceof e1 ? (e1) w : null;
        if (e1Var == null) {
            return false;
        }
        return e(kotlin.reflect.y.internal.j0.l.x1.a.i(e1Var));
    }

    private static final boolean e(e0 e0Var) {
        return c(e0Var) || d(e0Var);
    }

    public static final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        m.f(bVar, "descriptor");
        d dVar = bVar instanceof d ? (d) bVar : null;
        if (dVar == null || t.g(dVar.getVisibility())) {
            return false;
        }
        e C = dVar.C();
        m.e(C, "constructorDescriptor.constructedClass");
        if (f.b(C) || kotlin.reflect.y.internal.j0.i.d.G(dVar.C())) {
            return false;
        }
        List<i1> f2 = dVar.f();
        m.e(f2, "constructorDescriptor.valueParameters");
        if ((f2 instanceof Collection) && f2.isEmpty()) {
            return false;
        }
        Iterator<T> it = f2.iterator();
        while (it.hasNext()) {
            e0 type = ((i1) it.next()).getType();
            m.e(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
