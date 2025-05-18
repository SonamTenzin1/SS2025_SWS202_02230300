package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class j4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17827f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f17828g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17829h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j4(zzgc zzgcVar, zzan zzanVar, zzm zzmVar) {
        this.f17829h = zzgcVar;
        this.f17827f = zzanVar;
        this.f17828g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzan E3 = this.f17829h.E3(this.f17827f, this.f17828g);
        zzkcVar = this.f17829h.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17829h.f18163f;
        zzkcVar2.p(E3, this.f17828g);
    }
}
