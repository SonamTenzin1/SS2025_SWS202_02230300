package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.m0;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class r extends o<Long> {
    public r(long j2) {
        super(Long.valueOf(j2));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m0 a(g0 g0Var) {
        m.f(g0Var, "module");
        m0 F = g0Var.o().F();
        m.e(F, "module.builtIns.longType");
        return F;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().longValue() + ".toLong()";
    }
}
