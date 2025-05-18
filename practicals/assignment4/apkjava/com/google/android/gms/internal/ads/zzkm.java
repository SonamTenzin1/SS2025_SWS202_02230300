package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzkm {
    public byte[] a;

    /* renamed from: b, reason: collision with root package name */
    private int f16395b;

    /* renamed from: c, reason: collision with root package name */
    private int f16396c;

    public zzkm() {
    }

    public final int a() {
        return this.f16395b;
    }

    public final int b() {
        return this.f16396c;
    }

    public final int c() {
        byte[] bArr = this.a;
        int i2 = this.f16395b;
        int i3 = i2 + 1;
        this.f16395b = i3;
        int i4 = (bArr[i2] & 255) << 24;
        int i5 = i3 + 1;
        this.f16395b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        int i7 = i5 + 1;
        this.f16395b = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        this.f16395b = i7 + 1;
        return (bArr[i7] & 255) | i8;
    }

    public final long d() {
        byte[] bArr = this.a;
        int i2 = this.f16395b + 1;
        this.f16395b = i2;
        long j2 = (bArr[r1] & 255) << 56;
        int i3 = i2 + 1;
        this.f16395b = i3;
        long j3 = j2 | ((bArr[i2] & 255) << 48);
        int i4 = i3 + 1;
        this.f16395b = i4;
        long j4 = j3 | ((bArr[i3] & 255) << 40);
        int i5 = i4 + 1;
        this.f16395b = i5;
        long j5 = j4 | ((bArr[i4] & 255) << 32);
        int i6 = i5 + 1;
        this.f16395b = i6;
        long j6 = j5 | ((bArr[i5] & 255) << 24);
        int i7 = i6 + 1;
        this.f16395b = i7;
        long j7 = j6 | ((bArr[i6] & 255) << 16);
        int i8 = i7 + 1;
        this.f16395b = i8;
        long j8 = j7 | ((bArr[i7] & 255) << 8);
        this.f16395b = i8 + 1;
        return (bArr[i8] & 255) | j8;
    }

    public final int e() {
        byte[] bArr = this.a;
        int i2 = this.f16395b;
        this.f16395b = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int f() {
        byte[] bArr = this.a;
        int i2 = this.f16395b;
        int i3 = i2 + 1;
        this.f16395b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.f16395b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public final void g(int i2) {
        zzkh.a(i2 >= 0 && i2 <= this.f16396c);
        this.f16395b = i2;
    }

    public final void h(int i2) {
        g(this.f16395b + i2);
    }

    public final void i(byte[] bArr, int i2) {
        this.a = bArr;
        this.f16396c = i2;
        this.f16395b = 0;
    }

    public final void j(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.a, this.f16395b, bArr, i2, i3);
        this.f16395b += i3;
    }

    public final long k() {
        byte[] bArr = this.a;
        int i2 = this.f16395b + 1;
        this.f16395b = i2;
        long j2 = (bArr[r1] & 255) << 24;
        int i3 = i2 + 1;
        this.f16395b = i3;
        long j3 = j2 | ((bArr[i2] & 255) << 16);
        int i4 = i3 + 1;
        this.f16395b = i4;
        long j4 = j3 | ((bArr[i3] & 255) << 8);
        this.f16395b = i4 + 1;
        return (bArr[i4] & 255) | j4;
    }

    public final int l() {
        byte[] bArr = this.a;
        int i2 = this.f16395b;
        int i3 = i2 + 1;
        this.f16395b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        int i5 = i3 + 1;
        this.f16395b = i5;
        int i6 = (bArr[i3] & 255) | i4;
        this.f16395b = i5 + 2;
        return i6;
    }

    public final int m() {
        int c2 = c();
        if (c2 >= 0) {
            return c2;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(c2);
        throw new IllegalStateException(sb.toString());
    }

    public final long n() {
        long d2 = d();
        if (d2 >= 0) {
            return d2;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(d2);
        throw new IllegalStateException(sb.toString());
    }

    public zzkm(int i2) {
        byte[] bArr = new byte[i2];
        this.a = bArr;
        this.f16396c = bArr.length;
    }

    public zzkm(byte[] bArr) {
        this.a = bArr;
        this.f16396c = bArr.length;
    }
}
