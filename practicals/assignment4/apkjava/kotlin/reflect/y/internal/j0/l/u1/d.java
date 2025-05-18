package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.y.internal.j0.b.e;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: ErrorModuleDescriptor.kt */
/* loaded from: classes3.dex */
public final class d implements g0 {

    /* renamed from: f, reason: collision with root package name */
    public static final d f24825f = new d();

    /* renamed from: g, reason: collision with root package name */
    private static final f f24826g;

    /* renamed from: h, reason: collision with root package name */
    private static final List<g0> f24827h;

    /* renamed from: i, reason: collision with root package name */
    private static final List<g0> f24828i;

    /* renamed from: j, reason: collision with root package name */
    private static final Set<g0> f24829j;

    /* renamed from: k, reason: collision with root package name */
    private static final h f24830k;

    static {
        List<g0> j2;
        List<g0> j3;
        Set<g0> d2;
        f D = f.D(b.ERROR_MODULE.k());
        m.e(D, "special(ErrorEntity.ERROR_MODULE.debugText)");
        f24826g = D;
        j2 = u.j();
        f24827h = j2;
        j3 = u.j();
        f24828i = j3;
        d2 = w0.d();
        f24829j = d2;
        f24830k = e.f23157h.a();
    }

    private d() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public <T> T I0(f0<T> f0Var) {
        m.f(f0Var, "capability");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        m.f(oVar, "visitor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public p0 N(c cVar) {
        m.f(cVar, "fqName");
        throw new IllegalStateException("Should not be called!");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public boolean e0(g0 g0Var) {
        m.f(g0Var, "targetModule");
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public g getAnnotations() {
        return g.f25179c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i0
    public f getName() {
        return v();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public h o() {
        return f24830k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public Collection<c> p(c cVar, Function1<? super f, Boolean> function1) {
        List j2;
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public List<g0> t0() {
        return f24828i;
    }

    public f v() {
        return f24826g;
    }
}
