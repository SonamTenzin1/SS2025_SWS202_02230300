package io.sentry.android.core;

import io.sentry.f5;
import io.sentry.k1;
import io.sentry.l4;
import io.sentry.n1;
import io.sentry.v2;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PerformanceAndroidEventProcessor.java */
/* loaded from: classes2.dex */
public final class f1 implements k1 {

    /* renamed from: f, reason: collision with root package name */
    private boolean f22122f = false;

    /* renamed from: g, reason: collision with root package name */
    private final f0 f22123g;

    /* renamed from: h, reason: collision with root package name */
    private final SentryAndroidOptions f22124h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1(SentryAndroidOptions sentryAndroidOptions, f0 f0Var) {
        this.f22124h = (SentryAndroidOptions) io.sentry.util.q.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f22123g = (f0) io.sentry.util.q.c(f0Var, "ActivityFramesTracker is required");
    }

    private boolean a(List<io.sentry.protocol.t> list) {
        for (io.sentry.protocol.t tVar : list) {
            if (tVar.b().contentEquals("app.start.cold") || tVar.b().contentEquals("app.start.warm")) {
                return true;
            }
        }
        return false;
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        return l4Var;
    }

    @Override // io.sentry.k1
    public synchronized io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        Map<String, io.sentry.protocol.h> q;
        Long b2;
        if (!this.f22124h.isTracingEnabled()) {
            return xVar;
        }
        if (!this.f22122f && a(xVar.o0()) && (b2 = q0.e().b()) != null) {
            xVar.m0().put(q0.e().f().booleanValue() ? "app_start_cold" : "app_start_warm", new io.sentry.protocol.h(Float.valueOf((float) b2.longValue()), v2.a.MILLISECOND.apiName()));
            this.f22122f = true;
        }
        io.sentry.protocol.q G = xVar.G();
        f5 e2 = xVar.C().e();
        if (G != null && e2 != null && e2.b().contentEquals("ui.load") && (q = this.f22123g.q(G)) != null) {
            xVar.m0().putAll(q);
        }
        return xVar;
    }
}
