package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class x4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f18017f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f18018g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Object f18019h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f18020i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzhc f18021j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x4(zzhc zzhcVar, String str, String str2, Object obj, long j2) {
        this.f18021j = zzhcVar;
        this.f18017f = str;
        this.f18018g = str2;
        this.f18019h = obj;
        this.f18020i = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18021j.V(this.f18017f, this.f18018g, this.f18019h, this.f18020i);
    }
}
