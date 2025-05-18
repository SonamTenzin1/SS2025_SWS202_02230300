package io.sentry.android.core;

import android.os.Handler;
import android.os.Looper;

/* compiled from: MainLooperHandler.java */
/* loaded from: classes2.dex */
final class c1 {
    private final Handler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1() {
        this(Looper.getMainLooper());
    }

    public Thread a() {
        return this.a.getLooper().getThread();
    }

    public void b(Runnable runnable) {
        this.a.post(runnable);
    }

    c1(Looper looper) {
        this.a = new Handler(looper);
    }
}
