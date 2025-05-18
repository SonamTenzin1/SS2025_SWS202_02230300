package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.f;
import kotlin.reflect.y.internal.j0.d.a.n0.a;

/* compiled from: ReflectJavaAnnotation.kt */
/* loaded from: classes2.dex */
public final class e extends p implements kotlin.reflect.y.internal.j0.d.a.n0.a {
    private final Annotation a;

    public e(Annotation annotation) {
        kotlin.jvm.internal.m.f(annotation, "annotation");
        this.a = annotation;
    }

    public final Annotation R() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public l z() {
        return new l(kotlin.jvm.a.b(kotlin.jvm.a.a(this.a)));
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.b> b() {
        Method[] declaredMethods = kotlin.jvm.a.b(kotlin.jvm.a.a(this.a)).getDeclaredMethods();
        kotlin.jvm.internal.m.e(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            f.a aVar = f.a;
            Object invoke = method.invoke(this.a, new Object[0]);
            kotlin.jvm.internal.m.e(invoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(invoke, kotlin.reflect.y.internal.j0.f.f.x(method.getName())));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public kotlin.reflect.y.internal.j0.f.b e() {
        return d.a(kotlin.jvm.a.b(kotlin.jvm.a.a(this.a)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && this.a == ((e) obj).a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public boolean g() {
        return a.C0336a.b(this);
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }

    public String toString() {
        return e.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public boolean v() {
        return a.C0336a.a(this);
    }
}
