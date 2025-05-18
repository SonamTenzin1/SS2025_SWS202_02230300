package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdjk implements zzdbj {
    private final byte[] a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f15934b;

    /* renamed from: c, reason: collision with root package name */
    private final SecretKeySpec f15935c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15936d;

    public zzdjk(byte[] bArr, int i2) throws GeneralSecurityException {
        if (i2 != 12 && i2 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f15936d = i2;
        zzdlx.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f15935c = secretKeySpec;
        Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
        cipher.init(1, secretKeySpec);
        byte[] d2 = d(cipher.doFinal(new byte[16]));
        this.a = d2;
        this.f15934b = d(d2);
    }

    private final byte[] b(Cipher cipher, int i2, byte[] bArr, int i3, int i4) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i2;
        if (i4 == 0) {
            return cipher.doFinal(c(bArr3, this.a));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i5 = 0;
        while (i4 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                doFinal[i6] = (byte) (doFinal[i6] ^ bArr[(i3 + i5) + i6]);
            }
            doFinal = cipher.doFinal(doFinal);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i3, i3 + i4);
        if (copyOfRange.length == 16) {
            bArr2 = c(copyOfRange, this.a);
        } else {
            byte[] copyOf = Arrays.copyOf(this.f15934b, 16);
            for (int i7 = 0; i7 < copyOfRange.length; i7++) {
                copyOf[i7] = (byte) (copyOf[i7] ^ copyOfRange[i7]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(c(doFinal, bArr2));
    }

    private static byte[] c(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    private static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & 255) >>> 7));
            i2 = i3;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f15936d;
        if (length <= (Integer.MAX_VALUE - i2) - 16) {
            byte[] bArr3 = new byte[bArr.length + i2 + 16];
            byte[] c2 = zzdlo.c(i2);
            System.arraycopy(c2, 0, bArr3, 0, this.f15936d);
            Cipher cipher = Cipher.getInstance("AES/ECB/NOPADDING");
            cipher.init(1, this.f15935c);
            byte[] b2 = b(cipher, 0, c2, 0, c2.length);
            byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
            byte[] b3 = b(cipher, 1, bArr4, 0, bArr4.length);
            Cipher cipher2 = Cipher.getInstance("AES/CTR/NOPADDING");
            cipher2.init(1, this.f15935c, new IvParameterSpec(b2));
            cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.f15936d);
            byte[] b4 = b(cipher, 2, bArr3, this.f15936d, bArr.length);
            int length2 = bArr.length + this.f15936d;
            for (int i3 = 0; i3 < 16; i3++) {
                bArr3[length2 + i3] = (byte) ((b3[i3] ^ b2[i3]) ^ b4[i3]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
