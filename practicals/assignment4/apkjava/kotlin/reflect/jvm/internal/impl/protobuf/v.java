package kotlin.reflect.jvm.internal.impl.protobuf;

/* compiled from: Utf8.java */
/* loaded from: classes3.dex */
final class v {
    private static int a(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    private static int b(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    private static int c(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    private static int d(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return a(b2);
        }
        if (i4 == 1) {
            return b(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return c(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static boolean f(byte[] bArr, int i2, int i3) {
        return h(bArr, i2, i3) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r7[r8] > (-65)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        if (r7[r8] > (-65)) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x007f, code lost:
    
        if (r7[r8] > (-65)) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        if (i2 != 0) {
            if (i3 >= i4) {
                return i2;
            }
            byte b2 = (byte) i2;
            if (b2 < -32) {
                if (b2 >= -62) {
                    i5 = i3 + 1;
                }
                return -1;
            }
            if (b2 < -16) {
                byte b3 = (byte) ((i2 >> 8) ^ (-1));
                if (b3 == 0) {
                    int i6 = i3 + 1;
                    byte b4 = bArr[i3];
                    if (i6 >= i4) {
                        return b(b2, b4);
                    }
                    i3 = i6;
                    b3 = b4;
                }
                if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                    i5 = i3 + 1;
                }
                return -1;
            }
            byte b5 = (byte) ((i2 >> 8) ^ (-1));
            byte b6 = 0;
            if (b5 == 0) {
                int i7 = i3 + 1;
                b5 = bArr[i3];
                if (i7 >= i4) {
                    return b(b2, b5);
                }
                i3 = i7;
            } else {
                b6 = (byte) (i2 >> 16);
            }
            if (b6 == 0) {
                int i8 = i3 + 1;
                b6 = bArr[i3];
                if (i8 >= i4) {
                    return c(b2, b5, b6);
                }
                i3 = i8;
            }
            if (b5 <= -65 && (((b2 << 28) + (b5 + 112)) >> 30) == 0 && b6 <= -65) {
                i5 = i3 + 1;
            }
            return -1;
            i3 = i5;
        }
        return h(bArr, i3, i4);
    }

    public static int h(byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        return i(bArr, i2, i3);
    }

    private static int i(byte[] bArr, int i2, int i3) {
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i4 >= i3) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        i2 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b2 >= -16) {
                    if (i4 >= i3 - 2) {
                        return d(bArr, i4, i3);
                    }
                    int i5 = i4 + 1;
                    byte b3 = bArr[i4];
                    if (b3 <= -65 && (((b2 << 28) + (b3 + 112)) >> 30) == 0) {
                        int i6 = i5 + 1;
                        if (bArr[i5] <= -65) {
                            i4 = i6 + 1;
                            if (bArr[i6] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i4 >= i3 - 1) {
                    return d(bArr, i4, i3);
                }
                int i7 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 <= -65 && ((b2 != -32 || b4 >= -96) && (b2 != -19 || b4 < -96))) {
                    i2 = i7 + 1;
                    if (bArr[i7] > -65) {
                    }
                }
                return -1;
            }
            i2 = i4;
        }
        return 0;
    }
}
