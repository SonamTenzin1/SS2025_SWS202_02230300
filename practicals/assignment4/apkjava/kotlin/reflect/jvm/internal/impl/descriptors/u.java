package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: DescriptorVisibility.kt */
/* loaded from: classes2.dex */
public abstract class u {
    public final Integer a(u uVar) {
        kotlin.jvm.internal.m.f(uVar, "visibility");
        return b().a(uVar.b());
    }

    public abstract m1 b();

    public abstract String c();

    public final boolean d() {
        return b().c();
    }

    public abstract boolean e(kotlin.reflect.y.internal.j0.i.w.o.f fVar, q qVar, m mVar, boolean z);

    public abstract u f();

    public final String toString() {
        return b().toString();
    }
}
