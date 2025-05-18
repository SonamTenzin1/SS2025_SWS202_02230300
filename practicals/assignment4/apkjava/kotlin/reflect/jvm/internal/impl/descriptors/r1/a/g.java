package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import java.io.InputStream;
import kotlin.reflect.y.internal.j0.d.b.o;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes2.dex */
public final class g implements o {
    private final ClassLoader a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.j.b.f0.d f25318b;

    public g(ClassLoader classLoader) {
        kotlin.jvm.internal.m.f(classLoader, "classLoader");
        this.a = classLoader;
        this.f25318b = new kotlin.reflect.y.internal.j0.j.b.f0.d();
    }

    private final o.a d(String str) {
        f a;
        Class<?> a2 = e.a(this.a, str);
        if (a2 == null || (a = f.a.a(a2)) == null) {
            return null;
        }
        return new o.a.b(a, null, 2, null);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.o
    public o.a a(kotlin.reflect.y.internal.j0.d.a.n0.g gVar) {
        String b2;
        kotlin.jvm.internal.m.f(gVar, "javaClass");
        kotlin.reflect.y.internal.j0.f.c d2 = gVar.d();
        if (d2 == null || (b2 = d2.b()) == null) {
            return null;
        }
        return d(b2);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.u
    public InputStream b(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "packageFqName");
        if (cVar.i(kotlin.reflect.y.internal.j0.b.k.q)) {
            return this.f25318b.a(kotlin.reflect.y.internal.j0.j.b.f0.a.n.n(cVar));
        }
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.o
    public o.a c(kotlin.reflect.y.internal.j0.f.b bVar) {
        String b2;
        kotlin.jvm.internal.m.f(bVar, "classId");
        b2 = h.b(bVar);
        return d(b2);
    }
}
