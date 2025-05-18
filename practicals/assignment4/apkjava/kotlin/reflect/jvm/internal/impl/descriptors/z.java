package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.y.internal.j0.l.w1.k;

/* compiled from: InlineClassRepresentation.kt */
/* loaded from: classes2.dex */
public final class z<Type extends kotlin.reflect.y.internal.j0.l.w1.k> extends g1<Type> {
    private final kotlin.reflect.y.internal.j0.f.f a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f25385b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(kotlin.reflect.y.internal.j0.f.f fVar, Type type) {
        super(null);
        kotlin.jvm.internal.m.f(fVar, "underlyingPropertyName");
        kotlin.jvm.internal.m.f(type, "underlyingType");
        this.a = fVar;
        this.f25385b = type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public List<Pair<kotlin.reflect.y.internal.j0.f.f, Type>> a() {
        List<Pair<kotlin.reflect.y.internal.j0.f.f, Type>> e2;
        e2 = kotlin.collections.t.e(kotlin.s.a(this.a, this.f25385b));
        return e2;
    }

    public final kotlin.reflect.y.internal.j0.f.f c() {
        return this.a;
    }

    public final Type d() {
        return this.f25385b;
    }
}
