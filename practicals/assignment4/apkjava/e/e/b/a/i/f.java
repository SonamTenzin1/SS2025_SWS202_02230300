package e.e.b.a.i;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.y;
import e.e.b.a.i.b0.j.j0;
import e.e.b.a.i.b0.j.m0;
import e.e.b.a.i.b0.j.n0;
import e.e.b.a.i.b0.j.o0;
import e.e.b.a.i.b0.j.p0;
import e.e.b.a.i.b0.j.r0;
import e.e.b.a.i.b0.j.s0;
import e.e.b.a.i.b0.j.u0;
import e.e.b.a.i.v;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: DaggerTransportRuntimeComponent.java */
/* loaded from: classes2.dex */
final class f extends v {

    /* renamed from: f, reason: collision with root package name */
    private Provider<Executor> f20832f;

    /* renamed from: g, reason: collision with root package name */
    private Provider<Context> f20833g;

    /* renamed from: h, reason: collision with root package name */
    private Provider f20834h;

    /* renamed from: i, reason: collision with root package name */
    private Provider f20835i;

    /* renamed from: j, reason: collision with root package name */
    private Provider f20836j;

    /* renamed from: k, reason: collision with root package name */
    private Provider<String> f20837k;
    private Provider<r0> l;
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.t> m;
    private Provider<y> n;
    private Provider<e.e.b.a.i.b0.c> o;
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.u> p;
    private Provider<com.google.android.datatransport.runtime.scheduling.jobscheduling.w> q;
    private Provider<u> r;

    /* compiled from: DaggerTransportRuntimeComponent.java */
    /* loaded from: classes2.dex */
    private static final class b implements v.a {
        private Context a;

        private b() {
        }

        @Override // e.e.b.a.i.v.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.a = (Context) e.e.b.a.i.x.a.d.b(context);
            return this;
        }

        @Override // e.e.b.a.i.v.a
        public v c() {
            e.e.b.a.i.x.a.d.a(this.a, Context.class);
            return new f(this.a);
        }
    }

    public static v.a c() {
        return new b();
    }

    private void d(Context context) {
        this.f20832f = e.e.b.a.i.x.a.a.a(l.a());
        e.e.b.a.i.x.a.b a2 = e.e.b.a.i.x.a.c.a(context);
        this.f20833g = a2;
        com.google.android.datatransport.runtime.backends.j a3 = com.google.android.datatransport.runtime.backends.j.a(a2, e.e.b.a.i.c0.c.a(), e.e.b.a.i.c0.d.a());
        this.f20834h = a3;
        this.f20835i = e.e.b.a.i.x.a.a.a(com.google.android.datatransport.runtime.backends.l.a(this.f20833g, a3));
        this.f20836j = u0.a(this.f20833g, m0.a(), o0.a());
        this.f20837k = e.e.b.a.i.x.a.a.a(n0.a(this.f20833g));
        this.l = e.e.b.a.i.x.a.a.a(s0.a(e.e.b.a.i.c0.c.a(), e.e.b.a.i.c0.d.a(), p0.a(), this.f20836j, this.f20837k));
        e.e.b.a.i.b0.g b2 = e.e.b.a.i.b0.g.b(e.e.b.a.i.c0.c.a());
        this.m = b2;
        e.e.b.a.i.b0.i a4 = e.e.b.a.i.b0.i.a(this.f20833g, this.l, b2, e.e.b.a.i.c0.d.a());
        this.n = a4;
        Provider<Executor> provider = this.f20832f;
        Provider provider2 = this.f20835i;
        Provider<r0> provider3 = this.l;
        this.o = e.e.b.a.i.b0.d.a(provider, provider2, a4, provider3, provider3);
        Provider<Context> provider4 = this.f20833g;
        Provider provider5 = this.f20835i;
        Provider<r0> provider6 = this.l;
        this.p = com.google.android.datatransport.runtime.scheduling.jobscheduling.v.a(provider4, provider5, provider6, this.n, this.f20832f, provider6, e.e.b.a.i.c0.c.a(), e.e.b.a.i.c0.d.a(), this.l);
        Provider<Executor> provider7 = this.f20832f;
        Provider<r0> provider8 = this.l;
        this.q = x.a(provider7, provider8, this.n, provider8);
        this.r = e.e.b.a.i.x.a.a.a(w.a(e.e.b.a.i.c0.c.a(), e.e.b.a.i.c0.d.a(), this.o, this.p, this.q));
    }

    @Override // e.e.b.a.i.v
    j0 a() {
        return this.l.get();
    }

    @Override // e.e.b.a.i.v
    u b() {
        return this.r.get();
    }

    private f(Context context) {
        d(context);
    }
}
