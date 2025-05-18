package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class x3 extends Thread {

    /* renamed from: f, reason: collision with root package name */
    private final Object f18014f;

    /* renamed from: g, reason: collision with root package name */
    private final BlockingQueue<v3<?>> f18015g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzfu f18016h;

    public x3(zzfu zzfuVar, String str, BlockingQueue<v3<?>> blockingQueue) {
        this.f18016h = zzfuVar;
        Preconditions.k(str);
        Preconditions.k(blockingQueue);
        this.f18014f = new Object();
        this.f18015g = blockingQueue;
        setName(str);
    }

    private final void b(InterruptedException interruptedException) {
        this.f18016h.h().K().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.f18014f) {
            this.f18014f.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        x3 x3Var;
        x3 x3Var2;
        Object obj3;
        Object obj4;
        Semaphore semaphore2;
        Object obj5;
        x3 x3Var3;
        x3 x3Var4;
        boolean z;
        Semaphore semaphore3;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore3 = this.f18016h.f18152k;
                semaphore3.acquire();
                z2 = true;
            } catch (InterruptedException e2) {
                b(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                v3<?> poll = this.f18015g.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.f17986g ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.f18014f) {
                        if (this.f18015g.peek() == null) {
                            z = this.f18016h.l;
                            if (!z) {
                                try {
                                    this.f18014f.wait(30000L);
                                } catch (InterruptedException e3) {
                                    b(e3);
                                }
                            }
                        }
                    }
                    obj3 = this.f18016h.f18151j;
                    synchronized (obj3) {
                        if (this.f18015g.peek() == null) {
                            break;
                        }
                    }
                }
            }
            obj4 = this.f18016h.f18151j;
            synchronized (obj4) {
                semaphore2 = this.f18016h.f18152k;
                semaphore2.release();
                obj5 = this.f18016h.f18151j;
                obj5.notifyAll();
                x3Var3 = this.f18016h.f18145d;
                if (this != x3Var3) {
                    x3Var4 = this.f18016h.f18146e;
                    if (this == x3Var4) {
                        zzfu.A(this.f18016h, null);
                    } else {
                        this.f18016h.h().H().a("Current scheduler thread is neither worker nor network");
                    }
                } else {
                    zzfu.u(this.f18016h, null);
                }
            }
        } catch (Throwable th) {
            obj = this.f18016h.f18151j;
            synchronized (obj) {
                semaphore = this.f18016h.f18152k;
                semaphore.release();
                obj2 = this.f18016h.f18151j;
                obj2.notifyAll();
                x3Var = this.f18016h.f18145d;
                if (this != x3Var) {
                    x3Var2 = this.f18016h.f18146e;
                    if (this == x3Var2) {
                        zzfu.A(this.f18016h, null);
                    } else {
                        this.f18016h.h().H().a("Current scheduler thread is neither worker nor network");
                    }
                } else {
                    zzfu.u(this.f18016h, null);
                }
                throw th;
            }
        }
    }
}
