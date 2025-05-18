package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zztg {
    public final List<byte[]> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16762b;

    private zztg(List<byte[]> list, int i2) {
        this.a = list;
        this.f16762b = i2;
    }

    public static zztg a(zzst zzstVar) throws zzlm {
        try {
            zzstVar.l(21);
            int g2 = zzstVar.g() & 3;
            int g3 = zzstVar.g();
            int b2 = zzstVar.b();
            int i2 = 0;
            for (int i3 = 0; i3 < g3; i3++) {
                zzstVar.l(1);
                int h2 = zzstVar.h();
                for (int i4 = 0; i4 < h2; i4++) {
                    int h3 = zzstVar.h();
                    i2 += h3 + 4;
                    zzstVar.l(h3);
                }
            }
            zzstVar.k(b2);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < g3; i6++) {
                zzstVar.l(1);
                int h4 = zzstVar.h();
                for (int i7 = 0; i7 < h4; i7++) {
                    int h5 = zzstVar.h();
                    byte[] bArr2 = zzsq.a;
                    System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                    int length = i5 + bArr2.length;
                    System.arraycopy(zzstVar.a, zzstVar.b(), bArr, length, h5);
                    i5 = length + h5;
                    zzstVar.l(h5);
                }
            }
            return new zztg(i2 == 0 ? null : Collections.singletonList(bArr), g2 + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzlm("Error parsing HEVC config", e2);
        }
    }
}
