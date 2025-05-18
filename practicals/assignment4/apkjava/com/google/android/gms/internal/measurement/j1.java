package com.google.android.gms.internal.measurement;

import java.io.IOException;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class j1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, byte[] bArr, int i3, int i4, m1 m1Var) throws zzfo {
        if ((i2 >>> 3) == 0) {
            throw zzfo.d();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            return k(bArr, i3, m1Var);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return i(bArr, i3, m1Var) + m1Var.a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw zzfo.d();
        }
        int i6 = (i2 & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = i(bArr, i3, m1Var);
            i7 = m1Var.a;
            if (i7 == i6) {
                break;
            }
            i3 = a(i7, bArr, i3, i4, m1Var);
        }
        if (i3 > i4 || i7 != i6) {
            throw zzfo.g();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2, byte[] bArr, int i3, int i4, zzfl<?> zzflVar, m1 m1Var) {
        n2 n2Var = (n2) zzflVar;
        int i5 = i(bArr, i3, m1Var);
        n2Var.h(m1Var.a);
        while (i5 < i4) {
            int i6 = i(bArr, i5, m1Var);
            if (i2 != m1Var.a) {
                break;
            }
            i5 = i(bArr, i6, m1Var);
            n2Var.h(m1Var.a);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, byte[] bArr, int i3, int i4, zzhy zzhyVar, m1 m1Var) throws zzfo {
        if ((i2 >>> 3) == 0) {
            throw zzfo.d();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int k2 = k(bArr, i3, m1Var);
            zzhyVar.c(i2, Long.valueOf(m1Var.f17218b));
            return k2;
        }
        if (i5 == 1) {
            zzhyVar.c(i2, Long.valueOf(l(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int i6 = i(bArr, i3, m1Var);
            int i7 = m1Var.a;
            if (i7 >= 0) {
                if (i7 > bArr.length - i6) {
                    throw zzfo.a();
                }
                if (i7 == 0) {
                    zzhyVar.c(i2, zzdu.f17368f);
                } else {
                    zzhyVar.c(i2, zzdu.q(bArr, i6, i7));
                }
                return i6 + i7;
            }
            throw zzfo.b();
        }
        if (i5 != 3) {
            if (i5 == 5) {
                zzhyVar.c(i2, Integer.valueOf(h(bArr, i3)));
                return i3 + 4;
            }
            throw zzfo.d();
        }
        zzhy g2 = zzhy.g();
        int i8 = (i2 & (-8)) | 4;
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int i10 = i(bArr, i3, m1Var);
            int i11 = m1Var.a;
            i9 = i11;
            if (i11 == i8) {
                i3 = i10;
                break;
            }
            int c2 = c(i9, bArr, i10, i4, g2, m1Var);
            i9 = i11;
            i3 = c2;
        }
        if (i3 <= i4 && i9 == i8) {
            zzhyVar.c(i2, g2);
            return i3;
        }
        throw zzfo.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2, byte[] bArr, int i3, m1 m1Var) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            m1Var.a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            m1Var.a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            m1Var.a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            m1Var.a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                m1Var.a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(p3<?> p3Var, int i2, byte[] bArr, int i3, int i4, zzfl<?> zzflVar, m1 m1Var) throws IOException {
        int g2 = g(p3Var, bArr, i3, i4, m1Var);
        zzflVar.add(m1Var.f17219c);
        while (g2 < i4) {
            int i5 = i(bArr, g2, m1Var);
            if (i2 != m1Var.a) {
                break;
            }
            g2 = g(p3Var, bArr, i5, i4, m1Var);
            zzflVar.add(m1Var.f17219c);
        }
        return g2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(p3 p3Var, byte[] bArr, int i2, int i3, int i4, m1 m1Var) throws IOException {
        g3 g3Var = (g3) p3Var;
        Object a = g3Var.a();
        int p = g3Var.p(a, bArr, i2, i3, i4, m1Var);
        g3Var.f(a);
        m1Var.f17219c = a;
        return p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(p3 p3Var, byte[] bArr, int i2, int i3, m1 m1Var) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = d(i5, bArr, i4, m1Var);
            i5 = m1Var.a;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object a = p3Var.a();
            int i7 = i5 + i6;
            p3Var.d(a, bArr, i6, i7, m1Var);
            p3Var.f(a);
            m1Var.f17219c = a;
            return i7;
        }
        throw zzfo.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(byte[] bArr, int i2, m1 m1Var) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            m1Var.a = b2;
            return i3;
        }
        return d(b2, bArr, i3, m1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(byte[] bArr, int i2, zzfl<?> zzflVar, m1 m1Var) throws IOException {
        n2 n2Var = (n2) zzflVar;
        int i3 = i(bArr, i2, m1Var);
        int i4 = m1Var.a + i3;
        while (i3 < i4) {
            i3 = i(bArr, i3, m1Var);
            n2Var.h(m1Var.a);
        }
        if (i3 == i4) {
            return i3;
        }
        throw zzfo.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(byte[] bArr, int i2, m1 m1Var) {
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            m1Var.f17218b = j2;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (r10 & Byte.MAX_VALUE) << i5;
            b2 = bArr[i4];
            i4 = i6;
        }
        m1Var.f17218b = j3;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long l(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double m(byte[] bArr, int i2) {
        return Double.longBitsToDouble(l(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(byte[] bArr, int i2, m1 m1Var) throws zzfo {
        int i3 = i(bArr, i2, m1Var);
        int i4 = m1Var.a;
        if (i4 < 0) {
            throw zzfo.b();
        }
        if (i4 == 0) {
            m1Var.f17219c = HttpUrl.FRAGMENT_ENCODE_SET;
            return i3;
        }
        m1Var.f17219c = new String(bArr, i3, i4, zzff.a);
        return i3 + i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float o(byte[] bArr, int i2) {
        return Float.intBitsToFloat(h(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(byte[] bArr, int i2, m1 m1Var) throws zzfo {
        int i3 = i(bArr, i2, m1Var);
        int i4 = m1Var.a;
        if (i4 < 0) {
            throw zzfo.b();
        }
        if (i4 == 0) {
            m1Var.f17219c = HttpUrl.FRAGMENT_ENCODE_SET;
            return i3;
        }
        m1Var.f17219c = n4.k(bArr, i3, i4);
        return i3 + i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(byte[] bArr, int i2, m1 m1Var) throws zzfo {
        int i3 = i(bArr, i2, m1Var);
        int i4 = m1Var.a;
        if (i4 >= 0) {
            if (i4 > bArr.length - i3) {
                throw zzfo.a();
            }
            if (i4 == 0) {
                m1Var.f17219c = zzdu.f17368f;
                return i3;
            }
            m1Var.f17219c = zzdu.q(bArr, i3, i4);
            return i3 + i4;
        }
        throw zzfo.b();
    }
}
