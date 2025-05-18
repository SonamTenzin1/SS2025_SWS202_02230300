package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class su implements ux {
    private final zzdni a;

    private su(zzdni zzdniVar) {
        zzdni zzdniVar2 = (zzdni) zzdod.d(zzdniVar, "output");
        this.a = zzdniVar2;
        zzdniVar2.f15991c = this;
    }

    public static su a(zzdni zzdniVar) {
        su suVar = zzdniVar.f15991c;
        return suVar != null ? suVar : new su(zzdniVar);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void A(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof zzdot) {
            zzdot zzdotVar = (zzdot) list;
            while (i3 < list.size()) {
                Object k1 = zzdotVar.k1(i3);
                if (k1 instanceof String) {
                    this.a.R(i2, (String) k1);
                } else {
                    this.a.g(i2, (zzdmr) k1);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.R(i2, list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void B(int i2, long j2) throws IOException {
        this.a.x0(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void C(int i2) throws IOException {
        this.a.H0(i2, 4);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void D(int i2, int i3) throws IOException {
        this.a.l(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void E(int i2, double d2) throws IOException {
        this.a.C(i2, d2);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final int F() {
        return zzdob.zze.l;
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void G(int i2, Object obj) throws IOException {
        if (obj instanceof zzdmr) {
            this.a.D(i2, (zzdmr) obj);
        } else {
            this.a.E(i2, (zzdpk) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void H(int i2, int i3) throws IOException {
        this.a.l(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void I(int i2, zzdmr zzdmrVar) throws IOException {
        this.a.g(i2, zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void J(int i2, long j2) throws IOException {
        this.a.t0(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void K(int i2, int i3) throws IOException {
        this.a.J0(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void L(int i2, long j2) throws IOException {
        this.a.t0(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void M(int i2, long j2) throws IOException {
        this.a.x0(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void N(int i2, int i3) throws IOException {
        this.a.I0(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void O(int i2, int i3) throws IOException {
        this.a.K0(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void P(int i2, long j2) throws IOException {
        this.a.u0(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void Q(int i2) throws IOException {
        this.a.H0(i2, 3);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void R(int i2, boolean z) throws IOException {
        this.a.v0(i2, z);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void S(int i2, List<?> list, lw lwVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            U(i2, list.get(i3), lwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void T(int i2, int i3) throws IOException {
        this.a.I0(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void U(int i2, Object obj, lw lwVar) throws IOException {
        zzdni zzdniVar = this.a;
        zzdniVar.H0(i2, 3);
        lwVar.e((zzdpk) obj, zzdniVar.f15991c);
        zzdniVar.H0(i2, 4);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final <K, V> void V(int i2, tv<K, V> tvVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.H0(i2, 2);
            this.a.e0(zzdpc.a(tvVar, entry.getKey(), entry.getValue()));
            zzdpc.b(this.a, tvVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void W(int i2, List<?> list, lw lwVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Y(i2, list.get(i3), lwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void X(int i2, String str) throws IOException {
        this.a.R(i2, str);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void Y(int i2, Object obj, lw lwVar) throws IOException {
        this.a.i(i2, (zzdpk) obj, lwVar);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.G(list.get(i5).booleanValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.F(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.v0(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.i0(list.get(i5).intValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.b0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.I0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.n0(list.get(i5).intValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.b0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.I0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.V(list.get(i5).longValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.S(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.t0(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void m(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.Z(list.get(i5).longValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.U(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.x0(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void n(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.l0(list.get(i5).intValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.g0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.l(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void o(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.j0(list.get(i5).intValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.e0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.J0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void p(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.m0(list.get(i5).intValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.g0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.l(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void r(int i2, float f2) throws IOException {
        this.a.f(i2, f2);
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void s(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.Y(list.get(i5).longValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.U(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.x0(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void t(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.X(list.get(i5).longValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.T(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.u0(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void u(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.W(list.get(i5).longValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.S(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.t0(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void v(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.k0(list.get(i5).intValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.f0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.K0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void w(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.H(list.get(i5).doubleValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.B(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.C(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void x(int i2, List<zzdmr> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.a.g(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.ads.ux
    public final void z(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.H0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzdni.s0(list.get(i5).floatValue());
            }
            this.a.e0(i4);
            while (i3 < list.size()) {
                this.a.d0(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.f(i2, list.get(i3).floatValue());
            i3++;
        }
    }
}
