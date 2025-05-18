package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.y.internal.j0.i.w.h;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
/* loaded from: classes2.dex */
public class r extends j implements p0 {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f25282h = {kotlin.jvm.internal.g0.h(new kotlin.jvm.internal.y(kotlin.jvm.internal.g0.b(r.class), "fragments", "getFragments()Ljava/util/List;")), kotlin.jvm.internal.g0.h(new kotlin.jvm.internal.y(kotlin.jvm.internal.g0.b(r.class), "empty", "getEmpty()Z"))};

    /* renamed from: i, reason: collision with root package name */
    private final x f25283i;

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f25284j;

    /* renamed from: k, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f25285k;
    private final kotlin.reflect.y.internal.j0.k.i l;
    private final kotlin.reflect.y.internal.j0.i.w.h m;

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<Boolean> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.n0.b(r.this.v0().R0(), r.this.d()));
        }
    }

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.k0>> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.k0> invoke() {
            return kotlin.reflect.jvm.internal.impl.descriptors.n0.c(r.this.v0().R0(), r.this.d());
        }
    }

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<kotlin.reflect.y.internal.j0.i.w.h> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.i.w.h invoke() {
            int u;
            List p0;
            if (r.this.isEmpty()) {
                return h.b.f24422b;
            }
            List<kotlin.reflect.jvm.internal.impl.descriptors.k0> I = r.this.I();
            u = kotlin.collections.v.u(I, 10);
            ArrayList arrayList = new ArrayList(u);
            Iterator<T> it = I.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.k0) it.next()).q());
            }
            p0 = kotlin.collections.c0.p0(arrayList, new h0(r.this.v0(), r.this.d()));
            return kotlin.reflect.y.internal.j0.i.w.b.f24397b.a("package view scope for " + r.this.d() + " in " + r.this.v0().getName(), p0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x xVar, kotlin.reflect.y.internal.j0.f.c cVar, kotlin.reflect.y.internal.j0.k.n nVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), cVar.h());
        kotlin.jvm.internal.m.f(xVar, "module");
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        this.f25283i = xVar;
        this.f25284j = cVar;
        this.f25285k = nVar.d(new b());
        this.l = nVar.d(new a());
        this.m = new kotlin.reflect.y.internal.j0.i.w.g(nVar, new c());
    }

    protected final boolean A0() {
        return ((Boolean) kotlin.reflect.y.internal.j0.k.m.a(this.l, this, f25282h[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public List<kotlin.reflect.jvm.internal.impl.descriptors.k0> I() {
        return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f25285k, this, f25282h[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public p0 b() {
        if (d().d()) {
            return null;
        }
        x v0 = v0();
        kotlin.reflect.y.internal.j0.f.c e2 = d().e();
        kotlin.jvm.internal.m.e(e2, "fqName.parent()");
        return v0.N(e2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        kotlin.jvm.internal.m.f(oVar, "visitor");
        return oVar.c(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public x v0() {
        return this.f25283i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public kotlin.reflect.y.internal.j0.f.c d() {
        return this.f25284j;
    }

    public boolean equals(Object obj) {
        p0 p0Var = obj instanceof p0 ? (p0) obj : null;
        return p0Var != null && kotlin.jvm.internal.m.a(d(), p0Var.d()) && kotlin.jvm.internal.m.a(v0(), p0Var.v0());
    }

    public int hashCode() {
        return (v0().hashCode() * 31) + d().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public boolean isEmpty() {
        return A0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    public kotlin.reflect.y.internal.j0.i.w.h q() {
        return this.m;
    }
}
