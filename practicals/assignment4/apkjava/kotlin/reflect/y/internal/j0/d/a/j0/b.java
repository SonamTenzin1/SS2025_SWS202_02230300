package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.Collection;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.d.a.k0.g;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.l.m0;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes2.dex */
public class b implements c, g {
    static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.b(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f23406b;

    /* renamed from: c, reason: collision with root package name */
    private final z0 f23407c;

    /* renamed from: d, reason: collision with root package name */
    private final i f23408d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.a.n0.b f23409e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f23410f;

    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<m0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23411f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f23412g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, b bVar) {
            super(0);
            this.f23411f = gVar;
            this.f23412g = bVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke() {
            m0 s = this.f23411f.d().o().o(this.f23412g.d()).s();
            m.e(s, "c.module.builtIns.getBui…qName(fqName).defaultType");
            return s;
        }
    }

    public b(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.reflect.y.internal.j0.d.a.n0.a aVar, kotlin.reflect.y.internal.j0.f.c cVar) {
        z0 z0Var;
        Collection<kotlin.reflect.y.internal.j0.d.a.n0.b> b2;
        m.f(gVar, "c");
        m.f(cVar, "fqName");
        this.f23406b = cVar;
        if (aVar == null || (z0Var = gVar.a().t().a(aVar)) == null) {
            z0Var = z0.a;
            m.e(z0Var, "NO_SOURCE");
        }
        this.f23407c = z0Var;
        this.f23408d = gVar.e().d(new a(gVar, this));
        this.f23409e = (aVar == null || (b2 = aVar.b()) == null) ? null : (kotlin.reflect.y.internal.j0.d.a.n0.b) s.V(b2);
        this.f23410f = aVar != null && aVar.g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public Map<f, kotlin.reflect.y.internal.j0.i.r.g<?>> a() {
        Map<f, kotlin.reflect.y.internal.j0.i.r.g<?>> i2;
        i2 = q0.i();
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final kotlin.reflect.y.internal.j0.d.a.n0.b b() {
        return this.f23409e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m0 getType() {
        return (m0) kotlin.reflect.y.internal.j0.k.m.a(this.f23408d, this, a[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public kotlin.reflect.y.internal.j0.f.c d() {
        return this.f23406b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.k0.g
    public boolean g() {
        return this.f23410f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public z0 t() {
        return this.f23407c;
    }
}
