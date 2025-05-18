package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aw<T> implements lw<T> {
    private static final int[] a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f12268b = gx.r();

    /* renamed from: c, reason: collision with root package name */
    private final int[] f12269c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f12270d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12271e;

    /* renamed from: f, reason: collision with root package name */
    private final int f12272f;

    /* renamed from: g, reason: collision with root package name */
    private final zzdpk f12273g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f12274h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f12275i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f12276j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f12277k;
    private final int[] l;
    private final int m;
    private final int n;
    private final cw o;
    private final kv p;
    private final cx<?, ?> q;
    private final vu<?> r;
    private final uv s;

    private aw(int[] iArr, Object[] objArr, int i2, int i3, zzdpk zzdpkVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, cw cwVar, kv kvVar, cx<?, ?> cxVar, vu<?> vuVar, uv uvVar) {
        this.f12269c = iArr;
        this.f12270d = objArr;
        this.f12271e = i2;
        this.f12272f = i3;
        this.f12275i = zzdpkVar instanceof zzdob;
        this.f12276j = z;
        this.f12274h = vuVar != null && vuVar.h(zzdpkVar);
        this.f12277k = false;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = cwVar;
        this.p = kvVar;
        this.q = cxVar;
        this.r = vuVar;
        this.f12273g = zzdpkVar;
        this.s = uvVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean A(Object obj, int i2, lw lwVar) {
        return lwVar.j(gx.L(obj, i2 & 1048575));
    }

    private final int B(int i2, int i3) {
        if (i2 < this.f12271e || i2 > this.f12272f) {
            return -1;
        }
        return C(i2, i3);
    }

    private final int C(int i2, int i3) {
        int length = (this.f12269c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f12269c[i5];
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

    private static zzdqu D(Object obj) {
        zzdob zzdobVar = (zzdob) obj;
        zzdqu zzdquVar = zzdobVar.zzhhd;
        if (zzdquVar != zzdqu.f()) {
            return zzdquVar;
        }
        zzdqu i2 = zzdqu.i();
        zzdobVar.zzhhd = i2;
        return i2;
    }

    private final void E(T t, int i2, int i3) {
        gx.n(t, R(i3) & 1048575, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void F(T t, ux uxVar) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i2;
        int i3;
        int i4;
        if (this.f12274h) {
            yu<?> i5 = this.r.i(t);
            if (!i5.b()) {
                it = i5.e();
                entry = (Map.Entry) it.next();
                int i6 = -1;
                length = this.f12269c.length;
                Unsafe unsafe = f12268b;
                i2 = 0;
                int i7 = 0;
                while (i2 < length) {
                    int Q = Q(i2);
                    int[] iArr = this.f12269c;
                    int i8 = iArr[i2];
                    int i9 = (267386880 & Q) >>> 20;
                    if (this.f12276j || i9 > 17) {
                        i3 = i2;
                        i4 = 0;
                    } else {
                        int i10 = iArr[i2 + 2];
                        int i11 = i10 & 1048575;
                        i3 = i2;
                        if (i11 != i6) {
                            i7 = unsafe.getInt(t, i11);
                            i6 = i11;
                        }
                        i4 = 1 << (i10 >>> 20);
                    }
                    while (entry != null && this.r.a(entry) <= i8) {
                        this.r.f(uxVar, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    long j2 = Q & 1048575;
                    int i12 = i3;
                    switch (i9) {
                        case 0:
                            if ((i4 & i7) == 0) {
                                break;
                            } else {
                                uxVar.E(i8, gx.K(t, j2));
                                continue;
                            }
                        case 1:
                            if ((i4 & i7) != 0) {
                                uxVar.r(i8, gx.I(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i4 & i7) != 0) {
                                uxVar.J(i8, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i4 & i7) != 0) {
                                uxVar.L(i8, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i4 & i7) != 0) {
                                uxVar.T(i8, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i4 & i7) != 0) {
                                uxVar.B(i8, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i4 & i7) != 0) {
                                uxVar.D(i8, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i4 & i7) != 0) {
                                uxVar.R(i8, gx.H(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i4 & i7) != 0) {
                                t(i8, unsafe.getObject(t, j2), uxVar);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i4 & i7) != 0) {
                                uxVar.Y(i8, unsafe.getObject(t, j2), N(i12));
                                break;
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i4 & i7) != 0) {
                                uxVar.I(i8, (zzdmr) unsafe.getObject(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i4 & i7) != 0) {
                                uxVar.K(i8, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i4 & i7) != 0) {
                                uxVar.N(i8, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i4 & i7) != 0) {
                                uxVar.H(i8, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i4 & i7) != 0) {
                                uxVar.M(i8, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i4 & i7) != 0) {
                                uxVar.O(i8, unsafe.getInt(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i4 & i7) != 0) {
                                uxVar.P(i8, unsafe.getLong(t, j2));
                                break;
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i4 & i7) != 0) {
                                uxVar.U(i8, unsafe.getObject(t, j2), N(i12));
                                break;
                            } else {
                                continue;
                            }
                        case 18:
                            nw.e(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 19:
                            nw.x(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 20:
                            nw.C(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 21:
                            nw.F(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 22:
                            nw.K(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 23:
                            nw.I(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 24:
                            nw.O(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 25:
                            nw.R(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 26:
                            nw.c(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar);
                            break;
                        case 27:
                            nw.d(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, N(i12));
                            break;
                        case 28:
                            nw.v(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar);
                            break;
                        case 29:
                            nw.M(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 30:
                            nw.Q(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 31:
                            nw.P(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 32:
                            nw.J(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 33:
                            nw.N(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 34:
                            nw.G(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, false);
                            continue;
                        case 35:
                            nw.e(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 36:
                            nw.x(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 37:
                            nw.C(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 38:
                            nw.F(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 39:
                            nw.K(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 40:
                            nw.I(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 41:
                            nw.O(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 42:
                            nw.R(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 43:
                            nw.M(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 44:
                            nw.Q(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 45:
                            nw.P(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 46:
                            nw.J(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 47:
                            nw.N(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 48:
                            nw.G(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, true);
                            break;
                        case 49:
                            nw.w(this.f12269c[i12], (List) unsafe.getObject(t, j2), uxVar, N(i12));
                            break;
                        case 50:
                            v(uxVar, i8, unsafe.getObject(t, j2), i12);
                            break;
                        case 51:
                            if (y(t, i8, i12)) {
                                uxVar.E(i8, L(t, j2));
                                break;
                            }
                            break;
                        case 52:
                            if (y(t, i8, i12)) {
                                uxVar.r(i8, M(t, j2));
                                break;
                            }
                            break;
                        case 53:
                            if (y(t, i8, i12)) {
                                uxVar.J(i8, V(t, j2));
                                break;
                            }
                            break;
                        case 54:
                            if (y(t, i8, i12)) {
                                uxVar.L(i8, V(t, j2));
                                break;
                            }
                            break;
                        case 55:
                            if (y(t, i8, i12)) {
                                uxVar.T(i8, U(t, j2));
                                break;
                            }
                            break;
                        case 56:
                            if (y(t, i8, i12)) {
                                uxVar.B(i8, V(t, j2));
                                break;
                            }
                            break;
                        case 57:
                            if (y(t, i8, i12)) {
                                uxVar.D(i8, U(t, j2));
                                break;
                            }
                            break;
                        case 58:
                            if (y(t, i8, i12)) {
                                uxVar.R(i8, W(t, j2));
                                break;
                            }
                            break;
                        case 59:
                            if (y(t, i8, i12)) {
                                t(i8, unsafe.getObject(t, j2), uxVar);
                                break;
                            }
                            break;
                        case 60:
                            if (y(t, i8, i12)) {
                                uxVar.Y(i8, unsafe.getObject(t, j2), N(i12));
                                break;
                            }
                            break;
                        case 61:
                            if (y(t, i8, i12)) {
                                uxVar.I(i8, (zzdmr) unsafe.getObject(t, j2));
                                break;
                            }
                            break;
                        case 62:
                            if (y(t, i8, i12)) {
                                uxVar.K(i8, U(t, j2));
                                break;
                            }
                            break;
                        case 63:
                            if (y(t, i8, i12)) {
                                uxVar.N(i8, U(t, j2));
                                break;
                            }
                            break;
                        case 64:
                            if (y(t, i8, i12)) {
                                uxVar.H(i8, U(t, j2));
                                break;
                            }
                            break;
                        case 65:
                            if (y(t, i8, i12)) {
                                uxVar.M(i8, V(t, j2));
                                break;
                            }
                            break;
                        case 66:
                            if (y(t, i8, i12)) {
                                uxVar.O(i8, U(t, j2));
                                break;
                            }
                            break;
                        case 67:
                            if (y(t, i8, i12)) {
                                uxVar.P(i8, V(t, j2));
                                break;
                            }
                            break;
                        case 68:
                            if (y(t, i8, i12)) {
                                uxVar.U(i8, unsafe.getObject(t, j2), N(i12));
                                break;
                            }
                            break;
                    }
                    i2 = i12 + 3;
                }
                while (entry != null) {
                    this.r.f(uxVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                u(this.q, t, uxVar);
            }
        }
        it = null;
        entry = null;
        int i62 = -1;
        length = this.f12269c.length;
        Unsafe unsafe2 = f12268b;
        i2 = 0;
        int i72 = 0;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        u(this.q, t, uxVar);
    }

    private final void G(T t, T t2, int i2) {
        int Q = Q(i2);
        int i3 = this.f12269c[i2];
        long j2 = Q & 1048575;
        if (y(t2, i3, i2)) {
            Object L = gx.L(t, j2);
            Object L2 = gx.L(t2, j2);
            if (L != null && L2 != null) {
                gx.g(t, j2, zzdod.g(L, L2));
                E(t, i3, i2);
            } else if (L2 != null) {
                gx.g(t, j2, L2);
                E(t, i3, i2);
            }
        }
    }

    private final boolean H(T t, T t2, int i2) {
        return I(t, i2) == I(t2, i2);
    }

    private final boolean I(T t, int i2) {
        if (this.f12276j) {
            int Q = Q(i2);
            long j2 = Q & 1048575;
            switch ((Q & 267386880) >>> 20) {
                case 0:
                    return gx.K(t, j2) != 0.0d;
                case 1:
                    return gx.I(t, j2) != 0.0f;
                case 2:
                    return gx.F(t, j2) != 0;
                case 3:
                    return gx.F(t, j2) != 0;
                case 4:
                    return gx.E(t, j2) != 0;
                case 5:
                    return gx.F(t, j2) != 0;
                case 6:
                    return gx.E(t, j2) != 0;
                case 7:
                    return gx.H(t, j2);
                case 8:
                    Object L = gx.L(t, j2);
                    if (L instanceof String) {
                        return !((String) L).isEmpty();
                    }
                    if (L instanceof zzdmr) {
                        return !zzdmr.f15982f.equals(L);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return gx.L(t, j2) != null;
                case 10:
                    return !zzdmr.f15982f.equals(gx.L(t, j2));
                case 11:
                    return gx.E(t, j2) != 0;
                case 12:
                    return gx.E(t, j2) != 0;
                case 13:
                    return gx.E(t, j2) != 0;
                case 14:
                    return gx.F(t, j2) != 0;
                case 15:
                    return gx.E(t, j2) != 0;
                case 16:
                    return gx.F(t, j2) != 0;
                case 17:
                    return gx.L(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int R = R(i2);
        return (gx.E(t, (long) (R & 1048575)) & (1 << (R >>> 20))) != 0;
    }

    private static <E> List<E> J(Object obj, long j2) {
        return (List) gx.L(obj, j2);
    }

    private final void K(T t, int i2) {
        if (this.f12276j) {
            return;
        }
        int R = R(i2);
        long j2 = R & 1048575;
        gx.n(t, j2, gx.E(t, j2) | (1 << (R >>> 20)));
    }

    private static <T> double L(T t, long j2) {
        return ((Double) gx.L(t, j2)).doubleValue();
    }

    private static <T> float M(T t, long j2) {
        return ((Float) gx.L(t, j2)).floatValue();
    }

    private final lw N(int i2) {
        int i3 = (i2 / 3) << 1;
        lw lwVar = (lw) this.f12270d[i3];
        if (lwVar != null) {
            return lwVar;
        }
        lw<T> c2 = gw.b().c((Class) this.f12270d[i3 + 1]);
        this.f12270d[i3] = c2;
        return c2;
    }

    private final Object O(int i2) {
        return this.f12270d[(i2 / 3) << 1];
    }

    private final zzdog P(int i2) {
        return (zzdog) this.f12270d[((i2 / 3) << 1) + 1];
    }

    private final int Q(int i2) {
        return this.f12269c[i2 + 1];
    }

    private final int R(int i2) {
        return this.f12269c[i2 + 2];
    }

    private static boolean S(int i2) {
        return (i2 & 536870912) != 0;
    }

    private final int T(int i2) {
        if (i2 < this.f12271e || i2 > this.f12272f) {
            return -1;
        }
        return C(i2, 0);
    }

    private static <T> int U(T t, long j2) {
        return ((Integer) gx.L(t, j2)).intValue();
    }

    private static <T> long V(T t, long j2) {
        return ((Long) gx.L(t, j2)).longValue();
    }

    private static <T> boolean W(T t, long j2) {
        return ((Boolean) gx.L(t, j2)).booleanValue();
    }

    private static <UT, UB> int k(cx<UT, UB> cxVar, T t) {
        return cxVar.i(cxVar.j(t));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private final int l(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, bu buVar) throws IOException {
        int j3;
        Unsafe unsafe = f12268b;
        long j4 = this.f12269c[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Double.valueOf(au.p(bArr, i2)));
                    j3 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Float.valueOf(au.q(bArr, i2)));
                    j3 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    j3 = au.j(bArr, i2, buVar);
                    unsafe.putObject(t, j2, Long.valueOf(buVar.f12360b));
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    j3 = au.h(bArr, i2, buVar);
                    unsafe.putObject(t, j2, Integer.valueOf(buVar.a));
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    unsafe.putObject(t, j2, Long.valueOf(au.o(bArr, i2)));
                    j3 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    unsafe.putObject(t, j2, Integer.valueOf(au.n(bArr, i2)));
                    j3 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    j3 = au.j(bArr, i2, buVar);
                    unsafe.putObject(t, j2, Boolean.valueOf(buVar.f12360b != 0));
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    int h2 = au.h(bArr, i2, buVar);
                    int i10 = buVar.a;
                    if (i10 == 0) {
                        unsafe.putObject(t, j2, HttpUrl.FRAGMENT_ENCODE_SET);
                    } else {
                        if ((i7 & 536870912) != 0 && !jx.k(bArr, h2, h2 + i10)) {
                            throw zzdok.h();
                        }
                        unsafe.putObject(t, j2, new String(bArr, h2, i10, zzdod.a));
                        h2 += i10;
                    }
                    unsafe.putInt(t, j4, i5);
                    return h2;
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    int g2 = au.g(N(i9), bArr, i2, i3, buVar);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object == null) {
                        unsafe.putObject(t, j2, buVar.f12361c);
                    } else {
                        unsafe.putObject(t, j2, zzdod.g(object, buVar.f12361c));
                    }
                    unsafe.putInt(t, j4, i5);
                    return g2;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    j3 = au.m(bArr, i2, buVar);
                    unsafe.putObject(t, j2, buVar.f12361c);
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int h3 = au.h(bArr, i2, buVar);
                    int i11 = buVar.a;
                    zzdog P = P(i9);
                    if (P != null && !P.a(i11)) {
                        D(t).k(i4, Long.valueOf(i11));
                        return h3;
                    }
                    unsafe.putObject(t, j2, Integer.valueOf(i11));
                    j3 = h3;
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    j3 = au.h(bArr, i2, buVar);
                    unsafe.putObject(t, j2, Integer.valueOf(zzdnd.B(buVar.a)));
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    j3 = au.j(bArr, i2, buVar);
                    unsafe.putObject(t, j2, Long.valueOf(zzdnd.w(buVar.f12360b)));
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    j3 = au.f(N(i9), bArr, i2, i3, (i4 & (-8)) | 4, buVar);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j2, buVar.f12361c);
                    } else {
                        unsafe.putObject(t, j2, zzdod.g(object2, buVar.f12361c));
                    }
                    unsafe.putInt(t, j4, i5);
                    return j3;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0037. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private final int m(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, bu buVar) throws IOException {
        int h2;
        int i9 = i2;
        Unsafe unsafe = f12268b;
        zzdoj zzdojVar = (zzdoj) unsafe.getObject(t, j3);
        if (!zzdojVar.m0()) {
            int size = zzdojVar.size();
            zzdojVar = zzdojVar.N(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j3, zzdojVar);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    tu tuVar = (tu) zzdojVar;
                    int h3 = au.h(bArr, i9, buVar);
                    int i10 = buVar.a + h3;
                    while (h3 < i10) {
                        tuVar.f(au.p(bArr, h3));
                        h3 += 8;
                    }
                    if (h3 == i10) {
                        return h3;
                    }
                    throw zzdok.a();
                }
                if (i6 == 1) {
                    tu tuVar2 = (tu) zzdojVar;
                    tuVar2.f(au.p(bArr, i2));
                    while (true) {
                        int i11 = i9 + 8;
                        if (i11 >= i3) {
                            return i11;
                        }
                        i9 = au.h(bArr, i11, buVar);
                        if (i4 != buVar.a) {
                            return i11;
                        }
                        tuVar2.f(au.p(bArr, i9));
                    }
                }
                return i9;
            case 19:
            case 36:
                if (i6 == 2) {
                    cv cvVar = (cv) zzdojVar;
                    int h4 = au.h(bArr, i9, buVar);
                    int i12 = buVar.a + h4;
                    while (h4 < i12) {
                        cvVar.i(au.q(bArr, h4));
                        h4 += 4;
                    }
                    if (h4 == i12) {
                        return h4;
                    }
                    throw zzdok.a();
                }
                if (i6 == 5) {
                    cv cvVar2 = (cv) zzdojVar;
                    cvVar2.i(au.q(bArr, i2));
                    while (true) {
                        int i13 = i9 + 4;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i9 = au.h(bArr, i13, buVar);
                        if (i4 != buVar.a) {
                            return i13;
                        }
                        cvVar2.i(au.q(bArr, i9));
                    }
                }
                return i9;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    ov ovVar = (ov) zzdojVar;
                    int h5 = au.h(bArr, i9, buVar);
                    int i14 = buVar.a + h5;
                    while (h5 < i14) {
                        h5 = au.j(bArr, h5, buVar);
                        ovVar.i(buVar.f12360b);
                    }
                    if (h5 == i14) {
                        return h5;
                    }
                    throw zzdok.a();
                }
                if (i6 == 0) {
                    ov ovVar2 = (ov) zzdojVar;
                    int j4 = au.j(bArr, i9, buVar);
                    ovVar2.i(buVar.f12360b);
                    while (j4 < i3) {
                        int h6 = au.h(bArr, j4, buVar);
                        if (i4 != buVar.a) {
                            return j4;
                        }
                        j4 = au.j(bArr, h6, buVar);
                        ovVar2.i(buVar.f12360b);
                    }
                    return j4;
                }
                return i9;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return au.i(bArr, i9, zzdojVar, buVar);
                }
                if (i6 == 0) {
                    return au.b(i4, bArr, i2, i3, zzdojVar, buVar);
                }
                return i9;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    ov ovVar3 = (ov) zzdojVar;
                    int h7 = au.h(bArr, i9, buVar);
                    int i15 = buVar.a + h7;
                    while (h7 < i15) {
                        ovVar3.i(au.o(bArr, h7));
                        h7 += 8;
                    }
                    if (h7 == i15) {
                        return h7;
                    }
                    throw zzdok.a();
                }
                if (i6 == 1) {
                    ov ovVar4 = (ov) zzdojVar;
                    ovVar4.i(au.o(bArr, i2));
                    while (true) {
                        int i16 = i9 + 8;
                        if (i16 >= i3) {
                            return i16;
                        }
                        i9 = au.h(bArr, i16, buVar);
                        if (i4 != buVar.a) {
                            return i16;
                        }
                        ovVar4.i(au.o(bArr, i9));
                    }
                }
                return i9;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    gv gvVar = (gv) zzdojVar;
                    int h8 = au.h(bArr, i9, buVar);
                    int i17 = buVar.a + h8;
                    while (h8 < i17) {
                        gvVar.Z0(au.n(bArr, h8));
                        h8 += 4;
                    }
                    if (h8 == i17) {
                        return h8;
                    }
                    throw zzdok.a();
                }
                if (i6 == 5) {
                    gv gvVar2 = (gv) zzdojVar;
                    gvVar2.Z0(au.n(bArr, i2));
                    while (true) {
                        int i18 = i9 + 4;
                        if (i18 >= i3) {
                            return i18;
                        }
                        i9 = au.h(bArr, i18, buVar);
                        if (i4 != buVar.a) {
                            return i18;
                        }
                        gvVar2.Z0(au.n(bArr, i9));
                    }
                }
                return i9;
            case 25:
            case 42:
                if (i6 == 2) {
                    cu cuVar = (cu) zzdojVar;
                    h2 = au.h(bArr, i9, buVar);
                    int i19 = buVar.a + h2;
                    while (h2 < i19) {
                        h2 = au.j(bArr, h2, buVar);
                        cuVar.f(buVar.f12360b != 0);
                    }
                    if (h2 != i19) {
                        throw zzdok.a();
                    }
                    return h2;
                }
                if (i6 == 0) {
                    cu cuVar2 = (cu) zzdojVar;
                    i9 = au.j(bArr, i9, buVar);
                    cuVar2.f(buVar.f12360b != 0);
                    while (i9 < i3) {
                        int h9 = au.h(bArr, i9, buVar);
                        if (i4 == buVar.a) {
                            i9 = au.j(bArr, h9, buVar);
                            cuVar2.f(buVar.f12360b != 0);
                        }
                    }
                }
                return i9;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        i9 = au.h(bArr, i9, buVar);
                        int i20 = buVar.a;
                        if (i20 < 0) {
                            throw zzdok.b();
                        }
                        if (i20 == 0) {
                            zzdojVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            zzdojVar.add(new String(bArr, i9, i20, zzdod.a));
                            i9 += i20;
                        }
                        while (i9 < i3) {
                            int h10 = au.h(bArr, i9, buVar);
                            if (i4 == buVar.a) {
                                i9 = au.h(bArr, h10, buVar);
                                int i21 = buVar.a;
                                if (i21 < 0) {
                                    throw zzdok.b();
                                }
                                if (i21 == 0) {
                                    zzdojVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    zzdojVar.add(new String(bArr, i9, i21, zzdod.a));
                                    i9 += i21;
                                }
                            }
                        }
                    } else {
                        i9 = au.h(bArr, i9, buVar);
                        int i22 = buVar.a;
                        if (i22 < 0) {
                            throw zzdok.b();
                        }
                        if (i22 == 0) {
                            zzdojVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            int i23 = i9 + i22;
                            if (jx.k(bArr, i9, i23)) {
                                zzdojVar.add(new String(bArr, i9, i22, zzdod.a));
                                i9 = i23;
                            } else {
                                throw zzdok.h();
                            }
                        }
                        while (i9 < i3) {
                            int h11 = au.h(bArr, i9, buVar);
                            if (i4 == buVar.a) {
                                i9 = au.h(bArr, h11, buVar);
                                int i24 = buVar.a;
                                if (i24 < 0) {
                                    throw zzdok.b();
                                }
                                if (i24 == 0) {
                                    zzdojVar.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    int i25 = i9 + i24;
                                    if (jx.k(bArr, i9, i25)) {
                                        zzdojVar.add(new String(bArr, i9, i24, zzdod.a));
                                        i9 = i25;
                                    } else {
                                        throw zzdok.h();
                                    }
                                }
                            }
                        }
                    }
                }
                return i9;
            case 27:
                if (i6 == 2) {
                    return au.e(N(i7), i4, bArr, i2, i3, zzdojVar, buVar);
                }
                return i9;
            case 28:
                if (i6 == 2) {
                    int h12 = au.h(bArr, i9, buVar);
                    int i26 = buVar.a;
                    if (i26 >= 0) {
                        if (i26 > bArr.length - h12) {
                            throw zzdok.a();
                        }
                        if (i26 == 0) {
                            zzdojVar.add(zzdmr.f15982f);
                        } else {
                            zzdojVar.add(zzdmr.A(bArr, h12, i26));
                            h12 += i26;
                        }
                        while (h12 < i3) {
                            int h13 = au.h(bArr, h12, buVar);
                            if (i4 != buVar.a) {
                                return h12;
                            }
                            h12 = au.h(bArr, h13, buVar);
                            int i27 = buVar.a;
                            if (i27 >= 0) {
                                if (i27 > bArr.length - h12) {
                                    throw zzdok.a();
                                }
                                if (i27 == 0) {
                                    zzdojVar.add(zzdmr.f15982f);
                                } else {
                                    zzdojVar.add(zzdmr.A(bArr, h12, i27));
                                    h12 += i27;
                                }
                            } else {
                                throw zzdok.b();
                            }
                        }
                        return h12;
                    }
                    throw zzdok.b();
                }
                return i9;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        h2 = au.b(i4, bArr, i2, i3, zzdojVar, buVar);
                    }
                    return i9;
                }
                h2 = au.i(bArr, i9, zzdojVar, buVar);
                zzdob zzdobVar = (zzdob) t;
                zzdqu zzdquVar = zzdobVar.zzhhd;
                if (zzdquVar == zzdqu.f()) {
                    zzdquVar = null;
                }
                zzdqu zzdquVar2 = (zzdqu) nw.b(i5, zzdojVar, P(i7), zzdquVar, this.q);
                if (zzdquVar2 != null) {
                    zzdobVar.zzhhd = zzdquVar2;
                }
                return h2;
            case 33:
            case 47:
                if (i6 == 2) {
                    gv gvVar3 = (gv) zzdojVar;
                    int h14 = au.h(bArr, i9, buVar);
                    int i28 = buVar.a + h14;
                    while (h14 < i28) {
                        h14 = au.h(bArr, h14, buVar);
                        gvVar3.Z0(zzdnd.B(buVar.a));
                    }
                    if (h14 == i28) {
                        return h14;
                    }
                    throw zzdok.a();
                }
                if (i6 == 0) {
                    gv gvVar4 = (gv) zzdojVar;
                    int h15 = au.h(bArr, i9, buVar);
                    gvVar4.Z0(zzdnd.B(buVar.a));
                    while (h15 < i3) {
                        int h16 = au.h(bArr, h15, buVar);
                        if (i4 != buVar.a) {
                            return h15;
                        }
                        h15 = au.h(bArr, h16, buVar);
                        gvVar4.Z0(zzdnd.B(buVar.a));
                    }
                    return h15;
                }
                return i9;
            case 34:
            case 48:
                if (i6 == 2) {
                    ov ovVar5 = (ov) zzdojVar;
                    int h17 = au.h(bArr, i9, buVar);
                    int i29 = buVar.a + h17;
                    while (h17 < i29) {
                        h17 = au.j(bArr, h17, buVar);
                        ovVar5.i(zzdnd.w(buVar.f12360b));
                    }
                    if (h17 == i29) {
                        return h17;
                    }
                    throw zzdok.a();
                }
                if (i6 == 0) {
                    ov ovVar6 = (ov) zzdojVar;
                    int j5 = au.j(bArr, i9, buVar);
                    ovVar6.i(zzdnd.w(buVar.f12360b));
                    while (j5 < i3) {
                        int h18 = au.h(bArr, j5, buVar);
                        if (i4 != buVar.a) {
                            return j5;
                        }
                        j5 = au.j(bArr, h18, buVar);
                        ovVar6.i(zzdnd.w(buVar.f12360b));
                    }
                    return j5;
                }
                return i9;
            case 49:
                if (i6 == 3) {
                    lw N = N(i7);
                    int i30 = (i4 & (-8)) | 4;
                    i9 = au.f(N, bArr, i2, i3, i30, buVar);
                    zzdojVar.add(buVar.f12361c);
                    while (i9 < i3) {
                        int h19 = au.h(bArr, i9, buVar);
                        if (i4 == buVar.a) {
                            i9 = au.f(N, bArr, h19, i3, i30, buVar);
                            zzdojVar.add(buVar.f12361c);
                        }
                    }
                }
                return i9;
            default:
                return i9;
        }
    }

    private final <K, V> int n(T t, byte[] bArr, int i2, int i3, int i4, long j2, bu buVar) throws IOException {
        Unsafe unsafe = f12268b;
        Object O = O(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.s.c(object)) {
            Object e2 = this.s.e(O);
            this.s.a(e2, object);
            unsafe.putObject(t, j2, e2);
            object = e2;
        }
        this.s.g(O);
        this.s.h(object);
        int h2 = au.h(bArr, i2, buVar);
        int i5 = buVar.a;
        if (i5 >= 0 && i5 <= i3 - h2) {
            throw null;
        }
        throw zzdok.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> aw<T> p(Class<T> cls, xv xvVar, cw cwVar, kv kvVar, cx<?, ?> cxVar, vu<?> vuVar, uv uvVar) {
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
        iw iwVar;
        int i19;
        int objectFieldOffset;
        int i20;
        int i21;
        Class<?> cls2;
        String str;
        int i22;
        int i23;
        Field s;
        int i24;
        char charAt11;
        int i25;
        Field s2;
        Field s3;
        int i26;
        char charAt12;
        int i27;
        char charAt13;
        int i28;
        char charAt14;
        int i29;
        char charAt15;
        char charAt16;
        if (xvVar instanceof iw) {
            iw iwVar2 = (iw) xvVar;
            int i30 = 0;
            boolean z2 = iwVar2.c() == zzdob.zze.f16030j;
            String d2 = iwVar2.d();
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
            Unsafe unsafe = f12268b;
            Object[] e2 = iwVar2.e();
            Class<?> cls3 = iwVar2.b().getClass();
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
                        s2 = (Field) obj;
                    } else {
                        s2 = s(cls3, (String) obj);
                        e2[i89] = s2;
                    }
                    iwVar = iwVar2;
                    String str2 = d2;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(s2);
                    int i90 = i89 + 1;
                    Object obj2 = e2[i90];
                    if (obj2 instanceof Field) {
                        s3 = (Field) obj2;
                    } else {
                        s3 = s(cls3, (String) obj2);
                        e2[i90] = s3;
                    }
                    cls2 = cls3;
                    i20 = i5;
                    i18 = i88;
                    str = str2;
                    i23 = 0;
                    i22 = (int) unsafe.objectFieldOffset(s3);
                    i21 = i30;
                } else {
                    iwVar = iwVar2;
                    String str3 = d2;
                    int i91 = i5 + 1;
                    Field s4 = s(cls3, (String) e2[i5]);
                    if (i81 == 9 || i81 == 17) {
                        i19 = 1;
                        objArr[((i71 / 3) << 1) + 1] = s4.getType();
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
                    objectFieldOffset = (int) unsafe.objectFieldOffset(s4);
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
                            s = (Field) obj3;
                        } else {
                            s = s(cls3, (String) obj3);
                            e2[i98] = s;
                        }
                        i21 = i30;
                        cls2 = cls3;
                        i22 = (int) unsafe.objectFieldOffset(s);
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
                iwVar2 = iwVar;
            }
            return new aw<>(iArr3, objArr, charAt, i4, iwVar2.b(), z2, false, iArr, i6, i66, cwVar, kvVar, cxVar, vuVar, uvVar);
        }
        ((yw) xvVar).c();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB q(int i2, int i3, Map<K, V> map, zzdog zzdogVar, UB ub, cx<UT, UB> cxVar) {
        tv<?, ?> g2 = this.s.g(O(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzdogVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = cxVar.m();
                }
                ju x = zzdmr.x(zzdpc.a(g2, next.getKey(), next.getValue()));
                try {
                    zzdpc.b(x.b(), g2, next.getKey(), next.getValue());
                    cxVar.b(ub, i3, x.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB r(Object obj, int i2, UB ub, cx<UT, UB> cxVar) {
        zzdog P;
        int i3 = this.f12269c[i2];
        Object L = gx.L(obj, Q(i2) & 1048575);
        return (L == null || (P = P(i2)) == null) ? ub : (UB) q(i2, i3, this.s.h(L), P, ub, cxVar);
    }

    private static Field s(Class<?> cls, String str) {
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

    private static void t(int i2, Object obj, ux uxVar) throws IOException {
        if (obj instanceof String) {
            uxVar.X(i2, (String) obj);
        } else {
            uxVar.I(i2, (zzdmr) obj);
        }
    }

    private static <UT, UB> void u(cx<UT, UB> cxVar, T t, ux uxVar) throws IOException {
        cxVar.d(cxVar.j(t), uxVar);
    }

    private final <K, V> void v(ux uxVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            uxVar.V(i2, this.s.g(O(i3)), this.s.b(obj));
        }
    }

    private final void w(Object obj, int i2, kw kwVar) throws IOException {
        if (S(i2)) {
            gx.g(obj, i2 & 1048575, kwVar.M());
        } else if (this.f12275i) {
            gx.g(obj, i2 & 1048575, kwVar.a());
        } else {
            gx.g(obj, i2 & 1048575, kwVar.T());
        }
    }

    private final void x(T t, T t2, int i2) {
        long Q = Q(i2) & 1048575;
        if (I(t2, i2)) {
            Object L = gx.L(t, Q);
            Object L2 = gx.L(t2, Q);
            if (L != null && L2 != null) {
                gx.g(t, Q, zzdod.g(L, L2));
                K(t, i2);
            } else if (L2 != null) {
                gx.g(t, Q, L2);
                K(t, i2);
            }
        }
    }

    private final boolean y(T t, int i2, int i3) {
        return gx.E(t, (long) (R(i3) & 1048575)) == i2;
    }

    private final boolean z(T t, int i2, int i3, int i4) {
        if (this.f12276j) {
            return I(t, i2);
        }
        return (i3 & i4) != 0;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void a(T t, T t2) {
        t2.getClass();
        for (int i2 = 0; i2 < this.f12269c.length; i2 += 3) {
            int Q = Q(i2);
            long j2 = 1048575 & Q;
            int i3 = this.f12269c[i2];
            switch ((Q & 267386880) >>> 20) {
                case 0:
                    if (I(t2, i2)) {
                        gx.d(t, j2, gx.K(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (I(t2, i2)) {
                        gx.e(t, j2, gx.I(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (I(t2, i2)) {
                        gx.h(t, j2, gx.H(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (I(t2, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    x(t, t2, i2);
                    break;
                case 10:
                    if (I(t2, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    x(t, t2, i2);
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
                    this.p.b(t, t2, j2);
                    break;
                case 50:
                    nw.g(this.s, t, t2, j2);
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
                    if (y(t2, i3, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        E(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    G(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (y(t2, i3, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        E(t, i3, i2);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    G(t, t2, i2);
                    break;
            }
        }
        if (this.f12276j) {
            return;
        }
        nw.h(this.q, t, t2);
        if (this.f12274h) {
            nw.f(this.r, t, t2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (com.google.android.gms.internal.ads.nw.H(com.google.android.gms.internal.ads.gx.L(r10, r6), com.google.android.gms.internal.ads.gx.L(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (com.google.android.gms.internal.ads.gx.F(r10, r6) == com.google.android.gms.internal.ads.gx.F(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (com.google.android.gms.internal.ads.gx.E(r10, r6) == com.google.android.gms.internal.ads.gx.E(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (com.google.android.gms.internal.ads.gx.F(r10, r6) == com.google.android.gms.internal.ads.gx.F(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (com.google.android.gms.internal.ads.gx.E(r10, r6) == com.google.android.gms.internal.ads.gx.E(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (com.google.android.gms.internal.ads.gx.E(r10, r6) == com.google.android.gms.internal.ads.gx.E(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
    
        if (com.google.android.gms.internal.ads.gx.E(r10, r6) == com.google.android.gms.internal.ads.gx.E(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (com.google.android.gms.internal.ads.nw.H(com.google.android.gms.internal.ads.gx.L(r10, r6), com.google.android.gms.internal.ads.gx.L(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        if (com.google.android.gms.internal.ads.nw.H(com.google.android.gms.internal.ads.gx.L(r10, r6), com.google.android.gms.internal.ads.gx.L(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (com.google.android.gms.internal.ads.nw.H(com.google.android.gms.internal.ads.gx.L(r10, r6), com.google.android.gms.internal.ads.gx.L(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
    
        if (com.google.android.gms.internal.ads.gx.H(r10, r6) == com.google.android.gms.internal.ads.gx.H(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
    
        if (com.google.android.gms.internal.ads.gx.E(r10, r6) == com.google.android.gms.internal.ads.gx.E(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (com.google.android.gms.internal.ads.gx.F(r10, r6) == com.google.android.gms.internal.ads.gx.F(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        if (com.google.android.gms.internal.ads.gx.E(r10, r6) == com.google.android.gms.internal.ads.gx.E(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
    
        if (com.google.android.gms.internal.ads.gx.F(r10, r6) == com.google.android.gms.internal.ads.gx.F(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        if (com.google.android.gms.internal.ads.gx.F(r10, r6) == com.google.android.gms.internal.ads.gx.F(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.gx.I(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.gx.I(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.gx.K(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.gx.K(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (com.google.android.gms.internal.ads.nw.H(com.google.android.gms.internal.ads.gx.L(r10, r6), com.google.android.gms.internal.ads.gx.L(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c5 A[LOOP:0: B:2:0x0005->B:86:0x01c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.lw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(T t, T t2) {
        int length = this.f12269c.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                int Q = Q(i2);
                long j2 = Q & 1048575;
                switch ((Q & 267386880) >>> 20) {
                    case 0:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                            return false;
                        }
                        i2 += 3;
                    case 1:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 2:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 3:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 4:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 5:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 6:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 7:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 8:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 9:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 10:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 11:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 12:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 13:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 14:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 15:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 16:
                        if (H(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        if (z) {
                        }
                        break;
                    case 17:
                        if (H(t, t2, i2)) {
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
                        z = nw.H(gx.L(t, j2), gx.L(t2, j2));
                        if (z) {
                        }
                        break;
                    case 50:
                        z = nw.H(gx.L(t, j2), gx.L(t2, j2));
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
                        if (gx.E(t, R) == gx.E(t2, R)) {
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
                if (!this.q.j(t).equals(this.q.j(t2))) {
                    return false;
                }
                if (this.f12274h) {
                    return this.r.i(t).equals(this.r.i(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final T c() {
        return (T) this.o.a(this.f12273g);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.lw
    public final int d(T t) {
        int i2;
        int i3;
        int length = this.f12269c.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int Q = Q(i5);
            int i6 = this.f12269c[i5];
            long j2 = 1048575 & Q;
            int i7 = 37;
            switch ((Q & 267386880) >>> 20) {
                case 0:
                    i2 = i4 * 53;
                    i3 = zzdod.i(Double.doubleToLongBits(gx.K(t, j2)));
                    i4 = i2 + i3;
                    break;
                case 1:
                    i2 = i4 * 53;
                    i3 = Float.floatToIntBits(gx.I(t, j2));
                    i4 = i2 + i3;
                    break;
                case 2:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 3:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 4:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 5:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 6:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i2 = i4 * 53;
                    i3 = zzdod.h(gx.H(t, j2));
                    i4 = i2 + i3;
                    break;
                case 8:
                    i2 = i4 * 53;
                    i3 = ((String) gx.L(t, j2)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    Object L = gx.L(t, j2);
                    if (L != null) {
                        i7 = L.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
                    break;
                case 10:
                    i2 = i4 * 53;
                    i3 = gx.L(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 11:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 12:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 13:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 14:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 15:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 16:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 17:
                    Object L2 = gx.L(t, j2);
                    if (L2 != null) {
                        i7 = L2.hashCode();
                    }
                    i4 = (i4 * 53) + i7;
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
                    i2 = i4 * 53;
                    i3 = gx.L(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 50:
                    i2 = i4 * 53;
                    i3 = gx.L(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 51:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(Double.doubleToLongBits(L(t, j2)));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = Float.floatToIntBits(M(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.h(W(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = ((String) gx.L(t, j2)).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = gx.L(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = gx.L(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = gx.L(t, j2).hashCode();
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i4 * 53) + this.q.j(t).hashCode();
        return this.f12274h ? (hashCode * 53) + this.r.i(t).hashCode() : hashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a26  */
    @Override // com.google.android.gms.internal.ads.lw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(T t, ux uxVar) throws IOException {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        int i2;
        Iterator<Map.Entry<?, Object>> it2;
        Map.Entry<?, ?> entry2;
        int length2;
        if (uxVar.F() == zzdob.zze.m) {
            u(this.q, t, uxVar);
            if (this.f12274h) {
                yu<?> i3 = this.r.i(t);
                if (!i3.b()) {
                    it2 = i3.a();
                    entry2 = (Map.Entry) it2.next();
                    for (length2 = this.f12269c.length - 3; length2 >= 0; length2 -= 3) {
                        int Q = Q(length2);
                        int i4 = this.f12269c[length2];
                        while (entry2 != null && this.r.a(entry2) > i4) {
                            this.r.f(uxVar, entry2);
                            entry2 = it2.hasNext() ? (Map.Entry) it2.next() : null;
                        }
                        switch ((Q & 267386880) >>> 20) {
                            case 0:
                                if (I(t, length2)) {
                                    uxVar.E(i4, gx.K(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (I(t, length2)) {
                                    uxVar.r(i4, gx.I(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (I(t, length2)) {
                                    uxVar.J(i4, gx.F(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (I(t, length2)) {
                                    uxVar.L(i4, gx.F(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (I(t, length2)) {
                                    uxVar.T(i4, gx.E(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (I(t, length2)) {
                                    uxVar.B(i4, gx.F(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (I(t, length2)) {
                                    uxVar.D(i4, gx.E(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (I(t, length2)) {
                                    uxVar.R(i4, gx.H(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (I(t, length2)) {
                                    t(i4, gx.L(t, Q & 1048575), uxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (I(t, length2)) {
                                    uxVar.Y(i4, gx.L(t, Q & 1048575), N(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (I(t, length2)) {
                                    uxVar.I(i4, (zzdmr) gx.L(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (I(t, length2)) {
                                    uxVar.K(i4, gx.E(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (I(t, length2)) {
                                    uxVar.N(i4, gx.E(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (I(t, length2)) {
                                    uxVar.H(i4, gx.E(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (I(t, length2)) {
                                    uxVar.M(i4, gx.F(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (I(t, length2)) {
                                    uxVar.O(i4, gx.E(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (I(t, length2)) {
                                    uxVar.P(i4, gx.F(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (I(t, length2)) {
                                    uxVar.U(i4, gx.L(t, Q & 1048575), N(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                nw.e(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 19:
                                nw.x(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 20:
                                nw.C(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 21:
                                nw.F(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 22:
                                nw.K(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 23:
                                nw.I(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 24:
                                nw.O(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 25:
                                nw.R(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 26:
                                nw.c(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar);
                                break;
                            case 27:
                                nw.d(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, N(length2));
                                break;
                            case 28:
                                nw.v(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar);
                                break;
                            case 29:
                                nw.M(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 30:
                                nw.Q(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 31:
                                nw.P(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 32:
                                nw.J(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 33:
                                nw.N(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 34:
                                nw.G(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, false);
                                break;
                            case 35:
                                nw.e(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 36:
                                nw.x(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 37:
                                nw.C(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 38:
                                nw.F(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 39:
                                nw.K(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 40:
                                nw.I(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 41:
                                nw.O(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 42:
                                nw.R(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 43:
                                nw.M(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 44:
                                nw.Q(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 45:
                                nw.P(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 46:
                                nw.J(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 47:
                                nw.N(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 48:
                                nw.G(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, true);
                                break;
                            case 49:
                                nw.w(this.f12269c[length2], (List) gx.L(t, Q & 1048575), uxVar, N(length2));
                                break;
                            case 50:
                                v(uxVar, i4, gx.L(t, Q & 1048575), length2);
                                break;
                            case 51:
                                if (y(t, i4, length2)) {
                                    uxVar.E(i4, L(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (y(t, i4, length2)) {
                                    uxVar.r(i4, M(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (y(t, i4, length2)) {
                                    uxVar.J(i4, V(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (y(t, i4, length2)) {
                                    uxVar.L(i4, V(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (y(t, i4, length2)) {
                                    uxVar.T(i4, U(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (y(t, i4, length2)) {
                                    uxVar.B(i4, V(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (y(t, i4, length2)) {
                                    uxVar.D(i4, U(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (y(t, i4, length2)) {
                                    uxVar.R(i4, W(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (y(t, i4, length2)) {
                                    t(i4, gx.L(t, Q & 1048575), uxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (y(t, i4, length2)) {
                                    uxVar.Y(i4, gx.L(t, Q & 1048575), N(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (y(t, i4, length2)) {
                                    uxVar.I(i4, (zzdmr) gx.L(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (y(t, i4, length2)) {
                                    uxVar.K(i4, U(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (y(t, i4, length2)) {
                                    uxVar.N(i4, U(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (y(t, i4, length2)) {
                                    uxVar.H(i4, U(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (y(t, i4, length2)) {
                                    uxVar.M(i4, V(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (y(t, i4, length2)) {
                                    uxVar.O(i4, U(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (y(t, i4, length2)) {
                                    uxVar.P(i4, V(t, Q & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (y(t, i4, length2)) {
                                    uxVar.U(i4, gx.L(t, Q & 1048575), N(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.r.f(uxVar, entry2);
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
        if (this.f12276j) {
            if (this.f12274h) {
                yu<?> i5 = this.r.i(t);
                if (!i5.b()) {
                    it = i5.e();
                    entry = (Map.Entry) it.next();
                    length = this.f12269c.length;
                    for (i2 = 0; i2 < length; i2 += 3) {
                        int Q2 = Q(i2);
                        int i6 = this.f12269c[i2];
                        while (entry != null && this.r.a(entry) <= i6) {
                            this.r.f(uxVar, entry);
                            entry = it.hasNext() ? (Map.Entry) it.next() : null;
                        }
                        switch ((Q2 & 267386880) >>> 20) {
                            case 0:
                                if (I(t, i2)) {
                                    uxVar.E(i6, gx.K(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (I(t, i2)) {
                                    uxVar.r(i6, gx.I(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (I(t, i2)) {
                                    uxVar.J(i6, gx.F(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (I(t, i2)) {
                                    uxVar.L(i6, gx.F(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (I(t, i2)) {
                                    uxVar.T(i6, gx.E(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (I(t, i2)) {
                                    uxVar.B(i6, gx.F(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (I(t, i2)) {
                                    uxVar.D(i6, gx.E(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (I(t, i2)) {
                                    uxVar.R(i6, gx.H(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (I(t, i2)) {
                                    t(i6, gx.L(t, Q2 & 1048575), uxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (I(t, i2)) {
                                    uxVar.Y(i6, gx.L(t, Q2 & 1048575), N(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (I(t, i2)) {
                                    uxVar.I(i6, (zzdmr) gx.L(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (I(t, i2)) {
                                    uxVar.K(i6, gx.E(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (I(t, i2)) {
                                    uxVar.N(i6, gx.E(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (I(t, i2)) {
                                    uxVar.H(i6, gx.E(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (I(t, i2)) {
                                    uxVar.M(i6, gx.F(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (I(t, i2)) {
                                    uxVar.O(i6, gx.E(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (I(t, i2)) {
                                    uxVar.P(i6, gx.F(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (I(t, i2)) {
                                    uxVar.U(i6, gx.L(t, Q2 & 1048575), N(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                nw.e(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 19:
                                nw.x(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 20:
                                nw.C(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 21:
                                nw.F(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 22:
                                nw.K(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 23:
                                nw.I(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 24:
                                nw.O(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 25:
                                nw.R(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 26:
                                nw.c(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar);
                                break;
                            case 27:
                                nw.d(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, N(i2));
                                break;
                            case 28:
                                nw.v(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar);
                                break;
                            case 29:
                                nw.M(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 30:
                                nw.Q(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 31:
                                nw.P(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 32:
                                nw.J(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 33:
                                nw.N(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 34:
                                nw.G(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, false);
                                break;
                            case 35:
                                nw.e(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 36:
                                nw.x(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 37:
                                nw.C(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 38:
                                nw.F(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 39:
                                nw.K(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 40:
                                nw.I(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 41:
                                nw.O(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 42:
                                nw.R(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 43:
                                nw.M(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 44:
                                nw.Q(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 45:
                                nw.P(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 46:
                                nw.J(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 47:
                                nw.N(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 48:
                                nw.G(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, true);
                                break;
                            case 49:
                                nw.w(this.f12269c[i2], (List) gx.L(t, Q2 & 1048575), uxVar, N(i2));
                                break;
                            case 50:
                                v(uxVar, i6, gx.L(t, Q2 & 1048575), i2);
                                break;
                            case 51:
                                if (y(t, i6, i2)) {
                                    uxVar.E(i6, L(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (y(t, i6, i2)) {
                                    uxVar.r(i6, M(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (y(t, i6, i2)) {
                                    uxVar.J(i6, V(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (y(t, i6, i2)) {
                                    uxVar.L(i6, V(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (y(t, i6, i2)) {
                                    uxVar.T(i6, U(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (y(t, i6, i2)) {
                                    uxVar.B(i6, V(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (y(t, i6, i2)) {
                                    uxVar.D(i6, U(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (y(t, i6, i2)) {
                                    uxVar.R(i6, W(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (y(t, i6, i2)) {
                                    t(i6, gx.L(t, Q2 & 1048575), uxVar);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (y(t, i6, i2)) {
                                    uxVar.Y(i6, gx.L(t, Q2 & 1048575), N(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (y(t, i6, i2)) {
                                    uxVar.I(i6, (zzdmr) gx.L(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (y(t, i6, i2)) {
                                    uxVar.K(i6, U(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (y(t, i6, i2)) {
                                    uxVar.N(i6, U(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (y(t, i6, i2)) {
                                    uxVar.H(i6, U(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (y(t, i6, i2)) {
                                    uxVar.M(i6, V(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (y(t, i6, i2)) {
                                    uxVar.O(i6, U(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (y(t, i6, i2)) {
                                    uxVar.P(i6, V(t, Q2 & 1048575));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (y(t, i6, i2)) {
                                    uxVar.U(i6, gx.L(t, Q2 & 1048575), N(i2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.r.f(uxVar, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    u(this.q, t, uxVar);
                    return;
                }
            }
            it = null;
            entry = null;
            length = this.f12269c.length;
            while (i2 < length) {
            }
            while (entry != null) {
            }
            u(this.q, t, uxVar);
            return;
        }
        F(t, uxVar);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void f(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long Q = Q(this.l[i3]) & 1048575;
            Object L = gx.L(t, Q);
            if (L != null) {
                gx.g(t, Q, this.s.d(L));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.e(t, this.l[i2]);
            i2++;
        }
        this.q.g(t);
        if (this.f12274h) {
            this.r.g(t);
        }
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
    @Override // com.google.android.gms.internal.ads.lw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(T t, byte[] bArr, int i2, int i3, bu buVar) throws IOException {
        byte b2;
        int i4;
        int T;
        int i5;
        int i6;
        int i7;
        Unsafe unsafe;
        int i8;
        int i9;
        int j2;
        aw<T> awVar = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i10 = i3;
        bu buVar2 = buVar;
        if (awVar.f12276j) {
            Unsafe unsafe2 = f12268b;
            int i11 = -1;
            int i12 = i2;
            int i13 = -1;
            int i14 = 0;
            while (i12 < i10) {
                int i15 = i12 + 1;
                byte b3 = bArr2[i12];
                if (b3 < 0) {
                    i4 = au.d(b3, bArr2, i15, buVar2);
                    b2 = buVar2.a;
                } else {
                    b2 = b3;
                    i4 = i15;
                }
                int i16 = b2 >>> 3;
                int i17 = b2 & 7;
                if (i16 > i13) {
                    T = awVar.B(i16, i14 / 3);
                } else {
                    T = awVar.T(i16);
                }
                int i18 = T;
                if (i18 == i11) {
                    i6 = i16;
                    i8 = i4;
                    unsafe = unsafe2;
                    i5 = 0;
                } else {
                    int i19 = awVar.f12269c[i18 + 1];
                    int i20 = (267386880 & i19) >>> 20;
                    long j3 = 1048575 & i19;
                    if (i20 <= 17) {
                        switch (i20) {
                            case 0:
                                i9 = i18;
                                if (i17 == 1) {
                                    gx.d(t2, j3, au.p(bArr2, i4));
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
                                    gx.e(t2, j3, au.q(bArr2, i4));
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
                                    j2 = au.j(bArr2, i4, buVar2);
                                    unsafe2.putLong(t, j3, buVar2.f12360b);
                                    i12 = j2;
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
                                    i12 = au.h(bArr2, i4, buVar2);
                                    unsafe2.putInt(t2, j3, buVar2.a);
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
                                    unsafe2.putLong(t, j3, au.o(bArr2, i4));
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
                                    unsafe2.putInt(t2, j3, au.n(bArr2, i4));
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
                                    int j4 = au.j(bArr2, i4, buVar2);
                                    gx.h(t2, j3, buVar2.f12360b != 0);
                                    i12 = j4;
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
                                        i12 = au.k(bArr2, i4, buVar2);
                                    } else {
                                        i12 = au.l(bArr2, i4, buVar2);
                                    }
                                    unsafe2.putObject(t2, j3, buVar2.f12361c);
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
                                    i12 = au.g(awVar.N(i18), bArr2, i4, i10, buVar2);
                                    Object object = unsafe2.getObject(t2, j3);
                                    if (object == null) {
                                        unsafe2.putObject(t2, j3, buVar2.f12361c);
                                    } else {
                                        unsafe2.putObject(t2, j3, zzdod.g(object, buVar2.f12361c));
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
                                    i12 = au.m(bArr2, i4, buVar2);
                                    unsafe2.putObject(t2, j3, buVar2.f12361c);
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
                                    i12 = au.h(bArr2, i4, buVar2);
                                    unsafe2.putInt(t2, j3, buVar2.a);
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
                                    i12 = au.h(bArr2, i4, buVar2);
                                    unsafe2.putInt(t2, j3, zzdnd.B(buVar2.a));
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
                                    j2 = au.j(bArr2, i4, buVar2);
                                    i9 = i18;
                                    unsafe2.putLong(t, j3, zzdnd.w(buVar2.f12360b));
                                    i12 = j2;
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
                            zzdoj zzdojVar = (zzdoj) unsafe2.getObject(t2, j3);
                            if (!zzdojVar.m0()) {
                                int size = zzdojVar.size();
                                zzdojVar = zzdojVar.N(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t2, j3, zzdojVar);
                            }
                            i12 = au.e(awVar.N(i18), b2, bArr, i4, i3, zzdojVar, buVar);
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
                            i12 = m(t, bArr, i4, i3, b2, i16, i17, i5, i19, i20, j3, buVar);
                        } else {
                            i6 = i16;
                            i7 = i4;
                            unsafe = unsafe2;
                            if (i20 == 50) {
                                if (i17 == 2) {
                                    i12 = n(t, bArr, i7, i3, i5, j3, buVar);
                                }
                                i8 = i7;
                            } else {
                                i12 = l(t, bArr, i7, i3, b2, i6, i17, i19, i20, j3, i5, buVar);
                            }
                        }
                        awVar = this;
                        t2 = t;
                        bArr2 = bArr;
                        i10 = i3;
                        buVar2 = buVar;
                        unsafe2 = unsafe;
                        i14 = i5;
                        i13 = i6;
                        i11 = -1;
                    }
                    i8 = i7;
                }
                i12 = au.c(b2, bArr, i8, i3, D(t), buVar);
                awVar = this;
                t2 = t;
                bArr2 = bArr;
                i10 = i3;
                buVar2 = buVar;
                unsafe2 = unsafe;
                i14 = i5;
                i13 = i6;
                i11 = -1;
            }
            if (i12 != i10) {
                throw zzdok.g();
            }
            return;
        }
        o(t, bArr, i2, i3, 0, buVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0085. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.lw
    public final void h(T t, kw kwVar, zzdno zzdnoVar) throws IOException {
        zzdnoVar.getClass();
        cx cxVar = this.q;
        vu<?> vuVar = this.r;
        yu<?> yuVar = null;
        Object obj = null;
        while (true) {
            try {
                int N = kwVar.N();
                int T = T(N);
                if (T < 0) {
                    if (N == Integer.MAX_VALUE) {
                        for (int i2 = this.m; i2 < this.n; i2++) {
                            obj = r(t, this.l[i2], obj, cxVar);
                        }
                        if (obj != null) {
                            cxVar.r(t, obj);
                            return;
                        }
                        return;
                    }
                    Object b2 = !this.f12274h ? null : vuVar.b(zzdnoVar, this.f12273g, N);
                    if (b2 != null) {
                        if (yuVar == null) {
                            yuVar = vuVar.j(t);
                        }
                        yu<?> yuVar2 = yuVar;
                        obj = vuVar.c(kwVar, b2, zzdnoVar, yuVar2, obj, cxVar);
                        yuVar = yuVar2;
                    } else {
                        cxVar.e(kwVar);
                        if (obj == null) {
                            obj = cxVar.k(t);
                        }
                        if (!cxVar.f(obj, kwVar)) {
                            for (int i3 = this.m; i3 < this.n; i3++) {
                                obj = r(t, this.l[i3], obj, cxVar);
                            }
                            if (obj != null) {
                                cxVar.r(t, obj);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int Q = Q(T);
                    switch ((267386880 & Q) >>> 20) {
                        case 0:
                            gx.d(t, Q & 1048575, kwVar.readDouble());
                            K(t, T);
                            break;
                        case 1:
                            gx.e(t, Q & 1048575, kwVar.readFloat());
                            K(t, T);
                            break;
                        case 2:
                            gx.f(t, Q & 1048575, kwVar.K());
                            K(t, T);
                            break;
                        case 3:
                            gx.f(t, Q & 1048575, kwVar.E());
                            K(t, T);
                            break;
                        case 4:
                            gx.n(t, Q & 1048575, kwVar.P());
                            K(t, T);
                            break;
                        case 5:
                            gx.f(t, Q & 1048575, kwVar.L());
                            K(t, T);
                            break;
                        case 6:
                            gx.n(t, Q & 1048575, kwVar.R());
                            K(t, T);
                            break;
                        case 7:
                            gx.h(t, Q & 1048575, kwVar.G());
                            K(t, T);
                            break;
                        case 8:
                            w(t, Q, kwVar);
                            K(t, T);
                            break;
                        case 9:
                            if (I(t, T)) {
                                long j2 = Q & 1048575;
                                gx.g(t, j2, zzdod.g(gx.L(t, j2), kwVar.U(N(T), zzdnoVar)));
                                break;
                            } else {
                                gx.g(t, Q & 1048575, kwVar.U(N(T), zzdnoVar));
                                K(t, T);
                                break;
                            }
                        case 10:
                            gx.g(t, Q & 1048575, kwVar.T());
                            K(t, T);
                            break;
                        case 11:
                            gx.n(t, Q & 1048575, kwVar.V());
                            K(t, T);
                            break;
                        case 12:
                            int X = kwVar.X();
                            zzdog P = P(T);
                            if (P != null && !P.a(X)) {
                                obj = nw.a(N, X, obj, cxVar);
                                break;
                            }
                            gx.n(t, Q & 1048575, X);
                            K(t, T);
                            break;
                        case 13:
                            gx.n(t, Q & 1048575, kwVar.b0());
                            K(t, T);
                            break;
                        case 14:
                            gx.f(t, Q & 1048575, kwVar.e0());
                            K(t, T);
                            break;
                        case 15:
                            gx.n(t, Q & 1048575, kwVar.D());
                            K(t, T);
                            break;
                        case 16:
                            gx.f(t, Q & 1048575, kwVar.J());
                            K(t, T);
                            break;
                        case 17:
                            if (I(t, T)) {
                                long j3 = Q & 1048575;
                                gx.g(t, j3, zzdod.g(gx.L(t, j3), kwVar.c0(N(T), zzdnoVar)));
                                break;
                            } else {
                                gx.g(t, Q & 1048575, kwVar.c0(N(T), zzdnoVar));
                                K(t, T);
                                break;
                            }
                        case 18:
                            kwVar.r(this.p.a(t, Q & 1048575));
                            break;
                        case 19:
                            kwVar.o(this.p.a(t, Q & 1048575));
                            break;
                        case 20:
                            kwVar.u(this.p.a(t, Q & 1048575));
                            break;
                        case 21:
                            kwVar.z(this.p.a(t, Q & 1048575));
                            break;
                        case 22:
                            kwVar.C(this.p.a(t, Q & 1048575));
                            break;
                        case 23:
                            kwVar.B(this.p.a(t, Q & 1048575));
                            break;
                        case 24:
                            kwVar.n(this.p.a(t, Q & 1048575));
                            break;
                        case 25:
                            kwVar.i(this.p.a(t, Q & 1048575));
                            break;
                        case 26:
                            if (S(Q)) {
                                kwVar.t(this.p.a(t, Q & 1048575));
                                break;
                            } else {
                                kwVar.b(this.p.a(t, Q & 1048575));
                                break;
                            }
                        case 27:
                            kwVar.Z(this.p.a(t, Q & 1048575), N(T), zzdnoVar);
                            break;
                        case 28:
                            kwVar.O(this.p.a(t, Q & 1048575));
                            break;
                        case 29:
                            kwVar.Y(this.p.a(t, Q & 1048575));
                            break;
                        case 30:
                            List<Integer> a2 = this.p.a(t, Q & 1048575);
                            kwVar.W(a2);
                            obj = nw.b(N, a2, P(T), obj, cxVar);
                            break;
                        case 31:
                            kwVar.d0(this.p.a(t, Q & 1048575));
                            break;
                        case 32:
                            kwVar.a0(this.p.a(t, Q & 1048575));
                            break;
                        case 33:
                            kwVar.I(this.p.a(t, Q & 1048575));
                            break;
                        case 34:
                            kwVar.H(this.p.a(t, Q & 1048575));
                            break;
                        case 35:
                            kwVar.r(this.p.a(t, Q & 1048575));
                            break;
                        case 36:
                            kwVar.o(this.p.a(t, Q & 1048575));
                            break;
                        case 37:
                            kwVar.u(this.p.a(t, Q & 1048575));
                            break;
                        case 38:
                            kwVar.z(this.p.a(t, Q & 1048575));
                            break;
                        case 39:
                            kwVar.C(this.p.a(t, Q & 1048575));
                            break;
                        case 40:
                            kwVar.B(this.p.a(t, Q & 1048575));
                            break;
                        case 41:
                            kwVar.n(this.p.a(t, Q & 1048575));
                            break;
                        case 42:
                            kwVar.i(this.p.a(t, Q & 1048575));
                            break;
                        case 43:
                            kwVar.Y(this.p.a(t, Q & 1048575));
                            break;
                        case 44:
                            List<Integer> a3 = this.p.a(t, Q & 1048575);
                            kwVar.W(a3);
                            obj = nw.b(N, a3, P(T), obj, cxVar);
                            break;
                        case 45:
                            kwVar.d0(this.p.a(t, Q & 1048575));
                            break;
                        case 46:
                            kwVar.a0(this.p.a(t, Q & 1048575));
                            break;
                        case 47:
                            kwVar.I(this.p.a(t, Q & 1048575));
                            break;
                        case 48:
                            kwVar.H(this.p.a(t, Q & 1048575));
                            break;
                        case 49:
                            kwVar.Q(this.p.a(t, Q & 1048575), N(T), zzdnoVar);
                            break;
                        case 50:
                            Object O = O(T);
                            long Q2 = Q(T) & 1048575;
                            Object L = gx.L(t, Q2);
                            if (L == null) {
                                L = this.s.e(O);
                                gx.g(t, Q2, L);
                            } else if (this.s.c(L)) {
                                Object e2 = this.s.e(O);
                                this.s.a(e2, L);
                                gx.g(t, Q2, e2);
                                L = e2;
                            }
                            kwVar.F(this.s.h(L), this.s.g(O), zzdnoVar);
                            break;
                        case 51:
                            gx.g(t, Q & 1048575, Double.valueOf(kwVar.readDouble()));
                            E(t, N, T);
                            break;
                        case 52:
                            gx.g(t, Q & 1048575, Float.valueOf(kwVar.readFloat()));
                            E(t, N, T);
                            break;
                        case 53:
                            gx.g(t, Q & 1048575, Long.valueOf(kwVar.K()));
                            E(t, N, T);
                            break;
                        case 54:
                            gx.g(t, Q & 1048575, Long.valueOf(kwVar.E()));
                            E(t, N, T);
                            break;
                        case 55:
                            gx.g(t, Q & 1048575, Integer.valueOf(kwVar.P()));
                            E(t, N, T);
                            break;
                        case 56:
                            gx.g(t, Q & 1048575, Long.valueOf(kwVar.L()));
                            E(t, N, T);
                            break;
                        case 57:
                            gx.g(t, Q & 1048575, Integer.valueOf(kwVar.R()));
                            E(t, N, T);
                            break;
                        case 58:
                            gx.g(t, Q & 1048575, Boolean.valueOf(kwVar.G()));
                            E(t, N, T);
                            break;
                        case 59:
                            w(t, Q, kwVar);
                            E(t, N, T);
                            break;
                        case 60:
                            if (y(t, N, T)) {
                                long j4 = Q & 1048575;
                                gx.g(t, j4, zzdod.g(gx.L(t, j4), kwVar.U(N(T), zzdnoVar)));
                            } else {
                                gx.g(t, Q & 1048575, kwVar.U(N(T), zzdnoVar));
                                K(t, T);
                            }
                            E(t, N, T);
                            break;
                        case 61:
                            gx.g(t, Q & 1048575, kwVar.T());
                            E(t, N, T);
                            break;
                        case 62:
                            gx.g(t, Q & 1048575, Integer.valueOf(kwVar.V()));
                            E(t, N, T);
                            break;
                        case 63:
                            int X2 = kwVar.X();
                            zzdog P2 = P(T);
                            if (P2 != null && !P2.a(X2)) {
                                obj = nw.a(N, X2, obj, cxVar);
                                break;
                            }
                            gx.g(t, Q & 1048575, Integer.valueOf(X2));
                            E(t, N, T);
                            break;
                        case 64:
                            gx.g(t, Q & 1048575, Integer.valueOf(kwVar.b0()));
                            E(t, N, T);
                            break;
                        case 65:
                            gx.g(t, Q & 1048575, Long.valueOf(kwVar.e0()));
                            E(t, N, T);
                            break;
                        case 66:
                            gx.g(t, Q & 1048575, Integer.valueOf(kwVar.D()));
                            E(t, N, T);
                            break;
                        case 67:
                            gx.g(t, Q & 1048575, Long.valueOf(kwVar.J()));
                            E(t, N, T);
                            break;
                        case 68:
                            gx.g(t, Q & 1048575, kwVar.c0(N(T), zzdnoVar));
                            E(t, N, T);
                            break;
                        default:
                            if (obj == null) {
                                try {
                                    obj = cxVar.m();
                                } catch (zzdol unused) {
                                    cxVar.e(kwVar);
                                    if (obj == null) {
                                        obj = cxVar.k(t);
                                    }
                                    if (!cxVar.f(obj, kwVar)) {
                                        for (int i4 = this.m; i4 < this.n; i4++) {
                                            obj = r(t, this.l[i4], obj, cxVar);
                                        }
                                        if (obj != null) {
                                            cxVar.r(t, obj);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!cxVar.f(obj, kwVar)) {
                                for (int i5 = this.m; i5 < this.n; i5++) {
                                    obj = r(t, this.l[i5], obj, cxVar);
                                }
                                if (obj != null) {
                                    cxVar.r(t, obj);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.m; i6 < this.n; i6++) {
                    obj = r(t, this.l[i6], obj, cxVar);
                }
                if (obj != null) {
                    cxVar.r(t, obj);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:299:0x0545. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.lw
    public final int i(T t) {
        int i2;
        int i3;
        long j2;
        int z0;
        int w0;
        int s;
        int o;
        int h0;
        int j0;
        int I;
        int o2;
        int h02;
        int j02;
        int i4 = 267386880;
        if (this.f12276j) {
            Unsafe unsafe = f12268b;
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.f12269c.length) {
                int Q = Q(i5);
                int i7 = (Q & i4) >>> 20;
                int i8 = this.f12269c[i5];
                long j3 = Q & 1048575;
                int i9 = (i7 < zzdnv.O.g() || i7 > zzdnv.b0.g()) ? 0 : this.f12269c[i5 + 2] & 1048575;
                switch (i7) {
                    case 0:
                        if (I(t, i5)) {
                            I = zzdni.I(i8, 0.0d);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (I(t, i5)) {
                            I = zzdni.x(i8, 0.0f);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (I(t, i5)) {
                            I = zzdni.z0(i8, gx.F(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (I(t, i5)) {
                            I = zzdni.B0(i8, gx.F(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (I(t, i5)) {
                            I = zzdni.m(i8, gx.E(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (I(t, i5)) {
                            I = zzdni.F0(i8, 0L);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (I(t, i5)) {
                            I = zzdni.r(i8, 0);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (I(t, i5)) {
                            I = zzdni.w0(i8, true);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (I(t, i5)) {
                            Object L = gx.L(t, j3);
                            if (L instanceof zzdmr) {
                                I = zzdni.J(i8, (zzdmr) L);
                            } else {
                                I = zzdni.c0(i8, (String) L);
                            }
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (I(t, i5)) {
                            I = nw.z(i8, gx.L(t, j3), N(i5));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (I(t, i5)) {
                            I = zzdni.J(i8, (zzdmr) gx.L(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (I(t, i5)) {
                            I = zzdni.o(i8, gx.E(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (I(t, i5)) {
                            I = zzdni.t(i8, gx.E(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (I(t, i5)) {
                            I = zzdni.s(i8, 0);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (I(t, i5)) {
                            I = zzdni.G0(i8, 0L);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (I(t, i5)) {
                            I = zzdni.q(i8, gx.E(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (I(t, i5)) {
                            I = zzdni.D0(i8, gx.F(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (I(t, i5)) {
                            I = zzdni.L(i8, (zzdpk) gx.L(t, j3), N(i5));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        I = nw.a0(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 19:
                        I = nw.Z(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 20:
                        I = nw.S(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 21:
                        I = nw.T(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 22:
                        I = nw.W(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 23:
                        I = nw.a0(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 24:
                        I = nw.Z(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 25:
                        I = nw.b0(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 26:
                        I = nw.A(i8, J(t, j3));
                        i6 += I;
                        break;
                    case 27:
                        I = nw.B(i8, J(t, j3), N(i5));
                        i6 += I;
                        break;
                    case 28:
                        I = nw.D(i8, J(t, j3));
                        i6 += I;
                        break;
                    case 29:
                        I = nw.X(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 30:
                        I = nw.V(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 31:
                        I = nw.Z(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 32:
                        I = nw.a0(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 33:
                        I = nw.Y(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 34:
                        I = nw.U(i8, J(t, j3), false);
                        i6 += I;
                        break;
                    case 35:
                        o2 = nw.o((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 36:
                        o2 = nw.n((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 37:
                        o2 = nw.c0((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 38:
                        o2 = nw.d0((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 39:
                        o2 = nw.k((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 40:
                        o2 = nw.o((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 41:
                        o2 = nw.n((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 42:
                        o2 = nw.p((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 43:
                        o2 = nw.l((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 44:
                        o2 = nw.j((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 45:
                        o2 = nw.n((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 46:
                        o2 = nw.o((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 47:
                        o2 = nw.m((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 48:
                        o2 = nw.i((List) unsafe.getObject(t, j3));
                        if (o2 <= 0) {
                            break;
                        } else {
                            if (this.f12277k) {
                                unsafe.putInt(t, i9, o2);
                            }
                            h02 = zzdni.h0(i8);
                            j02 = zzdni.j0(o2);
                            I = h02 + j02 + o2;
                            i6 += I;
                            break;
                        }
                    case 49:
                        I = nw.E(i8, J(t, j3), N(i5));
                        i6 += I;
                        break;
                    case 50:
                        I = this.s.f(i8, gx.L(t, j3), O(i5));
                        i6 += I;
                        break;
                    case 51:
                        if (y(t, i8, i5)) {
                            I = zzdni.I(i8, 0.0d);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (y(t, i8, i5)) {
                            I = zzdni.x(i8, 0.0f);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (y(t, i8, i5)) {
                            I = zzdni.z0(i8, V(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (y(t, i8, i5)) {
                            I = zzdni.B0(i8, V(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (y(t, i8, i5)) {
                            I = zzdni.m(i8, U(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (y(t, i8, i5)) {
                            I = zzdni.F0(i8, 0L);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (y(t, i8, i5)) {
                            I = zzdni.r(i8, 0);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (y(t, i8, i5)) {
                            I = zzdni.w0(i8, true);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (y(t, i8, i5)) {
                            Object L2 = gx.L(t, j3);
                            if (L2 instanceof zzdmr) {
                                I = zzdni.J(i8, (zzdmr) L2);
                            } else {
                                I = zzdni.c0(i8, (String) L2);
                            }
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (y(t, i8, i5)) {
                            I = nw.z(i8, gx.L(t, j3), N(i5));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (y(t, i8, i5)) {
                            I = zzdni.J(i8, (zzdmr) gx.L(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (y(t, i8, i5)) {
                            I = zzdni.o(i8, U(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (y(t, i8, i5)) {
                            I = zzdni.t(i8, U(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (y(t, i8, i5)) {
                            I = zzdni.s(i8, 0);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (y(t, i8, i5)) {
                            I = zzdni.G0(i8, 0L);
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (y(t, i8, i5)) {
                            I = zzdni.q(i8, U(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (y(t, i8, i5)) {
                            I = zzdni.D0(i8, V(t, j3));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (y(t, i8, i5)) {
                            I = zzdni.L(i8, (zzdpk) gx.L(t, j3), N(i5));
                            i6 += I;
                            break;
                        } else {
                            break;
                        }
                }
                i5 += 3;
                i4 = 267386880;
            }
            return i6 + k(this.q, t);
        }
        Unsafe unsafe2 = f12268b;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f12269c.length; i13 += 3) {
            int Q2 = Q(i13);
            int[] iArr = this.f12269c;
            int i14 = iArr[i13];
            int i15 = (Q2 & 267386880) >>> 20;
            if (i15 <= 17) {
                int i16 = iArr[i13 + 2];
                int i17 = i16 & 1048575;
                i3 = 1 << (i16 >>> 20);
                if (i17 != i10) {
                    i12 = unsafe2.getInt(t, i17);
                    i10 = i17;
                }
                i2 = i16;
            } else {
                i2 = (!this.f12277k || i15 < zzdnv.O.g() || i15 > zzdnv.b0.g()) ? 0 : this.f12269c[i13 + 2] & 1048575;
                i3 = 0;
            }
            long j4 = Q2 & 1048575;
            switch (i15) {
                case 0:
                    j2 = 0;
                    if ((i12 & i3) != 0) {
                        i11 += zzdni.I(i14, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j2 = 0;
                    if ((i12 & i3) != 0) {
                        i11 += zzdni.x(i14, 0.0f);
                        break;
                    }
                case 2:
                    j2 = 0;
                    if ((i12 & i3) != 0) {
                        z0 = zzdni.z0(i14, unsafe2.getLong(t, j4));
                        i11 += z0;
                    }
                    break;
                case 3:
                    j2 = 0;
                    if ((i12 & i3) != 0) {
                        z0 = zzdni.B0(i14, unsafe2.getLong(t, j4));
                        i11 += z0;
                    }
                    break;
                case 4:
                    j2 = 0;
                    if ((i12 & i3) != 0) {
                        z0 = zzdni.m(i14, unsafe2.getInt(t, j4));
                        i11 += z0;
                    }
                    break;
                case 5:
                    j2 = 0;
                    if ((i12 & i3) != 0) {
                        z0 = zzdni.F0(i14, 0L);
                        i11 += z0;
                    }
                    break;
                case 6:
                    if ((i12 & i3) != 0) {
                        i11 += zzdni.r(i14, 0);
                        j2 = 0;
                        break;
                    }
                    j2 = 0;
                case 7:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.w0(i14, true);
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 8:
                    if ((i12 & i3) != 0) {
                        Object object = unsafe2.getObject(t, j4);
                        if (object instanceof zzdmr) {
                            w0 = zzdni.J(i14, (zzdmr) object);
                        } else {
                            w0 = zzdni.c0(i14, (String) object);
                        }
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 9:
                    if ((i12 & i3) != 0) {
                        w0 = nw.z(i14, unsafe2.getObject(t, j4), N(i13));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 10:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.J(i14, (zzdmr) unsafe2.getObject(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 11:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.o(i14, unsafe2.getInt(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 12:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.t(i14, unsafe2.getInt(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 13:
                    if ((i12 & i3) != 0) {
                        s = zzdni.s(i14, 0);
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 14:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.G0(i14, 0L);
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 15:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.q(i14, unsafe2.getInt(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 16:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.D0(i14, unsafe2.getLong(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 17:
                    if ((i12 & i3) != 0) {
                        w0 = zzdni.L(i14, (zzdpk) unsafe2.getObject(t, j4), N(i13));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 18:
                    w0 = nw.a0(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 19:
                    w0 = nw.Z(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 20:
                    w0 = nw.S(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 21:
                    w0 = nw.T(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 22:
                    w0 = nw.W(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 23:
                    w0 = nw.a0(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 24:
                    w0 = nw.Z(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 25:
                    w0 = nw.b0(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 26:
                    w0 = nw.A(i14, (List) unsafe2.getObject(t, j4));
                    i11 += w0;
                    j2 = 0;
                    break;
                case 27:
                    w0 = nw.B(i14, (List) unsafe2.getObject(t, j4), N(i13));
                    i11 += w0;
                    j2 = 0;
                    break;
                case 28:
                    w0 = nw.D(i14, (List) unsafe2.getObject(t, j4));
                    i11 += w0;
                    j2 = 0;
                    break;
                case 29:
                    w0 = nw.X(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 30:
                    w0 = nw.V(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 31:
                    w0 = nw.Z(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 32:
                    w0 = nw.a0(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 33:
                    w0 = nw.Y(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 34:
                    w0 = nw.U(i14, (List) unsafe2.getObject(t, j4), false);
                    i11 += w0;
                    j2 = 0;
                    break;
                case 35:
                    o = nw.o((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 36:
                    o = nw.n((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 37:
                    o = nw.c0((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 38:
                    o = nw.d0((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 39:
                    o = nw.k((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 40:
                    o = nw.o((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 41:
                    o = nw.n((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 42:
                    o = nw.p((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 43:
                    o = nw.l((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 44:
                    o = nw.j((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 45:
                    o = nw.n((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 46:
                    o = nw.o((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 47:
                    o = nw.m((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 48:
                    o = nw.i((List) unsafe2.getObject(t, j4));
                    if (o > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i2, o);
                        }
                        h0 = zzdni.h0(i14);
                        j0 = zzdni.j0(o);
                        s = h0 + j0 + o;
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 49:
                    w0 = nw.E(i14, (List) unsafe2.getObject(t, j4), N(i13));
                    i11 += w0;
                    j2 = 0;
                    break;
                case 50:
                    w0 = this.s.f(i14, unsafe2.getObject(t, j4), O(i13));
                    i11 += w0;
                    j2 = 0;
                    break;
                case 51:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.I(i14, 0.0d);
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 52:
                    if (y(t, i14, i13)) {
                        s = zzdni.x(i14, 0.0f);
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 53:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.z0(i14, V(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 54:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.B0(i14, V(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 55:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.m(i14, U(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 56:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.F0(i14, 0L);
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 57:
                    if (y(t, i14, i13)) {
                        s = zzdni.r(i14, 0);
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 58:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.w0(i14, true);
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 59:
                    if (y(t, i14, i13)) {
                        Object object2 = unsafe2.getObject(t, j4);
                        if (object2 instanceof zzdmr) {
                            w0 = zzdni.J(i14, (zzdmr) object2);
                        } else {
                            w0 = zzdni.c0(i14, (String) object2);
                        }
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 60:
                    if (y(t, i14, i13)) {
                        w0 = nw.z(i14, unsafe2.getObject(t, j4), N(i13));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 61:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.J(i14, (zzdmr) unsafe2.getObject(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 62:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.o(i14, U(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 63:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.t(i14, U(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 64:
                    if (y(t, i14, i13)) {
                        s = zzdni.s(i14, 0);
                        i11 += s;
                    }
                    j2 = 0;
                    break;
                case 65:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.G0(i14, 0L);
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 66:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.q(i14, U(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 67:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.D0(i14, V(t, j4));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                case 68:
                    if (y(t, i14, i13)) {
                        w0 = zzdni.L(i14, (zzdpk) unsafe2.getObject(t, j4), N(i13));
                        i11 += w0;
                    }
                    j2 = 0;
                    break;
                default:
                    j2 = 0;
                    break;
            }
        }
        int k2 = i11 + k(this.q, t);
        return this.f12274h ? k2 + this.r.i(t).n() : k2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.lw
    public final boolean j(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= this.m) {
                return !this.f12274h || this.r.i(t).d();
            }
            int i6 = this.l[i4];
            int i7 = this.f12269c[i6];
            int Q = Q(i6);
            if (this.f12276j) {
                i2 = 0;
            } else {
                int i8 = this.f12269c[i6 + 2];
                int i9 = i8 & 1048575;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i5 = f12268b.getInt(t, i9);
                    i3 = i9;
                }
            }
            if (((268435456 & Q) != 0) && !z(t, i6, i5, i2)) {
                return false;
            }
            int i10 = (267386880 & Q) >>> 20;
            if (i10 != 9 && i10 != 17) {
                if (i10 != 27) {
                    if (i10 == 60 || i10 == 68) {
                        if (y(t, i7, i6) && !A(t, Q, N(i6))) {
                            return false;
                        }
                    } else if (i10 != 49) {
                        if (i10 == 50 && !this.s.b(gx.L(t, Q & 1048575)).isEmpty()) {
                            this.s.g(O(i6));
                            throw null;
                        }
                    }
                }
                List list = (List) gx.L(t, Q & 1048575);
                if (!list.isEmpty()) {
                    lw N = N(i6);
                    int i11 = 0;
                    while (true) {
                        if (i11 >= list.size()) {
                            break;
                        }
                        if (!N.j(list.get(i11))) {
                            z = false;
                            break;
                        }
                        i11++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (z(t, i6, i5, i2) && !A(t, Q, N(i6))) {
                return false;
            }
            i4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:113:0x007f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public final int o(T t, byte[] bArr, int i2, int i3, int i4, bu buVar) throws IOException {
        Unsafe unsafe;
        int i5;
        Object obj;
        aw<T> awVar;
        int i6;
        int i7;
        int T;
        int i8;
        int i9;
        int i10;
        int i11;
        Object obj2;
        bu buVar2;
        int i12;
        int i13;
        int i14;
        bu buVar3;
        int i15;
        bu buVar4;
        int i16;
        int i17;
        bu buVar5;
        int i18;
        int i19;
        int i20;
        aw<T> awVar2 = this;
        Object obj3 = t;
        byte[] bArr2 = bArr;
        int i21 = i3;
        int i22 = i4;
        bu buVar6 = buVar;
        Unsafe unsafe2 = f12268b;
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
                    i7 = au.d(b2, bArr2, i29, buVar6);
                    i6 = buVar6.a;
                } else {
                    i6 = b2;
                    i7 = i29;
                }
                int i30 = i6 >>> 3;
                int i31 = i6 & 7;
                if (i30 > i24) {
                    T = awVar2.B(i30, i25 / 3);
                } else {
                    T = awVar2.T(i30);
                }
                int i32 = T;
                if (i32 == -1) {
                    i8 = i30;
                    i9 = i7;
                    i10 = i6;
                    unsafe = unsafe2;
                    i5 = i22;
                    i11 = 0;
                } else {
                    int[] iArr = awVar2.f12269c;
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
                                buVar4 = buVar;
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
                                    gx.d(obj3, j2, au.p(bArr2, i16));
                                    i23 = i16 + 8;
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 1:
                                i12 = i32;
                                i13 = i30;
                                i15 = i28;
                                i14 = i35;
                                bArr2 = bArr;
                                buVar4 = buVar;
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
                                    gx.e(obj3, j2, au.q(bArr2, i16));
                                    i23 = i16 + 4;
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar4;
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
                                    int j3 = au.j(bArr2, i16, buVar);
                                    unsafe2.putLong(t, j2, buVar.f12360b);
                                    i27 |= i37;
                                    i23 = j3;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar;
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
                                buVar4 = buVar;
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
                                    i23 = au.h(bArr2, i16, buVar4);
                                    unsafe2.putInt(obj3, j2, buVar4.a);
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 5:
                            case 14:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                buVar4 = buVar;
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
                                    unsafe2.putLong(t, j2, au.o(bArr2, i7));
                                    i23 = i16 + 8;
                                    i27 |= i37;
                                    i28 = i15;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar4;
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
                                buVar5 = buVar;
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
                                    unsafe2.putInt(obj3, j2, au.n(bArr2, i7));
                                    i23 = i7 + 4;
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 7:
                                i17 = i3;
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                buVar5 = buVar;
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
                                    int j4 = au.j(bArr2, i7, buVar5);
                                    gx.h(obj3, j2, buVar5.f12360b != 0);
                                    i27 |= i37;
                                    i23 = j4;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 8:
                                i17 = i3;
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                buVar5 = buVar;
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
                                        i23 = au.k(bArr2, i7, buVar5);
                                    } else {
                                        i23 = au.l(bArr2, i7, buVar5);
                                    }
                                    unsafe2.putObject(obj3, j2, buVar5.f12361c);
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 9:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                buVar5 = buVar;
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
                                    i23 = au.g(awVar2.N(i12), bArr2, i7, i17, buVar5);
                                    if ((i27 & i37) == 0) {
                                        unsafe2.putObject(obj3, j2, buVar5.f12361c);
                                    } else {
                                        unsafe2.putObject(obj3, j2, zzdod.g(unsafe2.getObject(obj3, j2), buVar5.f12361c));
                                    }
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar5;
                                    i22 = i4;
                                    i21 = i17;
                                }
                            case 10:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                buVar4 = buVar;
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
                                    i23 = au.m(bArr2, i7, buVar4);
                                    unsafe2.putObject(obj3, j2, buVar4.f12361c);
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar4;
                                    i21 = i3;
                                    i22 = i4;
                                }
                            case 12:
                                i12 = i32;
                                i13 = i30;
                                i14 = i35;
                                bArr2 = bArr;
                                buVar4 = buVar;
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
                                    i23 = au.h(bArr2, i7, buVar4);
                                    int i39 = buVar4.a;
                                    zzdog P = awVar2.P(i12);
                                    if (P != null && !P.a(i39)) {
                                        D(t).k(i14, Long.valueOf(i39));
                                        i26 = i14;
                                        i25 = i12;
                                        i24 = i13;
                                        buVar6 = buVar4;
                                        i21 = i3;
                                        i22 = i4;
                                    } else {
                                        unsafe2.putInt(obj3, j2, i39);
                                        i27 |= i37;
                                        i26 = i14;
                                        i25 = i12;
                                        i24 = i13;
                                        buVar6 = buVar4;
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
                                buVar4 = buVar;
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
                                    i23 = au.h(bArr2, i7, buVar4);
                                    unsafe2.putInt(obj3, j2, zzdnd.B(buVar4.a));
                                    i27 |= i37;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar4;
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
                                    int j5 = au.j(bArr2, i7, buVar);
                                    buVar4 = buVar;
                                    unsafe2.putLong(t, j2, zzdnd.w(buVar.f12360b));
                                    i27 |= i37;
                                    i23 = j5;
                                    i26 = i14;
                                    i25 = i12;
                                    i24 = i13;
                                    buVar6 = buVar4;
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
                                    i23 = au.f(awVar2.N(i32), bArr, i7, i3, (i30 << 3) | 4, buVar);
                                    if ((i27 & i37) == 0) {
                                        buVar3 = buVar;
                                        unsafe2.putObject(obj3, j2, buVar3.f12361c);
                                    } else {
                                        buVar3 = buVar;
                                        unsafe2.putObject(obj3, j2, zzdod.g(unsafe2.getObject(obj3, j2), buVar3.f12361c));
                                    }
                                    i27 |= i37;
                                    bArr2 = bArr;
                                    i21 = i3;
                                    i26 = i35;
                                    i25 = i32;
                                    i24 = i30;
                                    i22 = i4;
                                    buVar6 = buVar3;
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
                        bu buVar7 = buVar6;
                        if (i34 != 27) {
                            i18 = i27;
                            if (i34 <= 49) {
                                i8 = i30;
                                i20 = i35;
                                i11 = i32;
                                unsafe = unsafe2;
                                i23 = m(t, bArr, i41, i3, i35, i30, i31, i32, i33, i34, j2, buVar);
                                if (i23 == i41) {
                                    i5 = i4;
                                    i9 = i23;
                                } else {
                                    awVar2 = this;
                                    obj3 = t;
                                    bArr2 = bArr;
                                    i21 = i3;
                                    i22 = i4;
                                    buVar6 = buVar;
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
                                    i23 = l(t, bArr, i19, i3, i20, i8, i31, i33, i34, j2, i11, buVar);
                                    if (i23 != i19) {
                                        awVar2 = this;
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
                                        buVar6 = buVar;
                                    }
                                } else if (i31 == 2) {
                                    i23 = n(t, bArr, i19, i3, i11, j2, buVar);
                                    if (i23 != i19) {
                                        awVar2 = this;
                                        obj3 = t;
                                        bArr2 = bArr;
                                        i21 = i3;
                                        i22 = i4;
                                        buVar6 = buVar;
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
                            zzdoj zzdojVar = (zzdoj) unsafe2.getObject(obj3, j2);
                            if (!zzdojVar.m0()) {
                                int size = zzdojVar.size();
                                zzdojVar = zzdojVar.N(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(obj3, j2, zzdojVar);
                            }
                            i23 = au.e(awVar2.N(i32), i35, bArr, i41, i3, zzdojVar, buVar);
                            i22 = i4;
                            i24 = i30;
                            i26 = i35;
                            i25 = i32;
                            buVar6 = buVar7;
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
                    if (this.f12274h) {
                        buVar2 = buVar;
                        if (buVar2.f12362d != zzdno.d()) {
                            int i42 = i8;
                            if (buVar2.f12362d.a(this.f12273g, i42) == null) {
                                i23 = au.c(i10, bArr, i9, i3, D(t), buVar);
                                obj3 = t;
                                i21 = i3;
                                i26 = i10;
                                awVar2 = this;
                                buVar6 = buVar2;
                                i24 = i42;
                                i25 = i11;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i22 = i5;
                            } else {
                                zzdob.zzc zzcVar = (zzdob.zzc) t;
                                if (zzcVar.zzhhj.c()) {
                                    zzcVar.zzhhj = (yu) zzcVar.zzhhj.clone();
                                }
                                throw new NoSuchMethodError();
                            }
                        } else {
                            obj2 = t;
                        }
                    } else {
                        obj2 = t;
                        buVar2 = buVar;
                    }
                    i23 = au.c(i10, bArr, i9, i3, D(t), buVar);
                    i26 = i10;
                    awVar2 = this;
                    buVar6 = buVar2;
                    i24 = i8;
                    obj3 = obj2;
                    i25 = i11;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i21 = i3;
                    i22 = i5;
                } else {
                    awVar = this;
                    obj = t;
                    i23 = i9;
                    i26 = i10;
                }
            } else {
                unsafe = unsafe2;
                i5 = i22;
                obj = obj3;
                awVar = awVar2;
            }
        }
        if (i28 != -1) {
            unsafe.putInt(obj, i28, i27);
        }
        zzdqu zzdquVar = null;
        for (int i43 = awVar.m; i43 < awVar.n; i43++) {
            zzdquVar = (zzdqu) awVar.r(obj, awVar.l[i43], zzdquVar, awVar.q);
        }
        if (zzdquVar != null) {
            awVar.q.r(obj, zzdquVar);
        }
        if (i5 == 0) {
            if (i23 != i3) {
                throw zzdok.g();
            }
        } else if (i23 > i3 || i26 != i5) {
            throw zzdok.g();
        }
        return i23;
    }
}
