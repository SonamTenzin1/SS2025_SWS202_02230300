package com.airbnb.epoxy;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: HandlerExecutor.java */
/* loaded from: classes.dex */
class w implements Executor {

    /* renamed from: f, reason: collision with root package name */
    final Handler f8478f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Handler handler) {
        this.f8478f = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Looper.myLooper() == this.f8478f.getLooper()) {
            runnable.run();
        } else {
            this.f8478f.post(runnable);
        }
    }
}
