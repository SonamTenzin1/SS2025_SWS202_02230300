package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.i.w.d;
import kotlin.reflect.y.internal.j0.i.w.h;

/* compiled from: ErrorScope.kt */
/* loaded from: classes3.dex */
public class f implements h {

    /* renamed from: b, reason: collision with root package name */
    private final g f24832b;

    /* renamed from: c, reason: collision with root package name */
    private final String f24833c;

    public f(g gVar, String... strArr) {
        m.f(gVar, "kind");
        m.f(strArr, "formatParams");
        this.f24832b = gVar;
        String k2 = gVar.k();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        String format = String.format(k2, Arrays.copyOf(copyOf, copyOf.length));
        m.e(format, "format(this, *args)");
        this.f24833c = format;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> b() {
        Set<kotlin.reflect.y.internal.j0.f.f> d2;
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> d() {
        Set<kotlin.reflect.y.internal.j0.f.f> d2;
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    public Set<kotlin.reflect.y.internal.j0.f.f> e() {
        Set<kotlin.reflect.y.internal.j0.f.f> d2;
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.reflect.jvm.internal.impl.descriptors.h f(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        String format = String.format(b.ERROR_CLASS.k(), Arrays.copyOf(new Object[]{fVar}, 1));
        m.e(format, "format(this, *args)");
        kotlin.reflect.y.internal.j0.f.f D = kotlin.reflect.y.internal.j0.f.f.D(format);
        m.e(D, "special(ErrorEntity.ERRO…S.debugText.format(name))");
        return new a(D);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.k
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        List j2;
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        Set<y0> c2;
        m.f(fVar, "name");
        m.f(bVar, "location");
        c2 = v0.c(new c(k.a.h()));
        return c2;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Set<t0> c(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return k.a.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String j() {
        return this.f24833c;
    }

    public String toString() {
        return "ErrorScope{" + this.f24833c + '}';
    }
}
