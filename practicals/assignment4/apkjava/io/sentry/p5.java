package io.sentry;

import java.security.SecureRandom;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TracesSampler.java */
/* loaded from: classes2.dex */
public final class p5 {
    private static final Double a = Double.valueOf(1.0d);

    /* renamed from: b, reason: collision with root package name */
    private final x4 f22546b;

    /* renamed from: c, reason: collision with root package name */
    private final SecureRandom f22547c;

    public p5(x4 x4Var) {
        this((x4) io.sentry.util.q.c(x4Var, "options are required"), new SecureRandom());
    }

    private boolean b(Double d2) {
        return d2.doubleValue() >= this.f22547c.nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public q5 a(r3 r3Var) {
        Double a2;
        Double d2;
        q5 u;
        q5 g2 = r3Var.a().g();
        if (g2 != null) {
            return g2;
        }
        if (this.f22546b.getProfilesSampler() != null) {
            try {
                a2 = this.f22546b.getProfilesSampler().a(r3Var);
            } catch (Throwable th) {
                this.f22546b.getLogger().b(s4.ERROR, "Error in the 'ProfilesSamplerCallback' callback.", th);
            }
            if (a2 == null) {
                a2 = this.f22546b.getProfilesSampleRate();
            }
            Boolean valueOf = Boolean.valueOf(a2 == null && b(a2));
            if (this.f22546b.getTracesSampler() != null) {
                try {
                    d2 = this.f22546b.getTracesSampler().a(r3Var);
                } catch (Throwable th2) {
                    this.f22546b.getLogger().b(s4.ERROR, "Error in the 'TracesSamplerCallback' callback.", th2);
                    d2 = null;
                }
                if (d2 != null) {
                    return new q5(Boolean.valueOf(b(d2)), d2, valueOf, a2);
                }
            }
            u = r3Var.a().u();
            if (u == null) {
                return u;
            }
            Double tracesSampleRate = this.f22546b.getTracesSampleRate();
            Double d3 = Boolean.TRUE.equals(this.f22546b.getEnableTracing()) ? a : null;
            if (tracesSampleRate == null) {
                tracesSampleRate = d3;
            }
            if (tracesSampleRate != null) {
                return new q5(Boolean.valueOf(b(tracesSampleRate)), tracesSampleRate, valueOf, a2);
            }
            Boolean bool = Boolean.FALSE;
            return new q5(bool, null, bool, null);
        }
        a2 = null;
        if (a2 == null) {
        }
        Boolean valueOf2 = Boolean.valueOf(a2 == null && b(a2));
        if (this.f22546b.getTracesSampler() != null) {
        }
        u = r3Var.a().u();
        if (u == null) {
        }
    }

    p5(x4 x4Var, SecureRandom secureRandom) {
        this.f22546b = x4Var;
        this.f22547c = secureRandom;
    }
}
