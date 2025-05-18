package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class r extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Long f17246j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17247k;
    private final /* synthetic */ String l;
    private final /* synthetic */ Bundle m;
    private final /* synthetic */ boolean n;
    private final /* synthetic */ boolean o;
    private final /* synthetic */ zzx p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(zzx zzxVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzxVar);
        this.p = zzxVar;
        this.f17246j = l;
        this.f17247k = str;
        this.l = str2;
        this.m = bundle;
        this.n = z;
        this.o = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        Long l = this.f17246j;
        long longValue = l == null ? this.f17581f : l.longValue();
        zzmVar = this.p.p;
        zzmVar.logEvent(this.f17247k, this.l, this.m, this.n, this.o, longValue);
    }
}
