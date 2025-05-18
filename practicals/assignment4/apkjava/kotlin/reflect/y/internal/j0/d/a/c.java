package kotlin.reflect.y.internal.j0.d.a;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.reflect.y.internal.j0.d.a.o0.h;
import kotlin.reflect.y.internal.j0.d.a.o0.i;
import kotlin.s;

/* compiled from: AnnotationQualifiersFqNames.kt */
/* loaded from: classes2.dex */
public final class c {
    private static final kotlin.reflect.y.internal.j0.f.c a = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.meta.TypeQualifierNickname");

    /* renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23350b = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.meta.TypeQualifier");

    /* renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23351c = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.meta.TypeQualifierDefault");

    /* renamed from: d, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23352d = new kotlin.reflect.y.internal.j0.f.c("kotlin.annotations.jvm.UnderMigration");

    /* renamed from: e, reason: collision with root package name */
    private static final List<b> f23353e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<kotlin.reflect.y.internal.j0.f.c, q> f23354f;

    /* renamed from: g, reason: collision with root package name */
    private static final Map<kotlin.reflect.y.internal.j0.f.c, q> f23355g;

    /* renamed from: h, reason: collision with root package name */
    private static final Set<kotlin.reflect.y.internal.j0.f.c> f23356h;

    static {
        List<b> m;
        Map<kotlin.reflect.y.internal.j0.f.c, q> f2;
        List e2;
        List e3;
        Map l;
        Map<kotlin.reflect.y.internal.j0.f.c, q> n;
        Set<kotlin.reflect.y.internal.j0.f.c> i2;
        b bVar = b.VALUE_PARAMETER;
        m = u.m(b.FIELD, b.METHOD_RETURN_TYPE, bVar, b.TYPE_PARAMETER_BOUNDS, b.TYPE_USE);
        f23353e = m;
        kotlin.reflect.y.internal.j0.f.c i3 = b0.i();
        h hVar = h.NOT_NULL;
        f2 = p0.f(s.a(i3, new q(new i(hVar, false, 2, null), m, false)));
        f23354f = f2;
        kotlin.reflect.y.internal.j0.f.c cVar = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.ParametersAreNullableByDefault");
        i iVar = new i(h.NULLABLE, false, 2, null);
        e2 = t.e(bVar);
        kotlin.reflect.y.internal.j0.f.c cVar2 = new kotlin.reflect.y.internal.j0.f.c("javax.annotation.ParametersAreNonnullByDefault");
        i iVar2 = new i(hVar, false, 2, null);
        e3 = t.e(bVar);
        l = q0.l(s.a(cVar, new q(iVar, e2, false, 4, null)), s.a(cVar2, new q(iVar2, e3, false, 4, null)));
        n = q0.n(l, f2);
        f23355g = n;
        i2 = w0.i(b0.f(), b0.e());
        f23356h = i2;
    }

    public static final Map<kotlin.reflect.y.internal.j0.f.c, q> a() {
        return f23355g;
    }

    public static final Set<kotlin.reflect.y.internal.j0.f.c> b() {
        return f23356h;
    }

    public static final Map<kotlin.reflect.y.internal.j0.f.c, q> c() {
        return f23354f;
    }

    public static final kotlin.reflect.y.internal.j0.f.c d() {
        return f23352d;
    }

    public static final kotlin.reflect.y.internal.j0.f.c e() {
        return f23351c;
    }

    public static final kotlin.reflect.y.internal.j0.f.c f() {
        return f23350b;
    }

    public static final kotlin.reflect.y.internal.j0.f.c g() {
        return a;
    }
}
