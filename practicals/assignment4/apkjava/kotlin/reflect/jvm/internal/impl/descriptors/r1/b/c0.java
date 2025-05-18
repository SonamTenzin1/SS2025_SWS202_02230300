package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z;

/* compiled from: ReflectJavaWildcardType.kt */
/* loaded from: classes2.dex */
public final class c0 extends z implements kotlin.reflect.y.internal.j0.d.a.n0.c0 {

    /* renamed from: b, reason: collision with root package name */
    private final WildcardType f25334b;

    /* renamed from: c, reason: collision with root package name */
    private final Collection<kotlin.reflect.y.internal.j0.d.a.n0.a> f25335c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f25336d;

    public c0(WildcardType wildcardType) {
        List j2;
        kotlin.jvm.internal.m.f(wildcardType, "reflectType");
        this.f25334b = wildcardType;
        j2 = kotlin.collections.u.j();
        this.f25335c = j2;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.c0
    public boolean J() {
        kotlin.jvm.internal.m.e(R().getUpperBounds(), "reflectType.upperBounds");
        return !kotlin.jvm.internal.m.a(kotlin.collections.j.x(r0), Object.class);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.c0
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public z C() {
        Type[] upperBounds = R().getUpperBounds();
        Type[] lowerBounds = R().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                z.a aVar = z.a;
                kotlin.jvm.internal.m.e(lowerBounds, "lowerBounds");
                Object N = kotlin.collections.j.N(lowerBounds);
                kotlin.jvm.internal.m.e(N, "lowerBounds.single()");
                return aVar.a((Type) N);
            }
            if (upperBounds.length != 1) {
                return null;
            }
            kotlin.jvm.internal.m.e(upperBounds, "upperBounds");
            Type type = (Type) kotlin.collections.j.N(upperBounds);
            if (kotlin.jvm.internal.m.a(type, Object.class)) {
                return null;
            }
            z.a aVar2 = z.a;
            kotlin.jvm.internal.m.e(type, "ub");
            return aVar2.a(type);
        }
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + R());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public WildcardType R() {
        return this.f25334b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.a> getAnnotations() {
        return this.f25335c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return this.f25336d;
    }
}
