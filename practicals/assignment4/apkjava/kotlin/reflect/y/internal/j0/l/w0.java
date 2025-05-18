package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;

/* compiled from: TypeAliasExpansion.kt */
/* loaded from: classes3.dex */
public final class w0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final w0 f24863b;

    /* renamed from: c, reason: collision with root package name */
    private final d1 f24864c;

    /* renamed from: d, reason: collision with root package name */
    private final List<g1> f24865d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<e1, g1> f24866e;

    /* compiled from: TypeAliasExpansion.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final w0 a(w0 w0Var, d1 d1Var, List<? extends g1> list) {
            int u;
            List L0;
            Map q;
            m.f(d1Var, "typeAliasDescriptor");
            m.f(list, "arguments");
            List<e1> parameters = d1Var.h().getParameters();
            m.e(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            u = v.u(parameters, 10);
            ArrayList arrayList = new ArrayList(u);
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((e1) it.next()).a());
            }
            L0 = c0.L0(arrayList, list);
            q = q0.q(L0);
            return new w0(w0Var, d1Var, list, q, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private w0(w0 w0Var, d1 d1Var, List<? extends g1> list, Map<e1, ? extends g1> map) {
        this.f24863b = w0Var;
        this.f24864c = d1Var;
        this.f24865d = list;
        this.f24866e = map;
    }

    public /* synthetic */ w0(w0 w0Var, d1 d1Var, List list, Map map, g gVar) {
        this(w0Var, d1Var, list, map);
    }

    public final List<g1> a() {
        return this.f24865d;
    }

    public final d1 b() {
        return this.f24864c;
    }

    public final g1 c(e1 e1Var) {
        m.f(e1Var, "constructor");
        h c2 = e1Var.c();
        if (c2 instanceof e1) {
            return this.f24866e.get(c2);
        }
        return null;
    }

    public final boolean d(d1 d1Var) {
        m.f(d1Var, "descriptor");
        if (!m.a(this.f24864c, d1Var)) {
            w0 w0Var = this.f24863b;
            if (!(w0Var != null ? w0Var.d(d1Var) : false)) {
                return false;
            }
        }
        return true;
    }
}
