package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import kotlin.reflect.y.internal.j0.m.c;
import kotlin.reflect.y.internal.j0.m.e;
import kotlin.reflect.y.internal.j0.m.s;

/* compiled from: TypeAttributes.kt */
/* loaded from: classes3.dex */
public final class a1 extends e<y0<?>, y0<?>> implements Iterable<y0<?>>, KMappedMarker {

    /* renamed from: g, reason: collision with root package name */
    public static final a f24676g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final a1 f24677h;

    /* compiled from: TypeAttributes.kt */
    /* loaded from: classes3.dex */
    public static final class a extends s<y0<?>, y0<?>> {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.y.internal.j0.m.s
        public <T extends y0<?>> int b(ConcurrentHashMap<KClass<? extends y0<?>>, Integer> concurrentHashMap, KClass<T> kClass, Function1<? super KClass<? extends y0<?>>, Integer> function1) {
            int intValue;
            m.f(concurrentHashMap, "<this>");
            m.f(kClass, "kClass");
            m.f(function1, "compute");
            Integer num = concurrentHashMap.get(kClass);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                Integer num2 = concurrentHashMap.get(kClass);
                if (num2 == null) {
                    Integer invoke = function1.invoke(kClass);
                    concurrentHashMap.putIfAbsent(kClass, Integer.valueOf(invoke.intValue()));
                    num2 = invoke;
                }
                m.e(num2, "this[kClass] ?: compute(…putIfAbsent(kClass, it) }");
                intValue = num2.intValue();
            }
            return intValue;
        }

        public final a1 g(List<? extends y0<?>> list) {
            m.f(list, "attributes");
            if (list.isEmpty()) {
                return h();
            }
            return new a1(list, null);
        }

        public final a1 h() {
            return a1.f24677h;
        }
    }

    static {
        List j2;
        j2 = u.j();
        f24677h = new a1((List<? extends y0<?>>) j2);
    }

    private a1(List<? extends y0<?>> list) {
        for (y0<?> y0Var : list) {
            h(y0Var.b(), y0Var);
        }
    }

    public /* synthetic */ a1(List list, g gVar) {
        this((List<? extends y0<?>>) list);
    }

    @Override // kotlin.reflect.y.internal.j0.m.a
    protected s<y0<?>, y0<?>> f() {
        return f24676g;
    }

    public final a1 n(a1 a1Var) {
        Object a2;
        m.f(a1Var, "other");
        if (isEmpty() && a1Var.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f24676g.e().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            y0<?> y0Var = c().get(intValue);
            y0<?> y0Var2 = a1Var.c().get(intValue);
            if (y0Var == null) {
                a2 = y0Var2 != null ? y0Var2.a(y0Var) : null;
            } else {
                a2 = y0Var.a(y0Var2);
            }
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, a2);
        }
        return f24676g.g(arrayList);
    }

    public final boolean o(y0<?> y0Var) {
        m.f(y0Var, "attribute");
        return c().get(f24676g.d(y0Var.b())) != null;
    }

    public final a1 q(a1 a1Var) {
        Object c2;
        m.f(a1Var, "other");
        if (isEmpty() && a1Var.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f24676g.e().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            y0<?> y0Var = c().get(intValue);
            y0<?> y0Var2 = a1Var.c().get(intValue);
            if (y0Var == null) {
                c2 = y0Var2 != null ? y0Var2.c(y0Var) : null;
            } else {
                c2 = y0Var.c(y0Var2);
            }
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, c2);
        }
        return f24676g.g(arrayList);
    }

    public final a1 r(y0<?> y0Var) {
        List E0;
        List<? extends y0<?>> p0;
        m.f(y0Var, "attribute");
        if (o(y0Var)) {
            return this;
        }
        if (isEmpty()) {
            return new a1(y0Var);
        }
        E0 = c0.E0(this);
        p0 = c0.p0(E0, y0Var);
        return f24676g.g(p0);
    }

    public final a1 s(y0<?> y0Var) {
        m.f(y0Var, "attribute");
        if (isEmpty()) {
            return this;
        }
        c<y0<?>> c2 = c();
        ArrayList arrayList = new ArrayList();
        for (y0<?> y0Var2 : c2) {
            if (!m.a(y0Var2, y0Var)) {
                arrayList.add(y0Var2);
            }
        }
        return arrayList.size() == c().c() ? this : f24676g.g(arrayList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a1(y0<?> y0Var) {
        this((List<? extends y0<?>>) r1);
        List e2;
        e2 = t.e(y0Var);
    }
}
