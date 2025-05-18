package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class i extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzk f17174j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17175k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(zzx zzxVar, zzk zzkVar) {
        super(zzxVar);
        this.f17175k = zzxVar;
        this.f17174j = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.f17175k.p;
        zzmVar.generateEventId(this.f17174j);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17174j.J(null);
    }
}
