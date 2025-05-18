package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cz implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzgv f12441f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgr f12442g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(zzgr zzgrVar, zzgv zzgvVar) {
        this.f12442g = zzgrVar;
        this.f12441f = zzgvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgw zzgwVar;
        zzgwVar = this.f12442g.f16260j;
        zzgwVar.d(this.f12441f);
    }
}
