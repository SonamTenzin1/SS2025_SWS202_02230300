package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
final class ok extends zzaok {

    /* renamed from: f, reason: collision with root package name */
    private zzcjy<zzaov, zzcla> f13105f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzckm f13106g;

    private ok(zzckm zzckmVar, zzcjy zzcjyVar) {
        this.f13106g = zzckmVar;
        this.f13105f = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void c1(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzckm.c(this.f13106g, (View) ObjectWrapper.k0(iObjectWrapper));
        this.f13105f.f15314c.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzaoj
    public final void p(String str) throws RemoteException {
        this.f13105f.f15314c.onAdFailedToLoad(0);
    }
}
