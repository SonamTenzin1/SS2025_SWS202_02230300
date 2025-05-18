package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkn;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class a7 {
    private final f a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjl f17699b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a7(zzjl zzjlVar) {
        this.f17699b = zzjlVar;
        this.a = new d7(this, zzjlVar.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j2) {
        this.f17699b.d();
        if (this.f17699b.a.p()) {
            if (this.f17699b.n().B(this.f17699b.q().C(), zzap.c0)) {
                this.f17699b.m().z.a(false);
            }
            if (this.f17699b.n().R(this.f17699b.q().C())) {
                b(this.f17699b.j().a(), false);
                return;
            }
            this.a.e();
            if (this.f17699b.m().x(this.f17699b.j().a())) {
                this.f17699b.m().s.a(true);
                this.f17699b.m().x.b(0L);
            }
            if (this.f17699b.m().s.b()) {
                this.a.c(Math.max(0L, this.f17699b.m().q.a() - this.f17699b.m().x.a()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j2, boolean z) {
        this.f17699b.d();
        this.f17699b.H();
        if (this.f17699b.m().x(j2)) {
            this.f17699b.m().s.a(true);
            this.f17699b.m().x.b(0L);
        }
        if (z && this.f17699b.n().S(this.f17699b.q().C())) {
            this.f17699b.m().w.b(j2);
        }
        if (this.f17699b.m().s.b()) {
            c(j2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void c(long j2, boolean z) {
        this.f17699b.d();
        if (zzkn.b() && this.f17699b.n().B(this.f17699b.q().C(), zzap.g0)) {
            if (!this.f17699b.a.p()) {
                return;
            } else {
                this.f17699b.m().w.b(j2);
            }
        }
        this.f17699b.h().P().b("Session started, time", Long.valueOf(this.f17699b.j().b()));
        Long valueOf = this.f17699b.n().P(this.f17699b.q().C()) ? Long.valueOf(j2 / 1000) : null;
        this.f17699b.p().V("auto", "_sid", valueOf, j2);
        this.f17699b.m().s.a(false);
        Bundle bundle = new Bundle();
        if (this.f17699b.n().P(this.f17699b.q().C())) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        if (this.f17699b.n().r(zzap.P0) && z) {
            bundle.putLong("_aib", 1L);
        }
        this.f17699b.p().P("auto", "_s", j2, bundle);
        if (zzkb.b() && this.f17699b.n().r(zzap.X0)) {
            String a = this.f17699b.m().C.a();
            if (!TextUtils.isEmpty(a)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a);
                this.f17699b.p().P("auto", "_ssr", j2, bundle2);
            }
        }
        if (zzkn.b() && this.f17699b.n().B(this.f17699b.q().C(), zzap.g0)) {
            return;
        }
        this.f17699b.m().w.b(j2);
    }
}
