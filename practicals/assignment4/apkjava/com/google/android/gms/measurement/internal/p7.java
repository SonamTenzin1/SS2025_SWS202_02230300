package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* loaded from: classes2.dex */
final class p7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzn f17910f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f17911g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zznVar) {
        this.f17911g = appMeasurementDynamiteService;
        this.f17910f = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17911g.f17687f.I().R(this.f17910f, this.f17911g.f17687f.o());
    }
}
