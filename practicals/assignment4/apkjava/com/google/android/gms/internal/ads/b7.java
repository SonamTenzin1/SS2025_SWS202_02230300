package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
@zzard
/* loaded from: classes2.dex */
public final class b7<T> implements zzbbh<T> {

    /* renamed from: f, reason: collision with root package name */
    private final T f12322f;

    /* renamed from: g, reason: collision with root package name */
    private final c7 f12323g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b7(T t) {
        this.f12322f = t;
        c7 c7Var = new c7();
        this.f12323g = c7Var;
        c7Var.b();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final T get() {
        return this.f12322f;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void k(Runnable runnable, Executor executor) {
        this.f12323g.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final T get(long j2, TimeUnit timeUnit) {
        return this.f12322f;
    }
}
