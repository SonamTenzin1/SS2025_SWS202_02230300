package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class h4 implements Callable<List<zzv>> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17800f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17801g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17802h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzgc f17803i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h4(zzgc zzgcVar, String str, String str2, String str3) {
        this.f17803i = zzgcVar;
        this.f17800f = str;
        this.f17801g = str2;
        this.f17802h = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzv> call() throws Exception {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17803i.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17803i.f18163f;
        return zzkcVar2.W().k0(this.f17800f, this.f17801g, this.f17802h);
    }
}
