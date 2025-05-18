package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: ModuleDescriptor.kt */
/* loaded from: classes2.dex */
public interface g0 extends m {

    /* compiled from: ModuleDescriptor.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        public static <R, D> R a(g0 g0Var, o<R, D> oVar, D d2) {
            kotlin.jvm.internal.m.f(oVar, "visitor");
            return oVar.j(g0Var, d2);
        }

        public static m b(g0 g0Var) {
            return null;
        }
    }

    <T> T I0(f0<T> f0Var);

    p0 N(kotlin.reflect.y.internal.j0.f.c cVar);

    boolean e0(g0 g0Var);

    kotlin.reflect.y.internal.j0.b.h o();

    Collection<kotlin.reflect.y.internal.j0.f.c> p(kotlin.reflect.y.internal.j0.f.c cVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1);

    List<g0> t0();
}
