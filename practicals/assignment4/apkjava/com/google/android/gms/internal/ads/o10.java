package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o10 implements r10 {
    private final byte[] a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private final Stack<q10> f13075b = new Stack<>();

    /* renamed from: c, reason: collision with root package name */
    private final x10 f13076c = new x10();

    /* renamed from: d, reason: collision with root package name */
    private s10 f13077d;

    /* renamed from: e, reason: collision with root package name */
    private int f13078e;

    /* renamed from: f, reason: collision with root package name */
    private int f13079f;

    /* renamed from: g, reason: collision with root package name */
    private long f13080g;

    private final long d(zzno zznoVar, int i2) throws IOException, InterruptedException {
        zznoVar.readFully(this.a, 0, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (this.a[i3] & 255);
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.r10
    public final void a() {
        this.f13078e = 0;
        this.f13075b.clear();
        this.f13076c.a();
    }

    @Override // com.google.android.gms.internal.ads.r10
    public final void b(s10 s10Var) {
        this.f13077d = s10Var;
    }

    @Override // com.google.android.gms.internal.ads.r10
    public final boolean c(zzno zznoVar) throws IOException, InterruptedException {
        String str;
        double longBitsToDouble;
        int d2;
        int c2;
        long j2;
        int i2;
        zzsk.e(this.f13077d != null);
        while (true) {
            if (!this.f13075b.isEmpty()) {
                long position = zznoVar.getPosition();
                j2 = this.f13075b.peek().f13213b;
                if (position >= j2) {
                    s10 s10Var = this.f13077d;
                    i2 = this.f13075b.pop().a;
                    s10Var.k(i2);
                    return true;
                }
            }
            if (this.f13078e == 0) {
                long b2 = this.f13076c.b(zznoVar, true, false, 4);
                if (b2 == -2) {
                    zznoVar.c();
                    while (true) {
                        zznoVar.d(this.a, 0, 4);
                        d2 = x10.d(this.a[0]);
                        if (d2 != -1 && d2 <= 4) {
                            c2 = (int) x10.c(this.a, d2, false);
                            if (this.f13077d.a(c2)) {
                                break;
                            }
                        }
                        zznoVar.a(1);
                    }
                    zznoVar.a(d2);
                    b2 = c2;
                }
                if (b2 == -1) {
                    return false;
                }
                this.f13079f = (int) b2;
                this.f13078e = 1;
            }
            if (this.f13078e == 1) {
                this.f13080g = this.f13076c.b(zznoVar, false, true, 8);
                this.f13078e = 2;
            }
            int j3 = this.f13077d.j(this.f13079f);
            if (j3 != 0) {
                if (j3 == 1) {
                    long position2 = zznoVar.getPosition();
                    this.f13075b.add(new q10(this.f13079f, this.f13080g + position2));
                    this.f13077d.i(this.f13079f, position2, this.f13080g);
                    this.f13078e = 0;
                    return true;
                }
                if (j3 == 2) {
                    long j4 = this.f13080g;
                    if (j4 <= 8) {
                        this.f13077d.c(this.f13079f, d(zznoVar, (int) j4));
                        this.f13078e = 0;
                        return true;
                    }
                    long j5 = this.f13080g;
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Invalid integer size: ");
                    sb.append(j5);
                    throw new zzlm(sb.toString());
                }
                if (j3 == 3) {
                    long j6 = this.f13080g;
                    if (j6 <= 2147483647L) {
                        s10 s10Var2 = this.f13077d;
                        int i3 = this.f13079f;
                        int i4 = (int) j6;
                        if (i4 == 0) {
                            str = HttpUrl.FRAGMENT_ENCODE_SET;
                        } else {
                            byte[] bArr = new byte[i4];
                            zznoVar.readFully(bArr, 0, i4);
                            str = new String(bArr);
                        }
                        s10Var2.g(i3, str);
                        this.f13078e = 0;
                        return true;
                    }
                    long j7 = this.f13080g;
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("String element size: ");
                    sb2.append(j7);
                    throw new zzlm(sb2.toString());
                }
                if (j3 == 4) {
                    this.f13077d.b(this.f13079f, (int) this.f13080g, zznoVar);
                    this.f13078e = 0;
                    return true;
                }
                if (j3 == 5) {
                    long j8 = this.f13080g;
                    if (j8 != 4 && j8 != 8) {
                        long j9 = this.f13080g;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j9);
                        throw new zzlm(sb3.toString());
                    }
                    s10 s10Var3 = this.f13077d;
                    int i5 = this.f13079f;
                    int i6 = (int) j8;
                    long d3 = d(zznoVar, i6);
                    if (i6 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) d3);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(d3);
                    }
                    s10Var3.h(i5, longBitsToDouble);
                    this.f13078e = 0;
                    return true;
                }
                StringBuilder sb4 = new StringBuilder(32);
                sb4.append("Invalid element type ");
                sb4.append(j3);
                throw new zzlm(sb4.toString());
            }
            zznoVar.a((int) this.f13080g);
            this.f13078e = 0;
        }
    }
}
