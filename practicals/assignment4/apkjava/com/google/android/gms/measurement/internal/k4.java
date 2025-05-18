package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class k4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzkj f17838f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f17839g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17840h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k4(zzgc zzgcVar, zzkj zzkjVar, zzm zzmVar) {
        this.f17840h = zzgcVar;
        this.f17838f = zzkjVar;
        this.f17839g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkc zzkcVar3;
        zzkcVar = this.f17840h.f18163f;
        zzkcVar.e0();
        if (this.f17838f.y() == null) {
            zzkcVar3 = this.f17840h.f18163f;
            zzkcVar3.O(this.f17838f, this.f17839g);
        } else {
            zzkcVar2 = this.f17840h.f18163f;
            zzkcVar2.v(this.f17838f, this.f17839g);
        }
    }
}
