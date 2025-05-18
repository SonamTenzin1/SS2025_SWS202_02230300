package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class x5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f18022f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzm f18023g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzik f18024h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x5(zzik zzikVar, AtomicReference atomicReference, zzm zzmVar) {
        this.f18024h = zzikVar;
        this.f18022f = atomicReference;
        this.f18023g = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.f18022f) {
            try {
                try {
                    zzelVar = this.f18024h.f18193d;
                } catch (RemoteException e2) {
                    this.f18024h.h().H().b("Failed to get app instance id", e2);
                }
                if (zzelVar == null) {
                    this.f18024h.h().H().a("Failed to get app instance id");
                    return;
                }
                this.f18022f.set(zzelVar.P4(this.f18023g));
                String str = (String) this.f18022f.get();
                if (str != null) {
                    this.f18024h.p().O(str);
                    this.f18024h.m().m.b(str);
                }
                this.f18024h.d0();
                this.f18022f.notify();
            } finally {
                this.f18022f.notify();
            }
        }
    }
}
