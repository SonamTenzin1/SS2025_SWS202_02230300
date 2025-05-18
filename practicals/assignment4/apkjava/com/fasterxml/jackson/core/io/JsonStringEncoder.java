package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

/* loaded from: classes2.dex */
public final class JsonStringEncoder {
    protected ByteArrayBuilder _bytes;
    protected final char[] _qbuf;
    protected TextBuffer _text;
    private static final char[] HC = CharTypes.copyHexChars();
    private static final byte[] HB = CharTypes.copyHexBytes();
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal<>();

    public JsonStringEncoder() {
        this._qbuf = r0;
        char[] cArr = {'\\', 0, '0', '0'};
    }

    private int _appendByte(int i2, int i3, ByteArrayBuilder byteArrayBuilder, int i4) {
        byteArrayBuilder.setCurrentSegmentLength(i4);
        byteArrayBuilder.append(92);
        if (i3 < 0) {
            byteArrayBuilder.append(117);
            if (i2 > 255) {
                int i5 = i2 >> 8;
                byte[] bArr = HB;
                byteArrayBuilder.append(bArr[i5 >> 4]);
                byteArrayBuilder.append(bArr[i5 & 15]);
                i2 &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = HB;
            byteArrayBuilder.append(bArr2[i2 >> 4]);
            byteArrayBuilder.append(bArr2[i2 & 15]);
        } else {
            byteArrayBuilder.append((byte) i3);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private int _appendNamed(int i2, char[] cArr) {
        cArr[1] = (char) i2;
        return 2;
    }

    private int _appendNumeric(int i2, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = HC;
        cArr[4] = cArr2[i2 >> 4];
        cArr[5] = cArr2[i2 & 15];
        return 6;
    }

    private static int _convert(int i2, int i3) {
        if (i3 >= 56320 && i3 <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i3 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i3) + "; illegal combination");
    }

    private static void _illegal(int i2) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i2));
    }

    public static JsonStringEncoder getInstance() {
        ThreadLocal<SoftReference<JsonStringEncoder>> threadLocal = _threadEncoder;
        SoftReference<JsonStringEncoder> softReference = threadLocal.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : softReference.get();
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
        threadLocal.set(new SoftReference<>(jsonStringEncoder2));
        return jsonStringEncoder2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] encodeAsUTF8(String str) {
        int i2;
        int i3;
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] resetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int length2 = resetAndGetFirstSegment.length;
        int i4 = 0;
        int i5 = 0;
        loop0: while (true) {
            if (i4 >= length) {
                break;
            }
            int i6 = i4 + 1;
            int charAt = str.charAt(i4);
            while (charAt <= 127) {
                if (i5 >= length2) {
                    resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = resetAndGetFirstSegment.length;
                    i5 = 0;
                }
                int i7 = i5 + 1;
                resetAndGetFirstSegment[i5] = (byte) charAt;
                if (i6 >= length) {
                    i5 = i7;
                    break loop0;
                }
                int charAt2 = str.charAt(i6);
                i6++;
                charAt = charAt2;
                i5 = i7;
            }
            if (i5 >= length2) {
                resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                length2 = resetAndGetFirstSegment.length;
                i5 = 0;
            }
            if (charAt < 2048) {
                i2 = i5 + 1;
                resetAndGetFirstSegment[i5] = (byte) ((charAt >> 6) | 192);
            } else if (charAt >= 55296 && charAt <= 57343) {
                if (charAt > 56319) {
                    _illegal(charAt);
                }
                if (i6 >= length) {
                    _illegal(charAt);
                }
                int i8 = i6 + 1;
                int _convert = _convert(charAt, str.charAt(i6));
                if (_convert > 1114111) {
                    _illegal(_convert);
                }
                int i9 = i5 + 1;
                resetAndGetFirstSegment[i5] = (byte) ((_convert >> 18) | 240);
                if (i9 >= length2) {
                    resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = resetAndGetFirstSegment.length;
                    i9 = 0;
                }
                int i10 = i9 + 1;
                resetAndGetFirstSegment[i9] = (byte) (((_convert >> 12) & 63) | 128);
                if (i10 >= length2) {
                    resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = resetAndGetFirstSegment.length;
                    i10 = 0;
                }
                int i11 = i10 + 1;
                resetAndGetFirstSegment[i10] = (byte) (((_convert >> 6) & 63) | 128);
                i3 = _convert;
                i4 = i8;
                i2 = i11;
                if (i2 < length2) {
                    resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = resetAndGetFirstSegment.length;
                    i2 = 0;
                }
                resetAndGetFirstSegment[i2] = (byte) ((i3 & 63) | 128);
                i5 = i2 + 1;
            } else {
                int i12 = i5 + 1;
                resetAndGetFirstSegment[i5] = (byte) ((charAt >> 12) | 224);
                if (i12 >= length2) {
                    resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = resetAndGetFirstSegment.length;
                    i12 = 0;
                }
                resetAndGetFirstSegment[i12] = (byte) (((charAt >> 6) & 63) | 128);
                i2 = i12 + 1;
            }
            i3 = charAt;
            i4 = i6;
            if (i2 < length2) {
            }
            resetAndGetFirstSegment[i2] = (byte) ((i3 & 63) | 128);
            i5 = i2 + 1;
        }
        return this._bytes.completeAndCoalesce(i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r8 = r6 + 1;
        r6 = r12.charAt(r6);
        r9 = r2[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r9 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r6 = _appendNumeric(r6, r11._qbuf);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        r9 = r7 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r9 <= r1.length) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        r9 = r1.length - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r9 <= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        java.lang.System.arraycopy(r11._qbuf, 0, r1, r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        r1 = r0.finishCurrentSegment();
        r6 = r6 - r9;
        java.lang.System.arraycopy(r11._qbuf, r9, r1, 0, r6);
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
    
        java.lang.System.arraycopy(r11._qbuf, 0, r1, r7, r6);
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r6 = _appendNamed(r9, r11._qbuf);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public char[] quoteAsString(String str) {
        int i2;
        TextBuffer textBuffer = this._text;
        if (textBuffer == null) {
            textBuffer = new TextBuffer(null);
            this._text = textBuffer;
        }
        char[] emptyAndGetCurrentSegment = textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length = iArr.length;
        int length2 = str.length();
        int i3 = 0;
        int i4 = 0;
        loop0: while (true) {
            if (i3 >= length2) {
                break;
            }
            while (true) {
                char charAt = str.charAt(i3);
                if (charAt < length && iArr[charAt] != 0) {
                    break;
                }
                if (i4 >= emptyAndGetCurrentSegment.length) {
                    emptyAndGetCurrentSegment = textBuffer.finishCurrentSegment();
                    i4 = 0;
                }
                int i5 = i4 + 1;
                emptyAndGetCurrentSegment[i4] = charAt;
                i3++;
                if (i3 >= length2) {
                    i4 = i5;
                    break loop0;
                }
                i4 = i5;
            }
            i3 = i2;
        }
        textBuffer.setCurrentLength(i4);
        return textBuffer.contentsAsArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r5 < r2.length) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        r2 = r0.finishCurrentSegment();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        r7 = r4 + 1;
        r4 = r11.charAt(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        if (r4 > 127) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r4 > 2047) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        r6 = r5 + 1;
        r2[r5] = (byte) ((r4 >> 6) | 192);
        r4 = (r4 & '?') | 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r5 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f6, code lost:
    
        if (r6 < r2.length) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f8, code lost:
    
        r2 = r0.finishCurrentSegment();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fd, code lost:
    
        r2[r6] = (byte) r5;
        r5 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
    
        if (r4 < 55296) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if (r4 <= 57343) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:
    
        if (r4 <= 56319) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
    
        _illegal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
    
        if (r7 < r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0086, code lost:
    
        _illegal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0089, code lost:
    
        r6 = r7 + 1;
        r4 = _convert(r4, r11.charAt(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        if (r4 <= 1114111) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0098, code lost:
    
        _illegal(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        r7 = r5 + 1;
        r2[r5] = (byte) ((r4 >> 18) | 240);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
    
        if (r7 < r2.length) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a7, code lost:
    
        r2 = r0.finishCurrentSegment();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ac, code lost:
    
        r5 = r7 + 1;
        r2[r7] = (byte) (((r4 >> 12) & 63) | 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b8, code lost:
    
        if (r5 < r2.length) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ba, code lost:
    
        r2 = r0.finishCurrentSegment();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bf, code lost:
    
        r7 = r5 + 1;
        r2[r5] = (byte) (((r4 >> 6) & 63) | 128);
        r5 = (r4 & 63) | 128;
        r4 = r6;
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d2, code lost:
    
        r6 = r5 + 1;
        r2[r5] = (byte) ((r4 >> '\f') | 224);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        if (r6 < r2.length) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00de, code lost:
    
        r2 = r0.finishCurrentSegment();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e3, code lost:
    
        r2[r6] = (byte) (((r4 >> 6) & 63) | 128);
        r4 = (r4 & '?') | 128;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0050, code lost:
    
        r5 = _appendByte(r4, r6[r4], r0, r5);
        r2 = r0.getCurrentSegment();
        r4 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] quoteAsUTF8(String str) {
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] resetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int i2 = 0;
        int i3 = 0;
        loop0: while (true) {
            if (i2 >= length) {
                break;
            }
            int[] iArr = CharTypes.get7BitOutputEscapes();
            while (true) {
                char charAt = str.charAt(i2);
                if (charAt > 127 || iArr[charAt] != 0) {
                    break;
                }
                if (i3 >= resetAndGetFirstSegment.length) {
                    resetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    i3 = 0;
                }
                int i4 = i3 + 1;
                resetAndGetFirstSegment[i3] = (byte) charAt;
                i2++;
                if (i2 >= length) {
                    i3 = i4;
                    break loop0;
                }
                i3 = i4;
            }
        }
        return this._bytes.completeAndCoalesce(i3);
    }
}
