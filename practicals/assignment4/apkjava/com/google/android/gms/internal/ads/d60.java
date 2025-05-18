package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d60 extends h60<zzaem> {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FrameLayout f12454b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FrameLayout f12455c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Context f12456d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzyh f12457e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d60(zzyh zzyhVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.f12457e = zzyhVar;
        this.f12454b = frameLayout;
        this.f12455c = frameLayout2;
        this.f12456d = context;
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaem a(zzzv zzzvVar) throws RemoteException {
        return zzzvVar.zzc(ObjectWrapper.E0(this.f12454b), ObjectWrapper.E0(this.f12455c));
    }

    @Override // com.google.android.gms.internal.ads.h60
    protected final /* synthetic */ zzaem c() {
        zzyh.d(this.f12456d, "native_ad_view_delegate");
        return new zzabt();
    }

    @Override // com.google.android.gms.internal.ads.h60
    public final /* synthetic */ zzaem d() throws RemoteException {
        zzagk zzagkVar;
        zzagkVar = this.f12457e.f16997d;
        return zzagkVar.c(this.f12456d, this.f12454b, this.f12455c);
    }
}
