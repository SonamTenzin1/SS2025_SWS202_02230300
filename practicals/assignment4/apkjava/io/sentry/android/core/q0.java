package io.sentry.android.core;

import android.os.SystemClock;
import io.sentry.f4;
import io.sentry.u4;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AppStartState.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class q0 {
    private static q0 a = new q0();

    /* renamed from: b, reason: collision with root package name */
    private Long f22252b;

    /* renamed from: c, reason: collision with root package name */
    private Long f22253c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f22254d = null;

    /* renamed from: e, reason: collision with root package name */
    private f4 f22255e;

    private q0() {
    }

    public static q0 e() {
        return a;
    }

    public f4 a() {
        Long b2;
        f4 d2 = d();
        if (d2 == null || (b2 = b()) == null) {
            return null;
        }
        return new u4(d2.x() + io.sentry.a1.h(b2.longValue()));
    }

    public synchronized Long b() {
        Long l;
        if (this.f22252b != null && (l = this.f22253c) != null && this.f22254d != null) {
            long longValue = l.longValue() - this.f22252b.longValue();
            if (longValue >= 60000) {
                return null;
            }
            return Long.valueOf(longValue);
        }
        return null;
    }

    public Long c() {
        return this.f22252b;
    }

    public f4 d() {
        return this.f22255e;
    }

    public Boolean f() {
        return this.f22254d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void g() {
        h(SystemClock.uptimeMillis());
    }

    void h(long j2) {
        this.f22253c = Long.valueOf(j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void i(long j2, f4 f4Var) {
        if (this.f22255e == null || this.f22252b == null) {
            this.f22255e = f4Var;
            this.f22252b = Long.valueOf(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void j(boolean z) {
        if (this.f22254d != null) {
            return;
        }
        this.f22254d = Boolean.valueOf(z);
    }
}
