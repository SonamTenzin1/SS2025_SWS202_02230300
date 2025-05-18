package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Context f12565f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzaxi f12566g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f5(zzaxi zzaxiVar, Context context) {
        this.f12566g = zzaxiVar;
        this.f12565f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.f12566g.f14258e;
        synchronized (obj) {
            this.f12566g.f14259f = zzaxi.w(this.f12565f);
            obj2 = this.f12566g.f14258e;
            obj2.notifyAll();
        }
    }
}
