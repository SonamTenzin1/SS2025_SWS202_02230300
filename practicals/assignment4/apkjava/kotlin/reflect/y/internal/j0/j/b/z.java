package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.e.z.g;

/* compiled from: ProtoContainer.kt */
/* loaded from: classes3.dex */
public abstract class z {
    private final c a;

    /* renamed from: b, reason: collision with root package name */
    private final g f24638b;

    /* renamed from: c, reason: collision with root package name */
    private final z0 f24639c;

    /* compiled from: ProtoContainer.kt */
    /* loaded from: classes3.dex */
    public static final class a extends z {

        /* renamed from: d, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.e.c f24640d;

        /* renamed from: e, reason: collision with root package name */
        private final a f24641e;

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.f.b f24642f;

        /* renamed from: g, reason: collision with root package name */
        private final c.EnumC0365c f24643g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f24644h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kotlin.reflect.y.internal.j0.e.c cVar, kotlin.reflect.y.internal.j0.e.z.c cVar2, g gVar, z0 z0Var, a aVar) {
            super(cVar2, gVar, z0Var, null);
            m.f(cVar, "classProto");
            m.f(cVar2, "nameResolver");
            m.f(gVar, "typeTable");
            this.f24640d = cVar;
            this.f24641e = aVar;
            this.f24642f = x.a(cVar2, cVar.F0());
            c.EnumC0365c d2 = kotlin.reflect.y.internal.j0.e.z.b.f24186f.d(cVar.E0());
            this.f24643g = d2 == null ? c.EnumC0365c.CLASS : d2;
            Boolean d3 = kotlin.reflect.y.internal.j0.e.z.b.f24187g.d(cVar.E0());
            m.e(d3, "IS_INNER.get(classProto.flags)");
            this.f24644h = d3.booleanValue();
        }

        @Override // kotlin.reflect.y.internal.j0.j.b.z
        public kotlin.reflect.y.internal.j0.f.c a() {
            kotlin.reflect.y.internal.j0.f.c b2 = this.f24642f.b();
            m.e(b2, "classId.asSingleFqName()");
            return b2;
        }

        public final kotlin.reflect.y.internal.j0.f.b e() {
            return this.f24642f;
        }

        public final kotlin.reflect.y.internal.j0.e.c f() {
            return this.f24640d;
        }

        public final c.EnumC0365c g() {
            return this.f24643g;
        }

        public final a h() {
            return this.f24641e;
        }

        public final boolean i() {
            return this.f24644h;
        }
    }

    /* compiled from: ProtoContainer.kt */
    /* loaded from: classes3.dex */
    public static final class b extends z {

        /* renamed from: d, reason: collision with root package name */
        private final kotlin.reflect.y.internal.j0.f.c f24645d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlin.reflect.y.internal.j0.f.c cVar, kotlin.reflect.y.internal.j0.e.z.c cVar2, g gVar, z0 z0Var) {
            super(cVar2, gVar, z0Var, null);
            m.f(cVar, "fqName");
            m.f(cVar2, "nameResolver");
            m.f(gVar, "typeTable");
            this.f24645d = cVar;
        }

        @Override // kotlin.reflect.y.internal.j0.j.b.z
        public kotlin.reflect.y.internal.j0.f.c a() {
            return this.f24645d;
        }
    }

    private z(kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, z0 z0Var) {
        this.a = cVar;
        this.f24638b = gVar;
        this.f24639c = z0Var;
    }

    public /* synthetic */ z(kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, z0 z0Var, kotlin.jvm.internal.g gVar2) {
        this(cVar, gVar, z0Var);
    }

    public abstract kotlin.reflect.y.internal.j0.f.c a();

    public final kotlin.reflect.y.internal.j0.e.z.c b() {
        return this.a;
    }

    public final z0 c() {
        return this.f24639c;
    }

    public final g d() {
        return this.f24638b;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }
}
