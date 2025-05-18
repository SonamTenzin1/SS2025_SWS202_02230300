package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class y50 extends h60<zzaqg> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Activity f13611b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzyh f13612c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y50(zzyh zzyhVar, Activity activity) {
        this.f13612c = zzyhVar;
        this.f13611b = activity;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaqg a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zzf(ObjectWrapper.E0(this.f13611b));
    }

    @Override // com.google.android.gms.internal.ads.h60
    protected final /* synthetic */ zzaqg c() {
        zzyh.d(this.f13611b, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaqg d() throws RemoteException {
        zzaqf zzaqfVar;
        zzaqfVar = this.f13612c.f17000g;
        return zzaqfVar.c(this.f13611b);
    }
}
