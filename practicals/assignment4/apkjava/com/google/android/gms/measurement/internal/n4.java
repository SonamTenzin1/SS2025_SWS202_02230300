package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class n4 implements Callable<List<m7>> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17882f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17883g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n4(zzgc zzgcVar, zzm zzmVar) {
        this.f17883g = zzgcVar;
        this.f17882f = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<m7> call() throws Exception {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17883g.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17883g.f18163f;
        return zzkcVar2.W().I(this.f17882f.f18234f);
    }
}
