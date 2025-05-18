package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class o4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzv f17894f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f17895g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17896h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o4(zzgc zzgcVar, zzv zzvVar, zzm zzmVar) {
        this.f17896h = zzgcVar;
        this.f17894f = zzvVar;
        this.f17895g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkc zzkcVar3;
        zzkcVar = this.f17896h.f18163f;
        zzkcVar.e0();
        if (this.f17894f.f18242h.y() == null) {
            zzkcVar3 = this.f17896h.f18163f;
            zzkcVar3.R(this.f17894f, this.f17895g);
        } else {
            zzkcVar2 = this.f17896h.f18163f;
            zzkcVar2.y(this.f17894f, this.f17895g);
        }
    }
}
