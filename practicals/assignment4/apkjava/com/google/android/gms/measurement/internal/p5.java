package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* loaded from: classes2.dex */
final class p5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzn f17907f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f17908g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p5(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zznVar) {
        this.f17908g = appMeasurementDynamiteService;
        this.f17907f = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17908g.f17687f.R().F(this.f17907f);
    }
}
