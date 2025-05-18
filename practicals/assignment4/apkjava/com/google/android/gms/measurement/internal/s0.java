package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class s0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17944f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzb f17945g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(zzb zzbVar, long j2) {
        this.f17945g = zzbVar;
        this.f17944f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17945g.B(this.f17944f);
    }
}
