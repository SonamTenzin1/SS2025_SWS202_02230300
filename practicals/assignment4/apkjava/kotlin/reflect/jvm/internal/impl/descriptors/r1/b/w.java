package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: ReflectJavaPackage.kt */
/* loaded from: classes2.dex */
public final class w extends p implements kotlin.reflect.y.internal.j0.d.a.n0.u {
    private final kotlin.reflect.y.internal.j0.f.c a;

    public w(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        this.a = cVar;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.u
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.u> A() {
        List j2;
        j2 = kotlin.collections.u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.y.internal.j0.d.a.n0.a> getAnnotations() {
        List<kotlin.reflect.y.internal.j0.d.a.n0.a> j2;
        j2 = kotlin.collections.u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.u
    public kotlin.reflect.y.internal.j0.f.c d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && kotlin.jvm.internal.m.a(d(), ((w) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public kotlin.reflect.y.internal.j0.d.a.n0.a l(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.u
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.g> q(Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        List j2;
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        j2 = kotlin.collections.u.j();
        return j2;
    }

    public String toString() {
        return w.class.getName() + ": " + d();
    }
}
