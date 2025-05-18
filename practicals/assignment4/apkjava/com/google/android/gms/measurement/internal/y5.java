package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class y5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f18030f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzik f18031g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y5(zzik zzikVar, zzm zzmVar) {
        this.f18031g = zzikVar;
        this.f18030f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f18031g.f18193d;
        if (zzelVar == null) {
            this.f18031g.h().H().a("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzelVar.r2(this.f18030f);
        } catch (RemoteException e2) {
            this.f18031g.h().H().b("Failed to reset data on the service", e2);
        }
        this.f18031g.d0();
    }
}
