package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* loaded from: classes2.dex */
final class k6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzn f17843f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17844g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17845h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f17846i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k6(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zznVar, String str, String str2) {
        this.f17846i = appMeasurementDynamiteService;
        this.f17843f = zznVar;
        this.f17844g = str;
        this.f17845h = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17846i.f17687f.R().I(this.f17843f, this.f17844g, this.f17845h);
    }
}
