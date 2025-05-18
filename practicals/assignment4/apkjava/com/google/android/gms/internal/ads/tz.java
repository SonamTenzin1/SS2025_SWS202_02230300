package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class tz {

    /* renamed from: g, reason: collision with root package name */
    private int f13368g;

    /* renamed from: h, reason: collision with root package name */
    private int f13369h;

    /* renamed from: i, reason: collision with root package name */
    private int f13370i;

    /* renamed from: j, reason: collision with root package name */
    private int f13371j;
    private int a = 1000;

    /* renamed from: b, reason: collision with root package name */
    private long[] f13363b = new long[1000];

    /* renamed from: e, reason: collision with root package name */
    private long[] f13366e = new long[1000];

    /* renamed from: d, reason: collision with root package name */
    private int[] f13365d = new int[1000];

    /* renamed from: c, reason: collision with root package name */
    private int[] f13364c = new int[1000];

    /* renamed from: f, reason: collision with root package name */
    private byte[][] f13367f = new byte[1000];

    public final void a() {
        this.f13369h = 0;
        this.f13370i = 0;
        this.f13371j = 0;
        this.f13368g = 0;
    }

    public final synchronized void b(long j2, int i2, long j3, int i3, byte[] bArr) {
        long[] jArr = this.f13366e;
        int i4 = this.f13371j;
        jArr[i4] = j2;
        long[] jArr2 = this.f13363b;
        jArr2[i4] = j3;
        this.f13364c[i4] = i3;
        this.f13365d[i4] = i2;
        this.f13367f[i4] = bArr;
        int i5 = this.f13368g + 1;
        this.f13368g = i5;
        int i6 = this.a;
        if (i5 == i6) {
            int i7 = i6 + 1000;
            long[] jArr3 = new long[i7];
            long[] jArr4 = new long[i7];
            int[] iArr = new int[i7];
            int[] iArr2 = new int[i7];
            byte[][] bArr2 = new byte[i7];
            int i8 = this.f13370i;
            int i9 = i6 - i8;
            System.arraycopy(jArr2, i8, jArr3, 0, i9);
            System.arraycopy(this.f13366e, this.f13370i, jArr4, 0, i9);
            System.arraycopy(this.f13365d, this.f13370i, iArr, 0, i9);
            System.arraycopy(this.f13364c, this.f13370i, iArr2, 0, i9);
            System.arraycopy(this.f13367f, this.f13370i, bArr2, 0, i9);
            int i10 = this.f13370i;
            System.arraycopy(this.f13363b, 0, jArr3, i9, i10);
            System.arraycopy(this.f13366e, 0, jArr4, i9, i10);
            System.arraycopy(this.f13365d, 0, iArr, i9, i10);
            System.arraycopy(this.f13364c, 0, iArr2, i9, i10);
            System.arraycopy(this.f13367f, 0, bArr2, i9, i10);
            this.f13363b = jArr3;
            this.f13366e = jArr4;
            this.f13365d = iArr;
            this.f13364c = iArr2;
            this.f13367f = bArr2;
            this.f13370i = 0;
            int i11 = this.a;
            this.f13371j = i11;
            this.f13368g = i11;
            this.a = i7;
            return;
        }
        int i12 = i4 + 1;
        this.f13371j = i12;
        if (i12 == i6) {
            this.f13371j = 0;
        }
    }

    public final synchronized boolean c(zzhm zzhmVar, uz uzVar) {
        if (this.f13368g == 0) {
            return false;
        }
        long[] jArr = this.f13366e;
        int i2 = this.f13370i;
        zzhmVar.f16282e = jArr[i2];
        zzhmVar.f16280c = this.f13364c[i2];
        zzhmVar.f16281d = this.f13365d[i2];
        uzVar.a = this.f13363b[i2];
        uzVar.f13412b = this.f13367f[i2];
        return true;
    }

    public final synchronized long d(long j2) {
        if (this.f13368g != 0) {
            long[] jArr = this.f13366e;
            int i2 = this.f13370i;
            if (j2 >= jArr[i2]) {
                int i3 = this.f13371j;
                if (i3 == 0) {
                    i3 = this.a;
                }
                if (j2 > jArr[i3 - 1]) {
                    return -1L;
                }
                int i4 = 0;
                int i5 = -1;
                while (i2 != this.f13371j && this.f13366e[i2] <= j2) {
                    if ((this.f13365d[i2] & 1) != 0) {
                        i5 = i4;
                    }
                    i2 = (i2 + 1) % this.a;
                    i4++;
                }
                if (i5 == -1) {
                    return -1L;
                }
                this.f13368g -= i5;
                int i6 = (this.f13370i + i5) % this.a;
                this.f13370i = i6;
                this.f13369h += i5;
                return this.f13363b[i6];
            }
        }
        return -1L;
    }

    public final synchronized long e() {
        int i2 = this.f13368g - 1;
        this.f13368g = i2;
        int i3 = this.f13370i;
        int i4 = i3 + 1;
        this.f13370i = i4;
        this.f13369h++;
        if (i4 == this.a) {
            this.f13370i = 0;
        }
        if (i2 > 0) {
            return this.f13363b[this.f13370i];
        }
        return this.f13364c[i3] + this.f13363b[i3];
    }
}
