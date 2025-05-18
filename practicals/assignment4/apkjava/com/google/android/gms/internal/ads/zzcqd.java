package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbtv;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcqd extends zzzl {

    /* renamed from: f, reason: collision with root package name */
    private final zzbjm f15535f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f15536g;

    /* renamed from: h, reason: collision with root package name */
    private final Executor f15537h;

    /* renamed from: i, reason: collision with root package name */
    private final zzcpw f15538i = new zzcpw();

    /* renamed from: j, reason: collision with root package name */
    private final zzcpy f15539j = new zzcpy();

    /* renamed from: k, reason: collision with root package name */
    private final zzcqc f15540k = new zzcqc();
    private final zzcxx l;
    private zzado m;
    private zzbvx n;
    private zzbbh<zzbvx> o;
    private boolean p;

    public zzcqd(zzbjm zzbjmVar, Context context, zzyd zzydVar, String str) {
        zzcxx zzcxxVar = new zzcxx();
        this.l = zzcxxVar;
        this.p = false;
        this.f15535f = zzbjmVar;
        zzcxxVar.n(zzydVar).t(str);
        this.f15537h = zzbjmVar.e();
        this.f15536g = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzbbh i7(zzcqd zzcqdVar, zzbbh zzbbhVar) {
        zzcqdVar.o = null;
        return null;
    }

    private final synchronized boolean k7() {
        boolean z;
        zzbvx zzbvxVar = this.n;
        if (zzbvxVar != null) {
            z = zzbvxVar.g() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean B() {
        Preconditions.f("isLoaded must be called on the main UI thread.");
        return k7();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void C2(zzyd zzydVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void C3(zzaqt zzaqtVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyd C5() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void H6(zzado zzadoVar) {
        Preconditions.f("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.m = zzadoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzzs I4() {
        return this.f15539j.a();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean J4(zzxz zzxzVar) {
        Preconditions.f("loadAd must be called on the main UI thread.");
        if (this.o == null && !k7()) {
            zzcya.b(this.f15536g, zzxzVar.f16973k);
            this.n = null;
            zzcxv d2 = this.l.w(zzxzVar).d();
            zzbtv.zza zzaVar = new zzbtv.zza();
            zzcqc zzcqcVar = this.f15540k;
            if (zzcqcVar != null) {
                zzaVar.c(zzcqcVar, this.f15535f.e()).g(this.f15540k, this.f15535f.e()).d(this.f15540k, this.f15535f.e());
            }
            zzbws a = this.f15535f.k().c(new zzbqy.zza().e(this.f15536g).b(d2).c()).d(zzaVar.c(this.f15538i, this.f15535f.e()).g(this.f15538i, this.f15535f.e()).d(this.f15538i, this.f15535f.e()).h(this.f15538i, this.f15535f.e()).a(this.f15539j, this.f15535f.e()).k()).b(new zzcow(this.m)).a();
            zzbbh<zzbvx> c2 = a.c();
            this.o = c2;
            zzbar.f(c2, new cn(this, a), this.f15537h);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void L0(zzyz zzyzVar) {
        Preconditions.f("setAdListener must be called on the main UI thread.");
        this.f15538i.c(zzyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void P5(zzzs zzzsVar) {
        Preconditions.f("setAppEventListener must be called on the main UI thread.");
        this.f15539j.b(zzzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final IObjectWrapper S0() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void U5(zzaqn zzaqnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void W6(zzacd zzacdVar) {
        this.l.k(zzacdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void X5(zzaax zzaaxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String c0() {
        zzbvx zzbvxVar = this.n;
        if (zzbvxVar == null) {
            return null;
        }
        return zzbvxVar.f();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void destroy() {
        Preconditions.f("destroy must be called on the main UI thread.");
        zzbvx zzbvxVar = this.n;
        if (zzbvxVar != null) {
            zzbvxVar.i().i0(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String f6() {
        return this.l.c();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final Bundle getAdMetadata() {
        Preconditions.f("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized String getMediationAdapterClassName() {
        zzbvx zzbvxVar = this.n;
        if (zzbvxVar == null) {
            return null;
        }
        return zzbvxVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzaar getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void h0(zzatb zzatbVar) {
        this.f15540k.c(zzatbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void k4() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void m4(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized boolean p0() {
        boolean z;
        zzbbh<zzbvx> zzbbhVar = this.o;
        if (zzbbhVar != null) {
            z = zzbbhVar.isDone() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void pause() {
        Preconditions.f("pause must be called on the main UI thread.");
        zzbvx zzbvxVar = this.n;
        if (zzbvxVar != null) {
            zzbvxVar.i().f0(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void resume() {
        Preconditions.f("resume must be called on the main UI thread.");
        zzbvx zzbvxVar = this.n;
        if (zzbvxVar != null) {
            zzbvxVar.i().g0(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.f("setImmersiveMode must be called on the main UI thread.");
        this.p = z;
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void showInterstitial() {
        Preconditions.f("showInterstitial must be called on the main UI thread.");
        zzbvx zzbvxVar = this.n;
        if (zzbvxVar == null) {
            return;
        }
        if (zzbvxVar.j()) {
            this.n.h(this.p);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void t1(boolean z) {
        Preconditions.f("setManualImpressionsEnabled must be called from the main thread.");
        this.l.j(z);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final synchronized void v4(zzzy zzzyVar) {
        Preconditions.f("setCorrelationIdProvider must be called on the main UI thread");
        this.l.o(zzzyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void w4(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final zzyz x5() {
        return this.f15538i.b();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void x6() {
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void z0(zzzp zzzpVar) {
        Preconditions.f("setAdMetadataListener must be called on the main UI thread.");
    }
}
