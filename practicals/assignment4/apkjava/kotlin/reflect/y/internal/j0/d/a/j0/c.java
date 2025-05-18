package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.Map;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.l0.l.e;
import kotlin.reflect.y.internal.j0.d.a.n0.a;
import kotlin.reflect.y.internal.j0.d.a.n0.d;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.s;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final f f23413b;

    /* renamed from: c, reason: collision with root package name */
    private static final f f23414c;

    /* renamed from: d, reason: collision with root package name */
    private static final f f23415d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<kotlin.reflect.y.internal.j0.f.c, kotlin.reflect.y.internal.j0.f.c> f23416e;

    static {
        Map<kotlin.reflect.y.internal.j0.f.c, kotlin.reflect.y.internal.j0.f.c> l;
        f x = f.x("message");
        m.e(x, "identifier(\"message\")");
        f23413b = x;
        f x2 = f.x("allowedTargets");
        m.e(x2, "identifier(\"allowedTargets\")");
        f23414c = x2;
        f x3 = f.x("value");
        m.e(x3, "identifier(\"value\")");
        f23415d = x3;
        l = q0.l(s.a(k.a.H, a0.f23326d), s.a(k.a.L, a0.f23328f), s.a(k.a.P, a0.f23331i));
        f23416e = l;
    }

    private c() {
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.n1.c f(c cVar, a aVar, g gVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return cVar.e(aVar, gVar, z);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.n1.c a(kotlin.reflect.y.internal.j0.f.c cVar, d dVar, g gVar) {
        a l;
        m.f(cVar, "kotlinName");
        m.f(dVar, "annotationOwner");
        m.f(gVar, "c");
        if (m.a(cVar, k.a.y)) {
            kotlin.reflect.y.internal.j0.f.c cVar2 = a0.f23330h;
            m.e(cVar2, "DEPRECATED_ANNOTATION");
            a l2 = dVar.l(cVar2);
            if (l2 != null || dVar.m()) {
                return new e(l2, gVar);
            }
        }
        kotlin.reflect.y.internal.j0.f.c cVar3 = f23416e.get(cVar);
        if (cVar3 == null || (l = dVar.l(cVar3)) == null) {
            return null;
        }
        return f(a, l, gVar, false, 4, null);
    }

    public final f b() {
        return f23413b;
    }

    public final f c() {
        return f23415d;
    }

    public final f d() {
        return f23414c;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.n1.c e(a aVar, g gVar, boolean z) {
        m.f(aVar, "annotation");
        m.f(gVar, "c");
        b e2 = aVar.e();
        if (m.a(e2, b.m(a0.f23326d))) {
            return new i(aVar, gVar);
        }
        if (m.a(e2, b.m(a0.f23328f))) {
            return new h(aVar, gVar);
        }
        if (m.a(e2, b.m(a0.f23331i))) {
            return new b(gVar, aVar, k.a.P);
        }
        if (m.a(e2, b.m(a0.f23330h))) {
            return null;
        }
        return new e(gVar, aVar, z);
    }
}
