package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class m5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17868f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17869g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m5(zzhc zzhcVar, long j2) {
        this.f17869g = zzhcVar;
        this.f17868f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17869g.m().r.b(this.f17868f);
        this.f17869g.h().O().b("Session timeout duration set", Long.valueOf(this.f17868f));
    }
}
