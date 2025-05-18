package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class jz implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f12842f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f12843g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ float f12844h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzhd f12845i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jz(zzhd zzhdVar, int i2, int i3, float f2) {
        this.f12845i = zzhdVar;
        this.f12842f = i2;
        this.f12843g = i3;
        this.f12844h = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhh zzhhVar;
        zzhhVar = this.f12845i.H;
        zzhhVar.e(this.f12842f, this.f12843g, this.f12844h);
    }
}
