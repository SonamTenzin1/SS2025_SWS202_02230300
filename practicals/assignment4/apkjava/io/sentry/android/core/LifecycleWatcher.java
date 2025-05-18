package io.sentry.android.core;

import androidx.lifecycle.DefaultLifecycleObserver;
import io.sentry.d5;
import io.sentry.s3;
import io.sentry.s4;
import io.sentry.t3;
import io.sentry.v1;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class LifecycleWatcher implements DefaultLifecycleObserver {
    private final AtomicLong a;

    /* renamed from: b, reason: collision with root package name */
    private final long f22038b;

    /* renamed from: c, reason: collision with root package name */
    private TimerTask f22039c;

    /* renamed from: d, reason: collision with root package name */
    private final Timer f22040d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f22041e;

    /* renamed from: f, reason: collision with root package name */
    private final v1 f22042f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f22043g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f22044h;

    /* renamed from: i, reason: collision with root package name */
    private final io.sentry.transport.q f22045i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LifecycleWatcher.this.e("end");
            LifecycleWatcher.this.f22042f.endSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleWatcher(v1 v1Var, long j2, boolean z, boolean z2) {
        this(v1Var, j2, z, z2, io.sentry.transport.o.b());
    }

    private void d(String str) {
        if (this.f22044h) {
            io.sentry.v0 v0Var = new io.sentry.v0();
            v0Var.p("navigation");
            v0Var.m("state", str);
            v0Var.l("app.lifecycle");
            v0Var.n(s4.INFO);
            this.f22042f.i(v0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        this.f22042f.i(io.sentry.android.core.internal.util.i.a(str));
    }

    private void f() {
        synchronized (this.f22041e) {
            TimerTask timerTask = this.f22039c;
            if (timerTask != null) {
                timerTask.cancel();
                this.f22039c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(s3 s3Var) {
        d5 r;
        if (this.a.get() != 0 || (r = s3Var.r()) == null || r.k() == null) {
            return;
        }
        this.a.set(r.k().getTime());
    }

    private void i() {
        synchronized (this.f22041e) {
            f();
            if (this.f22040d != null) {
                a aVar = new a();
                this.f22039c = aVar;
                this.f22040d.schedule(aVar, this.f22038b);
            }
        }
    }

    private void j() {
        if (this.f22043g) {
            f();
            long a2 = this.f22045i.a();
            this.f22042f.o(new t3() { // from class: io.sentry.android.core.z
                @Override // io.sentry.t3
                public final void a(s3 s3Var) {
                    LifecycleWatcher.this.h(s3Var);
                }
            });
            long j2 = this.a.get();
            if (j2 == 0 || j2 + this.f22038b <= a2) {
                e("start");
                this.f22042f.startSession();
            }
            this.a.set(a2);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.e
    public /* synthetic */ void onCreate(androidx.lifecycle.k kVar) {
        androidx.lifecycle.c.a(this, kVar);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.e
    public /* synthetic */ void onDestroy(androidx.lifecycle.k kVar) {
        androidx.lifecycle.c.b(this, kVar);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.e
    public /* synthetic */ void onPause(androidx.lifecycle.k kVar) {
        androidx.lifecycle.c.c(this, kVar);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.e
    public /* synthetic */ void onResume(androidx.lifecycle.k kVar) {
        androidx.lifecycle.c.d(this, kVar);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.e
    public void onStart(androidx.lifecycle.k kVar) {
        j();
        d("foreground");
        r0.a().c(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.e
    public void onStop(androidx.lifecycle.k kVar) {
        if (this.f22043g) {
            this.a.set(this.f22045i.a());
            i();
        }
        r0.a().c(true);
        d("background");
    }

    LifecycleWatcher(v1 v1Var, long j2, boolean z, boolean z2, io.sentry.transport.q qVar) {
        this.a = new AtomicLong(0L);
        this.f22041e = new Object();
        this.f22038b = j2;
        this.f22043g = z;
        this.f22044h = z2;
        this.f22042f = v1Var;
        this.f22045i = qVar;
        if (z) {
            this.f22040d = new Timer(true);
        } else {
            this.f22040d = null;
        }
    }
}
