package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class s7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13316f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f13317g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13318h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s7(zzbcd zzbcdVar, int i2, int i3) {
        this.f13318h = zzbcdVar;
        this.f13316f = i2;
        this.f13317g = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f13318h.w;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f13318h.w;
            zzbcnVar2.d(this.f13316f, this.f13317g);
        }
    }
}
