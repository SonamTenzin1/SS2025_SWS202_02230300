package kotlin.reflect.y.internal.j0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.h;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* loaded from: classes2.dex */
public final class e implements kotlin.reflect.jvm.internal.impl.descriptors.o1.b {

    /* renamed from: d, reason: collision with root package name */
    private static final f f23257d;

    /* renamed from: e, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.b f23258e;

    /* renamed from: f, reason: collision with root package name */
    private final g0 f23259f;

    /* renamed from: g, reason: collision with root package name */
    private final Function1<g0, m> f23260g;

    /* renamed from: h, reason: collision with root package name */
    private final i f23261h;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23255b = {kotlin.jvm.internal.g0.h(new y(kotlin.jvm.internal.g0.b(e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    public static final b a = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23256c = k.r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<g0, kotlin.reflect.y.internal.j0.b.b> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f23262f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.b.b invoke(g0 g0Var) {
            kotlin.jvm.internal.m.f(g0Var, "module");
            List<k0> I = g0Var.N(e.f23256c).I();
            ArrayList arrayList = new ArrayList();
            for (Object obj : I) {
                if (obj instanceof kotlin.reflect.y.internal.j0.b.b) {
                    arrayList.add(obj);
                }
            }
            return (kotlin.reflect.y.internal.j0.b.b) s.U(arrayList);
        }
    }

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final kotlin.reflect.y.internal.j0.f.b a() {
            return e.f23258e;
        }
    }

    /* compiled from: JvmBuiltInClassDescriptorFactory.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<h> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f23264g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.f23264g = nVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            List e2;
            Set<d> d2;
            m mVar = (m) e.this.f23260g.invoke(e.this.f23259f);
            f fVar = e.f23257d;
            d0 d0Var = d0.ABSTRACT;
            kotlin.reflect.jvm.internal.impl.descriptors.f fVar2 = kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE;
            e2 = t.e(e.this.f23259f.o().i());
            h hVar = new h(mVar, fVar, d0Var, fVar2, e2, z0.a, false, this.f23264g);
            kotlin.reflect.y.internal.j0.b.q.a aVar = new kotlin.reflect.y.internal.j0.b.q.a(this.f23264g, hVar);
            d2 = w0.d();
            hVar.L0(aVar, d2, null);
            return hVar;
        }
    }

    static {
        kotlin.reflect.y.internal.j0.f.d dVar = k.a.f23203d;
        f i2 = dVar.i();
        kotlin.jvm.internal.m.e(i2, "cloneable.shortName()");
        f23257d = i2;
        kotlin.reflect.y.internal.j0.f.b m = kotlin.reflect.y.internal.j0.f.b.m(dVar.l());
        kotlin.jvm.internal.m.e(m, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f23258e = m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(n nVar, g0 g0Var, Function1<? super g0, ? extends m> function1) {
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        kotlin.jvm.internal.m.f(g0Var, "moduleDescriptor");
        kotlin.jvm.internal.m.f(function1, "computeContainingDeclaration");
        this.f23259f = g0Var;
        this.f23260g = function1;
        this.f23261h = nVar.d(new c(nVar));
    }

    private final h i() {
        return (h) kotlin.reflect.y.internal.j0.k.m.a(this.f23261h, this, f23255b[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.b
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> a(kotlin.reflect.y.internal.j0.f.c cVar) {
        Set d2;
        Set c2;
        kotlin.jvm.internal.m.f(cVar, "packageFqName");
        if (kotlin.jvm.internal.m.a(cVar, f23256c)) {
            c2 = v0.c(i());
            return c2;
        }
        d2 = w0.d();
        return d2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.b
    public boolean b(kotlin.reflect.y.internal.j0.f.c cVar, f fVar) {
        kotlin.jvm.internal.m.f(cVar, "packageFqName");
        kotlin.jvm.internal.m.f(fVar, "name");
        return kotlin.jvm.internal.m.a(fVar, f23257d) && kotlin.jvm.internal.m.a(cVar, f23256c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o1.b
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(kotlin.reflect.y.internal.j0.f.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "classId");
        if (kotlin.jvm.internal.m.a(bVar, f23258e)) {
            return i();
        }
        return null;
    }

    public /* synthetic */ e(n nVar, g0 g0Var, Function1 function1, int i2, g gVar) {
        this(nVar, g0Var, (i2 & 4) != 0 ? a.f23262f : function1);
    }
}
