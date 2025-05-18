package kotlin.reflect.y.internal.j0.m;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.m.k;
import kotlin.reflect.y.internal.j0.m.r;
import kotlin.reflect.y.internal.j0.m.t;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public final class p extends kotlin.reflect.y.internal.j0.m.b {
    public static final p a = new p();

    /* renamed from: b, reason: collision with root package name */
    private static final List<h> f24913b;

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<y, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f24914f = new a();

        a() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
        
            if ((!kotlin.reflect.y.internal.j0.i.t.a.a(r4) && r4.l0() == null) == true) goto L13;
         */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String invoke(y yVar) {
            m.f(yVar, "$this$$receiver");
            List<i1> f2 = yVar.f();
            m.e(f2, "valueParameters");
            i1 i1Var = (i1) s.i0(f2);
            boolean z = true;
            if (i1Var != null) {
            }
            z = false;
            p pVar = p.a;
            if (z) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<y, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f24915f = new b();

        b() {
            super(1);
        }

        private static final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            return (mVar instanceof e) && h.a0((e) mVar);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(y yVar) {
            boolean z;
            m.f(yVar, "$this$$receiver");
            p pVar = p.a;
            kotlin.reflect.jvm.internal.impl.descriptors.m b2 = yVar.b();
            m.e(b2, "containingDeclaration");
            boolean z2 = true;
            if (!c(b2)) {
                Collection<? extends y> e2 = yVar.e();
                m.e(e2, "overriddenDescriptors");
                if (!e2.isEmpty()) {
                    Iterator<T> it = e2.iterator();
                    while (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.m b3 = ((y) it.next()).b();
                        m.e(b3, "it.containingDeclaration");
                        if (c(b3)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    z2 = false;
                }
            }
            if (z2) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<y, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f24916f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(y yVar) {
            boolean z;
            m.f(yVar, "$this$$receiver");
            w0 f0 = yVar.f0();
            if (f0 == null) {
                f0 = yVar.m0();
            }
            p pVar = p.a;
            boolean z2 = false;
            if (f0 != null) {
                e0 returnType = yVar.getReturnType();
                if (returnType != null) {
                    e0 type = f0.getType();
                    m.e(type, "receiver.type");
                    z = kotlin.reflect.y.internal.j0.l.x1.a.o(returnType, type);
                } else {
                    z = false;
                }
                if (z || pVar.d(yVar, f0)) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        List m;
        List<h> m2;
        f fVar = q.f24926k;
        k.b bVar = k.b.f24907b;
        f[] fVarArr = {bVar, new t.a(1)};
        f fVar2 = q.l;
        f[] fVarArr2 = {bVar, new t.a(2)};
        f fVar3 = q.f24917b;
        m mVar = m.a;
        j jVar = j.a;
        f fVar4 = q.f24923h;
        t.d dVar = t.d.f24940b;
        r.a aVar = r.a.f24929d;
        f fVar5 = q.f24925j;
        t.c cVar = t.c.f24939b;
        m = u.m(q.x, q.y);
        m2 = u.m(new h(fVar, fVarArr, (Function1) null, 4, (g) null), new h(fVar2, fVarArr2, a.f24914f), new h(fVar3, new f[]{bVar, mVar, new t.a(2), jVar}, (Function1) null, 4, (g) null), new h(q.f24918c, new f[]{bVar, mVar, new t.a(3), jVar}, (Function1) null, 4, (g) null), new h(q.f24919d, new f[]{bVar, mVar, new t.b(2), jVar}, (Function1) null, 4, (g) null), new h(q.f24924i, new f[]{bVar}, (Function1) null, 4, (g) null), new h(fVar4, new f[]{bVar, dVar, mVar, aVar}, (Function1) null, 4, (g) null), new h(fVar5, new f[]{bVar, cVar}, (Function1) null, 4, (g) null), new h(q.m, new f[]{bVar, cVar}, (Function1) null, 4, (g) null), new h(q.n, new f[]{bVar, cVar, aVar}, (Function1) null, 4, (g) null), new h(q.I, new f[]{bVar, dVar, mVar}, (Function1) null, 4, (g) null), new h(q.f24920e, new f[]{k.a.f24906b}, b.f24915f), new h(q.f24922g, new f[]{bVar, r.b.f24931d, dVar, mVar}, (Function1) null, 4, (g) null), new h(q.R, new f[]{bVar, dVar, mVar}, (Function1) null, 4, (g) null), new h(q.Q, new f[]{bVar, cVar}, (Function1) null, 4, (g) null), new h(m, new f[]{bVar}, c.f24916f), new h(q.S, new f[]{bVar, r.c.f24933d, dVar, mVar}, (Function1) null, 4, (g) null), new h(q.p, new f[]{bVar, cVar}, (Function1) null, 4, (g) null));
        f24913b = m2;
    }

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(y yVar, w0 w0Var) {
        kotlin.reflect.y.internal.j0.f.b g2;
        e0 returnType;
        kotlin.reflect.y.internal.j0.i.w.o.f value = w0Var.getValue();
        m.e(value, "receiver.value");
        if (!(value instanceof kotlin.reflect.y.internal.j0.i.w.o.e)) {
            return false;
        }
        e r = ((kotlin.reflect.y.internal.j0.i.w.o.e) value).r();
        if (!r.M() || (g2 = kotlin.reflect.y.internal.j0.i.t.a.g(r)) == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h b2 = x.b(kotlin.reflect.y.internal.j0.i.t.a.l(r), g2);
        if (!(b2 instanceof d1)) {
            b2 = null;
        }
        d1 d1Var = (d1) b2;
        if (d1Var == null || (returnType = yVar.getReturnType()) == null) {
            return false;
        }
        return kotlin.reflect.y.internal.j0.l.x1.a.o(returnType, d1Var.W());
    }

    @Override // kotlin.reflect.y.internal.j0.m.b
    public List<h> b() {
        return f24913b;
    }
}
