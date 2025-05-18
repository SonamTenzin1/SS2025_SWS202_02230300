package com.google.android.gms.internal.cloudmessaging;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public interface zzb {
    ScheduledExecutorService a(int i2, ThreadFactory threadFactory, int i3);

    ExecutorService b(ThreadFactory threadFactory, int i2);
}
