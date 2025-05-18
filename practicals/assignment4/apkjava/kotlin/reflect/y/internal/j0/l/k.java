package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;

/* compiled from: AnnotationsTypeAttribute.kt */
/* loaded from: classes3.dex */
public final class k {
    static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.d(k.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};

    /* renamed from: b, reason: collision with root package name */
    private static final ReadOnlyProperty f24752b;

    static {
        ReadOnlyProperty c2 = a1.f24676g.c(g0.b(j.class));
        m.d(c2, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        f24752b = c2;
    }

    public static final g a(a1 a1Var) {
        g e2;
        m.f(a1Var, "<this>");
        j b2 = b(a1Var);
        return (b2 == null || (e2 = b2.e()) == null) ? g.f25179c.b() : e2;
    }

    public static final j b(a1 a1Var) {
        m.f(a1Var, "<this>");
        return (j) f24752b.a(a1Var, a[0]);
    }
}
