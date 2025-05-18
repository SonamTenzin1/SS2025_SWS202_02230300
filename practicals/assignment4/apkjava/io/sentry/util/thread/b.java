package io.sentry.util.thread;

import io.sentry.protocol.w;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: IMainThreadChecker.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public interface b {
    boolean a(long j2);

    boolean b(w wVar);

    boolean c(Thread thread);

    boolean d();
}
