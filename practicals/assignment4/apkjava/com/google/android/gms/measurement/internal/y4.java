package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class y4 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ long f18028f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f18029g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y4(zzhc zzhcVar, long j2) {
        this.f18029g = zzhcVar;
        this.f18028f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhc zzhcVar = this.f18029g;
        long j2 = this.f18028f;
        zzhcVar.d();
        zzhcVar.b();
        zzhcVar.x();
        zzhcVar.h().O().a("Resetting analytics data (FE)");
        zzjl u = zzhcVar.u();
        u.d();
        u.f18204e.a();
        if (zzhcVar.n().K(zzhcVar.q().C())) {
            zzhcVar.m().f17927k.b(j2);
        }
        if (!TextUtils.isEmpty(zzhcVar.m().C.a())) {
            zzhcVar.m().C.b(null);
        }
        boolean p = zzhcVar.a.p();
        if (!zzhcVar.n().I()) {
            zzhcVar.m().D(!p);
        }
        zzhcVar.r().X();
        zzhcVar.f18181h = !p;
        this.f18029g.r().S(new AtomicReference<>());
    }
}
