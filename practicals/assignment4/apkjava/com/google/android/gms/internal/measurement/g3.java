package com.google.android.gms.internal.measurement;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class g3<T> implements p3<T> {
    private static final int[] a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f17156b = k4.t();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f17157c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f17158d;

    /* renamed from: e, reason: collision with root package name */
    private final int f17159e;

    /* renamed from: f, reason: collision with root package name */
    private final int f17160f;

    /* renamed from: g, reason: collision with root package name */
    private final zzgo f17161g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f17162h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f17163i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f17164j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f17165k;
    private final int[] l;
    private final int m;
    private final int n;
    private final j3 o;
    private final s2 p;
    private final h4<?, ?> q;
    private final d2<?> r;
    private final a3 s;

    private g3(int[] iArr, Object[] objArr, int i2, int i3, zzgo zzgoVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, j3 j3Var, s2 s2Var, h4<?, ?> h4Var, d2<?> d2Var, a3 a3Var) {
        this.f17157c = iArr;
        this.f17158d = objArr;
        this.f17159e = i2;
        this.f17160f = i3;
        this.f17163i = zzgoVar instanceof zzfd;
        this.f17164j = z;
        this.f17162h = d2Var != null && d2Var.h(zzgoVar);
        this.f17165k = false;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = j3Var;
        this.p = s2Var;
        this.q = h4Var;
        this.r = d2Var;
        this.f17161g = zzgoVar;
        this.s = a3Var;
    }

    private final void A(T t, T t2, int i2) {
        long P = P(i2) & 1048575;
        if (B(t2, i2)) {
            Object F = k4.F(t, P);
            Object F2 = k4.F(t2, P);
            if (F != null && F2 != null) {
                k4.j(t, P, zzff.e(F, F2));
                I(t, i2);
            } else if (F2 != null) {
                k4.j(t, P, F2);
                I(t, i2);
            }
        }
    }

    private final boolean B(T t, int i2) {
        if (this.f17164j) {
            int P = P(i2);
            long j2 = P & 1048575;
            switch ((P & 267386880) >>> 20) {
                case 0:
                    return k4.C(t, j2) != 0.0d;
                case 1:
                    return k4.x(t, j2) != 0.0f;
                case 2:
                    return k4.o(t, j2) != 0;
                case 3:
                    return k4.o(t, j2) != 0;
                case 4:
                    return k4.b(t, j2) != 0;
                case 5:
                    return k4.o(t, j2) != 0;
                case 6:
                    return k4.b(t, j2) != 0;
                case 7:
                    return k4.w(t, j2);
                case 8:
                    Object F = k4.F(t, j2);
                    if (F instanceof String) {
                        return !((String) F).isEmpty();
                    }
                    if (F instanceof zzdu) {
                        return !zzdu.f17368f.equals(F);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return k4.F(t, j2) != null;
                case 10:
                    return !zzdu.f17368f.equals(k4.F(t, j2));
                case 11:
                    return k4.b(t, j2) != 0;
                case 12:
                    return k4.b(t, j2) != 0;
                case 13:
                    return k4.b(t, j2) != 0;
                case 14:
                    return k4.o(t, j2) != 0;
                case 15:
                    return k4.b(t, j2) != 0;
                case 16:
                    return k4.o(t, j2) != 0;
                case 17:
                    return k4.F(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int R = R(i2);
        return (k4.b(t, (long) (R & 1048575)) & (1 << (R >>> 20))) != 0;
    }

    private final boolean C(T t, int i2, int i3) {
        return k4.b(t, (long) (R(i3) & 1048575)) == i2;
    }

    private final boolean D(T t, int i2, int i3, int i4) {
        if (this.f17164j) {
            return B(t, i2);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean E(Object obj, int i2, p3 p3Var) {
        return p3Var.e(k4.F(obj, i2 & 1048575));
    }

    private static <T> double F(T t, long j2) {
        return ((Double) k4.F(t, j2)).doubleValue();
    }

    private final int G(int i2, int i3) {
        int length = (this.f17157c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f17157c[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private final Object H(int i2) {
        return this.f17158d[(i2 / 3) << 1];
    }

    private final void I(T t, int i2) {
        if (this.f17164j) {
            return;
        }
        int R = R(i2);
        long j2 = R & 1048575;
        k4.h(t, j2, k4.b(t, j2) | (1 << (R >>> 20)));
    }

    private final void J(T t, int i2, int i3) {
        k4.h(t, R(i3) & 1048575, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void K(T t, y4 y4Var) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i2;
        int i3;
        int i4;
        if (this.f17162h) {
            h2<?> b2 = this.r.b(t);
            if (!b2.f17168b.isEmpty()) {
                it = b2.o();
                entry = (Map.Entry) it.next();
                int i5 = -1;
                length = this.f17157c.length;
                Unsafe unsafe = f17156b;
                i2 = 0;
                int i6 = 0;
                while (i2 < length) {
                    int P = P(i2);
                    int[] iArr = this.f17157c;
                    int i7 = iArr[i2];
                    int i8 = (267386880 & P) >>> 20;
                    if (this.f17164j || i8 > 17) {
                        i3 = i2;
                        i4 = 0;
                    } else {
                        int i9 = iArr[i2 + 2];
                        int i10 = i9 & 1048575;
                        i3 = i2;
                        if (i10 != i5) {
                            i6 = unsafe.getInt(t, i10);
                            i5 = i10;
                        }
                        i4 = 1 << (i9 >>> 20);
                    }
                    while (entry != null && this.r.a(entry) <= i7) {
                        this.r.g(y4Var, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    long j2 = P & 1048575;
                    int i11 = i3;
                    switch (i8) {
                        case 0:
                            if ((i4 & i6) == 0) {
                                break;
                            } else {
                                y4Var.h(i7, k4.C(t, j2));
                                continue;
                            }
                        case 1:
                            if ((i4 & i6) != 0) {
                                y4Var.r(i7, k4.x(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i4 & i6) != 0) {
                                y4Var.q(i7, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i4 & i6) != 0) {
                                y4Var.c(i7, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i4 & i6) != 0) {
                                y4Var.G(i7, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i4 & i6) != 0) {
                                y4Var.L(i7, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i4 & i6) != 0) {
                                y4Var.y(i7, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i4 & i6) != 0) {
                                y4Var.B(i7, k4.w(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i4 & i6) != 0) {
                                w(i7, unsafe.getObject(t, j2), y4Var);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i4 & i6) != 0) {
                                y4Var.C(i7, unsafe.getObject(t, j2), r(i11));
                                break;
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i4 & i6) != 0) {
                                y4Var.E(i7, (zzdu) unsafe.getObject(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i4 & i6) != 0) {
                                y4Var.M(i7, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i4 & i6) != 0) {
                                y4Var.D(i7, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i4 & i6) != 0) {
                                y4Var.H(i7, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i4 & i6) != 0) {
                                y4Var.b(i7, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i4 & i6) != 0) {
                                y4Var.J(i7, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i4 & i6) != 0) {
                                y4Var.N(i7, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i4 & i6) != 0) {
                                y4Var.F(i7, unsafe.getObject(t, j2), r(i11));
                                break;
                            } else {
                                continue;
                            }
                        case 18:
                            r3.l(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 19:
                            r3.y(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 20:
                            r3.C(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 21:
                            r3.G(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 22:
                            r3.T(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 23:
                            r3.N(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 24:
                            r3.a0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 25:
                            r3.d0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 26:
                            r3.j(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var);
                            break;
                        case 27:
                            r3.k(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, r(i11));
                            break;
                        case 28:
                            r3.w(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var);
                            break;
                        case 29:
                            r3.W(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 30:
                            r3.c0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 31:
                            r3.b0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 32:
                            r3.Q(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 33:
                            r3.Z(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 34:
                            r3.K(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, false);
                            continue;
                        case 35:
                            r3.l(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 36:
                            r3.y(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 37:
                            r3.C(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 38:
                            r3.G(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 39:
                            r3.T(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 40:
                            r3.N(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 41:
                            r3.a0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 42:
                            r3.d0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 43:
                            r3.W(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 44:
                            r3.c0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 45:
                            r3.b0(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 46:
                            r3.Q(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 47:
                            r3.Z(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 48:
                            r3.K(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, true);
                            break;
                        case 49:
                            r3.x(this.f17157c[i11], (List) unsafe.getObject(t, j2), y4Var, r(i11));
                            break;
                        case 50:
                            y(y4Var, i7, unsafe.getObject(t, j2), i11);
                            break;
                        case 51:
                            if (C(t, i7, i11)) {
                                y4Var.h(i7, F(t, j2));
                                break;
                            }
                            break;
                        case 52:
                            if (C(t, i7, i11)) {
                                y4Var.r(i7, M(t, j2));
                                break;
                            }
                            break;
                        case 53:
                            if (C(t, i7, i11)) {
                                y4Var.q(i7, S(t, j2));
                                break;
                            }
                            break;
                        case 54:
                            if (C(t, i7, i11)) {
                                y4Var.c(i7, S(t, j2));
                                break;
                            }
                            break;
                        case 55:
                            if (C(t, i7, i11)) {
                                y4Var.G(i7, Q(t, j2));
                                break;
                            }
                            break;
                        case 56:
                            if (C(t, i7, i11)) {
                                y4Var.L(i7, S(t, j2));
                                break;
                            }
                            break;
                        case 57:
                            if (C(t, i7, i11)) {
                                y4Var.y(i7, Q(t, j2));
                                break;
                            }
                            break;
                        case 58:
                            if (C(t, i7, i11)) {
                                y4Var.B(i7, V(t, j2));
                                break;
                            }
                            break;
                        case 59:
                            if (C(t, i7, i11)) {
                                w(i7, unsafe.getObject(t, j2), y4Var);
                                break;
                            }
                            break;
                        case 60:
                            if (C(t, i7, i11)) {
                                y4Var.C(i7, unsafe.getObject(t, j2), r(i11));
                                break;
                            }
                            break;
                        case 61:
                            if (C(t, i7, i11)) {
                                y4Var.E(i7, (zzdu) unsafe.getObject(t, j2));
                                break;
                            }
                            break;
                        case 62:
                            if (C(t, i7, i11)) {
                                y4Var.M(i7, Q(t, j2));
                                break;
                            }
                            break;
                        case 63:
                            if (C(t, i7, i11)) {
                                y4Var.D(i7, Q(t, j2));
                                break;
                            }
                            break;
                        case 64:
                            if (C(t, i7, i11)) {
                                y4Var.H(i7, Q(t, j2));
                                break;
                            }
                            break;
                        case 65:
                            if (C(t, i7, i11)) {
                                y4Var.b(i7, S(t, j2));
                                break;
                            }
                            break;
                        case 66:
                            if (C(t, i7, i11)) {
                                y4Var.J(i7, Q(t, j2));
                                break;
                            }
                            break;
                        case 67:
                            if (C(t, i7, i11)) {
                                y4Var.N(i7, S(t, j2));
                                break;
                            }
                            break;
                        case 68:
                            if (C(t, i7, i11)) {
                                y4Var.F(i7, unsafe.getObject(t, j2), r(i11));
                                break;
                            }
                            break;
                    }
                    i2 = i11 + 3;
                }
                while (entry != null) {
                    this.r.g(y4Var, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                x(this.q, t, y4Var);
            }
        }
        it = null;
        entry = null;
        int i52 = -1;
        length = this.f17157c.length;
        Unsafe unsafe2 = f17156b;
        i2 = 0;
        int i62 = 0;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        x(this.q, t, y4Var);
    }

    private final void L(T t, T t2, int i2) {
        int P = P(i2);
        int i3 = this.f17157c[i2];
        long j2 = P & 1048575;
        if (C(t2, i3, i2)) {
            Object F = k4.F(t, j2);
            Object F2 = k4.F(t2, j2);
            if (F != null && F2 != null) {
                k4.j(t, j2, zzff.e(F, F2));
                J(t, i3, i2);
            } else if (F2 != null) {
                k4.j(t, j2, F2);
                J(t, i3, i2);
            }
        }
    }

    private static <T> float M(T t, long j2) {
        return ((Float) k4.F(t, j2)).floatValue();
    }

    private final zzfk N(int i2) {
        return (zzfk) this.f17158d[((i2 / 3) << 1) + 1];
    }

    private final boolean O(T t, T t2, int i2) {
        return B(t, i2) == B(t2, i2);
    }

    private final int P(int i2) {
        return this.f17157c[i2 + 1];
    }

    private static <T> int Q(T t, long j2) {
        return ((Integer) k4.F(t, j2)).intValue();
    }

    private final int R(int i2) {
        return this.f17157c[i2 + 2];
    }

    private static <T> long S(T t, long j2) {
        return ((Long) k4.F(t, j2)).longValue();
    }

    private static zzhy T(Object obj) {
        zzfd zzfdVar = (zzfd) obj;
        zzhy zzhyVar = zzfdVar.zzb;
        if (zzhyVar != zzhy.a()) {
            return zzhyVar;
        }
        zzhy g2 = zzhy.g();
        zzfdVar.zzb = g2;
        return g2;
    }

    private static boolean U(int i2) {
        return (i2 & 536870912) != 0;
    }

    private static <T> boolean V(T t, long j2) {
        return ((Boolean) k4.F(t, j2)).booleanValue();
    }

    private final int W(int i2) {
        if (i2 < this.f17159e || i2 > this.f17160f) {
            return -1;
        }
        return G(i2, 0);
    }

    private final int k(int i2, int i3) {
        if (i2 < this.f17159e || i2 > this.f17160f) {
            return -1;
        }
        return G(i2, i3);
    }

    private static <UT, UB> int l(h4<UT, UB> h4Var, T t) {
        return h4Var.s(h4Var.k(t));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int m(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, m1 m1Var) throws IOException {
        int k2;
        Unsafe unsafe = f17156b;
        long j3 = this.f17157c[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(j1.m(bArr, i2)));
                    k2 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(j1.o(bArr, i2)));
                    k2 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    k2 = j1.k(bArr, i2, m1Var);
                    unsafe.putObject(t, j2, Long.valueOf(m1Var.f17218b));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    k2 = j1.i(bArr, i2, m1Var);
                    unsafe.putObject(t, j2, Integer.valueOf(m1Var.a));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(j1.l(bArr, i2)));
                    k2 = i2 + 8;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(j1.h(bArr, i2)));
                    k2 = i2 + 4;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    k2 = j1.k(bArr, i2, m1Var);
                    unsafe.putObject(t, j2, Boolean.valueOf(m1Var.f17218b != 0));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    int i10 = j1.i(bArr, i2, m1Var);
                    int i11 = m1Var.a;
                    if (i11 == 0) {
                        unsafe.putObject(t, j2, HttpUrl.FRAGMENT_ENCODE_SET);
                    } else {
                        if ((i7 & 536870912) != 0 && !n4.g(bArr, i10, i10 + i11)) {
                            throw zzfo.h();
                        }
                        unsafe.putObject(t, j2, new String(bArr, i10, i11, zzff.a));
                        i10 += i11;
                    }
                    unsafe.putInt(t, j3, i5);
                    return i10;
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    int g2 = j1.g(r(i9), bArr, i2, i3, m1Var);
                    Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, m1Var.f17219c);
                    } else {
                        unsafe.putObject(t, j2, zzff.e(object, m1Var.f17219c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return g2;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    k2 = j1.q(bArr, i2, m1Var);
                    unsafe.putObject(t, j2, m1Var.f17219c);
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int i12 = j1.i(bArr, i2, m1Var);
                    int i13 = m1Var.a;
                    zzfk N = N(i9);
                    if (N != null && !N.d(i13)) {
                        T(t).c(i4, Long.valueOf(i13));
                        return i12;
                    }
                    unsafe.putObject(t, j2, Integer.valueOf(i13));
                    k2 = i12;
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    k2 = j1.i(bArr, i2, m1Var);
                    unsafe.putObject(t, j2, Integer.valueOf(zzeg.k(m1Var.a)));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    k2 = j1.k(bArr, i2, m1Var);
                    unsafe.putObject(t, j2, Long.valueOf(zzeg.b(m1Var.f17218b)));
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    k2 = j1.f(r(i9), bArr, i2, i3, (i4 & (-8)) | 4, m1Var);
                    Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, m1Var.f17219c);
                    } else {
                        unsafe.putObject(t, j2, zzff.e(object2, m1Var.f17219c));
                    }
                    unsafe.putInt(t, j3, i5);
                    return k2;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0037. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private final int n(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, m1 m1Var) throws IOException {
        int i9;
        int i10 = i2;
        Unsafe unsafe = f17156b;
        zzfl zzflVar = (zzfl) unsafe.getObject(t, j3);
        if (!zzflVar.a()) {
            int size = zzflVar.size();
            zzflVar = zzflVar.d(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j3, zzflVar);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    b2 b2Var = (b2) zzflVar;
                    int i11 = j1.i(bArr, i10, m1Var);
                    int i12 = m1Var.a + i11;
                    while (i11 < i12) {
                        b2Var.f(j1.m(bArr, i11));
                        i11 += 8;
                    }
                    if (i11 == i12) {
                        return i11;
                    }
                    throw zzfo.a();
                }
                if (i6 == 1) {
                    b2 b2Var2 = (b2) zzflVar;
                    b2Var2.f(j1.m(bArr, i2));
                    while (true) {
                        int i13 = i10 + 8;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i10 = j1.i(bArr, i13, m1Var);
                        if (i4 != m1Var.a) {
                            return i13;
                        }
                        b2Var2.f(j1.m(bArr, i10));
                    }
                }
                return i10;
            case 19:
            case 36:
                if (i6 == 2) {
                    l2 l2Var = (l2) zzflVar;
                    int i14 = j1.i(bArr, i10, m1Var);
                    int i15 = m1Var.a + i14;
                    while (i14 < i15) {
                        l2Var.f(j1.o(bArr, i14));
                        i14 += 4;
                    }
                    if (i14 == i15) {
                        return i14;
                    }
                    throw zzfo.a();
                }
                if (i6 == 5) {
                    l2 l2Var2 = (l2) zzflVar;
                    l2Var2.f(j1.o(bArr, i2));
                    while (true) {
                        int i16 = i10 + 4;
                        if (i16 >= i3) {
                            return i16;
                        }
                        i10 = j1.i(bArr, i16, m1Var);
                        if (i4 != m1Var.a) {
                            return i16;
                        }
                        l2Var2.f(j1.o(bArr, i10));
                    }
                }
                return i10;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    w2 w2Var = (w2) zzflVar;
                    int i17 = j1.i(bArr, i10, m1Var);
                    int i18 = m1Var.a + i17;
                    while (i17 < i18) {
                        i17 = j1.k(bArr, i17, m1Var);
                        w2Var.G0(m1Var.f17218b);
                    }
                    if (i17 == i18) {
                        return i17;
                    }
                    throw zzfo.a();
                }
                if (i6 == 0) {
                    w2 w2Var2 = (w2) zzflVar;
                    int k2 = j1.k(bArr, i10, m1Var);
                    w2Var2.G0(m1Var.f17218b);
                    while (k2 < i3) {
                        int i19 = j1.i(bArr, k2, m1Var);
                        if (i4 != m1Var.a) {
                            return k2;
                        }
                        k2 = j1.k(bArr, i19, m1Var);
                        w2Var2.G0(m1Var.f17218b);
                    }
                    return k2;
                }
                return i10;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return j1.j(bArr, i10, zzflVar, m1Var);
                }
                if (i6 == 0) {
                    return j1.b(i4, bArr, i2, i3, zzflVar, m1Var);
                }
                return i10;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    w2 w2Var3 = (w2) zzflVar;
                    int i20 = j1.i(bArr, i10, m1Var);
                    int i21 = m1Var.a + i20;
                    while (i20 < i21) {
                        w2Var3.G0(j1.l(bArr, i20));
                        i20 += 8;
                    }
                    if (i20 == i21) {
                        return i20;
                    }
                    throw zzfo.a();
                }
                if (i6 == 1) {
                    w2 w2Var4 = (w2) zzflVar;
                    w2Var4.G0(j1.l(bArr, i2));
                    while (true) {
                        int i22 = i10 + 8;
                        if (i22 >= i3) {
                            return i22;
                        }
                        i10 = j1.i(bArr, i22, m1Var);
                        if (i4 != m1Var.a) {
                            return i22;
                        }
                        w2Var4.G0(j1.l(bArr, i10));
                    }
                }
                return i10;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    n2 n2Var = (n2) zzflVar;
                    int i23 = j1.i(bArr, i10, m1Var);
                    int i24 = m1Var.a + i23;
                    while (i23 < i24) {
                        n2Var.h(j1.h(bArr, i23));
                        i23 += 4;
                    }
                    if (i23 == i24) {
                        return i23;
                    }
                    throw zzfo.a();
                }
                if (i6 == 5) {
                    n2 n2Var2 = (n2) zzflVar;
                    n2Var2.h(j1.h(bArr, i2));
                    while (true) {
                        int i25 = i10 + 4;
                        if (i25 >= i3) {
                            return i25;
                        }
                        i10 = j1.i(bArr, i25, m1Var);
                        if (i4 != m1Var.a) {
                            return i25;
                        }
                        n2Var2.h(j1.h(bArr, i10));
                    }
                }
                return i10;
            case 25:
            case 42:
                if (i6 == 2) {
                    l1 l1Var = (l1) zzflVar;
                    i9 = j1.i(bArr, i10, m1Var);
                    int i26 = m1Var.a + i9;
                    while (i9 < i26) {
                        i9 = j1.k(bArr, i9, m1Var);
                        l1Var.f(m1Var.f17218b != 0);
                    }
                    if (i9 != i26) {
                        throw zzfo.a();
                    }
                    return i9;
                }
                if (i6 == 0) {
                    l1 l1Var2 = (l1) zzflVar;
                    i10 = j1.k(bArr, i10, m1Var);
                    l1Var2.f(m1Var.f17218b != 0);
                    while (i10 < i3) {
                        int i27 = j1.i(bArr, i10, m1Var);
                        if (i4 == m1Var.a) {
                            i10 = j1.k(bArr, i27, m1Var);
                            l1Var2.f(m1Var.f17218b != 0);
                        }
                    }
                }
                return i10;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        i10 = j1.i(bArr, i10, m1Var);
                        int i28 = m1Var.a;
                        if (i28 < 0) {
                            throw zzfo.b();
                        }
                        if (i28 == 0) {
                            zzflVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            zzflVar.add(new String(bArr, i10, i28, zzff.a));
                            i10 += i28;
                        }
                        while (i10 < i3) {
                            int i29 = j1.i(bArr, i10, m1Var);
                            if (i4 == m1Var.a) {
                                i10 = j1.i(bArr, i29, m1Var);
                                int i30 = m1Var.a;
                                if (i30 < 0) {
                                    throw zzfo.b();
                                }
                                if (i30 == 0) {
                                    zzflVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    zzflVar.add(new String(bArr, i10, i30, zzff.a));
                                    i10 += i30;
                                }
                            }
                        }
                    } else {
                        i10 = j1.i(bArr, i10, m1Var);
                        int i31 = m1Var.a;
                        if (i31 < 0) {
                            throw zzfo.b();
                        }
                        if (i31 == 0) {
                            zzflVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            int i32 = i10 + i31;
                            if (n4.g(bArr, i10, i32)) {
                                zzflVar.add(new String(bArr, i10, i31, zzff.a));
                                i10 = i32;
                            } else {
                                throw zzfo.h();
                            }
                        }
                        while (i10 < i3) {
                            int i33 = j1.i(bArr, i10, m1Var);
                            if (i4 == m1Var.a) {
                                i10 = j1.i(bArr, i33, m1Var);
                                int i34 = m1Var.a;
                                if (i34 < 0) {
                                    throw zzfo.b();
                                }
                                if (i34 == 0) {
                                    zzflVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    int i35 = i10 + i34;
                                    if (n4.g(bArr, i10, i35)) {
                                        zzflVar.add(new String(bArr, i10, i34, zzff.a));
                                        i10 = i35;
                                    } else {
                                        throw zzfo.h();
                                    }
                                }
                            }
                        }
                    }
                }
                return i10;
            case 27:
                if (i6 == 2) {
                    return j1.e(r(i7), i4, bArr, i2, i3, zzflVar, m1Var);
                }
                return i10;
            case 28:
                if (i6 == 2) {
                    int i36 = j1.i(bArr, i10, m1Var);
                    int i37 = m1Var.a;
                    if (i37 >= 0) {
                        if (i37 > bArr.length - i36) {
                            throw zzfo.a();
                        }
                        if (i37 == 0) {
                            zzflVar.add(zzdu.f17368f);
                        } else {
                            zzflVar.add(zzdu.q(bArr, i36, i37));
                            i36 += i37;
                        }
                        while (i36 < i3) {
                            int i38 = j1.i(bArr, i36, m1Var);
                            if (i4 != m1Var.a) {
                                return i36;
                            }
                            i36 = j1.i(bArr, i38, m1Var);
                            int i39 = m1Var.a;
                            if (i39 >= 0) {
                                if (i39 > bArr.length - i36) {
                                    throw zzfo.a();
                                }
                                if (i39 == 0) {
                                    zzflVar.add(zzdu.f17368f);
                                } else {
                                    zzflVar.add(zzdu.q(bArr, i36, i39));
                                    i36 += i39;
                                }
                            } else {
                                throw zzfo.b();
                            }
                        }
                        return i36;
                    }
                    throw zzfo.b();
                }
                return i10;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        i9 = j1.b(i4, bArr, i2, i3, zzflVar, m1Var);
                    }
                    return i10;
                }
                i9 = j1.j(bArr, i10, zzflVar, m1Var);
                zzfd zzfdVar = (zzfd) t;
                zzhy zzhyVar = zzfdVar.zzb;
                if (zzhyVar == zzhy.a()) {
                    zzhyVar = null;
                }
                zzhy zzhyVar2 = (zzhy) r3.i(i5, zzflVar, N(i7), zzhyVar, this.q);
                if (zzhyVar2 != null) {
                    zzfdVar.zzb = zzhyVar2;
                }
                return i9;
            case 33:
            case 47:
                if (i6 == 2) {
                    n2 n2Var3 = (n2) zzflVar;
                    int i40 = j1.i(bArr, i10, m1Var);
                    int i41 = m1Var.a + i40;
                    while (i40 < i41) {
                        i40 = j1.i(bArr, i40, m1Var);
                        n2Var3.h(zzeg.k(m1Var.a));
                    }
                    if (i40 == i41) {
                        return i40;
                    }
                    throw zzfo.a();
                }
                if (i6 == 0) {
                    n2 n2Var4 = (n2) zzflVar;
                    int i42 = j1.i(bArr, i10, m1Var);
                    n2Var4.h(zzeg.k(m1Var.a));
                    while (i42 < i3) {
                        int i43 = j1.i(bArr, i42, m1Var);
                        if (i4 != m1Var.a) {
                            return i42;
                        }
                        i42 = j1.i(bArr, i43, m1Var);
                        n2Var4.h(zzeg.k(m1Var.a));
                    }
                    return i42;
                }
                return i10;
            case 34:
            case 48:
                if (i6 == 2) {
                    w2 w2Var5 = (w2) zzflVar;
                    int i44 = j1.i(bArr, i10, m1Var);
                    int i45 = m1Var.a + i44;
                    while (i44 < i45) {
                        i44 = j1.k(bArr, i44, m1Var);
                        w2Var5.G0(zzeg.b(m1Var.f17218b));
                    }
                    if (i44 == i45) {
                        return i44;
                    }
                    throw zzfo.a();
                }
                if (i6 == 0) {
                    w2 w2Var6 = (w2) zzflVar;
                    int k3 = j1.k(bArr, i10, m1Var);
                    w2Var6.G0(zzeg.b(m1Var.f17218b));
                    while (k3 < i3) {
                        int i46 = j1.i(bArr, k3, m1Var);
                        if (i4 != m1Var.a) {
                            return k3;
                        }
                        k3 = j1.k(bArr, i46, m1Var);
                        w2Var6.G0(zzeg.b(m1Var.f17218b));
                    }
                    return k3;
                }
                return i10;
            case 49:
                if (i6 == 3) {
                    p3 r = r(i7);
                    int i47 = (i4 & (-8)) | 4;
                    i10 = j1.f(r, bArr, i2, i3, i47, m1Var);
                    zzflVar.add(m1Var.f17219c);
                    while (i10 < i3) {
                        int i48 = j1.i(bArr, i10, m1Var);
                        if (i4 == m1Var.a) {
                            i10 = j1.f(r, bArr, i48, i3, i47, m1Var);
                            zzflVar.add(m1Var.f17219c);
                        }
                    }
                }
                return i10;
            default:
                return i10;
        }
    }

    private final <K, V> int o(T t, byte[] bArr, int i2, int i3, int i4, long j2, m1 m1Var) throws IOException {
        Unsafe unsafe = f17156b;
        Object H = H(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.s.f(object)) {
            Object d2 = this.s.d(H);
            this.s.g(d2, object);
            unsafe.putObject(t, j2, d2);
            object = d2;
        }
        this.s.zzf(H);
        this.s.c(object);
        int i5 = j1.i(bArr, i2, m1Var);
        int i6 = m1Var.a;
        if (i6 >= 0 && i6 <= i3 - i5) {
            throw null;
        }
        throw zzfo.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> g3<T> q(Class<T> cls, e3 e3Var, j3 j3Var, s2 s2Var, h4<?, ?> h4Var, d2<?> d2Var, a3 a3Var) {
        int i2;
        int charAt;
        int charAt2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char charAt3;
        int i9;
        char charAt4;
        int i10;
        char charAt5;
        int i11;
        char charAt6;
        int i12;
        char charAt7;
        int i13;
        char charAt8;
        int i14;
        char charAt9;
        int i15;
        char charAt10;
        int i16;
        int i17;
        boolean z;
        int i18;
        n3 n3Var;
        int i19;
        int objectFieldOffset;
        int i20;
        int i21;
        Class<?> cls2;
        String str;
        int i22;
        int i23;
        Field u;
        int i24;
        char charAt11;
        int i25;
        Field u2;
        Field u3;
        int i26;
        char charAt12;
        int i27;
        char charAt13;
        int i28;
        char charAt14;
        int i29;
        char charAt15;
        char charAt16;
        if (e3Var instanceof n3) {
            n3 n3Var2 = (n3) e3Var;
            int i30 = 0;
            boolean z2 = n3Var2.a() == zzfd.zze.f17405j;
            String d2 = n3Var2.d();
            int length = d2.length();
            int charAt17 = d2.charAt(0);
            if (charAt17 >= 55296) {
                int i31 = charAt17 & 8191;
                int i32 = 1;
                int i33 = 13;
                while (true) {
                    i2 = i32 + 1;
                    charAt16 = d2.charAt(i32);
                    if (charAt16 < 55296) {
                        break;
                    }
                    i31 |= (charAt16 & 8191) << i33;
                    i33 += 13;
                    i32 = i2;
                }
                charAt17 = i31 | (charAt16 << i33);
            } else {
                i2 = 1;
            }
            int i34 = i2 + 1;
            int charAt18 = d2.charAt(i2);
            if (charAt18 >= 55296) {
                int i35 = charAt18 & 8191;
                int i36 = 13;
                while (true) {
                    i29 = i34 + 1;
                    charAt15 = d2.charAt(i34);
                    if (charAt15 < 55296) {
                        break;
                    }
                    i35 |= (charAt15 & 8191) << i36;
                    i36 += 13;
                    i34 = i29;
                }
                charAt18 = i35 | (charAt15 << i36);
                i34 = i29;
            }
            if (charAt18 == 0) {
                iArr = a;
                i7 = 0;
                i4 = 0;
                charAt = 0;
                i5 = 0;
                charAt2 = 0;
                i6 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt19 = d2.charAt(i34);
                if (charAt19 >= 55296) {
                    int i38 = charAt19 & 8191;
                    int i39 = 13;
                    while (true) {
                        i15 = i37 + 1;
                        charAt10 = d2.charAt(i37);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i38 |= (charAt10 & 8191) << i39;
                        i39 += 13;
                        i37 = i15;
                    }
                    charAt19 = i38 | (charAt10 << i39);
                    i37 = i15;
                }
                int i40 = i37 + 1;
                int charAt20 = d2.charAt(i37);
                if (charAt20 >= 55296) {
                    int i41 = charAt20 & 8191;
                    int i42 = 13;
                    while (true) {
                        i14 = i40 + 1;
                        charAt9 = d2.charAt(i40);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i41 |= (charAt9 & 8191) << i42;
                        i42 += 13;
                        i40 = i14;
                    }
                    charAt20 = i41 | (charAt9 << i42);
                    i40 = i14;
                }
                int i43 = i40 + 1;
                charAt = d2.charAt(i40);
                if (charAt >= 55296) {
                    int i44 = charAt & 8191;
                    int i45 = 13;
                    while (true) {
                        i13 = i43 + 1;
                        charAt8 = d2.charAt(i43);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i44 |= (charAt8 & 8191) << i45;
                        i45 += 13;
                        i43 = i13;
                    }
                    charAt = i44 | (charAt8 << i45);
                    i43 = i13;
                }
                int i46 = i43 + 1;
                int charAt21 = d2.charAt(i43);
                if (charAt21 >= 55296) {
                    int i47 = charAt21 & 8191;
                    int i48 = 13;
                    while (true) {
                        i12 = i46 + 1;
                        charAt7 = d2.charAt(i46);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i47 |= (charAt7 & 8191) << i48;
                        i48 += 13;
                        i46 = i12;
                    }
                    charAt21 = i47 | (charAt7 << i48);
                    i46 = i12;
                }
                int i49 = i46 + 1;
                charAt2 = d2.charAt(i46);
                if (charAt2 >= 55296) {
                    int i50 = charAt2 & 8191;
                    int i51 = 13;
                    while (true) {
                        i11 = i49 + 1;
                        charAt6 = d2.charAt(i49);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i50 |= (charAt6 & 8191) << i51;
                        i51 += 13;
                        i49 = i11;
                    }
                    charAt2 = i50 | (charAt6 << i51);
                    i49 = i11;
                }
                int i52 = i49 + 1;
                int charAt22 = d2.charAt(i49);
                if (charAt22 >= 55296) {
                    int i53 = charAt22 & 8191;
                    int i54 = 13;
                    while (true) {
                        i10 = i52 + 1;
                        charAt5 = d2.charAt(i52);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i53 |= (charAt5 & 8191) << i54;
                        i54 += 13;
                        i52 = i10;
                    }
                    charAt22 = i53 | (charAt5 << i54);
                    i52 = i10;
                }
                int i55 = i52 + 1;
                int charAt23 = d2.charAt(i52);
                if (charAt23 >= 55296) {
                    int i56 = charAt23 & 8191;
                    int i57 = i55;
                    int i58 = 13;
                    while (true) {
                        i9 = i57 + 1;
                        charAt4 = d2.charAt(i57);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i56 |= (charAt4 & 8191) << i58;
                        i58 += 13;
                        i57 = i9;
                    }
                    charAt23 = i56 | (charAt4 << i58);
                    i3 = i9;
                } else {
                    i3 = i55;
                }
                int i59 = i3 + 1;
                int charAt24 = d2.charAt(i3);
                if (charAt24 >= 55296) {
                    int i60 = charAt24 & 8191;
                    int i61 = i59;
                    int i62 = 13;
                    while (true) {
                        i8 = i61 + 1;
                        charAt3 = d2.charAt(i61);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i60 |= (charAt3 & 8191) << i62;
                        i62 += 13;
                        i61 = i8;
                    }
                    charAt24 = i60 | (charAt3 << i62);
                    i59 = i8;
                }
                int[] iArr2 = new int[charAt24 + charAt22 + charAt23];
                int i63 = (charAt19 << 1) + charAt20;
                i4 = charAt21;
                i5 = i63;
                i6 = charAt24;
                i30 = charAt19;
                i34 = i59;
                int i64 = charAt22;
                iArr = iArr2;
                i7 = i64;
            }
            Unsafe unsafe = f17156b;
            Object[] e2 = n3Var2.e();
            Class<?> cls3 = n3Var2.c().getClass();
            int i65 = i34;
            int[] iArr3 = new int[charAt2 * 3];
            Object[] objArr = new Object[charAt2 << 1];
            int i66 = i6 + i7;
            int i67 = i6;
            int i68 = i65;
            int i69 = i66;
            int i70 = 0;
            int i71 = 0;
            while (i68 < length) {
                int i72 = i68 + 1;
                int charAt25 = d2.charAt(i68);
                int i73 = length;
                if (charAt25 >= 55296) {
                    int i74 = charAt25 & 8191;
                    int i75 = i72;
                    int i76 = 13;
                    while (true) {
                        i28 = i75 + 1;
                        charAt14 = d2.charAt(i75);
                        i16 = i6;
                        if (charAt14 < 55296) {
                            break;
                        }
                        i74 |= (charAt14 & 8191) << i76;
                        i76 += 13;
                        i75 = i28;
                        i6 = i16;
                    }
                    charAt25 = i74 | (charAt14 << i76);
                    i17 = i28;
                } else {
                    i16 = i6;
                    i17 = i72;
                }
                int i77 = i17 + 1;
                int charAt26 = d2.charAt(i17);
                if (charAt26 >= 55296) {
                    int i78 = charAt26 & 8191;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i27 = i79 + 1;
                        charAt13 = d2.charAt(i79);
                        z = z2;
                        if (charAt13 < 55296) {
                            break;
                        }
                        i78 |= (charAt13 & 8191) << i80;
                        i80 += 13;
                        i79 = i27;
                        z2 = z;
                    }
                    charAt26 = i78 | (charAt13 << i80);
                    i18 = i27;
                } else {
                    z = z2;
                    i18 = i77;
                }
                int i81 = charAt26 & 255;
                int i82 = i4;
                if ((charAt26 & 1024) != 0) {
                    iArr[i70] = i71;
                    i70++;
                }
                int i83 = charAt;
                if (i81 >= 51) {
                    int i84 = i18 + 1;
                    int charAt27 = d2.charAt(i18);
                    char c2 = 55296;
                    if (charAt27 >= 55296) {
                        int i85 = charAt27 & 8191;
                        int i86 = 13;
                        while (true) {
                            i26 = i84 + 1;
                            charAt12 = d2.charAt(i84);
                            if (charAt12 < c2) {
                                break;
                            }
                            i85 |= (charAt12 & 8191) << i86;
                            i86 += 13;
                            i84 = i26;
                            c2 = 55296;
                        }
                        charAt27 = i85 | (charAt12 << i86);
                        i84 = i26;
                    }
                    int i87 = i81 - 51;
                    int i88 = i84;
                    if (i87 == 9 || i87 == 17) {
                        objArr[((i71 / 3) << 1) + 1] = e2[i5];
                        i5++;
                    } else if (i87 == 12 && (charAt17 & 1) == 1) {
                        objArr[((i71 / 3) << 1) + 1] = e2[i5];
                        i5++;
                    }
                    int i89 = charAt27 << 1;
                    Object obj = e2[i89];
                    if (obj instanceof Field) {
                        u2 = (Field) obj;
                    } else {
                        u2 = u(cls3, (String) obj);
                        e2[i89] = u2;
                    }
                    n3Var = n3Var2;
                    String str2 = d2;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(u2);
                    int i90 = i89 + 1;
                    Object obj2 = e2[i90];
                    if (obj2 instanceof Field) {
                        u3 = (Field) obj2;
                    } else {
                        u3 = u(cls3, (String) obj2);
                        e2[i90] = u3;
                    }
                    cls2 = cls3;
                    i20 = i5;
                    i18 = i88;
                    str = str2;
                    i23 = 0;
                    i22 = (int) unsafe.objectFieldOffset(u3);
                    i21 = i30;
                } else {
                    n3Var = n3Var2;
                    String str3 = d2;
                    int i91 = i5 + 1;
                    Field u4 = u(cls3, (String) e2[i5]);
                    if (i81 == 9 || i81 == 17) {
                        i19 = 1;
                        objArr[((i71 / 3) << 1) + 1] = u4.getType();
                    } else {
                        if (i81 == 27 || i81 == 49) {
                            i19 = 1;
                            i25 = i91 + 1;
                            objArr[((i71 / 3) << 1) + 1] = e2[i91];
                        } else if (i81 == 12 || i81 == 30 || i81 == 44) {
                            i19 = 1;
                            if ((charAt17 & 1) == 1) {
                                i25 = i91 + 1;
                                objArr[((i71 / 3) << 1) + 1] = e2[i91];
                            }
                        } else {
                            if (i81 == 50) {
                                int i92 = i67 + 1;
                                iArr[i67] = i71;
                                int i93 = (i71 / 3) << 1;
                                int i94 = i91 + 1;
                                objArr[i93] = e2[i91];
                                if ((charAt26 & RecyclerView.l.FLAG_MOVED) != 0) {
                                    i91 = i94 + 1;
                                    objArr[i93 + 1] = e2[i94];
                                    i67 = i92;
                                } else {
                                    i91 = i94;
                                    i19 = 1;
                                    i67 = i92;
                                }
                            }
                            i19 = 1;
                        }
                        i91 = i25;
                    }
                    objectFieldOffset = (int) unsafe.objectFieldOffset(u4);
                    if ((charAt17 & 1) != i19 || i81 > 17) {
                        i20 = i91;
                        i21 = i30;
                        cls2 = cls3;
                        str = str3;
                        i22 = 0;
                        i23 = 0;
                    } else {
                        int i95 = i18 + 1;
                        str = str3;
                        int charAt28 = str.charAt(i18);
                        if (charAt28 >= 55296) {
                            int i96 = charAt28 & 8191;
                            int i97 = 13;
                            while (true) {
                                i24 = i95 + 1;
                                charAt11 = str.charAt(i95);
                                if (charAt11 < 55296) {
                                    break;
                                }
                                i96 |= (charAt11 & 8191) << i97;
                                i97 += 13;
                                i95 = i24;
                            }
                            charAt28 = i96 | (charAt11 << i97);
                            i95 = i24;
                        }
                        int i98 = (i30 << 1) + (charAt28 / 32);
                        Object obj3 = e2[i98];
                        i20 = i91;
                        if (obj3 instanceof Field) {
                            u = (Field) obj3;
                        } else {
                            u = u(cls3, (String) obj3);
                            e2[i98] = u;
                        }
                        i21 = i30;
                        cls2 = cls3;
                        i22 = (int) unsafe.objectFieldOffset(u);
                        i23 = charAt28 % 32;
                        i18 = i95;
                    }
                    if (i81 >= 18 && i81 <= 49) {
                        iArr[i69] = objectFieldOffset;
                        i69++;
                    }
                }
                int i99 = i71 + 1;
                iArr3[i71] = charAt25;
                int i100 = i99 + 1;
                iArr3[i99] = objectFieldOffset | ((charAt26 & 256) != 0 ? 268435456 : 0) | ((charAt26 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 536870912 : 0) | (i81 << 20);
                i71 = i100 + 1;
                iArr3[i100] = (i23 << 20) | i22;
                i30 = i21;
                d2 = str;
                i68 = i18;
                cls3 = cls2;
                i4 = i82;
                length = i73;
                i6 = i16;
                z2 = z;
                charAt = i83;
                i5 = i20;
                n3Var2 = n3Var;
            }
            return new g3<>(iArr3, objArr, charAt, i4, n3Var2.c(), z2, false, iArr, i6, i66, j3Var, s2Var, h4Var, d2Var, a3Var);
        }
        ((e4) e3Var).a();
        int i101 = zzfd.zze.f17405j;
        throw new NoSuchMethodError();
    }

    private final p3 r(int i2) {
        int i3 = (i2 / 3) << 1;
        p3 p3Var = (p3) this.f17158d[i3];
        if (p3Var != null) {
            return p3Var;
        }
        p3<T> b2 = l3.a().b((Class) this.f17158d[i3 + 1]);
        this.f17158d[i3] = b2;
        return b2;
    }

    private final <K, V, UT, UB> UB s(int i2, int i3, Map<K, V> map, zzfk zzfkVar, UB ub, h4<UT, UB> h4Var) {
        z2<?, ?> zzf = this.s.zzf(H(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzfkVar.d(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = h4Var.a();
                }
                t1 x = zzdu.x(zzgg.a(zzf, next.getKey(), next.getValue()));
                try {
                    zzgg.b(x.b(), zzf, next.getKey(), next.getValue());
                    h4Var.e(ub, i3, x.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB t(Object obj, int i2, UB ub, h4<UT, UB> h4Var) {
        zzfk N;
        int i3 = this.f17157c[i2];
        Object F = k4.F(obj, P(i2) & 1048575);
        return (F == null || (N = N(i2)) == null) ? ub : (UB) s(i2, i3, this.s.c(F), N, ub, h4Var);
    }

    private static Field u(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private static List<?> v(Object obj, long j2) {
        return (List) k4.F(obj, j2);
    }

    private static void w(int i2, Object obj, y4 y4Var) throws IOException {
        if (obj instanceof String) {
            y4Var.g(i2, (String) obj);
        } else {
            y4Var.E(i2, (zzdu) obj);
        }
    }

    private static <UT, UB> void x(h4<UT, UB> h4Var, T t, y4 y4Var) throws IOException {
        h4Var.g(h4Var.k(t), y4Var);
    }

    private final <K, V> void y(y4 y4Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            y4Var.O(i2, this.s.zzf(H(i3)), this.s.b(obj));
        }
    }

    private final void z(Object obj, int i2, q3 q3Var) throws IOException {
        if (U(i2)) {
            k4.j(obj, i2 & 1048575, q3Var.j());
        } else if (this.f17163i) {
            k4.j(obj, i2 & 1048575, q3Var.w());
        } else {
            k4.j(obj, i2 & 1048575, q3Var.f());
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final T a() {
        return (T) this.o.c(this.f17161g);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:299:0x0545. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.p3
    public final int b(T t) {
        int i2;
        int i3;
        long j2;
        int b0;
        int G;
        int A0;
        int R;
        int V;
        int g0;
        int o0;
        int B;
        int V2;
        int g02;
        int o02;
        int i4 = 267386880;
        int i5 = 1;
        if (this.f17164j) {
            Unsafe unsafe = f17156b;
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.f17157c.length) {
                int P = P(i6);
                int i8 = (P & i4) >>> 20;
                int i9 = this.f17157c[i6];
                long j3 = P & 1048575;
                int i10 = (i8 < zzex.O.a() || i8 > zzex.b0.a()) ? 0 : this.f17157c[i6 + 2] & 1048575;
                switch (i8) {
                    case 0:
                        if (B(t, i6)) {
                            B = zzen.B(i9, 0.0d);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (B(t, i6)) {
                            B = zzen.C(i9, 0.0f);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (B(t, i6)) {
                            B = zzen.b0(i9, k4.o(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (B(t, i6)) {
                            B = zzen.h0(i9, k4.o(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (B(t, i6)) {
                            B = zzen.l0(i9, k4.b(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (B(t, i6)) {
                            B = zzen.q0(i9, 0L);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (B(t, i6)) {
                            B = zzen.x0(i9, 0);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (B(t, i6)) {
                            B = zzen.H(i9, true);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (B(t, i6)) {
                            Object F = k4.F(t, j3);
                            if (F instanceof zzdu) {
                                B = zzen.T(i9, (zzdu) F);
                            } else {
                                B = zzen.G(i9, (String) F);
                            }
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (B(t, i6)) {
                            B = r3.a(i9, k4.F(t, j3), r(i6));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (B(t, i6)) {
                            B = zzen.T(i9, (zzdu) k4.F(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (B(t, i6)) {
                            B = zzen.p0(i9, k4.b(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (B(t, i6)) {
                            B = zzen.C0(i9, k4.b(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (B(t, i6)) {
                            B = zzen.A0(i9, 0);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (B(t, i6)) {
                            B = zzen.u0(i9, 0L);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (B(t, i6)) {
                            B = zzen.t0(i9, k4.b(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (B(t, i6)) {
                            B = zzen.m0(i9, k4.o(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (B(t, i6)) {
                            B = zzen.U(i9, (zzgo) k4.F(t, j3), r(i6));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        B = r3.U(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 19:
                        B = r3.R(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 20:
                        B = r3.d(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 21:
                        B = r3.t(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 22:
                        B = r3.H(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 23:
                        B = r3.U(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 24:
                        B = r3.R(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 25:
                        B = r3.X(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 26:
                        B = r3.b(i9, v(t, j3));
                        i7 += B;
                        break;
                    case 27:
                        B = r3.c(i9, v(t, j3), r(i6));
                        i7 += B;
                        break;
                    case 28:
                        B = r3.r(i9, v(t, j3));
                        i7 += B;
                        break;
                    case 29:
                        B = r3.L(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 30:
                        B = r3.D(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 31:
                        B = r3.R(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 32:
                        B = r3.U(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 33:
                        B = r3.O(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 34:
                        B = r3.z(i9, v(t, j3), false);
                        i7 += B;
                        break;
                    case 35:
                        V2 = r3.V((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 36:
                        V2 = r3.S((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 37:
                        V2 = r3.e((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 38:
                        V2 = r3.u((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 39:
                        V2 = r3.I((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 40:
                        V2 = r3.V((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 41:
                        V2 = r3.S((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 42:
                        V2 = r3.Y((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 43:
                        V2 = r3.M((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 44:
                        V2 = r3.E((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 45:
                        V2 = r3.S((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 46:
                        V2 = r3.V((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 47:
                        V2 = r3.P((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 48:
                        V2 = r3.A((List) unsafe.getObject(t, j3));
                        if (V2 <= 0) {
                            break;
                        } else {
                            if (this.f17165k) {
                                unsafe.putInt(t, i10, V2);
                            }
                            g02 = zzen.g0(i9);
                            o02 = zzen.o0(V2);
                            B = g02 + o02 + V2;
                            i7 += B;
                            break;
                        }
                    case 49:
                        B = r3.s(i9, v(t, j3), r(i6));
                        i7 += B;
                        break;
                    case 50:
                        B = this.s.h(i9, k4.F(t, j3), H(i6));
                        i7 += B;
                        break;
                    case 51:
                        if (C(t, i9, i6)) {
                            B = zzen.B(i9, 0.0d);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (C(t, i9, i6)) {
                            B = zzen.C(i9, 0.0f);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (C(t, i9, i6)) {
                            B = zzen.b0(i9, S(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (C(t, i9, i6)) {
                            B = zzen.h0(i9, S(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (C(t, i9, i6)) {
                            B = zzen.l0(i9, Q(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (C(t, i9, i6)) {
                            B = zzen.q0(i9, 0L);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (C(t, i9, i6)) {
                            B = zzen.x0(i9, 0);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (C(t, i9, i6)) {
                            B = zzen.H(i9, true);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (C(t, i9, i6)) {
                            Object F2 = k4.F(t, j3);
                            if (F2 instanceof zzdu) {
                                B = zzen.T(i9, (zzdu) F2);
                            } else {
                                B = zzen.G(i9, (String) F2);
                            }
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (C(t, i9, i6)) {
                            B = r3.a(i9, k4.F(t, j3), r(i6));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (C(t, i9, i6)) {
                            B = zzen.T(i9, (zzdu) k4.F(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (C(t, i9, i6)) {
                            B = zzen.p0(i9, Q(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (C(t, i9, i6)) {
                            B = zzen.C0(i9, Q(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (C(t, i9, i6)) {
                            B = zzen.A0(i9, 0);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (C(t, i9, i6)) {
                            B = zzen.u0(i9, 0L);
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (C(t, i9, i6)) {
                            B = zzen.t0(i9, Q(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (C(t, i9, i6)) {
                            B = zzen.m0(i9, S(t, j3));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (C(t, i9, i6)) {
                            B = zzen.U(i9, (zzgo) k4.F(t, j3), r(i6));
                            i7 += B;
                            break;
                        } else {
                            break;
                        }
                }
                i6 += 3;
                i4 = 267386880;
            }
            return i7 + l(this.q, t);
        }
        Unsafe unsafe2 = f17156b;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < this.f17157c.length) {
            int P2 = P(i12);
            int[] iArr = this.f17157c;
            int i15 = iArr[i12];
            int i16 = (P2 & 267386880) >>> 20;
            if (i16 <= 17) {
                int i17 = iArr[i12 + 2];
                int i18 = i17 & 1048575;
                i3 = i5 << (i17 >>> 20);
                if (i18 != i11) {
                    i14 = unsafe2.getInt(t, i18);
                    i11 = i18;
                }
                i2 = i17;
            } else {
                i2 = (!this.f17165k || i16 < zzex.O.a() || i16 > zzex.b0.a()) ? 0 : this.f17157c[i12 + 2] & 1048575;
                i3 = 0;
            }
            long j4 = P2 & 1048575;
            switch (i16) {
                case 0:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        i13 += zzen.B(i15, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        i13 += zzen.C(i15, 0.0f);
                        break;
                    }
                case 2:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        b0 = zzen.b0(i15, unsafe2.getLong(t, j4));
                        i13 += b0;
                    }
                    break;
                case 3:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        b0 = zzen.h0(i15, unsafe2.getLong(t, j4));
                        i13 += b0;
                    }
                    break;
                case 4:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        b0 = zzen.l0(i15, unsafe2.getInt(t, j4));
                        i13 += b0;
                    }
                    break;
                case 5:
                    j2 = 0;
                    if ((i14 & i3) != 0) {
                        b0 = zzen.q0(i15, 0L);
                        i13 += b0;
                    }
                    break;
                case 6:
                    if ((i14 & i3) != 0) {
                        i13 += zzen.x0(i15, 0);
                        j2 = 0;
                        break;
                    }
                    j2 = 0;
                case 7:
                    if ((i14 & i3) != 0) {
                        i13 += zzen.H(i15, true);
                        j2 = 0;
                        break;
                    }
                    j2 = 0;
                case 8:
                    if ((i14 & i3) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzdu) {
                            G = zzen.T(i15, (zzdu) object);
                        } else {
                            G = zzen.G(i15, (String) object);
                        }
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 9:
                    if ((i14 & i3) != 0) {
                        G = r3.a(i15, unsafe2.getObject(t, j4), r(i12));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 10:
                    if ((i14 & i3) != 0) {
                        G = zzen.T(i15, (zzdu) unsafe2.getObject(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 11:
                    if ((i14 & i3) != 0) {
                        G = zzen.p0(i15, unsafe2.getInt(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 12:
                    if ((i14 & i3) != 0) {
                        G = zzen.C0(i15, unsafe2.getInt(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 13:
                    if ((i14 & i3) != 0) {
                        A0 = zzen.A0(i15, 0);
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 14:
                    if ((i14 & i3) != 0) {
                        G = zzen.u0(i15, 0L);
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 15:
                    if ((i14 & i3) != 0) {
                        G = zzen.t0(i15, unsafe2.getInt(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 16:
                    if ((i14 & i3) != 0) {
                        G = zzen.m0(i15, unsafe2.getLong(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 17:
                    if ((i14 & i3) != 0) {
                        G = zzen.U(i15, (zzgo) unsafe2.getObject(t, j4), r(i12));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 18:
                    G = r3.U(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += G;
                    j2 = 0;
                    break;
                case 19:
                    R = r3.R(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 20:
                    R = r3.d(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 21:
                    R = r3.t(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 22:
                    R = r3.H(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 23:
                    R = r3.U(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 24:
                    R = r3.R(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 25:
                    R = r3.X(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 26:
                    G = r3.b(i15, (List) unsafe2.getObject(t, j4));
                    i13 += G;
                    j2 = 0;
                    break;
                case 27:
                    G = r3.c(i15, (List) unsafe2.getObject(t, j4), r(i12));
                    i13 += G;
                    j2 = 0;
                    break;
                case 28:
                    G = r3.r(i15, (List) unsafe2.getObject(t, j4));
                    i13 += G;
                    j2 = 0;
                    break;
                case 29:
                    G = r3.L(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += G;
                    j2 = 0;
                    break;
                case 30:
                    R = r3.D(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 31:
                    R = r3.R(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 32:
                    R = r3.U(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 33:
                    R = r3.O(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 34:
                    R = r3.z(i15, (List) unsafe2.getObject(t, j4), false);
                    i13 += R;
                    j2 = 0;
                    break;
                case 35:
                    V = r3.V((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 36:
                    V = r3.S((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 37:
                    V = r3.e((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 38:
                    V = r3.u((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 39:
                    V = r3.I((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 40:
                    V = r3.V((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 41:
                    V = r3.S((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 42:
                    V = r3.Y((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 43:
                    V = r3.M((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 44:
                    V = r3.E((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 45:
                    V = r3.S((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 46:
                    V = r3.V((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 47:
                    V = r3.P((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 48:
                    V = r3.A((List) unsafe2.getObject(t, j4));
                    if (V > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i2, V);
                        }
                        g0 = zzen.g0(i15);
                        o0 = zzen.o0(V);
                        A0 = g0 + o0 + V;
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 49:
                    G = r3.s(i15, (List) unsafe2.getObject(t, j4), r(i12));
                    i13 += G;
                    j2 = 0;
                    break;
                case 50:
                    G = this.s.h(i15, unsafe2.getObject(t, j4), H(i12));
                    i13 += G;
                    j2 = 0;
                    break;
                case 51:
                    if (C(t, i15, i12)) {
                        G = zzen.B(i15, 0.0d);
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 52:
                    if (C(t, i15, i12)) {
                        A0 = zzen.C(i15, 0.0f);
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 53:
                    if (C(t, i15, i12)) {
                        G = zzen.b0(i15, S(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 54:
                    if (C(t, i15, i12)) {
                        G = zzen.h0(i15, S(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 55:
                    if (C(t, i15, i12)) {
                        G = zzen.l0(i15, Q(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 56:
                    if (C(t, i15, i12)) {
                        G = zzen.q0(i15, 0L);
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 57:
                    if (C(t, i15, i12)) {
                        A0 = zzen.x0(i15, 0);
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 58:
                    if (C(t, i15, i12)) {
                        A0 = zzen.H(i15, true);
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 59:
                    if (C(t, i15, i12)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzdu) {
                            G = zzen.T(i15, (zzdu) object2);
                        } else {
                            G = zzen.G(i15, (String) object2);
                        }
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 60:
                    if (C(t, i15, i12)) {
                        G = r3.a(i15, unsafe2.getObject(t, j4), r(i12));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 61:
                    if (C(t, i15, i12)) {
                        G = zzen.T(i15, (zzdu) unsafe2.getObject(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 62:
                    if (C(t, i15, i12)) {
                        G = zzen.p0(i15, Q(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 63:
                    if (C(t, i15, i12)) {
                        G = zzen.C0(i15, Q(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 64:
                    if (C(t, i15, i12)) {
                        A0 = zzen.A0(i15, 0);
                        i13 += A0;
                    }
                    j2 = 0;
                    break;
                case 65:
                    if (C(t, i15, i12)) {
                        G = zzen.u0(i15, 0L);
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 66:
                    if (C(t, i15, i12)) {
                        G = zzen.t0(i15, Q(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 67:
                    if (C(t, i15, i12)) {
                        G = zzen.m0(i15, S(t, j4));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                case 68:
                    if (C(t, i15, i12)) {
                        G = zzen.U(i15, (zzgo) unsafe2.getObject(t, j4), r(i12));
                        i13 += G;
                    }
                    j2 = 0;
                    break;
                default:
                    j2 = 0;
                    break;
            }
            i12 += 3;
            i5 = 1;
        }
        int i19 = 0;
        int l = i13 + l(this.q, t);
        if (!this.f17162h) {
            return l;
        }
        h2<?> b2 = this.r.b(t);
        for (int i20 = 0; i20 < b2.f17168b.k(); i20++) {
            Map.Entry<?, Object> i21 = b2.f17168b.i(i20);
            i19 += h2.a((zzey) i21.getKey(), i21.getValue());
        }
        for (Map.Entry<?, Object> entry : b2.f17168b.n()) {
            i19 += h2.a((zzey) entry.getKey(), entry.getValue());
        }
        return l + i19;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.p3
    public final int c(T t) {
        int i2;
        int b2;
        int length = this.f17157c.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int P = P(i4);
            int i5 = this.f17157c[i4];
            long j2 = 1048575 & P;
            int i6 = 37;
            switch ((P & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    b2 = zzff.b(Double.doubleToLongBits(k4.C(t, j2)));
                    i3 = i2 + b2;
                    break;
                case 1:
                    i2 = i3 * 53;
                    b2 = Float.floatToIntBits(k4.x(t, j2));
                    i3 = i2 + b2;
                    break;
                case 2:
                    i2 = i3 * 53;
                    b2 = zzff.b(k4.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 3:
                    i2 = i3 * 53;
                    b2 = zzff.b(k4.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 4:
                    i2 = i3 * 53;
                    b2 = k4.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 5:
                    i2 = i3 * 53;
                    b2 = zzff.b(k4.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 6:
                    i2 = i3 * 53;
                    b2 = k4.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 7:
                    i2 = i3 * 53;
                    b2 = zzff.c(k4.w(t, j2));
                    i3 = i2 + b2;
                    break;
                case 8:
                    i2 = i3 * 53;
                    b2 = ((String) k4.F(t, j2)).hashCode();
                    i3 = i2 + b2;
                    break;
                case 9:
                    Object F = k4.F(t, j2);
                    if (F != null) {
                        i6 = F.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    b2 = k4.F(t, j2).hashCode();
                    i3 = i2 + b2;
                    break;
                case 11:
                    i2 = i3 * 53;
                    b2 = k4.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 12:
                    i2 = i3 * 53;
                    b2 = k4.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 13:
                    i2 = i3 * 53;
                    b2 = k4.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 14:
                    i2 = i3 * 53;
                    b2 = zzff.b(k4.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 15:
                    i2 = i3 * 53;
                    b2 = k4.b(t, j2);
                    i3 = i2 + b2;
                    break;
                case 16:
                    i2 = i3 * 53;
                    b2 = zzff.b(k4.o(t, j2));
                    i3 = i2 + b2;
                    break;
                case 17:
                    Object F2 = k4.F(t, j2);
                    if (F2 != null) {
                        i6 = F2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
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
                    b2 = k4.F(t, j2).hashCode();
                    i3 = i2 + b2;
                    break;
                case 50:
                    i2 = i3 * 53;
                    b2 = k4.F(t, j2).hashCode();
                    i3 = i2 + b2;
                    break;
                case 51:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = zzff.b(Double.doubleToLongBits(F(t, j2)));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Float.floatToIntBits(M(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = zzff.b(S(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = zzff.b(S(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Q(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = zzff.b(S(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Q(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = zzff.c(V(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = ((String) k4.F(t, j2)).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = k4.F(t, j2).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = k4.F(t, j2).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Q(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Q(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Q(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = zzff.b(S(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = Q(t, j2);
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = zzff.b(S(t, j2));
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        b2 = k4.F(t, j2).hashCode();
                        i3 = i2 + b2;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.q.k(t).hashCode();
        return this.f17162h ? (hashCode * 53) + this.r.b(t).hashCode() : hashCode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x020f, code lost:
    
        if (r0 == r15) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x022e, code lost:
    
        if (r0 == r15) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e2, code lost:
    
        if (r0 == r15) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0230, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0061. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.measurement.p3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(T t, byte[] bArr, int i2, int i3, m1 m1Var) throws IOException {
        byte b2;
        int i4;
        int W;
        int i5;
        int i6;
        int i7;
        Unsafe unsafe;
        int i8;
        int i9;
        int k2;
        g3<T> g3Var = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i3;
        m1 m1Var2 = m1Var;
        if (g3Var.f17164j) {
            Unsafe unsafe2 = f17156b;
            int i11 = -1;
            int i12 = i2;
            int i13 = -1;
            int i14 = 0;
            while (i12 < i10) {
                int i15 = i12 + 1;
                byte b3 = bArr2[i12];
                if (b3 < 0) {
                    i4 = j1.d(b3, bArr2, i15, m1Var2);
                    b2 = m1Var2.a;
                } else {
                    b2 = b3;
                    i4 = i15;
                }
                int i16 = b2 >>> 3;
                int i17 = b2 & 7;
                if (i16 > i13) {
                    W = g3Var.k(i16, i14 / 3);
                } else {
                    W = g3Var.W(i16);
                }
                int i18 = W;
                if (i18 == i11) {
                    i6 = i16;
                    i8 = i4;
                    unsafe = unsafe2;
                    i5 = 0;
                } else {
                    int i19 = g3Var.f17157c[i18 + 1];
                    int i20 = (267386880 & i19) >>> 20;
                    long j2 = 1048575 & i19;
                    if (i20 <= 17) {
                        switch (i20) {
                            case 0:
                                i9 = i18;
                                if (i17 == 1) {
                                    k4.f(t2, j2, j1.m(bArr2, i4));
                                    i12 = i4 + 8;
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                i5 = i9;
                                break;
                            case 1:
                                i9 = i18;
                                if (i17 == 5) {
                                    k4.g(t2, j2, j1.o(bArr2, i4));
                                    i12 = i4 + 4;
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                i5 = i9;
                                break;
                            case 2:
                            case 3:
                                i9 = i18;
                                if (i17 == 0) {
                                    k2 = j1.k(bArr2, i4, m1Var2);
                                    unsafe2.putLong(t, j2, m1Var2.f17218b);
                                    i12 = k2;
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                i5 = i9;
                                break;
                            case 4:
                            case 11:
                                i9 = i18;
                                if (i17 == 0) {
                                    i12 = j1.i(bArr2, i4, m1Var2);
                                    unsafe2.putInt(t2, j2, m1Var2.a);
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                i5 = i9;
                                break;
                            case 5:
                            case 14:
                                if (i17 == 1) {
                                    i9 = i18;
                                    unsafe2.putLong(t, j2, j1.l(bArr2, i4));
                                    i12 = i4 + 8;
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                            case 6:
                            case 13:
                                if (i17 == 5) {
                                    unsafe2.putInt(t2, j2, j1.h(bArr2, i4));
                                    i12 = i4 + 4;
                                    i14 = i18;
                                    i13 = i16;
                                    break;
                                }
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                            case 7:
                                if (i17 == 0) {
                                    int k3 = j1.k(bArr2, i4, m1Var2);
                                    k4.k(t2, j2, m1Var2.f17218b != 0);
                                    i12 = k3;
                                    i14 = i18;
                                    i13 = i16;
                                    break;
                                }
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                            case 8:
                                if (i17 == 2) {
                                    if ((536870912 & i19) == 0) {
                                        i12 = j1.n(bArr2, i4, m1Var2);
                                    } else {
                                        i12 = j1.p(bArr2, i4, m1Var2);
                                    }
                                    unsafe2.putObject(t2, j2, m1Var2.f17219c);
                                    i14 = i18;
                                    i13 = i16;
                                    break;
                                }
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                            case 9:
                                if (i17 == 2) {
                                    i12 = j1.g(g3Var.r(i18), bArr2, i4, i10, m1Var2);
                                    Object object = unsafe2.getObject(t2, j2);
                                    if (object == null) {
                                        unsafe2.putObject(t2, j2, m1Var2.f17219c);
                                    } else {
                                        unsafe2.putObject(t2, j2, zzff.e(object, m1Var2.f17219c));
                                    }
                                    i14 = i18;
                                    i13 = i16;
                                    break;
                                }
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                            case 10:
                                if (i17 == 2) {
                                    i12 = j1.q(bArr2, i4, m1Var2);
                                    unsafe2.putObject(t2, j2, m1Var2.f17219c);
                                    i14 = i18;
                                    i13 = i16;
                                    break;
                                }
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                            case 12:
                                i9 = i18;
                                if (i17 == 0) {
                                    i12 = j1.i(bArr2, i4, m1Var2);
                                    unsafe2.putInt(t2, j2, m1Var2.a);
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                i5 = i9;
                                break;
                            case 15:
                                i9 = i18;
                                if (i17 == 0) {
                                    i12 = j1.i(bArr2, i4, m1Var2);
                                    unsafe2.putInt(t2, j2, zzeg.k(m1Var2.a));
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                i5 = i9;
                                break;
                            case 16:
                                if (i17 == 0) {
                                    k2 = j1.k(bArr2, i4, m1Var2);
                                    i9 = i18;
                                    unsafe2.putLong(t, j2, zzeg.b(m1Var2.f17218b));
                                    i12 = k2;
                                    i13 = i16;
                                    i14 = i9;
                                    break;
                                }
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                            default:
                                i5 = i18;
                                i6 = i16;
                                i7 = i4;
                                unsafe = unsafe2;
                                break;
                        }
                        i11 = -1;
                    } else if (i20 == 27) {
                        if (i17 == 2) {
                            zzfl zzflVar = (zzfl) unsafe2.getObject(t2, j2);
                            if (!zzflVar.a()) {
                                int size = zzflVar.size();
                                zzflVar = zzflVar.d(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t2, j2, zzflVar);
                            }
                            i12 = j1.e(g3Var.r(i18), b2, bArr, i4, i3, zzflVar, m1Var);
                            i13 = i16;
                            i14 = i18;
                            i11 = -1;
                        }
                        i5 = i18;
                        i6 = i16;
                        i7 = i4;
                        unsafe = unsafe2;
                    } else {
                        i5 = i18;
                        if (i20 <= 49) {
                            i6 = i16;
                            int i21 = i4;
                            unsafe = unsafe2;
                            i12 = n(t, bArr, i4, i3, b2, i16, i17, i5, i19, i20, j2, m1Var);
                        } else {
                            i6 = i16;
                            i7 = i4;
                            unsafe = unsafe2;
                            if (i20 == 50) {
                                if (i17 == 2) {
                                    i12 = o(t, bArr, i7, i3, i5, j2, m1Var);
                                }
                                i8 = i7;
                            } else {
                                i12 = m(t, bArr, i7, i3, b2, i6, i17, i19, i20, j2, i5, m1Var);
                            }
                        }
                        g3Var = this;
                        t2 = t;
                        bArr2 = bArr;
                        i10 = i3;
                        m1Var2 = m1Var;
                        unsafe2 = unsafe;
                        i14 = i5;
                        i13 = i6;
                        i11 = -1;
                    }
                    i8 = i7;
                }
                i12 = j1.c(b2, bArr, i8, i3, T(t), m1Var);
                g3Var = this;
                t2 = t;
                bArr2 = bArr;
                i10 = i3;
                m1Var2 = m1Var;
                unsafe2 = unsafe;
                i14 = i5;
                i13 = i6;
                i11 = -1;
            }
            if (i12 != i10) {
                throw zzfo.g();
            }
            return;
        }
        p(t, bArr, i2, i3, 0, m1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.p3
    public final boolean e(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= this.m) {
                return !this.f17162h || this.r.b(t).q();
            }
            int i6 = this.l[i4];
            int i7 = this.f17157c[i6];
            int P = P(i6);
            if (this.f17164j) {
                i2 = 0;
            } else {
                int i8 = this.f17157c[i6 + 2];
                int i9 = i8 & 1048575;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i5 = f17156b.getInt(t, i9);
                    i3 = i9;
                }
            }
            if (((268435456 & P) != 0) && !D(t, i6, i5, i2)) {
                return false;
            }
            int i10 = (267386880 & P) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (C(t, i7, i6) && !E(t, P, r(i6))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 == 50 && !this.s.b(k4.F(t, P & 1048575)).isEmpty()) {
                            this.s.zzf(H(i6));
                            throw null;
                        }
                    }
                }
                List list = (List) k4.F(t, P & 1048575);
                if (!list.isEmpty()) {
                    p3 r = r(i6);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list.size()) {
                            break;
                        }
                        if (!r.e(list.get(i11))) {
                            z = false;
                            break;
                        }
                        i11++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (D(t, i6, i5, i2) && !E(t, P, r(i6))) {
                return false;
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void f(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long P = P(this.l[i3]) & 1048575;
            Object F = k4.F(t, P);
            if (F != null) {
                k4.j(t, P, this.s.e(F));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.e(t, this.l[i2]);
            i2++;
        }
        this.q.q(t);
        if (this.f17162h) {
            this.r.j(t);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (com.google.android.gms.internal.measurement.r3.q(com.google.android.gms.internal.measurement.k4.F(r10, r6), com.google.android.gms.internal.measurement.k4.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.o(r10, r6) == com.google.android.gms.internal.measurement.k4.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.b(r10, r6) == com.google.android.gms.internal.measurement.k4.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.o(r10, r6) == com.google.android.gms.internal.measurement.k4.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.b(r10, r6) == com.google.android.gms.internal.measurement.k4.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.b(r10, r6) == com.google.android.gms.internal.measurement.k4.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.b(r10, r6) == com.google.android.gms.internal.measurement.k4.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (com.google.android.gms.internal.measurement.r3.q(com.google.android.gms.internal.measurement.k4.F(r10, r6), com.google.android.gms.internal.measurement.k4.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        if (com.google.android.gms.internal.measurement.r3.q(com.google.android.gms.internal.measurement.k4.F(r10, r6), com.google.android.gms.internal.measurement.k4.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (com.google.android.gms.internal.measurement.r3.q(com.google.android.gms.internal.measurement.k4.F(r10, r6), com.google.android.gms.internal.measurement.k4.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.w(r10, r6) == com.google.android.gms.internal.measurement.k4.w(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.b(r10, r6) == com.google.android.gms.internal.measurement.k4.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.o(r10, r6) == com.google.android.gms.internal.measurement.k4.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.b(r10, r6) == com.google.android.gms.internal.measurement.k4.b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.o(r10, r6) == com.google.android.gms.internal.measurement.k4.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        if (com.google.android.gms.internal.measurement.k4.o(r10, r6) == com.google.android.gms.internal.measurement.k4.o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.k4.x(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.k4.x(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.k4.C(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.k4.C(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.measurement.r3.q(com.google.android.gms.internal.measurement.k4.F(r10, r6), com.google.android.gms.internal.measurement.k4.F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c5 A[LOOP:0: B:2:0x0005->B:86:0x01c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.p3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g(T t, T t2) {
        int length = this.f17157c.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                int P = P(i2);
                long j2 = P & 1048575;
                switch ((P & 267386880) >>> 20) {
                    case 0:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                            return false;
                        }
                        i2 += 3;
                    case 1:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 2:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 3:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 4:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 5:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 6:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 7:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 8:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 9:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 10:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 11:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 12:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 13:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 14:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 15:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 16:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 17:
                        if (O(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
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
                        z = r3.q(k4.F(t, j2), k4.F(t2, j2));
                        if (z) {
                        }
                        break;
                    case 50:
                        z = r3.q(k4.F(t, j2), k4.F(t2, j2));
                        if (z) {
                        }
                        break;
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
                        long R = R(i2) & 1048575;
                        if (k4.b(t, R) == k4.b(t2, R)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    default:
                        if (z) {
                        }
                        break;
                }
            } else {
                if (!this.q.k(t).equals(this.q.k(t2))) {
                    return false;
                }
                if (this.f17162h) {
                    return this.r.b(t).equals(this.r.b(t2));
                }
                return true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a2a  */
    @Override // com.google.android.gms.internal.measurement.p3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(T t, y4 y4Var) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i2;
        Iterator<Map.Entry<?, Object>> it2;
        Map.Entry<?, ?> entry2;
        int length2;
        if (y4Var.a() == zzfd.zze.m) {
            x(this.q, t, y4Var);
            if (this.f17162h) {
                h2<?> b2 = this.r.b(t);
                if (!b2.f17168b.isEmpty()) {
                    it2 = b2.p();
                    entry2 = (Map.Entry) it2.next();
                    for (length2 = this.f17157c.length - 3; length2 >= 0; length2 -= 3) {
                        int P = P(length2);
                        int i3 = this.f17157c[length2];
                        while (entry2 != null && this.r.a(entry2) > i3) {
                            this.r.g(y4Var, entry2);
                            entry2 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                        }
                        switch ((P & 267386880) >>> 20) {
                            case 0:
                                if (B(t, length2)) {
                                    y4Var.h(i3, k4.C(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (B(t, length2)) {
                                    y4Var.r(i3, k4.x(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (B(t, length2)) {
                                    y4Var.q(i3, k4.o(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (B(t, length2)) {
                                    y4Var.c(i3, k4.o(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (B(t, length2)) {
                                    y4Var.G(i3, k4.b(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (B(t, length2)) {
                                    y4Var.L(i3, k4.o(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (B(t, length2)) {
                                    y4Var.y(i3, k4.b(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (B(t, length2)) {
                                    y4Var.B(i3, k4.w(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (B(t, length2)) {
                                    w(i3, k4.F(t, P & 1048575), y4Var);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (B(t, length2)) {
                                    y4Var.C(i3, k4.F(t, P & 1048575), r(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (B(t, length2)) {
                                    y4Var.E(i3, (zzdu) k4.F(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (B(t, length2)) {
                                    y4Var.M(i3, k4.b(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (B(t, length2)) {
                                    y4Var.D(i3, k4.b(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (B(t, length2)) {
                                    y4Var.H(i3, k4.b(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (B(t, length2)) {
                                    y4Var.b(i3, k4.o(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (B(t, length2)) {
                                    y4Var.J(i3, k4.b(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (B(t, length2)) {
                                    y4Var.N(i3, k4.o(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (B(t, length2)) {
                                    y4Var.F(i3, k4.F(t, P & 1048575), r(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                r3.l(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 19:
                                r3.y(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 20:
                                r3.C(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 21:
                                r3.G(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 22:
                                r3.T(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 23:
                                r3.N(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 24:
                                r3.a0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 25:
                                r3.d0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 26:
                                r3.j(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var);
                                break;
                            case 27:
                                r3.k(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, r(length2));
                                break;
                            case 28:
                                r3.w(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var);
                                break;
                            case 29:
                                r3.W(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 30:
                                r3.c0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 31:
                                r3.b0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 32:
                                r3.Q(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 33:
                                r3.Z(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 34:
                                r3.K(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, false);
                                break;
                            case 35:
                                r3.l(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 36:
                                r3.y(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 37:
                                r3.C(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 38:
                                r3.G(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 39:
                                r3.T(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 40:
                                r3.N(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 41:
                                r3.a0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 42:
                                r3.d0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 43:
                                r3.W(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 44:
                                r3.c0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 45:
                                r3.b0(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 46:
                                r3.Q(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 47:
                                r3.Z(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 48:
                                r3.K(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, true);
                                break;
                            case 49:
                                r3.x(this.f17157c[length2], (List) k4.F(t, P & 1048575), y4Var, r(length2));
                                break;
                            case 50:
                                y(y4Var, i3, k4.F(t, P & 1048575), length2);
                                break;
                            case 51:
                                if (C(t, i3, length2)) {
                                    y4Var.h(i3, F(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (C(t, i3, length2)) {
                                    y4Var.r(i3, M(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (C(t, i3, length2)) {
                                    y4Var.q(i3, S(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (C(t, i3, length2)) {
                                    y4Var.c(i3, S(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (C(t, i3, length2)) {
                                    y4Var.G(i3, Q(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (C(t, i3, length2)) {
                                    y4Var.L(i3, S(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (C(t, i3, length2)) {
                                    y4Var.y(i3, Q(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (C(t, i3, length2)) {
                                    y4Var.B(i3, V(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (C(t, i3, length2)) {
                                    w(i3, k4.F(t, P & 1048575), y4Var);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (C(t, i3, length2)) {
                                    y4Var.C(i3, k4.F(t, P & 1048575), r(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (C(t, i3, length2)) {
                                    y4Var.E(i3, (zzdu) k4.F(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (C(t, i3, length2)) {
                                    y4Var.M(i3, Q(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (C(t, i3, length2)) {
                                    y4Var.D(i3, Q(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (C(t, i3, length2)) {
                                    y4Var.H(i3, Q(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (C(t, i3, length2)) {
                                    y4Var.b(i3, S(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (C(t, i3, length2)) {
                                    y4Var.J(i3, Q(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (C(t, i3, length2)) {
                                    y4Var.N(i3, S(t, P & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (C(t, i3, length2)) {
                                    y4Var.F(i3, k4.F(t, P & 1048575), r(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.r.g(y4Var, entry2);
                        entry2 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                    }
                    return;
                }
            }
            it2 = null;
            entry2 = null;
            while (length2 >= 0) {
            }
            while (entry2 != null) {
            }
            return;
        }
        if (this.f17164j) {
            if (this.f17162h) {
                h2<?> b3 = this.r.b(t);
                if (!b3.f17168b.isEmpty()) {
                    it = b3.o();
                    entry = (Map.Entry) it.next();
                    length = this.f17157c.length;
                    for (i2 = 0; i2 < length; i2 += 3) {
                        int P2 = P(i2);
                        int i4 = this.f17157c[i2];
                        while (entry != null && this.r.a(entry) <= i4) {
                            this.r.g(y4Var, entry);
                            entry = it.hasNext() ? (Map.Entry) it.next() : null;
                        }
                        switch ((P2 & 267386880) >>> 20) {
                            case 0:
                                if (B(t, i2)) {
                                    y4Var.h(i4, k4.C(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (B(t, i2)) {
                                    y4Var.r(i4, k4.x(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (B(t, i2)) {
                                    y4Var.q(i4, k4.o(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (B(t, i2)) {
                                    y4Var.c(i4, k4.o(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (B(t, i2)) {
                                    y4Var.G(i4, k4.b(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (B(t, i2)) {
                                    y4Var.L(i4, k4.o(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (B(t, i2)) {
                                    y4Var.y(i4, k4.b(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (B(t, i2)) {
                                    y4Var.B(i4, k4.w(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (B(t, i2)) {
                                    w(i4, k4.F(t, P2 & 1048575), y4Var);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (B(t, i2)) {
                                    y4Var.C(i4, k4.F(t, P2 & 1048575), r(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (B(t, i2)) {
                                    y4Var.E(i4, (zzdu) k4.F(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (B(t, i2)) {
                                    y4Var.M(i4, k4.b(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (B(t, i2)) {
                                    y4Var.D(i4, k4.b(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (B(t, i2)) {
                                    y4Var.H(i4, k4.b(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (B(t, i2)) {
                                    y4Var.b(i4, k4.o(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (B(t, i2)) {
                                    y4Var.J(i4, k4.b(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (B(t, i2)) {
                                    y4Var.N(i4, k4.o(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (B(t, i2)) {
                                    y4Var.F(i4, k4.F(t, P2 & 1048575), r(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                r3.l(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 19:
                                r3.y(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 20:
                                r3.C(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 21:
                                r3.G(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 22:
                                r3.T(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 23:
                                r3.N(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 24:
                                r3.a0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 25:
                                r3.d0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 26:
                                r3.j(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var);
                                break;
                            case 27:
                                r3.k(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, r(i2));
                                break;
                            case 28:
                                r3.w(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var);
                                break;
                            case 29:
                                r3.W(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 30:
                                r3.c0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 31:
                                r3.b0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 32:
                                r3.Q(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 33:
                                r3.Z(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 34:
                                r3.K(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, false);
                                break;
                            case 35:
                                r3.l(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 36:
                                r3.y(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 37:
                                r3.C(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 38:
                                r3.G(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 39:
                                r3.T(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 40:
                                r3.N(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 41:
                                r3.a0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 42:
                                r3.d0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 43:
                                r3.W(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 44:
                                r3.c0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 45:
                                r3.b0(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 46:
                                r3.Q(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 47:
                                r3.Z(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 48:
                                r3.K(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, true);
                                break;
                            case 49:
                                r3.x(this.f17157c[i2], (List) k4.F(t, P2 & 1048575), y4Var, r(i2));
                                break;
                            case 50:
                                y(y4Var, i4, k4.F(t, P2 & 1048575), i2);
                                break;
                            case 51:
                                if (C(t, i4, i2)) {
                                    y4Var.h(i4, F(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (C(t, i4, i2)) {
                                    y4Var.r(i4, M(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (C(t, i4, i2)) {
                                    y4Var.q(i4, S(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (C(t, i4, i2)) {
                                    y4Var.c(i4, S(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (C(t, i4, i2)) {
                                    y4Var.G(i4, Q(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (C(t, i4, i2)) {
                                    y4Var.L(i4, S(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (C(t, i4, i2)) {
                                    y4Var.y(i4, Q(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (C(t, i4, i2)) {
                                    y4Var.B(i4, V(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (C(t, i4, i2)) {
                                    w(i4, k4.F(t, P2 & 1048575), y4Var);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (C(t, i4, i2)) {
                                    y4Var.C(i4, k4.F(t, P2 & 1048575), r(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (C(t, i4, i2)) {
                                    y4Var.E(i4, (zzdu) k4.F(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (C(t, i4, i2)) {
                                    y4Var.M(i4, Q(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (C(t, i4, i2)) {
                                    y4Var.D(i4, Q(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (C(t, i4, i2)) {
                                    y4Var.H(i4, Q(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (C(t, i4, i2)) {
                                    y4Var.b(i4, S(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (C(t, i4, i2)) {
                                    y4Var.J(i4, Q(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (C(t, i4, i2)) {
                                    y4Var.N(i4, S(t, P2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (C(t, i4, i2)) {
                                    y4Var.F(i4, k4.F(t, P2 & 1048575), r(i2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.r.g(y4Var, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    x(this.q, t, y4Var);
                    return;
                }
            }
            it = null;
            entry = null;
            length = this.f17157c.length;
            while (i2 < length) {
            }
            while (entry != null) {
            }
            x(this.q, t, y4Var);
            return;
        }
        K(t, y4Var);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0085. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.p3
    public final void i(T t, q3 q3Var, zzeq zzeqVar) throws IOException {
        zzeqVar.getClass();
        h4 h4Var = this.q;
        d2<?> d2Var = this.r;
        h2<?> h2Var = null;
        Object obj = null;
        while (true) {
            try {
                int a2 = q3Var.a();
                int W = W(a2);
                if (W < 0) {
                    if (a2 == Integer.MAX_VALUE) {
                        for (int i2 = this.m; i2 < this.n; i2++) {
                            obj = t(t, this.l[i2], obj, h4Var);
                        }
                        if (obj != null) {
                            h4Var.n(t, obj);
                            return;
                        }
                        return;
                    }
                    Object c2 = !this.f17162h ? null : d2Var.c(zzeqVar, this.f17161g, a2);
                    if (c2 != null) {
                        if (h2Var == null) {
                            h2Var = d2Var.i(t);
                        }
                        h2<?> h2Var2 = h2Var;
                        obj = d2Var.d(q3Var, c2, zzeqVar, h2Var2, obj, h4Var);
                        h2Var = h2Var2;
                    } else {
                        h4Var.i(q3Var);
                        if (obj == null) {
                            obj = h4Var.o(t);
                        }
                        if (!h4Var.j(obj, q3Var)) {
                            for (int i3 = this.m; i3 < this.n; i3++) {
                                obj = t(t, this.l[i3], obj, h4Var);
                            }
                            if (obj != null) {
                                h4Var.n(t, obj);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int P = P(W);
                    switch ((267386880 & P) >>> 20) {
                        case 0:
                            k4.f(t, P & 1048575, q3Var.d());
                            I(t, W);
                            break;
                        case 1:
                            k4.g(t, P & 1048575, q3Var.e());
                            I(t, W);
                            break;
                        case 2:
                            k4.i(t, P & 1048575, q3Var.s());
                            I(t, W);
                            break;
                        case 3:
                            k4.i(t, P & 1048575, q3Var.q());
                            I(t, W);
                            break;
                        case 4:
                            k4.h(t, P & 1048575, q3Var.m());
                            I(t, W);
                            break;
                        case 5:
                            k4.i(t, P & 1048575, q3Var.l());
                            I(t, W);
                            break;
                        case 6:
                            k4.h(t, P & 1048575, q3Var.v());
                            I(t, W);
                            break;
                        case 7:
                            k4.k(t, P & 1048575, q3Var.O());
                            I(t, W);
                            break;
                        case 8:
                            z(t, P, q3Var);
                            I(t, W);
                            break;
                        case 9:
                            if (B(t, W)) {
                                long j2 = P & 1048575;
                                k4.j(t, j2, zzff.e(k4.F(t, j2), q3Var.J(r(W), zzeqVar)));
                                break;
                            } else {
                                k4.j(t, P & 1048575, q3Var.J(r(W), zzeqVar));
                                I(t, W);
                                break;
                            }
                        case 10:
                            k4.j(t, P & 1048575, q3Var.f());
                            I(t, W);
                            break;
                        case 11:
                            k4.h(t, P & 1048575, q3Var.p());
                            I(t, W);
                            break;
                        case 12:
                            int k2 = q3Var.k();
                            zzfk N = N(W);
                            if (N != null && !N.d(k2)) {
                                obj = r3.h(a2, k2, obj, h4Var);
                                break;
                            }
                            k4.h(t, P & 1048575, k2);
                            I(t, W);
                            break;
                        case 13:
                            k4.h(t, P & 1048575, q3Var.g());
                            I(t, W);
                            break;
                        case 14:
                            k4.i(t, P & 1048575, q3Var.h());
                            I(t, W);
                            break;
                        case 15:
                            k4.h(t, P & 1048575, q3Var.x());
                            I(t, W);
                            break;
                        case 16:
                            k4.i(t, P & 1048575, q3Var.y());
                            I(t, W);
                            break;
                        case 17:
                            if (B(t, W)) {
                                long j3 = P & 1048575;
                                k4.j(t, j3, zzff.e(k4.F(t, j3), q3Var.K(r(W), zzeqVar)));
                                break;
                            } else {
                                k4.j(t, P & 1048575, q3Var.K(r(W), zzeqVar));
                                I(t, W);
                                break;
                            }
                        case 18:
                            q3Var.H(this.p.b(t, P & 1048575));
                            break;
                        case 19:
                            q3Var.A(this.p.b(t, P & 1048575));
                            break;
                        case 20:
                            q3Var.M(this.p.b(t, P & 1048575));
                            break;
                        case 21:
                            q3Var.u0(this.p.b(t, P & 1048575));
                            break;
                        case 22:
                            q3Var.L(this.p.b(t, P & 1048575));
                            break;
                        case 23:
                            q3Var.G(this.p.b(t, P & 1048575));
                            break;
                        case 24:
                            q3Var.F(this.p.b(t, P & 1048575));
                            break;
                        case 25:
                            q3Var.E(this.p.b(t, P & 1048575));
                            break;
                        case 26:
                            if (U(P)) {
                                q3Var.o(this.p.b(t, P & 1048575));
                                break;
                            } else {
                                q3Var.r(this.p.b(t, P & 1048575));
                                break;
                            }
                        case 27:
                            q3Var.N(this.p.b(t, P & 1048575), r(W), zzeqVar);
                            break;
                        case 28:
                            q3Var.z(this.p.b(t, P & 1048575));
                            break;
                        case 29:
                            q3Var.u(this.p.b(t, P & 1048575));
                            break;
                        case 30:
                            List<Integer> b2 = this.p.b(t, P & 1048575);
                            q3Var.C(b2);
                            obj = r3.i(a2, b2, N(W), obj, h4Var);
                            break;
                        case 31:
                            q3Var.B(this.p.b(t, P & 1048575));
                            break;
                        case 32:
                            q3Var.n(this.p.b(t, P & 1048575));
                            break;
                        case 33:
                            q3Var.i(this.p.b(t, P & 1048575));
                            break;
                        case 34:
                            q3Var.t(this.p.b(t, P & 1048575));
                            break;
                        case 35:
                            q3Var.H(this.p.b(t, P & 1048575));
                            break;
                        case 36:
                            q3Var.A(this.p.b(t, P & 1048575));
                            break;
                        case 37:
                            q3Var.M(this.p.b(t, P & 1048575));
                            break;
                        case 38:
                            q3Var.u0(this.p.b(t, P & 1048575));
                            break;
                        case 39:
                            q3Var.L(this.p.b(t, P & 1048575));
                            break;
                        case 40:
                            q3Var.G(this.p.b(t, P & 1048575));
                            break;
                        case 41:
                            q3Var.F(this.p.b(t, P & 1048575));
                            break;
                        case 42:
                            q3Var.E(this.p.b(t, P & 1048575));
                            break;
                        case 43:
                            q3Var.u(this.p.b(t, P & 1048575));
                            break;
                        case 44:
                            List<Integer> b3 = this.p.b(t, P & 1048575);
                            q3Var.C(b3);
                            obj = r3.i(a2, b3, N(W), obj, h4Var);
                            break;
                        case 45:
                            q3Var.B(this.p.b(t, P & 1048575));
                            break;
                        case 46:
                            q3Var.n(this.p.b(t, P & 1048575));
                            break;
                        case 47:
                            q3Var.i(this.p.b(t, P & 1048575));
                            break;
                        case 48:
                            q3Var.t(this.p.b(t, P & 1048575));
                            break;
                        case 49:
                            q3Var.I(this.p.b(t, P & 1048575), r(W), zzeqVar);
                            break;
                        case 50:
                            Object H = H(W);
                            long P2 = P(W) & 1048575;
                            Object F = k4.F(t, P2);
                            if (F == null) {
                                F = this.s.d(H);
                                k4.j(t, P2, F);
                            } else if (this.s.f(F)) {
                                Object d2 = this.s.d(H);
                                this.s.g(d2, F);
                                k4.j(t, P2, d2);
                                F = d2;
                            }
                            q3Var.D(this.s.c(F), this.s.zzf(H), zzeqVar);
                            break;
                        case 51:
                            k4.j(t, P & 1048575, Double.valueOf(q3Var.d()));
                            J(t, a2, W);
                            break;
                        case 52:
                            k4.j(t, P & 1048575, Float.valueOf(q3Var.e()));
                            J(t, a2, W);
                            break;
                        case 53:
                            k4.j(t, P & 1048575, Long.valueOf(q3Var.s()));
                            J(t, a2, W);
                            break;
                        case 54:
                            k4.j(t, P & 1048575, Long.valueOf(q3Var.q()));
                            J(t, a2, W);
                            break;
                        case 55:
                            k4.j(t, P & 1048575, Integer.valueOf(q3Var.m()));
                            J(t, a2, W);
                            break;
                        case 56:
                            k4.j(t, P & 1048575, Long.valueOf(q3Var.l()));
                            J(t, a2, W);
                            break;
                        case 57:
                            k4.j(t, P & 1048575, Integer.valueOf(q3Var.v()));
                            J(t, a2, W);
                            break;
                        case 58:
                            k4.j(t, P & 1048575, Boolean.valueOf(q3Var.O()));
                            J(t, a2, W);
                            break;
                        case 59:
                            z(t, P, q3Var);
                            J(t, a2, W);
                            break;
                        case 60:
                            if (C(t, a2, W)) {
                                long j4 = P & 1048575;
                                k4.j(t, j4, zzff.e(k4.F(t, j4), q3Var.J(r(W), zzeqVar)));
                            } else {
                                k4.j(t, P & 1048575, q3Var.J(r(W), zzeqVar));
                                I(t, W);
                            }
                            J(t, a2, W);
                            break;
                        case 61:
                            k4.j(t, P & 1048575, q3Var.f());
                            J(t, a2, W);
                            break;
                        case 62:
                            k4.j(t, P & 1048575, Integer.valueOf(q3Var.p()));
                            J(t, a2, W);
                            break;
                        case 63:
                            int k3 = q3Var.k();
                            zzfk N2 = N(W);
                            if (N2 != null && !N2.d(k3)) {
                                obj = r3.h(a2, k3, obj, h4Var);
                                break;
                            }
                            k4.j(t, P & 1048575, Integer.valueOf(k3));
                            J(t, a2, W);
                            break;
                        case 64:
                            k4.j(t, P & 1048575, Integer.valueOf(q3Var.g()));
                            J(t, a2, W);
                            break;
                        case 65:
                            k4.j(t, P & 1048575, Long.valueOf(q3Var.h()));
                            J(t, a2, W);
                            break;
                        case 66:
                            k4.j(t, P & 1048575, Integer.valueOf(q3Var.x()));
                            J(t, a2, W);
                            break;
                        case 67:
                            k4.j(t, P & 1048575, Long.valueOf(q3Var.y()));
                            J(t, a2, W);
                            break;
                        case 68:
                            k4.j(t, P & 1048575, q3Var.K(r(W), zzeqVar));
                            J(t, a2, W);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = h4Var.a();
                                } catch (zzfn unused) {
                                    h4Var.i(q3Var);
                                    if (obj == null) {
                                        obj = h4Var.o(t);
                                    }
                                    if (!h4Var.j(obj, q3Var)) {
                                        for (int i4 = this.m; i4 < this.n; i4++) {
                                            obj = t(t, this.l[i4], obj, h4Var);
                                        }
                                        if (obj != null) {
                                            h4Var.n(t, obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!h4Var.j(obj, q3Var)) {
                                for (int i5 = this.m; i5 < this.n; i5++) {
                                    obj = t(t, this.l[i5], obj, h4Var);
                                }
                                if (obj != null) {
                                    h4Var.n(t, obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.m; i6 < this.n; i6++) {
                    obj = t(t, this.l[i6], obj, h4Var);
                }
                if (obj != null) {
                    h4Var.n(t, obj);
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void j(T t, T t2) {
        t2.getClass();
        for (int i2 = 0; i2 < this.f17157c.length; i2 += 3) {
            int P = P(i2);
            long j2 = 1048575 & P;
            int i3 = this.f17157c[i2];
            switch ((P & 267386880) >>> 20) {
                case 0:
                    if (B(t2, i2)) {
                        k4.f(t, j2, k4.C(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (B(t2, i2)) {
                        k4.g(t, j2, k4.x(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (B(t2, i2)) {
                        k4.k(t, j2, k4.w(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (B(t2, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    A(t, t2, i2);
                    break;
                case 10:
                    if (B(t2, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    A(t, t2, i2);
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
                    this.p.c(t, t2, j2);
                    break;
                case 50:
                    r3.n(this.s, t, t2, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (C(t2, i3, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        J(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    L(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (C(t2, i3, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        J(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    L(t, t2, i2);
                    break;
            }
        }
        if (this.f17164j) {
            return;
        }
        r3.o(this.q, t, t2);
        if (this.f17162h) {
            r3.m(this.r, t, t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:110:0x007f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final int p(T t, byte[] bArr, int i2, int i3, int i4, m1 m1Var) throws IOException {
        Unsafe unsafe;
        int i5;
        Object obj;
        g3<T> g3Var;
        int i6;
        int i7;
        int W;
        int i8;
        int i9;
        int i10;
        int i11;
        Object obj2;
        m1 m1Var2;
        int i12;
        int i13;
        int i14;
        m1 m1Var3;
        int i15;
        m1 m1Var4;
        int i16;
        int i17;
        m1 m1Var5;
        int i18;
        int i19;
        int i20;
        g3<T> g3Var2 = this;
        Object obj3 = t;
        byte[] bArr2 = bArr;
        int i21 = i3;
        int i22 = i4;
        m1 m1Var6 = m1Var;
        Unsafe unsafe2 = f17156b;
        int i23 = i2;
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = -1;
        while (true) {
            if (i23 < i21) {
                int i29 = i23 + 1;
                byte b2 = bArr2[i23];
                if (b2 < 0) {
                    i7 = j1.d(b2, bArr2, i29, m1Var6);
                    i6 = m1Var6.a;
                } else {
                    i6 = b2;
                    i7 = i29;
                }
                int i30 = i6 >>> 3;
                int i31 = i6 & 7;
                if (i30 > i24) {
                    W = g3Var2.k(i30, i25 / 3);
                } else {
                    W = g3Var2.W(i30);
                }
                int i32 = W;
                if (i32 == -1) {
                    i8 = i30;
                    i9 = i7;
                    i10 = i6;
                    unsafe = unsafe2;
                    i5 = i22;
                    i11 = 0;
                } else {
                    int[] iArr = g3Var2.f17157c;
                    int i33 = iArr[i32 + 1];
                    int i34 = (i33 & 267386880) >>> 20;
                    int i35 = i6;
                    long j2 = i33 & 1048575;
                    if (i34 <= 17) {
                        int i36 = iArr[i32 + 2];
                        int i37 = 1 << (i36 >>> 20);
                        int i38 = i36 & 1048575;
                        if (i38 != i28) {
                            if (i28 != -1) {
                                unsafe2.putInt(obj3, i28, i27);
                            }
                            i27 = unsafe2.getInt(obj3, i38);
                            i28 = i38;
                        }
                        switch (i34) {
                            case 0:
                                i12 = i32;
                                i13 = i30;
                                i15 = i28;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var4 = m1Var;
                                i16 = i7;
                                if (i31 != 1) {
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    k4.f(obj3, j2, j1.m(bArr2, i16));
                                    i23 = i16 + 8;
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 1:
                                i12 = i32;
                                i13 = i30;
                                i15 = i28;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var4 = m1Var;
                                i16 = i7;
                                if (i31 != 5) {
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    k4.g(obj3, j2, j1.o(bArr2, i16));
                                    i23 = i16 + 4;
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 2:
                            case 3:
                                i12 = i32;
                                i13 = i30;
                                i15 = i28;
                                i14 = i35;
                                bArr2 = bArr;
                                i16 = i7;
                                if (i31 != 0) {
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    int k2 = j1.k(bArr2, i16, m1Var);
                                    unsafe2.putLong(t, j2, m1Var.f17218b);
                                    i27 |= i37;
                                    i23 = k2;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var;
                                    i28 = i15;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 4:
                            case 11:
                                i12 = i32;
                                i13 = i30;
                                i15 = i28;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var4 = m1Var;
                                i16 = i7;
                                if (i31 != 0) {
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    i23 = j1.i(bArr2, i16, m1Var4);
                                    unsafe2.putInt(obj3, j2, m1Var4.a);
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 5:
                            case 14:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var4 = m1Var;
                                if (i31 != 1) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    i15 = i28;
                                    i16 = i7;
                                    unsafe2.putLong(t, j2, j1.l(bArr2, i7));
                                    i23 = i16 + 8;
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 6:
                            case 13:
                                i17 = i3;
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var5 = m1Var;
                                if (i31 != 5) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    unsafe2.putInt(obj3, j2, j1.h(bArr2, i7));
                                    i23 = i7 + 4;
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 7:
                                i17 = i3;
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var5 = m1Var;
                                if (i31 != 0) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    int k3 = j1.k(bArr2, i7, m1Var5);
                                    k4.k(obj3, j2, m1Var5.f17218b != 0);
                                    i27 |= i37;
                                    i23 = k3;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 8:
                                i17 = i3;
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var5 = m1Var;
                                if (i31 != 2) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    if ((i33 & 536870912) == 0) {
                                        i23 = j1.n(bArr2, i7, m1Var5);
                                    } else {
                                        i23 = j1.p(bArr2, i7, m1Var5);
                                    }
                                    unsafe2.putObject(obj3, j2, m1Var5.f17219c);
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 9:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var5 = m1Var;
                                if (i31 != 2) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    i17 = i3;
                                    i23 = j1.g(g3Var2.r(i12), bArr2, i7, i17, m1Var5);
                                    if ((i27 & i37) == 0) {
                                        unsafe2.putObject(obj3, j2, m1Var5.f17219c);
                                    } else {
                                        unsafe2.putObject(obj3, j2, zzff.e(unsafe2.getObject(obj3, j2), m1Var5.f17219c));
                                    }
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 10:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var4 = m1Var;
                                if (i31 != 2) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    i23 = j1.q(bArr2, i7, m1Var4);
                                    unsafe2.putObject(obj3, j2, m1Var4.f17219c);
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 12:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var4 = m1Var;
                                if (i31 != 0) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    i23 = j1.i(bArr2, i7, m1Var4);
                                    int i39 = m1Var4.a;
                                    zzfk N = g3Var2.N(i12);
                                    if (N != null && !N.d(i39)) {
                                        T(t).c(i14, Long.valueOf(i39));
                                        i26 = i14;
                                        i25 = i12;
                                        i24 = i13;
                                        m1Var6 = m1Var4;
                                        i21 = i3;
                                        i22 = i4;
                                    } else {
                                        unsafe2.putInt(obj3, j2, i39);
                                        i27 |= i37;
                                        i26 = i14;
                                        i25 = i12;
                                        i24 = i13;
                                        m1Var6 = m1Var4;
                                        i21 = i3;
                                        i22 = i4;
                                    }
                                }
                                break;
                            case 15:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                m1Var4 = m1Var;
                                if (i31 != 0) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    i23 = j1.i(bArr2, i7, m1Var4);
                                    unsafe2.putInt(obj3, j2, zzeg.k(m1Var4.a));
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 16:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                if (i31 != 0) {
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    bArr2 = bArr;
                                    int k4 = j1.k(bArr2, i7, m1Var);
                                    m1Var4 = m1Var;
                                    unsafe2.putLong(t, j2, zzeg.b(m1Var.f17218b));
                                    i27 |= i37;
                                    i23 = k4;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    m1Var6 = m1Var4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 17:
                                if (i31 != 3) {
                                    i12 = i32;
                                    i13 = i30;
                                    i14 = i35;
                                    i15 = i28;
                                    i16 = i7;
                                    i9 = i16;
                                    i11 = i12;
                                    unsafe = unsafe2;
                                    i8 = i13;
                                    i28 = i15;
                                    i10 = i14;
                                    i5 = i4;
                                    break;
                                } else {
                                    i23 = j1.f(g3Var2.r(i32), bArr, i7, i3, (i30 << 3) | 4, m1Var);
                                    if ((i27 & i37) == 0) {
                                        m1Var3 = m1Var;
                                        unsafe2.putObject(obj3, j2, m1Var3.f17219c);
                                    } else {
                                        m1Var3 = m1Var;
                                        unsafe2.putObject(obj3, j2, zzff.e(unsafe2.getObject(obj3, j2), m1Var3.f17219c));
                                    }
                                    i27 |= i37;
                                    bArr2 = bArr;
                                    i21 = i3;
                                    i26 = i35;
                                    i25 = i32;
                                    i24 = i30;
                                    i22 = i4;
                                    m1Var6 = m1Var3;
                                }
                            default:
                                i12 = i32;
                                i13 = i30;
                                i15 = i28;
                                i14 = i35;
                                i16 = i7;
                                i9 = i16;
                                i11 = i12;
                                unsafe = unsafe2;
                                i8 = i13;
                                i28 = i15;
                                i10 = i14;
                                i5 = i4;
                                break;
                        }
                    } else {
                        int i40 = i28;
                        int i41 = i7;
                        bArr2 = bArr;
                        m1 m1Var7 = m1Var6;
                        if (i34 != 27) {
                            i18 = i27;
                            if (i34 <= 49) {
                                i8 = i30;
                                i20 = i35;
                                i11 = i32;
                                unsafe = unsafe2;
                                i23 = n(t, bArr, i41, i3, i35, i30, i31, i32, i33, i34, j2, m1Var);
                                if (i23 == i41) {
                                    i5 = i4;
                                    i9 = i23;
                                } else {
                                    g3Var2 = this;
                                    obj3 = t;
                                    bArr2 = bArr;
                                    i21 = i3;
                                    i22 = i4;
                                    m1Var6 = m1Var;
                                    i28 = i40;
                                    i25 = i11;
                                    i27 = i18;
                                    i24 = i8;
                                    i26 = i20;
                                    unsafe2 = unsafe;
                                }
                            } else {
                                i8 = i30;
                                i19 = i41;
                                i20 = i35;
                                i11 = i32;
                                unsafe = unsafe2;
                                if (i34 != 50) {
                                    i23 = m(t, bArr, i19, i3, i20, i8, i31, i33, i34, j2, i11, m1Var);
                                    if (i23 != i19) {
                                        g3Var2 = this;
                                        obj3 = t;
                                        i21 = i3;
                                        i22 = i4;
                                        i26 = i20;
                                        i24 = i8;
                                        i28 = i40;
                                        i25 = i11;
                                        i27 = i18;
                                        unsafe2 = unsafe;
                                        bArr2 = bArr;
                                        m1Var6 = m1Var;
                                    }
                                } else if (i31 == 2) {
                                    i23 = o(t, bArr, i19, i3, i11, j2, m1Var);
                                    if (i23 != i19) {
                                        g3Var2 = this;
                                        obj3 = t;
                                        bArr2 = bArr;
                                        i21 = i3;
                                        i22 = i4;
                                        m1Var6 = m1Var;
                                        i28 = i40;
                                        i25 = i11;
                                        i27 = i18;
                                        i24 = i8;
                                        i26 = i20;
                                        unsafe2 = unsafe;
                                    }
                                } else {
                                    i5 = i4;
                                    i9 = i19;
                                }
                                i5 = i4;
                                i9 = i23;
                            }
                        } else if (i31 == 2) {
                            zzfl zzflVar = (zzfl) unsafe2.getObject(obj3, j2);
                            if (!zzflVar.a()) {
                                int size = zzflVar.size();
                                zzflVar = zzflVar.d(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(obj3, j2, zzflVar);
                            }
                            i23 = j1.e(g3Var2.r(i32), i35, bArr, i41, i3, zzflVar, m1Var);
                            i22 = i4;
                            i24 = i30;
                            i26 = i35;
                            i25 = i32;
                            m1Var6 = m1Var7;
                            i28 = i40;
                            i27 = i27;
                            i21 = i3;
                        } else {
                            i18 = i27;
                            i8 = i30;
                            i19 = i41;
                            i20 = i35;
                            i11 = i32;
                            unsafe = unsafe2;
                            i5 = i4;
                            i9 = i19;
                        }
                        i28 = i40;
                        i27 = i18;
                        i10 = i20;
                    }
                }
                if (i10 != i5 || i5 == 0) {
                    if (this.f17162h) {
                        m1Var2 = m1Var;
                        if (m1Var2.f17220d != zzeq.a()) {
                            int i42 = i8;
                            if (m1Var2.f17220d.b(this.f17161g, i42) == null) {
                                i23 = j1.c(i10, bArr, i9, i3, T(t), m1Var);
                                obj3 = t;
                                i21 = i3;
                                i26 = i10;
                                g3Var2 = this;
                                m1Var6 = m1Var2;
                                i24 = i42;
                                i25 = i11;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i22 = i5;
                            } else {
                                zzfd.zzd zzdVar = (zzfd.zzd) t;
                                zzdVar.B();
                                h2<zzfd.a> h2Var = zzdVar.zzc;
                                throw new NoSuchMethodError();
                            }
                        } else {
                            obj2 = t;
                        }
                    } else {
                        obj2 = t;
                        m1Var2 = m1Var;
                    }
                    i23 = j1.c(i10, bArr, i9, i3, T(t), m1Var);
                    i26 = i10;
                    g3Var2 = this;
                    m1Var6 = m1Var2;
                    i24 = i8;
                    obj3 = obj2;
                    i25 = i11;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i21 = i3;
                    i22 = i5;
                } else {
                    g3Var = this;
                    obj = t;
                    i23 = i9;
                    i26 = i10;
                }
            } else {
                unsafe = unsafe2;
                i5 = i22;
                obj = obj3;
                g3Var = g3Var2;
            }
        }
        if (i28 != -1) {
            unsafe.putInt(obj, i28, i27);
        }
        zzhy zzhyVar = null;
        for (int i43 = g3Var.m; i43 < g3Var.n; i43++) {
            zzhyVar = (zzhy) g3Var.t(obj, g3Var.l[i43], zzhyVar, g3Var.q);
        }
        if (zzhyVar != null) {
            g3Var.q.n(obj, zzhyVar);
        }
        if (i5 == 0) {
            if (i23 != i3) {
                throw zzfo.g();
            }
        } else if (i23 > i3 || i26 != i5) {
            throw zzfo.g();
        }
        return i23;
    }
}
