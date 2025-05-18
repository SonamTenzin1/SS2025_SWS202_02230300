package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
abstract class p implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zaak f11778f;

    private p(zaak zaakVar) {
        this.f11778f = zaakVar;
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        Lock lock2;
        zabe zabeVar;
        lock = this.f11778f.f11805b;
        lock.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
        } catch (RuntimeException e2) {
            zabeVar = this.f11778f.a;
            zabeVar.k(e2);
        } finally {
            lock2 = this.f11778f.f11805b;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(zaak zaakVar, g gVar) {
        this(zaakVar);
    }
}
