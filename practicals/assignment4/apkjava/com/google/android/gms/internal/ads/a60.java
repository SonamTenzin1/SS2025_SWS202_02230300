package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a60 extends h60<zzzk> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f12223b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzyd f12224c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f12225d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzamp f12226e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzyh f12227f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a60(zzyh zzyhVar, Context context, zzyd zzydVar, String str, zzamp zzampVar) {
        this.f12227f = zzyhVar;
        this.f12223b = context;
        this.f12224c = zzydVar;
        this.f12225d = str;
        this.f12226e = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zzb(ObjectWrapper.E0(this.f12223b), this.f12224c, this.f12225d, this.f12226e, 15000000);
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk c() {
        zzyh.d(this.f12223b, "interstitial");
        return new zzabp();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk d() throws RemoteException {
        zzxx zzxxVar;
        zzxxVar = this.f12227f.a;
        return zzxxVar.c(this.f12223b, this.f12224c, this.f12225d, this.f12226e, 2);
    }
}
