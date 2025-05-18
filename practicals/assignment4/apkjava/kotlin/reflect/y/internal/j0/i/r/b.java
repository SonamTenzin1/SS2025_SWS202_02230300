package kotlin.reflect.y.internal.j0.i.r;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public class b extends g<List<? extends g<?>>> {

    /* renamed from: b, reason: collision with root package name */
    private final Function1<g0, e0> f24358b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends g<?>> list, Function1<? super g0, ? extends e0> function1) {
        super(list);
        m.f(list, "value");
        m.f(function1, "computeType");
        this.f24358b = function1;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public e0 a(g0 g0Var) {
        m.f(g0Var, "module");
        e0 invoke = this.f24358b.invoke(g0Var);
        if (!h.c0(invoke) && !h.p0(invoke)) {
            h.C0(invoke);
        }
        return invoke;
    }
}
