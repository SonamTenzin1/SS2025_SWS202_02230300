package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13606f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13607g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzto f13608h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y30(zzto zztoVar, int i2, long j2) {
        this.f13608h = zztoVar;
        this.f13606f = i2;
        this.f13607g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.f13608h.f16775b;
        zztnVar.b(this.f13606f, this.f13607g);
    }
}
