package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13223f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13224g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzbcd f13225h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q7(zzbcd zzbcdVar, String str, String str2) {
        this.f13225h = zzbcdVar;
        this.f13223f = str;
        this.f13224g = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbcn zzbcnVar;
        zzbcn zzbcnVar2;
        zzbcnVar = this.f13225h.w;
        if (zzbcnVar != null) {
            zzbcnVar2 = this.f13225h.w;
            zzbcnVar2.b(this.f13223f, this.f13224g);
        }
    }
}
