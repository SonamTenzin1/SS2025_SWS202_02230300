package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* loaded from: classes2.dex */
public final class zzdjh implements zzdby {
    private final SecretKey a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15929b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f15930c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f15931d;

    private static Cipher b() throws GeneralSecurityException {
        return zzdkx.f15960c.b("AES/ECB/NoPadding");
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        byte[] d2;
        Cipher b2 = b();
        b2.init(1, this.a);
        double length = bArr.length;
        Double.isNaN(length);
        int max = Math.max(1, (int) Math.ceil(length / 16.0d));
        if ((max << 4) == bArr.length) {
            d2 = zzdjs.b(bArr, (max - 1) << 4, this.f15930c, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, (max - 1) << 4, bArr.length);
            if (copyOfRange.length < 16) {
                byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
                copyOf[copyOfRange.length] = Byte.MIN_VALUE;
                d2 = zzdjs.d(copyOf, this.f15931d);
            } else {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < max - 1; i2++) {
            bArr2 = b2.doFinal(zzdjs.b(bArr2, 0, bArr, i2 << 4, 16));
        }
        byte[] d3 = zzdjs.d(d2, bArr2);
        byte[] bArr3 = new byte[this.f15929b];
        System.arraycopy(b2.doFinal(d3), 0, bArr3, 0, this.f15929b);
        return bArr3;
    }
}
