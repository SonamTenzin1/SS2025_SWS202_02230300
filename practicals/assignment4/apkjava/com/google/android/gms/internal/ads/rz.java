package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes2.dex */
final class rz {
    private final zzjl a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13290b;

    /* renamed from: c, reason: collision with root package name */
    private final tz f13291c;

    /* renamed from: d, reason: collision with root package name */
    private final LinkedBlockingDeque<zzjk> f13292d;

    /* renamed from: e, reason: collision with root package name */
    private final uz f13293e;

    /* renamed from: f, reason: collision with root package name */
    private final zzkm f13294f;

    /* renamed from: g, reason: collision with root package name */
    private long f13295g;

    /* renamed from: h, reason: collision with root package name */
    private long f13296h;

    /* renamed from: i, reason: collision with root package name */
    private zzjk f13297i;

    /* renamed from: j, reason: collision with root package name */
    private int f13298j;

    public rz(zzjl zzjlVar) {
        this.a = zzjlVar;
        int a = zzjlVar.a();
        this.f13290b = a;
        this.f13291c = new tz();
        this.f13292d = new LinkedBlockingDeque<>();
        this.f13293e = new uz();
        this.f13294f = new zzkm(32);
        this.f13298j = a;
    }

    private final void c(long j2, byte[] bArr, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            i(j2);
            int i4 = (int) (j2 - this.f13295g);
            int min = Math.min(i2 - i3, this.f13290b - i4);
            System.arraycopy(this.f13292d.peek().a, i4 + 0, bArr, i3, min);
            j2 += min;
            i3 += min;
        }
    }

    private final void i(long j2) {
        int i2 = ((int) (j2 - this.f13295g)) / this.f13290b;
        for (int i3 = 0; i3 < i2; i3++) {
            this.a.c(this.f13292d.remove());
            this.f13295g += this.f13290b;
        }
    }

    private final void l() {
        if (this.f13298j == this.f13290b) {
            this.f13298j = 0;
            zzjk b2 = this.a.b();
            this.f13297i = b2;
            this.f13292d.add(b2);
        }
    }

    public final void a() {
        this.f13291c.a();
        while (!this.f13292d.isEmpty()) {
            this.a.c(this.f13292d.remove());
        }
        this.f13295g = 0L;
        this.f13296h = 0L;
        this.f13297i = null;
        this.f13298j = this.f13290b;
    }

    public final void b(long j2, int i2, long j3, int i3, byte[] bArr) {
        this.f13291c.b(j2, i2, j3, i3, bArr);
    }

    public final int d(zzie zzieVar, int i2) throws IOException, InterruptedException {
        l();
        int min = Math.min(i2, this.f13290b - this.f13298j);
        zzieVar.readFully(this.f13297i.a, this.f13298j + 0, min);
        this.f13298j += min;
        this.f13296h += min;
        return min;
    }

    public final void e(zzkm zzkmVar, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            l();
            int min = Math.min(i3, this.f13290b - this.f13298j);
            zzkmVar.j(this.f13297i.a, this.f13298j + 0, min);
            this.f13298j += min;
            i3 -= min;
        }
        this.f13296h += i2;
    }

    public final boolean f(zzhm zzhmVar) {
        return this.f13291c.c(zzhmVar, this.f13293e);
    }

    public final boolean g(zzhm zzhmVar) {
        int i2;
        if (!this.f13291c.c(zzhmVar, this.f13293e)) {
            return false;
        }
        if (zzhmVar.a()) {
            uz uzVar = this.f13293e;
            long j2 = uzVar.a;
            c(j2, this.f13294f.a, 1);
            long j3 = j2 + 1;
            byte b2 = this.f13294f.a[0];
            boolean z = (b2 & 128) != 0;
            int i3 = b2 & Byte.MAX_VALUE;
            zzgb zzgbVar = zzhmVar.a;
            if (zzgbVar.a == null) {
                zzgbVar.a = new byte[16];
            }
            c(j3, zzgbVar.a, i3);
            long j4 = j3 + i3;
            if (z) {
                c(j4, this.f13294f.a, 2);
                j4 += 2;
                this.f13294f.g(0);
                i2 = this.f13294f.f();
            } else {
                i2 = 1;
            }
            zzgb zzgbVar2 = zzhmVar.a;
            int[] iArr = zzgbVar2.f16236d;
            if (iArr == null || iArr.length < i2) {
                iArr = new int[i2];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzgbVar2.f16237e;
            if (iArr3 == null || iArr3.length < i2) {
                iArr3 = new int[i2];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i2 * 6;
                zzkm zzkmVar = this.f13294f;
                if (zzkmVar.b() < i4) {
                    zzkmVar.i(new byte[i4], i4);
                }
                c(j4, this.f13294f.a, i4);
                j4 += i4;
                this.f13294f.g(0);
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr2[i5] = this.f13294f.f();
                    iArr4[i5] = this.f13294f.m();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzhmVar.f16280c - ((int) (j4 - uzVar.a));
            }
            zzgb zzgbVar3 = zzhmVar.a;
            zzgbVar3.a(i2, iArr2, iArr4, uzVar.f13412b, zzgbVar3.a, 1);
            long j5 = uzVar.a;
            int i6 = (int) (j4 - j5);
            uzVar.a = j5 + i6;
            zzhmVar.f16280c -= i6;
        }
        ByteBuffer byteBuffer = zzhmVar.f16279b;
        if (byteBuffer != null) {
            byteBuffer.capacity();
            int i7 = zzhmVar.f16280c;
        }
        ByteBuffer byteBuffer2 = zzhmVar.f16279b;
        if (byteBuffer2 != null) {
            long j6 = this.f13293e.a;
            int i8 = zzhmVar.f16280c;
            while (i8 > 0) {
                i(j6);
                int i9 = (int) (j6 - this.f13295g);
                int min = Math.min(i8, this.f13290b - i9);
                byteBuffer2.put(this.f13292d.peek().a, i9 + 0, min);
                j6 += min;
                i8 -= min;
            }
        }
        i(this.f13291c.e());
        return true;
    }

    public final boolean h(long j2) {
        long d2 = this.f13291c.d(j2);
        if (d2 == -1) {
            return false;
        }
        i(d2);
        return true;
    }

    public final void j() {
        i(this.f13291c.e());
    }

    public final long k() {
        return this.f13296h;
    }
}
