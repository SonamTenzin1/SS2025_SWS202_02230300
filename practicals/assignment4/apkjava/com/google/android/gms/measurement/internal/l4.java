package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class l4 implements Callable<byte[]> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17848f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17849g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzgc f17850h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l4(zzgc zzgcVar, zzan zzanVar, String str) {
        this.f17850h = zzgcVar;
        this.f17848f = zzanVar;
        this.f17849g = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17850h.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17850h.f18163f;
        return zzkcVar2.Y().w(this.f17848f, this.f17849g);
    }
}
