package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
final class z extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f17294j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzk f17295k;
    private final /* synthetic */ zzx.c l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(zzx.c cVar, Activity activity, zzk zzkVar) {
        super(zzx.this);
        this.l = cVar;
        this.f17294j = activity;
        this.f17295k = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = zzx.this.p;
        zzmVar.onActivitySaveInstanceState(ObjectWrapper.E0(this.f17294j), this.f17295k, this.f17582g);
    }
}
