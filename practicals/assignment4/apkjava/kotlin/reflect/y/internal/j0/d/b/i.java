package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.l0.m.f;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.j.b.s;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* compiled from: JavaFlexibleTypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class i implements s {
    public static final i a = new i();

    private i() {
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.s
    public e0 a(q qVar, String str, m0 m0Var, m0 m0Var2) {
        m.f(qVar, "proto");
        m.f(str, "flexibleId");
        m.f(m0Var, "lowerBound");
        m.f(m0Var2, "upperBound");
        if (!m.a(str, "kotlin.jvm.PlatformType")) {
            return k.d(j.M, str, m0Var.toString(), m0Var2.toString());
        }
        if (qVar.x(a.f23826g)) {
            return new f(m0Var, m0Var2);
        }
        return f0.d(m0Var, m0Var2);
    }
}
