package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.components.x;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.r.d;
import com.google.firebase.installations.r.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FirebaseInstallations.java */
/* loaded from: classes2.dex */
public class h implements i {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadFactory f19681b = new a();

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.j f19682c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.firebase.installations.r.c f19683d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.installations.q.c f19684e;

    /* renamed from: f, reason: collision with root package name */
    private final o f19685f;

    /* renamed from: g, reason: collision with root package name */
    private final x<com.google.firebase.installations.q.b> f19686g;

    /* renamed from: h, reason: collision with root package name */
    private final m f19687h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f19688i;

    /* renamed from: j, reason: collision with root package name */
    private final ExecutorService f19689j;

    /* renamed from: k, reason: collision with root package name */
    private final Executor f19690k;
    private String l;
    private Set<com.google.firebase.installations.p.a> m;
    private final List<n> n;

    /* compiled from: FirebaseInstallations.java */
    /* loaded from: classes2.dex */
    class a implements ThreadFactory {

        /* renamed from: f, reason: collision with root package name */
        private final AtomicInteger f19691f = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        @SuppressLint({"ThreadPoolCreation"})
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f19691f.getAndIncrement())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FirebaseInstallations.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f19692b;

        static {
            int[] iArr = new int[f.b.values().length];
            f19692b = iArr;
            try {
                iArr[f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19692b[f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19692b[f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public h(final com.google.firebase.j jVar, com.google.firebase.s.b<com.google.firebase.r.i> bVar, ExecutorService executorService, Executor executor) {
        this(executorService, executor, jVar, new com.google.firebase.installations.r.c(jVar.i(), bVar), new com.google.firebase.installations.q.c(jVar), o.c(), new x(new com.google.firebase.s.b() { // from class: com.google.firebase.installations.a
            @Override // com.google.firebase.s.b
            public final Object get() {
                return h.w(com.google.firebase.j.this);
            }
        }), new m());
    }

    private void A(Exception exc) {
        synchronized (this.f19688i) {
            Iterator<n> it = this.n.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    private void B(com.google.firebase.installations.q.d dVar) {
        synchronized (this.f19688i) {
            Iterator<n> it = this.n.iterator();
            while (it.hasNext()) {
                if (it.next().b(dVar)) {
                    it.remove();
                }
            }
        }
    }

    private synchronized void C(String str) {
        this.l = str;
    }

    private synchronized void D(com.google.firebase.installations.q.d dVar, com.google.firebase.installations.q.d dVar2) {
        if (this.m.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator<com.google.firebase.installations.p.a> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().a(dVar2.d());
            }
        }
    }

    private Task<l> b() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        d(new j(this.f19685f, taskCompletionSource));
        return taskCompletionSource.a();
    }

    private Task<String> c() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        d(new k(taskCompletionSource));
        return taskCompletionSource.a();
    }

    private void d(n nVar) {
        synchronized (this.f19688i) {
            this.n.add(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(boolean z) {
        com.google.firebase.installations.q.d z2;
        com.google.firebase.installations.q.d m = m();
        try {
            if (!m.i() && !m.l()) {
                if (!z && !this.f19685f.f(m)) {
                    return;
                }
                z2 = g(m);
                p(z2);
                D(m, z2);
                if (z2.k()) {
                    C(z2.d());
                }
                if (!z2.i()) {
                    A(new FirebaseInstallationsException(FirebaseInstallationsException.a.BAD_CONFIG));
                    return;
                } else if (z2.j()) {
                    A(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                    return;
                } else {
                    B(z2);
                    return;
                }
            }
            z2 = z(m);
            p(z2);
            D(m, z2);
            if (z2.k()) {
            }
            if (!z2.i()) {
            }
        } catch (FirebaseInstallationsException e2) {
            A(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void v(final boolean z) {
        com.google.firebase.installations.q.d n = n();
        if (z) {
            n = n.p();
        }
        B(n);
        this.f19690k.execute(new Runnable() { // from class: com.google.firebase.installations.c
            @Override // java.lang.Runnable
            public final void run() {
                h.this.r(z);
            }
        });
    }

    private com.google.firebase.installations.q.d g(com.google.firebase.installations.q.d dVar) throws FirebaseInstallationsException {
        com.google.firebase.installations.r.f e2 = this.f19683d.e(h(), dVar.d(), o(), dVar.f());
        int i2 = b.f19692b[e2.b().ordinal()];
        if (i2 == 1) {
            return dVar.o(e2.c(), e2.d(), this.f19685f.b());
        }
        if (i2 == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i2 == 3) {
            C(null);
            return dVar.r();
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.a.UNAVAILABLE);
    }

    private synchronized String j() {
        return this.l;
    }

    private com.google.firebase.installations.q.b k() {
        return this.f19686g.get();
    }

    public static h l(com.google.firebase.j jVar) {
        Preconditions.b(jVar != null, "Null is not a valid value of FirebaseApp.");
        return (h) jVar.h(i.class);
    }

    private com.google.firebase.installations.q.d m() {
        com.google.firebase.installations.q.d d2;
        synchronized (a) {
            g a2 = g.a(this.f19682c.i(), "generatefid.lock");
            try {
                d2 = this.f19684e.d();
            } finally {
                if (a2 != null) {
                    a2.b();
                }
            }
        }
        return d2;
    }

    private com.google.firebase.installations.q.d n() {
        com.google.firebase.installations.q.d d2;
        synchronized (a) {
            g a2 = g.a(this.f19682c.i(), "generatefid.lock");
            try {
                d2 = this.f19684e.d();
                if (d2.j()) {
                    d2 = this.f19684e.b(d2.t(y(d2)));
                }
            } finally {
                if (a2 != null) {
                    a2.b();
                }
            }
        }
        return d2;
    }

    private void p(com.google.firebase.installations.q.d dVar) {
        synchronized (a) {
            g a2 = g.a(this.f19682c.i(), "generatefid.lock");
            try {
                this.f19684e.b(dVar);
            } finally {
                if (a2 != null) {
                    a2.b();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t() {
        u(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.firebase.installations.q.b w(com.google.firebase.j jVar) {
        return new com.google.firebase.installations.q.b(jVar);
    }

    private void x() {
        Preconditions.h(i(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.h(o(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.h(h(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.b(o.h(i()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.b(o.g(h()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String y(com.google.firebase.installations.q.d dVar) {
        if ((!this.f19682c.k().equals("CHIME_ANDROID_SDK") && !this.f19682c.s()) || !dVar.m()) {
            return this.f19687h.a();
        }
        String f2 = k().f();
        return TextUtils.isEmpty(f2) ? this.f19687h.a() : f2;
    }

    private com.google.firebase.installations.q.d z(com.google.firebase.installations.q.d dVar) throws FirebaseInstallationsException {
        com.google.firebase.installations.r.d d2 = this.f19683d.d(h(), dVar.d(), o(), i(), (dVar.d() == null || dVar.d().length() != 11) ? null : k().i());
        int i2 = b.a[d2.e().ordinal()];
        if (i2 == 1) {
            return dVar.s(d2.c(), d2.d(), this.f19685f.b(), d2.b().c(), d2.b().d());
        }
        if (i2 == 2) {
            return dVar.q("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.a.UNAVAILABLE);
    }

    @Override // com.google.firebase.installations.i
    public Task<l> a(final boolean z) {
        x();
        Task<l> b2 = b();
        this.f19689j.execute(new Runnable() { // from class: com.google.firebase.installations.d
            @Override // java.lang.Runnable
            public final void run() {
                h.this.v(z);
            }
        });
        return b2;
    }

    @Override // com.google.firebase.installations.i
    public Task<String> getId() {
        x();
        String j2 = j();
        if (j2 != null) {
            return Tasks.e(j2);
        }
        Task<String> c2 = c();
        this.f19689j.execute(new Runnable() { // from class: com.google.firebase.installations.b
            @Override // java.lang.Runnable
            public final void run() {
                h.this.t();
            }
        });
        return c2;
    }

    String h() {
        return this.f19682c.l().b();
    }

    String i() {
        return this.f19682c.l().c();
    }

    String o() {
        return this.f19682c.l().e();
    }

    @SuppressLint({"ThreadPoolCreation"})
    h(ExecutorService executorService, Executor executor, com.google.firebase.j jVar, com.google.firebase.installations.r.c cVar, com.google.firebase.installations.q.c cVar2, o oVar, x<com.google.firebase.installations.q.b> xVar, m mVar) {
        this.f19688i = new Object();
        this.m = new HashSet();
        this.n = new ArrayList();
        this.f19682c = jVar;
        this.f19683d = cVar;
        this.f19684e = cVar2;
        this.f19685f = oVar;
        this.f19686g = xVar;
        this.f19687h = mVar;
        this.f19689j = executorService;
        this.f19690k = executor;
    }
}
