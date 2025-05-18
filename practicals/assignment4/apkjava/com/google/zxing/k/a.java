package com.google.zxing.k;

import com.google.zxing.WriterException;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.g.b;
import com.google.zxing.k.c.f;
import java.util.Map;

/* compiled from: QRCodeWriter.java */
/* loaded from: classes2.dex */
public final class a implements e {
    private static b b(f fVar, int i2, int i3, int i4) {
        com.google.zxing.k.c.b a = fVar.a();
        if (a != null) {
            int e2 = a.e();
            int d2 = a.d();
            int i5 = i4 << 1;
            int i6 = e2 + i5;
            int i7 = i5 + d2;
            int max = Math.max(i2, i6);
            int max2 = Math.max(i3, i7);
            int min = Math.min(max / i6, max2 / i7);
            int i8 = (max - (e2 * min)) / 2;
            int i9 = (max2 - (d2 * min)) / 2;
            b bVar = new b(max, max2);
            int i10 = 0;
            while (i10 < d2) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < e2) {
                    if (a.b(i12, i10) == 1) {
                        bVar.j(i11, i9, min, min);
                    }
                    i12++;
                    i11 += min;
                }
                i10++;
                i9 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.zxing.e
    public b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<c, ?> map) throws WriterException {
        if (!str.isEmpty()) {
            if (aVar != com.google.zxing.a.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(aVar)));
            }
            if (i2 >= 0 && i3 >= 0) {
                com.google.zxing.k.b.a aVar2 = com.google.zxing.k.b.a.L;
                int i4 = 4;
                if (map != null) {
                    c cVar = c.ERROR_CORRECTION;
                    if (map.containsKey(cVar)) {
                        aVar2 = com.google.zxing.k.b.a.valueOf(map.get(cVar).toString());
                    }
                    c cVar2 = c.MARGIN;
                    if (map.containsKey(cVar2)) {
                        i4 = Integer.parseInt(map.get(cVar2).toString());
                    }
                }
                return b(com.google.zxing.k.c.c.n(str, aVar2, map), i2, i3, i4);
            }
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
