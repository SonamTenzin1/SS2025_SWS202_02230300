package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
final class y extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f17290j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx.c f17291k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(zzx.c cVar, Activity activity) {
        super(zzx.this);
        this.f17291k = cVar;
        this.f17290j = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = zzx.this.p;
        zzmVar.onActivityDestroyed(ObjectWrapper.E0(this.f17290j), this.f17582g);
    }
}
