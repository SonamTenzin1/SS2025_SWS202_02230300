package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class d implements Executor {

    /* renamed from: f, reason: collision with root package name */
    static final Executor f19633f = new d();

    private d() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
