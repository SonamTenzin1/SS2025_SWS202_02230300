package io.sentry.util.thread;

import io.sentry.protocol.w;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: MainThreadChecker.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class c implements b {
    private static final long a = Thread.currentThread().getId();

    /* renamed from: b, reason: collision with root package name */
    private static final c f22765b = new c();

    private c() {
    }

    public static c e() {
        return f22765b;
    }

    @Override // io.sentry.util.thread.b
    public boolean a(long j2) {
        return a == j2;
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean b(w wVar) {
        return a.b(this, wVar);
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean c(Thread thread) {
        return a.c(this, thread);
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean d() {
        return a.a(this);
    }
}
