package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
final class p4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17902f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17903g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17904h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f17905i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzgc f17906j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p4(zzgc zzgcVar, String str, String str2, String str3, long j2) {
        this.f17906j = zzgcVar;
        this.f17902f = str;
        this.f17903g = str2;
        this.f17904h = str3;
        this.f17905i = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc zzkcVar;
        zzkc zzkcVar2;
        String str = this.f17902f;
        if (str == null) {
            zzkcVar2 = this.f17906j.f18163f;
            zzkcVar2.g0().Q().K(this.f17903g, null);
        } else {
            zzig zzigVar = new zzig(this.f17904h, str, this.f17905i);
            zzkcVar = this.f17906j.f18163f;
            zzkcVar.g0().Q().K(this.f17903g, zzigVar);
        }
    }
}
