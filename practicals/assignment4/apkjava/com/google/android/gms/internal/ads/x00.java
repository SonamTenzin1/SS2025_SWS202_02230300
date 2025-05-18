package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x00 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13537f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13538g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f13539h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzma f13540i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x00(zzma zzmaVar, int i2, long j2, long j3) {
        this.f13540i = zzmaVar;
        this.f13537f = i2;
        this.f13538g = j2;
        this.f13539h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.f13540i.f16456b;
        zzlzVar.c(this.f13537f, this.f13538g, this.f13539h);
    }
}
