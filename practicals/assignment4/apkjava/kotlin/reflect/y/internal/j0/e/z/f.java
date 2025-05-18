package kotlin.reflect.y.internal.j0.e.z;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.r;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.u;

/* compiled from: protoTypeTableUtil.kt */
/* loaded from: classes3.dex */
public final class f {
    public static final q a(q qVar, g gVar) {
        m.f(qVar, "<this>");
        m.f(gVar, "typeTable");
        if (qVar.k0()) {
            return qVar.R();
        }
        if (qVar.l0()) {
            return gVar.a(qVar.S());
        }
        return null;
    }

    public static final q b(r rVar, g gVar) {
        m.f(rVar, "<this>");
        m.f(gVar, "typeTable");
        if (rVar.e0()) {
            q T = rVar.T();
            m.e(T, "expandedType");
            return T;
        }
        if (rVar.f0()) {
            return gVar.a(rVar.U());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final q c(q qVar, g gVar) {
        m.f(qVar, "<this>");
        m.f(gVar, "typeTable");
        if (qVar.p0()) {
            return qVar.c0();
        }
        if (qVar.q0()) {
            return gVar.a(qVar.d0());
        }
        return null;
    }

    public static final boolean d(i iVar) {
        m.f(iVar, "<this>");
        return iVar.w0() || iVar.x0();
    }

    public static final boolean e(n nVar) {
        m.f(nVar, "<this>");
        return nVar.t0() || nVar.u0();
    }

    public static final q f(c cVar, g gVar) {
        m.f(cVar, "<this>");
        m.f(gVar, "typeTable");
        if (cVar.p1()) {
            return cVar.K0();
        }
        if (cVar.q1()) {
            return gVar.a(cVar.L0());
        }
        return null;
    }

    public static final q g(q qVar, g gVar) {
        m.f(qVar, "<this>");
        m.f(gVar, "typeTable");
        if (qVar.s0()) {
            return qVar.f0();
        }
        if (qVar.t0()) {
            return gVar.a(qVar.g0());
        }
        return null;
    }

    public static final q h(i iVar, g gVar) {
        m.f(iVar, "<this>");
        m.f(gVar, "typeTable");
        if (iVar.w0()) {
            return iVar.g0();
        }
        if (iVar.x0()) {
            return gVar.a(iVar.h0());
        }
        return null;
    }

    public static final q i(n nVar, g gVar) {
        m.f(nVar, "<this>");
        m.f(gVar, "typeTable");
        if (nVar.t0()) {
            return nVar.f0();
        }
        if (nVar.u0()) {
            return gVar.a(nVar.g0());
        }
        return null;
    }

    public static final q j(i iVar, g gVar) {
        m.f(iVar, "<this>");
        m.f(gVar, "typeTable");
        if (iVar.y0()) {
            q i0 = iVar.i0();
            m.e(i0, "returnType");
            return i0;
        }
        if (iVar.z0()) {
            return gVar.a(iVar.j0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final q k(n nVar, g gVar) {
        m.f(nVar, "<this>");
        m.f(gVar, "typeTable");
        if (nVar.v0()) {
            q h0 = nVar.h0();
            m.e(h0, "returnType");
            return h0;
        }
        if (nVar.w0()) {
            return gVar.a(nVar.i0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final List<q> l(c cVar, g gVar) {
        int u;
        m.f(cVar, "<this>");
        m.f(gVar, "typeTable");
        List<q> b1 = cVar.b1();
        if (!(!b1.isEmpty())) {
            b1 = null;
        }
        if (b1 == null) {
            List<Integer> a1 = cVar.a1();
            m.e(a1, "supertypeIdList");
            u = v.u(a1, 10);
            b1 = new ArrayList<>(u);
            for (Integer num : a1) {
                m.e(num, "it");
                b1.add(gVar.a(num.intValue()));
            }
        }
        return b1;
    }

    public static final q m(q.b bVar, g gVar) {
        m.f(bVar, "<this>");
        m.f(gVar, "typeTable");
        if (bVar.B()) {
            return bVar.y();
        }
        if (bVar.C()) {
            return gVar.a(bVar.z());
        }
        return null;
    }

    public static final q n(u uVar, g gVar) {
        m.f(uVar, "<this>");
        m.f(gVar, "typeTable");
        if (uVar.S()) {
            q M = uVar.M();
            m.e(M, "type");
            return M;
        }
        if (uVar.T()) {
            return gVar.a(uVar.N());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final q o(r rVar, g gVar) {
        m.f(rVar, "<this>");
        m.f(gVar, "typeTable");
        if (rVar.i0()) {
            q b0 = rVar.b0();
            m.e(b0, "underlyingType");
            return b0;
        }
        if (rVar.j0()) {
            return gVar.a(rVar.c0());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<q> p(s sVar, g gVar) {
        int u;
        m.f(sVar, "<this>");
        m.f(gVar, "typeTable");
        List<q> S = sVar.S();
        if (!(!S.isEmpty())) {
            S = null;
        }
        if (S == null) {
            List<Integer> R = sVar.R();
            m.e(R, "upperBoundIdList");
            u = v.u(R, 10);
            S = new ArrayList<>(u);
            for (Integer num : R) {
                m.e(num, "it");
                S.add(gVar.a(num.intValue()));
            }
        }
        return S;
    }

    public static final q q(u uVar, g gVar) {
        m.f(uVar, "<this>");
        m.f(gVar, "typeTable");
        if (uVar.U()) {
            return uVar.O();
        }
        if (uVar.V()) {
            return gVar.a(uVar.P());
        }
        return null;
    }
}
