package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

/* compiled from: ReflectJavaAnnotationArguments.kt */
/* loaded from: classes2.dex */
public final class s extends f implements kotlin.reflect.y.internal.j0.d.a.n0.o {

    /* renamed from: c, reason: collision with root package name */
    private final Object f25361c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(kotlin.reflect.y.internal.j0.f.f fVar, Object obj) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(obj, "value");
        this.f25361c = obj;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.o
    public Object getValue() {
        return this.f25361c;
    }
}
