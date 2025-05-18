package com.flurry.sdk;

import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public abstract class g4 {

    /* renamed from: f, reason: collision with root package name */
    static Runnable f10784f = new a();

    /* renamed from: g, reason: collision with root package name */
    protected final String f10785g;

    /* renamed from: h, reason: collision with root package name */
    protected final g4 f10786h;

    /* renamed from: i, reason: collision with root package name */
    protected final boolean f10787i;

    /* renamed from: j, reason: collision with root package name */
    protected final boolean f10788j;

    /* loaded from: classes2.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends FutureTask<Void> {

        /* renamed from: f, reason: collision with root package name */
        public final g4 f10789f;

        /* renamed from: g, reason: collision with root package name */
        private TimerTask f10790g;

        /* renamed from: h, reason: collision with root package name */
        private final int f10791h;

        /* renamed from: i, reason: collision with root package name */
        private final int f10792i;

        /* renamed from: j, reason: collision with root package name */
        private final int f10793j;

        /* renamed from: k, reason: collision with root package name */
        private int f10794k;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(g4 g4Var, Runnable runnable) {
            super(runnable, null);
            this.f10791h = 0;
            this.f10792i = 1;
            this.f10793j = 2;
            this.f10789f = g4Var;
            if (runnable == g4.f10784f) {
                this.f10794k = 0;
            } else {
                this.f10794k = 1;
            }
        }

        public final synchronized boolean a() {
            return this.f10794k == 0;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        public synchronized boolean cancel(boolean z) {
            super.cancel(z);
            TimerTask timerTask = this.f10790g;
            if (timerTask != null) {
                timerTask.cancel();
            }
            return true;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public synchronized void run() {
            if (this.f10794k == 1) {
                this.f10794k = 2;
                if (!this.f10789f.p(this)) {
                    this.f10789f.o(this);
                }
                this.f10794k = 1;
                return;
            }
            super.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g4(String str, g4 g4Var, boolean z) {
        this(str, g4Var, z, g4Var == null ? false : g4Var.f10788j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void k(Runnable runnable);

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(Runnable runnable) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Future<Void> m(Runnable runnable);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void n(Runnable runnable) throws CancellationException;

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean o(Runnable runnable) {
        for (g4 g4Var = this.f10786h; g4Var != null; g4Var = g4Var.f10786h) {
            if (g4Var.p(runnable)) {
                return true;
            }
        }
        runnable.run();
        return true;
    }

    protected abstract boolean p(Runnable runnable);

    private g4(String str, g4 g4Var, boolean z, boolean z2) {
        this.f10785g = str;
        this.f10786h = g4Var;
        this.f10787i = z;
        this.f10788j = z2;
    }
}
