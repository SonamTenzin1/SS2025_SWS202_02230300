package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class c6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzig f17726f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzik f17727g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c6(zzik zzikVar, zzig zzigVar) {
        this.f17727g = zzikVar;
        this.f17726f = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f17727g.f18193d;
        if (zzelVar == null) {
            this.f17727g.h().H().a("Failed to send current screen to service");
            return;
        }
        try {
            zzig zzigVar = this.f17726f;
            if (zzigVar == null) {
                zzelVar.j3(0L, null, null, this.f17727g.f().getPackageName());
            } else {
                zzelVar.j3(zzigVar.f18190c, zzigVar.a, zzigVar.f18189b, this.f17727g.f().getPackageName());
            }
            this.f17727g.d0();
        } catch (RemoteException e2) {
            this.f17727g.h().H().b("Failed to send current screen to the service", e2);
        }
    }
}
