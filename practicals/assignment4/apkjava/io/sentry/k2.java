package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: JavaMemoryCollector.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class k2 implements r1 {
    private final Runtime a = Runtime.getRuntime();

    @Override // io.sentry.r1
    public void a(k3 k3Var) {
        k3Var.b(new w2(System.currentTimeMillis(), this.a.totalMemory() - this.a.freeMemory()));
    }

    @Override // io.sentry.r1
    public void setup() {
    }
}
