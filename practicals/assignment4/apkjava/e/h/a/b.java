package e.h.a;

import android.os.SystemClock;

/* compiled from: DownloadSpeedMonitor.java */
/* loaded from: classes2.dex */
public class b implements s, r {
    private long a;

    /* renamed from: b, reason: collision with root package name */
    private long f21209b;

    /* renamed from: c, reason: collision with root package name */
    private long f21210c;

    /* renamed from: d, reason: collision with root package name */
    private long f21211d;

    /* renamed from: e, reason: collision with root package name */
    private int f21212e;

    /* renamed from: f, reason: collision with root package name */
    private int f21213f = 1000;

    @Override // e.h.a.s
    public void a() {
        this.f21212e = 0;
        this.a = 0L;
    }

    @Override // e.h.a.r
    public int c() {
        return this.f21212e;
    }

    @Override // e.h.a.s
    public void f(long j2) {
        if (this.f21211d <= 0) {
            return;
        }
        long j3 = j2 - this.f21210c;
        this.a = 0L;
        long uptimeMillis = SystemClock.uptimeMillis() - this.f21211d;
        if (uptimeMillis <= 0) {
            this.f21212e = (int) j3;
        } else {
            this.f21212e = (int) (j3 / uptimeMillis);
        }
    }

    @Override // e.h.a.s
    public void g(long j2) {
        this.f21211d = SystemClock.uptimeMillis();
        this.f21210c = j2;
    }

    @Override // e.h.a.s
    public void i(long j2) {
        if (this.f21213f <= 0) {
            return;
        }
        boolean z = true;
        if (this.a != 0) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.a;
            if (uptimeMillis >= this.f21213f || (this.f21212e == 0 && uptimeMillis > 0)) {
                int i2 = (int) ((j2 - this.f21209b) / uptimeMillis);
                this.f21212e = i2;
                this.f21212e = Math.max(0, i2);
            } else {
                z = false;
            }
        }
        if (z) {
            this.f21209b = j2;
            this.a = SystemClock.uptimeMillis();
        }
    }
}
