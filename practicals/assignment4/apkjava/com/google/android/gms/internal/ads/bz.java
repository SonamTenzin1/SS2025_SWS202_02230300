package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class bz implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzhv f12372f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgn f12373g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(zzgn zzgnVar, zzhv zzhvVar) {
        this.f12373g = zzgnVar;
        this.f12372f = zzhvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgq zzgqVar;
        zzgqVar = this.f12373g.G;
        zzgqVar.h(this.f12372f);
    }
}
