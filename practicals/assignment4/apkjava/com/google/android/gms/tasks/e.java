package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class e implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18318f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ f f18319g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, Task task) {
        this.f18319g = fVar;
        this.f18318f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar;
        x xVar2;
        x xVar3;
        Continuation continuation;
        x xVar4;
        x xVar5;
        if (this.f18318f.l()) {
            xVar5 = this.f18319g.f18321c;
            xVar5.s();
            return;
        }
        try {
            continuation = this.f18319g.f18320b;
            Object a = continuation.a(this.f18318f);
            xVar4 = this.f18319g.f18321c;
            xVar4.r(a);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                xVar3 = this.f18319g.f18321c;
                xVar3.q((Exception) e2.getCause());
            } else {
                xVar2 = this.f18319g.f18321c;
                xVar2.q(e2);
            }
        } catch (Exception e3) {
            xVar = this.f18319g.f18321c;
            xVar.q(e3);
        }
    }
}
