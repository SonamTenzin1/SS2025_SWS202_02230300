package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class mx extends lx {
    @Override // com.google.android.gms.internal.ads.lx
    final int a(int i2, byte[] bArr, int i3, int i4) {
        int l;
        int l2;
        while (i3 < i4 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 >= i4) {
            return 0;
        }
        while (i3 < i4) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i5 >= i4) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        i3 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                }
                if (b2 >= -16) {
                    if (i5 >= i4 - 2) {
                        l2 = jx.l(bArr, i5, i4);
                        return l2;
                    }
                    int i6 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                        int i7 = i6 + 1;
                        if (bArr[i6] <= -65) {
                            i5 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i5 >= i4 - 1) {
                    l = jx.l(bArr, i5, i4);
                    return l;
                }
                int i8 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                    i3 = i8 + 1;
                    if (bArr[i8] > -65) {
                    }
                }
                return -1;
            }
            i3 = i5;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.ads.lx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        char charAt;
        int length = charSequence.length();
        int i7 = i3 + i2;
        int i8 = 0;
        while (i8 < length && (i6 = i8 + i2) < i7 && (charAt = charSequence.charAt(i8)) < 128) {
            bArr[i6] = (byte) charAt;
            i8++;
        }
        int i9 = i2 + i8;
        while (i8 < length) {
            char charAt2 = charSequence.charAt(i8);
            if (charAt2 >= 128 || i9 >= i7) {
                if (charAt2 < 2048 && i9 <= i7 - 2) {
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> 6) | 960);
                    i9 = i10 + 1;
                    bArr[i10] = (byte) ((charAt2 & '?') | 128);
                } else {
                    if ((charAt2 >= 55296 && 57343 >= charAt2) || i9 > i7 - 3) {
                        if (i9 <= i7 - 4) {
                            int i11 = i8 + 1;
                            if (i11 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i11);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i12 = i9 + 1;
                                    bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                                    int i13 = i12 + 1;
                                    bArr[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i14 = i13 + 1;
                                    bArr[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i9 = i14 + 1;
                                    bArr[i14] = (byte) ((codePoint & 63) | 128);
                                    i8 = i11;
                                } else {
                                    i8 = i11;
                                }
                            }
                            throw new nx(i8 - 1, length);
                        }
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((i5 = i8 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i5)))) {
                            throw new nx(i8, length);
                        }
                        StringBuilder sb = new StringBuilder(37);
                        sb.append("Failed writing ");
                        sb.append(charAt2);
                        sb.append(" at index ");
                        sb.append(i9);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
                    }
                    int i15 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> '\f') | 480);
                    int i16 = i15 + 1;
                    bArr[i15] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i16 + 1;
                    bArr[i16] = (byte) ((charAt2 & '?') | 128);
                }
                i8++;
            } else {
                i4 = i9 + 1;
                bArr[i9] = (byte) charAt2;
            }
            i9 = i4;
            i8++;
        }
        return i9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.lx
    public final void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        lx.d(charSequence, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.lx
    public final String f(byte[] bArr, int i2, int i3) throws zzdok {
        boolean i4;
        boolean i5;
        boolean j2;
        boolean k2;
        boolean i6;
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i7 = i2 + i3;
            char[] cArr = new char[i3];
            int i8 = 0;
            while (i2 < i7) {
                byte b2 = bArr[i2];
                i6 = kx.i(b2);
                if (!i6) {
                    break;
                }
                i2++;
                kx.d(b2, cArr, i8);
                i8++;
            }
            int i9 = i8;
            while (i2 < i7) {
                int i10 = i2 + 1;
                byte b3 = bArr[i2];
                i4 = kx.i(b3);
                if (i4) {
                    int i11 = i9 + 1;
                    kx.d(b3, cArr, i9);
                    while (i10 < i7) {
                        byte b4 = bArr[i10];
                        i5 = kx.i(b4);
                        if (!i5) {
                            break;
                        }
                        i10++;
                        kx.d(b4, cArr, i11);
                        i11++;
                    }
                    i2 = i10;
                    i9 = i11;
                } else {
                    j2 = kx.j(b3);
                    if (!j2) {
                        k2 = kx.k(b3);
                        if (k2) {
                            if (i10 < i7 - 1) {
                                int i12 = i10 + 1;
                                kx.b(b3, bArr[i10], bArr[i12], cArr, i9);
                                i2 = i12 + 1;
                                i9++;
                            } else {
                                throw zzdok.h();
                            }
                        } else if (i10 < i7 - 2) {
                            int i13 = i10 + 1;
                            byte b5 = bArr[i10];
                            int i14 = i13 + 1;
                            kx.a(b3, b5, bArr[i13], bArr[i14], cArr, i9);
                            i2 = i14 + 1;
                            i9 = i9 + 1 + 1;
                        } else {
                            throw zzdok.h();
                        }
                    } else if (i10 < i7) {
                        kx.c(b3, bArr[i10], cArr, i9);
                        i2 = i10 + 1;
                        i9++;
                    } else {
                        throw zzdok.h();
                    }
                }
            }
            return new String(cArr, 0, i9);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }
}
