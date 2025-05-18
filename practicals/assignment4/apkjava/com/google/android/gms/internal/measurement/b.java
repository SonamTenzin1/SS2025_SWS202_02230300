package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class b extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17127j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17128k;
    private final /* synthetic */ zzk l;
    private final /* synthetic */ zzx m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(zzx zzxVar, String str, String str2, zzk zzkVar) {
        super(zzxVar);
        this.m = zzxVar;
        this.f17127j = str;
        this.f17128k = str2;
        this.l = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.m.p;
        zzmVar.getConditionalUserProperties(this.f17127j, this.f17128k, this.l);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.l.J(null);
    }
}
