package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.collections.t;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.y.internal.j0.l.a1;

/* compiled from: TypeAttributeTranslator.kt */
/* loaded from: classes3.dex */
public final class o implements z0 {
    public static final o a = new o();

    private o() {
    }

    @Override // kotlin.reflect.y.internal.j0.l.z0
    public a1 a(g gVar, e1 e1Var, m mVar) {
        List<? extends y0<?>> e2;
        kotlin.jvm.internal.m.f(gVar, "annotations");
        if (gVar.isEmpty()) {
            return a1.f24676g.h();
        }
        a1.a aVar = a1.f24676g;
        e2 = t.e(new j(gVar));
        return aVar.g(e2);
    }
}
