package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z;

/* compiled from: ReflectJavaArrayType.kt */
/* loaded from: classes2.dex */
public final class k extends z implements kotlin.reflect.y.internal.j0.d.a.n0.f {

    /* renamed from: b, reason: collision with root package name */
    private final Type f25345b;

    /* renamed from: c, reason: collision with root package name */
    private final z f25346c;

    /* renamed from: d, reason: collision with root package name */
    private final Collection<kotlin.reflect.y.internal.j0.d.a.n0.a> f25347d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f25348e;

    public k(Type type) {
        z a;
        List j2;
        kotlin.jvm.internal.m.f(type, "reflectType");
        this.f25345b = type;
        Type R = R();
        if (!(R instanceof GenericArrayType)) {
            if (R instanceof Class) {
                Class cls = (Class) R;
                if (cls.isArray()) {
                    z.a aVar = z.a;
                    Class<?> componentType = cls.getComponentType();
                    kotlin.jvm.internal.m.e(componentType, "getComponentType()");
                    a = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + R().getClass() + "): " + R());
        }
        z.a aVar2 = z.a;
        Type genericComponentType = ((GenericArrayType) R).getGenericComponentType();
        kotlin.jvm.internal.m.e(genericComponentType, "genericComponentType");
        a = aVar2.a(genericComponentType);
        this.f25346c = a;
        j2 = kotlin.collections.u.j();
        this.f25347d = j2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z
    protected Type R() {
        return this.f25345b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.f
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public z n() {
        return this.f25346c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.a> getAnnotations() {
        return this.f25347d;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return this.f25348e;
    }
}
