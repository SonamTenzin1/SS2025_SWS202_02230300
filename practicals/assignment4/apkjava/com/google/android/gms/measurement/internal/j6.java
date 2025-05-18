package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzn;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class j6 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f17832f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f17833g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ boolean f17834h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzm f17835i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzn f17836j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzik f17837k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j6(zzik zzikVar, String str, String str2, boolean z, zzm zzmVar, zzn zznVar) {
        this.f17837k = zzikVar;
        this.f17832f = str;
        this.f17833g = str2;
        this.f17834h = z;
        this.f17835i = zzmVar;
        this.f17836j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        Bundle bundle = new Bundle();
        try {
            zzelVar = this.f17837k.f18193d;
            if (zzelVar == null) {
                this.f17837k.h().H().c("Failed to get user properties", this.f17832f, this.f17833g);
                return;
            }
            Bundle B = zzkk.B(zzelVar.f3(this.f17832f, this.f17833g, this.f17834h, this.f17835i));
            this.f17837k.d0();
            this.f17837k.l().O(this.f17836j, B);
        } catch (RemoteException e2) {
            this.f17837k.h().H().c("Failed to get user properties", this.f17832f, e2);
        } finally {
            this.f17837k.l().O(this.f17836j, bundle);
        }
    }
}
