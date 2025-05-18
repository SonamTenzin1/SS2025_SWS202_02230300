package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class b6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzan f17707f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17708g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzn f17709h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzik f17710i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b6(zzik zzikVar, zzan zzanVar, String str, zzn zznVar) {
        this.f17710i = zzikVar;
        this.f17707f = zzanVar;
        this.f17708g = str;
        this.f17709h = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        try {
            zzelVar = this.f17710i.f18193d;
            if (zzelVar == null) {
                this.f17710i.h().H().a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] T1 = zzelVar.T1(this.f17707f, this.f17708g);
            this.f17710i.d0();
            this.f17710i.l().S(this.f17709h, T1);
        } catch (RemoteException e2) {
            this.f17710i.h().H().b("Failed to send event to the service to bundle", e2);
        } finally {
            this.f17710i.l().S(this.f17709h, null);
        }
    }
}
