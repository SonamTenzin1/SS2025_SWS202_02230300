package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zm implements zzban<zzbpc> {
    private final /* synthetic */ zzbxo a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcpp f13717b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zm(zzcpp zzcppVar, zzbxo zzbxoVar) {
        this.f13717b = zzcppVar;
        this.a = zzbxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.a.e().onAdFailedToLoad(zzcgm.b(th));
        zzcya.a(th, "AdLoaderShim.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbpc zzbpcVar) {
        zzbpc zzbpcVar2 = zzbpcVar;
        synchronized (this.f13717b) {
            this.f13717b.m = zzbpcVar2.b();
            this.f13717b.n = zzbpcVar2.f();
            zzbpcVar2.c();
        }
    }
}
