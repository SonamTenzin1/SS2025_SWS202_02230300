package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: classes2.dex */
public final class g extends f implements kotlin.reflect.y.internal.j0.d.a.n0.c {

    /* renamed from: c, reason: collision with root package name */
    private final Annotation f25343c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(kotlin.reflect.y.internal.j0.f.f fVar, Annotation annotation) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(annotation, "annotation");
        this.f25343c = annotation;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.c
    public kotlin.reflect.y.internal.j0.d.a.n0.a a() {
        return new e(this.f25343c);
    }
}
