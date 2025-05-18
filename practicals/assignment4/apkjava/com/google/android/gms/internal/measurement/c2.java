package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class c2 implements y4 {
    private final zzen a;

    private c2(zzen zzenVar) {
        zzen zzenVar2 = (zzen) zzff.f(zzenVar, "output");
        this.a = zzenVar2;
        zzenVar2.f17377c = this;
    }

    public static c2 P(zzen zzenVar) {
        c2 c2Var = zzenVar.f17377c;
        return c2Var != null ? c2Var : new c2(zzenVar);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void A(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof zzfv) {
            zzfv zzfvVar = (zzfv) list;
            while (i3 < list.size()) {
                Object e2 = zzfvVar.e(i3);
                if (e2 instanceof String) {
                    this.a.r(i2, (String) e2);
                } else {
                    this.a.o(i2, (zzdu) e2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.r(i2, list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void B(int i2, boolean z) throws IOException {
        this.a.s(i2, z);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void C(int i2, Object obj, p3 p3Var) throws IOException {
        this.a.q(i2, (zzgo) obj, p3Var);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void D(int i2, int i3) throws IOException {
        this.a.P(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void E(int i2, zzdu zzduVar) throws IOException {
        this.a.o(i2, zzduVar);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void F(int i2, Object obj, p3 p3Var) throws IOException {
        zzen zzenVar = this.a;
        zzenVar.m(i2, 3);
        p3Var.h((zzgo) obj, zzenVar.f17377c);
        zzenVar.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void G(int i2, int i3) throws IOException {
        this.a.P(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void H(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void I(int i2, List<?> list, p3 p3Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            F(i2, list.get(i3), p3Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void J(int i2, int i3) throws IOException {
        this.a.f0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void K(int i2, List<?> list, p3 p3Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            C(i2, list.get(i3), p3Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void L(int i2, long j2) throws IOException {
        this.a.Y(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void M(int i2, int i3) throws IOException {
        this.a.X(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void N(int i2, long j2) throws IOException {
        this.a.Q(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final <K, V> void O(int i2, z2<K, V> z2Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.m(i2, 2);
            this.a.O(zzgg.a(z2Var, entry.getKey(), entry.getValue()));
            zzgg.b(this.a, z2Var, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final int a() {
        return zzfd.zze.l;
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void b(int i2, long j2) throws IOException {
        this.a.Y(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void c(int i2, long j2) throws IOException {
        this.a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void d(int i2) throws IOException {
        this.a.m(i2, 3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void e(int i2) throws IOException {
        this.a.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void f(int i2, Object obj) throws IOException {
        if (obj instanceof zzdu) {
            this.a.R(i2, (zzdu) obj);
        } else {
            this.a.p(i2, (zzgo) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void g(int i2, String str) throws IOException {
        this.a.r(i2, str);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void h(int i2, double d2) throws IOException {
        this.a.k(i2, d2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.L(list.get(i5).booleanValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.y(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.s(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.k0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.j(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.P(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.B0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.j(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.P(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.d0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.t(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.n(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void m(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.v0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.Z(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.Y(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void n(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.w0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.e0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void o(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.o0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.O(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.X(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void p(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.z0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.e0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void q(int i2, long j2) throws IOException {
        this.a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void r(int i2, float f2) throws IOException {
        this.a.l(i2, f2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void s(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.r0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.Z(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.Y(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void t(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.n0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.S(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.Q(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void u(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.i0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.t(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.n(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void v(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.s0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.W(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.f0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void w(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.z(list.get(i5).doubleValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.h(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.k(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void x(int i2, List<zzdu> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.a.o(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void y(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void z(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzen.A(list.get(i5).floatValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.i(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.l(i2, list.get(i3).floatValue());
            i3++;
        }
    }
}
