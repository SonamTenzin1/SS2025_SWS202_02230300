package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class rt extends mt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public rt(byte[] bArr, int i2) throws InvalidKeyException {
        super(bArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.mt
    public final int f() {
        return 24;
    }

    @Override // com.google.android.gms.internal.ads.mt
    final int[] g(int[] iArr, int i2) {
        if (iArr.length == 6) {
            int[] iArr2 = new int[16];
            mt.e(r0, this.f12993b);
            int[] iArr3 = {0, 0, 0, 0, iArr3[12], iArr3[13], iArr3[14], iArr3[15], 0, 0, 0, 0, iArr[0], iArr[1], iArr[2], iArr[3]};
            mt.i(iArr3);
            mt.e(iArr2, Arrays.copyOf(iArr3, 8));
            iArr2[12] = i2;
            iArr2[13] = 0;
            iArr2[14] = iArr[4];
            iArr2[15] = iArr[5];
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }
}
