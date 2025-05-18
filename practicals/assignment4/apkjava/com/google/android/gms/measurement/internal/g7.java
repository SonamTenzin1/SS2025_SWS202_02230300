package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.2.0 */
/* loaded from: classes2.dex */
final class g7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzn f17779f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17780g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f17781h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f17782i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f17783j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zznVar, String str, String str2, boolean z) {
        this.f17783j = appMeasurementDynamiteService;
        this.f17779f = zznVar;
        this.f17780g = str;
        this.f17781h = str2;
        this.f17782i = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17783j.f17687f.R().J(this.f17779f, this.f17780g, this.f17781h, this.f17782i);
    }
}
