package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.l.z0;

/* compiled from: TypeAttributes.kt */
/* loaded from: classes3.dex */
public final class b1 {
    public static final a1 a(a1 a1Var, g gVar) {
        a1 s;
        m.f(a1Var, "<this>");
        m.f(gVar, "newAnnotations");
        if (k.a(a1Var) == gVar) {
            return a1Var;
        }
        j b2 = k.b(a1Var);
        if (b2 != null && (s = a1Var.s(b2)) != null) {
            a1Var = s;
        }
        return (gVar.iterator().hasNext() || !gVar.isEmpty()) ? a1Var.r(new j(gVar)) : a1Var;
    }

    public static final a1 b(g gVar) {
        m.f(gVar, "<this>");
        return z0.a.a(o.a, gVar, null, null, 6, null);
    }
}
