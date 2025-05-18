package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzhy {
    private static final zzhy a = new zzhy(0, new int[0], new Object[0], false);

    /* renamed from: b, reason: collision with root package name */
    private int f17429b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f17430c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f17431d;

    /* renamed from: e, reason: collision with root package name */
    private int f17432e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f17433f;

    private zzhy() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzhy a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhy b(zzhy zzhyVar, zzhy zzhyVar2) {
        int i2 = zzhyVar.f17429b + zzhyVar2.f17429b;
        int[] copyOf = Arrays.copyOf(zzhyVar.f17430c, i2);
        System.arraycopy(zzhyVar2.f17430c, 0, copyOf, zzhyVar.f17429b, zzhyVar2.f17429b);
        Object[] copyOf2 = Arrays.copyOf(zzhyVar.f17431d, i2);
        System.arraycopy(zzhyVar2.f17431d, 0, copyOf2, zzhyVar.f17429b, zzhyVar2.f17429b);
        return new zzhy(i2, copyOf, copyOf2, true);
    }

    private static void d(int i2, Object obj, y4 y4Var) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            y4Var.q(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 1) {
            y4Var.L(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 2) {
            y4Var.E(i3, (zzdu) obj);
            return;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                y4Var.y(i3, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfo.f());
        }
        if (y4Var.a() == zzfd.zze.l) {
            y4Var.d(i3);
            ((zzhy) obj).h(y4Var);
            y4Var.e(i3);
        } else {
            y4Var.e(i3);
            ((zzhy) obj).h(y4Var);
            y4Var.d(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhy g() {
        return new zzhy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i2, Object obj) {
        if (this.f17433f) {
            int i3 = this.f17429b;
            int[] iArr = this.f17430c;
            if (i3 == iArr.length) {
                int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
                this.f17430c = Arrays.copyOf(iArr, i4);
                this.f17431d = Arrays.copyOf(this.f17431d, i4);
            }
            int[] iArr2 = this.f17430c;
            int i5 = this.f17429b;
            iArr2[i5] = i2;
            this.f17431d[i5] = obj;
            this.f17429b = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(y4 y4Var) throws IOException {
        if (y4Var.a() == zzfd.zze.m) {
            for (int i2 = this.f17429b - 1; i2 >= 0; i2--) {
                y4Var.f(this.f17430c[i2] >>> 3, this.f17431d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f17429b; i3++) {
            y4Var.f(this.f17430c[i3] >>> 3, this.f17431d[i3]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhy)) {
            return false;
        }
        zzhy zzhyVar = (zzhy) obj;
        int i2 = this.f17429b;
        if (i2 == zzhyVar.f17429b) {
            int[] iArr = this.f17430c;
            int[] iArr2 = zzhyVar.f17430c;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                }
                if (iArr[i3] != iArr2[i3]) {
                    z = false;
                    break;
                }
                i3++;
            }
            if (z) {
                Object[] objArr = this.f17431d;
                Object[] objArr2 = zzhyVar.f17431d;
                int i4 = this.f17429b;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i5].equals(objArr2[i5])) {
                        z2 = false;
                        break;
                    }
                    i5++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f17429b; i3++) {
            f3.d(sb, i2, String.valueOf(this.f17430c[i3] >>> 3), this.f17431d[i3]);
        }
    }

    public final void h(y4 y4Var) throws IOException {
        if (this.f17429b == 0) {
            return;
        }
        if (y4Var.a() == zzfd.zze.l) {
            for (int i2 = 0; i2 < this.f17429b; i2++) {
                d(this.f17430c[i2], this.f17431d[i2], y4Var);
            }
            return;
        }
        for (int i3 = this.f17429b - 1; i3 >= 0; i3--) {
            d(this.f17430c[i3], this.f17431d[i3], y4Var);
        }
    }

    public final int hashCode() {
        int i2 = this.f17429b;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f17430c;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.f17431d;
        int i8 = this.f17429b;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final void i() {
        this.f17433f = false;
    }

    public final int j() {
        int i2 = this.f17432e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f17429b; i4++) {
            i3 += zzen.c0(this.f17430c[i4] >>> 3, (zzdu) this.f17431d[i4]);
        }
        this.f17432e = i3;
        return i3;
    }

    public final int k() {
        int h0;
        int i2 = this.f17432e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f17429b; i4++) {
            int i5 = this.f17430c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                h0 = zzen.h0(i6, ((Long) this.f17431d[i4]).longValue());
            } else if (i7 == 1) {
                h0 = zzen.q0(i6, ((Long) this.f17431d[i4]).longValue());
            } else if (i7 == 2) {
                h0 = zzen.T(i6, (zzdu) this.f17431d[i4]);
            } else if (i7 == 3) {
                h0 = (zzen.g0(i6) << 1) + ((zzhy) this.f17431d[i4]).k();
            } else if (i7 == 5) {
                h0 = zzen.x0(i6, ((Integer) this.f17431d[i4]).intValue());
            } else {
                throw new IllegalStateException(zzfo.f());
            }
            i3 += h0;
        }
        this.f17432e = i3;
        return i3;
    }

    private zzhy(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f17432e = -1;
        this.f17429b = i2;
        this.f17430c = iArr;
        this.f17431d = objArr;
        this.f17433f = z;
    }
}
