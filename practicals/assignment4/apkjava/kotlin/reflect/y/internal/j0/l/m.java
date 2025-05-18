package kotlin.reflect.y.internal.j0.l;

import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* compiled from: ClassifierBasedTypeConstructor.kt */
/* loaded from: classes3.dex */
public abstract class m implements e1 {
    private int a;

    private final boolean h(h hVar) {
        return (k.m(hVar) || d.E(hVar)) ? false : true;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* renamed from: c */
    public abstract h w();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e1) || obj.hashCode() != hashCode()) {
            return false;
        }
        e1 e1Var = (e1) obj;
        if (e1Var.getParameters().size() != getParameters().size()) {
            return false;
        }
        h w = w();
        h w2 = e1Var.w();
        if (w2 != null && h(w) && h(w2)) {
            return i(w2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g(h hVar, h hVar2) {
        kotlin.jvm.internal.m.f(hVar, "first");
        kotlin.jvm.internal.m.f(hVar2, "second");
        if (!kotlin.jvm.internal.m.a(hVar.getName(), hVar2.getName())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = hVar.b();
        for (kotlin.reflect.jvm.internal.impl.descriptors.m b3 = hVar2.b(); b2 != null && b3 != null; b3 = b3.b()) {
            if (b2 instanceof g0) {
                return b3 instanceof g0;
            }
            if (b3 instanceof g0) {
                return false;
            }
            if (b2 instanceof k0) {
                return (b3 instanceof k0) && kotlin.jvm.internal.m.a(((k0) b2).d(), ((k0) b3).d());
            }
            if ((b3 instanceof k0) || !kotlin.jvm.internal.m.a(b2.getName(), b3.getName())) {
                return false;
            }
            b2 = b2.b();
        }
        return true;
    }

    public int hashCode() {
        int identityHashCode;
        int i2 = this.a;
        if (i2 != 0) {
            return i2;
        }
        h w = w();
        if (h(w)) {
            identityHashCode = d.m(w).hashCode();
        } else {
            identityHashCode = System.identityHashCode(this);
        }
        this.a = identityHashCode;
        return identityHashCode;
    }

    protected abstract boolean i(h hVar);
}
