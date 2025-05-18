package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class f5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17757f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17758g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f5(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f17758g = zzhcVar;
        this.f17757f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17757f) {
            try {
                this.f17757f.set(Integer.valueOf(this.f17758g.n().t(this.f17758g.q().C(), zzap.R)));
            } finally {
                this.f17757f.notify();
            }
        }
    }
}
