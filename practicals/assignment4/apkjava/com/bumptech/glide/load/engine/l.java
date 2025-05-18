package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.r.l.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class l<R> implements h.b<R>, a.f {

    /* renamed from: f, reason: collision with root package name */
    private static final c f9162f = new c();
    p<?> A;
    private h<R> B;
    private volatile boolean C;

    /* renamed from: g, reason: collision with root package name */
    final e f9163g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.r.l.c f9164h;

    /* renamed from: i, reason: collision with root package name */
    private final c.i.j.f<l<?>> f9165i;

    /* renamed from: j, reason: collision with root package name */
    private final c f9166j;

    /* renamed from: k, reason: collision with root package name */
    private final m f9167k;
    private final com.bumptech.glide.load.engine.b0.a l;
    private final com.bumptech.glide.load.engine.b0.a m;
    private final com.bumptech.glide.load.engine.b0.a n;
    private final com.bumptech.glide.load.engine.b0.a o;
    private final AtomicInteger p;
    private com.bumptech.glide.load.f q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private u<?> v;
    com.bumptech.glide.load.a w;
    private boolean x;
    GlideException y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final com.bumptech.glide.p.i f9168f;

        a(com.bumptech.glide.p.i iVar) {
            this.f9168f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (l.this) {
                if (l.this.f9163g.f(this.f9168f)) {
                    l.this.e(this.f9168f);
                }
                l.this.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final com.bumptech.glide.p.i f9170f;

        b(com.bumptech.glide.p.i iVar) {
            this.f9170f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (l.this) {
                if (l.this.f9163g.f(this.f9170f)) {
                    l.this.A.a();
                    l.this.f(this.f9170f);
                    l.this.q(this.f9170f);
                }
                l.this.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        public <R> p<R> a(u<R> uVar, boolean z) {
            return new p<>(uVar, z, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class d {
        final com.bumptech.glide.p.i a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f9172b;

        d(com.bumptech.glide.p.i iVar, Executor executor) {
            this.a = iVar;
            this.f9172b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static final class e implements Iterable<d> {

        /* renamed from: f, reason: collision with root package name */
        private final List<d> f9173f;

        e() {
            this(new ArrayList(2));
        }

        private static d h(com.bumptech.glide.p.i iVar) {
            return new d(iVar, com.bumptech.glide.r.e.a());
        }

        void c(com.bumptech.glide.p.i iVar, Executor executor) {
            this.f9173f.add(new d(iVar, executor));
        }

        void clear() {
            this.f9173f.clear();
        }

        boolean f(com.bumptech.glide.p.i iVar) {
            return this.f9173f.contains(h(iVar));
        }

        e g() {
            return new e(new ArrayList(this.f9173f));
        }

        void i(com.bumptech.glide.p.i iVar) {
            this.f9173f.remove(h(iVar));
        }

        boolean isEmpty() {
            return this.f9173f.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f9173f.iterator();
        }

        int size() {
            return this.f9173f.size();
        }

        e(List<d> list) {
            this.f9173f = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, c.i.j.f<l<?>> fVar) {
        this(aVar, aVar2, aVar3, aVar4, mVar, fVar, f9162f);
    }

    private com.bumptech.glide.load.engine.b0.a i() {
        if (this.s) {
            return this.n;
        }
        return this.t ? this.o : this.m;
    }

    private boolean l() {
        return this.z || this.x || this.C;
    }

    private synchronized void p() {
        if (this.q != null) {
            this.f9163g.clear();
            this.q = null;
            this.A = null;
            this.v = null;
            this.z = false;
            this.C = false;
            this.x = false;
            this.B.R(false);
            this.B = null;
            this.y = null;
            this.w = null;
            this.f9165i.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.y = glideException;
        }
        m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.h.b
    public void b(u<R> uVar, com.bumptech.glide.load.a aVar) {
        synchronized (this) {
            this.v = uVar;
            this.w = aVar;
        }
        n();
    }

    @Override // com.bumptech.glide.load.engine.h.b
    public void c(h<?> hVar) {
        i().execute(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bumptech.glide.p.i iVar, Executor executor) {
        this.f9164h.c();
        this.f9163g.c(iVar, executor);
        boolean z = true;
        if (this.x) {
            j(1);
            executor.execute(new b(iVar));
        } else if (this.z) {
            j(1);
            executor.execute(new a(iVar));
        } else {
            if (this.C) {
                z = false;
            }
            com.bumptech.glide.r.j.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    synchronized void e(com.bumptech.glide.p.i iVar) {
        try {
            iVar.a(this.y);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    synchronized void f(com.bumptech.glide.p.i iVar) {
        try {
            iVar.b(this.A, this.w);
        } catch (Throwable th) {
            throw new com.bumptech.glide.load.engine.b(th);
        }
    }

    void g() {
        if (l()) {
            return;
        }
        this.C = true;
        this.B.v();
        this.f9167k.c(this, this.q);
    }

    synchronized void h() {
        this.f9164h.c();
        com.bumptech.glide.r.j.a(l(), "Not yet complete!");
        int decrementAndGet = this.p.decrementAndGet();
        com.bumptech.glide.r.j.a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            p<?> pVar = this.A;
            if (pVar != null) {
                pVar.g();
            }
            p();
        }
    }

    synchronized void j(int i2) {
        p<?> pVar;
        com.bumptech.glide.r.j.a(l(), "Not yet complete!");
        if (this.p.getAndAdd(i2) == 0 && (pVar = this.A) != null) {
            pVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized l<R> k(com.bumptech.glide.load.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.q = fVar;
        this.r = z;
        this.s = z2;
        this.t = z3;
        this.u = z4;
        return this;
    }

    void m() {
        synchronized (this) {
            this.f9164h.c();
            if (this.C) {
                p();
                return;
            }
            if (!this.f9163g.isEmpty()) {
                if (!this.z) {
                    this.z = true;
                    com.bumptech.glide.load.f fVar = this.q;
                    e g2 = this.f9163g.g();
                    j(g2.size() + 1);
                    this.f9167k.b(this, fVar, null);
                    Iterator<d> it = g2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f9172b.execute(new a(next.a));
                    }
                    h();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            }
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
    }

    void n() {
        synchronized (this) {
            this.f9164h.c();
            if (this.C) {
                this.v.c();
                p();
                return;
            }
            if (!this.f9163g.isEmpty()) {
                if (!this.x) {
                    this.A = this.f9166j.a(this.v, this.r);
                    this.x = true;
                    e g2 = this.f9163g.g();
                    j(g2.size() + 1);
                    this.f9167k.b(this, this.q, this.A);
                    Iterator<d> it = g2.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        next.f9172b.execute(new b(next.a));
                    }
                    h();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            }
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void q(com.bumptech.glide.p.i iVar) {
        boolean z;
        this.f9164h.c();
        this.f9163g.i(iVar);
        if (this.f9163g.isEmpty()) {
            g();
            if (!this.x && !this.z) {
                z = false;
                if (z && this.p.get() == 0) {
                    p();
                }
            }
            z = true;
            if (z) {
                p();
            }
        }
    }

    public synchronized void r(h<R> hVar) {
        com.bumptech.glide.load.engine.b0.a i2;
        this.B = hVar;
        if (hVar.X()) {
            i2 = this.l;
        } else {
            i2 = i();
        }
        i2.execute(hVar);
    }

    @Override // com.bumptech.glide.r.l.a.f
    public com.bumptech.glide.r.l.c u() {
        return this.f9164h;
    }

    l(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, c.i.j.f<l<?>> fVar, c cVar) {
        this.f9163g = new e();
        this.f9164h = com.bumptech.glide.r.l.c.a();
        this.p = new AtomicInteger();
        this.l = aVar;
        this.m = aVar2;
        this.n = aVar3;
        this.o = aVar4;
        this.f9167k = mVar;
        this.f9165i = fVar;
        this.f9166j = cVar;
    }
}
