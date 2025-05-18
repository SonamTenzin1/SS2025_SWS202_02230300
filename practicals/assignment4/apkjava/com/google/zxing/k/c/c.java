package com.google.zxing.k.c;

import com.google.zxing.WriterException;
import com.google.zxing.k.b.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Encoder.java */
/* loaded from: classes2.dex */
public final class c {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Encoder.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.zxing.k.b.b.values().length];
            a = iArr;
            try {
                iArr[com.google.zxing.k.b.b.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.zxing.k.b.b.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.zxing.k.b.b.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.zxing.k.b.b.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void a(String str, com.google.zxing.g.a aVar, String str2) throws WriterException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                aVar.e(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    static void b(CharSequence charSequence, com.google.zxing.g.a aVar) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int p = p(charSequence.charAt(i2));
            if (p == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int p2 = p(charSequence.charAt(i3));
                if (p2 != -1) {
                    aVar.e((p * 45) + p2, 11);
                    i2 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                aVar.e(p, 6);
                i2 = i3;
            }
        }
    }

    static void c(String str, com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar, String str2) throws WriterException {
        int i2 = a.a[bVar.ordinal()];
        if (i2 == 1) {
            h(str, aVar);
            return;
        }
        if (i2 == 2) {
            b(str, aVar);
        } else if (i2 == 3) {
            a(str, aVar, str2);
        } else {
            if (i2 == 4) {
                e(str, aVar);
                return;
            }
            throw new WriterException("Invalid mode: ".concat(String.valueOf(bVar)));
        }
    }

    private static void d(com.google.zxing.g.c cVar, com.google.zxing.g.a aVar) {
        aVar.e(com.google.zxing.k.b.b.ECI.g(), 4);
        aVar.e(cVar.k(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void e(String str, com.google.zxing.g.a aVar) throws WriterException {
        int i2;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i3 = 0; i3 < length; i3 += 2) {
                int i4 = ((bytes[i3] & 255) << 8) | (bytes[i3 + 1] & 255);
                int i5 = 33088;
                if (i4 < 33088 || i4 > 40956) {
                    if (i4 < 57408 || i4 > 60351) {
                        i2 = -1;
                        if (i2 == -1) {
                            aVar.e(((i2 >> 8) * 192) + (i2 & 255), 13);
                        } else {
                            throw new WriterException("Invalid byte sequence");
                        }
                    } else {
                        i5 = 49472;
                    }
                }
                i2 = i4 - i5;
                if (i2 == -1) {
                }
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    static void f(int i2, com.google.zxing.k.b.c cVar, com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar) throws WriterException {
        int k2 = bVar.k(cVar);
        int i3 = 1 << k2;
        if (i2 < i3) {
            aVar.e(i2, k2);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    static void g(com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar) {
        aVar.e(bVar.g(), 4);
    }

    static void h(CharSequence charSequence, com.google.zxing.g.a aVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                aVar.e((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    aVar.e((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    aVar.e(charAt, 4);
                }
            }
        }
    }

    private static int i(com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar, com.google.zxing.g.a aVar2, com.google.zxing.k.b.c cVar) {
        return aVar.i() + bVar.k(cVar) + aVar2.i();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(com.google.zxing.g.a aVar, com.google.zxing.k.b.a aVar2, com.google.zxing.k.b.c cVar, b bVar) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            e.a(aVar, aVar2, cVar, i4, bVar);
            int j2 = j(bVar);
            if (j2 < i2) {
                i3 = i4;
                i2 = j2;
            }
        }
        return i3;
    }

    private static com.google.zxing.k.b.b l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return com.google.zxing.k.b.b.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else {
                if (p(charAt) == -1) {
                    return com.google.zxing.k.b.b.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return com.google.zxing.k.b.b.ALPHANUMERIC;
        }
        if (z2) {
            return com.google.zxing.k.b.b.NUMERIC;
        }
        return com.google.zxing.k.b.b.BYTE;
    }

    private static com.google.zxing.k.b.c m(int i2, com.google.zxing.k.b.a aVar) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            com.google.zxing.k.b.c e2 = com.google.zxing.k.b.c.e(i3);
            if (v(i2, e2, aVar)) {
                return e2;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static f n(String str, com.google.zxing.k.b.a aVar, Map<com.google.zxing.c, ?> map) throws WriterException {
        com.google.zxing.k.b.c t;
        com.google.zxing.g.c g2;
        boolean z = map != null && map.containsKey(com.google.zxing.c.CHARACTER_SET);
        String obj = z ? map.get(com.google.zxing.c.CHARACTER_SET).toString() : "ISO-8859-1";
        com.google.zxing.k.b.b l = l(str, obj);
        com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
        com.google.zxing.k.b.b bVar = com.google.zxing.k.b.b.BYTE;
        if (l == bVar && z && (g2 = com.google.zxing.g.c.g(obj)) != null) {
            d(g2, aVar2);
        }
        if ((map != null && map.containsKey(com.google.zxing.c.GS1_FORMAT)) && Boolean.valueOf(map.get(com.google.zxing.c.GS1_FORMAT).toString()).booleanValue()) {
            g(com.google.zxing.k.b.b.FNC1_FIRST_POSITION, aVar2);
        }
        g(l, aVar2);
        com.google.zxing.g.a aVar3 = new com.google.zxing.g.a();
        c(str, l, aVar3, obj);
        if (map != null) {
            com.google.zxing.c cVar = com.google.zxing.c.QR_VERSION;
            if (map.containsKey(cVar)) {
                t = com.google.zxing.k.b.c.e(Integer.parseInt(map.get(cVar).toString()));
                if (!v(i(l, aVar2, aVar3, t), t, aVar)) {
                    throw new WriterException("Data too big for requested version");
                }
                com.google.zxing.g.a aVar4 = new com.google.zxing.g.a();
                aVar4.d(aVar2);
                f(l != bVar ? aVar3.j() : str.length(), t, l, aVar4);
                aVar4.d(aVar3);
                c.b c2 = t.c(aVar);
                int d2 = t.d() - c2.d();
                u(d2, aVar4);
                com.google.zxing.g.a r = r(aVar4, t.d(), d2, c2.c());
                f fVar = new f();
                fVar.c(aVar);
                fVar.f(l);
                fVar.g(t);
                int b2 = t.b();
                b bVar2 = new b(b2, b2);
                int k2 = k(r, aVar, t, bVar2);
                fVar.d(k2);
                e.a(r, aVar, t, k2, bVar2);
                fVar.e(bVar2);
                return fVar;
            }
        }
        t = t(aVar, l, aVar2, aVar3);
        com.google.zxing.g.a aVar42 = new com.google.zxing.g.a();
        aVar42.d(aVar2);
        f(l != bVar ? aVar3.j() : str.length(), t, l, aVar42);
        aVar42.d(aVar3);
        c.b c22 = t.c(aVar);
        int d22 = t.d() - c22.d();
        u(d22, aVar42);
        com.google.zxing.g.a r2 = r(aVar42, t.d(), d22, c22.c());
        f fVar2 = new f();
        fVar2.c(aVar);
        fVar2.f(l);
        fVar2.g(t);
        int b22 = t.b();
        b bVar22 = new b(b22, b22);
        int k22 = k(r2, aVar, t, bVar22);
        fVar2.d(k22);
        e.a(r2, aVar, t, k22, bVar22);
        fVar2.e(bVar22);
        return fVar2;
    }

    static byte[] o(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f20312e).b(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static int p(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    static void q(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i4 != i7 + i6) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            } else {
                iArr[0] = i11;
                iArr2[0] = i13;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    static com.google.zxing.g.a r(com.google.zxing.g.a aVar, int i2, int i3, int i4) throws WriterException {
        if (aVar.j() == i3) {
            ArrayList arrayList = new ArrayList(i4);
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                q(i2, i3, i4, i8, iArr, iArr2);
                int i9 = iArr[0];
                byte[] bArr = new byte[i9];
                aVar.l(i5 << 3, bArr, 0, i9);
                byte[] o = o(bArr, iArr2[0]);
                arrayList.add(new com.google.zxing.k.c.a(bArr, o));
                i6 = Math.max(i6, i9);
                i7 = Math.max(i7, o.length);
                i5 += iArr[0];
            }
            if (i3 == i5) {
                com.google.zxing.g.a aVar2 = new com.google.zxing.g.a();
                for (int i10 = 0; i10 < i6; i10++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a2 = ((com.google.zxing.k.c.a) it.next()).a();
                        if (i10 < a2.length) {
                            aVar2.e(a2[i10], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i7; i11++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] b2 = ((com.google.zxing.k.c.a) it2.next()).b();
                        if (i11 < b2.length) {
                            aVar2.e(b2[i11], 8);
                        }
                    }
                }
                if (i2 == aVar2.j()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i2 + " and " + aVar2.j() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static com.google.zxing.k.b.c t(com.google.zxing.k.b.a aVar, com.google.zxing.k.b.b bVar, com.google.zxing.g.a aVar2, com.google.zxing.g.a aVar3) throws WriterException {
        return m(i(bVar, aVar2, aVar3, m(i(bVar, aVar2, aVar3, com.google.zxing.k.b.c.e(1)), aVar)), aVar);
    }

    static void u(int i2, com.google.zxing.g.a aVar) throws WriterException {
        int i3 = i2 << 3;
        if (aVar.i() <= i3) {
            for (int i4 = 0; i4 < 4 && aVar.i() < i3; i4++) {
                aVar.b(false);
            }
            int i5 = aVar.i() & 7;
            if (i5 > 0) {
                while (i5 < 8) {
                    aVar.b(false);
                    i5++;
                }
            }
            int j2 = i2 - aVar.j();
            for (int i6 = 0; i6 < j2; i6++) {
                aVar.e((i6 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.i() != i3) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.i() + " > " + i3);
    }

    private static boolean v(int i2, com.google.zxing.k.b.c cVar, com.google.zxing.k.b.a aVar) {
        return cVar.d() - cVar.c(aVar).d() >= (i2 + 7) / 8;
    }
}
