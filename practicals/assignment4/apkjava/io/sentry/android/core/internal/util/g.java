package io.sentry.android.core.internal.util;

import android.os.SystemClock;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AndroidCurrentDateProvider.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class g implements io.sentry.transport.q {
    private static final io.sentry.transport.q a = new g();

    private g() {
    }

    public static io.sentry.transport.q b() {
        return a;
    }

    @Override // io.sentry.transport.q
    public long a() {
        return SystemClock.uptimeMillis();
    }
}
