package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class e extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17146j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17147k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zzx zzxVar, String str) {
        super(zzxVar);
        this.f17147k = zzxVar;
        this.f17146j = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.f17147k.p;
        zzmVar.endAdUnitExposure(this.f17146j, this.f17582g);
    }
}
