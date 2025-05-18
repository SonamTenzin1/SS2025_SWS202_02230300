package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class m extends zzx.a {

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17217k;
    private final /* synthetic */ Object l;
    private final /* synthetic */ zzx o;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ int f17216j = 5;
    private final /* synthetic */ Object m = null;
    private final /* synthetic */ Object n = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(zzx zzxVar, boolean z, int i2, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.o = zzxVar;
        this.f17217k = str;
        this.l = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.o.p;
        zzmVar.logHealthData(this.f17216j, this.f17217k, ObjectWrapper.E0(this.l), ObjectWrapper.E0(this.m), ObjectWrapper.E0(this.n));
    }
}
