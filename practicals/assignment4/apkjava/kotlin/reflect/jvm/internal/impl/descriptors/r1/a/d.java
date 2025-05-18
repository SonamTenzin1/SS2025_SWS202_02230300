package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.w;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.text.u;

/* compiled from: ReflectJavaClassFinder.kt */
/* loaded from: classes2.dex */
public final class d implements o {
    private final ClassLoader a;

    public d(ClassLoader classLoader) {
        kotlin.jvm.internal.m.f(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o
    public kotlin.reflect.y.internal.j0.d.a.n0.g a(o.b bVar) {
        String z;
        kotlin.jvm.internal.m.f(bVar, "request");
        kotlin.reflect.y.internal.j0.f.b a = bVar.a();
        kotlin.reflect.y.internal.j0.f.c h2 = a.h();
        kotlin.jvm.internal.m.e(h2, "classId.packageFqName");
        String b2 = a.i().b();
        kotlin.jvm.internal.m.e(b2, "classId.relativeClassName.asString()");
        z = u.z(b2, '.', '$', false, 4, null);
        if (!h2.d()) {
            z = h2.b() + '.' + z;
        }
        Class<?> a2 = e.a(this.a, z);
        if (a2 != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.r1.b.l(a2);
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o
    public Set<String> b(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "packageFqName");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.o
    public kotlin.reflect.y.internal.j0.d.a.n0.u c(kotlin.reflect.y.internal.j0.f.c cVar, boolean z) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        return new w(cVar);
    }
}
