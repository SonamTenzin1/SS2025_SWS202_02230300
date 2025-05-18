package com.google.firebase.installations.r;

import com.google.firebase.installations.o;
import java.util.concurrent.TimeUnit;

/* compiled from: RequestLimiter.java */
/* loaded from: classes2.dex */
class e {
    private static final long a = TimeUnit.HOURS.toMillis(24);

    /* renamed from: b, reason: collision with root package name */
    private static final long f19739b = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: c, reason: collision with root package name */
    private final o f19740c = o.c();

    /* renamed from: d, reason: collision with root package name */
    private long f19741d;

    /* renamed from: e, reason: collision with root package name */
    private int f19742e;

    private synchronized long a(int i2) {
        if (!c(i2)) {
            return a;
        }
        double pow = Math.pow(2.0d, this.f19742e);
        double e2 = this.f19740c.e();
        Double.isNaN(e2);
        return (long) Math.min(pow + e2, f19739b);
    }

    private static boolean c(int i2) {
        return i2 == 429 || (i2 >= 500 && i2 < 600);
    }

    private static boolean d(int i2) {
        return (i2 >= 200 && i2 < 300) || i2 == 401 || i2 == 404;
    }

    private synchronized void e() {
        this.f19742e = 0;
    }

    public synchronized boolean b() {
        boolean z;
        if (this.f19742e != 0) {
            z = this.f19740c.a() > this.f19741d;
        }
        return z;
    }

    public synchronized void f(int i2) {
        if (d(i2)) {
            e();
            return;
        }
        this.f19742e++;
        this.f19741d = this.f19740c.a() + a(i2);
    }
}
