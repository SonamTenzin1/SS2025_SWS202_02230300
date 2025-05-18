package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class s extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Bundle f17251j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17252k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(zzx zzxVar, Bundle bundle) {
        super(zzxVar);
        this.f17252k = zzxVar;
        this.f17251j = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.f17252k.p;
        zzmVar.setConditionalUserProperty(this.f17251j, this.f17581f);
    }
}
