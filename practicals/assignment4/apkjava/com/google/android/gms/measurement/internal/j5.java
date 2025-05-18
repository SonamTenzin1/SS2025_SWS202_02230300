package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class j5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17830f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17831g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j5(zzhc zzhcVar, long j2) {
        this.f17831g = zzhcVar;
        this.f17830f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17831g.m().q.b(this.f17830f);
        this.f17831g.h().O().b("Minimum session duration set", Long.valueOf(this.f17830f));
    }
}
