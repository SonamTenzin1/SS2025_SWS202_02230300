package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e60 extends h60<zzaer> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ View f12508b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ HashMap f12509c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ HashMap f12510d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzyh f12511e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e60(zzyh zzyhVar, View view, HashMap hashMap, HashMap hashMap2) {
        this.f12511e = zzyhVar;
        this.f12508b = view;
        this.f12509c = hashMap;
        this.f12510d = hashMap2;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaer a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.E0(this.f12508b), ObjectWrapper.E0(this.f12509c), ObjectWrapper.E0(this.f12510d));
    }

    @Override // com.google.android.gms.internal.ads.h60
    protected final /* synthetic */ zzaer c() {
        zzyh.d(this.f12508b.getContext(), "native_ad_view_holder_delegate");
        return new zzabu();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaer d() throws RemoteException {
        zzagl zzaglVar;
        zzaglVar = this.f12511e.f17001h;
        return zzaglVar.c(this.f12508b, this.f12509c, this.f12510d);
    }
}
