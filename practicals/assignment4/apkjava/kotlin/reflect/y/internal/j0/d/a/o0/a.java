package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.q;
import kotlin.reflect.y.internal.j0.d.a.x;
import kotlin.reflect.y.internal.j0.l.w1.g;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.o;
import kotlin.reflect.y.internal.j0.l.w1.p;
import kotlin.reflect.y.internal.j0.l.w1.u;

/* compiled from: AbstractSignatureParts.kt */
/* loaded from: classes3.dex */
public abstract class a<TAnnotation> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractSignatureParts.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.a.o0.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0337a {
        private final i a;

        /* renamed from: b, reason: collision with root package name */
        private final x f23602b;

        /* renamed from: c, reason: collision with root package name */
        private final o f23603c;

        public C0337a(i iVar, x xVar, o oVar) {
            this.a = iVar;
            this.f23602b = xVar;
            this.f23603c = oVar;
        }

        public final x a() {
            return this.f23602b;
        }

        public final i b() {
            return this.a;
        }

        public final o c() {
            return this.f23603c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractSignatureParts.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Integer, e> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ q f23604f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e[] f23605g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(q qVar, e[] eVarArr) {
            super(1);
            this.f23604f = qVar;
            this.f23605g = eVarArr;
        }

        public final e b(int i2) {
            int A;
            Map<Integer, e> a;
            e eVar;
            q qVar = this.f23604f;
            if (qVar != null && (a = qVar.a()) != null && (eVar = a.get(Integer.valueOf(i2))) != null) {
                return eVar;
            }
            e[] eVarArr = this.f23605g;
            if (i2 >= 0) {
                A = n.A(eVarArr);
                if (i2 <= A) {
                    return eVarArr[i2];
                }
            }
            return e.a.a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ e invoke(Integer num) {
            return b(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractSignatureParts.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<TAnnotation, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<TAnnotation> f23606f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a<TAnnotation> aVar) {
            super(1);
            this.f23606f = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(TAnnotation tannotation) {
            m.f(tannotation, "$this$extractNullability");
            return Boolean.valueOf(this.f23606f.r(tannotation));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractSignatureParts.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<C0337a, Iterable<? extends C0337a>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<TAnnotation> f23607f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f23608g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(a<TAnnotation> aVar, p pVar) {
            super(1);
            this.f23607f = aVar;
            this.f23608g = pVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<C0337a> invoke(C0337a c0337a) {
            kotlin.reflect.y.internal.j0.l.w1.n w;
            List<o> e0;
            int u;
            int u2;
            C0337a c0337a2;
            g M;
            m.f(c0337a, "it");
            if (this.f23607f.u()) {
                i b2 = c0337a.b();
                if (((b2 == null || (M = this.f23608g.M(b2)) == null) ? null : this.f23608g.y(M)) != null) {
                    return null;
                }
            }
            i b3 = c0337a.b();
            if (b3 == null || (w = this.f23608g.w(b3)) == null || (e0 = this.f23608g.e0(w)) == null) {
                return null;
            }
            List<kotlin.reflect.y.internal.j0.l.w1.m> X = this.f23608g.X(c0337a.b());
            p pVar = this.f23608g;
            a<TAnnotation> aVar = this.f23607f;
            Iterator<T> it = e0.iterator();
            Iterator<T> it2 = X.iterator();
            u = v.u(e0, 10);
            u2 = v.u(X, 10);
            ArrayList arrayList = new ArrayList(Math.min(u, u2));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                kotlin.reflect.y.internal.j0.l.w1.m mVar = (kotlin.reflect.y.internal.j0.l.w1.m) it2.next();
                o oVar = (o) next;
                if (pVar.L(mVar)) {
                    c0337a2 = new C0337a(null, c0337a.a(), oVar);
                } else {
                    i x0 = pVar.x0(mVar);
                    c0337a2 = new C0337a(x0, aVar.c(x0, c0337a.a()), oVar);
                }
                arrayList.add(c0337a2);
            }
            return arrayList;
        }
    }

    private final i B(i iVar, i iVar2) {
        return iVar == null ? iVar2 : iVar2 == null ? iVar : (!iVar.d() || iVar2.d()) ? (iVar.d() || !iVar2.d()) ? (iVar.c().compareTo(iVar2.c()) >= 0 && iVar.c().compareTo(iVar2.c()) > 0) ? iVar : iVar2 : iVar : iVar2;
    }

    private final List<C0337a> C(i iVar) {
        return f(new C0337a(iVar, c(iVar, m()), null), new d(this, v()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x c(i iVar, x xVar) {
        return h().c(xVar, i(iVar));
    }

    private final e d(i iVar) {
        h hVar;
        h t = t(iVar);
        f fVar = null;
        if (t == null) {
            i p = p(iVar);
            hVar = p != null ? t(p) : null;
        } else {
            hVar = t;
        }
        p v = v();
        kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
        if (cVar.l(s(v.h0(iVar)))) {
            fVar = f.READ_ONLY;
        } else if (cVar.k(s(v.T(iVar)))) {
            fVar = f.MUTABLE;
        }
        return new e(hVar, fVar, v().C(iVar) || A(iVar), hVar != t);
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x012a, code lost:
    
        if ((r0 != null && r0.c()) != false) goto L93;
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final e e(C0337a c0337a) {
        Iterable<? extends TAnnotation> j2;
        kotlin.reflect.y.internal.j0.d.a.b l;
        i d2;
        boolean z;
        o c2;
        i iVar;
        kotlin.reflect.y.internal.j0.l.w1.n w;
        if (c0337a.b() == null) {
            p v = v();
            o c3 = c0337a.c();
            if ((c3 != null ? v.N(c3) : null) == u.IN) {
                return e.a.a();
            }
        }
        boolean z2 = c0337a.c() == null;
        i b2 = c0337a.b();
        if (b2 == null || (j2 = i(b2)) == null) {
            j2 = kotlin.collections.u.j();
        }
        p v2 = v();
        i b3 = c0337a.b();
        o F = (b3 == null || (w = v2.w(b3)) == null) ? null : v2.F(w);
        boolean z3 = l() == kotlin.reflect.y.internal.j0.d.a.b.TYPE_PARAMETER_BOUNDS;
        if (z2) {
            if (!z3 && o()) {
                i b4 = c0337a.b();
                if (b4 != null && w(b4)) {
                    Iterable<TAnnotation> k2 = k();
                    ArrayList arrayList = new ArrayList();
                    for (TAnnotation tannotation : k2) {
                        if (!h().m(tannotation)) {
                            arrayList.add(tannotation);
                        }
                    }
                    j2 = c0.o0(arrayList, j2);
                }
            }
            j2 = c0.m0(k(), j2);
        }
        f e2 = h().e(j2);
        i f2 = h().f(j2, new c(this));
        if (f2 != null) {
            return new e(f2.c(), e2, f2.c() == h.NOT_NULL && F != null, f2.d());
        }
        if (!z2 && !z3) {
            l = kotlin.reflect.y.internal.j0.d.a.b.TYPE_USE;
        } else {
            l = l();
        }
        x a = c0337a.a();
        q a2 = a != null ? a.a(l) : null;
        i j3 = F != null ? j(F) : null;
        if (j3 == null || (d2 = i.b(j3, h.NOT_NULL, false, 2, null)) == null) {
            d2 = a2 != null ? a2.d() : null;
        }
        if ((j3 != null ? j3.c() : null) != h.NOT_NULL) {
            if (F != null) {
            }
            z = false;
            c2 = c0337a.c();
            if (c2 != null || (iVar = j(c2)) == null) {
                iVar = null;
            } else if (iVar.c() == h.NULLABLE) {
                iVar = i.b(iVar, h.FORCE_FLEXIBILITY, false, 2, null);
            }
            i B = B(iVar, d2);
            return new e(B != null ? B.c() : null, e2, z, B == null && B.d());
        }
        z = true;
        c2 = c0337a.c();
        if (c2 != null) {
        }
        iVar = null;
        i B2 = B(iVar, d2);
        return new e(B2 != null ? B2.c() : null, e2, z, B2 == null && B2.d());
    }

    private final <T> List<T> f(T t, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        ArrayList arrayList = new ArrayList(1);
        g(t, arrayList, function1);
        return arrayList;
    }

    private final <T> void g(T t, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t);
        Iterable<? extends T> invoke = function1.invoke(t);
        if (invoke != null) {
            Iterator<? extends T> it = invoke.iterator();
            while (it.hasNext()) {
                g(it.next(), list, function1);
            }
        }
    }

    private final i j(o oVar) {
        boolean z;
        boolean z2;
        boolean z3;
        List<i> arrayList;
        boolean z4;
        p v = v();
        i iVar = null;
        if (!z(oVar)) {
            return null;
        }
        List<i> B0 = v.B0(oVar);
        boolean z5 = B0 instanceof Collection;
        if (!z5 || !B0.isEmpty()) {
            Iterator<T> it = B0.iterator();
            while (it.hasNext()) {
                if (!v.Y((i) it.next())) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return null;
        }
        if (!z5 || !B0.isEmpty()) {
            Iterator<T> it2 = B0.iterator();
            while (it2.hasNext()) {
                if (t((i) it2.next()) != null) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (!z2) {
            if (!z5 || !B0.isEmpty()) {
                Iterator<T> it3 = B0.iterator();
                while (it3.hasNext()) {
                    if (p((i) it3.next()) != null) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (z3) {
                arrayList = new ArrayList<>();
                Iterator<T> it4 = B0.iterator();
                while (it4.hasNext()) {
                    i p = p((i) it4.next());
                    if (p != null) {
                        arrayList.add(p);
                    }
                }
            }
            return iVar;
        }
        arrayList = B0;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                if (!v.p0((i) it5.next())) {
                    z4 = false;
                    break;
                }
            }
        }
        z4 = true;
        iVar = new i(z4 ? h.NULLABLE : h.NOT_NULL, arrayList != B0);
        return iVar;
    }

    private final h t(i iVar) {
        p v = v();
        if (v.W(v.h0(iVar))) {
            return h.NULLABLE;
        }
        if (v.W(v.T(iVar))) {
            return null;
        }
        return h.NOT_NULL;
    }

    public abstract boolean A(i iVar);

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:
    
        if (r10 != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Function1<Integer, e> b(i iVar, Iterable<? extends i> iterable, q qVar, boolean z) {
        int u;
        boolean z2;
        int size;
        int i2;
        i b2;
        boolean z3;
        m.f(iVar, "<this>");
        m.f(iterable, "overrides");
        List<C0337a> C = C(iVar);
        u = v.u(iterable, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<? extends i> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(C(it.next()));
        }
        if (!q()) {
            if (x()) {
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator<? extends i> it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        if (!y(iVar, it2.next())) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
            }
            z2 = false;
            size = !z2 ? 1 : C.size();
            e[] eVarArr = new e[size];
            i2 = 0;
            while (i2 < size) {
                e e2 = e(C.get(i2));
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    C0337a c0337a = (C0337a) s.X((List) it3.next(), i2);
                    e d2 = (c0337a == null || (b2 = c0337a.b()) == null) ? null : d(b2);
                    if (d2 != null) {
                        arrayList2.add(d2);
                    }
                }
                eVarArr[i2] = s.a(e2, arrayList2, i2 == 0 && x(), i2 == 0 && n(), z);
                i2++;
            }
            return new b(qVar, eVarArr);
        }
        z2 = true;
        if (!z2) {
        }
        e[] eVarArr2 = new e[size];
        i2 = 0;
        while (i2 < size) {
        }
        return new b(qVar, eVarArr2);
    }

    public abstract kotlin.reflect.y.internal.j0.d.a.a<TAnnotation> h();

    public abstract Iterable<TAnnotation> i(i iVar);

    public abstract Iterable<TAnnotation> k();

    public abstract kotlin.reflect.y.internal.j0.d.a.b l();

    public abstract x m();

    public abstract boolean n();

    public abstract boolean o();

    public abstract i p(i iVar);

    public boolean q() {
        return false;
    }

    public abstract boolean r(TAnnotation tannotation);

    public abstract kotlin.reflect.y.internal.j0.f.d s(i iVar);

    public abstract boolean u();

    public abstract p v();

    public abstract boolean w(i iVar);

    public abstract boolean x();

    public abstract boolean y(i iVar, i iVar2);

    public abstract boolean z(o oVar);
}
