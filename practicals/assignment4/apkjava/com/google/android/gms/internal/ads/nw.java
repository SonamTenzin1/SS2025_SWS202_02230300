package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class nw {
    private static final Class<?> a = t();

    /* renamed from: b, reason: collision with root package name */
    private static final cx<?, ?> f13064b = y(false);

    /* renamed from: c, reason: collision with root package name */
    private static final cx<?, ?> f13065c = y(true);

    /* renamed from: d, reason: collision with root package name */
    private static final cx<?, ?> f13066d = new dx();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(int i2, List<?> list) {
        int r0;
        int r02;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int h0 = zzdni.h0(i2) * size;
        if (list instanceof zzdot) {
            zzdot zzdotVar = (zzdot) list;
            while (i3 < size) {
                Object k1 = zzdotVar.k1(i3);
                if (k1 instanceof zzdmr) {
                    r02 = zzdni.Q((zzdmr) k1);
                } else {
                    r02 = zzdni.r0((String) k1);
                }
                h0 += r02;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof zzdmr) {
                    r0 = zzdni.Q((zzdmr) obj);
                } else {
                    r0 = zzdni.r0((String) obj);
                }
                h0 += r0;
                i3++;
            }
        }
        return h0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B(int i2, List<?> list, lw lwVar) {
        int A;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h0 = zzdni.h0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzdor) {
                A = zzdni.e((zzdor) obj);
            } else {
                A = zzdni.A((zzdpk) obj, lwVar);
            }
            h0 += A;
        }
        return h0;
    }

    public static void C(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.l(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i2, List<zzdmr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h0 = size * zzdni.h0(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            h0 += zzdni.Q(list.get(i3));
        }
        return h0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(int i2, List<zzdpk> list, lw lwVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzdni.L(i2, list.get(i4), lwVar);
        }
        return i3;
    }

    public static void F(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.u(i2, list, z);
    }

    public static void G(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.t(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean H(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void I(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.s(i2, list, z);
    }

    public static void J(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.m(i2, list, z);
    }

    public static void K(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.j(i2, list, z);
    }

    public static void L(Class<?> cls) {
        Class<?> cls2;
        if (!zzdob.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void M(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.o(i2, list, z);
    }

    public static void N(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.v(i2, list, z);
    }

    public static void O(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.n(i2, list, z);
    }

    public static void P(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.p(i2, list, z);
    }

    public static void Q(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.k(i2, list, z);
    }

    public static void R(int i2, List<Boolean> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.i(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int S(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return c0(list) + (list.size() * zzdni.h0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int T(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d0(list) + (size * zzdni.h0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int U(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i(list) + (size * zzdni.h0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int V(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzdni.h0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int W(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return k(list) + (size * zzdni.h0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int X(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return l(list) + (size * zzdni.h0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Y(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m(list) + (size * zzdni.h0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Z(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.r(i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB a(int i2, int i3, UB ub, cx<UT, UB> cxVar) {
        if (ub == null) {
            ub = cxVar.m();
        }
        cxVar.a(ub, i2, i3);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.F0(i2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB b(int i2, List<Integer> list, zzdog zzdogVar, UB ub, cx<UT, UB> cxVar) {
        if (zzdogVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (zzdogVar.a(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) a(i2, intValue, ub, cxVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzdogVar.a(intValue2)) {
                    ub = (UB) a(i2, intValue2, ub, cxVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.w0(i2, true);
    }

    public static void c(int i2, List<String> list, ux uxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.A(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c0(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ov) {
            ov ovVar = (ov) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.V(ovVar.f(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.V(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void d(int i2, List<?> list, ux uxVar, lw lwVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.W(i2, list, lwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d0(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ov) {
            ov ovVar = (ov) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.W(ovVar.f(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.W(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void e(int i2, List<Double> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.w(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends zzdnu<FT>> void f(vu<FT> vuVar, T t, T t2) {
        yu<FT> i2 = vuVar.i(t2);
        if (i2.b()) {
            return;
        }
        vuVar.j(t).h(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void g(uv uvVar, T t, T t2, long j2) {
        gx.g(t, j2, uvVar.a(gx.L(t, j2), gx.L(t2, j2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void h(cx<UT, UB> cxVar, T t, T t2) {
        cxVar.q(t, cxVar.s(cxVar.j(t), cxVar.j(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ov) {
            ov ovVar = (ov) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.X(ovVar.f(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.X(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.n0(gvVar.f(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.n0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.i0(gvVar.f(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.i0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.j0(gvVar.f(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.j0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.k0(gvVar.f(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzdni.k0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List<?> list) {
        return list.size() << 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(List<?> list) {
        return list.size() << 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(List<?> list) {
        return list.size();
    }

    public static cx<?, ?> q() {
        return f13064b;
    }

    public static cx<?, ?> r() {
        return f13065c;
    }

    public static cx<?, ?> s() {
        return f13066d;
    }

    private static Class<?> t() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> u() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void v(int i2, List<zzdmr> list, ux uxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.x(i2, list);
    }

    public static void w(int i2, List<?> list, ux uxVar, lw lwVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.S(i2, list, lwVar);
    }

    public static void x(int i2, List<Float> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.z(i2, list, z);
    }

    private static cx<?, ?> y(boolean z) {
        try {
            Class<?> u = u();
            if (u == null) {
                return null;
            }
            return (cx) u.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(int i2, Object obj, lw lwVar) {
        if (obj instanceof zzdor) {
            return zzdni.d(i2, (zzdor) obj);
        }
        return zzdni.z(i2, (zzdpk) obj, lwVar);
    }
}
