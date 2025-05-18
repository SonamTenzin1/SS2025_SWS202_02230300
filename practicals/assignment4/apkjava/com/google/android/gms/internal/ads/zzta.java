package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzta {
    public final List<byte[]> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16748b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16749c;

    /* renamed from: d, reason: collision with root package name */
    private final int f16750d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16751e;

    private zzta(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.a = list;
        this.f16748b = i2;
        this.f16749c = i3;
        this.f16750d = i4;
        this.f16751e = f2;
    }

    public static zzta a(zzst zzstVar) throws zzlm {
        int i2;
        int i3;
        float f2;
        try {
            zzstVar.l(4);
            int g2 = (zzstVar.g() & 3) + 1;
            if (g2 != 3) {
                ArrayList arrayList = new ArrayList();
                int g3 = zzstVar.g() & 31;
                for (int i4 = 0; i4 < g3; i4++) {
                    arrayList.add(b(zzstVar));
                }
                int g4 = zzstVar.g();
                for (int i5 = 0; i5 < g4; i5++) {
                    arrayList.add(b(zzstVar));
                }
                if (g3 > 0) {
                    zzsr a = zzsq.a((byte[]) arrayList.get(0), g2, ((byte[]) arrayList.get(0)).length);
                    int i6 = a.f16720b;
                    int i7 = a.f16721c;
                    f2 = a.f16722d;
                    i2 = i6;
                    i3 = i7;
                } else {
                    i2 = -1;
                    i3 = -1;
                    f2 = 1.0f;
                }
                return new zzta(arrayList, g2, i2, i3, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new zzlm("Error parsing AVC config", e2);
        }
    }

    private static byte[] b(zzst zzstVar) {
        int h2 = zzstVar.h();
        int b2 = zzstVar.b();
        zzstVar.l(h2);
        return zzsl.b(zzstVar.a, b2, h2);
    }
}
