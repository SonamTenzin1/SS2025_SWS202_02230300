package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x50 extends h60<zzzk> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f13556b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzyd f13557c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f13558d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzamp f13559e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzyh f13560f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x50(zzyh zzyhVar, Context context, zzyd zzydVar, String str, zzamp zzampVar) {
        this.f13560f = zzyhVar;
        this.f13556b = context;
        this.f13557c = zzydVar;
        this.f13558d = str;
        this.f13559e = zzampVar;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zza(ObjectWrapper.E0(this.f13556b), this.f13557c, this.f13558d, this.f13559e, 15000000);
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk c() {
        zzyh.d(this.f13556b, "banner");
        return new zzabp();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzzk d() throws RemoteException {
        zzxx zzxxVar;
        zzxxVar = this.f13560f.a;
        return zzxxVar.c(this.f13556b, this.f13557c, this.f13558d, this.f13559e, 1);
    }
}
