package h.a.b0;

import h.a.r;
import h.a.z.g.l;
import h.a.z.g.m;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Schedulers.java */
/* loaded from: classes2.dex */
public final class a {
    static final r a = h.a.a0.a.h(new h());

    /* renamed from: b, reason: collision with root package name */
    static final r f21436b = h.a.a0.a.e(new b());

    /* renamed from: c, reason: collision with root package name */
    static final r f21437c = h.a.a0.a.f(new c());

    /* renamed from: d, reason: collision with root package name */
    static final r f21438d = m.d();

    /* renamed from: e, reason: collision with root package name */
    static final r f21439e = h.a.a0.a.g(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: h.a.b0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0290a {
        static final r a = new h.a.z.g.b();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes2.dex */
    static final class b implements Callable<r> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return C0290a.a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes2.dex */
    static final class c implements Callable<r> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return d.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes2.dex */
    public static final class d {
        static final r a = new h.a.z.g.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes2.dex */
    public static final class e {
        static final r a = new h.a.z.g.f();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes2.dex */
    static final class f implements Callable<r> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return e.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes2.dex */
    public static final class g {
        static final r a = new l();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes2.dex */
    static final class h implements Callable<r> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r call() throws Exception {
            return g.a;
        }
    }

    public static r a(Executor executor) {
        return new h.a.z.g.d(executor, false);
    }

    public static r b() {
        return h.a.a0.a.p(f21437c);
    }

    public static r c() {
        return h.a.a0.a.r(a);
    }
}
