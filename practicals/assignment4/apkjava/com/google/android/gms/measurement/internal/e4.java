package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class e4 implements Callable<List<zzv>> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17741f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17742g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17743h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzgc f17744i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e4(zzgc zzgcVar, zzm zzmVar, String str, String str2) {
        this.f17744i = zzgcVar;
        this.f17741f = zzmVar;
        this.f17742g = str;
        this.f17743h = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzv> call() throws Exception {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17744i.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17744i.f18163f;
        return zzkcVar2.W().k0(this.f17741f.f18234f, this.f17742g, this.f17743h);
    }
}
