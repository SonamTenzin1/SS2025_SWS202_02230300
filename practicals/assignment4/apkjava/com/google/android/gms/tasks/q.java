package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class q implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18341f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ s f18342g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(s sVar, Task task) {
        this.f18342g = sVar;
        this.f18341f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SuccessContinuation successContinuation;
        try {
            successContinuation = this.f18342g.f18343b;
            Task a = successContinuation.a(this.f18341f.j());
            if (a == null) {
                this.f18342g.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f18310b;
            a.e(executor, this.f18342g);
            a.d(executor, this.f18342g);
            a.a(executor, this.f18342g);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.f18342g.c((Exception) e2.getCause());
            } else {
                this.f18342g.c(e2);
            }
        } catch (CancellationException unused) {
            this.f18342g.b();
        } catch (Exception e3) {
            this.f18342g.c(e3);
        }
    }
}
