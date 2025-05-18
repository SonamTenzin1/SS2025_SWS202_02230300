package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class i5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17817f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17818g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i5(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f17818g = zzhcVar;
        this.f17817f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17817f) {
            try {
                this.f17817f.set(Double.valueOf(this.f17818g.n().v(this.f17818g.q().C(), zzap.S)));
            } finally {
                this.f17817f.notify();
            }
        }
    }
}
