package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class zzow implements zznn, zznu {
    private static final zznq a = new k20();

    /* renamed from: b, reason: collision with root package name */
    private static final int f16542b = zzsy.i("qt  ");

    /* renamed from: g, reason: collision with root package name */
    private int f16547g;

    /* renamed from: h, reason: collision with root package name */
    private int f16548h;

    /* renamed from: i, reason: collision with root package name */
    private long f16549i;

    /* renamed from: j, reason: collision with root package name */
    private int f16550j;

    /* renamed from: k, reason: collision with root package name */
    private zzst f16551k;
    private int l;
    private int m;
    private zznp n;
    private l20[] o;
    private long p;
    private boolean q;

    /* renamed from: e, reason: collision with root package name */
    private final zzst f16545e = new zzst(16);

    /* renamed from: f, reason: collision with root package name */
    private final Stack<z10> f16546f = new Stack<>();

    /* renamed from: c, reason: collision with root package name */
    private final zzst f16543c = new zzst(zzsq.a);

    /* renamed from: d, reason: collision with root package name */
    private final zzst f16544d = new zzst(4);

    private final void i(long j2) throws zzlm {
        zzpa b2;
        while (!this.f16546f.isEmpty() && this.f16546f.peek().Q0 == j2) {
            z10 pop = this.f16546f.pop();
            if (pop.P0 == y10.B) {
                long j3 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                zzpo zzpoVar = null;
                zznr zznrVar = new zznr();
                a20 d2 = pop.d(y10.A0);
                if (d2 != null && (zzpoVar = b20.d(d2, this.q)) != null) {
                    zznrVar.a(zzpoVar);
                }
                for (int i2 = 0; i2 < pop.S0.size(); i2++) {
                    z10 z10Var = pop.S0.get(i2);
                    if (z10Var.P0 == y10.D && (b2 = b20.b(z10Var, pop.d(y10.C), -9223372036854775807L, null, this.q)) != null) {
                        n20 c2 = b20.c(b2, z10Var.e(y10.E).e(y10.F).e(y10.G), zznrVar);
                        if (c2.a != 0) {
                            l20 l20Var = new l20(b2, c2, this.n.y(i2, b2.f16557b));
                            zzlh j4 = b2.f16561f.j(c2.f13015d + 30);
                            if (b2.f16557b == 1) {
                                if (zznrVar.c()) {
                                    j4 = j4.k(zznrVar.f16525c, zznrVar.f16526d);
                                }
                                if (zzpoVar != null) {
                                    j4 = j4.a(zzpoVar);
                                }
                            }
                            l20Var.f12907c.a(j4);
                            j3 = Math.max(j3, b2.f16560e);
                            arrayList.add(l20Var);
                        }
                    }
                }
                this.p = j3;
                this.o = (l20[]) arrayList.toArray(new l20[arrayList.size()]);
                this.n.d();
                this.n.z(this);
                this.f16546f.clear();
                this.f16547g = 2;
            } else if (!this.f16546f.isEmpty()) {
                this.f16546f.peek().S0.add(pop);
            }
        }
        if (this.f16547g != 2) {
            j();
        }
    }

    private final void j() {
        this.f16547g = 0;
        this.f16550j = 0;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long a(long j2) {
        long j3 = Long.MAX_VALUE;
        for (l20 l20Var : this.o) {
            n20 n20Var = l20Var.f12906b;
            int a2 = n20Var.a(j2);
            if (a2 == -1) {
                a2 = n20Var.b(j2);
            }
            long j4 = n20Var.f13013b[a2];
            if (j4 < j3) {
                j3 = j4;
            }
        }
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x018a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zznn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int d(zzno zznoVar, zznt zzntVar) throws IOException, InterruptedException {
        l20[] l20VarArr;
        int i2;
        boolean z;
        boolean z2;
        while (true) {
            int i3 = this.f16547g;
            boolean z3 = true;
            boolean z4 = false;
            if (i3 == 0) {
                if (this.f16550j == 0) {
                    if (zznoVar.b(this.f16545e.a, 0, 8, true)) {
                        this.f16550j = 8;
                        this.f16545e.k(0);
                        this.f16549i = this.f16545e.q();
                        this.f16548h = this.f16545e.d();
                    } else {
                        z3 = false;
                        if (z3) {
                            return -1;
                        }
                    }
                }
                if (this.f16549i == 1) {
                    zznoVar.readFully(this.f16545e.a, 8, 8);
                    this.f16550j += 8;
                    this.f16549i = this.f16545e.t();
                }
                int i4 = this.f16548h;
                if (i4 == y10.B || i4 == y10.D || i4 == y10.E || i4 == y10.F || i4 == y10.G || i4 == y10.P) {
                    long position = (zznoVar.getPosition() + this.f16549i) - this.f16550j;
                    this.f16546f.add(new z10(this.f16548h, position));
                    if (this.f16549i == this.f16550j) {
                        i(position);
                    } else {
                        j();
                    }
                } else {
                    if (i4 == y10.R || i4 == y10.C || i4 == y10.S || i4 == y10.T || i4 == y10.m0 || i4 == y10.n0 || i4 == y10.o0 || i4 == y10.Q || i4 == y10.p0 || i4 == y10.q0 || i4 == y10.r0 || i4 == y10.s0 || i4 == y10.t0 || i4 == y10.O || i4 == y10.a || i4 == y10.A0) {
                        zzsk.e(this.f16550j == 8);
                        zzsk.e(this.f16549i <= 2147483647L);
                        zzst zzstVar = new zzst((int) this.f16549i);
                        this.f16551k = zzstVar;
                        System.arraycopy(this.f16545e.a, 0, zzstVar.a, 0, 8);
                        this.f16547g = 1;
                    } else {
                        this.f16551k = null;
                        this.f16547g = 1;
                    }
                }
                if (z3) {
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException();
                    }
                    long j2 = Long.MAX_VALUE;
                    int i5 = 0;
                    int i6 = -1;
                    while (true) {
                        l20VarArr = this.o;
                        if (i5 >= l20VarArr.length) {
                            break;
                        }
                        l20 l20Var = l20VarArr[i5];
                        int i7 = l20Var.f12908d;
                        n20 n20Var = l20Var.f12906b;
                        if (i7 != n20Var.a) {
                            long j3 = n20Var.f13013b[i7];
                            if (j3 < j2) {
                                i6 = i5;
                                j2 = j3;
                            }
                        }
                        i5++;
                    }
                    if (i6 == -1) {
                        return -1;
                    }
                    l20 l20Var2 = l20VarArr[i6];
                    zznw zznwVar = l20Var2.f12907c;
                    int i8 = l20Var2.f12908d;
                    n20 n20Var2 = l20Var2.f12906b;
                    long j4 = n20Var2.f13013b[i8];
                    int i9 = n20Var2.f13014c[i8];
                    if (l20Var2.a.f16562g == 1) {
                        j4 += 8;
                        i9 -= 8;
                    }
                    int i10 = i9;
                    long position2 = (j4 - zznoVar.getPosition()) + this.l;
                    if (position2 >= 0 && position2 < 262144) {
                        zznoVar.a((int) position2);
                        int i11 = l20Var2.a.f16566k;
                        if (i11 == 0) {
                            while (true) {
                                int i12 = this.l;
                                i2 = i10;
                                if (i12 >= i2) {
                                    break;
                                }
                                int d2 = zznwVar.d(zznoVar, i2 - i12, false);
                                this.l += d2;
                                this.m -= d2;
                                i10 = i2;
                            }
                        } else {
                            byte[] bArr = this.f16544d.a;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            int i13 = 4 - i11;
                            i2 = i10;
                            while (this.l < i2) {
                                int i14 = this.m;
                                if (i14 == 0) {
                                    zznoVar.readFully(this.f16544d.a, i13, i11);
                                    this.f16544d.k(0);
                                    this.m = this.f16544d.s();
                                    this.f16543c.k(0);
                                    zznwVar.b(this.f16543c, 4);
                                    this.l += 4;
                                    i2 += i13;
                                } else {
                                    int d3 = zznwVar.d(zznoVar, i14, false);
                                    this.l += d3;
                                    this.m -= d3;
                                }
                            }
                        }
                        n20 n20Var3 = l20Var2.f12906b;
                        zznwVar.c(n20Var3.f13016e[i8], n20Var3.f13017f[i8], i2, 0, null);
                        l20Var2.f12908d++;
                        this.l = 0;
                        this.m = 0;
                        return 0;
                    }
                    zzntVar.a = j4;
                    return 1;
                }
                long j5 = this.f16549i - this.f16550j;
                long position3 = zznoVar.getPosition() + j5;
                zzst zzstVar2 = this.f16551k;
                if (zzstVar2 != null) {
                    zznoVar.readFully(zzstVar2.a, this.f16550j, (int) j5);
                    if (this.f16548h == y10.a) {
                        zzst zzstVar3 = this.f16551k;
                        zzstVar3.k(8);
                        if (zzstVar3.d() != f16542b) {
                            zzstVar3.l(4);
                            while (zzstVar3.u() > 0) {
                                if (zzstVar3.d() == f16542b) {
                                }
                            }
                            z2 = false;
                            this.q = z2;
                        }
                        z2 = true;
                        this.q = z2;
                    } else if (!this.f16546f.isEmpty()) {
                        this.f16546f.peek().R0.add(new a20(this.f16548h, this.f16551k));
                    }
                } else if (j5 < 262144) {
                    zznoVar.a((int) j5);
                } else {
                    zzntVar.a = zznoVar.getPosition() + j5;
                    z = true;
                    i(position3);
                    if (z && this.f16547g != 2) {
                        z4 = true;
                    }
                    if (!z4) {
                        return 1;
                    }
                }
                z = false;
                i(position3);
                if (z) {
                    z4 = true;
                }
                if (!z4) {
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void e(zznp zznpVar) {
        this.n = zznpVar;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long f() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean g(zzno zznoVar) throws IOException, InterruptedException {
        return m20.a(zznoVar);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void h(long j2, long j3) {
        this.f16546f.clear();
        this.f16550j = 0;
        this.l = 0;
        this.m = 0;
        if (j2 == 0) {
            j();
            return;
        }
        l20[] l20VarArr = this.o;
        if (l20VarArr != null) {
            for (l20 l20Var : l20VarArr) {
                n20 n20Var = l20Var.f12906b;
                int a2 = n20Var.a(j3);
                if (a2 == -1) {
                    a2 = n20Var.b(j3);
                }
                l20Var.f12908d = a2;
            }
        }
    }
}
