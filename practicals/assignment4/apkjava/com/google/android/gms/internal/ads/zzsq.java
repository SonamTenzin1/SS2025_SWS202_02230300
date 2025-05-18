package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzsq {
    public static final byte[] a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    private static final float[] f16717b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    private static final Object f16718c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static int[] f16719d = new int[10];

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzsr a(byte[] bArr, int i2, int i3) {
        int e2;
        boolean z;
        int i4;
        boolean z2;
        boolean d2;
        float f2;
        int a2;
        int i5;
        zzsu zzsuVar = new zzsu(bArr, i2, i3);
        zzsuVar.b(8);
        int a3 = zzsuVar.a(8);
        zzsuVar.b(16);
        int e3 = zzsuVar.e();
        if (a3 == 100 || a3 == 110 || a3 == 122 || a3 == 244 || a3 == 44 || a3 == 83 || a3 == 86 || a3 == 118 || a3 == 128 || a3 == 138) {
            e2 = zzsuVar.e();
            boolean d3 = e2 == 3 ? zzsuVar.d() : false;
            zzsuVar.e();
            zzsuVar.e();
            zzsuVar.b(1);
            if (zzsuVar.d()) {
                int i6 = e2 != 3 ? 8 : 12;
                int i7 = 0;
                while (i7 < i6) {
                    if (zzsuVar.d()) {
                        int i8 = i7 < 6 ? 16 : 64;
                        int i9 = 8;
                        int i10 = 8;
                        for (int i11 = 0; i11 < i8; i11++) {
                            if (i9 != 0) {
                                i9 = ((zzsuVar.f() + i10) + 256) % 256;
                            }
                            if (i9 != 0) {
                                i10 = i9;
                            }
                        }
                    }
                    i7++;
                }
            }
            z = d3;
        } else {
            e2 = 1;
            z = false;
        }
        int e4 = zzsuVar.e() + 4;
        int e5 = zzsuVar.e();
        if (e5 == 0) {
            i4 = zzsuVar.e() + 4;
        } else {
            if (e5 == 1) {
                boolean d4 = zzsuVar.d();
                zzsuVar.f();
                zzsuVar.f();
                long e6 = zzsuVar.e();
                for (int i12 = 0; i12 < e6; i12++) {
                    zzsuVar.e();
                }
                z2 = d4;
                i4 = 0;
                zzsuVar.e();
                zzsuVar.b(1);
                int e7 = zzsuVar.e() + 1;
                int e8 = zzsuVar.e() + 1;
                d2 = zzsuVar.d();
                int i13 = (2 - (d2 ? 1 : 0)) * e8;
                if (!d2) {
                    zzsuVar.b(1);
                }
                zzsuVar.b(1);
                int i14 = e7 << 4;
                int i15 = i13 << 4;
                if (zzsuVar.d()) {
                    int e9 = zzsuVar.e();
                    int e10 = zzsuVar.e();
                    int e11 = zzsuVar.e();
                    int e12 = zzsuVar.e();
                    if (e2 == 0) {
                        i5 = 2 - (d2 ? 1 : 0);
                    } else {
                        int i16 = e2 == 3 ? 1 : 2;
                        i5 = (2 - (d2 ? 1 : 0)) * (e2 == 1 ? 2 : 1);
                        r7 = i16;
                    }
                    i14 -= (e9 + e10) * r7;
                    i15 -= (e11 + e12) * i5;
                }
                int i17 = i14;
                int i18 = i15;
                float f3 = 1.0f;
                if (zzsuVar.d() && zzsuVar.d()) {
                    a2 = zzsuVar.a(8);
                    if (a2 != 255) {
                        int a4 = zzsuVar.a(16);
                        int a5 = zzsuVar.a(16);
                        if (a4 != 0 && a5 != 0) {
                            f3 = a4 / a5;
                        }
                        f2 = f3;
                    } else {
                        float[] fArr = f16717b;
                        if (a2 < fArr.length) {
                            f2 = fArr[a2];
                        } else {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append("Unexpected aspect_ratio_idc value: ");
                            sb.append(a2);
                            Log.w("NalUnitUtil", sb.toString());
                        }
                    }
                    return new zzsr(e3, i17, i18, f2, z, d2, e4, e5, i4, z2);
                }
                f2 = 1.0f;
                return new zzsr(e3, i17, i18, f2, z, d2, e4, e5, i4, z2);
            }
            i4 = 0;
        }
        z2 = false;
        zzsuVar.e();
        zzsuVar.b(1);
        int e72 = zzsuVar.e() + 1;
        int e82 = zzsuVar.e() + 1;
        d2 = zzsuVar.d();
        int i132 = (2 - (d2 ? 1 : 0)) * e82;
        if (!d2) {
        }
        zzsuVar.b(1);
        int i142 = e72 << 4;
        int i152 = i132 << 4;
        if (zzsuVar.d()) {
        }
        int i172 = i142;
        int i182 = i152;
        float f32 = 1.0f;
        if (zzsuVar.d()) {
            a2 = zzsuVar.a(8);
            if (a2 != 255) {
            }
            return new zzsr(e3, i172, i182, f2, z, d2, e4, e5, i4, z2);
        }
        f2 = 1.0f;
        return new zzsr(e3, i172, i182, f2, z, d2, e4, e5, i4, z2);
    }

    public static void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < position) {
                int i5 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }
}
