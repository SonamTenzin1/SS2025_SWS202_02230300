package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class c4 implements Callable<List<m7>> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17720f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17721g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17722h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzgc f17723i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c4(zzgc zzgcVar, zzm zzmVar, String str, String str2) {
        this.f17723i = zzgcVar;
        this.f17720f = zzmVar;
        this.f17721g = str;
        this.f17722h = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<m7> call() throws Exception {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17723i.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17723i.f18163f;
        return zzkcVar2.W().K(this.f17720f.f18234f, this.f17721g, this.f17722h);
    }
}
