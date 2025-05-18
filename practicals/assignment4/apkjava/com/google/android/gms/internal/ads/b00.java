package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Stack;

/* loaded from: classes2.dex */
final class b00 implements e00 {
    private final byte[] a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private final Stack<d00> f12282b = new Stack<>();

    /* renamed from: c, reason: collision with root package name */
    private final g00 f12283c = new g00();

    /* renamed from: d, reason: collision with root package name */
    private f00 f12284d;

    /* renamed from: e, reason: collision with root package name */
    private int f12285e;

    /* renamed from: f, reason: collision with root package name */
    private int f12286f;

    /* renamed from: g, reason: collision with root package name */
    private long f12287g;

    private final long d(zzie zzieVar, int i2) throws IOException, InterruptedException {
        zzieVar.readFully(this.a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (this.a[i3] & 255);
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.e00
    public final void a() {
        this.f12285e = 0;
        this.f12282b.clear();
        this.f12283c.a();
    }

    @Override // com.google.android.gms.internal.ads.e00
    public final void b(f00 f00Var) {
        this.f12284d = f00Var;
    }

    @Override // com.google.android.gms.internal.ads.e00
    public final boolean c(zzie zzieVar) throws IOException, InterruptedException {
        double longBitsToDouble;
        long j2;
        int i2;
        zzkh.d(this.f12284d != null);
        while (true) {
            if (!this.f12282b.isEmpty()) {
                long position = zzieVar.getPosition();
                j2 = this.f12282b.peek().f12443b;
                if (position >= j2) {
                    f00 f00Var = this.f12284d;
                    i2 = this.f12282b.pop().a;
                    f00Var.k(i2);
                    return true;
                }
            }
            if (this.f12285e == 0) {
                long b2 = this.f12283c.b(zzieVar, true, false);
                if (b2 == -1) {
                    return false;
                }
                this.f12286f = (int) b2;
                this.f12285e = 1;
            }
            if (this.f12285e == 1) {
                this.f12287g = this.f12283c.b(zzieVar, false, true);
                this.f12285e = 2;
            }
            int j3 = this.f12284d.j(this.f12286f);
            if (j3 != 0) {
                if (j3 == 1) {
                    long position2 = zzieVar.getPosition();
                    this.f12282b.add(new d00(this.f12286f, this.f12287g + position2));
                    this.f12284d.i(this.f12286f, position2, this.f12287g);
                    this.f12285e = 0;
                    return true;
                }
                if (j3 == 2) {
                    long j4 = this.f12287g;
                    if (j4 <= 8) {
                        this.f12284d.c(this.f12286f, d(zzieVar, (int) j4));
                        this.f12285e = 0;
                        return true;
                    }
                    long j5 = this.f12287g;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j5);
                    throw new IllegalStateException(sb.toString());
                }
                if (j3 == 3) {
                    long j6 = this.f12287g;
                    if (j6 <= 2147483647L) {
                        f00 f00Var2 = this.f12284d;
                        int i3 = this.f12286f;
                        int i4 = (int) j6;
                        byte[] bArr = new byte[i4];
                        zzieVar.readFully(bArr, 0, i4);
                        f00Var2.g(i3, new String(bArr, Charset.forName("UTF-8")));
                        this.f12285e = 0;
                        return true;
                    }
                    long j7 = this.f12287g;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j7);
                    throw new IllegalStateException(sb2.toString());
                }
                if (j3 == 4) {
                    this.f12284d.l(this.f12286f, (int) this.f12287g, zzieVar);
                    this.f12285e = 0;
                    return true;
                }
                if (j3 == 5) {
                    long j8 = this.f12287g;
                    if (j8 != 4 && j8 != 8) {
                        long j9 = this.f12287g;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j9);
                        throw new IllegalStateException(sb3.toString());
                    }
                    f00 f00Var3 = this.f12284d;
                    int i5 = this.f12286f;
                    int i6 = (int) j8;
                    long d2 = d(zzieVar, i6);
                    if (i6 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) d2);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(d2);
                    }
                    f00Var3.h(i5, longBitsToDouble);
                    this.f12285e = 0;
                    return true;
                }
                StringBuilder sb4 = new StringBuilder(32);
                sb4.append("Invalid element type ");
                sb4.append(j3);
                throw new IllegalStateException(sb4.toString());
            }
            zzieVar.a((int) this.f12287g);
            this.f12285e = 0;
        }
    }
}
