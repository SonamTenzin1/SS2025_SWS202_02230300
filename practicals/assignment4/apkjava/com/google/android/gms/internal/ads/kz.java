package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class kz implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Surface f12897f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhd f12898g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kz(zzhd zzhdVar, Surface surface) {
        this.f12898g = zzhdVar;
        this.f12897f = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhh zzhhVar;
        zzhhVar = this.f12898g.H;
        zzhhVar.g(this.f12897f);
    }
}
