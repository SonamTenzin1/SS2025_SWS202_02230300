package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class f6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17759f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f17760g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzv f17761h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzm f17762i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzv f17763j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzik f17764k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f6(zzik zzikVar, boolean z, boolean z2, zzv zzvVar, zzm zzmVar, zzv zzvVar2) {
        this.f17764k = zzikVar;
        this.f17759f = z;
        this.f17760g = z2;
        this.f17761h = zzvVar;
        this.f17762i = zzmVar;
        this.f17763j = zzvVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f17764k.f18193d;
        if (zzelVar == null) {
            this.f17764k.h().H().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f17759f) {
            this.f17764k.M(zzelVar, this.f17760g ? null : this.f17761h, this.f17762i);
        } else {
            try {
                if (TextUtils.isEmpty(this.f17763j.f18240f)) {
                    zzelVar.h2(this.f17761h, this.f17762i);
                } else {
                    zzelVar.R6(this.f17761h);
                }
            } catch (RemoteException e2) {
                this.f17764k.h().H().b("Failed to send conditional user property to the service", e2);
            }
        }
        this.f17764k.d0();
    }
}
