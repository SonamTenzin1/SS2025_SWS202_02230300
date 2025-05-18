package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* compiled from: PackageFragmentDescriptorImpl.kt */
/* loaded from: classes2.dex */
public abstract class z extends k implements kotlin.reflect.jvm.internal.impl.descriptors.k0 {

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f25306j;

    /* renamed from: k, reason: collision with root package name */
    private final String f25307k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, kotlin.reflect.y.internal.j0.f.c cVar) {
        super(g0Var, kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), cVar.h(), z0.a);
        kotlin.jvm.internal.m.f(g0Var, "module");
        kotlin.jvm.internal.m.f(cVar, "fqName");
        this.f25306j = cVar;
        this.f25307k = "package " + cVar + " of " + g0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        kotlin.jvm.internal.m.f(oVar, "visitor");
        return oVar.f(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    public final kotlin.reflect.y.internal.j0.f.c d() {
        return this.f25306j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = z0.a;
        kotlin.jvm.internal.m.e(z0Var, "NO_SOURCE");
        return z0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        return this.f25307k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.g0 b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = super.b();
        kotlin.jvm.internal.m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.g0) b2;
    }
}
