package io.sentry;

/* compiled from: SentryDate.java */
/* loaded from: classes2.dex */
public abstract class f4 implements Comparable<f4> {
    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(f4 f4Var) {
        return Long.valueOf(x()).compareTo(Long.valueOf(f4Var.x()));
    }

    public long k(f4 f4Var) {
        return x() - f4Var.x();
    }

    public final boolean q(f4 f4Var) {
        return k(f4Var) > 0;
    }

    public final boolean u(f4 f4Var) {
        return k(f4Var) < 0;
    }

    public long v(f4 f4Var) {
        if (f4Var != null && compareTo(f4Var) < 0) {
            return f4Var.x();
        }
        return x();
    }

    public abstract long x();
}
