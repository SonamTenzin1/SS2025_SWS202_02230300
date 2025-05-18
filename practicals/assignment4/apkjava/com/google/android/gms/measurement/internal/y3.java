package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class y3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzgz f18026f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzfx f18027g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y3(zzfx zzfxVar, zzgz zzgzVar) {
        this.f18027g = zzfxVar;
        this.f18026f = zzgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18027g.l(this.f18026f);
        this.f18027g.c();
    }
}
