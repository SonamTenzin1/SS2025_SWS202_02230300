package kotlin.reflect.y.internal.j0.c;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.c.b.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;

/* compiled from: utils.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final void a(c cVar, b bVar, e eVar, f fVar) {
        kotlin.reflect.y.internal.j0.c.b.a location;
        m.f(cVar, "<this>");
        m.f(bVar, "from");
        m.f(eVar, "scopeOwner");
        m.f(fVar, "name");
        if (cVar == c.a.a || (location = bVar.getLocation()) == null) {
            return;
        }
        kotlin.reflect.y.internal.j0.c.b.e position = cVar.a() ? location.getPosition() : kotlin.reflect.y.internal.j0.c.b.e.f23313f.a();
        String a = location.a();
        String b2 = d.m(eVar).b();
        m.e(b2, "getFqName(scopeOwner).asString()");
        kotlin.reflect.y.internal.j0.c.b.f fVar2 = kotlin.reflect.y.internal.j0.c.b.f.CLASSIFIER;
        String k2 = fVar.k();
        m.e(k2, "name.asString()");
        cVar.b(a, position, b2, fVar2, k2);
    }

    public static final void b(c cVar, b bVar, k0 k0Var, f fVar) {
        m.f(cVar, "<this>");
        m.f(bVar, "from");
        m.f(k0Var, "scopeOwner");
        m.f(fVar, "name");
        String b2 = k0Var.d().b();
        m.e(b2, "scopeOwner.fqName.asString()");
        String k2 = fVar.k();
        m.e(k2, "name.asString()");
        c(cVar, bVar, b2, k2);
    }

    public static final void c(c cVar, b bVar, String str, String str2) {
        kotlin.reflect.y.internal.j0.c.b.a location;
        m.f(cVar, "<this>");
        m.f(bVar, "from");
        m.f(str, "packageFqName");
        m.f(str2, "name");
        if (cVar == c.a.a || (location = bVar.getLocation()) == null) {
            return;
        }
        cVar.b(location.a(), cVar.a() ? location.getPosition() : kotlin.reflect.y.internal.j0.c.b.e.f23313f.a(), str, kotlin.reflect.y.internal.j0.c.b.f.PACKAGE, str2);
    }
}
