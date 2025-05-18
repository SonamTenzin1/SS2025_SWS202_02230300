package com.flurry.sdk;

import com.flurry.sdk.g4;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class c5 extends g4 {

    /* renamed from: k, reason: collision with root package name */
    private final Deque<g4.b> f10675k;
    private g4.b l;

    /* loaded from: classes2.dex */
    final class a extends g4.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c5 c5Var, g4 g4Var, Runnable runnable) {
            super(g4Var, runnable);
            c5Var.getClass();
        }

        @Override // java.util.concurrent.FutureTask
        protected final void done() {
            this.f10789f.k(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c5(String str, g4 g4Var, boolean z) {
        super(str, g4Var, z);
        this.f10675k = new LinkedList();
    }

    private synchronized void a() {
        if (this.f10787i) {
            while (this.f10675k.size() > 0) {
                g4.b remove = this.f10675k.remove();
                if (!remove.isDone()) {
                    this.l = remove;
                    if (!q(remove)) {
                        this.l = null;
                        this.f10675k.addFirst(remove);
                        return;
                    }
                }
            }
        } else if (this.l == null && this.f10675k.size() > 0) {
            g4.b remove2 = this.f10675k.remove();
            if (!remove2.isDone()) {
                this.l = remove2;
                if (!q(remove2)) {
                    this.l = null;
                    this.f10675k.addFirst(remove2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.g4
    public void k(Runnable runnable) {
        synchronized (this) {
            if (this.l == runnable) {
                this.l = null;
            }
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.g4
    public Future<Void> m(Runnable runnable) {
        g4.b aVar;
        if (runnable instanceof g4.b) {
            aVar = (g4.b) runnable;
        } else {
            aVar = new a(this, this, runnable);
        }
        synchronized (this) {
            this.f10675k.add(aVar);
            a();
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.g4
    public void n(Runnable runnable) throws CancellationException {
        g4.b bVar = new g4.b(this, g4.f10784f);
        synchronized (this) {
            this.f10675k.add(bVar);
            a();
        }
        if (this.f10788j) {
            for (g4 g4Var = this.f10786h; g4Var != null; g4Var = g4Var.f10786h) {
                g4Var.l(bVar);
            }
        }
        while (!bVar.isDone()) {
            try {
                bVar.get();
            } catch (CancellationException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
        if (!p(runnable)) {
            o(runnable);
        }
        k(bVar);
    }

    @Override // com.flurry.sdk.g4
    protected boolean p(Runnable runnable) {
        return false;
    }

    protected boolean q(g4.b bVar) {
        g4 g4Var = this.f10786h;
        if (g4Var == null) {
            return true;
        }
        g4Var.m(bVar);
        return true;
    }
}
