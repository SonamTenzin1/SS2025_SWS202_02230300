package kotlin.reflect.y.internal.j0.d.a.l0.m;

import cm.aptoide.pt.database.room.RoomNotification;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.d.a.j0.k;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.s;

/* compiled from: RawType.kt */
/* loaded from: classes2.dex */
public final class e extends j1 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f23579c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.d.a.l0.m.a f23580d;

    /* renamed from: e, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.d.a.l0.m.a f23581e;

    /* renamed from: f, reason: collision with root package name */
    private final g f23582f;

    /* compiled from: RawType.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* compiled from: RawType.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[kotlin.reflect.y.internal.j0.d.a.l0.m.b.values().length];
            iArr[kotlin.reflect.y.internal.j0.d.a.l0.m.b.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[kotlin.reflect.y.internal.j0.d.a.l0.m.b.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[kotlin.reflect.y.internal.j0.d.a.l0.m.b.INFLEXIBLE.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RawType.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function1<kotlin.reflect.y.internal.j0.l.t1.g, m0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f23583f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f23584g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ m0 f23585h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.m.a f23586i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, e eVar2, m0 m0Var, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
            super(1);
            this.f23583f = eVar;
            this.f23584g = eVar2;
            this.f23585h = m0Var;
            this.f23586i = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            kotlin.reflect.y.internal.j0.f.b g2;
            kotlin.reflect.jvm.internal.impl.descriptors.e b2;
            m.f(gVar, "kotlinTypeRefiner");
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.f23583f;
            if (!(eVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
                eVar = null;
            }
            if (eVar == null || (g2 = kotlin.reflect.y.internal.j0.i.t.a.g(eVar)) == null || (b2 = gVar.b(g2)) == null || m.a(b2, this.f23583f)) {
                return null;
            }
            return (m0) this.f23584g.l(this.f23585h, b2, this.f23586i).c();
        }
    }

    static {
        k kVar = k.COMMON;
        f23580d = d.d(kVar, false, null, 3, null).i(kotlin.reflect.y.internal.j0.d.a.l0.m.b.FLEXIBLE_LOWER_BOUND);
        f23581e = d.d(kVar, false, null, 3, null).i(kotlin.reflect.y.internal.j0.d.a.l0.m.b.FLEXIBLE_UPPER_BOUND);
    }

    public e(g gVar) {
        this.f23582f = gVar == null ? new g(this) : gVar;
    }

    public static /* synthetic */ g1 k(e eVar, e1 e1Var, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, e0 e0Var, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            e0Var = eVar.f23582f.c(e1Var, true, aVar);
            m.e(e0Var, "typeParameterUpperBoundE…eter, isRaw = true, attr)");
        }
        return eVar.j(e1Var, aVar, e0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<m0, Boolean> l(m0 m0Var, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        int u;
        List e2;
        if (m0Var.O0().getParameters().isEmpty()) {
            return s.a(m0Var, Boolean.FALSE);
        }
        if (h.c0(m0Var)) {
            g1 g1Var = m0Var.M0().get(0);
            r1 a2 = g1Var.a();
            e0 type = g1Var.getType();
            m.e(type, "componentTypeProjection.type");
            e2 = t.e(new i1(a2, m(type, aVar)));
            return s.a(f0.i(m0Var.N0(), m0Var.O0(), e2, m0Var.P0(), null, 16, null), Boolean.FALSE);
        }
        if (g0.a(m0Var)) {
            return s.a(kotlin.reflect.y.internal.j0.l.u1.k.d(j.N, m0Var.O0().toString()), Boolean.FALSE);
        }
        kotlin.reflect.y.internal.j0.i.w.h a0 = eVar.a0(this);
        m.e(a0, "declaration.getMemberScope(this)");
        a1 N0 = m0Var.N0();
        kotlin.reflect.y.internal.j0.l.e1 h2 = eVar.h();
        m.e(h2, "declaration.typeConstructor");
        List<e1> parameters = eVar.h().getParameters();
        m.e(parameters, "declaration.typeConstructor.parameters");
        u = v.u(parameters, 10);
        ArrayList arrayList = new ArrayList(u);
        for (e1 e1Var : parameters) {
            m.e(e1Var, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
            arrayList.add(k(this, e1Var, aVar, null, 4, null));
        }
        return s.a(f0.k(N0, h2, arrayList, m0Var.P0(), a0, new c(eVar, this, m0Var, aVar)), Boolean.TRUE);
    }

    private final e0 m(e0 e0Var, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.h w = e0Var.O0().w();
        if (w instanceof e1) {
            e0 c2 = this.f23582f.c((e1) w, true, aVar);
            m.e(c2, "typeParameterUpperBoundE…tion, isRaw = true, attr)");
            return m(c2, aVar);
        }
        if (w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            kotlin.reflect.jvm.internal.impl.descriptors.h w2 = b0.d(e0Var).O0().w();
            if (w2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
                Pair<m0, Boolean> l = l(b0.c(e0Var), (kotlin.reflect.jvm.internal.impl.descriptors.e) w, f23580d);
                m0 a2 = l.a();
                boolean booleanValue = l.b().booleanValue();
                Pair<m0, Boolean> l2 = l(b0.d(e0Var), (kotlin.reflect.jvm.internal.impl.descriptors.e) w2, f23581e);
                m0 a3 = l2.a();
                boolean booleanValue2 = l2.b().booleanValue();
                if (!booleanValue && !booleanValue2) {
                    return f0.d(a2, a3);
                }
                return new f(a2, a3);
            }
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + w2 + "\" while for lower it's \"" + w + '\"').toString());
        }
        throw new IllegalStateException(("Unexpected declaration kind: " + w).toString());
    }

    static /* synthetic */ e0 n(e eVar, e0 e0Var, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = new kotlin.reflect.y.internal.j0.d.a.l0.m.a(k.COMMON, null, false, null, null, 30, null);
        }
        return eVar.m(e0Var, aVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean f() {
        return false;
    }

    public final g1 j(e1 e1Var, kotlin.reflect.y.internal.j0.d.a.l0.m.a aVar, e0 e0Var) {
        m.f(e1Var, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
        m.f(aVar, "attr");
        m.f(e0Var, "erasedUpperBound");
        int i2 = b.a[aVar.d().ordinal()];
        if (i2 == 1) {
            return new i1(r1.INVARIANT, e0Var);
        }
        if (i2 != 2 && i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (!e1Var.n().k()) {
            return new i1(r1.INVARIANT, kotlin.reflect.y.internal.j0.i.t.a.f(e1Var).H());
        }
        m.e(e0Var.O0().getParameters(), "erasedUpperBound.constructor.parameters");
        if (!r0.isEmpty()) {
            return new i1(r1.OUT_VARIANCE, e0Var);
        }
        return d.b(e1Var, aVar);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public i1 e(e0 e0Var) {
        m.f(e0Var, RoomNotification.KEY);
        return new i1(n(this, e0Var, null, 2, null));
    }

    public /* synthetic */ e(g gVar, int i2, g gVar2) {
        this((i2 & 1) != 0 ? null : gVar);
    }
}
