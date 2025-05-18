package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.android.core.l0;
import io.sentry.e2;
import io.sentry.f2;
import io.sentry.k3;
import io.sentry.m3;
import io.sentry.n3;
import io.sentry.q1;
import io.sentry.s4;
import io.sentry.v1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidTransactionProfiler.java */
/* loaded from: classes2.dex */
public final class m0 implements f2 {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final SentryAndroidOptions f22231b;

    /* renamed from: c, reason: collision with root package name */
    private final v1 f22232c;

    /* renamed from: d, reason: collision with root package name */
    private final s0 f22233d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22234e;

    /* renamed from: f, reason: collision with root package name */
    private int f22235f;

    /* renamed from: g, reason: collision with root package name */
    private final io.sentry.android.core.internal.util.t f22236g;

    /* renamed from: h, reason: collision with root package name */
    private n3 f22237h;

    /* renamed from: i, reason: collision with root package name */
    private e2 f22238i;

    /* renamed from: j, reason: collision with root package name */
    private l0 f22239j;

    /* renamed from: k, reason: collision with root package name */
    private long f22240k;
    private long l;

    public m0(Context context, SentryAndroidOptions sentryAndroidOptions, s0 s0Var, io.sentry.android.core.internal.util.t tVar) {
        this(context, sentryAndroidOptions, s0Var, tVar, q1.a());
    }

