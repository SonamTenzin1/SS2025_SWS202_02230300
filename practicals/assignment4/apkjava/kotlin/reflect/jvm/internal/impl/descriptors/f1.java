package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: typeParameterUtils.kt */
/* loaded from: classes2.dex */
public final class f1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: typeParameterUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f25141f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar) {
            kotlin.jvm.internal.m.f(mVar, "it");
            return Boolean.valueOf(mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: typeParameterUtils.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f25142f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar) {
            kotlin.jvm.internal.m.f(mVar, "it");
            return Boolean.valueOf(!(mVar instanceof l));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: typeParameterUtils.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function1<m, Sequence<? extends e1>> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f25143f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Sequence<e1> invoke(m mVar) {
            Sequence<e1> J;
            kotlin.jvm.internal.m.f(mVar, "it");
            List<e1> typeParameters = ((kotlin.reflect.jvm.internal.impl.descriptors.a) mVar).getTypeParameters();
            kotlin.jvm.internal.m.e(typeParameters, "it as CallableDescriptor).typeParameters");
            J = kotlin.collections.c0.J(typeParameters);
            return J;
        }
    }

    public static final r0 a(kotlin.reflect.y.internal.j0.l.e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "<this>");
        h w = e0Var.O0().w();
        return b(e0Var, w instanceof i ? (i) w : null, 0);
    }

    private static final r0 b(kotlin.reflect.y.internal.j0.l.e0 e0Var, i iVar, int i2) {
        if (iVar == null || kotlin.reflect.y.internal.j0.l.u1.k.m(iVar)) {
            return null;
        }
        int size = iVar.w().size() + i2;
        if (!iVar.m()) {
            if (size != e0Var.M0().size()) {
                kotlin.reflect.y.internal.j0.i.d.E(iVar);
            }
            return new r0(iVar, e0Var.M0().subList(i2, e0Var.M0().size()), null);
        }
        List<kotlin.reflect.y.internal.j0.l.g1> subList = e0Var.M0().subList(i2, size);
        m b2 = iVar.b();
        return new r0(iVar, subList, b(e0Var, b2 instanceof i ? (i) b2 : null, size));
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.c c(e1 e1Var, m mVar, int i2) {
        return new kotlin.reflect.jvm.internal.impl.descriptors.c(e1Var, mVar, i2);
    }

    public static final List<e1> d(i iVar) {
        Sequence y;
        Sequence l;
        Sequence p;
        List A;
        List<e1> list;
        m mVar;
        List<e1> o0;
        int u;
        List<e1> o02;
        kotlin.reflect.y.internal.j0.l.e1 h2;
        kotlin.jvm.internal.m.f(iVar, "<this>");
        List<e1> w = iVar.w();
        kotlin.jvm.internal.m.e(w, "declaredTypeParameters");
        if (!iVar.m() && !(iVar.b() instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            return w;
        }
        y = kotlin.sequences.n.y(kotlin.reflect.y.internal.j0.i.t.a.m(iVar), a.f25141f);
        l = kotlin.sequences.n.l(y, b.f25142f);
        p = kotlin.sequences.n.p(l, c.f25143f);
        A = kotlin.sequences.n.A(p);
        Iterator<m> it = kotlin.reflect.y.internal.j0.i.t.a.m(iVar).iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                mVar = null;
                break;
            }
            mVar = it.next();
            if (mVar instanceof e) {
                break;
            }
        }
        e eVar = (e) mVar;
        if (eVar != null && (h2 = eVar.h()) != null) {
            list = h2.getParameters();
        }
        if (list == null) {
            list = kotlin.collections.u.j();
        }
        if (A.isEmpty() && list.isEmpty()) {
            List<e1> w2 = iVar.w();
            kotlin.jvm.internal.m.e(w2, "declaredTypeParameters");
            return w2;
        }
        o0 = kotlin.collections.c0.o0(A, list);
        u = kotlin.collections.v.u(o0, 10);
        ArrayList arrayList = new ArrayList(u);
        for (e1 e1Var : o0) {
            kotlin.jvm.internal.m.e(e1Var, "it");
            arrayList.add(c(e1Var, iVar, w.size()));
        }
        o02 = kotlin.collections.c0.o0(w, arrayList);
        return o02;
    }
}
