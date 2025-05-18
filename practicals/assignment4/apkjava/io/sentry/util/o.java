package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: LazyEvaluator.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class o<T> {
    private T a = null;

    /* renamed from: b, reason: collision with root package name */
    private final a<T> f22762b;

    /* compiled from: LazyEvaluator.java */
    /* loaded from: classes2.dex */
    public interface a<T> {
        T a();
    }

    public o(a<T> aVar) {
        this.f22762b = aVar;
    }

    public synchronized T a() {
        if (this.a == null) {
            this.a = this.f22762b.a();
        }
        return this.a;
    }
}
