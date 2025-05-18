package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.q;
import androidx.work.x;

/* compiled from: StopWorkRunnable.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private static final String f2579f = androidx.work.n.f("StopWorkRunnable");

    /* renamed from: g, reason: collision with root package name */
    private final androidx.work.impl.j f2580g;

    /* renamed from: h, reason: collision with root package name */
    private final String f2581h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f2582i;

    public i(androidx.work.impl.j jVar, String str, boolean z) {
        this.f2580g = jVar;
        this.f2581h = str;
        this.f2582i = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean o;
        WorkDatabase t = this.f2580g.t();
        androidx.work.impl.d r = this.f2580g.r();
        q j2 = t.j();
        t.beginTransaction();
        try {
            boolean h2 = r.h(this.f2581h);
            if (this.f2582i) {
                o = this.f2580g.r().n(this.f2581h);
            } else {
                if (!h2 && j2.l(this.f2581h) == x.a.RUNNING) {
                    j2.a(x.a.ENQUEUED, this.f2581h);
                }
                o = this.f2580g.r().o(this.f2581h);
            }
            androidx.work.n.c().a(f2579f, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f2581h, Boolean.valueOf(o)), new Throwable[0]);
            t.setTransactionSuccessful();
        } finally {
            t.endTransaction();
        }
    }
}
