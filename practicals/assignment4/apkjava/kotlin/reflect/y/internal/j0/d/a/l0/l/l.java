package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.l.j;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: LazyJavaStaticScope.kt */
/* loaded from: classes2.dex */
public abstract class l extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(g gVar) {
        super(gVar, null, 2, null);
        m.f(gVar, "c");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected j.a H(r rVar, List<? extends e1> list, e0 e0Var, List<? extends i1> list2) {
        List j2;
        m.f(rVar, "method");
        m.f(list, "methodTypeParameters");
        m.f(e0Var, "returnType");
        m.f(list2, "valueParameters");
        j2 = u.j();
        return new j.a(e0Var, null, list2, list, false, j2);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void s(f fVar, Collection<t0> collection) {
        m.f(fVar, "name");
        m.f(collection, "result");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected w0 z() {
        return null;
    }
}
