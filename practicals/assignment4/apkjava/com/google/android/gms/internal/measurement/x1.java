package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class x1 extends zzeg {

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f17284f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f17285g;

    /* renamed from: h, reason: collision with root package name */
    private int f17286h;

    /* renamed from: i, reason: collision with root package name */
    private int f17287i;

    /* renamed from: j, reason: collision with root package name */
    private int f17288j;

    /* renamed from: k, reason: collision with root package name */
    private int f17289k;
    private int l;
    private int m;

    private x1(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.m = Integer.MAX_VALUE;
        this.f17284f = bArr;
        this.f17286h = i3 + i2;
        this.f17288j = i2;
        this.f17289k = i2;
        this.f17285g = z;
    }

    private final byte C() throws IOException {
        int i2 = this.f17288j;
        if (i2 != this.f17286h) {
            byte[] bArr = this.f17284f;
            this.f17288j = i2 + 1;
            return bArr[i2];
        }
        throw zzfo.a();
    }

    private final void D(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f17286h;
            int i4 = this.f17288j;
            if (i2 <= i3 - i4) {
                this.f17288j = i4 + i2;
                return;
            }
        }
        if (i2 < 0) {
            throw zzfo.b();
        }
        throw zzfo.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int E() throws IOException {
        int i2;
        int i3 = this.f17288j;
        int i4 = this.f17286h;
        if (i4 != i3) {
            byte[] bArr = this.f17284f;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f17288j = i5;
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
                this.f17288j = i6;
                return i2;
            }
        }
        return (int) z();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long F() throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        int i2;
        int i3 = this.f17288j;
        int i4 = this.f17286h;
        if (i4 != i3) {
            byte[] bArr = this.f17284f;
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f17288j = i5;
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
                    this.f17288j = i6;
                    return j5;
                }
                i2 = i7 ^ (-128);
                j5 = i2;
                this.f17288j = i6;
                return j5;
            }
        }
        return z();
    }

    private final int G() throws IOException {
        int i2 = this.f17288j;
        if (this.f17286h - i2 >= 4) {
            byte[] bArr = this.f17284f;
            this.f17288j = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }
        throw zzfo.a();
    }

    private final long H() throws IOException {
        int i2 = this.f17288j;
        if (this.f17286h - i2 >= 8) {
            byte[] bArr = this.f17284f;
            this.f17288j = i2 + 8;
            return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
        }
        throw zzfo.a();
    }

    private final void I() {
        int i2 = this.f17286h + this.f17287i;
        this.f17286h = i2;
        int i3 = i2 - this.f17289k;
        int i4 = this.m;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f17287i = i5;
            this.f17286h = i2 - i5;
            return;
        }
        this.f17287i = 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean A() throws IOException {
        return this.f17288j == this.f17286h;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int B() {
        return this.f17288j - this.f17289k;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int a() throws IOException {
        if (A()) {
            this.l = 0;
            return 0;
        }
        int E = E();
        this.l = E;
        if ((E >>> 3) != 0) {
            return E;
        }
        throw zzfo.d();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final void d(int i2) throws zzfo {
        if (this.l != i2) {
            throw zzfo.e();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final double e() throws IOException {
        return Double.longBitsToDouble(H());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean f(int i2) throws IOException {
        int a;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.f17286h - this.f17288j >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.f17284f;
                    int i5 = this.f17288j;
                    this.f17288j = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw zzfo.c();
            }
            while (i4 < 10) {
                if (C() < 0) {
                    i4++;
                }
            }
            throw zzfo.c();
            return true;
        }
        if (i3 == 1) {
            D(8);
            return true;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    return false;
                }
                if (i3 == 5) {
                    D(4);
                    return true;
                }
                throw zzfo.f();
            }
            do {
                a = a();
                if (a == 0) {
                    break;
                }
            } while (f(a));
            d(((i2 >>> 3) << 3) | 4);
            return true;
        }
        D(E());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final float g() throws IOException {
        return Float.intBitsToFloat(G());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int h(int i2) throws zzfo {
        if (i2 >= 0) {
            int B = i2 + B();
            int i3 = this.m;
            if (B <= i3) {
                this.m = B;
                I();
                return i3;
            }
            throw zzfo.a();
        }
        throw zzfo.b();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long i() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final void j(int i2) {
        this.m = i2;
        I();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long l() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int m() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long n() throws IOException {
        return H();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int o() throws IOException {
        return G();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean p() throws IOException {
        return F() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final String q() throws IOException {
        int E = E();
        if (E > 0 && E <= this.f17286h - this.f17288j) {
            String str = new String(this.f17284f, this.f17288j, E, zzff.a);
            this.f17288j += E;
            return str;
        }
        if (E == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (E < 0) {
            throw zzfo.b();
        }
        throw zzfo.a();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final String r() throws IOException {
        int E = E();
        if (E > 0) {
            int i2 = this.f17286h;
            int i3 = this.f17288j;
            if (E <= i2 - i3) {
                String k2 = n4.k(this.f17284f, i3, E);
                this.f17288j += E;
                return k2;
            }
        }
        if (E == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (E <= 0) {
            throw zzfo.b();
        }
        throw zzfo.a();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final zzdu s() throws IOException {
        byte[] bArr;
        int E = E();
        if (E > 0) {
            int i2 = this.f17286h;
            int i3 = this.f17288j;
            if (E <= i2 - i3) {
                zzdu q = zzdu.q(this.f17284f, i3, E);
                this.f17288j += E;
                return q;
            }
        }
        if (E == 0) {
            return zzdu.f17368f;
        }
        if (E > 0) {
            int i4 = this.f17286h;
            int i5 = this.f17288j;
            if (E <= i4 - i5) {
                int i6 = E + i5;
                this.f17288j = i6;
                bArr = Arrays.copyOfRange(this.f17284f, i5, i6);
                return zzdu.o(bArr);
            }
        }
        if (E > 0) {
            throw zzfo.a();
        }
        if (E == 0) {
            bArr = zzff.f17408c;
            return zzdu.o(bArr);
        }
        throw zzfo.b();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int t() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int u() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int v() throws IOException {
        return G();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long w() throws IOException {
        return H();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int x() throws IOException {
        return zzeg.k(E());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long y() throws IOException {
        return zzeg.b(F());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long z() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & Byte.MAX_VALUE) << i2;
            if ((C() & 128) == 0) {
                return j2;
            }
        }
        throw zzfo.c();
    }
}
