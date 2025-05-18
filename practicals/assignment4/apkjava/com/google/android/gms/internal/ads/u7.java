package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class u7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13389f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u7(zzbcd zzbcdVar) {
        this.f13389f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f13389f.w;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f13389f.w;
            zzbcnVar2.i();
        }
    }
}
