package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f7 implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private final Handler f12570f = new zzaxa(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                zzk.zzlg();
                zzaxi.n(zzk.zzlk().a(), th);
                throw th;
            }
        }
        this.f12570f.post(runnable);
    }
}
