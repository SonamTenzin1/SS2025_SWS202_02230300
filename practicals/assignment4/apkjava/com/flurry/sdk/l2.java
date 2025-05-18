package com.flurry.sdk;

import android.os.Handler;
import android.os.Looper;
import com.flurry.sdk.g4;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class l2 extends c5 {
    private static final ThreadLocal<l2> m = new ThreadLocal<>();
    private Thread n;

    public l2(String str, g4 g4Var) {
        super(str, g4Var, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.g4
    public void l(Runnable runnable) {
        if (Thread.currentThread() == this.n) {
            runnable.run();
        }
    }

    @Override // com.flurry.sdk.c5, com.flurry.sdk.g4
    public Future<Void> m(Runnable runnable) {
        return super.m(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.c5, com.flurry.sdk.g4
    public void n(Runnable runnable) {
        synchronized (this) {
            if (this.n == Thread.currentThread()) {
                if (runnable instanceof g4.b) {
                    g4 g4Var = this.f10786h;
                    if (g4Var != null) {
                        g4Var.n(runnable);
                    }
                } else {
                    runnable.run();
                }
                return;
            }
            super.n(runnable);
        }
    }

    @Override // com.flurry.sdk.c5, com.flurry.sdk.g4
    protected boolean p(Runnable runnable) {
        ThreadLocal<l2> threadLocal;
        l2 l2Var;
        Thread thread;
        synchronized (this) {
            threadLocal = m;
            l2Var = threadLocal.get();
            threadLocal.set(this);
            thread = this.n;
            this.n = Thread.currentThread();
        }
        try {
            o(runnable);
            synchronized (this) {
                this.n = thread;
                threadLocal.set(l2Var);
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                this.n = thread;
                m.set(l2Var);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
