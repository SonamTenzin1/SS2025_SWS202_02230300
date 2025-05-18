package com.google.firebase.crashlytics.internal.s;

import android.annotation.SuppressLint;
import android.database.SQLException;
import android.os.SystemClock;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.b0;
import com.google.firebase.crashlytics.internal.n.n0;
import com.google.firebase.crashlytics.internal.n.q0;
import com.google.firebase.crashlytics.internal.p.f0;
import com.google.firebase.crashlytics.internal.t.d;
import e.e.b.a.c;
import e.e.b.a.f;
import e.e.b.a.i.m;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportQueue.java */
/* loaded from: classes2.dex */
public final class e {
    private final double a;

    /* renamed from: b, reason: collision with root package name */
    private final double f19530b;

    /* renamed from: c, reason: collision with root package name */
    private final long f19531c;

    /* renamed from: d, reason: collision with root package name */
    private final long f19532d;

    /* renamed from: e, reason: collision with root package name */
    private final int f19533e;

    /* renamed from: f, reason: collision with root package name */
    private final BlockingQueue<Runnable> f19534f;

    /* renamed from: g, reason: collision with root package name */
    private final ThreadPoolExecutor f19535g;

    /* renamed from: h, reason: collision with root package name */
    private final f<f0> f19536h;

    /* renamed from: i, reason: collision with root package name */
    private final n0 f19537i;

    /* renamed from: j, reason: collision with root package name */
    private int f19538j;

    /* renamed from: k, reason: collision with root package name */
    private long f19539k;

    /* compiled from: ReportQueue.java */
    /* loaded from: classes2.dex */
    private final class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private final b0 f19540f;

        /* renamed from: g, reason: collision with root package name */
        private final TaskCompletionSource<b0> f19541g;

        @Override // java.lang.Runnable
        public void run() {
            e.this.p(this.f19540f, this.f19541g);
            e.this.f19537i.c();
            double e2 = e.this.e();
            h.f().b("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(e2 / 1000.0d)) + " s for report: " + this.f19540f.d());
            e.q(e2);
        }

        private b(b0 b0Var, TaskCompletionSource<b0> taskCompletionSource) {
            this.f19540f = b0Var;
            this.f19541g = taskCompletionSource;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f<f0> fVar, d dVar, n0 n0Var) {
        this(dVar.f19549f, dVar.f19550g, dVar.f19551h * 1000, fVar, n0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double e() {
        return Math.min(3600000.0d, (60000.0d / this.a) * Math.pow(this.f19530b, f()));
    }

    private int f() {
        int max;
        if (this.f19539k == 0) {
            this.f19539k = o();
        }
        int o = (int) ((o() - this.f19539k) / this.f19531c);
        if (j()) {
            max = Math.min(100, this.f19538j + o);
        } else {
            max = Math.max(0, this.f19538j - o);
        }
        if (this.f19538j != max) {
            this.f19538j = max;
            this.f19539k = o();
        }
        return max;
    }

    private boolean i() {
        return this.f19534f.size() < this.f19533e;
    }

    private boolean j() {
        return this.f19534f.size() == this.f19533e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(CountDownLatch countDownLatch) {
        try {
            m.a(this.f19536h, e.e.b.a.d.HIGHEST);
        } catch (SQLException unused) {
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(TaskCompletionSource taskCompletionSource, boolean z, b0 b0Var, Exception exc) {
        if (exc != null) {
            taskCompletionSource.d(exc);
            return;
        }
        if (z) {
            h();
        }
        taskCompletionSource.e(b0Var);
    }

    private long o() {
        return System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final b0 b0Var, final TaskCompletionSource<b0> taskCompletionSource) {
        h.f().b("Sending report through Google DataTransport: " + b0Var.d());
        final boolean z = SystemClock.elapsedRealtime() - this.f19532d < 2000;
        this.f19536h.b(c.f(b0Var.b()), new e.e.b.a.h() { // from class: com.google.firebase.crashlytics.h.s.b
            @Override // e.e.b.a.h
            public final void a(Exception exc) {
                e.this.n(taskCompletionSource, z, b0Var, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(double d2) {
        try {
            Thread.sleep((long) d2);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskCompletionSource<b0> g(b0 b0Var, boolean z) {
        synchronized (this.f19534f) {
            TaskCompletionSource<b0> taskCompletionSource = new TaskCompletionSource<>();
            if (z) {
                this.f19537i.b();
                if (i()) {
                    h.f().b("Enqueueing report: " + b0Var.d());
                    h.f().b("Queue size: " + this.f19534f.size());
                    this.f19535g.execute(new b(b0Var, taskCompletionSource));
                    h.f().b("Closing task for report: " + b0Var.d());
                    taskCompletionSource.e(b0Var);
                    return taskCompletionSource;
                }
                f();
                h.f().b("Dropping report due to queue being full: " + b0Var.d());
                this.f19537i.a();
                taskCompletionSource.e(b0Var);
                return taskCompletionSource;
            }
            p(b0Var, taskCompletionSource);
            return taskCompletionSource;
        }
    }

    @SuppressLint({"DiscouragedApi", "ThreadPoolCreation"})
    public void h() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.h.s.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.l(countDownLatch);
            }
        }).start();
        q0.b(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    @SuppressLint({"ThreadPoolCreation"})
    e(double d2, double d3, long j2, f<f0> fVar, n0 n0Var) {
        this.a = d2;
        this.f19530b = d3;
        this.f19531c = j2;
        this.f19536h = fVar;
        this.f19537i = n0Var;
        this.f19532d = SystemClock.elapsedRealtime();
        int i2 = (int) d2;
        this.f19533e = i2;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i2);
        this.f19534f = arrayBlockingQueue;
        this.f19535g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f19538j = 0;
        this.f19539k = 0L;
    }
}
