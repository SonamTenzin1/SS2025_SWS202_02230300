package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class an implements zzban<zzbnf> {
    private final /* synthetic */ zzboc a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcpt f12261b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(zzcpt zzcptVar, zzboc zzbocVar) {
        this.f12261b = zzcptVar;
        this.a = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzbtb zzbtbVar;
        synchronized (this.f12261b) {
            zzcpt.i7(this.f12261b, null);
            this.a.c().onAdFailedToLoad(zzcgm.b(th));
            zzbtbVar = this.f12261b.l;
            zzbtbVar.i0(60);
            zzcya.a(th, "BannerAdManagerShim.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbnf zzbnfVar) {
        zzbnf zzbnfVar2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        zzbtb zzbtbVar;
        zzbnf zzbnfVar3;
        zzbnf zzbnfVar4 = zzbnfVar;
        synchronized (this.f12261b) {
            zzcpt.i7(this.f12261b, null);
            zzbnfVar2 = this.f12261b.o;
            if (zzbnfVar2 != null) {
                zzbnfVar3 = this.f12261b.o;
                zzbnfVar3.a();
            }
            this.f12261b.o = zzbnfVar4;
            viewGroup = this.f12261b.f15523h;
            viewGroup.removeAllViews();
            viewGroup2 = this.f12261b.f15523h;
            viewGroup2.addView(zzbnfVar4.i());
            zzbnfVar4.c();
            zzbtbVar = this.f12261b.l;
            zzbtbVar.i0(zzbnfVar4.k());
        }
    }
}
