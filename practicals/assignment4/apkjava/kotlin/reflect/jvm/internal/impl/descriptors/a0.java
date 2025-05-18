package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: InvalidModuleException.kt */
/* loaded from: classes2.dex */
public final class a0 {
    private static final f0<b0> a = new f0<>("InvalidModuleNotifier");

    public static final void a(g0 g0Var) {
        kotlin.u uVar;
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        b0 b0Var = (b0) g0Var.I0(a);
        if (b0Var != null) {
            b0Var.a(g0Var);
            uVar = kotlin.u.a;
        } else {
            uVar = null;
        }
        if (uVar != null) {
            return;
        }
        throw new InvalidModuleException("Accessing invalid module descriptor " + g0Var);
    }
}
