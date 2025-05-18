package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import io.sentry.k3;
import io.sentry.r1;
import io.sentry.s4;
import io.sentry.w1;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AndroidCpuCollector.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class g0 implements r1 {
    private long a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f22127b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f22128c = 1;

    /* renamed from: d, reason: collision with root package name */
    private long f22129d = 1;

    /* renamed from: e, reason: collision with root package name */
    private final long f22130e = 1000000000;

    /* renamed from: f, reason: collision with root package name */
    private double f22131f;

    /* renamed from: g, reason: collision with root package name */
    private final File f22132g;

    /* renamed from: h, reason: collision with root package name */
    private final w1 f22133h;

    /* renamed from: i, reason: collision with root package name */
    private final s0 f22134i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f22135j;

    public g0(w1 w1Var, s0 s0Var) {
        double d2 = 1L;
        Double.isNaN(d2);
        this.f22131f = 1.0E9d / d2;
        this.f22132g = new File("/proc/self/stat");
        this.f22135j = false;
        this.f22133h = (w1) io.sentry.util.q.c(w1Var, "Logger is required.");
        this.f22134i = (s0) io.sentry.util.q.c(s0Var, "BuildInfoProvider is required.");
    }

    private long b() {
        String str;
        try {
            str = io.sentry.util.l.c(this.f22132g);
        } catch (IOException e2) {
            this.f22135j = false;
            this.f22133h.b(s4.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", e2);
            str = null;
        }
        if (str != null) {
            String[] split = str.trim().split("[\n\t\r ]");
            try {
                double parseLong = Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
                double d2 = this.f22131f;
                Double.isNaN(parseLong);
                return (long) (parseLong * d2);
            } catch (NumberFormatException e3) {
                this.f22133h.b(s4.ERROR, "Error parsing /proc/self/stat file.", e3);
            }
        }
        return 0L;
    }

    @Override // io.sentry.r1
    @SuppressLint({"NewApi"})
    public void a(k3 k3Var) {
        if (this.f22134i.d() < 21 || !this.f22135j) {
            return;
        }
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        long j2 = elapsedRealtimeNanos - this.a;
        this.a = elapsedRealtimeNanos;
        long b2 = b();
        long j3 = b2 - this.f22127b;
        this.f22127b = b2;
        double d2 = j3;
        double d3 = j2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        long currentTimeMillis = System.currentTimeMillis();
        double d4 = this.f22129d;
        Double.isNaN(d4);
        k3Var.a(new io.sentry.x0(currentTimeMillis, ((d2 / d3) / d4) * 100.0d));
    }

    @Override // io.sentry.r1
    @SuppressLint({"NewApi"})
    public void setup() {
        if (this.f22134i.d() < 21) {
            this.f22135j = false;
            return;
        }
        this.f22135j = true;
        this.f22128c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.f22129d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        double d2 = this.f22128c;
        Double.isNaN(d2);
        this.f22131f = 1.0E9d / d2;
        this.f22127b = b();
    }
}
