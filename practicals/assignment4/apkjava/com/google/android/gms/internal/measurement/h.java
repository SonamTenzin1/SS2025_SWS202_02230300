package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class h extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzk f17166j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17167k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(zzx zzxVar, zzk zzkVar) {
        super(zzxVar);
        this.f17167k = zzxVar;
        this.f17166j = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.f17167k.p;
        zzmVar.getCurrentScreenName(this.f17166j);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17166j.J(null);
    }
}
