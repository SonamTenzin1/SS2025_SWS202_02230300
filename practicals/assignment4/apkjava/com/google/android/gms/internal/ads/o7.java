package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class o7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13090f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o7(zzbcd zzbcdVar) {
        this.f13090f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f13090f.w;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f13090f.w;
            zzbcnVar2.a();
        }
    }
}
