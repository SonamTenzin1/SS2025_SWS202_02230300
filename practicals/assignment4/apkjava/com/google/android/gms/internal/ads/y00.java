package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y00 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f13591f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzma f13592g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y00(zzma zzmaVar, zznc zzncVar) {
        this.f13592g = zzmaVar;
        this.f13591f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        this.f13591f.a();
        zzlzVar = this.f13592g.f16456b;
        zzlzVar.b(this.f13591f);
    }
}
