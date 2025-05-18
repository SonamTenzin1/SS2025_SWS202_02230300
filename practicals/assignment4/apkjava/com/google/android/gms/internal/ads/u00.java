package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u00 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f13374f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13375g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u00(zzma zzmaVar, zznc zzncVar) {
        this.f13375g = zzmaVar;
        this.f13374f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.f13375g.f16456b;
        zzlzVar.e(this.f13374f);
    }
}
