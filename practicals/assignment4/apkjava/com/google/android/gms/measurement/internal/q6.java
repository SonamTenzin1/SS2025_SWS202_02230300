package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
final class q6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzjc f17918f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q6(zzjc zzjcVar) {
        this.f17918f = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzik zzikVar = this.f17918f.f18201h;
        Context f2 = this.f17918f.f18201h.f();
        this.f17918f.f18201h.G();
        zzikVar.E(new ComponentName(f2, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
