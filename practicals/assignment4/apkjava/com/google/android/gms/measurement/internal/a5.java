package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
final class a5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzgx f17694f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17695g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a5(zzhc zzhcVar, zzgx zzgxVar) {
        this.f17695g = zzhcVar;
        this.f17694f = zzgxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17695g.J(this.f17694f);
    }
}
