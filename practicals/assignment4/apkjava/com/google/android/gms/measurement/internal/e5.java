package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class e5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f17745f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17746g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e5(zzhc zzhcVar, AtomicReference atomicReference) {
        this.f17746g = zzhcVar;
        this.f17745f = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f17745f) {
            try {
                this.f17745f.set(this.f17746g.n().H(this.f17746g.q().C()));
            } finally {
                this.f17745f.notify();
            }
        }
    }
}
