package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class w4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f18002f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f18003g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w4(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f18003g = zzhcVar;
        this.f18002f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18002f) {
            try {
                this.f18002f.set(Boolean.valueOf(this.f18003g.n().F(this.f18003g.q().C())));
            } finally {
                this.f18002f.notify();
            }
        }
    }
}
