package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class i10 {
    private final int a;

    /* renamed from: b, reason: collision with root package name */
    private final int f12730b;

    /* renamed from: c, reason: collision with root package name */
    private final int f12731c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12732d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12733e;

    /* renamed from: f, reason: collision with root package name */
    private final short[] f12734f;

    /* renamed from: g, reason: collision with root package name */
    private int f12735g;

    /* renamed from: h, reason: collision with root package name */
    private short[] f12736h;

    /* renamed from: i, reason: collision with root package name */
    private int f12737i;

    /* renamed from: j, reason: collision with root package name */
    private short[] f12738j;

    /* renamed from: k, reason: collision with root package name */
    private int f12739k;
    private short[] l;
    private int q;
    private int r;
    private int s;
    private int t;
    private int v;
    private int w;
    private int x;
    private int m = 0;
    private int n = 0;
    private int u = 0;
    private float o = 1.0f;
    private float p = 1.0f;

    public i10(int i2, int i3) {
        this.a = i2;
        this.f12730b = i3;
        this.f12731c = i2 / 400;
        int i4 = i2 / 65;
        this.f12732d = i4;
        int i5 = i4 * 2;
        this.f12733e = i5;
        this.f12734f = new short[i5];
        this.f12735g = i5;
        this.f12736h = new short[i5 * i3];
        this.f12737i = i5;
        this.f12738j = new short[i5 * i3];
        this.f12739k = i5;
        this.l = new short[i5 * i3];
    }

    private final int b(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f12730b;
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                short s = sArr[i5 + i11];
                short s2 = sArr[i5 + i3 + i11];
                i10 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i10 * i8 < i6 * i3) {
                i8 = i3;
                i6 = i10;
            }
            if (i10 * i7 > i9 * i3) {
                i7 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.w = i6 / i8;
        this.x = i9 / i7;
        return i8;
    }

    private static void d(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }

    private final void f(short[] sArr, int i2, int i3) {
        g(i3);
        int i4 = this.f12730b;
        System.arraycopy(sArr, i2 * i4, this.f12738j, this.r * i4, i4 * i3);
        this.r += i3;
    }

    private final void g(int i2) {
        int i3 = this.r + i2;
        int i4 = this.f12737i;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.f12737i = i5;
            this.f12738j = Arrays.copyOf(this.f12738j, i5 * this.f12730b);
        }
    }

    private final void h(int i2) {
        int i3 = this.q + i2;
        int i4 = this.f12735g;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.f12735g = i5;
            this.f12736h = Arrays.copyOf(this.f12736h, i5 * this.f12730b);
        }
    }

    private final void j(short[] sArr, int i2, int i3) {
        int i4 = this.f12733e / i3;
        int i5 = this.f12730b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f12734f[i8] = (short) (i9 / i6);
        }
    }

    private final void m() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = this.r;
        float f2 = this.o / this.p;
        double d2 = f2;
        int i9 = 1;
        if (d2 <= 1.00001d && d2 >= 0.99999d) {
            f(this.f12736h, 0, this.q);
            this.q = 0;
        } else {
            int i10 = this.q;
            if (i10 >= this.f12733e) {
                int i11 = 0;
                while (true) {
                    int i12 = this.t;
                    if (i12 > 0) {
                        int min = Math.min(this.f12733e, i12);
                        f(this.f12736h, i11, min);
                        this.t -= min;
                        i11 += min;
                    } else {
                        short[] sArr = this.f12736h;
                        int i13 = this.a;
                        int i14 = i13 > 4000 ? i13 / 4000 : 1;
                        if (this.f12730b == i9 && i14 == i9) {
                            i2 = b(sArr, i11, this.f12731c, this.f12732d);
                        } else {
                            j(sArr, i11, i14);
                            int b2 = b(this.f12734f, 0, this.f12731c / i14, this.f12732d / i14);
                            if (i14 != i9) {
                                int i15 = b2 * i14;
                                int i16 = i14 << 2;
                                int i17 = i15 - i16;
                                int i18 = i15 + i16;
                                int i19 = this.f12731c;
                                if (i17 < i19) {
                                    i17 = i19;
                                }
                                int i20 = this.f12732d;
                                if (i18 > i20) {
                                    i18 = i20;
                                }
                                if (this.f12730b == i9) {
                                    i2 = b(sArr, i11, i17, i18);
                                } else {
                                    j(sArr, i11, i9);
                                    i2 = b(this.f12734f, 0, i17, i18);
                                }
                            } else {
                                i2 = b2;
                            }
                        }
                        int i21 = this.w;
                        int i22 = i21 != 0 && this.u != 0 && this.x <= i21 * 3 && (i21 << 1) > this.v * 3 ? this.u : i2;
                        this.v = i21;
                        this.u = i2;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.f12736h;
                            if (f2 >= 2.0f) {
                                i4 = (int) (i22 / (f2 - 1.0f));
                            } else {
                                this.t = (int) ((i22 * (2.0f - f2)) / (f2 - 1.0f));
                                i4 = i22;
                            }
                            g(i4);
                            int i23 = i4;
                            d(i4, this.f12730b, this.f12738j, this.r, sArr2, i11, sArr2, i11 + i22);
                            this.r += i23;
                            i11 += i22 + i23;
                        } else {
                            int i24 = i22;
                            short[] sArr3 = this.f12736h;
                            if (f2 < 0.5f) {
                                i3 = (int) ((i24 * f2) / (1.0f - f2));
                            } else {
                                this.t = (int) ((i24 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                                i3 = i24;
                            }
                            int i25 = i24 + i3;
                            g(i25);
                            int i26 = this.f12730b;
                            System.arraycopy(sArr3, i11 * i26, this.f12738j, this.r * i26, i26 * i24);
                            d(i3, this.f12730b, this.f12738j, this.r + i24, sArr3, i24 + i11, sArr3, i11);
                            this.r += i25;
                            i11 += i3;
                        }
                    }
                    if (this.f12733e + i11 > i10) {
                        break;
                    } else {
                        i9 = 1;
                    }
                }
                int i27 = this.q - i11;
                short[] sArr4 = this.f12736h;
                int i28 = this.f12730b;
                System.arraycopy(sArr4, i11 * i28, sArr4, 0, i28 * i27);
                this.q = i27;
            }
        }
        float f3 = this.p;
        if (f3 == 1.0f || this.r == i8) {
            return;
        }
        int i29 = this.a;
        int i30 = (int) (i29 / f3);
        while (true) {
            if (i30 <= 16384 && i29 <= 16384) {
                break;
            }
            i30 /= 2;
            i29 /= 2;
        }
        int i31 = this.r - i8;
        int i32 = this.s + i31;
        int i33 = this.f12739k;
        if (i32 > i33) {
            int i34 = i33 + (i33 / 2) + i31;
            this.f12739k = i34;
            this.l = Arrays.copyOf(this.l, i34 * this.f12730b);
        }
        short[] sArr5 = this.f12738j;
        int i35 = this.f12730b;
        System.arraycopy(sArr5, i8 * i35, this.l, this.s * i35, i35 * i31);
        this.r = i8;
        this.s += i31;
        int i36 = 0;
        while (true) {
            i5 = this.s;
            if (i36 >= i5 - 1) {
                break;
            }
            while (true) {
                i6 = this.m;
                int i37 = (i6 + 1) * i30;
                i7 = this.n;
                if (i37 <= i7 * i29) {
                    break;
                }
                g(1);
                int i38 = 0;
                while (true) {
                    int i39 = this.f12730b;
                    if (i38 < i39) {
                        short[] sArr6 = this.f12738j;
                        int i40 = (this.r * i39) + i38;
                        short[] sArr7 = this.l;
                        int i41 = (i36 * i39) + i38;
                        short s = sArr7[i41];
                        short s2 = sArr7[i41 + i39];
                        int i42 = this.n * i29;
                        int i43 = this.m;
                        int i44 = i43 * i30;
                        int i45 = (i43 + 1) * i30;
                        int i46 = i45 - i42;
                        int i47 = i45 - i44;
                        sArr6[i40] = (short) (((s * i46) + ((i47 - i46) * s2)) / i47);
                        i38++;
                    }
                }
                this.n++;
                this.r++;
            }
            int i48 = i6 + 1;
            this.m = i48;
            if (i48 == i29) {
                this.m = 0;
                zzsk.e(i7 == i30);
                this.n = 0;
            }
            i36++;
        }
        int i49 = i5 - 1;
        if (i49 != 0) {
            short[] sArr8 = this.l;
            int i50 = this.f12730b;
            System.arraycopy(sArr8, i49 * i50, sArr8, 0, (i5 - i49) * i50);
            this.s -= i49;
        }
    }

    public final void a(float f2) {
        this.o = f2;
    }

    public final void c(float f2) {
        this.p = f2;
    }

    public final void e(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.f12730b;
        int i3 = remaining / i2;
        h(i3);
        shortBuffer.get(this.f12736h, this.q * this.f12730b, ((i2 * i3) << 1) / 2);
        this.q += i3;
        m();
    }

    public final void i(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f12730b, this.r);
        shortBuffer.put(this.f12738j, 0, this.f12730b * min);
        int i2 = this.r - min;
        this.r = i2;
        short[] sArr = this.f12738j;
        int i3 = this.f12730b;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }

    public final void k() {
        int i2;
        int i3 = this.q;
        float f2 = this.o;
        float f3 = this.p;
        int i4 = this.r + ((int) ((((i3 / (f2 / f3)) + this.s) / f3) + 0.5f));
        h((this.f12733e * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f12733e;
            int i6 = this.f12730b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.f12736h[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.q += i2 * 2;
        m();
        if (this.r > i4) {
            this.r = i4;
        }
        this.q = 0;
        this.t = 0;
        this.s = 0;
    }

    public final int l() {
        return this.r;
    }
}
