package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes2.dex */
public final class zzdrp {
    private final ByteBuffer a;

    /* renamed from: b, reason: collision with root package name */
    private zzdni f16070b;

    /* renamed from: c, reason: collision with root package name */
    private int f16071c;

    private zzdrp(byte[] bArr, int i2, int i3) {
        this(ByteBuffer.wrap(bArr, i2, i3));
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i3);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        long j2 = i4 + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int d(int i2, int i3) {
        return o(i2) + p(i3);
    }

    public static zzdrp e(byte[] bArr) {
        return v(bArr, 0, bArr.length);
    }

    public static int g(int i2, zzdrw zzdrwVar) {
        int o = o(i2);
        int c2 = zzdrwVar.c();
        return o + q(c2) + c2;
    }

    public static int h(int i2, byte[] bArr) {
        return o(i2) + q(bArr.length) + bArr.length;
    }

    private static void i(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i4 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i5 = remaining + arrayOffset;
                    while (i4 < length) {
                        int i6 = i4 + arrayOffset;
                        if (i6 >= i5 || (charAt = charSequence.charAt(i4)) >= 128) {
                            break;
                        }
                        array[i6] = (byte) charAt;
                        i4++;
                    }
                    if (i4 == length) {
                        i2 = arrayOffset + length;
                    } else {
                        i2 = arrayOffset + i4;
                        while (i4 < length) {
                            char charAt2 = charSequence.charAt(i4);
                            if (charAt2 >= 128 || i2 >= i5) {
                                if (charAt2 < 2048 && i2 <= i5 - 2) {
                                    int i7 = i2 + 1;
                                    array[i2] = (byte) ((charAt2 >>> 6) | 960);
                                    i2 = i7 + 1;
                                    array[i7] = (byte) ((charAt2 & '?') | 128);
                                } else {
                                    if ((charAt2 >= 55296 && 57343 >= charAt2) || i2 > i5 - 3) {
                                        if (i2 <= i5 - 4) {
                                            int i8 = i4 + 1;
                                            if (i8 != charSequence.length()) {
                                                char charAt3 = charSequence.charAt(i8);
                                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                                    int i9 = i2 + 1;
                                                    array[i2] = (byte) ((codePoint >>> 18) | 240);
                                                    int i10 = i9 + 1;
                                                    array[i9] = (byte) (((codePoint >>> 12) & 63) | 128);
                                                    int i11 = i10 + 1;
                                                    array[i10] = (byte) (((codePoint >>> 6) & 63) | 128);
                                                    i2 = i11 + 1;
                                                    array[i11] = (byte) ((codePoint & 63) | 128);
                                                    i4 = i8;
                                                } else {
                                                    i4 = i8;
                                                }
                                            }
                                            StringBuilder sb = new StringBuilder(39);
                                            sb.append("Unpaired surrogate at index ");
                                            sb.append(i4 - 1);
                                            throw new IllegalArgumentException(sb.toString());
                                        }
                                        StringBuilder sb2 = new StringBuilder(37);
                                        sb2.append("Failed writing ");
                                        sb2.append(charAt2);
                                        sb2.append(" at index ");
                                        sb2.append(i2);
                                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                    }
                                    int i12 = i2 + 1;
                                    array[i2] = (byte) ((charAt2 >>> '\f') | 480);
                                    int i13 = i12 + 1;
                                    array[i12] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                    i3 = i13 + 1;
                                    array[i13] = (byte) ((charAt2 & '?') | 128);
                                }
                                i4++;
                            } else {
                                i3 = i2 + 1;
                                array[i2] = (byte) charAt2;
                            }
                            i2 = i3;
                            i4++;
                        }
                    }
                    byteBuffer.position(i2 - byteBuffer.arrayOffset());
                    return;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e2);
                    throw bufferOverflowException;
                }
            }
            int length2 = charSequence.length();
            while (i4 < length2) {
                char charAt4 = charSequence.charAt(i4);
                if (charAt4 < 128) {
                    byteBuffer.put((byte) charAt4);
                } else if (charAt4 < 2048) {
                    byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                } else {
                    if (charAt4 >= 55296 && 57343 >= charAt4) {
                        int i14 = i4 + 1;
                        if (i14 != charSequence.length()) {
                            char charAt5 = charSequence.charAt(i14);
                            if (Character.isSurrogatePair(charAt4, charAt5)) {
                                int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                i4 = i14;
                            } else {
                                i4 = i14;
                            }
                        }
                        StringBuilder sb3 = new StringBuilder(39);
                        sb3.append("Unpaired surrogate at index ");
                        sb3.append(i4 - 1);
                        throw new IllegalArgumentException(sb3.toString());
                    }
                    byteBuffer.put((byte) ((charAt4 >>> '\f') | 480));
                    byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                }
                i4++;
            }
            return;
        }
        throw new ReadOnlyBufferException();
    }

    public static int m(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int n(int i2, String str) {
        return o(i2) + r(str);
    }

    public static int o(int i2) {
        return q(i2 << 3);
    }

    public static int p(int i2) {
        if (i2 >= 0) {
            return q(i2);
        }
        return 10;
    }

    private static int q(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int r(String str) {
        int a = a(str);
        return q(a) + a;
    }

    private final void s(int i2) throws IOException {
        byte b2 = (byte) i2;
        if (this.a.hasRemaining()) {
            this.a.put(b2);
            return;
        }
        throw new zzdrq(this.a.position(), this.a.limit());
    }

    private final void t(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            s((i2 & 127) | 128);
            i2 >>>= 7;
        }
        s(i2);
    }

    public static zzdrp v(byte[] bArr, int i2, int i3) {
        return new zzdrp(bArr, 0, i3);
    }

    public final void b(int i2, zzdrw zzdrwVar) throws IOException {
        w(i2, 2);
        if (zzdrwVar.a < 0) {
            zzdrwVar.c();
        }
        t(zzdrwVar.a);
        zzdrwVar.a(this);
    }

    public final void c(int i2, byte[] bArr) throws IOException {
        w(i2, 2);
        t(bArr.length);
        int length = bArr.length;
        if (this.a.remaining() >= length) {
            this.a.put(bArr, 0, length);
            return;
        }
        throw new zzdrq(this.a.position(), this.a.limit());
    }

    public final void f() {
        if (this.a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.a.remaining())));
        }
    }

    public final void j(int i2, zzdpk zzdpkVar) throws IOException {
        if (this.f16070b == null) {
            this.f16070b = zzdni.E0(this.a);
            this.f16071c = this.a.position();
        } else if (this.f16071c != this.a.position()) {
            this.f16070b.c(this.a.array(), this.f16071c, this.a.position() - this.f16071c);
            this.f16071c = this.a.position();
        }
        zzdni zzdniVar = this.f16070b;
        zzdniVar.h(i2, zzdpkVar);
        zzdniVar.b();
        this.f16071c = this.a.position();
    }

    public final void k(int i2, String str) throws IOException {
        w(i2, 2);
        try {
            int q = q(str.length());
            if (q == q(str.length() * 3)) {
                int position = this.a.position();
                if (this.a.remaining() >= q) {
                    this.a.position(position + q);
                    i(str, this.a);
                    int position2 = this.a.position();
                    this.a.position(position);
                    t((position2 - position) - q);
                    this.a.position(position2);
                    return;
                }
                throw new zzdrq(position + q, this.a.limit());
            }
            t(a(str));
            i(str, this.a);
        } catch (BufferOverflowException e2) {
            zzdrq zzdrqVar = new zzdrq(this.a.position(), this.a.limit());
            zzdrqVar.initCause(e2);
            throw zzdrqVar;
        }
    }

    public final void l(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            s((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        s((int) j2);
    }

    public final void u(int i2, boolean z) throws IOException {
        w(3, 0);
        byte b2 = z ? (byte) 1 : (byte) 0;
        if (this.a.hasRemaining()) {
            this.a.put(b2);
            return;
        }
        throw new zzdrq(this.a.position(), this.a.limit());
    }

    public final void w(int i2, int i3) throws IOException {
        t((i2 << 3) | i3);
    }

    public final void x(int i2, int i3) throws IOException {
        w(i2, 0);
        if (i3 >= 0) {
            t(i3);
        } else {
            l(i3);
        }
    }

    private zzdrp(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
}
