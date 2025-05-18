package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: SchemaUtil.java */
/* loaded from: classes.dex */
final class h1 {
    private static final Class<?> a = B();

    /* renamed from: b, reason: collision with root package name */
    private static final l1<?, ?> f1311b = C(false);

    /* renamed from: c, reason: collision with root package name */
    private static final l1<?, ?> f1312c = C(true);

    /* renamed from: d, reason: collision with root package name */
    private static final l1<?, ?> f1313d = new n1();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB A(int i2, List<Integer> list, a0.e eVar, UB ub, l1<UT, UB> l1Var) {
        if (eVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (eVar.a(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) L(i2, intValue, ub, l1Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.a(intValue2)) {
                    ub = (UB) L(i2, intValue2, ub, l1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> B() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static l1<?, ?> C(boolean z) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (l1) D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends u.b<FT>> void E(q<FT> qVar, T t, T t2) {
        u<FT> c2 = qVar.c(t2);
        if (c2.n()) {
            return;
        }
        qVar.d(t).u(c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void F(l0 l0Var, T t, T t2, long j2) {
        p1.O(t, j2, l0Var.a(p1.A(t, j2), p1.A(t2, j2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void G(l1<UT, UB> l1Var, T t, T t2) {
        l1Var.p(t, l1Var.k(l1Var.g(t), l1Var.g(t2)));
    }

    public static l1<?, ?> H() {
        return f1311b;
    }

    public static l1<?, ?> I() {
        return f1312c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!y.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB L(int i2, int i3, UB ub, l1<UT, UB> l1Var) {
        if (ub == null) {
            ub = l1Var.n();
        }
        l1Var.e(ub, i2, i3);
        return ub;
    }

    public static l1<?, ?> M() {
        return f1313d;
    }

    public static void N(int i2, List<Boolean> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.A(i2, list, z);
    }

    public static void O(int i2, List<h> list, s1 s1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.N(i2, list);
    }

    public static void P(int i2, List<Double> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.K(i2, list, z);
    }

    public static void Q(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.J(i2, list, z);
    }

    public static void R(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.y(i2, list, z);
    }

    public static void S(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.u(i2, list, z);
    }

    public static void T(int i2, List<Float> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.a(i2, list, z);
    }

    public static void U(int i2, List<?> list, s1 s1Var, f1 f1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.l(i2, list, f1Var);
    }

    public static void V(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.o(i2, list, z);
    }

    public static void W(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.I(i2, list, z);
    }

    public static void X(int i2, List<?> list, s1 s1Var, f1 f1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.j(i2, list, f1Var);
    }

    public static void Y(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.v(i2, list, z);
    }

    public static void Z(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.f(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(size);
        }
        return size * CodedOutputStream.d(i2, true);
    }

    public static void a0(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.G(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.C(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, List<h> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int V = size * CodedOutputStream.V(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            V += CodedOutputStream.h(list.get(i3));
        }
        return V;
    }

    public static void c0(int i2, List<String> list, s1 s1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.k(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = e(list);
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(e2);
        }
        return e2 + (size * CodedOutputStream.V(i2));
    }

    public static void d0(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.B(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.l(zVar.q(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.l(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void e0(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.g(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(size * 4);
        }
        return size * CodedOutputStream.m(i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(size * 8);
        }
        return size * CodedOutputStream.o(i2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i2, List<q0> list, f1 f1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += CodedOutputStream.s(i2, list.get(i4), f1Var);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = l(list);
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(l);
        }
        return l + (size * CodedOutputStream.V(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.w(zVar.q(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.w(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int n = n(list);
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(n);
        }
        return n + (list.size() * CodedOutputStream.V(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.y(h0Var.q(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.y(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i2, Object obj, f1 f1Var) {
        if (obj instanceof d0) {
            return CodedOutputStream.A(i2, (d0) obj);
        }
        return CodedOutputStream.F(i2, (q0) obj, f1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i2, List<?> list, f1 f1Var) {
        int H;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int V = CodedOutputStream.V(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof d0) {
                H = CodedOutputStream.B((d0) obj);
            } else {
                H = CodedOutputStream.H((q0) obj, f1Var);
            }
            V += H;
        }
        return V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r = r(list);
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(r);
        }
        return r + (size * CodedOutputStream.V(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.Q(zVar.q(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.Q(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t = t(list);
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(t);
        }
        return t + (size * CodedOutputStream.V(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.S(h0Var.q(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.S(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i2, List<?> list) {
        int U;
        int U2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int V = CodedOutputStream.V(i2) * size;
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            while (i3 < size) {
                Object c1 = f0Var.c1(i3);
                if (c1 instanceof h) {
                    U2 = CodedOutputStream.h((h) c1);
                } else {
                    U2 = CodedOutputStream.U((String) c1);
                }
                V += U2;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof h) {
                    U = CodedOutputStream.h((h) obj);
                } else {
                    U = CodedOutputStream.U((String) obj);
                }
                V += U;
                i3++;
            }
        }
        return V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w = w(list);
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(w);
        }
        return w + (size * CodedOutputStream.V(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.X(zVar.q(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.X(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = y(list);
        if (z) {
            return CodedOutputStream.V(i2) + CodedOutputStream.C(y);
        }
        return y + (size * CodedOutputStream.V(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.Z(h0Var.q(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += CodedOutputStream.Z(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB z(int i2, List<Integer> list, a0.d<?> dVar, UB ub, l1<UT, UB> l1Var) {
        if (dVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (dVar.a(intValue) != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) L(i2, intValue, ub, l1Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (dVar.a(intValue2) == null) {
                    ub = (UB) L(i2, intValue2, ub, l1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
