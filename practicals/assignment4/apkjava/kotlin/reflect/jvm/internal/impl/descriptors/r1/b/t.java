package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.v;

/* compiled from: ReflectJavaMember.kt */
/* loaded from: classes2.dex */
public abstract class t extends p implements h, v, kotlin.reflect.y.internal.j0.d.a.n0.q {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.v
    public int E() {
        return U().getModifiers();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean Q() {
        return v.a.d(this);
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

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.q
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public l P() {
        Class<?> declaringClass = U().getDeclaringClass();
        kotlin.jvm.internal.m.e(declaringClass, "member.declaringClass");
        return new l(declaringClass);
    }

    public abstract Member U();

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<kotlin.reflect.y.internal.j0.d.a.n0.b0> V(Type[] typeArr, Annotation[][] annotationArr, boolean z) {
        String str;
        boolean z2;
        int A;
        kotlin.jvm.internal.m.f(typeArr, "parameterTypes");
        kotlin.jvm.internal.m.f(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> b2 = c.a.b(U());
        int size = b2 != null ? b2.size() - typeArr.length : 0;
        int length = typeArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            z a = z.a.a(typeArr[i2]);
            if (b2 != null) {
                str = (String) kotlin.collections.s.X(b2, i2 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i2 + '+' + size + " (name=" + getName() + " type=" + a + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            if (z) {
                A = kotlin.collections.n.A(typeArr);
                if (i2 == A) {
                    z2 = true;
                    arrayList.add(new b0(a, annotationArr[i2], str, z2));
                }
            }
            z2 = false;
            arrayList.add(new b0(a, annotationArr[i2], str, z2));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && kotlin.jvm.internal.m.a(U(), ((t) obj).U());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.t
    public kotlin.reflect.y.internal.j0.f.f getName() {
        String name = U().getName();
        kotlin.reflect.y.internal.j0.f.f x = name != null ? kotlin.reflect.y.internal.j0.f.f.x(name) : null;
        return x == null ? kotlin.reflect.y.internal.j0.f.h.f24216b : x;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public m1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return U().hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return h.a.c(this);
    }

    public String toString() {
        return getClass().getName() + ": " + U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.h
    public AnnotatedElement w() {
        Member U = U();
        kotlin.jvm.internal.m.d(U, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) U;
    }
}
