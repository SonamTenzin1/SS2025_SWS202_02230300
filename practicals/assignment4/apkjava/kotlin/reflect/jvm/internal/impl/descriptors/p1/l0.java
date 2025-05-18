package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.l1;

/* compiled from: ValueParameterDescriptorImpl.kt */
/* loaded from: classes2.dex */
public class l0 extends m0 implements i1 {

    /* renamed from: k, reason: collision with root package name */
    public static final a f25249k = new a(null);
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final kotlin.reflect.y.internal.j0.l.e0 p;
    private final i1 q;

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final l0 a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, boolean z, boolean z2, boolean z3, kotlin.reflect.y.internal.j0.l.e0 e0Var2, z0 z0Var, Function0<? extends List<? extends j1>> function0) {
            kotlin.jvm.internal.m.f(aVar, "containingDeclaration");
            kotlin.jvm.internal.m.f(gVar, "annotations");
            kotlin.jvm.internal.m.f(fVar, "name");
            kotlin.jvm.internal.m.f(e0Var, "outType");
            kotlin.jvm.internal.m.f(z0Var, "source");
            if (function0 == null) {
                return new l0(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var);
            }
            return new b(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var, function0);
        }
    }

    /* compiled from: ValueParameterDescriptorImpl.kt */
    /* loaded from: classes2.dex */
    public static final class b extends l0 {
        private final Lazy r;

        /* compiled from: ValueParameterDescriptorImpl.kt */
        /* loaded from: classes2.dex */
        static final class a extends Lambda implements Function0<List<? extends j1>> {
            a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends j1> invoke() {
                return b.this.O0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, boolean z, boolean z2, boolean z3, kotlin.reflect.y.internal.j0.l.e0 e0Var2, z0 z0Var, Function0<? extends List<? extends j1>> function0) {
            super(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var);
            Lazy b2;
            kotlin.jvm.internal.m.f(aVar, "containingDeclaration");
            kotlin.jvm.internal.m.f(gVar, "annotations");
            kotlin.jvm.internal.m.f(fVar, "name");
            kotlin.jvm.internal.m.f(e0Var, "outType");
            kotlin.jvm.internal.m.f(z0Var, "source");
            kotlin.jvm.internal.m.f(function0, "destructuringVariables");
            b2 = kotlin.i.b(function0);
            this.r = b2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.l0, kotlin.reflect.jvm.internal.impl.descriptors.i1
        public i1 G0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.y.internal.j0.f.f fVar, int i2) {
            kotlin.jvm.internal.m.f(aVar, "newOwner");
            kotlin.jvm.internal.m.f(fVar, "newName");
            kotlin.reflect.jvm.internal.impl.descriptors.n1.g annotations = getAnnotations();
            kotlin.jvm.internal.m.e(annotations, "annotations");
            kotlin.reflect.y.internal.j0.l.e0 type = getType();
            kotlin.jvm.internal.m.e(type, "type");
            boolean u0 = u0();
            boolean b0 = b0();
            boolean Y = Y();
            kotlin.reflect.y.internal.j0.l.e0 l0 = l0();
            z0 z0Var = z0.a;
            kotlin.jvm.internal.m.e(z0Var, "NO_SOURCE");
            return new b(aVar, null, i2, annotations, fVar, type, u0, b0, Y, l0, z0Var, new a());
        }

        public final List<j1> O0() {
            return (List) this.r.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, boolean z, boolean z2, boolean z3, kotlin.reflect.y.internal.j0.l.e0 e0Var2, z0 z0Var) {
        super(aVar, gVar, fVar, e0Var, z0Var);
        kotlin.jvm.internal.m.f(aVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(gVar, "annotations");
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(e0Var, "outType");
        kotlin.jvm.internal.m.f(z0Var, "source");
        this.l = i2;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = e0Var2;
        this.q = i1Var == null ? this : i1Var;
    }

    public static final l0 L0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, i1 i1Var, int i2, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, boolean z, boolean z2, boolean z3, kotlin.reflect.y.internal.j0.l.e0 e0Var2, z0 z0Var, Function0<? extends List<? extends j1>> function0) {
        return f25249k.a(aVar, i1Var, i2, gVar, fVar, e0Var, z, z2, z3, e0Var2, z0Var, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public i1 G0(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.y.internal.j0.f.f fVar, int i2) {
        kotlin.jvm.internal.m.f(aVar, "newOwner");
        kotlin.jvm.internal.m.f(fVar, "newName");
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g annotations = getAnnotations();
        kotlin.jvm.internal.m.e(annotations, "annotations");
        kotlin.reflect.y.internal.j0.l.e0 type = getType();
        kotlin.jvm.internal.m.e(type, "type");
        boolean u0 = u0();
        boolean b0 = b0();
        boolean Y = Y();
        kotlin.reflect.y.internal.j0.l.e0 l0 = l0();
        z0 z0Var = z0.a;
        kotlin.jvm.internal.m.e(z0Var, "NO_SOURCE");
        return new l0(aVar, null, i2, annotations, fVar, type, u0, b0, Y, l0, z0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        kotlin.jvm.internal.m.f(oVar, "visitor");
        return oVar.k(this, d2);
    }

    public Void M0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b1
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public i1 c(l1 l1Var) {
        kotlin.jvm.internal.m.f(l1Var, "substitutor");
        if (l1Var.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public /* bridge */ /* synthetic */ kotlin.reflect.y.internal.j0.i.r.g X() {
        return (kotlin.reflect.y.internal.j0.i.r.g) M0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public boolean Y() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public boolean b0() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<i1> e() {
        int u;
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> e2 = b().e();
        kotlin.jvm.internal.m.e(e2, "containingDeclaration.overriddenDescriptors");
        u = kotlin.collections.v.u(e2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = e2.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.a) it.next()).f().get(g()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public int g() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.jvm.internal.impl.descriptors.t.f25369f;
        kotlin.jvm.internal.m.e(uVar, "LOCAL");
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean j0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public kotlin.reflect.y.internal.j0.l.e0 l0() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1
    public boolean u0() {
        if (this.m) {
            kotlin.reflect.jvm.internal.impl.descriptors.a b2 = b();
            kotlin.jvm.internal.m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            if (((kotlin.reflect.jvm.internal.impl.descriptors.b) b2).i().g()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.a b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = super.b();
        kotlin.jvm.internal.m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.a) b2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.p1.j, kotlin.reflect.jvm.internal.impl.descriptors.m
    public i1 a() {
        i1 i1Var = this.q;
        return i1Var == this ? this : i1Var.a();
    }
}
