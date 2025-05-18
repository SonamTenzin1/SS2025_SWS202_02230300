package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class x6 {
    private final Runnable a = new Runnable(this) { // from class: com.google.android.gms.measurement.internal.w6

        /* renamed from: f, reason: collision with root package name */
        private final x6 f18008f;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f18008f = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final x6 x6Var = this.f18008f;
            x6Var.f18025b.g().z(new Runnable(x6Var) { // from class: com.google.android.gms.measurement.internal.z6

                /* renamed from: f, reason: collision with root package name */
                private final x6 f18050f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f18050f = x6Var;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    x6 x6Var2 = this.f18050f;
                    x6Var2.f18025b.d();
                    x6Var2.f18025b.h().O().a("Application backgrounded");
                    x6Var2.f18025b.p().u0("auto", "_ab", new Bundle());
                }
            });
        }
    };

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjl f18025b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x6(zzjl zzjlVar) {
        this.f18025b = zzjlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j2) {
        Handler handler;
        this.f18025b.d();
        if (this.f18025b.n().r(zzap.O0)) {
            handler = this.f18025b.f18202c;
            handler.removeCallbacks(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(long j2) {
        Handler handler;
        if (this.f18025b.n().r(zzap.O0)) {
            handler = this.f18025b.f18202c;
            handler.postDelayed(this.a, 2000L);
        }
    }
}
