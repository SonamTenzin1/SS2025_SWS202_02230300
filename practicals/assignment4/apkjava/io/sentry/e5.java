package io.sentry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: Span.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class e5 implements d2 {
    private f4 a;

    /* renamed from: b, reason: collision with root package name */
    private f4 f22391b;

    /* renamed from: c, reason: collision with root package name */
    private final f5 f22392c;

    /* renamed from: d, reason: collision with root package name */
    private final b5 f22393d;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f22394e;

    /* renamed from: f, reason: collision with root package name */
    private final v1 f22395f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f22396g;

    /* renamed from: h, reason: collision with root package name */
    private final i5 f22397h;

    /* renamed from: i, reason: collision with root package name */
    private g5 f22398i;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Object> f22399j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e5(io.sentry.protocol.q qVar, h5 h5Var, b5 b5Var, String str, v1 v1Var, f4 f4Var, i5 i5Var, g5 g5Var) {
        this.f22396g = new AtomicBoolean(false);
        this.f22399j = new ConcurrentHashMap();
        this.f22392c = new f5(qVar, new h5(), str, h5Var, b5Var.B());
        this.f22393d = (b5) io.sentry.util.q.c(b5Var, "transaction is required");
        this.f22395f = (v1) io.sentry.util.q.c(v1Var, "hub is required");
        this.f22397h = i5Var;
        this.f22398i = g5Var;
        if (f4Var != null) {
            this.a = f4Var;
        } else {
            this.a = v1Var.q().getDateProvider().a();
        }
    }

    private void F(f4 f4Var) {
        this.a = f4Var;
    }

    private List<e5> s() {
        ArrayList arrayList = new ArrayList();
        for (e5 e5Var : this.f22393d.C()) {
            if (e5Var.v() != null && e5Var.v().equals(x())) {
                arrayList.add(e5Var);
            }
        }
        return arrayList;
    }

    public Boolean A() {
        return this.f22392c.e();
    }

    public Boolean B() {
        return this.f22392c.f();
    }

    public void C(String str, Object obj) {
        if (this.f22396g.get()) {
            return;
        }
        this.f22399j.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(g5 g5Var) {
        this.f22398i = g5Var;
    }

    public d2 E(String str, String str2, f4 f4Var, h2 h2Var, i5 i5Var) {
        if (this.f22396g.get()) {
            return c3.r();
        }
        return this.f22393d.N(this.f22392c.h(), str, str2, f4Var, h2Var, i5Var);
    }

    @Override // io.sentry.d2
    public boolean b() {
        return this.f22396g.get();
    }

    @Override // io.sentry.d2
    public boolean c(f4 f4Var) {
        if (this.f22391b == null) {
            return false;
        }
        this.f22391b = f4Var;
        return true;
    }

    @Override // io.sentry.d2
    public void d(j5 j5Var) {
        o(j5Var, this.f22395f.q().getDateProvider().a());
    }

    @Override // io.sentry.d2
    public void g() {
        d(this.f22392c.i());
    }

    @Override // io.sentry.d2
    public String getDescription() {
        return this.f22392c.a();
    }

    @Override // io.sentry.d2
    public j5 getStatus() {
        return this.f22392c.i();
    }

    @Override // io.sentry.d2
    public void h(String str, Number number, v2 v2Var) {
        this.f22393d.h(str, number, v2Var);
    }

    @Override // io.sentry.d2
    public void j(String str) {
        if (this.f22396g.get()) {
            return;
        }
        this.f22392c.l(str);
    }

    @Override // io.sentry.d2
    public f5 m() {
        return this.f22392c;
    }

    @Override // io.sentry.d2
    public f4 n() {
        return this.f22391b;
    }

    @Override // io.sentry.d2
    public void o(j5 j5Var, f4 f4Var) {
        List<e5> s;
        f4 f4Var2;
        if (this.f22396g.compareAndSet(false, true)) {
            this.f22392c.o(j5Var);
            if (f4Var == null) {
                f4Var = this.f22395f.q().getDateProvider().a();
            }
            this.f22391b = f4Var;
            if (this.f22397h.c() || this.f22397h.b()) {
                if (this.f22393d.A().x().equals(x())) {
                    s = this.f22393d.x();
                } else {
                    s = s();
                }
                f4 f4Var3 = null;
                f4 f4Var4 = null;
                for (e5 e5Var : s) {
                    if (f4Var3 == null || e5Var.q().u(f4Var3)) {
                        f4Var3 = e5Var.q();
                    }
                    if (f4Var4 == null || (e5Var.n() != null && e5Var.n().q(f4Var4))) {
                        f4Var4 = e5Var.n();
                    }
                }
                if (this.f22397h.c() && f4Var3 != null && this.a.u(f4Var3)) {
                    F(f4Var3);
                }
                if (this.f22397h.b() && f4Var4 != null && ((f4Var2 = this.f22391b) == null || f4Var2.q(f4Var4))) {
                    c(f4Var4);
                }
            }
            Throwable th = this.f22394e;
            if (th != null) {
                this.f22395f.p(th, this, this.f22393d.getName());
            }
            g5 g5Var = this.f22398i;
            if (g5Var != null) {
                g5Var.a(this);
            }
        }
    }

    @Override // io.sentry.d2
    public f4 q() {
        return this.a;
    }

    public Map<String, Object> r() {
        return this.f22399j;
    }

    public String t() {
        return this.f22392c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i5 u() {
        return this.f22397h;
    }

    public h5 v() {
        return this.f22392c.d();
    }

    public q5 w() {
        return this.f22392c.g();
    }

    public h5 x() {
        return this.f22392c.h();
    }

    public Map<String, String> y() {
        return this.f22392c.j();
    }

    public io.sentry.protocol.q z() {
        return this.f22392c.k();
    }

    public e5(r5 r5Var, b5 b5Var, v1 v1Var, f4 f4Var, i5 i5Var) {
        this.f22396g = new AtomicBoolean(false);
        this.f22399j = new ConcurrentHashMap();
        this.f22392c = (f5) io.sentry.util.q.c(r5Var, "context is required");
        this.f22393d = (b5) io.sentry.util.q.c(b5Var, "sentryTracer is required");
        this.f22395f = (v1) io.sentry.util.q.c(v1Var, "hub is required");
        this.f22398i = null;
        if (f4Var != null) {
            this.a = f4Var;
        } else {
            this.a = v1Var.q().getDateProvider().a();
        }
        this.f22397h = i5Var;
    }
}
