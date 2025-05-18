package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ r0 f11790f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(r0 r0Var) {
        this.f11790f = r0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.f11790f.r;
        lock.lock();
        try {
            this.f11790f.y();
        } finally {
            lock2 = this.f11790f.r;
            lock2.unlock();
        }
    }
}
