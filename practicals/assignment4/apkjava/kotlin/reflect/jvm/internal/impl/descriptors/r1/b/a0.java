package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h;

/* compiled from: ReflectJavaTypeParameter.kt */
/* loaded from: classes2.dex */
public final class a0 extends p implements h, kotlin.reflect.y.internal.j0.d.a.n0.y {
    private final TypeVariable<?> a;

    public a0(TypeVariable<?> typeVariable) {
        kotlin.jvm.internal.m.f(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public e l(kotlin.reflect.y.internal.j0.f.c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.y
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public List<n> getUpperBounds() {
        List<n> j2;
        Type[] bounds = this.a.getBounds();
        kotlin.jvm.internal.m.e(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new n(type));
        }
        n nVar = (n) kotlin.collections.s.u0(arrayList);
        if (!kotlin.jvm.internal.m.a(nVar != null ? nVar.R() : null, Object.class)) {
            return arrayList;
        }
        j2 = kotlin.collections.u.j();
        return j2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a0) && kotlin.jvm.internal.m.a(this.a, ((a0) obj).a);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.t
    public kotlin.reflect.y.internal.j0.f.f getName() {
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(this.a.getName());
        kotlin.jvm.internal.m.e(x, "identifier(typeVariable.name)");
        return x;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return h.a.c(this);
    }

    public String toString() {
        return a0.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h
    public AnnotatedElement w() {
        TypeVariable<?> typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }
}
