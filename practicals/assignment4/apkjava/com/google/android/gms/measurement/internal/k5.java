package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class k5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17841f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17842g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k5(zzhc zzhcVar, boolean z) {
        this.f17842g = zzhcVar;
        this.f17841f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean p = this.f17842g.a.p();
        boolean o = this.f17842g.a.o();
        this.f17842g.a.n(this.f17841f);
        if (o == this.f17841f) {
            this.f17842g.a.h().P().b("Default data collection state already set to", Boolean.valueOf(this.f17841f));
        }
        if (this.f17842g.a.p() == p || this.f17842g.a.p() != this.f17842g.a.o()) {
            this.f17842g.a.h().M().c("Default data collection is different than actual status", Boolean.valueOf(this.f17841f), Boolean.valueOf(p));
        }
        this.f17842g.l0();
    }
}
