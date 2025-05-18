package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g1;

/* compiled from: ErrorUtils.kt */
/* loaded from: classes3.dex */
public final class k {
    public static final k a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static final g0 f24853b = d.f24825f;

    /* renamed from: c, reason: collision with root package name */
    private static final a f24854c;

    /* renamed from: d, reason: collision with root package name */
    private static final e0 f24855d;

    /* renamed from: e, reason: collision with root package name */
    private static final e0 f24856e;

    /* renamed from: f, reason: collision with root package name */
    private static final t0 f24857f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<t0> f24858g;

    static {
        Set<t0> c2;
        String format = String.format(b.ERROR_CLASS.k(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        m.e(format, "format(this, *args)");
        f D = f.D(format);
        m.e(D, "special(ErrorEntity.ERRO….format(\"unknown class\"))");
        f24854c = new a(D);
        f24855d = d(j.y, new String[0]);
        f24856e = d(j.v0, new String[0]);
        e eVar = new e();
        f24857f = eVar;
        c2 = v0.c(eVar);
        f24858g = c2;
    }

    private k() {
    }

    public static final f a(g gVar, boolean z, String... strArr) {
        m.f(gVar, "kind");
        m.f(strArr, "formatParams");
        return z ? new l(gVar, (String[]) Arrays.copyOf(strArr, strArr.length)) : new f(gVar, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final f b(g gVar, String... strArr) {
        m.f(gVar, "kind");
        m.f(strArr, "formatParams");
        return a(gVar, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final h d(j jVar, String... strArr) {
        List<? extends g1> j2;
        m.f(jVar, "kind");
        m.f(strArr, "formatParams");
        k kVar = a;
        j2 = u.j();
        return kVar.g(jVar, j2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static final boolean m(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar != null) {
            k kVar = a;
            if (kVar.n(mVar) || kVar.n(mVar.b()) || mVar == f24853b) {
                return true;
            }
        }
        return false;
    }

    private final boolean n(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return mVar instanceof a;
    }

    public static final boolean o(e0 e0Var) {
        if (e0Var == null) {
            return false;
        }
        e1 O0 = e0Var.O0();
        return (O0 instanceof i) && ((i) O0).g() == j.B;
    }

    public final h c(j jVar, e1 e1Var, String... strArr) {
        List<? extends g1> j2;
        m.f(jVar, "kind");
        m.f(e1Var, "typeConstructor");
        m.f(strArr, "formatParams");
        j2 = u.j();
        return f(jVar, j2, e1Var, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final i e(j jVar, String... strArr) {
        m.f(jVar, "kind");
        m.f(strArr, "formatParams");
        return new i(jVar, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final h f(j jVar, List<? extends g1> list, e1 e1Var, String... strArr) {
        m.f(jVar, "kind");
        m.f(list, "arguments");
        m.f(e1Var, "typeConstructor");
        m.f(strArr, "formatParams");
        return new h(e1Var, b(g.ERROR_TYPE_SCOPE, e1Var.toString()), jVar, list, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final h g(j jVar, List<? extends g1> list, String... strArr) {
        m.f(jVar, "kind");
        m.f(list, "arguments");
        m.f(strArr, "formatParams");
        return f(jVar, list, e(jVar, (String[]) Arrays.copyOf(strArr, strArr.length)), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final a h() {
        return f24854c;
    }

    public final g0 i() {
        return f24853b;
    }

    public final Set<t0> j() {
        return f24858g;
    }

    public final e0 k() {
        return f24856e;
    }

    public final e0 l() {
        return f24855d;
    }
}
