package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class pu extends zzdnd {

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f13183f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f13184g;

    /* renamed from: h, reason: collision with root package name */
    private int f13185h;

    /* renamed from: i, reason: collision with root package name */
    private int f13186i;

    /* renamed from: j, reason: collision with root package name */
    private int f13187j;

    /* renamed from: k, reason: collision with root package name */
    private int f13188k;
    private int l;
    private int m;

    private pu(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.m = Integer.MAX_VALUE;
        this.f13183f = bArr;
        this.f13185h = i3 + i2;
        this.f13187j = i2;
        this.f13188k = i2;
        this.f13184g = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int C() throws IOException {
        int i2;
        int i3 = this.f13187j;
        int i4 = this.f13185h;
        if (i4 != i3) {
            byte[] bArr = this.f13183f;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f13187j = i5;
                return b2;
            }
            if (i4 - i5 >= 9) {
                int i6 = i5 + 1;
                int i7 = b2 ^ (bArr[i5] << 7);
                if (i7 < 0) {
                    i2 = i7 ^ (-128);
                } else {
                    int i8 = i6 + 1;
                    int i9 = i7 ^ (bArr[i6] << 14);
                    if (i9 >= 0) {
                        i2 = i9 ^ 16256;
                    } else {
                        i6 = i8 + 1;
                        int i10 = i9 ^ (bArr[i8] << 21);
                        if (i10 < 0) {
                            i2 = i10 ^ (-2080896);
                        } else {
                            i8 = i6 + 1;
                            byte b3 = bArr[i6];
                            i2 = (i10 ^ (b3 << 28)) ^ 266354560;
                            if (b3 < 0) {
                                i6 = i8 + 1;
                                if (bArr[i8] < 0) {
                                    i8 = i6 + 1;
                                    if (bArr[i6] < 0) {
                                        i6 = i8 + 1;
                                        if (bArr[i8] < 0) {
                                            i8 = i6 + 1;
                                            if (bArr[i6] < 0) {
                                                i6 = i8 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i6 = i8;
                }
                this.f13187j = i6;
                return i2;
            }
        }
        return (int) s();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long D() throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        int i2;
        int i3 = this.f13187j;
        int i4 = this.f13185h;
        if (i4 != i3) {
            byte[] bArr = this.f13183f;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f13187j = i5;
                return b2;
            }
            if (i4 - i5 >= 9) {
                int i6 = i5 + 1;
                int i7 = b2 ^ (bArr[i5] << 7);
                if (i7 >= 0) {
                    int i8 = i6 + 1;
                    int i9 = i7 ^ (bArr[i6] << 14);
                    if (i9 >= 0) {
                        i6 = i8;
                        j5 = i9 ^ 16256;
                    } else {
                        i6 = i8 + 1;
                        int i10 = i9 ^ (bArr[i8] << 21);
                        if (i10 < 0) {
                            i2 = i10 ^ (-2080896);
                        } else {
                            long j6 = i10;
                            int i11 = i6 + 1;
                            long j7 = j6 ^ (bArr[i6] << 28);
                            if (j7 >= 0) {
                                j4 = 266354560;
                            } else {
                                i6 = i11 + 1;
                                long j8 = j7 ^ (bArr[i11] << 35);
                                if (j8 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i11 = i6 + 1;
                                    j7 = j8 ^ (bArr[i6] << 42);
                                    if (j7 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i6 = i11 + 1;
                                        j8 = j7 ^ (bArr[i11] << 49);
                                        if (j8 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            int i12 = i6 + 1;
                                            j2 = (j8 ^ (bArr[i6] << 56)) ^ 71499008037633920L;
                                            i6 = j2 < 0 ? i12 + 1 : i12;
                                            j5 = j2;
                                        }
                                    }
                                }
                                j2 = j8 ^ j3;
                                j5 = j2;
                            }
                            j5 = j4 ^ j7;
                            i6 = i11;
                        }
                    }
                    this.f13187j = i6;
                    return j5;
                }
                i2 = i7 ^ (-128);
                j5 = i2;
                this.f13187j = i6;
                return j5;
            }
        }
        return s();
    }

    private final int E() throws IOException {
        int i2 = this.f13187j;
        if (this.f13185h - i2 >= 4) {
            byte[] bArr = this.f13183f;
            this.f13187j = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }
        throw zzdok.a();
    }

    private final long F() throws IOException {
        int i2 = this.f13187j;
        if (this.f13185h - i2 >= 8) {
            byte[] bArr = this.f13183f;
            this.f13187j = i2 + 8;
            return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
        }
        throw zzdok.a();
    }

    private final void G() {
        int i2 = this.f13185h + this.f13186i;
        this.f13185h = i2;
        int i3 = i2 - this.f13188k;
        int i4 = this.m;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f13186i = i5;
            this.f13185h = i2 - i5;
            return;
        }
        this.f13186i = 0;
    }

    private final byte H() throws IOException {
        int i2 = this.f13187j;
        if (i2 != this.f13185h) {
            byte[] bArr = this.f13183f;
            this.f13187j = i2 + 1;
            return bArr[i2];
        }
        throw zzdok.a();
    }

    private final void I(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f13185h;
            int i4 = this.f13187j;
            if (i2 <= i3 - i4) {
                this.f13187j = i4 + i2;
                return;
            }
        }
        if (i2 < 0) {
            throw zzdok.b();
        }
        throw zzdok.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final void A(int i2) {
        this.m = i2;
        G();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final double a() throws IOException {
        return Double.longBitsToDouble(F());
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final float b() throws IOException {
        return Float.intBitsToFloat(E());
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final String c() throws IOException {
        int C = C();
        if (C > 0 && C <= this.f13185h - this.f13187j) {
            String str = new String(this.f13183f, this.f13187j, C, zzdod.a);
            this.f13187j += C;
            return str;
        }
        if (C == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (C < 0) {
            throw zzdok.b();
        }
        throw zzdok.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int d() throws IOException {
        if (t()) {
            this.l = 0;
            return 0;
        }
        int C = C();
        this.l = C;
        if ((C >>> 3) != 0) {
            return C;
        }
        throw zzdok.d();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long e() throws IOException {
        return D();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long f() throws IOException {
        return D();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int g() throws IOException {
        return C();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long h() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int i() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final boolean j() throws IOException {
        return D() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final String k() throws IOException {
        int C = C();
        if (C > 0) {
            int i2 = this.f13185h;
            int i3 = this.f13187j;
            if (C <= i2 - i3) {
                String m = jx.m(this.f13183f, i3, C);
                this.f13187j += C;
                return m;
            }
        }
        if (C == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (C <= 0) {
            throw zzdok.b();
        }
        throw zzdok.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final zzdmr l() throws IOException {
        byte[] bArr;
        int C = C();
        if (C > 0) {
            int i2 = this.f13185h;
            int i3 = this.f13187j;
            if (C <= i2 - i3) {
                zzdmr A = zzdmr.A(this.f13183f, i3, C);
                this.f13187j += C;
                return A;
            }
        }
        if (C == 0) {
            return zzdmr.f15982f;
        }
        if (C > 0) {
            int i4 = this.f13185h;
            int i5 = this.f13187j;
            if (C <= i4 - i5) {
                int i6 = C + i5;
                this.f13187j = i6;
                bArr = Arrays.copyOfRange(this.f13183f, i5, i6);
                return zzdmr.i(bArr);
            }
        }
        if (C > 0) {
            throw zzdok.a();
        }
        if (C == 0) {
            bArr = zzdod.f16033c;
            return zzdmr.i(bArr);
        }
        throw zzdok.b();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int m() throws IOException {
        return C();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int n() throws IOException {
        return C();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int o() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long p() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int q() throws IOException {
        return zzdnd.B(C());
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long r() throws IOException {
        return zzdnd.w(D());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long s() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & Byte.MAX_VALUE) << i2;
            if ((H() & 128) == 0) {
                return j2;
            }
        }
        throw zzdok.c();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final boolean t() throws IOException {
        return this.f13187j == this.f13185h;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int u() {
        return this.f13187j - this.f13188k;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final void x(int i2) throws zzdok {
        if (this.l != i2) {
            throw zzdok.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final boolean y(int i2) throws IOException {
        int d2;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.f13185h - this.f13187j >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.f13183f;
                    int i5 = this.f13187j;
                    this.f13187j = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw zzdok.c();
            }
            while (i4 < 10) {
                if (H() < 0) {
                    i4++;
                }
            }
            throw zzdok.c();
            return true;
        }
        if (i3 == 1) {
            I(8);
            return true;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    return false;
                }
                if (i3 == 5) {
                    I(4);
                    return true;
                }
                throw zzdok.f();
            }
            do {
                d2 = d();
                if (d2 == 0) {
                    break;
                }
            } while (y(d2));
            x(((i2 >>> 3) << 3) | 4);
            return true;
        }
        I(C());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int z(int i2) throws zzdok {
        if (i2 >= 0) {
            int u = i2 + u();
            int i3 = this.m;
            if (u <= i3) {
                this.m = u;
                G();
                return i3;
            }
            throw zzdok.a();
        }
        throw zzdok.b();
    }
}
