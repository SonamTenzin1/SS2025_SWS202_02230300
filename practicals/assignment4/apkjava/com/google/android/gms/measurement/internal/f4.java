package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class f4 implements Callable<List<m7>> {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17753f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17754g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17755h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzgc f17756i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f4(zzgc zzgcVar, String str, String str2, String str3) {
        this.f17756i = zzgcVar;
        this.f17753f = str;
        this.f17754g = str2;
        this.f17755h = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<m7> call() throws Exception {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        zzkcVar = this.f17756i.f18163f;
        zzkcVar.e0();
        zzkcVar2 = this.f17756i.f18163f;
        return zzkcVar2.W().K(this.f17753f, this.f17754g, this.f17755h);
    }
}
