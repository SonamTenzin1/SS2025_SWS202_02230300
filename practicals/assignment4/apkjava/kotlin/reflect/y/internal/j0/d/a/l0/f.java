package kotlin.reflect.y.internal.j0.d.a.l0;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.y.internal.j0.d.a.l0.k;
import kotlin.reflect.y.internal.j0.d.a.l0.l.h;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.reflect.y.internal.j0.f.c;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
/* loaded from: classes2.dex */
public final class f implements o0 {
    private final g a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.a<c, h> f23464b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyJavaPackageFragmentProvider.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function0<h> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ u f23466g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u uVar) {
            super(0);
            this.f23466g = uVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            return new h(f.this.a, this.f23466g);
        }
    }

    public f(b bVar) {
        Lazy c2;
        m.f(bVar, "components");
        k.a aVar = k.a.a;
        c2 = j.c(null);
        g gVar = new g(bVar, aVar, c2);
        this.a = gVar;
        this.f23464b = gVar.e().b();
    }

    private final h e(c cVar) {
        u a2 = o.a.a(this.a.a().d(), cVar, false, 2, null);
        if (a2 == null) {
            return null;
        }
        return this.f23464b.b(cVar, new a(a2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public List<h> a(c cVar) {
        List<h> n;
        m.f(cVar, "fqName");
        n = kotlin.collections.u.n(e(cVar));
        return n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public void b(c cVar, Collection<k0> collection) {
        m.f(cVar, "fqName");
        m.f(collection, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.a.a(collection, e(cVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public boolean c(c cVar) {
        m.f(cVar, "fqName");
        return o.a.a(this.a.a().d(), cVar, false, 2, null) == null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<c> p(c cVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        List<c> j2;
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        h e2 = e(cVar);
        List<c> P0 = e2 != null ? e2.P0() : null;
        if (P0 != null) {
            return P0;
        }
        j2 = kotlin.collections.u.j();
        return j2;
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.a.a().m();
    }
}
