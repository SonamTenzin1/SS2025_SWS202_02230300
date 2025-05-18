package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class d extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17144j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17145k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(zzx zzxVar, String str) {
        super(zzxVar);
        this.f17145k = zzxVar;
        this.f17144j = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.f17145k.p;
        zzmVar.beginAdUnitExposure(this.f17144j, this.f17582g);
    }
}
