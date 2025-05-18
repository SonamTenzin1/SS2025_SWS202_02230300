package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.k;
import com.google.firebase.crashlytics.internal.o.l;
import com.google.firebase.crashlytics.internal.r.f;
import com.google.firebase.crashlytics.internal.t.i;
import com.google.firebase.j;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: CrashlyticsCore.java */
/* loaded from: classes2.dex */
public class y {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final j f19123b;

    /* renamed from: c, reason: collision with root package name */
    private final e0 f19124c;

    /* renamed from: f, reason: collision with root package name */
    private z f19127f;

    /* renamed from: g, reason: collision with root package name */
    private z f19128g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f19129h;

    /* renamed from: i, reason: collision with root package name */
    private x f19130i;

    /* renamed from: j, reason: collision with root package name */
    private final i0 f19131j;

    /* renamed from: k, reason: collision with root package name */
    private final f f19132k;
    public final com.google.firebase.crashlytics.internal.m.b l;
    private final com.google.firebase.crashlytics.internal.l.a m;
    private final ExecutorService n;
    private final w o;
    private final v p;
    private final com.google.firebase.crashlytics.internal.d q;
    private final k r;

    /* renamed from: e, reason: collision with root package name */
    private final long f19126e = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name */
    private final n0 f19125d = new n0();

    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes2.dex */
    class a implements Callable<Task<Void>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f19133f;

        a(i iVar) {
            this.f19133f = iVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task<Void> call() throws Exception {
            return y.this.f(this.f19133f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f19135f;

        b(i iVar) {
            this.f19135f = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.f(this.f19135f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes2.dex */
    public class c implements Callable<Boolean> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                boolean d2 = y.this.f19127f.d();
                if (!d2) {
                    h.f().k("Initialization marker file was not properly removed.");
                }
                return Boolean.valueOf(d2);
            } catch (Exception e2) {
                h.f().e("Problem encountered deleting Crashlytics initialization marker.", e2);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CrashlyticsCore.java */
    /* loaded from: classes2.dex */
    public class d implements Callable<Boolean> {
        d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(y.this.f19130i.r());
        }
    }

    public y(j jVar, i0 i0Var, com.google.firebase.crashlytics.internal.d dVar, e0 e0Var, com.google.firebase.crashlytics.internal.m.b bVar, com.google.firebase.crashlytics.internal.l.a aVar, f fVar, ExecutorService executorService, v vVar, k kVar) {
        this.f19123b = jVar;
        this.f19124c = e0Var;
        this.a = jVar.i();
        this.f19131j = i0Var;
        this.q = dVar;
        this.l = bVar;
        this.m = aVar;
        this.n = executorService;
        this.f19132k = fVar;
        this.o = new w(executorService);
        this.p = vVar;
        this.r = kVar;
    }

    private void d() {
        try {
            this.f19129h = Boolean.TRUE.equals((Boolean) q0.a(this.o.g(new d())));
        } catch (Exception unused) {
            this.f19129h = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<Void> f(i iVar) {
        m();
        try {
            this.l.a(new com.google.firebase.crashlytics.internal.m.a() { // from class: com.google.firebase.crashlytics.h.n.d
                @Override // com.google.firebase.crashlytics.internal.m.a
                public final void a(String str) {
                    y.this.k(str);
                }
            });
            this.f19130i.R();
            if (!iVar.b().f19545b.a) {
                h.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.d(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f19130i.y(iVar)) {
                h.f().k("Previous sessions could not be finalized.");
            }
            return this.f19130i.T(iVar.a());
        } catch (Exception e2) {
            h.f().e("Crashlytics encountered a problem during asynchronous initialization.", e2);
            return Tasks.d(e2);
        } finally {
            l();
        }
    }

    private void h(i iVar) {
        Future<?> submit = this.n.submit(new b(iVar));
        h.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            h.f().e("Crashlytics was interrupted during initialization.", e2);
        } catch (ExecutionException e3) {
            h.f().e("Crashlytics encountered a problem during initialization.", e3);
        } catch (TimeoutException e4) {
            h.f().e("Crashlytics timed out during initialization.", e4);
        }
    }

    public static String i() {
        return "18.6.1";
    }

    static boolean j(String str, boolean z) {
        if (!z) {
            h.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    boolean e() {
        return this.f19127f.c();
    }

    public Task<Void> g(i iVar) {
        return q0.c(this.n, new a(iVar));
    }

    public void k(String str) {
        this.f19130i.W(System.currentTimeMillis() - this.f19126e, str);
    }

    void l() {
        this.o.g(new c());
    }

    void m() {
        this.o.b();
        this.f19127f.a();
        h.f().i("Initialization marker file was created.");
    }

    public boolean n(l lVar, i iVar) {
        if (j(lVar.f19056b, t.i(this.a, "com.crashlytics.RequireBuildId", true))) {
            String sVar = new s(this.f19131j).toString();
            try {
                this.f19128g = new z("crash_marker", this.f19132k);
                this.f19127f = new z("initialization_marker", this.f19132k);
                l lVar2 = new l(sVar, this.f19132k, this.o);
                com.google.firebase.crashlytics.internal.o.f fVar = new com.google.firebase.crashlytics.internal.o.f(this.f19132k);
                com.google.firebase.crashlytics.internal.u.a aVar = new com.google.firebase.crashlytics.internal.u.a(1024, new com.google.firebase.crashlytics.internal.u.c(10));
                this.r.b(lVar2);
                this.f19130i = new x(this.a, this.o, this.f19131j, this.f19124c, this.f19132k, this.f19128g, lVar, lVar2, fVar, o0.f(this.a, this.f19131j, this.f19132k, lVar, fVar, lVar2, aVar, iVar, this.f19125d, this.p), this.q, this.m, this.p);
                boolean e2 = e();
                d();
                this.f19130i.w(sVar, Thread.getDefaultUncaughtExceptionHandler(), iVar);
                if (e2 && t.d(this.a)) {
                    h.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    h(iVar);
                    return false;
                }
                h.f().b("Successfully configured exception handler.");
                return true;
            } catch (Exception e3) {
                h.f().e("Crashlytics was not started due to an exception during initialization", e3);
                this.f19130i = null;
                return false;
            }
        }
        throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
    }
}
