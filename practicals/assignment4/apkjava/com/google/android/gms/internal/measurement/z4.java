package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class z4 extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17303j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17304k;
    private final /* synthetic */ Bundle l;
    private final /* synthetic */ zzx m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(zzx zzxVar, String str, String str2, Bundle bundle) {
        super(zzxVar);
        this.m = zzxVar;
        this.f17303j = str;
        this.f17304k = str2;
        this.l = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.m.p;
        zzmVar.clearConditionalUserProperty(this.f17303j, this.f17304k, this.l);
    }
}
