package kotlin.reflect.y.internal.j0.j.b;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.h;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public abstract class a implements o0 {
    private final n a;

    /* renamed from: b, reason: collision with root package name */
    private final u f24454b;

    /* renamed from: c, reason: collision with root package name */
    private final g0 f24455c;

    /* renamed from: d, reason: collision with root package name */
    protected k f24456d;

    /* renamed from: e, reason: collision with root package name */
    private final h<c, k0> f24457e;

    /* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
    /* renamed from: kotlin.f0.y.e.j0.j.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0383a extends Lambda implements Function1<c, k0> {
        C0383a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 invoke(c cVar) {
            m.f(cVar, "fqName");
            p d2 = a.this.d(cVar);
            if (d2 == null) {
                return null;
            }
            d2.M0(a.this.e());
            return d2;
        }
    }

    public a(n nVar, u uVar, g0 g0Var) {
        m.f(nVar, "storageManager");
        m.f(uVar, "finder");
        m.f(g0Var, "moduleDescriptor");
        this.a = nVar;
        this.f24454b = uVar;
        this.f24455c = g0Var;
        this.f24457e = nVar.i(new C0383a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public List<k0> a(c cVar) {
        List<k0> n;
        m.f(cVar, "fqName");
        n = u.n(this.f24457e.invoke(cVar));
        return n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public void b(c cVar, Collection<k0> collection) {
        m.f(cVar, "fqName");
        m.f(collection, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.a.a(collection, this.f24457e.invoke(cVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o0
    public boolean c(c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.m d2;
        m.f(cVar, "fqName");
        if (this.f24457e.f(cVar)) {
            d2 = (k0) this.f24457e.invoke(cVar);
        } else {
            d2 = d(cVar);
        }
        return d2 == null;
    }

    protected abstract p d(c cVar);

    protected final k e() {
        k kVar = this.f24456d;
        if (kVar != null) {
            return kVar;
        }
        m.w("components");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u f() {
        return this.f24454b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final g0 g() {
        return this.f24455c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final n h() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(k kVar) {
        m.f(kVar, "<set-?>");
        this.f24456d = kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    public Collection<c> p(c cVar, Function1<? super f, Boolean> function1) {
        Set d2;
        m.f(cVar, "fqName");
        m.f(function1, "nameFilter");
        d2 = w0.d();
        return d2;
    }
}
