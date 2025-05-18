package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class s5 extends f7 {
    public s5(zzkc zzkcVar) {
        super(zzkcVar);
    }

    private static String i(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    public final byte[] w(zzan zzanVar, String str) {
        m7 m7Var;
        zzbr.zzg.zza zzaVar;
        z3 z3Var;
        zzbr.zzf.zza zzaVar2;
        Bundle bundle;
        byte[] bArr;
        long j2;
        h a;
        d();
        this.a.s();
        Preconditions.k(zzanVar);
        Preconditions.g(str);
        if (!n().B(str, zzap.p0)) {
            h().O().b("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzanVar.f18067f) && !"_iapx".equals(zzanVar.f18067f)) {
            h().O().c("Generating a payload for this event is not available. package_name, event_name", str, zzanVar.f18067f);
            return null;
        }
        zzbr.zzf.zza F = zzbr.zzf.F();
        q().w0();
        try {
            z3 j0 = q().j0(str);
            if (j0 == null) {
                h().O().b("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!j0.e0()) {
                h().O().b("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzbr.zzg.zza I = zzbr.zzg.R0().w(1).I("android");
            if (!TextUtils.isEmpty(j0.t())) {
                I.m0(j0.t());
            }
            if (!TextUtils.isEmpty(j0.X())) {
                I.h0(j0.X());
            }
            if (!TextUtils.isEmpty(j0.T())) {
                I.r0(j0.T());
            }
            if (j0.V() != -2147483648L) {
                I.t0((int) j0.V());
            }
            I.l0(j0.Z()).E0(j0.d0());
            if (!TextUtils.isEmpty(j0.A())) {
                I.F0(j0.A());
            } else if (!TextUtils.isEmpty(j0.D())) {
                I.P0(j0.D());
            }
            I.u0(j0.b0());
            if (this.a.p() && zzx.X() && n().x(I.C0())) {
                I.C0();
                if (!TextUtils.isEmpty(null)) {
                    I.O0(null);
                }
            }
            Pair<String, Boolean> v = m().v(j0.t());
            if (j0.l() && v != null && !TextUtils.isEmpty((CharSequence) v.first)) {
                I.v0(i((String) v.first, Long.toString(zzanVar.f18070i)));
                Object obj = v.second;
                if (obj != null) {
                    I.J(((Boolean) obj).booleanValue());
                }
            }
            e().p();
            zzbr.zzg.zza V = I.V(Build.MODEL);
            e().p();
            V.P(Build.VERSION.RELEASE).k0((int) e().v()).a0(e().w());
            I.z0(i(j0.x(), Long.toString(zzanVar.f18070i)));
            if (!TextUtils.isEmpty(j0.M())) {
                I.H0(j0.M());
            }
            String t = j0.t();
            List<m7> I2 = q().I(t);
            Iterator<m7> it = I2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    m7Var = null;
                    break;
                }
                m7Var = it.next();
                if ("_lte".equals(m7Var.f17873c)) {
                    break;
                }
            }
            if (m7Var == null || m7Var.f17875e == null) {
                m7 m7Var2 = new m7(t, "auto", "_lte", j().a(), 0L);
                I2.add(m7Var2);
                q().T(m7Var2);
            }
            if (n().B(t, zzap.k0)) {
                zzkg p = p();
                p.h().P().a("Checking account type status for ad personalization signals");
                if (p.e().z()) {
                    String t2 = j0.t();
                    if (j0.l() && p.r().I(t2)) {
                        p.h().O().a("Turning off ad personalization due to account type");
                        Iterator<m7> it2 = I2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            if ("_npa".equals(it2.next().f17873c)) {
                                it2.remove();
                                break;
                            }
                        }
                        I2.add(new m7(t2, "auto", "_npa", p.j().a(), 1L));
                    }
                }
            }
            zzbr.zzk[] zzkVarArr = new zzbr.zzk[I2.size()];
            for (int i2 = 0; i2 < I2.size(); i2++) {
                zzbr.zzk.zza B = zzbr.zzk.X().C(I2.get(i2).f17873c).B(I2.get(i2).f17874d);
                p().K(B, I2.get(i2).f17875e);
                zzkVarArr[i2] = (zzbr.zzk) ((zzfd) B.y());
            }
            I.O(Arrays.asList(zzkVarArr));
            Bundle Y = zzanVar.f18068g.Y();
            Y.putLong("_c", 1L);
            h().O().a("Marking in-app purchase as real-time");
            Y.putLong("_r", 1L);
            Y.putString("_o", zzanVar.f18069h);
            if (l().v0(I.C0())) {
                l().L(Y, "_dbg", 1L);
                l().L(Y, "_r", 1L);
            }
            h D = q().D(str, zzanVar.f18067f);
            if (D == null) {
                z3Var = j0;
                zzaVar = I;
                zzaVar2 = F;
                bundle = Y;
                bArr = null;
                a = new h(str, zzanVar.f18067f, 0L, 0L, zzanVar.f18070i, 0L, null, null, null, null);
                j2 = 0;
            } else {
                zzaVar = I;
                z3Var = j0;
                zzaVar2 = F;
                bundle = Y;
                bArr = null;
                j2 = D.f17788f;
                a = D.a(zzanVar.f18070i);
            }
            q().N(a);
            zzak zzakVar = new zzak(this.a, zzanVar.f18069h, str, zzanVar.f18067f, zzanVar.f18070i, j2, bundle);
            zzbr.zzc.zza J = zzbr.zzc.c0().B(zzakVar.f18063d).E(zzakVar.f18061b).J(zzakVar.f18064e);
            Iterator<String> it3 = zzakVar.f18065f.iterator();
            while (it3.hasNext()) {
                String next = it3.next();
                zzbr.zze.zza C = zzbr.zze.T().C(next);
                p().J(C, zzakVar.f18065f.W(next));
                J.C(C);
            }
            zzbr.zzg.zza zzaVar3 = zzaVar;
            zzaVar3.D(J).E(zzbr.zzh.B().w(zzbr.zzd.B().w(a.f17785c).A(zzanVar.f18067f)));
            zzaVar3.U(o().w(z3Var.t(), Collections.emptyList(), zzaVar3.c0(), Long.valueOf(J.M())));
            if (J.L()) {
                zzaVar3.N(J.M()).T(J.M());
            }
            long R = z3Var.R();
            if (R != 0) {
                zzaVar3.g0(R);
            }
            long P = z3Var.P();
            if (P != 0) {
                zzaVar3.X(P);
            } else if (R != 0) {
                zzaVar3.X(R);
            }
            z3Var.i0();
            zzaVar3.o0((int) z3Var.f0()).q0(n().C()).C(j().a()).Q(true);
            zzbr.zzf.zza zzaVar4 = zzaVar2;
            zzaVar4.w(zzaVar3);
            z3 z3Var2 = z3Var;
            z3Var2.a(zzaVar3.j0());
            z3Var2.q(zzaVar3.n0());
            q().O(z3Var2);
            q().w();
            try {
                return p().W(((zzbr.zzf) ((zzfd) zzaVar4.y())).j());
            } catch (IOException e2) {
                h().H().c("Data loss. Failed to bundle and serialize. appId", zzet.x(str), e2);
                return bArr;
            }
        } catch (SecurityException e3) {
            h().O().b("Resettable device id encryption failed", e3.getMessage());
            return new byte[0];
        } catch (SecurityException e4) {
            h().O().b("app instance id encryption failed", e4.getMessage());
            return new byte[0];
        } finally {
            q().A0();
        }
    }
}
