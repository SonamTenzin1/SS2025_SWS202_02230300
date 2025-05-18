package com.google.zxing.f;

import com.google.zxing.e;
import com.google.zxing.f.b.c;
import com.google.zxing.g.b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: AztecWriter.java */
/* loaded from: classes2.dex */
public final class a implements e {
    private static b b(String str, com.google.zxing.a aVar, int i2, int i3, Charset charset, int i4, int i5) {
        if (aVar == com.google.zxing.a.AZTEC) {
            return c(c.d(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
    }

    private static b c(com.google.zxing.f.b.a aVar, int i2, int i3) {
        b a = aVar.a();
        if (a != null) {
            int h2 = a.h();
            int g2 = a.g();
            int max = Math.max(i2, h2);
            int max2 = Math.max(i3, g2);
            int min = Math.min(max / h2, max2 / g2);
            int i4 = (max - (h2 * min)) / 2;
            int i5 = (max2 - (g2 * min)) / 2;
            b bVar = new b(max, max2);
            int i6 = 0;
            while (i6 < g2) {
                int i7 = i4;
                int i8 = 0;
                while (i8 < h2) {
                    if (a.f(i8, i6)) {
                        bVar.j(i7, i5, min, min);
                    }
                    i8++;
                    i7 += min;
                }
                i6++;
                i5 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.zxing.e
    public b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) {
        Charset charset;
        int i4;
        int i5;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (map != null) {
            com.google.zxing.c cVar = com.google.zxing.c.CHARACTER_SET;
            if (map.containsKey(cVar)) {
                charset2 = Charset.forName(map.get(cVar).toString());
            }
            com.google.zxing.c cVar2 = com.google.zxing.c.ERROR_CORRECTION;
            int parseInt = map.containsKey(cVar2) ? Integer.parseInt(map.get(cVar2).toString()) : 33;
            com.google.zxing.c cVar3 = com.google.zxing.c.AZTEC_LAYERS;
            if (map.containsKey(cVar3)) {
                charset = charset2;
                i4 = parseInt;
                i5 = Integer.parseInt(map.get(cVar3).toString());
                return b(str, aVar, i2, i3, charset, i4, i5);
            }
            charset = charset2;
            i4 = parseInt;
        } else {
            charset = charset2;
            i4 = 33;
        }
        i5 = 0;
        return b(str, aVar, i2, i3, charset, i4, i5);
    }
}
