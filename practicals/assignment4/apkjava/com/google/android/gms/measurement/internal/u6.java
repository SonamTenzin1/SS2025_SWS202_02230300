package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
final class u6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f17980f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzjl f17981g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u6(zzjl zzjlVar, long j2) {
        this.f17981g = zzjlVar;
        this.f17980f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjl.K(this.f17981g, this.f17980f);
    }
}
