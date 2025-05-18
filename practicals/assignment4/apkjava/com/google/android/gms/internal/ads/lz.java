package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class lz implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f12943f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f12944g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzhd f12945h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lz(zzhd zzhdVar, int i2, long j2) {
        this.f12945h = zzhdVar;
        this.f12943f = i2;
        this.f12944g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhh zzhhVar;
        zzhhVar = this.f12945h.H;
        zzhhVar.b(this.f12943f, this.f12944g);
    }
}
