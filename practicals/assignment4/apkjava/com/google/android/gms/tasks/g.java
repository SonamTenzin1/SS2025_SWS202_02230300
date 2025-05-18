package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18322f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ h f18323g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, Task task) {
        this.f18323g = hVar;
        this.f18322f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar;
        x xVar2;
        x xVar3;
        Continuation continuation;
        try {
            continuation = this.f18323g.f18324b;
            Task task = (Task) continuation.a(this.f18322f);
            if (task == null) {
                this.f18323g.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f18310b;
            task.e(executor, this.f18323g);
            task.d(executor, this.f18323g);
            task.a(executor, this.f18323g);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                xVar3 = this.f18323g.f18325c;
                xVar3.q((Exception) e2.getCause());
            } else {
                xVar2 = this.f18323g.f18325c;
                xVar2.q(e2);
            }
        } catch (Exception e3) {
            xVar = this.f18323g.f18325c;
            xVar.q(e3);
        }
    }
}
