package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.w.a;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.k0;
import com.google.firebase.messaging.o0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class FirebaseMessaging {
    private static final long a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static o0 f19764b;

    /* renamed from: c, reason: collision with root package name */
    @SuppressLint({"FirebaseUnknownNullness"})
    static e.e.b.a.g f19765c;

    /* renamed from: d, reason: collision with root package name */
    static ScheduledExecutorService f19766d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.j f19767e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.firebase.iid.w.a f19768f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.firebase.installations.i f19769g;

    /* renamed from: h, reason: collision with root package name */
    private final Context f19770h;

    /* renamed from: i, reason: collision with root package name */
    private final b0 f19771i;

    /* renamed from: j, reason: collision with root package name */
    private final k0 f19772j;

    /* renamed from: k, reason: collision with root package name */
    private final a f19773k;
    private final Executor l;
    private final Executor m;
    private final Task<t0> n;
    private final g0 o;
    private boolean p;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    public class a {
        private final com.google.firebase.q.d a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f19774b;

        /* renamed from: c, reason: collision with root package name */
        private com.google.firebase.q.b<com.google.firebase.h> f19775c;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f19776d;

        a(com.google.firebase.q.d dVar) {
            this.a = dVar;
        }

        private Boolean d() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context i2 = FirebaseMessaging.this.f19767e.i();
            SharedPreferences sharedPreferences = i2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = i2.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(i2.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void a() {
            if (this.f19774b) {
                return;
            }
            Boolean d2 = d();
            this.f19776d = d2;
            if (d2 == null) {
                com.google.firebase.q.b<com.google.firebase.h> bVar = new com.google.firebase.q.b(this) { // from class: com.google.firebase.messaging.v
                    private final FirebaseMessaging.a a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // com.google.firebase.q.b
                    public void a(com.google.firebase.q.a aVar) {
                        this.a.c(aVar);
                    }
                };
                this.f19775c = bVar;
                this.a.a(com.google.firebase.h.class, bVar);
            }
            this.f19774b = true;
        }

        synchronized boolean b() {
            boolean r;
            a();
            Boolean bool = this.f19776d;
            if (bool == null) {
                r = FirebaseMessaging.this.f19767e.r();
            } else {
                r = bool.booleanValue();
            }
            return r;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void c(com.google.firebase.q.a aVar) {
            if (b()) {
                FirebaseMessaging.this.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(com.google.firebase.j jVar, com.google.firebase.iid.w.a aVar, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar, e.e.b.a.g gVar, com.google.firebase.q.d dVar) {
        this(jVar, aVar, bVar, bVar2, iVar, gVar, dVar, new g0(jVar.i()));
    }

    private String g() {
        return "[DEFAULT]".equals(this.f19767e.k()) ? HttpUrl.FRAGMENT_ENCODE_SET : this.f19767e.m();
    }

    @Keep
    static synchronized FirebaseMessaging getInstance(com.google.firebase.j jVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) jVar.h(FirebaseMessaging.class);
            Preconditions.l(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public static e.e.b.a.g i() {
        return f19765c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void d(String str) {
        if ("[DEFAULT]".equals(this.f19767e.k())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(this.f19767e.k());
                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new o(this.f19770h).g(intent);
        }
    }

    private synchronized void r() {
        if (this.p) {
            return;
        }
        t(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        com.google.firebase.iid.w.a aVar = this.f19768f;
        if (aVar != null) {
            aVar.a();
        } else if (u(h())) {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() throws IOException {
        com.google.firebase.iid.w.a aVar = this.f19768f;
        if (aVar != null) {
            try {
                return (String) Tasks.a(aVar.b());
            } catch (InterruptedException | ExecutionException e2) {
                throw new IOException(e2);
            }
        }
        o0.a h2 = h();
        if (!u(h2)) {
            return h2.f19842b;
        }
        final String c2 = g0.c(this.f19767e);
        try {
            String str = (String) Tasks.a(this.f19769g.getId().h(p.d(), new Continuation(this, c2) { // from class: com.google.firebase.messaging.t
                private final FirebaseMessaging a;

                /* renamed from: b, reason: collision with root package name */
                private final String f19862b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f19862b = c2;
                }

                @Override // com.google.android.gms.tasks.Continuation
                public Object a(Task task) {
                    return this.a.n(this.f19862b, task);
                }
            }));
            f19764b.f(g(), c2, str, this.o.a());
            if (h2 == null || !str.equals(h2.f19842b)) {
                d(str);
            }
            return str;
        } catch (InterruptedException | ExecutionException e3) {
            throw new IOException(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Runnable runnable, long j2) {
        synchronized (FirebaseMessaging.class) {
            if (f19766d == null) {
                f19766d = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            f19766d.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f19770h;
    }

    o0.a h() {
        return f19764b.d(g(), g0.c(this.f19767e));
    }

    public boolean k() {
        return this.f19773k.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.o.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task m(Task task) {
        return this.f19771i.d((String) task.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task n(String str, final Task task) throws Exception {
        return this.f19772j.a(str, new k0.a(this, task) { // from class: com.google.firebase.messaging.u
            private final FirebaseMessaging a;

            /* renamed from: b, reason: collision with root package name */
            private final Task f19872b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f19872b = task;
            }

            @Override // com.google.firebase.messaging.k0.a
            public Task start() {
                return this.a.m(this.f19872b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void o() {
        if (k()) {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void p(t0 t0Var) {
        if (k()) {
            t0Var.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void q(boolean z) {
        this.p = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void t(long j2) {
        e(new p0(this, Math.min(Math.max(30L, j2 + j2), a)), j2);
        this.p = true;
    }

    boolean u(o0.a aVar) {
        return aVar == null || aVar.b(this.o.a());
    }

    FirebaseMessaging(com.google.firebase.j jVar, com.google.firebase.iid.w.a aVar, com.google.firebase.s.b<com.google.firebase.u.i> bVar, com.google.firebase.s.b<com.google.firebase.r.j> bVar2, com.google.firebase.installations.i iVar, e.e.b.a.g gVar, com.google.firebase.q.d dVar, g0 g0Var) {
        this(jVar, aVar, iVar, gVar, dVar, g0Var, new b0(jVar, g0Var, bVar, bVar2, iVar), p.e(), p.b());
    }

    FirebaseMessaging(com.google.firebase.j jVar, com.google.firebase.iid.w.a aVar, com.google.firebase.installations.i iVar, e.e.b.a.g gVar, com.google.firebase.q.d dVar, g0 g0Var, b0 b0Var, Executor executor, Executor executor2) {
        this.p = false;
        f19765c = gVar;
        this.f19767e = jVar;
        this.f19768f = aVar;
        this.f19769g = iVar;
        this.f19773k = new a(dVar);
        Context i2 = jVar.i();
        this.f19770h = i2;
        this.o = g0Var;
        this.m = executor;
        this.f19771i = b0Var;
        this.f19772j = new k0(executor);
        this.l = executor2;
        if (aVar != null) {
            aVar.c(new a.InterfaceC0229a(this) { // from class: com.google.firebase.messaging.q
                private final FirebaseMessaging a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // com.google.firebase.iid.w.a.InterfaceC0229a
                public void a(String str) {
                    this.a.d(str);
                }
            });
        }
        synchronized (FirebaseMessaging.class) {
            if (f19764b == null) {
                f19764b = new o0(i2);
            }
        }
        executor2.execute(new Runnable(this) { // from class: com.google.firebase.messaging.r

            /* renamed from: f, reason: collision with root package name */
            private final FirebaseMessaging f19852f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f19852f = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19852f.o();
            }
        });
        Task<t0> d2 = t0.d(this, iVar, g0Var, b0Var, i2, p.f());
        this.n = d2;
        d2.e(p.g(), new OnSuccessListener(this) { // from class: com.google.firebase.messaging.s
            private final FirebaseMessaging a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                this.a.p((t0) obj);
            }
        });
    }
}
