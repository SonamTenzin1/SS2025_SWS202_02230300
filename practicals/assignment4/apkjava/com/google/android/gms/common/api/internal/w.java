package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class w {
    private final zabd a;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(zabd zabdVar) {
        this.a = zabdVar;
    }

    protected abstract void a();

    public final void b(zabe zabeVar) {
        Lock lock;
        Lock lock2;
        zabd zabdVar;
        lock = zabeVar.f11825f;
        lock.lock();
        try {
            zabdVar = zabeVar.p;
            if (zabdVar != this.a) {
                return;
            }
            a();
        } finally {
            lock2 = zabeVar.f11825f;
            lock2.unlock();
        }
    }
}
