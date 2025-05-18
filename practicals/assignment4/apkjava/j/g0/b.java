package j.g0;

import j.f;
import j.i;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public final class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0068, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int c(byte[] bArr, int i2) {
        int i3;
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        loop0: while (i4 < length) {
            byte b2 = bArr[i4];
            if (b2 >= 0) {
                int i7 = i6 + 1;
                if (i6 == i2) {
                    return i5;
                }
                if (b2 != 10 && b2 != 13) {
                    if ((b2 >= 0 && 31 >= b2) || (Byte.MAX_VALUE <= b2 && 159 >= b2)) {
                        return -1;
                    }
                }
                if (b2 == 65533) {
                    return -1;
                }
                i5 += b2 < 65536 ? 1 : 2;
                i4++;
                while (true) {
                    i6 = i7;
                    if (i4 < length && bArr[i4] >= 0) {
                        int i8 = i4 + 1;
                        byte b3 = bArr[i4];
                        i7 = i6 + 1;
                        if (i6 == i2) {
                            return i5;
                        }
                        if (b3 != 10 && b3 != 13) {
                            if ((b3 >= 0 && 31 >= b3) || (Byte.MAX_VALUE <= b3 && 159 >= b3)) {
                                break loop0;
                            }
                        }
                        if (b3 == 65533) {
                            break loop0;
                        }
                        i5 += b3 < 65536 ? 1 : 2;
                        i4 = i8;
                    }
                }
            } else {
                if ((b2 >> 5) == -2) {
                    int i9 = i4 + 1;
                    if (length <= i9) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    byte b4 = bArr[i4];
                    byte b5 = bArr[i9];
                    if (!((b5 & 192) == 128)) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    int i10 = (b5 ^ 3968) ^ (b4 << 6);
                    if (i10 < 128) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    i3 = i6 + 1;
                    if (i6 == i2) {
                        return i5;
                    }
                    if (i10 != 10 && i10 != 13) {
                        if ((i10 >= 0 && 31 >= i10) || (127 <= i10 && 159 >= i10)) {
                            return -1;
                        }
                    }
                    if (i10 == 65533) {
                        return -1;
                    }
                    i5 += i10 < 65536 ? 1 : 2;
                    u uVar = u.a;
                    i4 += 2;
                } else if ((b2 >> 4) == -2) {
                    int i11 = i4 + 2;
                    if (length <= i11) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    byte b6 = bArr[i4];
                    byte b7 = bArr[i4 + 1];
                    if (!((b7 & 192) == 128)) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    byte b8 = bArr[i11];
                    if (!((b8 & 192) == 128)) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    int i12 = ((b8 ^ (-123008)) ^ (b7 << 6)) ^ (b6 << 12);
                    if (i12 < 2048) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    if (55296 <= i12 && 57343 >= i12) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    i3 = i6 + 1;
                    if (i6 == i2) {
                        return i5;
                    }
                    if (i12 != 10 && i12 != 13) {
                        if ((i12 >= 0 && 31 >= i12) || (127 <= i12 && 159 >= i12)) {
                            return -1;
                        }
                    }
                    if (i12 == 65533) {
                        return -1;
                    }
                    i5 += i12 < 65536 ? 1 : 2;
                    u uVar2 = u.a;
                    i4 += 3;
                } else {
                    if ((b2 >> 3) != -2) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    int i13 = i4 + 3;
                    if (length <= i13) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    byte b9 = bArr[i4];
                    byte b10 = bArr[i4 + 1];
                    if (!((b10 & 192) == 128)) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    byte b11 = bArr[i4 + 2];
                    if (!((b11 & 192) == 128)) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    byte b12 = bArr[i13];
                    if (!((b12 & 192) == 128)) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    int i14 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b9 << 18);
                    if (i14 > 1114111) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    if (55296 <= i14 && 57343 >= i14) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    if (i14 < 65536) {
                        if (i6 == i2) {
                            return i5;
                        }
                        return -1;
                    }
                    i3 = i6 + 1;
                    if (i6 == i2) {
                        return i5;
                    }
                    if (i14 != 10 && i14 != 13) {
                        if ((i14 >= 0 && 31 >= i14) || (127 <= i14 && 159 >= i14)) {
                            return -1;
                        }
                    }
                    if (i14 == 65533) {
                        return -1;
                    }
                    i5 += i14 < 65536 ? 1 : 2;
                    u uVar3 = u.a;
                    i4 += 4;
                }
                i6 = i3;
            }
        }
        return i5;
    }

    public static final void d(i iVar, f fVar, int i2, int i3) {
        m.f(iVar, "$this$commonWrite");
        m.f(fVar, "buffer");
        fVar.write(iVar.y(), i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static final char[] f() {
        return a;
    }
}
