package io.sentry;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ISentryExecutorService.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public interface b2 {
    void a(long j2);

    Future<?> b(Runnable runnable, long j2) throws RejectedExecutionException;

    boolean isClosed();

    Future<?> submit(Runnable runnable) throws RejectedExecutionException;
}
