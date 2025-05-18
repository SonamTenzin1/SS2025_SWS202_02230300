package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class m4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17866f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17867g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m4(zzgc zzgcVar, zzm zzmVar) {
        this.f17867g = zzgcVar;
        this.f17866f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17867g.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17867g.f18163f;
        zzkcVar2.P(this.f17866f);
    }
}
