package io.sentry;

import io.sentry.UncaughtExceptionHandlerIntegration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DeduplicateMultithreadedEventProcessor.java */
/* loaded from: classes2.dex */
public final class b1 implements k1 {

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f22294f = Collections.synchronizedMap(new HashMap());

    /* renamed from: g, reason: collision with root package name */
    private final x4 f22295g;

    public b1(x4 x4Var) {
        this.f22295g = x4Var;
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        io.sentry.protocol.p u0;
        String i2;
        Long h2;
        if (!io.sentry.util.m.d(n1Var, UncaughtExceptionHandlerIntegration.a.class) || (u0 = l4Var.u0()) == null || (i2 = u0.i()) == null || (h2 = u0.h()) == null) {
            return l4Var;
        }
        Long l = this.f22294f.get(i2);
        if (l != null && !l.equals(h2)) {
            this.f22295g.getLogger().c(s4.INFO, "Event %s has been dropped due to multi-threaded deduplication", l4Var.G());
            io.sentry.util.m.n(n1Var, io.sentry.hints.h.MULTITHREADED_DEDUPLICATION);
            return null;
        }
        this.f22294f.put(i2, h2);
        return l4Var;
    }

    @Override // io.sentry.k1
    public /* synthetic */ io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        return j1.a(this, xVar, n1Var);
    }
}
