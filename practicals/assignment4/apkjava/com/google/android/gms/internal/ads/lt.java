package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* loaded from: classes2.dex */
final class lt extends mt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public lt(byte[] bArr, int i2) throws InvalidKeyException {
        super(bArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.mt
    public final int f() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.mt
    final int[] g(int[] iArr, int i2) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            mt.e(iArr2, this.f12993b);
            iArr2[12] = i2;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length << 5)));
    }
}
