package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b40 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zznc f12311f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f12312g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b40(zzto zztoVar, zznc zzncVar) {
        this.f12312g = zztoVar;
        this.f12311f = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        this.f12311f.a();
        zztnVar = this.f12312g.f16775b;
        zztnVar.p(this.f12311f);
    }
}
