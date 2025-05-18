package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class v7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13445f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v7(zzbcd zzbcdVar) {
        this.f13445f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f13445f.w;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f13445f.w;
            zzbcnVar2.e();
        }
    }
}
