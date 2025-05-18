package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbdk {

    @VisibleForTesting
    private static int a;

    /* renamed from: b */
    @VisibleForTesting
    private static int f14388b;

    /* renamed from: c */
    private zzge f14389c;

    /* renamed from: d */
    private zzhd f14390d;

    /* renamed from: e */
    private zzgn f14391e;

    /* renamed from: f */
    private zzbdo f14392f;

    /* renamed from: g */
    private final j8 f14393g;

    /* renamed from: h */
    private final k8 f14394h;

    /* renamed from: i */
    private final i8 f14395i;

    public zzbdk() {
        j8 j8Var = new j8(this);
        this.f14393g = j8Var;
        this.f14394h = new k8(this);
        this.f14395i = new i8(this);
        Preconditions.f("ExoPlayer must be created on the main UI thread.");
        if (zzawz.n()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 29);
            sb.append("AdExoPlayerHelper initialize ");
            sb.append(valueOf);
            zzawz.m(sb.toString());
        }
        a++;
        zzge a2 = zzgg.a(2);
        this.f14389c = a2;
        a2.i(j8Var);
    }

    public final synchronized void f(String str, String str2) {
        zzbdo zzbdoVar = this.f14392f;
        if (zzbdoVar != null) {
            zzbdoVar.b(str, str2);
        }
    }

    public static int g() {
        return a;
    }

    public static int h() {
        return f14388b;
    }

    public final synchronized void a() {
        this.f14392f = null;
    }

    public final synchronized void c(zzbdo zzbdoVar) {
        this.f14392f = zzbdoVar;
    }

    public final void d(zzgh zzghVar, zzhh zzhhVar, zzgq zzgqVar) {
        this.f14393g.d(zzghVar);
        this.f14394h.i(zzhhVar);
        this.f14395i.i(zzgqVar);
    }

    public final boolean e(zzhn zzhnVar) {
        if (this.f14389c == null) {
            return false;
        }
        Handler handler = zzaxi.a;
        this.f14390d = new zzhd(zzhnVar, 1, 0L, handler, this.f14394h, -1);
        zzgn zzgnVar = new zzgn(zzhnVar, handler, this.f14395i);
        this.f14391e = zzgnVar;
        this.f14389c.k(this.f14390d, zzgnVar);
        f14388b++;
        return true;
    }

    public final void finalize() throws Throwable {
        a--;
        if (zzawz.n()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("AdExoPlayerHelper finalize ");
            sb.append(valueOf);
            zzawz.m(sb.toString());
        }
    }

    public final void i() {
        zzge zzgeVar = this.f14389c;
        if (zzgeVar != null) {
            zzgeVar.c();
            this.f14389c = null;
            f14388b--;
        }
    }

    public final zzge j() {
        return this.f14389c;
    }

    public final zzhd k() {
        return this.f14390d;
    }

    public final zzgn l() {
        return this.f14391e;
    }
}
