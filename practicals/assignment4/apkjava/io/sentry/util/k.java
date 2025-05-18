package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: ExceptionUtils.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class k {
    public static Throwable a(Throwable th) {
        q.c(th, "throwable cannot be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }
}
