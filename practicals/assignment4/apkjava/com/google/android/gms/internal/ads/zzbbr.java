package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzard
/* loaded from: classes2.dex */
public class zzbbr<T> implements zzbbh<T> {

    /* renamed from: g, reason: collision with root package name */
    private T f14335g;

    /* renamed from: h, reason: collision with root package name */
    private Throwable f14336h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f14337i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14338j;

    /* renamed from: f, reason: collision with root package name */
    private final Object f14334f = new Object();

    /* renamed from: k, reason: collision with root package name */
    private final c7 f14339k = new c7();

    private final boolean d() {
        return this.f14336h != null || this.f14337i;
    }

    public final void a(T t) {
        synchronized (this.f14334f) {
            if (this.f14338j) {
                return;
            }
            if (d()) {
                zzk.zzlk().h(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                return;
            }
            this.f14337i = true;
            this.f14335g = t;
            this.f14334f.notifyAll();
            this.f14339k.b();
        }
    }

    public final void c(Throwable th) {
        synchronized (this.f14334f) {
            if (this.f14338j) {
                return;
            }
            if (d()) {
                zzk.zzlk().h(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                return;
            }
            this.f14336h = th;
            this.f14334f.notifyAll();
            this.f14339k.b();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f14334f) {
            if (d()) {
                return false;
            }
            this.f14338j = true;
            this.f14337i = true;
            this.f14334f.notifyAll();
            this.f14339k.b();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.f14334f) {
            while (!d()) {
                this.f14334f.wait();
            }
            if (this.f14336h == null) {
                if (!this.f14338j) {
                    t = this.f14335g;
                } else {
                    throw new CancellationException("SettableFuture was cancelled.");
                }
            } else {
                throw new ExecutionException(this.f14336h);
            }
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.f14334f) {
            z = this.f14338j;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean d2;
        synchronized (this.f14334f) {
            d2 = d();
        }
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void k(Runnable runnable, Executor executor) {
        this.f14339k.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.f14334f) {
            long millis = timeUnit.toMillis(j2);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = millis + currentTimeMillis;
            while (!d() && currentTimeMillis < j3) {
                this.f14334f.wait(j3 - currentTimeMillis);
                currentTimeMillis = System.currentTimeMillis();
            }
            if (!this.f14338j) {
                if (this.f14336h == null) {
                    if (this.f14337i) {
                        t = this.f14335g;
                    } else {
                        throw new TimeoutException("SettableFuture timed out.");
                    }
                } else {
                    throw new ExecutionException(this.f14336h);
                }
            } else {
                throw new CancellationException("SettableFuture was cancelled.");
            }
        }
        return t;
    }
}
