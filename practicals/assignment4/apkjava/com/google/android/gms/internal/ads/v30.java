package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f13437f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f13438g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v30(zzto zztoVar, zznc zzncVar) {
        this.f13438g = zztoVar;
        this.f13437f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.f13438g.f16775b;
        zztnVar.r(this.f13437f);
    }
}
