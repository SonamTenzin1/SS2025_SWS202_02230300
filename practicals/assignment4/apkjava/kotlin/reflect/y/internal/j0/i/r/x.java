package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.u1.j;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class x extends a0<Integer> {
    public x(int i2) {
        super(Integer.valueOf(i2));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public e0 a(g0 g0Var) {
        m.f(g0Var, "module");
        e a = kotlin.reflect.jvm.internal.impl.descriptors.x.a(g0Var, k.a.A0);
        m0 s = a != null ? a.s() : null;
        return s == null ? kotlin.reflect.y.internal.j0.l.u1.k.d(j.A0, "UInt") : s;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().intValue() + ".toUInt()";
    }
}
