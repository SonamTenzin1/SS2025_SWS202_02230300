package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12910f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f12911g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzr f12912h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l30(zzr zzrVar, String str, long j2) {
        this.f12912h = zzrVar;
        this.f12910f = str;
        this.f12911g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzag.a aVar;
        zzag.a aVar2;
        aVar = this.f12912h.f16633f;
        aVar.a(this.f12910f, this.f12911g);
        aVar2 = this.f12912h.f16633f;
        aVar2.b(this.f12912h.toString());
    }
}
