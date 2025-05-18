package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class az implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzhu f12278f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgn f12279g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(zzgn zzgnVar, zzhu zzhuVar) {
        this.f12279g = zzgnVar;
        this.f12278f = zzhuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgq zzgqVar;
        zzgqVar = this.f12279g.G;
        zzgqVar.f(this.f12278f);
    }
}
