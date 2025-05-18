package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.util.Collection;
import java.util.List;

/* compiled from: ReflectJavaPrimitiveType.kt */
/* loaded from: classes2.dex */
public final class x extends z implements kotlin.reflect.y.internal.j0.d.a.n0.v {

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f25362b;

    /* renamed from: c, reason: collision with root package name */
    private final Collection<kotlin.reflect.y.internal.j0.d.a.n0.a> f25363c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f25364d;

    public x(Class<?> cls) {
        List j2;
        kotlin.jvm.internal.m.f(cls, "reflectType");
        this.f25362b = cls;
        j2 = kotlin.collections.u.j();
        this.f25363c = j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public Class<?> R() {
        return this.f25362b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.a> getAnnotations() {
        return this.f25363c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.v
    public kotlin.reflect.y.internal.j0.b.i getType() {
        if (kotlin.jvm.internal.m.a(R(), Void.TYPE)) {
            return null;
        }
        return kotlin.reflect.y.internal.j0.i.u.e.k(R().getName()).x();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return this.f25364d;
    }
}
