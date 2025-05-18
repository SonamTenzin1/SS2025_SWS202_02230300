package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class w5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f18004f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzkj f18005g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzm f18006h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzik f18007i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w5(zzik zzikVar, boolean z, zzkj zzkjVar, zzm zzmVar) {
        this.f18007i = zzikVar;
        this.f18004f = z;
        this.f18005g = zzkjVar;
        this.f18006h = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f18007i.f18193d;
        if (zzelVar == null) {
            this.f18007i.h().H().a("Discarding data. Failed to set user attribute");
        } else {
            this.f18007i.M(zzelVar, this.f18004f ? null : this.f18005g, this.f18006h);
            this.f18007i.d0();
        }
    }
}
