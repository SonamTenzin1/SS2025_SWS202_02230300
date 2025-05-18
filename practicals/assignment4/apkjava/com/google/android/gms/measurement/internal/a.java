package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17691f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f17692g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzb f17693h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(zzb zzbVar, String str, long j2) {
        this.f17693h = zzbVar;
        this.f17691f = str;
        this.f17692g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17693h.E(this.f17691f, this.f17692g);
    }
}
