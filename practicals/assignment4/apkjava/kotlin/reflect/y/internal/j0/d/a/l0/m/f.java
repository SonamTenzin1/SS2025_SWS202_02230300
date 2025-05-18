package kotlin.reflect.y.internal.j0.d.a.l0.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.l0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.t1.e;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.y;
import kotlin.text.v;

/* compiled from: RawType.kt */
/* loaded from: classes2.dex */
public final class f extends y implements l0 {

    /* compiled from: RawType.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function1<String, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f23587f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            m.f(str, "it");
            return "(raw) " + str;
        }
    }

    private f(m0 m0Var, m0 m0Var2, boolean z) {
        super(m0Var, m0Var2);
        if (z) {
            return;
        }
        e.a.d(m0Var, m0Var2);
    }

    private static final boolean b1(String str, String str2) {
        String m0;
        m0 = v.m0(str2, "out ");
        return m.a(str, m0) || m.a(str2, "*");
    }

    private static final List<String> c1(c cVar, e0 e0Var) {
        int u;
        List<g1> M0 = e0Var.M0();
        u = kotlin.collections.v.u(M0, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = M0.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.x((g1) it.next()));
        }
        return arrayList;
    }

    private static final String d1(String str, String str2) {
        boolean I;
        String L0;
        String I0;
        I = v.I(str, '<', false, 2, null);
        if (!I) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        L0 = v.L0(str, '<', null, 2, null);
        sb.append(L0);
        sb.append('<');
        sb.append(str2);
        sb.append('>');
        I0 = v.I0(str, '>', null, 2, null);
        sb.append(I0);
        return sb.toString();
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public m0 V0() {
        return W0();
    }

    @Override // kotlin.reflect.y.internal.j0.l.y
    public String Y0(c cVar, kotlin.reflect.y.internal.j0.h.f fVar) {
        String e0;
        List L0;
        m.f(cVar, "renderer");
        m.f(fVar, "options");
        String w = cVar.w(W0());
        String w2 = cVar.w(X0());
        if (fVar.n()) {
            return "raw (" + w + ".." + w2 + ')';
        }
        if (X0().M0().isEmpty()) {
            return cVar.t(w, w2, kotlin.reflect.y.internal.j0.l.x1.a.h(this));
        }
        List<String> c1 = c1(cVar, W0());
        List<String> c12 = c1(cVar, X0());
        e0 = c0.e0(c1, ", ", null, null, 0, null, a.f23587f, 30, null);
        L0 = c0.L0(c1, c12);
        boolean z = true;
        if (!(L0 instanceof Collection) || !L0.isEmpty()) {
            Iterator it = L0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair pair = (Pair) it.next();
                if (!b1((String) pair.c(), (String) pair.d())) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            w2 = d1(w2, e0);
        }
        String d1 = d1(w, e0);
        return m.a(d1, w2) ? d1 : cVar.t(d1, w2, kotlin.reflect.y.internal.j0.l.x1.a.h(this));
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public f S0(boolean z) {
        return new f(W0().S0(z), X0().S0(z));
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public y Y0(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        e0 a2 = gVar.a(W0());
        m.d(a2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        e0 a3 = gVar.a(X0());
        m.d(a3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new f((m0) a2, (m0) a3, true);
    }

    @Override // kotlin.reflect.y.internal.j0.l.q1
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public f U0(a1 a1Var) {
        m.f(a1Var, "newAttributes");
        return new f(W0().U0(a1Var), X0().U0(a1Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.y.internal.j0.l.y, kotlin.reflect.y.internal.j0.l.e0
    public h q() {
        kotlin.reflect.jvm.internal.impl.descriptors.h w = O0().w();
        g gVar = null;
        Object[] objArr = 0;
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) w : null;
        if (eVar != null) {
            h a0 = eVar.a0(new e(gVar, 1, objArr == true ? 1 : 0));
            m.e(a0, "classDescriptor.getMemberScope(RawSubstitution())");
            return a0;
        }
        throw new IllegalStateException(("Incorrect classifier: " + O0().w()).toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(m0 m0Var, m0 m0Var2) {
        this(m0Var, m0Var2, false);
        m.f(m0Var, "lowerBound");
        m.f(m0Var2, "upperBound");
    }
}
