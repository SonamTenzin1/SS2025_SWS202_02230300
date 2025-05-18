package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class d6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17738f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzik f17739g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d6(zzik zzikVar, zzm zzmVar) {
        this.f17739g = zzikVar;
        this.f17738f = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f17739g.f18193d;
        if (zzelVar == null) {
            this.f17739g.h().H().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzelVar.U3(this.f17738f);
            this.f17739g.d0();
        } catch (RemoteException e2) {
            this.f17739g.h().H().b("Failed to send measurementEnabled to the service", e2);
        }
    }
}
