package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: DelegatingScheduledFuture.java */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
class x<V> extends c.f.a.a<V> implements ScheduledFuture<V> {
    private final ScheduledFuture<?> m;

    /* compiled from: DelegatingScheduledFuture.java */
    /* loaded from: classes2.dex */
    class a implements b<V> {
        a() {
        }

        @Override // com.google.firebase.concurrent.x.b
        public void a(Throwable th) {
            x.this.M(th);
        }

        @Override // com.google.firebase.concurrent.x.b
        public void set(V v) {
            x.this.L(v);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DelegatingScheduledFuture.java */
    /* loaded from: classes2.dex */
    public interface b<T> {
        void a(Throwable th);

        void set(T t);
    }

    /* compiled from: DelegatingScheduledFuture.java */
    /* loaded from: classes2.dex */
    interface c<T> {
        ScheduledFuture<?> a(b<T> bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(c<V> cVar) {
        this.m = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.m.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.m.getDelay(timeUnit);
    }

    @Override // c.f.a.a
    protected void u() {
        this.m.cancel(O());
    }
}
