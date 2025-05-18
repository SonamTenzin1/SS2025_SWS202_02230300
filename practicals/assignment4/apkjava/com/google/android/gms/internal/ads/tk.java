package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class tk implements zzban<zzbnf> {
    private final /* synthetic */ zzckv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tk(zzckv zzckvVar) {
        this.a = zzckvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        zzbrm zzbrmVar;
        zzbrmVar = this.a.f15340d;
        zzbrmVar.onAdFailedToLoad(zzcgm.b(th));
        zzcya.a(th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbnf zzbnfVar) {
        zzbnfVar.c();
    }
}
