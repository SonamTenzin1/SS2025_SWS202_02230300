package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;

/* compiled from: DeserializedClassDataFinder.kt */
/* loaded from: classes3.dex */
public final class o implements h {
    private final l0 a;

    public o(l0 l0Var) {
        m.f(l0Var, "packageFragmentProvider");
        this.a = l0Var;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.h
    public g a(b bVar) {
        g a;
        m.f(bVar, "classId");
        l0 l0Var = this.a;
        c h2 = bVar.h();
        m.e(h2, "classId.packageFqName");
        for (k0 k0Var : n0.c(l0Var, h2)) {
            if ((k0Var instanceof p) && (a = ((p) k0Var).A0().a(bVar)) != null) {
                return a;
            }
        }
        return null;
    }
}
