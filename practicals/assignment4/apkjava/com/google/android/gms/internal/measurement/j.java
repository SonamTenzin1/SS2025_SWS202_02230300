package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class j extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17183j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17184k;
    private final /* synthetic */ boolean l;
    private final /* synthetic */ zzk m;
    private final /* synthetic */ zzx n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(zzx zzxVar, String str, String str2, boolean z, zzk zzkVar) {
        super(zzxVar);
        this.n = zzxVar;
        this.f17183j = str;
        this.f17184k = str2;
        this.l = z;
        this.m = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.n.p;
        zzmVar.getUserProperties(this.f17183j, this.f17184k, this.l, this.m);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.m.J(null);
    }
}
