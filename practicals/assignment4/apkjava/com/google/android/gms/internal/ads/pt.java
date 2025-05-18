package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class pt {
    private static void a(byte[] bArr, long j2, int i2) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i2 + i3] = (byte) (255 & j2);
            i3++;
            j2 >>= 8;
        }
    }

    private static long b(byte[] bArr, int i2) {
        return (((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16)) & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long d2 = d(bArr, 0, 0) & 67108863;
            int i2 = 3;
            long d3 = d(bArr, 3, 2) & 67108611;
            long d4 = d(bArr, 6, 4) & 67092735;
            long d5 = d(bArr, 9, 6) & 66076671;
            long d6 = d(bArr, 12, 8) & 1048575;
            long j2 = d3 * 5;
            long j3 = d4 * 5;
            long j4 = d5 * 5;
            long j5 = d6 * 5;
            int i3 = 17;
            byte[] bArr3 = new byte[17];
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            long j10 = 0;
            int i4 = 0;
            while (i4 < bArr2.length) {
                int min = Math.min(16, bArr2.length - i4);
                System.arraycopy(bArr2, i4, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i3, (byte) 0);
                }
                long d7 = j10 + d(bArr3, 0, 0);
                long d8 = j6 + d(bArr3, i2, 2);
                long d9 = j7 + d(bArr3, 6, 4);
                long d10 = j8 + d(bArr3, 9, 6);
                long d11 = j9 + (d(bArr3, 12, 8) | (bArr3[16] << 24));
                long j11 = (d7 * d2) + (d8 * j5) + (d9 * j4) + (d10 * j3) + (d11 * j2);
                long j12 = (d7 * d3) + (d8 * d2) + (d9 * j5) + (d10 * j4) + (d11 * j3);
                long j13 = (d7 * d4) + (d8 * d3) + (d9 * d2) + (d10 * j5) + (d11 * j4);
                long j14 = (d7 * d5) + (d8 * d4) + (d9 * d3) + (d10 * d2) + (d11 * j5);
                long j15 = j12 + (j11 >> 26);
                long j16 = j13 + (j15 >> 26);
                long j17 = j14 + (j16 >> 26);
                long j18 = (d7 * d6) + (d8 * d5) + (d9 * d4) + (d10 * d3) + (d11 * d2) + (j17 >> 26);
                long j19 = (j11 & 67108863) + ((j18 >> 26) * 5);
                j6 = (j15 & 67108863) + (j19 >> 26);
                i4 += 16;
                j7 = j16 & 67108863;
                j8 = j17 & 67108863;
                j9 = j18 & 67108863;
                i3 = 17;
                i2 = 3;
                j10 = j19 & 67108863;
            }
            long j20 = j7 + (j6 >> 26);
            long j21 = j20 & 67108863;
            long j22 = j8 + (j20 >> 26);
            long j23 = j22 & 67108863;
            long j24 = j9 + (j22 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j10 + ((j24 >> 26) * 5);
            long j27 = j26 & 67108863;
            long j28 = (j6 & 67108863) + (j26 >> 26);
            long j29 = j27 + 5;
            long j30 = j29 & 67108863;
            long j31 = (j29 >> 26) + j28;
            long j32 = j21 + (j31 >> 26);
            long j33 = j23 + (j32 >> 26);
            long j34 = j33 & 67108863;
            long j35 = (j25 + (j33 >> 26)) - 67108864;
            long j36 = j35 >> 63;
            long j37 = j27 & j36;
            long j38 = j28 & j36;
            long j39 = j21 & j36;
            long j40 = j23 & j36;
            long j41 = j25 & j36;
            long j42 = j36 ^ (-1);
            long j43 = (j31 & 67108863 & j42) | j38;
            long j44 = (j32 & 67108863 & j42) | j39;
            long j45 = (j34 & j42) | j40;
            long j46 = (j35 & j42) | j41;
            long j47 = ((j43 << 26) | j37 | (j30 & j42)) & 4294967295L;
            long j48 = ((j43 >> 6) | (j44 << 20)) & 4294967295L;
            long j49 = ((j44 >> 12) | (j45 << 14)) & 4294967295L;
            long b2 = j47 + b(bArr, 16);
            long b3 = j48 + b(bArr, 20) + (b2 >> 32);
            long b4 = j49 + b(bArr, 24) + (b3 >> 32);
            long b5 = ((((j45 >> 18) | (j46 << 8)) & 4294967295L) + b(bArr, 28) + (b4 >> 32)) & 4294967295L;
            byte[] bArr4 = new byte[16];
            a(bArr4, b2 & 4294967295L, 0);
            a(bArr4, b3 & 4294967295L, 4);
            a(bArr4, b4 & 4294967295L, 8);
            a(bArr4, b5, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    private static long d(byte[] bArr, int i2, int i3) {
        return (b(bArr, i2) >> i3) & 67108863;
    }
}
