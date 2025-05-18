package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class l extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Bundle f17204j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzk f17205k;
    private final /* synthetic */ zzx l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(zzx zzxVar, Bundle bundle, zzk zzkVar) {
        super(zzxVar);
        this.l = zzxVar;
        this.f17204j = bundle;
        this.f17205k = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.l.p;
        zzmVar.performAction(this.f17204j, this.f17205k, this.f17581f);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17205k.J(null);
    }
}
