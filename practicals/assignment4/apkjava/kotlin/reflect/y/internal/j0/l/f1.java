package kotlin.reflect.y.internal.j0.l;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;

/* compiled from: TypeSubstitution.kt */
/* loaded from: classes3.dex */
public abstract class f1 extends j1 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f24727c = new a(null);

    /* compiled from: TypeSubstitution.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: TypeSubstitution.kt */
        /* renamed from: kotlin.f0.y.e.j0.l.f1$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0395a extends f1 {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map<e1, g1> f24728d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f24729e;

            /* JADX WARN: Multi-variable type inference failed */
            C0395a(Map<e1, ? extends g1> map, boolean z) {
                this.f24728d = map;
                this.f24729e = z;
            }

            @Override // kotlin.reflect.y.internal.j0.l.j1
            public boolean a() {
                return this.f24729e;
            }

            @Override // kotlin.reflect.y.internal.j0.l.j1
            public boolean f() {
                return this.f24728d.isEmpty();
            }

            @Override // kotlin.reflect.y.internal.j0.l.f1
            public g1 k(e1 e1Var) {
                m.f(e1Var, RoomNotification.KEY);
                return this.f24728d.get(e1Var);
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public static /* synthetic */ f1 e(a aVar, Map map, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return aVar.d(map, z);
        }

        public final j1 a(e0 e0Var) {
            m.f(e0Var, "kotlinType");
            return b(e0Var.O0(), e0Var.M0());
        }

        public final j1 b(e1 e1Var, List<? extends g1> list) {
            int u;
            List L0;
            Map q;
            m.f(e1Var, "typeConstructor");
            m.f(list, "arguments");
            List<e1> parameters = e1Var.getParameters();
            m.e(parameters, "typeConstructor.parameters");
            e1 e1Var2 = (e1) s.i0(parameters);
            if (e1Var2 != null && e1Var2.o0()) {
                List<e1> parameters2 = e1Var.getParameters();
                m.e(parameters2, "typeConstructor.parameters");
                u = v.u(parameters2, 10);
                ArrayList arrayList = new ArrayList(u);
                Iterator<T> it = parameters2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((e1) it.next()).h());
                }
                L0 = c0.L0(arrayList, list);
                q = q0.q(L0);
                return e(this, q, false, 2, null);
            }
            return new c0(parameters, list);
        }

        public final f1 c(Map<e1, ? extends g1> map) {
            m.f(map, "map");
            return e(this, map, false, 2, null);
        }

        public final f1 d(Map<e1, ? extends g1> map, boolean z) {
            m.f(map, "map");
            return new C0395a(map, z);
        }
    }

    public static final j1 i(e1 e1Var, List<? extends g1> list) {
        return f24727c.b(e1Var, list);
    }

    public static final f1 j(Map<e1, ? extends g1> map) {
        return f24727c.c(map);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public g1 e(e0 e0Var) {
        m.f(e0Var, RoomNotification.KEY);
        return k(e0Var.O0());
    }

    public abstract g1 k(e1 e1Var);
}
