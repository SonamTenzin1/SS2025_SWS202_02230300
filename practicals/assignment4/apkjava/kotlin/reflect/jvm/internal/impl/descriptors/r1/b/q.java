package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: classes2.dex */
public final class q extends f implements kotlin.reflect.y.internal.j0.d.a.n0.m {

    /* renamed from: c, reason: collision with root package name */
    private final Enum<?> f25360c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(kotlin.reflect.y.internal.j0.f.f fVar, Enum<?> r3) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(r3, "value");
        this.f25360c = r3;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.m
    public kotlin.reflect.y.internal.j0.f.b b() {
        Class<?> cls = this.f25360c.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        kotlin.jvm.internal.m.e(cls, "enumClass");
        return d.a(cls);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.m
    public kotlin.reflect.y.internal.j0.f.f d() {
        return kotlin.reflect.y.internal.j0.f.f.x(this.f25360c.name());
    }
}
