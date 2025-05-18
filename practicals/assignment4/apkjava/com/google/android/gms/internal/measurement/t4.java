package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class t4 extends o4 {
    private static int e(byte[] bArr, int i2, long j2, int i3) {
        int h2;
        int i4;
        int j3;
        if (i3 == 0) {
            h2 = n4.h(i2);
            return h2;
        }
        if (i3 == 1) {
            i4 = n4.i(i2, k4.a(bArr, j2));
            return i4;
        }
        if (i3 == 2) {
            j3 = n4.j(i2, k4.a(bArr, j2), k4.a(bArr, j2 + 1));
            return j3;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b6, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0061, code lost:
    
        return -1;
     */
    @Override // com.google.android.gms.internal.measurement.o4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int a(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        long j2;
        if ((i3 | i4 | (bArr.length - i4)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        long j3 = i3;
        int i6 = (int) (i4 - j3);
        if (i6 >= 16) {
            long j4 = j3;
            i5 = 0;
            while (true) {
                if (i5 >= i6) {
                    i5 = i6;
                    break;
                }
                long j5 = j4 + 1;
                if (k4.a(bArr, j4) < 0) {
                    break;
                }
                i5++;
                j4 = j5;
            }
        } else {
            i5 = 0;
        }
        int i7 = i6 - i5;
        long j6 = j3 + i5;
        while (true) {
            byte b2 = 0;
            while (true) {
                if (i7 <= 0) {
                    break;
                }
                long j7 = j6 + 1;
                b2 = k4.a(bArr, j6);
                if (b2 < 0) {
                    j6 = j7;
                    break;
                }
                i7--;
                j6 = j7;
            }
            if (i7 == 0) {
                return 0;
            }
            int i8 = i7 - 1;
            if (b2 >= -32) {
                if (b2 >= -16) {
                    if (i8 < 3) {
                        return e(bArr, b2, j6, i8);
                    }
                    i7 = i8 - 3;
                    long j8 = j6 + 1;
                    byte a = k4.a(bArr, j6);
                    if (a > -65 || (((b2 << 28) + (a + 112)) >> 30) != 0) {
                        break;
                    }
                    long j9 = j8 + 1;
                    if (k4.a(bArr, j8) > -65) {
                        break;
                    }
                    j2 = j9 + 1;
                    if (k4.a(bArr, j9) > -65) {
                        break;
                    }
                } else {
                    if (i8 < 2) {
                        return e(bArr, b2, j6, i8);
                    }
                    i7 = i8 - 2;
                    long j10 = j6 + 1;
                    byte a2 = k4.a(bArr, j6);
                    if (a2 > -65 || ((b2 == -32 && a2 < -96) || (b2 == -19 && a2 >= -96))) {
                        break;
                    }
                    j6 = j10 + 1;
                    if (k4.a(bArr, j10) > -65) {
                        break;
                    }
                }
            } else if (i8 != 0) {
                i7 = i8 - 1;
                if (b2 < -62) {
                    break;
                }
                j2 = j6 + 1;
                if (k4.a(bArr, j6) > -65) {
                    break;
                }
            } else {
                return b2;
            }
            j6 = j2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.o4
    public final int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        char c2;
        long j2;
        long j3;
        long j4;
        int i4;
        char charAt;
        long j5 = i2;
        long j6 = i3 + j5;
        int length = charSequence.length();
        if (length > i3 || bArr.length - i3 < i2) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i2 + i3);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i5 = 0;
        while (true) {
            c2 = 128;
            j2 = 1;
            if (i5 >= length || (charAt = charSequence.charAt(i5)) >= 128) {
                break;
            }
            k4.l(bArr, j5, (byte) charAt);
            i5++;
            j5 = 1 + j5;
        }
        if (i5 == length) {
            return (int) j5;
        }
        while (i5 < length) {
            char charAt3 = charSequence.charAt(i5);
            if (charAt3 >= c2 || j5 >= j6) {
                if (charAt3 < 2048 && j5 <= j6 - 2) {
                    long j7 = j5 + j2;
                    k4.l(bArr, j5, (byte) ((charAt3 >>> 6) | 960));
                    k4.l(bArr, j7, (byte) ((charAt3 & '?') | 128));
                    j3 = j7 + j2;
                    j4 = j2;
                } else {
                    if ((charAt3 >= 55296 && 57343 >= charAt3) || j5 > j6 - 3) {
                        if (j5 <= j6 - 4) {
                            int i6 = i5 + 1;
                            if (i6 != length) {
                                char charAt4 = charSequence.charAt(i6);
                                if (Character.isSurrogatePair(charAt3, charAt4)) {
                                    int codePoint = Character.toCodePoint(charAt3, charAt4);
                                    long j8 = j5 + 1;
                                    k4.l(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                    long j9 = j8 + 1;
                                    k4.l(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j10 = j9 + 1;
                                    k4.l(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j4 = 1;
                                    j3 = j10 + 1;
                                    k4.l(bArr, j10, (byte) ((codePoint & 63) | 128));
                                    i5 = i6;
                                } else {
                                    i5 = i6;
                                }
                            }
                            throw new q4(i5 - 1, length);
                        }
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i4)))) {
                            throw new q4(i5, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j5);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    long j11 = j5 + j2;
                    k4.l(bArr, j5, (byte) ((charAt3 >>> '\f') | 480));
                    long j12 = j11 + j2;
                    k4.l(bArr, j11, (byte) (((charAt3 >>> 6) & 63) | 128));
                    k4.l(bArr, j12, (byte) ((charAt3 & '?') | 128));
                    j3 = j12 + 1;
                    j4 = 1;
                }
                i5++;
                c2 = 128;
                long j13 = j4;
                j5 = j3;
                j2 = j13;
            } else {
                long j14 = j5 + j2;
                k4.l(bArr, j5, (byte) charAt3);
                j4 = j2;
                j3 = j14;
            }
            i5++;
            c2 = 128;
            long j132 = j4;
            j5 = j3;
            j2 = j132;
        }
        return (int) j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.o4
    public final String d(byte[] bArr, int i2, int i3) throws zzfo {
        boolean l;
        boolean l2;
        boolean m;
        boolean n;
        boolean l3;
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (i2 < i4) {
                byte a = k4.a(bArr, i2);
                l3 = p4.l(a);
                if (!l3) {
                    break;
                }
                i2++;
                p4.i(a, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i2 < i4) {
                int i7 = i2 + 1;
                byte a2 = k4.a(bArr, i2);
                l = p4.l(a2);
                if (l) {
                    int i8 = i6 + 1;
                    p4.i(a2, cArr, i6);
                    while (i7 < i4) {
                        byte a3 = k4.a(bArr, i7);
                        l2 = p4.l(a3);
                        if (!l2) {
                            break;
                        }
                        i7++;
                        p4.i(a3, cArr, i8);
                        i8++;
                    }
                    i2 = i7;
                    i6 = i8;
                } else {
                    m = p4.m(a2);
                    if (!m) {
                        n = p4.n(a2);
                        if (n) {
                            if (i7 < i4 - 1) {
                                int i9 = i7 + 1;
                                p4.g(a2, k4.a(bArr, i7), k4.a(bArr, i9), cArr, i6);
                                i2 = i9 + 1;
                                i6++;
                            } else {
                                throw zzfo.h();
                            }
                        } else if (i7 < i4 - 2) {
                            int i10 = i7 + 1;
                            byte a4 = k4.a(bArr, i7);
                            int i11 = i10 + 1;
                            p4.f(a2, a4, k4.a(bArr, i10), k4.a(bArr, i11), cArr, i6);
                            i2 = i11 + 1;
                            i6 = i6 + 1 + 1;
                        } else {
                            throw zzfo.h();
                        }
                    } else if (i7 < i4) {
                        p4.h(a2, k4.a(bArr, i7), cArr, i6);
                        i2 = i7 + 1;
                        i6++;
                    } else {
                        throw zzfo.h();
                    }
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }
}
