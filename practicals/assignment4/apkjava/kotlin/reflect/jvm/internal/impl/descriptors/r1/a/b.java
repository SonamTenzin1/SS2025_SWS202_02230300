package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* compiled from: ReflectAnnotationSource.kt */
/* loaded from: classes2.dex */
public final class b implements z0 {

    /* renamed from: b, reason: collision with root package name */
    private final Annotation f25315b;

    public b(Annotation annotation) {
        kotlin.jvm.internal.m.f(annotation, "annotation");
        this.f25315b = annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public a1 a() {
        a1 a1Var = a1.a;
        kotlin.jvm.internal.m.e(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    public final Annotation d() {
        return this.f25315b;
    }
}
