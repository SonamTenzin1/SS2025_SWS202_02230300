package com.google.zxing.f.b;

/* compiled from: Encoder.java */
/* loaded from: classes2.dex */
public final class c {
    private static final int[] a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(com.google.zxing.g.a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int i4 = aVar.i() / i2;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                i6 |= aVar.h((i5 * i2) + i7) ? 1 << ((i2 - i7) - 1) : 0;
            }
            iArr[i5] = i6;
        }
        return iArr;
    }

    private static void b(com.google.zxing.g.b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bVar.i(i6, i5);
                    bVar.i(i6, i7);
                    bVar.i(i5, i6);
                    bVar.i(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bVar.i(i8, i8);
        int i9 = i8 + 1;
        bVar.i(i9, i8);
        bVar.i(i8, i9);
        int i10 = i2 + i3;
        bVar.i(i10, i8);
        bVar.i(i10, i9);
        bVar.i(i10, i10 - 1);
    }

    private static void c(com.google.zxing.g.b bVar, boolean z, int i2, com.google.zxing.g.a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.h(i4)) {
                    bVar.i(i5, i3 - 5);
                }
                if (aVar.h(i4 + 7)) {
                    bVar.i(i3 + 5, i5);
                }
                if (aVar.h(20 - i4)) {
                    bVar.i(i5, i3 + 5);
                }
                if (aVar.h(27 - i4)) {
                    bVar.i(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.h(i4)) {
                bVar.i(i6, i3 - 7);
            }
            if (aVar.h(i4 + 10)) {
                bVar.i(i3 + 7, i6);
            }
            if (aVar.h(29 - i4)) {
                bVar.i(i6, i3 + 7);
            }
            if (aVar.h(39 - i4)) {
                bVar.i(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static a d(byte[] bArr, int i2, int i3) {
        com.google.zxing.g.a aVar;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        com.google.zxing.g.a a2 = new d(bArr).a();
        int i8 = ((a2.i() * i2) / 100) + 11;
        int i9 = a2.i() + i8;
        int i10 = 0;
        int i11 = 1;
        if (i3 != 0) {
            z = i3 < 0;
            i5 = Math.abs(i3);
            if (i5 <= (z ? 4 : 32)) {
                i6 = i(i5, z);
                i4 = a[i5];
                int i12 = i6 - (i6 % i4);
                aVar = h(a2, i4);
                if (aVar.i() + i8 <= i12) {
                    if (z && aVar.i() > (i4 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
            }
        } else {
            com.google.zxing.g.a aVar2 = null;
            int i13 = 0;
            int i14 = 0;
            while (i13 <= 32) {
                boolean z2 = i13 <= 3;
                int i15 = z2 ? i13 + 1 : i13;
                int i16 = i(i15, z2);
                if (i9 <= i16) {
                    if (aVar2 == null || i14 != a[i15]) {
                        int i17 = a[i15];
                        i14 = i17;
                        aVar2 = h(a2, i17);
                    }
                    int i18 = i16 - (i16 % i14);
                    if ((!z2 || aVar2.i() <= (i14 << 6)) && aVar2.i() + i8 <= i18) {
                        aVar = aVar2;
                        i4 = i14;
                        z = z2;
                        i5 = i15;
                        i6 = i16;
                    }
                }
                i13++;
                i10 = 0;
                i11 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        com.google.zxing.g.a e2 = e(aVar, i6, i4);
        int i19 = aVar.i() / i4;
        com.google.zxing.g.a f2 = f(z, i5, i19);
        int i20 = (z ? 11 : 14) + (i5 << 2);
        int[] iArr = new int[i20];
        int i21 = 2;
        if (z) {
            for (int i22 = 0; i22 < i20; i22++) {
                iArr[i22] = i22;
            }
            i7 = i20;
        } else {
            int i23 = i20 / 2;
            i7 = i20 + 1 + (((i23 - 1) / 15) * 2);
            int i24 = i7 / 2;
            for (int i25 = 0; i25 < i23; i25++) {
                iArr[(i23 - i25) - i11] = (i24 - r14) - 1;
                iArr[i23 + i25] = (i25 / 15) + i25 + i24 + i11;
            }
        }
        com.google.zxing.g.b bVar = new com.google.zxing.g.b(i7);
        int i26 = 0;
        int i27 = 0;
        while (i26 < i5) {
            int i28 = ((i5 - i26) << i21) + (z ? 9 : 12);
            int i29 = 0;
            while (i29 < i28) {
                int i30 = i29 << 1;
                while (i10 < i21) {
                    if (e2.h(i27 + i30 + i10)) {
                        int i31 = i26 << 1;
                        bVar.i(iArr[i31 + i10], iArr[i31 + i29]);
                    }
                    if (e2.h((i28 << 1) + i27 + i30 + i10)) {
                        int i32 = i26 << 1;
                        bVar.i(iArr[i32 + i29], iArr[((i20 - 1) - i32) - i10]);
                    }
                    if (e2.h((i28 << 2) + i27 + i30 + i10)) {
                        int i33 = (i20 - 1) - (i26 << 1);
                        bVar.i(iArr[i33 - i10], iArr[i33 - i29]);
                    }
                    if (e2.h((i28 * 6) + i27 + i30 + i10)) {
                        int i34 = i26 << 1;
                        bVar.i(iArr[((i20 - 1) - i34) - i29], iArr[i34 + i10]);
                    }
                    i10++;
                    i21 = 2;
                }
                i29++;
                i10 = 0;
                i21 = 2;
            }
            i27 += i28 << 3;
            i26++;
            i10 = 0;
            i21 = 2;
        }
        c(bVar, z, i7, f2);
        if (z) {
            b(bVar, i7 / 2, 5);
        } else {
            int i35 = i7 / 2;
            b(bVar, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i37 < (i20 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i7; i38 += 2) {
                    int i39 = i35 - i36;
                    bVar.i(i39, i38);
                    int i40 = i35 + i36;
                    bVar.i(i40, i38);
                    bVar.i(i38, i39);
                    bVar.i(i38, i40);
                }
                i37 += 15;
                i36 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.c(z);
        aVar3.f(i7);
        aVar3.d(i5);
        aVar3.b(i19);
        aVar3.e(bVar);
        return aVar3;
    }

    private static com.google.zxing.g.a e(com.google.zxing.g.a aVar, int i2, int i3) {
        int i4 = aVar.i() / i3;
        com.google.zxing.common.reedsolomon.c cVar = new com.google.zxing.common.reedsolomon.c(g(i3));
        int i5 = i2 / i3;
        int[] a2 = a(aVar, i3, i5);
        cVar.b(a2, i5 - i4);
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        aVar2.e(0, i2 % i3);
        for (int i6 : a2) {
            aVar2.e(i6, i3);
        }
        return aVar2;
    }

    static com.google.zxing.g.a f(boolean z, int i2, int i3) {
        com.google.zxing.g.a aVar = new com.google.zxing.g.a();
        if (z) {
            aVar.e(i2 - 1, 2);
            aVar.e(i3 - 1, 6);
            return e(aVar, 28, 4);
        }
        aVar.e(i2 - 1, 5);
        aVar.e(i3 - 1, 11);
        return e(aVar, 40, 4);
    }

    private static com.google.zxing.common.reedsolomon.a g(int i2) {
        if (i2 == 4) {
            return com.google.zxing.common.reedsolomon.a.f20311d;
        }
        if (i2 == 6) {
            return com.google.zxing.common.reedsolomon.a.f20310c;
        }
        if (i2 == 8) {
            return com.google.zxing.common.reedsolomon.a.f20314g;
        }
        if (i2 == 10) {
            return com.google.zxing.common.reedsolomon.a.f20309b;
        }
        if (i2 == 12) {
            return com.google.zxing.common.reedsolomon.a.a;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
    }

    static com.google.zxing.g.a h(com.google.zxing.g.a aVar, int i2) {
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        int i3 = aVar.i();
        int i4 = (1 << i2) - 2;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i5 + i7;
                if (i8 >= i3 || aVar.h(i8)) {
                    i6 |= 1 << ((i2 - 1) - i7);
                }
            }
            int i9 = i6 & i4;
            if (i9 == i4) {
                aVar2.e(i9, i2);
            } else if (i9 == 0) {
                aVar2.e(i6 | 1, i2);
            } else {
                aVar2.e(i6, i2);
                i5 += i2;
            }
            i5--;
            i5 += i2;
        }
        return aVar2;
    }

    private static int i(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }
}
