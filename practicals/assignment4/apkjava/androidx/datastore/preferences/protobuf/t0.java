package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.h;
import androidx.datastore.preferences.protobuf.j0;
import androidx.datastore.preferences.protobuf.r1;
import androidx.datastore.preferences.protobuf.s1;
import androidx.datastore.preferences.protobuf.u;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: MessageSchema.java */
/* loaded from: classes.dex */
final class t0<T> implements f1<T> {
    private static final int[] a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f1413b = p1.B();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f1414c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f1415d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1416e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1417f;

    /* renamed from: g, reason: collision with root package name */
    private final q0 f1418g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f1419h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f1420i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f1421j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f1422k;
    private final int[] l;
    private final int m;
    private final int n;
    private final v0 o;
    private final g0 p;
    private final l1<?, ?> q;
    private final q<?> r;
    private final l0 s;

    private t0(int[] iArr, Object[] objArr, int i2, int i3, q0 q0Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        this.f1414c = iArr;
        this.f1415d = objArr;
        this.f1416e = i2;
        this.f1417f = i3;
        this.f1420i = q0Var instanceof y;
        this.f1421j = z;
        this.f1419h = qVar != null && qVar.e(q0Var);
        this.f1422k = z2;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = v0Var;
        this.p = g0Var;
        this.q = l1Var;
        this.r = qVar;
        this.f1418g = q0Var;
        this.s = l0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean A(Object obj, int i2, f1 f1Var) {
        return f1Var.g(p1.A(obj, R(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean B(Object obj, int i2, int i3) {
        List list = (List) p1.A(obj, R(i2));
        if (list.isEmpty()) {
            return true;
        }
        f1 s = s(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!s.g(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.datastore.preferences.protobuf.f1] */
    private boolean C(T t, int i2, int i3) {
        Map<?, ?> h2 = this.s.h(p1.A(t, R(i2)));
        if (h2.isEmpty()) {
            return true;
        }
        if (this.s.c(r(i3)).f1353c.g() != r1.c.MESSAGE) {
            return true;
        }
        ?? r5 = 0;
        for (Object obj : h2.values()) {
            r5 = r5;
            if (r5 == 0) {
                r5 = b1.a().d(obj.getClass());
            }
            if (!r5.g(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean D(T t, T t2, int i2) {
        long Y = Y(i2) & 1048575;
        return p1.x(t, Y) == p1.x(t2, Y);
    }

    private boolean E(T t, int i2, int i3) {
        return p1.x(t, (long) (Y(i3) & 1048575)) == i2;
    }

    private static boolean F(int i2) {
        return (i2 & 268435456) != 0;
    }

    private static List<?> G(Object obj, long j2) {
        return (List) p1.A(obj, j2);
    }

    private static <T> long H(T t, long j2) {
        return p1.y(t, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:324:0x0077, code lost:
    
        r0 = r16.m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x007b, code lost:
    
        if (r0 >= r16.n) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x007d, code lost:
    
        r13 = n(r19, r16.l[r0], r13, r17);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0088, code lost:
    
        if (r13 == null) goto L365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x008a, code lost:
    
        r17.o(r19, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x008d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0098. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends u.b<ET>> void I(l1<UT, UB> l1Var, q<ET> qVar, T t, e1 e1Var, p pVar) throws IOException {
        Object obj = null;
        u<ET> uVar = null;
        while (true) {
            try {
                int A = e1Var.A();
                int X = X(A);
                if (X < 0) {
                    if (A == Integer.MAX_VALUE) {
                        for (int i2 = this.m; i2 < this.n; i2++) {
                            obj = n(t, this.l[i2], obj, l1Var);
                        }
                        if (obj != null) {
                            l1Var.o(t, obj);
                            return;
                        }
                        return;
                    }
                    Object b2 = !this.f1419h ? null : qVar.b(pVar, this.f1418g, A);
                    if (b2 != null) {
                        if (uVar == null) {
                            uVar = qVar.d(t);
                        }
                        obj = qVar.g(e1Var, b2, pVar, uVar, obj, l1Var);
                    } else if (l1Var.q(e1Var)) {
                        if (e1Var.G()) {
                        }
                    } else {
                        if (obj == null) {
                            obj = l1Var.f(t);
                        }
                        if (l1Var.m(obj, e1Var)) {
                        }
                    }
                } else {
                    int i0 = i0(X);
                    try {
                        switch (h0(i0)) {
                            case 0:
                                p1.K(t, R(i0), e1Var.readDouble());
                                e0(t, X);
                                break;
                            case 1:
                                p1.L(t, R(i0), e1Var.readFloat());
                                e0(t, X);
                                break;
                            case 2:
                                p1.N(t, R(i0), e1Var.L());
                                e0(t, X);
                                break;
                            case 3:
                                p1.N(t, R(i0), e1Var.e());
                                e0(t, X);
                                break;
                            case 4:
                                p1.M(t, R(i0), e1Var.E());
                                e0(t, X);
                                break;
                            case 5:
                                p1.N(t, R(i0), e1Var.f());
                                e0(t, X);
                                break;
                            case 6:
                                p1.M(t, R(i0), e1Var.k());
                                e0(t, X);
                                break;
                            case 7:
                                p1.E(t, R(i0), e1Var.l());
                                e0(t, X);
                                break;
                            case 8:
                                b0(t, i0, e1Var);
                                e0(t, X);
                                break;
                            case 9:
                                if (y(t, X)) {
                                    p1.O(t, R(i0), a0.h(p1.A(t, R(i0)), e1Var.c(s(X), pVar)));
                                    break;
                                } else {
                                    p1.O(t, R(i0), e1Var.c(s(X), pVar));
                                    e0(t, X);
                                    break;
                                }
                            case 10:
                                p1.O(t, R(i0), e1Var.C());
                                e0(t, X);
                                break;
                            case 11:
                                p1.M(t, R(i0), e1Var.p());
                                e0(t, X);
                                break;
                            case 12:
                                int v = e1Var.v();
                                a0.e q = q(X);
                                if (q != null && !q.a(v)) {
                                    obj = h1.L(A, v, obj, l1Var);
                                    break;
                                }
                                p1.M(t, R(i0), v);
                                e0(t, X);
                                break;
                            case 13:
                                p1.M(t, R(i0), e1Var.H());
                                e0(t, X);
                                break;
                            case 14:
                                p1.N(t, R(i0), e1Var.m());
                                e0(t, X);
                                break;
                            case 15:
                                p1.M(t, R(i0), e1Var.x());
                                e0(t, X);
                                break;
                            case 16:
                                p1.N(t, R(i0), e1Var.y());
                                e0(t, X);
                                break;
                            case 17:
                                if (y(t, X)) {
                                    p1.O(t, R(i0), a0.h(p1.A(t, R(i0)), e1Var.O(s(X), pVar)));
                                    break;
                                } else {
                                    p1.O(t, R(i0), e1Var.O(s(X), pVar));
                                    e0(t, X);
                                    break;
                                }
                            case 18:
                                e1Var.J(this.p.e(t, R(i0)));
                                break;
                            case 19:
                                e1Var.D(this.p.e(t, R(i0)));
                                break;
                            case 20:
                                e1Var.q(this.p.e(t, R(i0)));
                                break;
                            case 21:
                                e1Var.n(this.p.e(t, R(i0)));
                                break;
                            case 22:
                                e1Var.s(this.p.e(t, R(i0)));
                                break;
                            case 23:
                                e1Var.N(this.p.e(t, R(i0)));
                                break;
                            case 24:
                                e1Var.w(this.p.e(t, R(i0)));
                                break;
                            case 25:
                                e1Var.z(this.p.e(t, R(i0)));
                                break;
                            case 26:
                                c0(t, i0, e1Var);
                                break;
                            case 27:
                                a0(t, i0, e1Var, s(X), pVar);
                                break;
                            case 28:
                                e1Var.I(this.p.e(t, R(i0)));
                                break;
                            case 29:
                                e1Var.j(this.p.e(t, R(i0)));
                                break;
                            case 30:
                                List<Integer> e2 = this.p.e(t, R(i0));
                                e1Var.t(e2);
                                obj = h1.A(A, e2, q(X), obj, l1Var);
                                break;
                            case 31:
                                e1Var.h(this.p.e(t, R(i0)));
                                break;
                            case 32:
                                e1Var.r(this.p.e(t, R(i0)));
                                break;
                            case 33:
                                e1Var.d(this.p.e(t, R(i0)));
                                break;
                            case 34:
                                e1Var.i(this.p.e(t, R(i0)));
                                break;
                            case 35:
                                e1Var.J(this.p.e(t, R(i0)));
                                break;
                            case 36:
                                e1Var.D(this.p.e(t, R(i0)));
                                break;
                            case 37:
                                e1Var.q(this.p.e(t, R(i0)));
                                break;
                            case 38:
                                e1Var.n(this.p.e(t, R(i0)));
                                break;
                            case 39:
                                e1Var.s(this.p.e(t, R(i0)));
                                break;
                            case 40:
                                e1Var.N(this.p.e(t, R(i0)));
                                break;
                            case 41:
                                e1Var.w(this.p.e(t, R(i0)));
                                break;
                            case 42:
                                e1Var.z(this.p.e(t, R(i0)));
                                break;
                            case 43:
                                e1Var.j(this.p.e(t, R(i0)));
                                break;
                            case 44:
                                List<Integer> e3 = this.p.e(t, R(i0));
                                e1Var.t(e3);
                                obj = h1.A(A, e3, q(X), obj, l1Var);
                                break;
                            case 45:
                                e1Var.h(this.p.e(t, R(i0)));
                                break;
                            case 46:
                                e1Var.r(this.p.e(t, R(i0)));
                                break;
                            case 47:
                                e1Var.d(this.p.e(t, R(i0)));
                                break;
                            case 48:
                                e1Var.i(this.p.e(t, R(i0)));
                                break;
                            case 49:
                                Z(t, R(i0), e1Var, s(X), pVar);
                                break;
                            case 50:
                                J(t, X, r(X), pVar, e1Var);
                                break;
                            case 51:
                                p1.O(t, R(i0), Double.valueOf(e1Var.readDouble()));
                                f0(t, A, X);
                                break;
                            case 52:
                                p1.O(t, R(i0), Float.valueOf(e1Var.readFloat()));
                                f0(t, A, X);
                                break;
                            case 53:
                                p1.O(t, R(i0), Long.valueOf(e1Var.L()));
                                f0(t, A, X);
                                break;
                            case 54:
                                p1.O(t, R(i0), Long.valueOf(e1Var.e()));
                                f0(t, A, X);
                                break;
                            case 55:
                                p1.O(t, R(i0), Integer.valueOf(e1Var.E()));
                                f0(t, A, X);
                                break;
                            case 56:
                                p1.O(t, R(i0), Long.valueOf(e1Var.f()));
                                f0(t, A, X);
                                break;
                            case 57:
                                p1.O(t, R(i0), Integer.valueOf(e1Var.k()));
                                f0(t, A, X);
                                break;
                            case 58:
                                p1.O(t, R(i0), Boolean.valueOf(e1Var.l()));
                                f0(t, A, X);
                                break;
                            case 59:
                                b0(t, i0, e1Var);
                                f0(t, A, X);
                                break;
                            case 60:
                                if (E(t, A, X)) {
                                    p1.O(t, R(i0), a0.h(p1.A(t, R(i0)), e1Var.c(s(X), pVar)));
                                } else {
                                    p1.O(t, R(i0), e1Var.c(s(X), pVar));
                                    e0(t, X);
                                }
                                f0(t, A, X);
                                break;
                            case 61:
                                p1.O(t, R(i0), e1Var.C());
                                f0(t, A, X);
                                break;
                            case 62:
                                p1.O(t, R(i0), Integer.valueOf(e1Var.p()));
                                f0(t, A, X);
                                break;
                            case 63:
                                int v2 = e1Var.v();
                                a0.e q2 = q(X);
                                if (q2 != null && !q2.a(v2)) {
                                    obj = h1.L(A, v2, obj, l1Var);
                                    break;
                                }
                                p1.O(t, R(i0), Integer.valueOf(v2));
                                f0(t, A, X);
                                break;
                            case 64:
                                p1.O(t, R(i0), Integer.valueOf(e1Var.H()));
                                f0(t, A, X);
                                break;
                            case 65:
                                p1.O(t, R(i0), Long.valueOf(e1Var.m()));
                                f0(t, A, X);
                                break;
                            case 66:
                                p1.O(t, R(i0), Integer.valueOf(e1Var.x()));
                                f0(t, A, X);
                                break;
                            case 67:
                                p1.O(t, R(i0), Long.valueOf(e1Var.y()));
                                f0(t, A, X);
                                break;
                            case 68:
                                p1.O(t, R(i0), e1Var.O(s(X), pVar));
                                f0(t, A, X);
                                break;
                            default:
                                if (obj == null) {
                                    obj = l1Var.n();
                                }
                                if (!l1Var.m(obj, e1Var)) {
                                    for (int i3 = this.m; i3 < this.n; i3++) {
                                        obj = n(t, this.l[i3], obj, l1Var);
                                    }
                                    if (obj != null) {
                                        l1Var.o(t, obj);
                                        return;
                                    }
                                    return;
                                }
                                break;
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        if (l1Var.q(e1Var)) {
                            if (!e1Var.G()) {
                                for (int i4 = this.m; i4 < this.n; i4++) {
                                    obj = n(t, this.l[i4], obj, l1Var);
                                }
                                if (obj != null) {
                                    l1Var.o(t, obj);
                                    return;
                                }
                                return;
                            }
                        } else {
                            if (obj == null) {
                                obj = l1Var.f(t);
                            }
                            if (!l1Var.m(obj, e1Var)) {
                                for (int i5 = this.m; i5 < this.n; i5++) {
                                    obj = n(t, this.l[i5], obj, l1Var);
                                }
                                if (obj != null) {
                                    l1Var.o(t, obj);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.m; i6 < this.n; i6++) {
                    obj = n(t, this.l[i6], obj, l1Var);
                }
                if (obj != null) {
                    l1Var.o(t, obj);
                }
                throw th;
            }
        }
    }

    private final <K, V> void J(Object obj, int i2, Object obj2, p pVar, e1 e1Var) throws IOException {
        long R = R(i0(i2));
        Object A = p1.A(obj, R);
        if (A == null) {
            A = this.s.e(obj2);
            p1.O(obj, R, A);
        } else if (this.s.g(A)) {
            Object e2 = this.s.e(obj2);
            this.s.a(e2, A);
            p1.O(obj, R, e2);
            A = e2;
        }
        e1Var.u(this.s.d(A), this.s.c(obj2), pVar);
    }

    private void K(T t, T t2, int i2) {
        long R = R(i0(i2));
        if (y(t2, i2)) {
            Object A = p1.A(t, R);
            Object A2 = p1.A(t2, R);
            if (A != null && A2 != null) {
                p1.O(t, R, a0.h(A, A2));
                e0(t, i2);
            } else if (A2 != null) {
                p1.O(t, R, A2);
                e0(t, i2);
            }
        }
    }

    private void L(T t, T t2, int i2) {
        int i0 = i0(i2);
        int Q = Q(i2);
        long R = R(i0);
        if (E(t2, Q, i2)) {
            Object A = p1.A(t, R);
            Object A2 = p1.A(t2, R);
            if (A != null && A2 != null) {
                p1.O(t, R, a0.h(A, A2));
                f0(t, Q, i2);
            } else if (A2 != null) {
                p1.O(t, R, A2);
                f0(t, Q, i2);
            }
        }
    }

    private void M(T t, T t2, int i2) {
        int i0 = i0(i2);
        long R = R(i0);
        int Q = Q(i2);
        switch (h0(i0)) {
            case 0:
                if (y(t2, i2)) {
                    p1.K(t, R, p1.v(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 1:
                if (y(t2, i2)) {
                    p1.L(t, R, p1.w(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 2:
                if (y(t2, i2)) {
                    p1.N(t, R, p1.y(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 3:
                if (y(t2, i2)) {
                    p1.N(t, R, p1.y(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 4:
                if (y(t2, i2)) {
                    p1.M(t, R, p1.x(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 5:
                if (y(t2, i2)) {
                    p1.N(t, R, p1.y(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 6:
                if (y(t2, i2)) {
                    p1.M(t, R, p1.x(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 7:
                if (y(t2, i2)) {
                    p1.E(t, R, p1.p(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 8:
                if (y(t2, i2)) {
                    p1.O(t, R, p1.A(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 9:
                K(t, t2, i2);
                return;
            case 10:
                if (y(t2, i2)) {
                    p1.O(t, R, p1.A(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 11:
                if (y(t2, i2)) {
                    p1.M(t, R, p1.x(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 12:
                if (y(t2, i2)) {
                    p1.M(t, R, p1.x(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 13:
                if (y(t2, i2)) {
                    p1.M(t, R, p1.x(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 14:
                if (y(t2, i2)) {
                    p1.N(t, R, p1.y(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 15:
                if (y(t2, i2)) {
                    p1.M(t, R, p1.x(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 16:
                if (y(t2, i2)) {
                    p1.N(t, R, p1.y(t2, R));
                    e0(t, i2);
                    return;
                }
                return;
            case 17:
                K(t, t2, i2);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.p.d(t, t2, R);
                return;
            case 50:
                h1.F(this.s, t, t2, R);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (E(t2, Q, i2)) {
                    p1.O(t, R, p1.A(t2, R));
                    f0(t, Q, i2);
                    return;
                }
                return;
            case 60:
                L(t, t2, i2);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (E(t2, Q, i2)) {
                    p1.O(t, R, p1.A(t2, R));
                    f0(t, Q, i2);
                    return;
                }
                return;
            case 68:
                L(t, t2, i2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> t0<T> N(Class<T> cls, o0 o0Var, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        if (o0Var instanceof d1) {
            return P((d1) o0Var, v0Var, g0Var, l1Var, qVar, l0Var);
        }
        return O((j1) o0Var, v0Var, g0Var, l1Var, qVar, l0Var);
    }

    static <T> t0<T> O(j1 j1Var, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        boolean z = j1Var.c() == a1.PROTO3;
        t[] e2 = j1Var.e();
        if (e2.length == 0) {
            int length = e2.length;
            int[] iArr = new int[length * 3];
            Object[] objArr = new Object[length * 2];
            if (e2.length <= 0) {
                int[] d2 = j1Var.d();
                if (d2 == null) {
                    d2 = a;
                }
                if (e2.length <= 0) {
                    int[] iArr2 = a;
                    int[] iArr3 = a;
                    int[] iArr4 = new int[d2.length + iArr2.length + iArr3.length];
                    System.arraycopy(d2, 0, iArr4, 0, d2.length);
                    System.arraycopy(iArr2, 0, iArr4, d2.length, iArr2.length);
                    System.arraycopy(iArr3, 0, iArr4, d2.length + iArr2.length, iArr3.length);
                    return new t0<>(iArr, objArr, 0, 0, j1Var.b(), z, true, iArr4, d2.length, d2.length + iArr2.length, v0Var, g0Var, l1Var, qVar, l0Var);
                }
                t tVar = e2[0];
                throw null;
            }
            t tVar2 = e2[0];
            throw null;
        }
        t tVar3 = e2[0];
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x027a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> t0<T> P(d1 d1Var, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        int i2;
        int charAt;
        int charAt2;
        int charAt3;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        char charAt4;
        int i7;
        char charAt5;
        int i8;
        char charAt6;
        int i9;
        char charAt7;
        int i10;
        char charAt8;
        int i11;
        char charAt9;
        int i12;
        char charAt10;
        int i13;
        char charAt11;
        int i14;
        int i15;
        boolean z;
        int i16;
        int[] iArr2;
        int i17;
        int i18;
        int i19;
        int objectFieldOffset;
        String str;
        Class<?> cls;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Field d0;
        int i25;
        char charAt12;
        int i26;
        int i27;
        Object obj;
        Field d02;
        Object obj2;
        Field d03;
        int i28;
        char charAt13;
        int i29;
        char charAt14;
        int i30;
        char charAt15;
        int i31;
        char charAt16;
        char charAt17;
        int i32 = 0;
        boolean z2 = d1Var.c() == a1.PROTO3;
        String e2 = d1Var.e();
        int length = e2.length();
        int charAt18 = e2.charAt(0);
        if (charAt18 >= 55296) {
            int i33 = charAt18 & 8191;
            int i34 = 1;
            int i35 = 13;
            while (true) {
                i2 = i34 + 1;
                charAt17 = e2.charAt(i34);
                if (charAt17 < 55296) {
                    break;
                }
                i33 |= (charAt17 & 8191) << i35;
                i35 += 13;
                i34 = i2;
            }
            charAt18 = i33 | (charAt17 << i35);
        } else {
            i2 = 1;
        }
        int i36 = i2 + 1;
        int charAt19 = e2.charAt(i2);
        if (charAt19 >= 55296) {
            int i37 = charAt19 & 8191;
            int i38 = 13;
            while (true) {
                i31 = i36 + 1;
                charAt16 = e2.charAt(i36);
                if (charAt16 < 55296) {
                    break;
                }
                i37 |= (charAt16 & 8191) << i38;
                i38 += 13;
                i36 = i31;
            }
            charAt19 = i37 | (charAt16 << i38);
            i36 = i31;
        }
        if (charAt19 == 0) {
            iArr = a;
            i4 = 0;
            i5 = 0;
            charAt = 0;
            charAt2 = 0;
            i3 = 0;
            charAt3 = 0;
        } else {
            int i39 = i36 + 1;
            int charAt20 = e2.charAt(i36);
            if (charAt20 >= 55296) {
                int i40 = charAt20 & 8191;
                int i41 = 13;
                while (true) {
                    i13 = i39 + 1;
                    charAt11 = e2.charAt(i39);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i40 |= (charAt11 & 8191) << i41;
                    i41 += 13;
                    i39 = i13;
                }
                charAt20 = i40 | (charAt11 << i41);
                i39 = i13;
            }
            int i42 = i39 + 1;
            int charAt21 = e2.charAt(i39);
            if (charAt21 >= 55296) {
                int i43 = charAt21 & 8191;
                int i44 = 13;
                while (true) {
                    i12 = i42 + 1;
                    charAt10 = e2.charAt(i42);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i43 |= (charAt10 & 8191) << i44;
                    i44 += 13;
                    i42 = i12;
                }
                charAt21 = i43 | (charAt10 << i44);
                i42 = i12;
            }
            int i45 = i42 + 1;
            int charAt22 = e2.charAt(i42);
            if (charAt22 >= 55296) {
                int i46 = charAt22 & 8191;
                int i47 = 13;
                while (true) {
                    i11 = i45 + 1;
                    charAt9 = e2.charAt(i45);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i46 |= (charAt9 & 8191) << i47;
                    i47 += 13;
                    i45 = i11;
                }
                charAt22 = i46 | (charAt9 << i47);
                i45 = i11;
            }
            int i48 = i45 + 1;
            charAt = e2.charAt(i45);
            if (charAt >= 55296) {
                int i49 = charAt & 8191;
                int i50 = 13;
                while (true) {
                    i10 = i48 + 1;
                    charAt8 = e2.charAt(i48);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i49 |= (charAt8 & 8191) << i50;
                    i50 += 13;
                    i48 = i10;
                }
                charAt = i49 | (charAt8 << i50);
                i48 = i10;
            }
            int i51 = i48 + 1;
            charAt2 = e2.charAt(i48);
            if (charAt2 >= 55296) {
                int i52 = charAt2 & 8191;
                int i53 = 13;
                while (true) {
                    i9 = i51 + 1;
                    charAt7 = e2.charAt(i51);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i52 |= (charAt7 & 8191) << i53;
                    i53 += 13;
                    i51 = i9;
                }
                charAt2 = i52 | (charAt7 << i53);
                i51 = i9;
            }
            int i54 = i51 + 1;
            int charAt23 = e2.charAt(i51);
            if (charAt23 >= 55296) {
                int i55 = charAt23 & 8191;
                int i56 = 13;
                while (true) {
                    i8 = i54 + 1;
                    charAt6 = e2.charAt(i54);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i55 |= (charAt6 & 8191) << i56;
                    i56 += 13;
                    i54 = i8;
                }
                charAt23 = i55 | (charAt6 << i56);
                i54 = i8;
            }
            int i57 = i54 + 1;
            int charAt24 = e2.charAt(i54);
            if (charAt24 >= 55296) {
                int i58 = charAt24 & 8191;
                int i59 = 13;
                while (true) {
                    i7 = i57 + 1;
                    charAt5 = e2.charAt(i57);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i58 |= (charAt5 & 8191) << i59;
                    i59 += 13;
                    i57 = i7;
                }
                charAt24 = i58 | (charAt5 << i59);
                i57 = i7;
            }
            int i60 = i57 + 1;
            charAt3 = e2.charAt(i57);
            if (charAt3 >= 55296) {
                int i61 = charAt3 & 8191;
                int i62 = i60;
                int i63 = 13;
                while (true) {
                    i6 = i62 + 1;
                    charAt4 = e2.charAt(i62);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i61 |= (charAt4 & 8191) << i63;
                    i63 += 13;
                    i62 = i6;
                }
                charAt3 = i61 | (charAt4 << i63);
                i60 = i6;
            }
            int[] iArr3 = new int[charAt3 + charAt23 + charAt24];
            i3 = (charAt20 * 2) + charAt21;
            i4 = charAt20;
            i36 = i60;
            int i64 = charAt23;
            iArr = iArr3;
            i32 = charAt22;
            i5 = i64;
        }
        Unsafe unsafe = f1413b;
        Object[] d2 = d1Var.d();
        Class<?> cls2 = d1Var.b().getClass();
        int[] iArr4 = new int[charAt2 * 3];
        Object[] objArr = new Object[charAt2 * 2];
        int i65 = charAt3 + i5;
        int i66 = charAt3;
        int i67 = i65;
        int i68 = 0;
        int i69 = 0;
        while (i36 < length) {
            int i70 = i36 + 1;
            int charAt25 = e2.charAt(i36);
            int i71 = length;
            if (charAt25 >= 55296) {
                int i72 = charAt25 & 8191;
                int i73 = i70;
                int i74 = 13;
                while (true) {
                    i30 = i73 + 1;
                    charAt15 = e2.charAt(i73);
                    i14 = charAt3;
                    if (charAt15 < 55296) {
                        break;
                    }
                    i72 |= (charAt15 & 8191) << i74;
                    i74 += 13;
                    i73 = i30;
                    charAt3 = i14;
                }
                charAt25 = i72 | (charAt15 << i74);
                i15 = i30;
            } else {
                i14 = charAt3;
                i15 = i70;
            }
            int i75 = i15 + 1;
            int charAt26 = e2.charAt(i15);
            if (charAt26 >= 55296) {
                int i76 = charAt26 & 8191;
                int i77 = i75;
                int i78 = 13;
                while (true) {
                    i29 = i77 + 1;
                    charAt14 = e2.charAt(i77);
                    z = z2;
                    if (charAt14 < 55296) {
                        break;
                    }
                    i76 |= (charAt14 & 8191) << i78;
                    i78 += 13;
                    i77 = i29;
                    z2 = z;
                }
                charAt26 = i76 | (charAt14 << i78);
                i16 = i29;
            } else {
                z = z2;
                i16 = i75;
            }
            int i79 = charAt26 & 255;
            int i80 = charAt;
            if ((charAt26 & 1024) != 0) {
                iArr[i68] = i69;
                i68++;
            }
            int i81 = i68;
            if (i79 >= 51) {
                int i82 = i16 + 1;
                int charAt27 = e2.charAt(i16);
                char c2 = 55296;
                if (charAt27 >= 55296) {
                    int i83 = charAt27 & 8191;
                    int i84 = 13;
                    while (true) {
                        i28 = i82 + 1;
                        charAt13 = e2.charAt(i82);
                        if (charAt13 < c2) {
                            break;
                        }
                        i83 |= (charAt13 & 8191) << i84;
                        i84 += 13;
                        i82 = i28;
                        c2 = 55296;
                    }
                    charAt27 = i83 | (charAt13 << i84);
                    i82 = i28;
                }
                int i85 = i79 - 51;
                int i86 = i82;
                if (i85 == 9 || i85 == 17) {
                    i27 = i3 + 1;
                    objArr[((i69 / 3) * 2) + 1] = d2[i3];
                } else {
                    if (i85 == 12 && (charAt18 & 1) == 1) {
                        i27 = i3 + 1;
                        objArr[((i69 / 3) * 2) + 1] = d2[i3];
                    }
                    int i87 = charAt27 * 2;
                    obj = d2[i87];
                    if (!(obj instanceof Field)) {
                        d02 = (Field) obj;
                    } else {
                        d02 = d0(cls2, (String) obj);
                        d2[i87] = d02;
                    }
                    iArr2 = iArr4;
                    i17 = charAt25;
                    int objectFieldOffset2 = (int) unsafe.objectFieldOffset(d02);
                    int i88 = i87 + 1;
                    obj2 = d2[i88];
                    if (!(obj2 instanceof Field)) {
                        d03 = (Field) obj2;
                    } else {
                        d03 = d0(cls2, (String) obj2);
                        d2[i88] = d03;
                    }
                    str = e2;
                    cls = cls2;
                    i20 = charAt18;
                    i23 = (int) unsafe.objectFieldOffset(d03);
                    objectFieldOffset = objectFieldOffset2;
                    i21 = i79;
                    i18 = i3;
                    i22 = i86;
                    i24 = 0;
                }
                i3 = i27;
                int i872 = charAt27 * 2;
                obj = d2[i872];
                if (!(obj instanceof Field)) {
                }
                iArr2 = iArr4;
                i17 = charAt25;
                int objectFieldOffset22 = (int) unsafe.objectFieldOffset(d02);
                int i882 = i872 + 1;
                obj2 = d2[i882];
                if (!(obj2 instanceof Field)) {
                }
                str = e2;
                cls = cls2;
                i20 = charAt18;
                i23 = (int) unsafe.objectFieldOffset(d03);
                objectFieldOffset = objectFieldOffset22;
                i21 = i79;
                i18 = i3;
                i22 = i86;
                i24 = 0;
            } else {
                iArr2 = iArr4;
                i17 = charAt25;
                i18 = i3 + 1;
                Field d04 = d0(cls2, (String) d2[i3]);
                if (i79 == 9 || i79 == 17) {
                    objArr[((i69 / 3) * 2) + 1] = d04.getType();
                } else {
                    if (i79 == 27 || i79 == 49) {
                        i26 = i18 + 1;
                        objArr[((i69 / 3) * 2) + 1] = d2[i18];
                    } else if (i79 == 12 || i79 == 30 || i79 == 44) {
                        if ((charAt18 & 1) == 1) {
                            i26 = i18 + 1;
                            objArr[((i69 / 3) * 2) + 1] = d2[i18];
                        }
                    } else if (i79 == 50) {
                        int i89 = i66 + 1;
                        iArr[i66] = i69;
                        int i90 = (i69 / 3) * 2;
                        int i91 = i18 + 1;
                        objArr[i90] = d2[i18];
                        if ((charAt26 & RecyclerView.l.FLAG_MOVED) != 0) {
                            i18 = i91 + 1;
                            objArr[i90 + 1] = d2[i91];
                            i66 = i89;
                        } else {
                            i66 = i89;
                            i18 = i91;
                        }
                    }
                    i19 = i79;
                    i18 = i26;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(d04);
                    if ((charAt18 & 1) != 1) {
                        i21 = i19;
                        if (i21 <= 17) {
                            i22 = i16 + 1;
                            int charAt28 = e2.charAt(i16);
                            if (charAt28 >= 55296) {
                                int i92 = charAt28 & 8191;
                                int i93 = 13;
                                while (true) {
                                    i25 = i22 + 1;
                                    charAt12 = e2.charAt(i22);
                                    if (charAt12 < 55296) {
                                        break;
                                    }
                                    i92 |= (charAt12 & 8191) << i93;
                                    i93 += 13;
                                    i22 = i25;
                                }
                                charAt28 = i92 | (charAt12 << i93);
                                i22 = i25;
                            }
                            int i94 = (i4 * 2) + (charAt28 / 32);
                            Object obj3 = d2[i94];
                            str = e2;
                            if (obj3 instanceof Field) {
                                d0 = (Field) obj3;
                            } else {
                                d0 = d0(cls2, (String) obj3);
                                d2[i94] = d0;
                            }
                            cls = cls2;
                            i20 = charAt18;
                            i23 = (int) unsafe.objectFieldOffset(d0);
                            i24 = charAt28 % 32;
                            if (i21 >= 18 && i21 <= 49) {
                                iArr[i67] = objectFieldOffset;
                                i67++;
                            }
                        } else {
                            str = e2;
                            cls = cls2;
                            i20 = charAt18;
                        }
                    } else {
                        str = e2;
                        cls = cls2;
                        i20 = charAt18;
                        i21 = i19;
                    }
                    i22 = i16;
                    i23 = 0;
                    i24 = 0;
                    if (i21 >= 18) {
                        iArr[i67] = objectFieldOffset;
                        i67++;
                    }
                }
                i19 = i79;
                objectFieldOffset = (int) unsafe.objectFieldOffset(d04);
                if ((charAt18 & 1) != 1) {
                }
                i22 = i16;
                i23 = 0;
                i24 = 0;
                if (i21 >= 18) {
                }
            }
            int i95 = i69 + 1;
            iArr2[i69] = i17;
            int i96 = i95 + 1;
            int i97 = i20;
            iArr2[i95] = ((charAt26 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 536870912 : 0) | ((charAt26 & 256) != 0 ? 268435456 : 0) | (i21 << 20) | objectFieldOffset;
            int i98 = i96 + 1;
            iArr2[i96] = (i24 << 20) | i23;
            i36 = i22;
            cls2 = cls;
            charAt18 = i97;
            length = i71;
            charAt3 = i14;
            z2 = z;
            i68 = i81;
            i69 = i98;
            i3 = i18;
            iArr4 = iArr2;
            charAt = i80;
            e2 = str;
        }
        return new t0<>(iArr4, objArr, i32, charAt, d1Var.b(), z2, false, iArr, charAt3, i65, v0Var, g0Var, l1Var, qVar, l0Var);
    }

    private int Q(int i2) {
        return this.f1414c[i2];
    }

    private static long R(int i2) {
        return i2 & 1048575;
    }

    private static <T> boolean S(T t, long j2) {
        return ((Boolean) p1.A(t, j2)).booleanValue();
    }

    private static <T> double T(T t, long j2) {
        return ((Double) p1.A(t, j2)).doubleValue();
    }

    private static <T> float U(T t, long j2) {
        return ((Float) p1.A(t, j2)).floatValue();
    }

    private static <T> int V(T t, long j2) {
        return ((Integer) p1.A(t, j2)).intValue();
    }

    private static <T> long W(T t, long j2) {
        return ((Long) p1.A(t, j2)).longValue();
    }

    private int X(int i2) {
        if (i2 < this.f1416e || i2 > this.f1417f) {
            return -1;
        }
        return g0(i2, 0);
    }

    private int Y(int i2) {
        return this.f1414c[i2 + 2];
    }

    private <E> void Z(Object obj, long j2, e1 e1Var, f1<E> f1Var, p pVar) throws IOException {
        e1Var.F(this.p.e(obj, j2), f1Var, pVar);
    }

    private <E> void a0(Object obj, int i2, e1 e1Var, f1<E> f1Var, p pVar) throws IOException {
        e1Var.K(this.p.e(obj, R(i2)), f1Var, pVar);
    }

    private void b0(Object obj, int i2, e1 e1Var) throws IOException {
        if (x(i2)) {
            p1.O(obj, R(i2), e1Var.M());
        } else if (this.f1420i) {
            p1.O(obj, R(i2), e1Var.a());
        } else {
            p1.O(obj, R(i2), e1Var.C());
        }
    }

    private void c0(Object obj, int i2, e1 e1Var) throws IOException {
        if (x(i2)) {
            e1Var.B(this.p.e(obj, R(i2)));
        } else {
            e1Var.b(this.p.e(obj, R(i2)));
        }
    }

    private static Field d0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void e0(T t, int i2) {
        if (this.f1421j) {
            return;
        }
        int Y = Y(i2);
        long j2 = Y & 1048575;
        p1.M(t, j2, p1.x(t, j2) | (1 << (Y >>> 20)));
    }

    private void f0(T t, int i2, int i3) {
        p1.M(t, Y(i3) & 1048575, i2);
    }

    private int g0(int i2, int i3) {
        int length = (this.f1414c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int Q = Q(i5);
            if (i2 == Q) {
                return i5;
            }
            if (i2 < Q) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static int h0(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    private int i0(int i2) {
        return this.f1414c[i2 + 1];
    }

    private boolean j(T t, T t2, int i2) {
        return y(t, i2) == y(t2, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j0(T t, s1 s1Var) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i2;
        Map.Entry<?, ?> entry2;
        int i3;
        if (this.f1419h) {
            u<?> c2 = this.r.c(t);
            if (!c2.n()) {
                it = c2.s();
                entry = (Map.Entry) it.next();
                int i4 = -1;
                length = this.f1414c.length;
                Unsafe unsafe = f1413b;
                i2 = 0;
                int i5 = 0;
                while (i2 < length) {
                    int i0 = i0(i2);
                    int Q = Q(i2);
                    int h0 = h0(i0);
                    if (this.f1421j || h0 > 17) {
                        entry2 = entry;
                        i3 = 0;
                    } else {
                        int i6 = this.f1414c[i2 + 2];
                        int i7 = i6 & 1048575;
                        Map.Entry<?, ?> entry3 = entry;
                        if (i7 != i4) {
                            i5 = unsafe.getInt(t, i7);
                            i4 = i7;
                        }
                        i3 = 1 << (i6 >>> 20);
                        entry2 = entry3;
                    }
                    while (entry2 != null && this.r.a(entry2) <= Q) {
                        this.r.j(s1Var, entry2);
                        entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    Map.Entry<?, ?> entry4 = entry2;
                    int i8 = i4;
                    long R = R(i0);
                    switch (h0) {
                        case 0:
                            if ((i3 & i5) == 0) {
                                break;
                            } else {
                                s1Var.e(Q, l(t, R));
                                continue;
                            }
                        case 1:
                            if ((i3 & i5) != 0) {
                                s1Var.E(Q, p(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i3 & i5) != 0) {
                                s1Var.p(Q, unsafe.getLong(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i3 & i5) != 0) {
                                s1Var.n(Q, unsafe.getLong(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i3 & i5) != 0) {
                                s1Var.t(Q, unsafe.getInt(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i3 & i5) != 0) {
                                s1Var.h(Q, unsafe.getLong(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i3 & i5) != 0) {
                                s1Var.d(Q, unsafe.getInt(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i3 & i5) != 0) {
                                s1Var.q(Q, k(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i3 & i5) != 0) {
                                n0(Q, unsafe.getObject(t, R), s1Var);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i3 & i5) != 0) {
                                s1Var.z(Q, unsafe.getObject(t, R), s(i2));
                                break;
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i3 & i5) != 0) {
                                s1Var.w(Q, (h) unsafe.getObject(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i3 & i5) != 0) {
                                s1Var.b(Q, unsafe.getInt(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i3 & i5) != 0) {
                                s1Var.H(Q, unsafe.getInt(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i3 & i5) != 0) {
                                s1Var.r(Q, unsafe.getInt(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i3 & i5) != 0) {
                                s1Var.x(Q, unsafe.getLong(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i3 & i5) != 0) {
                                s1Var.M(Q, unsafe.getInt(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i3 & i5) != 0) {
                                s1Var.D(Q, unsafe.getLong(t, R));
                                break;
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i3 & i5) != 0) {
                                s1Var.O(Q, unsafe.getObject(t, R), s(i2));
                                break;
                            } else {
                                continue;
                            }
                        case 18:
                            h1.P(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 19:
                            h1.T(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 20:
                            h1.W(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 21:
                            h1.e0(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 22:
                            h1.V(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 23:
                            h1.S(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 24:
                            h1.R(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 25:
                            h1.N(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 26:
                            h1.c0(Q(i2), (List) unsafe.getObject(t, R), s1Var);
                            break;
                        case 27:
                            h1.X(Q(i2), (List) unsafe.getObject(t, R), s1Var, s(i2));
                            break;
                        case 28:
                            h1.O(Q(i2), (List) unsafe.getObject(t, R), s1Var);
                            break;
                        case 29:
                            h1.d0(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 30:
                            h1.Q(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 31:
                            h1.Y(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 32:
                            h1.Z(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 33:
                            h1.a0(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 34:
                            h1.b0(Q(i2), (List) unsafe.getObject(t, R), s1Var, false);
                            continue;
                        case 35:
                            h1.P(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 36:
                            h1.T(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 37:
                            h1.W(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 38:
                            h1.e0(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 39:
                            h1.V(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 40:
                            h1.S(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 41:
                            h1.R(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 42:
                            h1.N(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 43:
                            h1.d0(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 44:
                            h1.Q(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 45:
                            h1.Y(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 46:
                            h1.Z(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 47:
                            h1.a0(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 48:
                            h1.b0(Q(i2), (List) unsafe.getObject(t, R), s1Var, true);
                            break;
                        case 49:
                            h1.U(Q(i2), (List) unsafe.getObject(t, R), s1Var, s(i2));
                            break;
                        case 50:
                            m0(s1Var, Q, unsafe.getObject(t, R), i2);
                            break;
                        case 51:
                            if (E(t, Q, i2)) {
                                s1Var.e(Q, T(t, R));
                                break;
                            }
                            break;
                        case 52:
                            if (E(t, Q, i2)) {
                                s1Var.E(Q, U(t, R));
                                break;
                            }
                            break;
                        case 53:
                            if (E(t, Q, i2)) {
                                s1Var.p(Q, W(t, R));
                                break;
                            }
                            break;
                        case 54:
                            if (E(t, Q, i2)) {
                                s1Var.n(Q, W(t, R));
                                break;
                            }
                            break;
                        case 55:
                            if (E(t, Q, i2)) {
                                s1Var.t(Q, V(t, R));
                                break;
                            }
                            break;
                        case 56:
                            if (E(t, Q, i2)) {
                                s1Var.h(Q, W(t, R));
                                break;
                            }
                            break;
                        case 57:
                            if (E(t, Q, i2)) {
                                s1Var.d(Q, V(t, R));
                                break;
                            }
                            break;
                        case 58:
                            if (E(t, Q, i2)) {
                                s1Var.q(Q, S(t, R));
                                break;
                            }
                            break;
                        case 59:
                            if (E(t, Q, i2)) {
                                n0(Q, unsafe.getObject(t, R), s1Var);
                                break;
                            }
                            break;
                        case 60:
                            if (E(t, Q, i2)) {
                                s1Var.z(Q, unsafe.getObject(t, R), s(i2));
                                break;
                            }
                            break;
                        case 61:
                            if (E(t, Q, i2)) {
                                s1Var.w(Q, (h) unsafe.getObject(t, R));
                                break;
                            }
                            break;
                        case 62:
                            if (E(t, Q, i2)) {
                                s1Var.b(Q, V(t, R));
                                break;
                            }
                            break;
                        case 63:
                            if (E(t, Q, i2)) {
                                s1Var.H(Q, V(t, R));
                                break;
                            }
                            break;
                        case 64:
                            if (E(t, Q, i2)) {
                                s1Var.r(Q, V(t, R));
                                break;
                            }
                            break;
                        case 65:
                            if (E(t, Q, i2)) {
                                s1Var.x(Q, W(t, R));
                                break;
                            }
                            break;
                        case 66:
                            if (E(t, Q, i2)) {
                                s1Var.M(Q, V(t, R));
                                break;
                            }
                            break;
                        case 67:
                            if (E(t, Q, i2)) {
                                s1Var.D(Q, W(t, R));
                                break;
                            }
                            break;
                        case 68:
                            if (E(t, Q, i2)) {
                                s1Var.O(Q, unsafe.getObject(t, R), s(i2));
                                break;
                            }
                            break;
                    }
                    i2 += 3;
                    i4 = i8;
                    entry = entry4;
                }
                while (entry != null) {
                    this.r.j(s1Var, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                o0(this.q, t, s1Var);
            }
        }
        it = null;
        entry = null;
        int i42 = -1;
        length = this.f1414c.length;
        Unsafe unsafe2 = f1413b;
        i2 = 0;
        int i52 = 0;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        o0(this.q, t, s1Var);
    }

    private static <T> boolean k(T t, long j2) {
        return p1.p(t, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k0(T t, s1 s1Var) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i2;
        if (this.f1419h) {
            u<?> c2 = this.r.c(t);
            if (!c2.n()) {
                it = c2.s();
                entry = (Map.Entry) it.next();
                length = this.f1414c.length;
                for (i2 = 0; i2 < length; i2 += 3) {
                    int i0 = i0(i2);
                    int Q = Q(i2);
                    while (entry != null && this.r.a(entry) <= Q) {
                        this.r.j(s1Var, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (h0(i0)) {
                        case 0:
                            if (y(t, i2)) {
                                s1Var.e(Q, l(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (y(t, i2)) {
                                s1Var.E(Q, p(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (y(t, i2)) {
                                s1Var.p(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (y(t, i2)) {
                                s1Var.n(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (y(t, i2)) {
                                s1Var.t(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (y(t, i2)) {
                                s1Var.h(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (y(t, i2)) {
                                s1Var.d(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (y(t, i2)) {
                                s1Var.q(Q, k(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (y(t, i2)) {
                                n0(Q, p1.A(t, R(i0)), s1Var);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (y(t, i2)) {
                                s1Var.z(Q, p1.A(t, R(i0)), s(i2));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (y(t, i2)) {
                                s1Var.w(Q, (h) p1.A(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (y(t, i2)) {
                                s1Var.b(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (y(t, i2)) {
                                s1Var.H(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (y(t, i2)) {
                                s1Var.r(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (y(t, i2)) {
                                s1Var.x(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (y(t, i2)) {
                                s1Var.M(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (y(t, i2)) {
                                s1Var.D(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (y(t, i2)) {
                                s1Var.O(Q, p1.A(t, R(i0)), s(i2));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            h1.P(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 19:
                            h1.T(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 20:
                            h1.W(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 21:
                            h1.e0(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 22:
                            h1.V(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 23:
                            h1.S(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 24:
                            h1.R(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 25:
                            h1.N(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 26:
                            h1.c0(Q(i2), (List) p1.A(t, R(i0)), s1Var);
                            break;
                        case 27:
                            h1.X(Q(i2), (List) p1.A(t, R(i0)), s1Var, s(i2));
                            break;
                        case 28:
                            h1.O(Q(i2), (List) p1.A(t, R(i0)), s1Var);
                            break;
                        case 29:
                            h1.d0(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 30:
                            h1.Q(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 31:
                            h1.Y(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 32:
                            h1.Z(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 33:
                            h1.a0(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 34:
                            h1.b0(Q(i2), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 35:
                            h1.P(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 36:
                            h1.T(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 37:
                            h1.W(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 38:
                            h1.e0(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 39:
                            h1.V(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 40:
                            h1.S(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 41:
                            h1.R(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 42:
                            h1.N(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 43:
                            h1.d0(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 44:
                            h1.Q(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 45:
                            h1.Y(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 46:
                            h1.Z(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 47:
                            h1.a0(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 48:
                            h1.b0(Q(i2), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 49:
                            h1.U(Q(i2), (List) p1.A(t, R(i0)), s1Var, s(i2));
                            break;
                        case 50:
                            m0(s1Var, Q, p1.A(t, R(i0)), i2);
                            break;
                        case 51:
                            if (E(t, Q, i2)) {
                                s1Var.e(Q, T(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (E(t, Q, i2)) {
                                s1Var.E(Q, U(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (E(t, Q, i2)) {
                                s1Var.p(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (E(t, Q, i2)) {
                                s1Var.n(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (E(t, Q, i2)) {
                                s1Var.t(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (E(t, Q, i2)) {
                                s1Var.h(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (E(t, Q, i2)) {
                                s1Var.d(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (E(t, Q, i2)) {
                                s1Var.q(Q, S(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (E(t, Q, i2)) {
                                n0(Q, p1.A(t, R(i0)), s1Var);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (E(t, Q, i2)) {
                                s1Var.z(Q, p1.A(t, R(i0)), s(i2));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (E(t, Q, i2)) {
                                s1Var.w(Q, (h) p1.A(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (E(t, Q, i2)) {
                                s1Var.b(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (E(t, Q, i2)) {
                                s1Var.H(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (E(t, Q, i2)) {
                                s1Var.r(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (E(t, Q, i2)) {
                                s1Var.x(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (E(t, Q, i2)) {
                                s1Var.M(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (E(t, Q, i2)) {
                                s1Var.D(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (E(t, Q, i2)) {
                                s1Var.O(Q, p1.A(t, R(i0)), s(i2));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.r.j(s1Var, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                o0(this.q, t, s1Var);
            }
        }
        it = null;
        entry = null;
        length = this.f1414c.length;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        o0(this.q, t, s1Var);
    }

    private static <T> double l(T t, long j2) {
        return p1.v(t, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l0(T t, s1 s1Var) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        o0(this.q, t, s1Var);
        if (this.f1419h) {
            u<?> c2 = this.r.c(t);
            if (!c2.n()) {
                it = c2.g();
                entry = (Map.Entry) it.next();
                for (length = this.f1414c.length - 3; length >= 0; length -= 3) {
                    int i0 = i0(length);
                    int Q = Q(length);
                    while (entry != null && this.r.a(entry) > Q) {
                        this.r.j(s1Var, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (h0(i0)) {
                        case 0:
                            if (y(t, length)) {
                                s1Var.e(Q, l(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (y(t, length)) {
                                s1Var.E(Q, p(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (y(t, length)) {
                                s1Var.p(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (y(t, length)) {
                                s1Var.n(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (y(t, length)) {
                                s1Var.t(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (y(t, length)) {
                                s1Var.h(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (y(t, length)) {
                                s1Var.d(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (y(t, length)) {
                                s1Var.q(Q, k(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (y(t, length)) {
                                n0(Q, p1.A(t, R(i0)), s1Var);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (y(t, length)) {
                                s1Var.z(Q, p1.A(t, R(i0)), s(length));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (y(t, length)) {
                                s1Var.w(Q, (h) p1.A(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (y(t, length)) {
                                s1Var.b(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (y(t, length)) {
                                s1Var.H(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (y(t, length)) {
                                s1Var.r(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (y(t, length)) {
                                s1Var.x(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (y(t, length)) {
                                s1Var.M(Q, w(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (y(t, length)) {
                                s1Var.D(Q, H(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (y(t, length)) {
                                s1Var.O(Q, p1.A(t, R(i0)), s(length));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            h1.P(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 19:
                            h1.T(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 20:
                            h1.W(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 21:
                            h1.e0(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 22:
                            h1.V(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 23:
                            h1.S(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 24:
                            h1.R(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 25:
                            h1.N(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 26:
                            h1.c0(Q(length), (List) p1.A(t, R(i0)), s1Var);
                            break;
                        case 27:
                            h1.X(Q(length), (List) p1.A(t, R(i0)), s1Var, s(length));
                            break;
                        case 28:
                            h1.O(Q(length), (List) p1.A(t, R(i0)), s1Var);
                            break;
                        case 29:
                            h1.d0(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 30:
                            h1.Q(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 31:
                            h1.Y(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 32:
                            h1.Z(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 33:
                            h1.a0(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 34:
                            h1.b0(Q(length), (List) p1.A(t, R(i0)), s1Var, false);
                            break;
                        case 35:
                            h1.P(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 36:
                            h1.T(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 37:
                            h1.W(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 38:
                            h1.e0(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 39:
                            h1.V(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 40:
                            h1.S(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 41:
                            h1.R(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 42:
                            h1.N(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 43:
                            h1.d0(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 44:
                            h1.Q(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 45:
                            h1.Y(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 46:
                            h1.Z(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 47:
                            h1.a0(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 48:
                            h1.b0(Q(length), (List) p1.A(t, R(i0)), s1Var, true);
                            break;
                        case 49:
                            h1.U(Q(length), (List) p1.A(t, R(i0)), s1Var, s(length));
                            break;
                        case 50:
                            m0(s1Var, Q, p1.A(t, R(i0)), length);
                            break;
                        case 51:
                            if (E(t, Q, length)) {
                                s1Var.e(Q, T(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (E(t, Q, length)) {
                                s1Var.E(Q, U(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (E(t, Q, length)) {
                                s1Var.p(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (E(t, Q, length)) {
                                s1Var.n(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (E(t, Q, length)) {
                                s1Var.t(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (E(t, Q, length)) {
                                s1Var.h(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (E(t, Q, length)) {
                                s1Var.d(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (E(t, Q, length)) {
                                s1Var.q(Q, S(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (E(t, Q, length)) {
                                n0(Q, p1.A(t, R(i0)), s1Var);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (E(t, Q, length)) {
                                s1Var.z(Q, p1.A(t, R(i0)), s(length));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (E(t, Q, length)) {
                                s1Var.w(Q, (h) p1.A(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (E(t, Q, length)) {
                                s1Var.b(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 63:
                            if (E(t, Q, length)) {
                                s1Var.H(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 64:
                            if (E(t, Q, length)) {
                                s1Var.r(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (E(t, Q, length)) {
                                s1Var.x(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (E(t, Q, length)) {
                                s1Var.M(Q, V(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (E(t, Q, length)) {
                                s1Var.D(Q, W(t, R(i0)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (E(t, Q, length)) {
                                s1Var.O(Q, p1.A(t, R(i0)), s(length));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.r.j(s1Var, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    private boolean m(T t, T t2, int i2) {
        int i0 = i0(i2);
        long R = R(i0);
        switch (h0(i0)) {
            case 0:
                return j(t, t2, i2) && Double.doubleToLongBits(p1.v(t, R)) == Double.doubleToLongBits(p1.v(t2, R));
            case 1:
                return j(t, t2, i2) && Float.floatToIntBits(p1.w(t, R)) == Float.floatToIntBits(p1.w(t2, R));
            case 2:
                return j(t, t2, i2) && p1.y(t, R) == p1.y(t2, R);
            case 3:
                return j(t, t2, i2) && p1.y(t, R) == p1.y(t2, R);
            case 4:
                return j(t, t2, i2) && p1.x(t, R) == p1.x(t2, R);
            case 5:
                return j(t, t2, i2) && p1.y(t, R) == p1.y(t2, R);
            case 6:
                return j(t, t2, i2) && p1.x(t, R) == p1.x(t2, R);
            case 7:
                return j(t, t2, i2) && p1.p(t, R) == p1.p(t2, R);
            case 8:
                return j(t, t2, i2) && h1.K(p1.A(t, R), p1.A(t2, R));
            case 9:
                return j(t, t2, i2) && h1.K(p1.A(t, R), p1.A(t2, R));
            case 10:
                return j(t, t2, i2) && h1.K(p1.A(t, R), p1.A(t2, R));
            case 11:
                return j(t, t2, i2) && p1.x(t, R) == p1.x(t2, R);
            case 12:
                return j(t, t2, i2) && p1.x(t, R) == p1.x(t2, R);
            case 13:
                return j(t, t2, i2) && p1.x(t, R) == p1.x(t2, R);
            case 14:
                return j(t, t2, i2) && p1.y(t, R) == p1.y(t2, R);
            case 15:
                return j(t, t2, i2) && p1.x(t, R) == p1.x(t2, R);
            case 16:
                return j(t, t2, i2) && p1.y(t, R) == p1.y(t2, R);
            case 17:
                return j(t, t2, i2) && h1.K(p1.A(t, R), p1.A(t2, R));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return h1.K(p1.A(t, R), p1.A(t2, R));
            case 50:
                return h1.K(p1.A(t, R), p1.A(t2, R));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return D(t, t2, i2) && h1.K(p1.A(t, R), p1.A(t2, R));
            default:
                return true;
        }
    }

    private <K, V> void m0(s1 s1Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            s1Var.L(i2, this.s.c(r(i3)), this.s.h(obj));
        }
    }

    private final <UT, UB> UB n(Object obj, int i2, UB ub, l1<UT, UB> l1Var) {
        a0.e q;
        int Q = Q(i2);
        Object A = p1.A(obj, R(i0(i2)));
        return (A == null || (q = q(i2)) == null) ? ub : (UB) o(i2, Q, this.s.d(A), q, ub, l1Var);
    }

    private void n0(int i2, Object obj, s1 s1Var) throws IOException {
        if (obj instanceof String) {
            s1Var.m(i2, (String) obj);
        } else {
            s1Var.w(i2, (h) obj);
        }
    }

    private final <K, V, UT, UB> UB o(int i2, int i3, Map<K, V> map, a0.e eVar, UB ub, l1<UT, UB> l1Var) {
        j0.a<?, ?> c2 = this.s.c(r(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = l1Var.n();
                }
                h.C0033h u = h.u(j0.b(c2, next.getKey(), next.getValue()));
                try {
                    j0.e(u.b(), c2, next.getKey(), next.getValue());
                    l1Var.d(ub, i3, u.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private <UT, UB> void o0(l1<UT, UB> l1Var, T t, s1 s1Var) throws IOException {
        l1Var.t(l1Var.g(t), s1Var);
    }

    private static <T> float p(T t, long j2) {
        return p1.w(t, j2);
    }

    private a0.e q(int i2) {
        return (a0.e) this.f1415d[((i2 / 3) * 2) + 1];
    }

    private Object r(int i2) {
        return this.f1415d[(i2 / 3) * 2];
    }

    private f1 s(int i2) {
        int i3 = (i2 / 3) * 2;
        f1 f1Var = (f1) this.f1415d[i3];
        if (f1Var != null) {
            return f1Var;
        }
        f1<T> d2 = b1.a().d((Class) this.f1415d[i3 + 1]);
        this.f1415d[i3] = d2;
        return d2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0060. Please report as an issue. */
    private int t(T t) {
        int i2;
        int i3;
        int i4;
        int d2;
        int L;
        int i5;
        int V;
        int X;
        Unsafe unsafe = f1413b;
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < this.f1414c.length) {
            int i0 = i0(i7);
            int Q = Q(i7);
            int h0 = h0(i0);
            if (h0 <= 17) {
                i2 = this.f1414c[i7 + 2];
                int i10 = 1048575 & i2;
                int i11 = 1 << (i2 >>> 20);
                if (i10 != i6) {
                    i9 = unsafe.getInt(t, i10);
                    i6 = i10;
                }
                i3 = i11;
            } else {
                i2 = (!this.f1422k || h0 < v.O.g() || h0 > v.b0.g()) ? 0 : this.f1414c[i7 + 2] & 1048575;
                i3 = 0;
            }
            long R = R(i0);
            int i12 = i6;
            switch (h0) {
                case 0:
                    if ((i9 & i3) == 0) {
                        break;
                    } else {
                        i4 = CodedOutputStream.i(Q, 0.0d);
                        i8 += i4;
                        break;
                    }
                case 1:
                    if ((i9 & i3) == 0) {
                        break;
                    } else {
                        i4 = CodedOutputStream.q(Q, 0.0f);
                        i8 += i4;
                        break;
                    }
                case 2:
                    if ((i9 & i3) == 0) {
                        break;
                    } else {
                        i4 = CodedOutputStream.x(Q, unsafe.getLong(t, R));
                        i8 += i4;
                        break;
                    }
                case 3:
                    if ((i9 & i3) == 0) {
                        break;
                    } else {
                        i4 = CodedOutputStream.Y(Q, unsafe.getLong(t, R));
                        i8 += i4;
                        break;
                    }
                case 4:
                    if ((i9 & i3) == 0) {
                        break;
                    } else {
                        i4 = CodedOutputStream.v(Q, unsafe.getInt(t, R));
                        i8 += i4;
                        break;
                    }
                case 5:
                    if ((i9 & i3) == 0) {
                        break;
                    } else {
                        i4 = CodedOutputStream.o(Q, 0L);
                        i8 += i4;
                        break;
                    }
                case 6:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.m(Q, 0);
                        i8 += i4;
                        break;
                    }
                    break;
                case 7:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.d(Q, true);
                        i8 += d2;
                    }
                    break;
                case 8:
                    if ((i9 & i3) != 0) {
                        Object object = unsafe.getObject(t, R);
                        if (object instanceof h) {
                            d2 = CodedOutputStream.g(Q, (h) object);
                        } else {
                            d2 = CodedOutputStream.T(Q, (String) object);
                        }
                        i8 += d2;
                    }
                    break;
                case 9:
                    if ((i9 & i3) != 0) {
                        d2 = h1.o(Q, unsafe.getObject(t, R), s(i7));
                        i8 += d2;
                    }
                    break;
                case 10:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.g(Q, (h) unsafe.getObject(t, R));
                        i8 += d2;
                    }
                    break;
                case 11:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.W(Q, unsafe.getInt(t, R));
                        i8 += d2;
                    }
                    break;
                case 12:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.k(Q, unsafe.getInt(t, R));
                        i8 += d2;
                    }
                    break;
                case 13:
                    if ((i9 & i3) != 0) {
                        L = CodedOutputStream.L(Q, 0);
                        i8 += L;
                    }
                    break;
                case 14:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.N(Q, 0L);
                        i8 += d2;
                    }
                    break;
                case 15:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.P(Q, unsafe.getInt(t, R));
                        i8 += d2;
                    }
                    break;
                case 16:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.R(Q, unsafe.getLong(t, R));
                        i8 += d2;
                    }
                    break;
                case 17:
                    if ((i9 & i3) != 0) {
                        d2 = CodedOutputStream.s(Q, (q0) unsafe.getObject(t, R), s(i7));
                        i8 += d2;
                    }
                    break;
                case 18:
                    d2 = h1.h(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 19:
                    d2 = h1.f(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 20:
                    d2 = h1.m(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 21:
                    d2 = h1.x(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 22:
                    d2 = h1.k(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 23:
                    d2 = h1.h(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 24:
                    d2 = h1.f(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 25:
                    d2 = h1.a(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 26:
                    d2 = h1.u(Q, (List) unsafe.getObject(t, R));
                    i8 += d2;
                    break;
                case 27:
                    d2 = h1.p(Q, (List) unsafe.getObject(t, R), s(i7));
                    i8 += d2;
                    break;
                case 28:
                    d2 = h1.c(Q, (List) unsafe.getObject(t, R));
                    i8 += d2;
                    break;
                case 29:
                    d2 = h1.v(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 30:
                    d2 = h1.d(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 31:
                    d2 = h1.f(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 32:
                    d2 = h1.h(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 33:
                    d2 = h1.q(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 34:
                    d2 = h1.s(Q, (List) unsafe.getObject(t, R), false);
                    i8 += d2;
                    break;
                case 35:
                    i5 = h1.i((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 36:
                    i5 = h1.g((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 37:
                    i5 = h1.n((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 38:
                    i5 = h1.y((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 39:
                    i5 = h1.l((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 40:
                    i5 = h1.i((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 41:
                    i5 = h1.g((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 42:
                    i5 = h1.b((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 43:
                    i5 = h1.w((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 44:
                    i5 = h1.e((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 45:
                    i5 = h1.g((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 46:
                    i5 = h1.i((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 47:
                    i5 = h1.r((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 48:
                    i5 = h1.t((List) unsafe.getObject(t, R));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i5);
                        L = V + X + i5;
                        i8 += L;
                    }
                    break;
                case 49:
                    d2 = h1.j(Q, (List) unsafe.getObject(t, R), s(i7));
                    i8 += d2;
                    break;
                case 50:
                    d2 = this.s.f(Q, unsafe.getObject(t, R), r(i7));
                    i8 += d2;
                    break;
                case 51:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.i(Q, 0.0d);
                        i8 += d2;
                    }
                    break;
                case 52:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.q(Q, 0.0f);
                        i8 += d2;
                    }
                    break;
                case 53:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.x(Q, W(t, R));
                        i8 += d2;
                    }
                    break;
                case 54:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.Y(Q, W(t, R));
                        i8 += d2;
                    }
                    break;
                case 55:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.v(Q, V(t, R));
                        i8 += d2;
                    }
                    break;
                case 56:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.o(Q, 0L);
                        i8 += d2;
                    }
                    break;
                case 57:
                    if (E(t, Q, i7)) {
                        L = CodedOutputStream.m(Q, 0);
                        i8 += L;
                    }
                    break;
                case 58:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.d(Q, true);
                        i8 += d2;
                    }
                    break;
                case 59:
                    if (E(t, Q, i7)) {
                        Object object2 = unsafe.getObject(t, R);
                        if (object2 instanceof h) {
                            d2 = CodedOutputStream.g(Q, (h) object2);
                        } else {
                            d2 = CodedOutputStream.T(Q, (String) object2);
                        }
                        i8 += d2;
                    }
                    break;
                case 60:
                    if (E(t, Q, i7)) {
                        d2 = h1.o(Q, unsafe.getObject(t, R), s(i7));
                        i8 += d2;
                    }
                    break;
                case 61:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.g(Q, (h) unsafe.getObject(t, R));
                        i8 += d2;
                    }
                    break;
                case 62:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.W(Q, V(t, R));
                        i8 += d2;
                    }
                    break;
                case 63:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.k(Q, V(t, R));
                        i8 += d2;
                    }
                    break;
                case 64:
                    if (E(t, Q, i7)) {
                        L = CodedOutputStream.L(Q, 0);
                        i8 += L;
                    }
                    break;
                case 65:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.N(Q, 0L);
                        i8 += d2;
                    }
                    break;
                case 66:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.P(Q, V(t, R));
                        i8 += d2;
                    }
                    break;
                case 67:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.R(Q, W(t, R));
                        i8 += d2;
                    }
                    break;
                case 68:
                    if (E(t, Q, i7)) {
                        d2 = CodedOutputStream.s(Q, (q0) unsafe.getObject(t, R), s(i7));
                        i8 += d2;
                    }
                    break;
            }
            i7 += 3;
            i6 = i12;
        }
        int v = i8 + v(this.q, t);
        return this.f1419h ? v + this.r.c(t).l() : v;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x003d. Please report as an issue. */
    private int u(T t) {
        int i2;
        int i3;
        int V;
        int X;
        Unsafe unsafe = f1413b;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f1414c.length; i5 += 3) {
            int i0 = i0(i5);
            int h0 = h0(i0);
            int Q = Q(i5);
            long R = R(i0);
            int i6 = (h0 < v.O.g() || h0 > v.b0.g()) ? 0 : this.f1414c[i5 + 2] & 1048575;
            switch (h0) {
                case 0:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.i(Q, 0.0d);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.q(Q, 0.0f);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.x(Q, p1.y(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.Y(Q, p1.y(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.v(Q, p1.x(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.o(Q, 0L);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.m(Q, 0);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.d(Q, true);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (y(t, i5)) {
                        Object A = p1.A(t, R);
                        if (A instanceof h) {
                            i2 = CodedOutputStream.g(Q, (h) A);
                        } else {
                            i2 = CodedOutputStream.T(Q, (String) A);
                        }
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (y(t, i5)) {
                        i2 = h1.o(Q, p1.A(t, R), s(i5));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.g(Q, (h) p1.A(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.W(Q, p1.x(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.k(Q, p1.x(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.L(Q, 0);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.N(Q, 0L);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.P(Q, p1.x(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.R(Q, p1.y(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.s(Q, (q0) p1.A(t, R), s(i5));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i2 = h1.h(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 19:
                    i2 = h1.f(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 20:
                    i2 = h1.m(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 21:
                    i2 = h1.x(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 22:
                    i2 = h1.k(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 23:
                    i2 = h1.h(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 24:
                    i2 = h1.f(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 25:
                    i2 = h1.a(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 26:
                    i2 = h1.u(Q, G(t, R));
                    i4 += i2;
                    break;
                case 27:
                    i2 = h1.p(Q, G(t, R), s(i5));
                    i4 += i2;
                    break;
                case 28:
                    i2 = h1.c(Q, G(t, R));
                    i4 += i2;
                    break;
                case 29:
                    i2 = h1.v(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 30:
                    i2 = h1.d(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 31:
                    i2 = h1.f(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 32:
                    i2 = h1.h(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 33:
                    i2 = h1.q(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 34:
                    i2 = h1.s(Q, G(t, R), false);
                    i4 += i2;
                    break;
                case 35:
                    i3 = h1.i((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 36:
                    i3 = h1.g((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 37:
                    i3 = h1.n((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 38:
                    i3 = h1.y((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 39:
                    i3 = h1.l((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 40:
                    i3 = h1.i((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 41:
                    i3 = h1.g((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 42:
                    i3 = h1.b((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 43:
                    i3 = h1.w((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 44:
                    i3 = h1.e((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 45:
                    i3 = h1.g((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 46:
                    i3 = h1.i((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 47:
                    i3 = h1.r((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 48:
                    i3 = h1.t((List) unsafe.getObject(t, R));
                    if (i3 <= 0) {
                        break;
                    } else {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        V = CodedOutputStream.V(Q);
                        X = CodedOutputStream.X(i3);
                        i2 = V + X + i3;
                        i4 += i2;
                        break;
                    }
                case 49:
                    i2 = h1.j(Q, G(t, R), s(i5));
                    i4 += i2;
                    break;
                case 50:
                    i2 = this.s.f(Q, p1.A(t, R), r(i5));
                    i4 += i2;
                    break;
                case 51:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.i(Q, 0.0d);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.q(Q, 0.0f);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.x(Q, W(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.Y(Q, W(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.v(Q, V(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.o(Q, 0L);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.m(Q, 0);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.d(Q, true);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (E(t, Q, i5)) {
                        Object A2 = p1.A(t, R);
                        if (A2 instanceof h) {
                            i2 = CodedOutputStream.g(Q, (h) A2);
                        } else {
                            i2 = CodedOutputStream.T(Q, (String) A2);
                        }
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (E(t, Q, i5)) {
                        i2 = h1.o(Q, p1.A(t, R), s(i5));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.g(Q, (h) p1.A(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.W(Q, V(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.k(Q, V(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.L(Q, 0);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.N(Q, 0L);
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.P(Q, V(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.R(Q, W(t, R));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (E(t, Q, i5)) {
                        i2 = CodedOutputStream.s(Q, (q0) p1.A(t, R), s(i5));
                        i4 += i2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i4 + v(this.q, t);
    }

    private <UT, UB> int v(l1<UT, UB> l1Var, T t) {
        return l1Var.h(l1Var.g(t));
    }

    private static <T> int w(T t, long j2) {
        return p1.x(t, j2);
    }

    private static boolean x(int i2) {
        return (i2 & 536870912) != 0;
    }

    private boolean y(T t, int i2) {
        if (this.f1421j) {
            int i0 = i0(i2);
            long R = R(i0);
            switch (h0(i0)) {
                case 0:
                    return p1.v(t, R) != 0.0d;
                case 1:
                    return p1.w(t, R) != 0.0f;
                case 2:
                    return p1.y(t, R) != 0;
                case 3:
                    return p1.y(t, R) != 0;
                case 4:
                    return p1.x(t, R) != 0;
                case 5:
                    return p1.y(t, R) != 0;
                case 6:
                    return p1.x(t, R) != 0;
                case 7:
                    return p1.p(t, R);
                case 8:
                    Object A = p1.A(t, R);
                    if (A instanceof String) {
                        return !((String) A).isEmpty();
                    }
                    if (A instanceof h) {
                        return !h.f1298f.equals(A);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return p1.A(t, R) != null;
                case 10:
                    return !h.f1298f.equals(p1.A(t, R));
                case 11:
                    return p1.x(t, R) != 0;
                case 12:
                    return p1.x(t, R) != 0;
                case 13:
                    return p1.x(t, R) != 0;
                case 14:
                    return p1.y(t, R) != 0;
                case 15:
                    return p1.x(t, R) != 0;
                case 16:
                    return p1.y(t, R) != 0;
                case 17:
                    return p1.A(t, R) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int Y = Y(i2);
        return (p1.x(t, (long) (Y & 1048575)) & (1 << (Y >>> 20))) != 0;
    }

    private boolean z(T t, int i2, int i3, int i4) {
        if (this.f1421j) {
            return y(t, i2);
        }
        return (i3 & i4) != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void a(T t, T t2) {
        t2.getClass();
        for (int i2 = 0; i2 < this.f1414c.length; i2 += 3) {
            M(t, t2, i2);
        }
        if (this.f1421j) {
            return;
        }
        h1.G(this.q, t, t2);
        if (this.f1419h) {
            h1.E(this.r, t, t2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public boolean b(T t, T t2) {
        int length = this.f1414c.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            if (!m(t, t2, i2)) {
                return false;
            }
        }
        if (!this.q.g(t).equals(this.q.g(t2))) {
            return false;
        }
        if (this.f1419h) {
            return this.r.c(t).equals(this.r.c(t2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public T c() {
        return (T) this.o.a(this.f1418g);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.f1
    public int d(T t) {
        int i2;
        int f2;
        int length = this.f1414c.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int i0 = i0(i4);
            int Q = Q(i4);
            long R = R(i0);
            int i5 = 37;
            switch (h0(i0)) {
                case 0:
                    i2 = i3 * 53;
                    f2 = a0.f(Double.doubleToLongBits(p1.v(t, R)));
                    i3 = i2 + f2;
                    break;
                case 1:
                    i2 = i3 * 53;
                    f2 = Float.floatToIntBits(p1.w(t, R));
                    i3 = i2 + f2;
                    break;
                case 2:
                    i2 = i3 * 53;
                    f2 = a0.f(p1.y(t, R));
                    i3 = i2 + f2;
                    break;
                case 3:
                    i2 = i3 * 53;
                    f2 = a0.f(p1.y(t, R));
                    i3 = i2 + f2;
                    break;
                case 4:
                    i2 = i3 * 53;
                    f2 = p1.x(t, R);
                    i3 = i2 + f2;
                    break;
                case 5:
                    i2 = i3 * 53;
                    f2 = a0.f(p1.y(t, R));
                    i3 = i2 + f2;
                    break;
                case 6:
                    i2 = i3 * 53;
                    f2 = p1.x(t, R);
                    i3 = i2 + f2;
                    break;
                case 7:
                    i2 = i3 * 53;
                    f2 = a0.c(p1.p(t, R));
                    i3 = i2 + f2;
                    break;
                case 8:
                    i2 = i3 * 53;
                    f2 = ((String) p1.A(t, R)).hashCode();
                    i3 = i2 + f2;
                    break;
                case 9:
                    Object A = p1.A(t, R);
                    if (A != null) {
                        i5 = A.hashCode();
                    }
                    i3 = (i3 * 53) + i5;
                    break;
                case 10:
                    i2 = i3 * 53;
                    f2 = p1.A(t, R).hashCode();
                    i3 = i2 + f2;
                    break;
                case 11:
                    i2 = i3 * 53;
                    f2 = p1.x(t, R);
                    i3 = i2 + f2;
                    break;
                case 12:
                    i2 = i3 * 53;
                    f2 = p1.x(t, R);
                    i3 = i2 + f2;
                    break;
                case 13:
                    i2 = i3 * 53;
                    f2 = p1.x(t, R);
                    i3 = i2 + f2;
                    break;
                case 14:
                    i2 = i3 * 53;
                    f2 = a0.f(p1.y(t, R));
                    i3 = i2 + f2;
                    break;
                case 15:
                    i2 = i3 * 53;
                    f2 = p1.x(t, R);
                    i3 = i2 + f2;
                    break;
                case 16:
                    i2 = i3 * 53;
                    f2 = a0.f(p1.y(t, R));
                    i3 = i2 + f2;
                    break;
                case 17:
                    Object A2 = p1.A(t, R);
                    if (A2 != null) {
                        i5 = A2.hashCode();
                    }
                    i3 = (i3 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    f2 = p1.A(t, R).hashCode();
                    i3 = i2 + f2;
                    break;
                case 50:
                    i2 = i3 * 53;
                    f2 = p1.A(t, R).hashCode();
                    i3 = i2 + f2;
                    break;
                case 51:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = a0.f(Double.doubleToLongBits(T(t, R)));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = Float.floatToIntBits(U(t, R));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = a0.f(W(t, R));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = a0.f(W(t, R));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = V(t, R);
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = a0.f(W(t, R));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = V(t, R);
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = a0.c(S(t, R));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = ((String) p1.A(t, R)).hashCode();
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = p1.A(t, R).hashCode();
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = p1.A(t, R).hashCode();
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = V(t, R);
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = V(t, R);
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = V(t, R);
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = a0.f(W(t, R));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = V(t, R);
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = a0.f(W(t, R));
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (E(t, Q, i4)) {
                        i2 = i3 * 53;
                        f2 = p1.A(t, R).hashCode();
                        i3 = i2 + f2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.q.g(t).hashCode();
        return this.f1419h ? (hashCode * 53) + this.r.c(t).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void e(T t, e1 e1Var, p pVar) throws IOException {
        pVar.getClass();
        I(this.q, this.r, t, e1Var, pVar);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void f(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long R = R(i0(this.l[i3]));
            Object A = p1.A(t, R);
            if (A != null) {
                p1.O(t, R, this.s.b(A));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.c(t, this.l[i2]);
            i2++;
        }
        this.q.j(t);
        if (this.f1419h) {
            this.r.f(t);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final boolean g(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.m; i5++) {
            int i6 = this.l[i5];
            int Q = Q(i6);
            int i0 = i0(i6);
            if (this.f1421j) {
                i2 = 0;
            } else {
                int i7 = this.f1414c[i6 + 2];
                int i8 = 1048575 & i7;
                i2 = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = f1413b.getInt(t, i8);
                    i3 = i8;
                }
            }
            if (F(i0) && !z(t, i6, i4, i2)) {
                return false;
            }
            int h0 = h0(i0);
            if (h0 != 9 && h0 != 17) {
                if (h0 != 27) {
                    if (h0 == 60 || h0 == 68) {
                        if (E(t, Q, i6) && !A(t, i0, s(i6))) {
                            return false;
                        }
                    } else if (h0 != 49) {
                        if (h0 == 50 && !C(t, i0, i6)) {
                            return false;
                        }
                    }
                }
                if (!B(t, i0, i6)) {
                    return false;
                }
            } else if (z(t, i6, i4, i2) && !A(t, i0, s(i6))) {
                return false;
            }
        }
        return !this.f1419h || this.r.c(t).p();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void h(T t, s1 s1Var) throws IOException {
        if (s1Var.i() == s1.a.DESCENDING) {
            l0(t, s1Var);
        } else if (this.f1421j) {
            k0(t, s1Var);
        } else {
            j0(t, s1Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public int i(T t) {
        return this.f1421j ? u(t) : t(t);
    }
}
