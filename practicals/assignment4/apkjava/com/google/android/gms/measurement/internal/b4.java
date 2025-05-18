package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class b4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17700f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgc f17701g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b4(zzgc zzgcVar, zzm zzmVar) {
        this.f17701g = zzgcVar;
        this.f17700f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17701g.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17701g.f18163f;
        zzm zzmVar = this.f17700f;
        zzkcVar2.g().d();
        zzkcVar2.c0();
        Preconditions.g(zzmVar.f18234f);
        zzkcVar2.T(zzmVar);
    }
}
