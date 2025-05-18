package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class x20 implements zznp, zzqj, zzqv, zzsf<c30> {
    private boolean A;
    private int B;
    private zzrb C;
    private long D;
    private boolean[] E;
    private boolean[] F;
    private boolean G;
    private long I;
    private int K;
    private boolean L;
    private boolean M;

    /* renamed from: f */
    private final Uri f13545f;

    /* renamed from: g */
    private final zzrv f13546g;

    /* renamed from: h */
    private final int f13547h;

    /* renamed from: i */
    private final Handler f13548i;

    /* renamed from: j */
    private final zzqi f13549j;

    /* renamed from: k */
    private final zzqm f13550k;
    private final zzrt l;
    private final String m;
    private final long n;
    private final d30 p;
    private zzqk v;
    private zznu w;
    private boolean x;
    private boolean y;
    private boolean z;
    private final zzse o = new zzse("Loader:ExtractorMediaPeriod");
    private final zzsm q = new zzsm();
    private final Runnable r = new y20(this);
    private final Runnable s = new z20(this);
    private final Handler t = new Handler();
    private long J = -9223372036854775807L;
    private final SparseArray<zzqt> u = new SparseArray<>();
    private long H = -1;

    public x20(Uri uri, zzrv zzrvVar, zznn[] zznnVarArr, int i2, Handler handler, zzqi zzqiVar, zzqm zzqmVar, zzrt zzrtVar, String str, int i3) {
        this.f13545f = uri;
        this.f13546g = zzrvVar;
        this.f13547h = i2;
        this.f13548i = handler;
        this.f13549j = zzqiVar;
        this.f13550k = zzqmVar;
        this.l = zzrtVar;
        this.m = str;
        this.n = i3;
        this.p = new d30(zznnVarArr, this);
    }

    private final boolean D() {
        return this.J != -9223372036854775807L;
    }

    public final void I() {
        if (this.M || this.y || this.w == null || !this.x) {
            return;
        }
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.u.valueAt(i2).p() == null) {
                return;
            }
        }
        this.q.c();
        zzra[] zzraVarArr = new zzra[size];
        this.F = new boolean[size];
        this.E = new boolean[size];
        this.D = this.w.f();
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (i3 < size) {
                zzlh p = this.u.valueAt(i3).p();
                zzraVarArr[i3] = new zzra(p);
                String str = p.f16427k;
                if (!zzsp.c(str) && !zzsp.b(str)) {
                    z = false;
                }
                this.F[i3] = z;
                this.G = z | this.G;
                i3++;
            } else {
                this.C = new zzrb(zzraVarArr);
                this.y = true;
                this.f13550k.e(new zzqz(this.D, this.w.b()), null);
                this.v.d(this);
                return;
            }
        }
    }

    private final int J() {
        int size = this.u.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.u.valueAt(i3).n();
        }
        return i2;
    }

    private final long K() {
        int size = this.u.size();
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.max(j2, this.u.valueAt(i2).l());
        }
        return j2;
    }

    private final void p() {
        zznu zznuVar;
        c30 c30Var = new c30(this, this.f13545f, this.f13546g, this.p, this.q);
        if (this.y) {
            zzsk.e(D());
            long j2 = this.D;
            if (j2 != -9223372036854775807L && this.J >= j2) {
                this.L = true;
                this.J = -9223372036854775807L;
                return;
            } else {
                c30Var.e(this.w.a(this.J), this.J);
                this.J = -9223372036854775807L;
            }
        }
        this.K = J();
        int i2 = this.f13547h;
        if (i2 == -1) {
            i2 = (this.y && this.H == -1 && ((zznuVar = this.w) == null || zznuVar.f() == -9223372036854775807L)) ? 6 : 3;
        }
        this.o.b(c30Var, this, i2);
    }

    private final void t(c30 c30Var) {
        long j2;
        if (this.H == -1) {
            j2 = c30Var.f12392i;
            this.H = j2;
        }
    }

    public final void C(int i2, long j2) {
        zzqt valueAt = this.u.valueAt(i2);
        if (this.L && j2 > valueAt.l()) {
            valueAt.q();
        } else {
            valueAt.k(j2, true);
        }
    }

    public final void H() throws IOException {
        this.o.h(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final long a() {
        if (this.B == 0) {
            return Long.MIN_VALUE;
        }
        return r();
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final boolean b(long j2) {
        if (this.L) {
            return false;
        }
        if (this.y && this.B == 0) {
            return false;
        }
        boolean b2 = this.q.b();
        if (this.o.a()) {
            return b2;
        }
        p();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long c(zzrm[] zzrmVarArr, boolean[] zArr, zzqw[] zzqwVarArr, boolean[] zArr2, long j2) {
        int i2;
        zzsk.e(this.y);
        for (int i3 = 0; i3 < zzrmVarArr.length; i3++) {
            if (zzqwVarArr[i3] != null && (zzrmVarArr[i3] == null || !zArr[i3])) {
                i2 = ((e30) zzqwVarArr[i3]).a;
                zzsk.e(this.E[i2]);
                this.B--;
                this.E[i2] = false;
                this.u.valueAt(i2).e();
                zzqwVarArr[i3] = null;
            }
        }
        boolean z = false;
        for (int i4 = 0; i4 < zzrmVarArr.length; i4++) {
            if (zzqwVarArr[i4] == null && zzrmVarArr[i4] != null) {
                zzrm zzrmVar = zzrmVarArr[i4];
                zzsk.e(zzrmVar.length() == 1);
                zzsk.e(zzrmVar.b(0) == 0);
                int a = this.C.a(zzrmVar.a());
                zzsk.e(!this.E[a]);
                this.B++;
                this.E[a] = true;
                zzqwVarArr[i4] = new e30(this, a);
                zArr2[i4] = true;
                z = true;
            }
        }
        if (!this.z) {
            int size = this.u.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!this.E[i5]) {
                    this.u.valueAt(i5).e();
                }
            }
        }
        if (this.B == 0) {
            this.A = false;
            if (this.o.a()) {
                this.o.i();
            }
        } else if (!this.z ? j2 != 0 : z) {
            j2 = h(j2);
            for (int i6 = 0; i6 < zzqwVarArr.length; i6++) {
                if (zzqwVarArr[i6] != null) {
                    zArr2[i6] = true;
                }
            }
        }
        this.z = true;
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void d() {
        this.x = true;
        this.t.post(this.r);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long e() {
        if (!this.A) {
            return -9223372036854775807L;
        }
        this.A = false;
        return this.I;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void f() throws IOException {
        this.o.h(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzsf
    public final /* synthetic */ void g(c30 c30Var, long j2, long j3) {
        t(c30Var);
        this.L = true;
        if (this.D == -9223372036854775807L) {
            long K = K();
            this.D = K == Long.MIN_VALUE ? 0L : K + 10000;
            this.f13550k.e(new zzqz(this.D, this.w.b()), null);
        }
        this.v.g(this);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long h(long j2) {
        if (!this.w.b()) {
            j2 = 0;
        }
        this.I = j2;
        int size = this.u.size();
        boolean z = !D();
        for (int i2 = 0; z && i2 < size; i2++) {
            if (this.E[i2]) {
                z = this.u.valueAt(i2).k(j2, false);
            }
        }
        if (!z) {
            this.J = j2;
            this.L = false;
            if (this.o.a()) {
                this.o.i();
            } else {
                for (int i3 = 0; i3 < size; i3++) {
                    this.u.valueAt(i3).t(this.E[i3]);
                }
            }
        }
        this.A = false;
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void i(zzlh zzlhVar) {
        this.t.post(this.r);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void j(zzqk zzqkVar, long j2) {
        this.v = zzqkVar;
        this.q.b();
        p();
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void k(long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final zzrb l() {
        return this.C;
    }

    @Override // com.google.android.gms.internal.ads.zzsf
    public final /* synthetic */ int m(c30 c30Var, long j2, long j3, IOException iOException) {
        zznu zznuVar;
        c30 c30Var2 = c30Var;
        t(c30Var2);
        Handler handler = this.f13548i;
        if (handler != null && this.f13549j != null) {
            handler.post(new b30(this, iOException));
        }
        if (iOException instanceof zzrc) {
            return 3;
        }
        boolean z = J() > this.K;
        if (this.H == -1 && ((zznuVar = this.w) == null || zznuVar.f() == -9223372036854775807L)) {
            this.I = 0L;
            this.A = this.y;
            int size = this.u.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.u.valueAt(i2).t(!this.y || this.E[i2]);
            }
            c30Var2.e(0L, 0L);
        }
        this.K = J();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsf
    public final /* synthetic */ void n(c30 c30Var, long j2, long j3, boolean z) {
        t(c30Var);
        if (z || this.B <= 0) {
            return;
        }
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.u.valueAt(i2).t(this.E[i2]);
        }
        this.v.g(this);
    }

    public final void o() {
        this.o.f(new a30(this, this.p));
        this.t.removeCallbacksAndMessages(null);
        this.M = true;
    }

    public final int q(int i2, zzlj zzljVar, zznd zzndVar, boolean z) {
        if (this.A || D()) {
            return -3;
        }
        return this.u.valueAt(i2).f(zzljVar, zzndVar, z, this.L, this.I);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long r() {
        long K;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (D()) {
            return this.J;
        }
        if (this.G) {
            K = Long.MAX_VALUE;
            int size = this.u.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.F[i2]) {
                    K = Math.min(K, this.u.valueAt(i2).l());
                }
            }
        } else {
            K = K();
        }
        return K == Long.MIN_VALUE ? this.I : K;
    }

    public final boolean v(int i2) {
        if (this.L) {
            return true;
        }
        return !D() && this.u.valueAt(i2).o();
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zznw y(int i2, int i3) {
        zzqt zzqtVar = this.u.get(i2);
        if (zzqtVar != null) {
            return zzqtVar;
        }
        zzqt zzqtVar2 = new zzqt(this.l);
        zzqtVar2.h(this);
        this.u.put(i2, zzqtVar2);
        return zzqtVar2;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void z(zznu zznuVar) {
        this.w = zznuVar;
        this.t.post(this.r);
    }
}
