package com.facebook.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/* compiled from: LockOnGetVariable.kt */
/* loaded from: classes2.dex */
public final class i0<T> {
    private T a;

    /* renamed from: b, reason: collision with root package name */
    private CountDownLatch f9781b;

    public i0(final Callable<T> callable) {
        kotlin.jvm.internal.m.f(callable, "callable");
        this.f9781b = new CountDownLatch(1);
        com.facebook.a0 a0Var = com.facebook.a0.a;
        com.facebook.a0.k().execute(new FutureTask(new Callable() { // from class: com.facebook.internal.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void a;
                a = i0.a(i0.this, callable);
                return a;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void a(i0 i0Var, Callable callable) {
        kotlin.jvm.internal.m.f(i0Var, "this$0");
        kotlin.jvm.internal.m.f(callable, "$callable");
        try {
            i0Var.a = (T) callable.call();
        } finally {
            CountDownLatch countDownLatch = i0Var.f9781b;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
