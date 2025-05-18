package kotlin.reflect.y.internal.j0.j.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.p;
import kotlin.reflect.y.internal.j0.l.r0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.s0;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.y0;
import kotlin.reflect.y.internal.j0.l.z0;
import kotlin.sequences.Sequence;
import kotlin.sequences.l;
import kotlin.sequences.n;
import okhttp3.HttpUrl;

/* compiled from: TypeDeserializer.kt */
/* loaded from: classes3.dex */
public final class d0 {
    private final m a;

    /* renamed from: b */
    private final d0 f24475b;

    /* renamed from: c */
    private final String f24476c;

    /* renamed from: d */
    private final String f24477d;

    /* renamed from: e */
    private final Function1<Integer, h> f24478e;

    /* renamed from: f */
    private final Function1<Integer, h> f24479f;

    /* renamed from: g */
    private final Map<Integer, e1> f24480g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Integer, h> {
        a() {
            super(1);
        }

        public final h b(int i2) {
            return d0.this.d(i2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ h invoke(Integer num) {
            return b(num.intValue());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function0<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c>> {

        /* renamed from: g */
        final /* synthetic */ q f24483g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(q qVar) {
            super(0);
            this.f24483g = qVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c> invoke() {
            return d0.this.a.c().d().d(this.f24483g, d0.this.a.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<Integer, h> {
        c() {
            super(1);
        }

        public final h b(int i2) {
            return d0.this.f(i2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ h invoke(Integer num) {
            return b(num.intValue());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class d extends i implements Function1<kotlin.reflect.y.internal.j0.f.b, kotlin.reflect.y.internal.j0.f.b> {

        /* renamed from: h */
        public static final d f24485h = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(kotlin.reflect.y.internal.j0.f.b.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u */
        public final kotlin.reflect.y.internal.j0.f.b invoke(kotlin.reflect.y.internal.j0.f.b bVar) {
            m.f(bVar, "p0");
            return bVar.g();
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<q, q> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final q invoke(q qVar) {
            m.f(qVar, "it");
            return kotlin.reflect.y.internal.j0.e.z.f.g(qVar, d0.this.a.j());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class f extends Lambda implements Function1<q, Integer> {

        /* renamed from: f */
        public static final f f24487f = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Integer invoke(q qVar) {
            m.f(qVar, "it");
            return Integer.valueOf(qVar.U());
        }
    }

    public d0(m mVar, d0 d0Var, List<s> list, String str, String str2) {
        Map<Integer, e1> linkedHashMap;
        m.f(mVar, "c");
        m.f(list, "typeParameterProtos");
        m.f(str, "debugName");
        m.f(str2, "containerPresentableName");
        this.a = mVar;
        this.f24475b = d0Var;
        this.f24476c = str;
        this.f24477d = str2;
        this.f24478e = mVar.h().i(new a());
        this.f24479f = mVar.h().i(new c());
        if (list.isEmpty()) {
            linkedHashMap = q0.i();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            for (s sVar : list) {
                linkedHashMap.put(Integer.valueOf(sVar.M()), new kotlin.reflect.y.internal.j0.j.b.g0.m(this.a, sVar, i2));
                i2++;
            }
        }
        this.f24480g = linkedHashMap;
    }

    public final h d(int i2) {
        kotlin.reflect.y.internal.j0.f.b a2 = x.a(this.a.g(), i2);
        if (a2.k()) {
            return this.a.c().b(a2);
        }
        return x.b(this.a.c().p(), a2);
    }

    private final m0 e(int i2) {
        if (x.a(this.a.g(), i2).k()) {
            return this.a.c().n().a();
        }
        return null;
    }

    public final h f(int i2) {
        kotlin.reflect.y.internal.j0.f.b a2 = x.a(this.a.g(), i2);
        if (a2.k()) {
            return null;
        }
        return x.d(this.a.c().p(), a2);
    }

    private final m0 g(e0 e0Var, e0 e0Var2) {
        List N;
        int u;
        kotlin.reflect.y.internal.j0.b.h h2 = kotlin.reflect.y.internal.j0.l.x1.a.h(e0Var);
        g annotations = e0Var.getAnnotations();
        e0 j2 = kotlin.reflect.y.internal.j0.b.g.j(e0Var);
        List<e0> e2 = kotlin.reflect.y.internal.j0.b.g.e(e0Var);
        N = c0.N(kotlin.reflect.y.internal.j0.b.g.l(e0Var), 1);
        u = v.u(N, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator it = N.iterator();
        while (it.hasNext()) {
            arrayList.add(((g1) it.next()).getType());
        }
        return kotlin.reflect.y.internal.j0.b.g.b(h2, annotations, j2, e2, arrayList, null, e0Var2, true).S0(e0Var.P0());
    }

    private final m0 h(a1 a1Var, kotlin.reflect.y.internal.j0.l.e1 e1Var, List<? extends g1> list, boolean z) {
        int size;
        int size2 = e1Var.getParameters().size() - list.size();
        m0 m0Var = null;
        if (size2 == 0) {
            m0Var = i(a1Var, e1Var, list, z);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            kotlin.reflect.y.internal.j0.l.e1 h2 = e1Var.o().X(size).h();
            m.e(h2, "functionTypeConstructor.…on(arity).typeConstructor");
            m0Var = f0.i(a1Var, h2, list, z, null, 16, null);
        }
        return m0Var == null ? k.a.f(j.S, list, e1Var, new String[0]) : m0Var;
    }

    private final m0 i(a1 a1Var, kotlin.reflect.y.internal.j0.l.e1 e1Var, List<? extends g1> list, boolean z) {
        m0 i2 = f0.i(a1Var, e1Var, list, z, null, 16, null);
        if (kotlin.reflect.y.internal.j0.b.g.p(i2)) {
            return p(i2);
        }
        return null;
    }

    private final e1 k(int i2) {
        e1 e1Var = this.f24480g.get(Integer.valueOf(i2));
        if (e1Var != null) {
            return e1Var;
        }
        d0 d0Var = this.f24475b;
        if (d0Var != null) {
            return d0Var.k(i2);
        }
        return null;
    }

    private static final List<q.b> m(q qVar, d0 d0Var) {
        List<q.b> o0;
        List<q.b> V = qVar.V();
        m.e(V, "argumentList");
        q g2 = kotlin.reflect.y.internal.j0.e.z.f.g(qVar, d0Var.a.j());
        List<q.b> m = g2 != null ? m(g2, d0Var) : null;
        if (m == null) {
            m = u.j();
        }
        o0 = c0.o0(V, m);
        return o0;
    }

    public static /* synthetic */ m0 n(d0 d0Var, q qVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return d0Var.l(qVar, z);
    }

    private final a1 o(List<? extends z0> list, g gVar, kotlin.reflect.y.internal.j0.l.e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        int u;
        List<? extends y0<?>> w;
        u = v.u(list, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((z0) it.next()).a(gVar, e1Var, mVar));
        }
        w = v.w(arrayList);
        return a1.f24676g.g(w);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (kotlin.jvm.internal.m.a(r2, r3) == false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final m0 p(e0 e0Var) {
        e0 type;
        kotlin.reflect.y.internal.j0.f.c cVar;
        g1 g1Var = (g1) kotlin.collections.s.i0(kotlin.reflect.y.internal.j0.b.g.l(e0Var));
        if (g1Var == null || (type = g1Var.getType()) == null) {
            return null;
        }
        h w = type.O0().w();
        kotlin.reflect.y.internal.j0.f.c h2 = w != null ? kotlin.reflect.y.internal.j0.i.t.a.h(w) : null;
        if (type.M0().size() == 1) {
            if (!m.a(h2, kotlin.reflect.y.internal.j0.b.k.m)) {
                cVar = e0.a;
            }
            e0 type2 = ((g1) kotlin.collections.s.s0(type.M0())).getType();
            m.e(type2, "continuationArgumentType.arguments.single().type");
            kotlin.reflect.jvm.internal.impl.descriptors.m e2 = this.a.e();
            if (!(e2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
                e2 = null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) e2;
            if (m.a(aVar != null ? kotlin.reflect.y.internal.j0.i.t.a.d(aVar) : null, c0.a)) {
                return g(e0Var, type2);
            }
            return g(e0Var, type2);
        }
        return (m0) e0Var;
    }

    private final g1 r(e1 e1Var, q.b bVar) {
        if (bVar.x() == q.b.c.STAR) {
            if (e1Var == null) {
                return new r0(this.a.c().p().o());
            }
            return new s0(e1Var);
        }
        a0 a0Var = a0.a;
        q.b.c x = bVar.x();
        m.e(x, "typeArgumentProto.projection");
        r1 c2 = a0Var.c(x);
        q m = kotlin.reflect.y.internal.j0.e.z.f.m(bVar, this.a.j());
        if (m == null) {
            return new i1(k.d(j.C0, bVar.toString()));
        }
        return new i1(c2, q(m));
    }

    private final kotlin.reflect.y.internal.j0.l.e1 s(q qVar) {
        h invoke;
        Object obj;
        if (qVar.m0()) {
            invoke = this.f24478e.invoke(Integer.valueOf(qVar.X()));
            if (invoke == null) {
                invoke = t(this, qVar, qVar.X());
            }
        } else if (qVar.v0()) {
            invoke = k(qVar.i0());
            if (invoke == null) {
                return k.a.e(j.Q, String.valueOf(qVar.i0()), this.f24477d);
            }
        } else if (qVar.w0()) {
            String string = this.a.g().getString(qVar.j0());
            Iterator<T> it = j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (m.a(((e1) obj).getName().k(), string)) {
                    break;
                }
            }
            invoke = (e1) obj;
            if (invoke == null) {
                return k.a.e(j.R, string, this.a.e().toString());
            }
        } else if (qVar.u0()) {
            invoke = this.f24479f.invoke(Integer.valueOf(qVar.h0()));
            if (invoke == null) {
                invoke = t(this, qVar, qVar.h0());
            }
        } else {
            return k.a.e(j.U, new String[0]);
        }
        kotlin.reflect.y.internal.j0.l.e1 h2 = invoke.h();
        m.e(h2, "classifier.typeConstructor");
        return h2;
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.e t(d0 d0Var, q qVar, int i2) {
        Sequence f2;
        Sequence u;
        List<Integer> B;
        Sequence f3;
        int j2;
        kotlin.reflect.y.internal.j0.f.b a2 = x.a(d0Var.a.g(), i2);
        f2 = l.f(qVar, new e());
        u = n.u(f2, f.f24487f);
        B = n.B(u);
        f3 = l.f(a2, d.f24485h);
        j2 = n.j(f3);
        while (B.size() < j2) {
            B.add(0);
        }
        return d0Var.a.c().q().d(a2, B);
    }

    public final List<e1> j() {
        List<e1> E0;
        E0 = c0.E0(this.f24480g.values());
        return E0;
    }

    public final m0 l(q qVar, boolean z) {
        m0 e2;
        int u;
        List<? extends g1> E0;
        m0 i2;
        m0 j2;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c> m0;
        m.f(qVar, "proto");
        if (qVar.m0()) {
            e2 = e(qVar.X());
        } else {
            e2 = qVar.u0() ? e(qVar.h0()) : null;
        }
        if (e2 != null) {
            return e2;
        }
        kotlin.reflect.y.internal.j0.l.e1 s = s(qVar);
        boolean z2 = true;
        if (k.m(s.w())) {
            return k.a.c(j.x0, s, s.toString());
        }
        kotlin.reflect.y.internal.j0.j.b.g0.a aVar = new kotlin.reflect.y.internal.j0.j.b.g0.a(this.a.h(), new b(qVar));
        a1 o = o(this.a.c().v(), aVar, s, this.a.e());
        List<q.b> m = m(qVar, this);
        u = v.u(m, 10);
        ArrayList arrayList = new ArrayList(u);
        int i3 = 0;
        for (Object obj : m) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                u.t();
            }
            List<e1> parameters = s.getParameters();
            m.e(parameters, "constructor.parameters");
            arrayList.add(r((e1) kotlin.collections.s.X(parameters, i3), (q.b) obj));
            i3 = i4;
        }
        E0 = c0.E0(arrayList);
        h w = s.w();
        if (z && (w instanceof d1)) {
            f0 f0Var = f0.a;
            m0 b2 = f0.b((d1) w, E0);
            List<z0> v = this.a.c().v();
            g.a aVar2 = g.f25179c;
            m0 = c0.m0(aVar, b2.getAnnotations());
            a1 o2 = o(v, aVar2.a(m0), s, this.a.e());
            if (!kotlin.reflect.y.internal.j0.l.g0.b(b2) && !qVar.e0()) {
                z2 = false;
            }
            i2 = b2.S0(z2).U0(o2);
        } else {
            Boolean d2 = kotlin.reflect.y.internal.j0.e.z.b.a.d(qVar.a0());
            m.e(d2, "SUSPEND_TYPE.get(proto.flags)");
            if (d2.booleanValue()) {
                i2 = h(o, s, E0, qVar.e0());
            } else {
                i2 = f0.i(o, s, E0, qVar.e0(), null, 16, null);
                Boolean d3 = kotlin.reflect.y.internal.j0.e.z.b.f24182b.d(qVar.a0());
                m.e(d3, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (d3.booleanValue()) {
                    p c2 = p.a.c(p.f24771g, i2, false, 2, null);
                    if (c2 == null) {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + i2 + '\'').toString());
                    }
                    i2 = c2;
                }
            }
        }
        q a2 = kotlin.reflect.y.internal.j0.e.z.f.a(qVar, this.a.j());
        if (a2 != null && (j2 = kotlin.reflect.y.internal.j0.l.q0.j(i2, l(a2, false))) != null) {
            i2 = j2;
        }
        return qVar.m0() ? this.a.c().t().a(x.a(this.a.g(), qVar.X()), i2) : i2;
    }

    public final e0 q(q qVar) {
        m.f(qVar, "proto");
        if (qVar.o0()) {
            String string = this.a.g().getString(qVar.b0());
            m0 n = n(this, qVar, false, 2, null);
            q c2 = kotlin.reflect.y.internal.j0.e.z.f.c(qVar, this.a.j());
            m.c(c2);
            return this.a.c().l().a(qVar, string, n, n(this, c2, false, 2, null));
        }
        return l(qVar, true);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24476c);
        if (this.f24475b == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = ". Child of " + this.f24475b.f24476c;
        }
        sb.append(str);
        return sb.toString();
    }
}
