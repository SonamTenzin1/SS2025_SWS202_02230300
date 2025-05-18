package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: AsyncHttpTransportFactory.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class r0 implements g2 {
    @Override // io.sentry.g2
    public io.sentry.transport.r a(x4 x4Var, p3 p3Var) {
        io.sentry.util.q.c(x4Var, "options is required");
        io.sentry.util.q.c(p3Var, "requestDetails is required");
        return new io.sentry.transport.m(x4Var, new io.sentry.transport.y(x4Var), x4Var.getTransportGate(), p3Var);
    }
}
