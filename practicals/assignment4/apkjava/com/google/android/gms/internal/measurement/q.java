package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class q extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17243j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17244k;
    private final /* synthetic */ Object l;
    private final /* synthetic */ boolean m;
    private final /* synthetic */ zzx n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(zzx zzxVar, String str, String str2, Object obj, boolean z) {
        super(zzxVar);
        this.n = zzxVar;
        this.f17243j = str;
        this.f17244k = str2;
        this.l = obj;
        this.m = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.n.p;
        zzmVar.setUserProperty(this.f17243j, this.f17244k, ObjectWrapper.E0(this.l), this.m, this.f17581f);
    }
}