    private ActivityManager.MemoryInfo c() {
        try {
            ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            this.f22231b.getLogger().c(s4.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            this.f22231b.getLogger().b(s4.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    private void d() {
        if (this.f22234e) {
            return;
        }
        this.f22234e = true;
        String profilingTracesDirPath = this.f22231b.getProfilingTracesDirPath();
        if (!this.f22231b.isProfilingEnabled()) {
            this.f22231b.getLogger().c(s4.INFO, "Profiling is disabled in options.", new Object[0]);
            return;
        }
        if (profilingTracesDirPath == null) {
            this.f22231b.getLogger().c(s4.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            return;
        }
        int profilingTracesHz = this.f22231b.getProfilingTracesHz();
        if (profilingTracesHz <= 0) {
            this.f22231b.getLogger().c(s4.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(profilingTracesHz));
        } else {
            this.f22239j = new l0(profilingTracesDirPath, ((int) TimeUnit.SECONDS.toMicros(1L)) / profilingTracesHz, this.f22236g, this.f22231b.getExecutorService(), this.f22231b.getLogger(), this.f22233d);
        }
    }

    @SuppressLint({"NewApi"})
    private boolean f(e2 e2Var) {
        l0.c j2;
        l0 l0Var = this.f22239j;
        if (l0Var == null || (j2 = l0Var.j()) == null) {
            return false;
        }
        long j3 = j2.a;
        this.f22240k = j3;
        this.l = j2.f22230b;
        this.f22238i = e2Var;
        this.f22237h = new n3(e2Var, Long.valueOf(j3), Long.valueOf(this.l));
        return true;
    }

    @SuppressLint({"NewApi"})
    private synchronized m3 g(e2 e2Var, boolean z, List<k3> list) {
        String str;
        if (this.f22239j == null) {
            return null;
        }
        if (this.f22233d.d() < 21) {
            return null;
        }
        n3 n3Var = this.f22237h;
        if (n3Var != null && n3Var.h().equals(e2Var.k().toString())) {
            int i2 = this.f22235f;
            if (i2 > 0) {
                this.f22235f = i2 - 1;
            }
            this.f22231b.getLogger().c(s4.DEBUG, "Transaction %s (%s) finished.", e2Var.getName(), e2Var.m().k().toString());
            if (this.f22235f != 0) {
                n3 n3Var2 = this.f22237h;
                if (n3Var2 != null) {
                    n3Var2.i(Long.valueOf(SystemClock.elapsedRealtimeNanos()), Long.valueOf(this.f22240k), Long.valueOf(Process.getElapsedCpuTime()), Long.valueOf(this.l));
                }
                return null;
            }
            l0.b f2 = this.f22239j.f(false, list);
            if (f2 == null) {
                return null;
            }
            long j2 = f2.a - this.f22240k;
            ArrayList arrayList = new ArrayList(1);
            n3 n3Var3 = this.f22237h;
            if (n3Var3 != null) {
                arrayList.add(n3Var3);
            }
            this.f22237h = null;
            this.f22235f = 0;
            this.f22238i = null;
            ActivityManager.MemoryInfo c2 = c();
            String l = c2 != null ? Long.toString(c2.totalMem) : "0";
            String[] strArr = Build.SUPPORTED_ABIS;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((n3) it.next()).i(Long.valueOf(f2.a), Long.valueOf(this.f22240k), Long.valueOf(f2.f22226b), Long.valueOf(this.l));
            }
            File file = f2.f22227c;
            String l2 = Long.toString(j2);
            int d2 = this.f22233d.d();
            String str2 = (strArr == null || strArr.length <= 0) ? HttpUrl.FRAGMENT_ENCODE_SET : strArr[0];
            u uVar = new Callable() { // from class: io.sentry.android.core.u
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    List c3;
                    c3 = io.sentry.android.core.internal.util.m.a().c();
                    return c3;
                }
            };
            String b2 = this.f22233d.b();
            String c3 = this.f22233d.c();
            String e2 = this.f22233d.e();
            Boolean f3 = this.f22233d.f();
            String proguardUuid = this.f22231b.getProguardUuid();
            String release = this.f22231b.getRelease();
            String environment = this.f22231b.getEnvironment();
            if (!f2.f22229e && !z) {
                str = "normal";
                return new m3(file, arrayList, e2Var, l2, d2, str2, uVar, b2, c3, e2, f3, l, proguardUuid, release, environment, str, f2.f22228d);
            }
            str = "timeout";
            return new m3(file, arrayList, e2Var, l2, d2, str2, uVar, b2, c3, e2, f3, l, proguardUuid, release, environment, str, f2.f22228d);
        }
        this.f22231b.getLogger().c(s4.INFO, "Transaction %s (%s) finished, but was not currently being profiled. Skipping", e2Var.getName(), e2Var.m().k().toString());
        return null;
    }

    @Override // io.sentry.f2
    public synchronized m3 a(e2 e2Var, List<k3> list) {
        return g(e2Var, false, list);
    }

    @Override // io.sentry.f2
    public synchronized void b(e2 e2Var) {
        if (this.f22233d.d() < 21) {
            return;
        }
        d();
        int i2 = this.f22235f + 1;
        this.f22235f = i2;
        if (i2 == 1) {
            if (f(e2Var)) {
                this.f22231b.getLogger().c(s4.DEBUG, "Transaction %s (%s) started and being profiled.", e2Var.getName(), e2Var.m().k().toString());
            }
        } else {
            this.f22235f = i2 - 1;
            this.f22231b.getLogger().c(s4.WARNING, "A transaction is already being profiled. Transaction %s (%s) will be ignored.", e2Var.getName(), e2Var.m().k().toString());
        }
    }

    @Override // io.sentry.f2
    public void close() {
        e2 e2Var = this.f22238i;
        if (e2Var != null) {
            g(e2Var, true, null);
        }
        l0 l0Var = this.f22239j;
        if (l0Var != null) {
            l0Var.e();
        }
    }

    public m0(Context context, SentryAndroidOptions sentryAndroidOptions, s0 s0Var, io.sentry.android.core.internal.util.t tVar, v1 v1Var) {
        this.f22234e = false;
        this.f22235f = 0;
        this.f22238i = null;
        this.f22239j = null;
        this.a = (Context) io.sentry.util.q.c(context, "The application context is required");
        this.f22231b = (SentryAndroidOptions) io.sentry.util.q.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f22232c = (v1) io.sentry.util.q.c(v1Var, "Hub is required");
        this.f22236g = (io.sentry.android.core.internal.util.t) io.sentry.util.q.c(tVar, "SentryFrameMetricsCollector is required");
        this.f22233d = (s0) io.sentry.util.q.c(s0Var, "The BuildInfoProvider is required.");
    }
}
