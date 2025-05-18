package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t0 implements zabt {
    private final /* synthetic */ r0 a;

    private t0(r0 r0Var) {
        this.a = r0Var;
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.a.r;
        lock.lock();
        try {
            this.a.o = connectionResult;
            this.a.y();
        } finally {
            lock2 = this.a.r;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void b(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.a.r;
        lock.lock();
        try {
            this.a.k(bundle);
            this.a.o = ConnectionResult.f11619f;
            this.a.y();
        } finally {
            lock2 = this.a.r;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void c(int i2, boolean z) {
        Lock lock;
        Lock lock2;
        boolean z2;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        zabe zabeVar;
        lock = this.a.r;
        lock.lock();
        try {
            z2 = this.a.q;
            if (!z2) {
                connectionResult = this.a.p;
                if (connectionResult != null) {
                    connectionResult2 = this.a.p;
                    if (connectionResult2.e0()) {
                        this.a.q = true;
                        zabeVar = this.a.f11787j;
                        zabeVar.H(i2);
                        return;
                    }
                }
            }
            this.a.q = false;
            this.a.j(i2, z);
        } finally {
            lock2 = this.a.r;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t0(r0 r0Var, s0 s0Var) {
        this(r0Var);
    }
}
