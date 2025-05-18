package io.sentry.android.ndk;

import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.z0;
import io.sentry.util.q;
import io.sentry.x4;

/* compiled from: DebugImagesLoader.java */
/* loaded from: classes2.dex */
public final class a implements z0 {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final x4 f22287b;

    /* renamed from: c, reason: collision with root package name */
    private final NativeModuleListLoader f22288c;

    public a(SentryAndroidOptions sentryAndroidOptions, NativeModuleListLoader nativeModuleListLoader) {
        this.f22287b = (x4) q.c(sentryAndroidOptions, "The SentryAndroidOptions is required.");
        this.f22288c = (NativeModuleListLoader) q.c(nativeModuleListLoader, "The NativeModuleListLoader is required.");
    }
}
