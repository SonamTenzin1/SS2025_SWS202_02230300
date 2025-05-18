package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class a6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17696f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzn f17697g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzik f17698h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a6(zzik zzikVar, zzm zzmVar, zzn zznVar) {
        this.f17698h = zzikVar;
        this.f17696f = zzmVar;
        this.f17697g = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        try {
            zzelVar = this.f17698h.f18193d;
            if (zzelVar == null) {
                this.f17698h.h().H().a("Failed to get app instance id");
                return;
            }
            String P4 = zzelVar.P4(this.f17696f);
            if (P4 != null) {
                this.f17698h.p().O(P4);
                this.f17698h.m().m.b(P4);
            }
            this.f17698h.d0();
            this.f17698h.l().P(this.f17697g, P4);
        } catch (RemoteException e2) {
            this.f17698h.h().H().b("Failed to get app instance id", e2);
        } finally {
            this.f17698h.l().P(this.f17697g, null);
        }
    }
}
