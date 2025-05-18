package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.q0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.a0;

/* compiled from: ModuleDescriptorImpl.kt */
/* loaded from: classes2.dex */
public final class x extends j implements kotlin.reflect.jvm.internal.impl.descriptors.g0 {

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.n f25300h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.b.h f25301i;

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.f f25302j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.descriptors.f0<?>, Object> f25303k;
    private final a0 l;
    private v m;
    private kotlin.reflect.jvm.internal.impl.descriptors.l0 n;
    private boolean o;
    private final kotlin.reflect.y.internal.j0.k.g<kotlin.reflect.y.internal.j0.f.c, p0> p;
    private final Lazy q;

    /* compiled from: ModuleDescriptorImpl.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<i> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            int u;
            v vVar = x.this.m;
            x xVar = x.this;
            if (vVar != null) {
                List<x> a = vVar.a();
                x.this.P0();
                a.contains(x.this);
                Iterator<T> it = a.iterator();
                while (it.hasNext()) {
                    ((x) it.next()).U0();
                }
                u = kotlin.collections.v.u(a, 10);
                ArrayList arrayList = new ArrayList(u);
                Iterator<T> it2 = a.iterator();
                while (it2.hasNext()) {
                    kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var = ((x) it2.next()).n;
                    kotlin.jvm.internal.m.c(l0Var);
                    arrayList.add(l0Var);
                }
                return new i(arrayList, "CompositeProvider@ModuleDescriptor for " + x.this.getName());
            }
            throw new AssertionError("Dependencies of module " + xVar.Q0() + " were not set before querying module content");
        }
    }

    /* compiled from: ModuleDescriptorImpl.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.c, p0> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final p0 invoke(kotlin.reflect.y.internal.j0.f.c cVar) {
            kotlin.jvm.internal.m.f(cVar, "fqName");
            a0 a0Var = x.this.l;
            x xVar = x.this;
            return a0Var.a(xVar, cVar, xVar.f25300h);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.y.internal.j0.b.h hVar, kotlin.reflect.y.internal.j0.g.a aVar) {
        this(fVar, nVar, hVar, aVar, null, null, 48, null);
        kotlin.jvm.internal.m.f(fVar, "moduleName");
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        kotlin.jvm.internal.m.f(hVar, "builtIns");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ x(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.y.internal.j0.b.h hVar, kotlin.reflect.y.internal.j0.g.a aVar, Map map, kotlin.reflect.y.internal.j0.f.f fVar2, int i2, kotlin.jvm.internal.g gVar) {
        this(fVar, nVar, hVar, r6, r7, (i2 & 32) != 0 ? null : fVar2);
        Map map2;
        Map i3;
        kotlin.reflect.y.internal.j0.g.a aVar2 = (i2 & 8) != 0 ? null : aVar;
        if ((i2 & 16) != 0) {
            i3 = q0.i();
            map2 = i3;
        } else {
            map2 = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Q0() {
        String fVar = getName().toString();
        kotlin.jvm.internal.m.e(fVar, "name.toString()");
        return fVar;
    }

    private final i S0() {
        return (i) this.q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U0() {
        return this.n != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public <T> T I0(kotlin.reflect.jvm.internal.impl.descriptors.f0<T> f0Var) {
        kotlin.jvm.internal.m.f(f0Var, "capability");
        T t = (T) this.f25303k.get(f0Var);
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        return (R) g0.a.a(this, oVar, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public p0 N(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        P0();
        return this.p.invoke(cVar);
    }

    public void P0() {
        if (V0()) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a0.a(this);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.l0 R0() {
        P0();
        return S0();
    }

    public final void T0(kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var) {
        kotlin.jvm.internal.m.f(l0Var, "providerForModuleContent");
        U0();
        this.n = l0Var;
    }

    public boolean V0() {
        return this.o;
    }

    public final void W0(List<x> list) {
        Set<x> d2;
        kotlin.jvm.internal.m.f(list, "descriptors");
        d2 = w0.d();
        X0(list, d2);
    }

    public final void X0(List<x> list, Set<x> set) {
        List j2;
        Set d2;
        kotlin.jvm.internal.m.f(list, "descriptors");
        kotlin.jvm.internal.m.f(set, "friends");
        j2 = kotlin.collections.u.j();
        d2 = w0.d();
        Y0(new w(list, set, j2, d2));
    }

    public final void Y0(v vVar) {
        kotlin.jvm.internal.m.f(vVar, "dependencies");
        v vVar2 = this.m;
        this.m = vVar;
    }

    public final void Z0(x... xVarArr) {
        List<x> Z;
        kotlin.jvm.internal.m.f(xVarArr, "descriptors");
        Z = kotlin.collections.n.Z(xVarArr);
        W0(Z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        return g0.a.b(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public boolean e0(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var) {
        boolean K;
        kotlin.jvm.internal.m.f(g0Var, "targetModule");
        if (kotlin.jvm.internal.m.a(this, g0Var)) {
            return true;
        }
        v vVar = this.m;
        kotlin.jvm.internal.m.c(vVar);
        K = kotlin.collections.c0.K(vVar.b(), g0Var);
        return K || t0().contains(g0Var) || g0Var.t0().contains(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public kotlin.reflect.y.internal.j0.b.h o() {
        return this.f25301i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public Collection<kotlin.reflect.y.internal.j0.f.c> p(kotlin.reflect.y.internal.j0.f.c cVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        P0();
        return R0().p(cVar, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g0
    public List<kotlin.reflect.jvm.internal.impl.descriptors.g0> t0() {
        v vVar = this.m;
        if (vVar != null) {
            return vVar.c();
        }
        throw new AssertionError("Dependencies of module " + Q0() + " were not set");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.y.internal.j0.b.h hVar, kotlin.reflect.y.internal.j0.g.a aVar, Map<kotlin.reflect.jvm.internal.impl.descriptors.f0<?>, ? extends Object> map, kotlin.reflect.y.internal.j0.f.f fVar2) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), fVar);
        Lazy b2;
        kotlin.jvm.internal.m.f(fVar, "moduleName");
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        kotlin.jvm.internal.m.f(hVar, "builtIns");
        kotlin.jvm.internal.m.f(map, "capabilities");
        this.f25300h = nVar;
        this.f25301i = hVar;
        this.f25302j = fVar2;
        if (fVar.y()) {
            this.f25303k = map;
            a0 a0Var = (a0) I0(a0.a.a());
            this.l = a0Var == null ? a0.b.f25211b : a0Var;
            this.o = true;
            this.p = nVar.h(new b());
            b2 = kotlin.i.b(new a());
            this.q = b2;
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + fVar);
    }
}
