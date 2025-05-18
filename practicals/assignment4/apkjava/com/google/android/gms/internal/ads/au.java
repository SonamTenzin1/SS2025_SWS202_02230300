package com.google.android.gms.internal.ads;

import java.io.IOException;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class au {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, byte[] bArr, int i3, int i4, bu buVar) throws zzdok {
        if ((i2 >>> 3) == 0) {
            throw zzdok.d();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            return j(bArr, i3, buVar);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return h(bArr, i3, buVar) + buVar.a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw zzdok.d();
        }
        int i6 = (i2 & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = h(bArr, i3, buVar);
            i7 = buVar.a;
            if (i7 == i6) {
                break;
            }
            i3 = a(i7, bArr, i3, i4, buVar);
        }
        if (i3 > i4 || i7 != i6) {
            throw zzdok.g();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2, byte[] bArr, int i3, int i4, zzdoj<?> zzdojVar, bu buVar) {
        gv gvVar = (gv) zzdojVar;
        int h2 = h(bArr, i3, buVar);
        gvVar.Z0(buVar.a);
        while (h2 < i4) {
            int h3 = h(bArr, h2, buVar);
            if (i2 != buVar.a) {
                break;
            }
            h2 = h(bArr, h3, buVar);
            gvVar.Z0(buVar.a);
        }
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, byte[] bArr, int i3, int i4, zzdqu zzdquVar, bu buVar) throws zzdok {
        if ((i2 >>> 3) == 0) {
            throw zzdok.d();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int j2 = j(bArr, i3, buVar);
            zzdquVar.k(i2, Long.valueOf(buVar.f12360b));
            return j2;
        }
        if (i5 == 1) {
            zzdquVar.k(i2, Long.valueOf(o(bArr, i3)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int h2 = h(bArr, i3, buVar);
            int i6 = buVar.a;
            if (i6 >= 0) {
                if (i6 > bArr.length - h2) {
                    throw zzdok.a();
                }
                if (i6 == 0) {
                    zzdquVar.k(i2, zzdmr.f15982f);
                } else {
                    zzdquVar.k(i2, zzdmr.A(bArr, h2, i6));
                }
                return h2 + i6;
            }
            throw zzdok.b();
        }
        if (i5 != 3) {
            if (i5 == 5) {
                zzdquVar.k(i2, Integer.valueOf(n(bArr, i3)));
                return i3 + 4;
            }
            throw zzdok.d();
        }
        zzdqu i7 = zzdqu.i();
        int i8 = (i2 & (-8)) | 4;
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int h3 = h(bArr, i3, buVar);
            int i10 = buVar.a;
            i9 = i10;
            if (i10 == i8) {
                i3 = h3;
                break;
            }
            int c2 = c(i9, bArr, h3, i4, i7, buVar);
            i9 = i10;
            i3 = c2;
        }
        if (i3 <= i4 && i9 == i8) {
            zzdquVar.k(i2, i7);
            return i3;
        }
        throw zzdok.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2, byte[] bArr, int i3, bu buVar) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            buVar.a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            buVar.a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            buVar.a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            buVar.a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                buVar.a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(lw<?> lwVar, int i2, byte[] bArr, int i3, int i4, zzdoj<?> zzdojVar, bu buVar) throws IOException {
        int g2 = g(lwVar, bArr, i3, i4, buVar);
        zzdojVar.add(buVar.f12361c);
        while (g2 < i4) {
            int h2 = h(bArr, g2, buVar);
            if (i2 != buVar.a) {
                break;
            }
            g2 = g(lwVar, bArr, h2, i4, buVar);
            zzdojVar.add(buVar.f12361c);
        }
        return g2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(lw lwVar, byte[] bArr, int i2, int i3, int i4, bu buVar) throws IOException {
        aw awVar = (aw) lwVar;
        Object c2 = awVar.c();
        int o = awVar.o(c2, bArr, i2, i3, i4, buVar);
        awVar.f(c2);
        buVar.f12361c = c2;
        return o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(lw lwVar, byte[] bArr, int i2, int i3, bu buVar) throws IOException {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = d(i5, bArr, i4, buVar);
            i5 = buVar.a;
        }
        int i6 = i4;
        if (i5 >= 0 && i5 <= i3 - i6) {
            Object c2 = lwVar.c();
            int i7 = i5 + i6;
            lwVar.g(c2, bArr, i6, i7, buVar);
            lwVar.f(c2);
            buVar.f12361c = c2;
            return i7;
        }
        throw zzdok.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i2, bu buVar) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            buVar.a = b2;
            return i3;
        }
        return d(b2, bArr, i3, buVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(byte[] bArr, int i2, zzdoj<?> zzdojVar, bu buVar) throws IOException {
        gv gvVar = (gv) zzdojVar;
        int h2 = h(bArr, i2, buVar);
        int i3 = buVar.a + h2;
        while (h2 < i3) {
            h2 = h(bArr, h2, buVar);
            gvVar.Z0(buVar.a);
        }
        if (h2 == i3) {
            return h2;
        }
        throw zzdok.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(byte[] bArr, int i2, bu buVar) {
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            buVar.f12360b = j2;
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
        buVar.f12360b = j3;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(byte[] bArr, int i2, bu buVar) throws zzdok {
        int h2 = h(bArr, i2, buVar);
        int i3 = buVar.a;
        if (i3 < 0) {
            throw zzdok.b();
        }
        if (i3 == 0) {
            buVar.f12361c = HttpUrl.FRAGMENT_ENCODE_SET;
            return h2;
        }
        buVar.f12361c = new String(bArr, h2, i3, zzdod.a);
        return h2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(byte[] bArr, int i2, bu buVar) throws zzdok {
        int h2 = h(bArr, i2, buVar);
        int i3 = buVar.a;
        if (i3 < 0) {
            throw zzdok.b();
        }
        if (i3 == 0) {
            buVar.f12361c = HttpUrl.FRAGMENT_ENCODE_SET;
            return h2;
        }
        buVar.f12361c = jx.m(bArr, h2, i3);
        return h2 + i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(byte[] bArr, int i2, bu buVar) throws zzdok {
        int h2 = h(bArr, i2, buVar);
        int i3 = buVar.a;
        if (i3 >= 0) {
            if (i3 > bArr.length - h2) {
                throw zzdok.a();
            }
            if (i3 == 0) {
                buVar.f12361c = zzdmr.f15982f;
                return h2;
            }
            buVar.f12361c = zzdmr.A(bArr, h2, i3);
            return h2 + i3;
        }
        throw zzdok.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long o(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double p(byte[] bArr, int i2) {
        return Double.longBitsToDouble(o(bArr, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float q(byte[] bArr, int i2) {
        return Float.intBitsToFloat(n(bArr, i2));
    }
}
