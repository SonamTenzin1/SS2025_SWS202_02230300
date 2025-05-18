package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class i4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17814f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17815g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17816h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i4(zzgc zzgcVar, zzan zzanVar, String str) {
        this.f17816h = zzgcVar;
        this.f17814f = zzanVar;
        this.f17815g = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17816h.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17816h.f18163f;
        zzkcVar2.q(this.f17814f, this.f17815g);
    }
}
