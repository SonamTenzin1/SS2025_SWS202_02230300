package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@zzard
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbcy {

    /* renamed from: b, reason: collision with root package name */
    private long f14356b;
    private final long a = TimeUnit.MILLISECONDS.toNanos(((Long) zzyt.e().c(zzacu.L)).longValue());

    /* renamed from: c, reason: collision with root package name */
    private boolean f14357c = true;

    public final void a(SurfaceTexture surfaceTexture, zzbcn zzbcnVar) {
        if (zzbcnVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.f14357c || Math.abs(timestamp - this.f14356b) >= this.a) {
            this.f14357c = false;
            this.f14356b = timestamp;
            zzaxi.a.post(new b8(this, zzbcnVar));
        }
    }

    public final void b() {
        this.f14357c = true;
    }
}
