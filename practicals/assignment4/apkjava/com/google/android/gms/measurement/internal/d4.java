package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class d4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzv f17730f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17731g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d4(zzgc zzgcVar, zzv zzvVar) {
        this.f17731g = zzgcVar;
        this.f17730f = zzvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkc zzkcVar3;
        zzkcVar = this.f17731g.f18163f;
        zzkcVar.e0();
        if (this.f17730f.f18242h.y() == null) {
            zzkcVar3 = this.f17731g.f18163f;
            zzkcVar3.Q(this.f17730f);
        } else {
            zzkcVar2 = this.f17731g.f18163f;
            zzkcVar2.x(this.f17730f);
        }
    }
}
