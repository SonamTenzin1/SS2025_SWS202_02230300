package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.i.r.n;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.d0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.p;
import kotlin.reflect.y.internal.j0.l.q0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.u0;

/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
public final class w {
    public static final w a = new w();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: IntersectionType.kt */
    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: f, reason: collision with root package name */
        public static final a f24808f = new c("START", 0);

        /* renamed from: g, reason: collision with root package name */
        public static final a f24809g = new C0398a("ACCEPT_NULL", 1);

        /* renamed from: h, reason: collision with root package name */
        public static final a f24810h = new d("UNKNOWN", 2);

        /* renamed from: i, reason: collision with root package name */
        public static final a f24811i = new b("NOT_NULL", 3);

        /* renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f24812j = g();

        /* compiled from: IntersectionType.kt */
        /* renamed from: kotlin.f0.y.e.j0.l.t1.w$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0398a extends a {
            C0398a(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            public a k(q1 q1Var) {
                m.f(q1Var, "nextType");
                return q(q1Var);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: classes3.dex */
        static final class b extends a {
            b(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b k(q1 q1Var) {
                m.f(q1Var, "nextType");
                return this;
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: classes3.dex */
        static final class c extends a {
            c(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            public a k(q1 q1Var) {
                m.f(q1Var, "nextType");
                return q(q1Var);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: classes3.dex */
        static final class d extends a {
            d(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.f0.y.e.j0.l.t1.w.a
            public a k(q1 q1Var) {
                m.f(q1Var, "nextType");
                a q = q(q1Var);
                return q == a.f24809g ? this : q;
            }
        }

        private a(String str, int i2) {
        }

        public /* synthetic */ a(String str, int i2, g gVar) {
            this(str, i2);
        }

        private static final /* synthetic */ a[] g() {
            return new a[]{f24808f, f24809g, f24810h, f24811i};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f24812j.clone();
        }

        public abstract a k(q1 q1Var);

        protected final a q(q1 q1Var) {
            m.f(q1Var, "<this>");
            return q1Var.P0() ? f24809g : ((q1Var instanceof p) && (((p) q1Var).a1() instanceof u0)) ? f24811i : q1Var instanceof u0 ? f24810h : o.a.a(q1Var) ? f24811i : f24810h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionType.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function0<String> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Set<m0> f24813f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Set<? extends m0> set) {
            super(0);
            this.f24813f = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String e0;
            StringBuilder sb = new StringBuilder();
            sb.append("This collections cannot be empty! input types: ");
            e0 = c0.e0(this.f24813f, null, null, null, 0, null, null, 63, null);
            sb.append(e0);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionType.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class c extends i implements Function2<e0, e0, Boolean> {
        c(Object obj) {
            super(2, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "isStrictSupertype";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(w.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(e0 e0Var, e0 e0Var2) {
            m.f(e0Var, "p0");
            m.f(e0Var2, "p1");
            return Boolean.valueOf(((w) this.receiver).e(e0Var, e0Var2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionType.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class d extends i implements Function2<e0, e0, Boolean> {
        d(Object obj) {
            super(2, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "equalTypes";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(m.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(e0 e0Var, e0 e0Var2) {
            m.f(e0Var, "p0");
            m.f(e0Var2, "p1");
            return Boolean.valueOf(((m) this.receiver).b(e0Var, e0Var2));
        }
    }

    private w() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[EDGE_INSN: B:23:0x0051->B:7:0x0051 BREAK  A[LOOP:1: B:14:0x0028->B:24:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:1: B:14:0x0028->B:24:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Collection<m0> b(Collection<? extends m0> collection, Function2<? super m0, ? super m0, Boolean> function2) {
        boolean z;
        ArrayList<m0> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        m.e(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            m0 m0Var = (m0) it.next();
            boolean z2 = true;
            if (!arrayList.isEmpty()) {
                for (m0 m0Var2 : arrayList) {
                    if (m0Var2 != m0Var) {
                        m.e(m0Var2, "lower");
                        m.e(m0Var, "upper");
                        if (function2.invoke(m0Var2, m0Var).booleanValue()) {
                            z = true;
                            if (!z) {
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            z2 = false;
            if (z2) {
                it.remove();
            }
        }
        return arrayList;
    }

    private final m0 d(Set<? extends m0> set) {
        if (set.size() == 1) {
            return (m0) s.r0(set);
        }
        new b(set);
        Collection<m0> b2 = b(set, new c(this));
        b2.isEmpty();
        m0 b3 = n.a.b(b2);
        if (b3 != null) {
            return b3;
        }
        Collection<m0> b4 = b(b2, new d(l.f24802b.a()));
        b4.isEmpty();
        return b4.size() < 2 ? (m0) s.r0(b4) : new d0(set).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(e0 e0Var, e0 e0Var2) {
        m a2 = l.f24802b.a();
        return a2.d(e0Var, e0Var2) && !a2.d(e0Var2, e0Var);
    }

    public final m0 c(List<? extends m0> list) {
        int u;
        int u2;
        m.f(list, "types");
        list.size();
        ArrayList<m0> arrayList = new ArrayList();
        for (m0 m0Var : list) {
            if (m0Var.O0() instanceof d0) {
                Collection<e0> a2 = m0Var.O0().a();
                m.e(a2, "type.constructor.supertypes");
                u2 = v.u(a2, 10);
                ArrayList arrayList2 = new ArrayList(u2);
                for (e0 e0Var : a2) {
                    m.e(e0Var, "it");
                    m0 d2 = b0.d(e0Var);
                    if (m0Var.P0()) {
                        d2 = d2.S0(true);
                    }
                    arrayList2.add(d2);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(m0Var);
            }
        }
        a aVar = a.f24808f;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVar = aVar.k((q1) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (m0 m0Var2 : arrayList) {
            if (aVar == a.f24811i) {
                if (m0Var2 instanceof i) {
                    m0Var2 = q0.k((i) m0Var2);
                }
                m0Var2 = q0.i(m0Var2, false, 1, null);
            }
            linkedHashSet.add(m0Var2);
        }
        u = v.u(list, 10);
        ArrayList arrayList3 = new ArrayList(u);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((m0) it2.next()).N0());
        }
        Iterator it3 = arrayList3.iterator();
        if (it3.hasNext()) {
            Object next = it3.next();
            while (it3.hasNext()) {
                next = ((a1) next).q((a1) it3.next());
            }
            return d(linkedHashSet).U0((a1) next);
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
