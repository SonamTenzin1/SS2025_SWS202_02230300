package com.bumptech.glide.p;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.GlideException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFutureTarget.java */
/* loaded from: classes.dex */
public class f<R> implements c<R>, g<R> {

    /* renamed from: f, reason: collision with root package name */
    private static final a f9493f = new a();

    /* renamed from: g, reason: collision with root package name */
    private final int f9494g;

    /* renamed from: h, reason: collision with root package name */
    private final int f9495h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f9496i;

    /* renamed from: j, reason: collision with root package name */
    private final a f9497j;

    /* renamed from: k, reason: collision with root package name */
    private R f9498k;
    private d l;
    private boolean m;
    private boolean n;
    private boolean o;
    private GlideException p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestFutureTarget.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }
    }

    public f(int i2, int i3) {
        this(i2, i3, true, f9493f);
    }

    private synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f9496i && !isDone()) {
            com.bumptech.glide.r.k.a();
        }
        if (!this.m) {
            if (!this.o) {
                if (this.n) {
                    return this.f9498k;
                }
                if (l == null) {
                    this.f9497j.b(this, 0L);
                } else if (l.longValue() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = l.longValue() + currentTimeMillis;
                    while (!isDone() && currentTimeMillis < longValue) {
                        this.f9497j.b(this, longValue - currentTimeMillis);
                        currentTimeMillis = System.currentTimeMillis();
                    }
                }
                if (!Thread.interrupted()) {
                    if (!this.o) {
                        if (!this.m) {
                            if (this.n) {
                                return this.f9498k;
                            }
                            throw new TimeoutException();
                        }
                        throw new CancellationException();
                    }
                    throw new ExecutionException(this.p);
                }
                throw new InterruptedException();
            }
            throw new ExecutionException(this.p);
        }
        throw new CancellationException();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        d dVar;
        if (isDone()) {
            return false;
        }
        this.m = true;
        this.f9497j.a(this);
        if (z && (dVar = this.l) != null) {
            dVar.clear();
            this.l = null;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized d getRequest() {
        return this.l;
    }

    @Override // com.bumptech.glide.p.l.i
    public void getSize(com.bumptech.glide.p.l.h hVar) {
        hVar.g(this.f9494g, this.f9495h);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.m;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        boolean z;
        if (!this.m && !this.n) {
            z = this.o;
        }
        return z;
    }

    @Override // com.bumptech.glide.m.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.p.l.i
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized void onResourceReady(R r, com.bumptech.glide.p.m.d<? super R> dVar) {
    }

    @Override // com.bumptech.glide.m.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.m.i
    public void onStop() {
    }

    @Override // com.bumptech.glide.p.l.i
    public void removeCallback(com.bumptech.glide.p.l.h hVar) {
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized void setRequest(d dVar) {
        this.l = dVar;
    }

    f(int i2, int i3, boolean z, a aVar) {
        this.f9494g = i2;
        this.f9495h = i3;
        this.f9496i = z;
        this.f9497j = aVar;
    }

    @Override // com.bumptech.glide.p.g
    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, com.bumptech.glide.p.l.i<R> iVar, boolean z) {
        this.o = true;
        this.p = glideException;
        this.f9497j.a(this);
        return false;
    }

    @Override // com.bumptech.glide.p.g
    public synchronized boolean onResourceReady(R r, Object obj, com.bumptech.glide.p.l.i<R> iVar, com.bumptech.glide.load.a aVar, boolean z) {
        this.n = true;
        this.f9498k = r;
        this.f9497j.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
