package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class f implements t {
    private final Executor a;

    /* renamed from: b, reason: collision with root package name */
    private final Continuation f18320b;

    /* renamed from: c, reason: collision with root package name */
    private final x f18321c;

    public f(Executor executor, Continuation continuation, x xVar) {
        this.a = executor;
        this.f18320b = continuation;
        this.f18321c = xVar;
    }

    @Override // com.google.android.gms.tasks.t
    public final void a(Task task) {
        this.a.execute(new e(this, task));
    }
}
