package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: DescriptorVisibility.kt */
/* loaded from: classes2.dex */
public abstract class r extends u {
    private final m1 a;

    public r(m1 m1Var) {
        kotlin.jvm.internal.m.f(m1Var, "delegate");
        this.a = m1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public m1 b() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public String c() {
        return b().b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.u
    public u f() {
        u j2 = t.j(b().d());
        kotlin.jvm.internal.m.e(j2, "toDescriptorVisibility(delegate.normalize())");
        return j2;
    }
}
