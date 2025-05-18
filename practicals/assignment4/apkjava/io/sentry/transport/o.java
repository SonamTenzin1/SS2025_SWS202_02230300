package io.sentry.transport;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: CurrentDateProvider.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class o implements q {
    private static final q a = new o();

    private o() {
    }

    public static q b() {
        return a;
    }

    @Override // io.sentry.transport.q
    public final long a() {
        return System.currentTimeMillis();
    }
}
