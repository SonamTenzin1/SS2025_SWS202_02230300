package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zzqt implements zznw {
    private final zzrt a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16616b;

    /* renamed from: c, reason: collision with root package name */
    private final h30 f16617c;

    /* renamed from: d, reason: collision with root package name */
    private final zzqs f16618d;

    /* renamed from: e, reason: collision with root package name */
    private final zzst f16619e;

    /* renamed from: f, reason: collision with root package name */
    private final AtomicInteger f16620f;

    /* renamed from: g, reason: collision with root package name */
    private i30 f16621g;

    /* renamed from: h, reason: collision with root package name */
    private i30 f16622h;

    /* renamed from: i, reason: collision with root package name */
    private zzlh f16623i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16624j;

    /* renamed from: k, reason: collision with root package name */
    private zzlh f16625k;
    private long l;
    private int m;
    private zzqv n;

    public zzqt(zzrt zzrtVar) {
        this.a = zzrtVar;
        int a = zzrtVar.a();
        this.f16616b = a;
        this.f16617c = new h30();
        this.f16618d = new zzqs();
        this.f16619e = new zzst(32);
        this.f16620f = new AtomicInteger();
        this.m = a;
        i30 i30Var = new i30(0L, a);
        this.f16621g = i30Var;
        this.f16622h = i30Var;
    }

    private final void g(long j2, byte[] bArr, int i2) {
        j(j2);
        int i3 = 0;
        while (i3 < i2) {
            int i4 = (int) (j2 - this.f16621g.a);
            int min = Math.min(i2 - i3, this.f16616b - i4);
            zzrs zzrsVar = this.f16621g.f12745d;
            System.arraycopy(zzrsVar.a, zzrsVar.a(i4), bArr, i3, min);
            j2 += min;
            i3 += min;
            if (j2 == this.f16621g.f12743b) {
                this.a.i(zzrsVar);
                this.f16621g = this.f16621g.a();
            }
        }
    }

    private final int i(int i2) {
        if (this.m == this.f16616b) {
            this.m = 0;
            i30 i30Var = this.f16622h;
            if (i30Var.f12744c) {
                this.f16622h = i30Var.f12746e;
            }
            i30 i30Var2 = this.f16622h;
            zzrs h2 = this.a.h();
            i30 i30Var3 = new i30(this.f16622h.f12743b, this.f16616b);
            i30Var2.f12745d = h2;
            i30Var2.f12746e = i30Var3;
            i30Var2.f12744c = true;
        }
        return Math.min(i2, this.f16616b - this.m);
    }

    private final void j(long j2) {
        while (true) {
            i30 i30Var = this.f16621g;
            if (j2 < i30Var.f12743b) {
                return;
            }
            this.a.i(i30Var.f12745d);
            this.f16621g = this.f16621g.a();
        }
    }

    private final void m() {
        this.f16617c.g();
        i30 i30Var = this.f16621g;
        if (i30Var.f12744c) {
            i30 i30Var2 = this.f16622h;
            boolean z = i30Var2.f12744c;
            int i2 = (z ? 1 : 0) + (((int) (i30Var2.a - i30Var.a)) / this.f16616b);
            zzrs[] zzrsVarArr = new zzrs[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zzrsVarArr[i3] = i30Var.f12745d;
                i30Var = i30Var.a();
            }
            this.a.g(zzrsVarArr);
        }
        i30 i30Var3 = new i30(0L, this.f16616b);
        this.f16621g = i30Var3;
        this.f16622h = i30Var3;
        this.l = 0L;
        this.m = this.f16616b;
        this.a.f();
    }

    private final boolean r() {
        return this.f16620f.compareAndSet(0, 1);
    }

    private final void s() {
        if (this.f16620f.compareAndSet(1, 0)) {
            return;
        }
        m();
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void a(zzlh zzlhVar) {
        zzlh zzlhVar2 = zzlhVar == null ? null : zzlhVar;
        boolean e2 = this.f16617c.e(zzlhVar2);
        this.f16625k = zzlhVar;
        this.f16624j = false;
        zzqv zzqvVar = this.n;
        if (zzqvVar == null || !e2) {
            return;
        }
        zzqvVar.i(zzlhVar2);
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void b(zzst zzstVar, int i2) {
        if (!r()) {
            zzstVar.l(i2);
            return;
        }
        while (i2 > 0) {
            int i3 = i(i2);
            zzrs zzrsVar = this.f16622h.f12745d;
            zzstVar.n(zzrsVar.a, zzrsVar.a(this.m), i3);
            this.m += i3;
            this.l += i3;
            i2 -= i3;
        }
        s();
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void c(long j2, int i2, int i3, int i4, zznx zznxVar) {
        if (!r()) {
            this.f16617c.c(j2);
            return;
        }
        try {
            this.f16617c.b(j2, i2, this.l - i3, i3, zznxVar);
        } finally {
            s();
        }
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final int d(zzno zznoVar, int i2, boolean z) throws IOException, InterruptedException {
        if (!r()) {
            int e2 = zznoVar.e(i2);
            if (e2 != -1) {
                return e2;
            }
            throw new EOFException();
        }
        try {
            int i3 = i(i2);
            zzrs zzrsVar = this.f16622h.f12745d;
            int read = zznoVar.read(zzrsVar.a, zzrsVar.a(this.m), i3);
            if (read != -1) {
                this.m += read;
                this.l += read;
                return read;
            }
            throw new EOFException();
        } finally {
            s();
        }
    }

    public final void e() {
        if (this.f16620f.getAndSet(2) == 0) {
            m();
        }
    }

    public final int f(zzlj zzljVar, zznd zzndVar, boolean z, boolean z2, long j2) {
        int i2;
        int a = this.f16617c.a(zzljVar, zzndVar, z, z2, this.f16623i, this.f16618d);
        if (a == -5) {
            this.f16623i = zzljVar.a;
            return -5;
        }
        if (a != -4) {
            if (a == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!zzndVar.f()) {
            if (zzndVar.f16503d < j2) {
                zzndVar.c(Integer.MIN_VALUE);
            }
            if (zzndVar.j()) {
                zzqs zzqsVar = this.f16618d;
                long j3 = zzqsVar.f16613b;
                this.f16619e.j(1);
                g(j3, this.f16619e.a, 1);
                long j4 = j3 + 1;
                byte b2 = this.f16619e.a[0];
                boolean z3 = (b2 & 128) != 0;
                int i3 = b2 & Byte.MAX_VALUE;
                zzmz zzmzVar = zzndVar.f16501b;
                if (zzmzVar.a == null) {
                    zzmzVar.a = new byte[16];
                }
                g(j4, zzmzVar.a, i3);
                long j5 = j4 + i3;
                if (z3) {
                    this.f16619e.j(2);
                    g(j5, this.f16619e.a, 2);
                    j5 += 2;
                    i2 = this.f16619e.h();
                } else {
                    i2 = 1;
                }
                zzmz zzmzVar2 = zzndVar.f16501b;
                int[] iArr = zzmzVar2.f16483d;
                if (iArr == null || iArr.length < i2) {
                    iArr = new int[i2];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = zzmzVar2.f16484e;
                if (iArr3 == null || iArr3.length < i2) {
                    iArr3 = new int[i2];
                }
                int[] iArr4 = iArr3;
                if (z3) {
                    int i4 = i2 * 6;
                    this.f16619e.j(i4);
                    g(j5, this.f16619e.a, i4);
                    j5 += i4;
                    this.f16619e.k(0);
                    for (int i5 = 0; i5 < i2; i5++) {
                        iArr2[i5] = this.f16619e.h();
                        iArr4[i5] = this.f16619e.s();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = zzqsVar.a - ((int) (j5 - zzqsVar.f16613b));
                }
                zznx zznxVar = zzqsVar.f16615d;
                zzmz zzmzVar3 = zzndVar.f16501b;
                zzmzVar3.a(i2, iArr2, iArr4, zznxVar.f16527b, zzmzVar3.a, zznxVar.a);
                long j6 = zzqsVar.f16613b;
                int i6 = (int) (j5 - j6);
                zzqsVar.f16613b = j6 + i6;
                zzqsVar.a -= i6;
            }
            zzndVar.h(this.f16618d.a);
            zzqs zzqsVar2 = this.f16618d;
            long j7 = zzqsVar2.f16613b;
            ByteBuffer byteBuffer = zzndVar.f16502c;
            int i7 = zzqsVar2.a;
            j(j7);
            while (i7 > 0) {
                int i8 = (int) (j7 - this.f16621g.a);
                int min = Math.min(i7, this.f16616b - i8);
                zzrs zzrsVar = this.f16621g.f12745d;
                byteBuffer.put(zzrsVar.a, zzrsVar.a(i8), min);
                j7 += min;
                i7 -= min;
                if (j7 == this.f16621g.f12743b) {
                    this.a.i(zzrsVar);
                    this.f16621g = this.f16621g.a();
                }
            }
            j(this.f16618d.f16614c);
        }
        return -4;
    }

    public final void h(zzqv zzqvVar) {
        this.n = zzqvVar;
    }

    public final boolean k(long j2, boolean z) {
        long d2 = this.f16617c.d(j2, z);
        if (d2 == -1) {
            return false;
        }
        j(d2);
        return true;
    }

    public final long l() {
        return this.f16617c.f();
    }

    public final int n() {
        return this.f16617c.i();
    }

    public final boolean o() {
        return this.f16617c.j();
    }

    public final zzlh p() {
        return this.f16617c.k();
    }

    public final void q() {
        long l = this.f16617c.l();
        if (l != -1) {
            j(l);
        }
    }

    public final void t(boolean z) {
        int andSet = this.f16620f.getAndSet(z ? 0 : 2);
        m();
        this.f16617c.h();
        if (andSet == 2) {
            this.f16623i = null;
        }
    }
}
