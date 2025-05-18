package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzj;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class f {
    private static volatile Handler a;

    /* renamed from: b, reason: collision with root package name */
    private final s4 f17750b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f17751c;

    /* renamed from: d, reason: collision with root package name */
    private volatile long f17752d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(s4 s4Var) {
        Preconditions.k(s4Var);
        this.f17750b = s4Var;
        this.f17751c = new g(this, s4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(f fVar, long j2) {
        fVar.f17752d = 0L;
        return 0L;
    }

    private final Handler f() {
        Handler handler;
        if (a != null) {
            return a;
        }
        synchronized (f.class) {
            if (a == null) {
                a = new zzj(this.f17750b.f().getMainLooper());
            }
            handler = a;
        }
        return handler;
    }

    public abstract void b();

    public final void c(long j2) {
        e();
        if (j2 >= 0) {
            this.f17752d = this.f17750b.j().a();
            if (f().postDelayed(this.f17751c, j2)) {
                return;
            }
            this.f17750b.h().H().b("Failed to schedule delayed post. time", Long.valueOf(j2));
        }
    }

    public final boolean d() {
        return this.f17752d != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.f17752d = 0L;
        f().removeCallbacks(this.f17751c);
    }
}
