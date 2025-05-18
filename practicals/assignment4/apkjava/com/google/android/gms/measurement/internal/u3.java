package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
final class u3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzfx f17973f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzet f17974g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u3(zzfn zzfnVar, zzfx zzfxVar, zzet zzetVar) {
        this.f17973f = zzfxVar;
        this.f17974g = zzetVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f17973f.E() == null) {
            this.f17974g.H().a("Install Referrer Reporter is null");
            return;
        }
        zzfm E = this.f17973f.E();
        E.a.r();
        E.b(E.a.f().getPackageName());
    }
}
