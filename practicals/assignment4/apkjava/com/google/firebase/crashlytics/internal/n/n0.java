package com.google.firebase.crashlytics.internal.n;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: OnDemandCounter.java */
/* loaded from: classes2.dex */
public final class n0 {
    private final AtomicInteger a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f19066b = new AtomicInteger();

    public void a() {
        this.f19066b.getAndIncrement();
    }

    public void b() {
        this.a.getAndIncrement();
    }

    public void c() {
        this.f19066b.set(0);
    }
}
