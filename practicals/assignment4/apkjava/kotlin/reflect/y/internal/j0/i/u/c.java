package kotlin.reflect.y.internal.j0.i.u;

import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.y.internal.j0.c.b.d;
import kotlin.reflect.y.internal.j0.d.a.j0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.f;
import kotlin.reflect.y.internal.j0.d.a.n0.d0;
import kotlin.reflect.y.internal.j0.i.w.h;

/* compiled from: JavaDescriptorResolver.kt */
/* loaded from: classes3.dex */
public final class c {
    private final f a;

    /* renamed from: b, reason: collision with root package name */
    private final g f24387b;

    public c(f fVar, g gVar) {
        m.f(fVar, "packageFragmentProvider");
        m.f(gVar, "javaResolverCache");
        this.a = fVar;
        this.f24387b = gVar;
    }

    public final f a() {
        return this.a;
    }

    public final e b(kotlin.reflect.y.internal.j0.d.a.n0.g gVar) {
        m.f(gVar, "javaClass");
        kotlin.reflect.y.internal.j0.f.c d2 = gVar.d();
        if (d2 != null && gVar.I() == d0.SOURCE) {
            return this.f24387b.a(d2);
        }
        kotlin.reflect.y.internal.j0.d.a.n0.g i2 = gVar.i();
        if (i2 != null) {
            e b2 = b(i2);
            h y0 = b2 != null ? b2.y0() : null;
            kotlin.reflect.jvm.internal.impl.descriptors.h f2 = y0 != null ? y0.f(gVar.getName(), d.FROM_JAVA_LOADER) : null;
            if (f2 instanceof e) {
                return (e) f2;
            }
            return null;
        }
        if (d2 == null) {
            return null;
        }
        f fVar = this.a;
        kotlin.reflect.y.internal.j0.f.c e2 = d2.e();
        m.e(e2, "fqName.parent()");
        kotlin.reflect.y.internal.j0.d.a.l0.l.h hVar = (kotlin.reflect.y.internal.j0.d.a.l0.l.h) s.W(fVar.a(e2));
        if (hVar != null) {
            return hVar.M0(gVar);
        }
        return null;
    }
}
