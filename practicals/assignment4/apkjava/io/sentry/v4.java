package io.sentry;

import java.util.Date;

/* compiled from: SentryNanotimeDate.java */
/* loaded from: classes2.dex */
public final class v4 extends f4 {

    /* renamed from: f, reason: collision with root package name */
    private final Date f22772f;

    /* renamed from: g, reason: collision with root package name */
    private final long f22773g;

    public v4() {
        this(a1.c(), System.nanoTime());
    }

    private long y(v4 v4Var, v4 v4Var2) {
        return v4Var.x() + (v4Var2.f22773g - v4Var.f22773g);
    }

    @Override // io.sentry.f4, java.lang.Comparable
    /* renamed from: g */
    public int compareTo(f4 f4Var) {
        if (f4Var instanceof v4) {
            v4 v4Var = (v4) f4Var;
            long time = this.f22772f.getTime();
            long time2 = v4Var.f22772f.getTime();
            if (time == time2) {
                return Long.valueOf(this.f22773g).compareTo(Long.valueOf(v4Var.f22773g));
            }
            return Long.valueOf(time).compareTo(Long.valueOf(time2));
        }
        return super.compareTo(f4Var);
    }

    @Override // io.sentry.f4
    public long k(f4 f4Var) {
        if (f4Var instanceof v4) {
            return this.f22773g - ((v4) f4Var).f22773g;
        }
        return super.k(f4Var);
    }

    @Override // io.sentry.f4
    public long v(f4 f4Var) {
        if (f4Var != null && (f4Var instanceof v4)) {
            v4 v4Var = (v4) f4Var;
            if (compareTo(f4Var) < 0) {
                return y(this, v4Var);
            }
            return y(v4Var, this);
        }
        return super.v(f4Var);
    }

    @Override // io.sentry.f4
    public long x() {
        return a1.a(this.f22772f);
    }

    public v4(Date date, long j2) {
        this.f22772f = date;
        this.f22773g = j2;
    }
}
