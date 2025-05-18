package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class t7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13348f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t7(zzbcd zzbcdVar) {
        this.f13348f = zzbcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcn zzbcnVar3;
        zzbcnVar = this.f13348f.w;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f13348f.w;
            zzbcnVar2.e();
            zzbcnVar3 = this.f13348f.w;
            zzbcnVar3.g();
        }
    }
}
