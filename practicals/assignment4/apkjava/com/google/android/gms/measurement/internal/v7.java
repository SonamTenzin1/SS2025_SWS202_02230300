package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class v7 extends w7 {

    /* renamed from: g, reason: collision with root package name */
    private zzbj.zze f17998g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q7 f17999h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v7(q7 q7Var, String str, int i2, zzbj.zze zzeVar) {
        super(str, i2);
        this.f17999h = q7Var;
        this.f17998g = zzeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.w7
    public final int a() {
        return this.f17998g.E();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i(Long l, zzbr.zzk zzkVar, boolean z) {
        boolean y = this.f17999h.n().y(this.a, zzap.w0);
        boolean y2 = this.f17999h.n().y(this.a, zzap.C0);
        boolean H = this.f17998g.H();
        boolean I = this.f17998g.I();
        boolean z2 = y && this.f17998g.K();
        boolean z3 = H || I || z2;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && !z3) {
            this.f17999h.h().P().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f18009b), this.f17998g.D() ? Integer.valueOf(this.f17998g.E()) : null);
            return true;
        }
        zzbj.zzc G = this.f17998g.G();
        boolean I2 = G.I();
        if (zzkVar.T()) {
            if (!G.F()) {
                this.f17999h.h().K().b("No number filter for long property. property", this.f17999h.k().B(zzkVar.P()));
            } else {
                bool = w7.d(w7.c(zzkVar.U(), G.G()), I2);
            }
        } else if (zzkVar.V()) {
            if (!G.F()) {
                this.f17999h.h().K().b("No number filter for double property. property", this.f17999h.k().B(zzkVar.P()));
            } else {
                bool = w7.d(w7.b(zzkVar.W(), G.G()), I2);
            }
        } else if (zzkVar.R()) {
            if (!G.D()) {
                if (!G.F()) {
                    this.f17999h.h().K().b("No string or number filter defined. property", this.f17999h.k().B(zzkVar.P()));
                } else if (zzkg.S(zzkVar.S())) {
                    bool = w7.d(w7.e(zzkVar.S(), G.G()), I2);
                } else {
                    this.f17999h.h().K().c("Invalid user property value for Numeric number filter. property, value", this.f17999h.k().B(zzkVar.P()), zzkVar.S());
                }
            } else {
                bool = w7.d(w7.g(zzkVar.S(), G.E(), this.f17999h.h()), I2);
            }
        } else {
            this.f17999h.h().K().b("User property has no value, property", this.f17999h.k().B(zzkVar.P()));
        }
        this.f17999h.h().P().b("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.f18010c = Boolean.TRUE;
        if (y && z2 && !bool.booleanValue()) {
            return true;
        }
        if (!z || this.f17998g.H()) {
            this.f18011d = bool;
        }
        if (bool.booleanValue() && z3 && zzkVar.I()) {
            long J = zzkVar.J();
            if (y2 && l != null) {
                J = l.longValue();
            }
            if (I) {
                this.f18013f = Long.valueOf(J);
            } else {
                this.f18012e = Long.valueOf(J);
            }
        }
        return true;
    }
}
