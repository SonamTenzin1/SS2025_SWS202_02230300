package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.n.p;
import androidx.work.impl.utils.j;
import androidx.work.impl.utils.n;
import java.util.Collections;
import java.util.List;

/* compiled from: DelayMetCommandHandler.java */
/* loaded from: classes.dex */
public class d implements androidx.work.impl.m.c, androidx.work.impl.b, n.b {

    /* renamed from: f, reason: collision with root package name */
    private static final String f2361f = androidx.work.n.f("DelayMetCommandHandler");

    /* renamed from: g, reason: collision with root package name */
    private final Context f2362g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2363h;

    /* renamed from: i, reason: collision with root package name */
    private final String f2364i;

    /* renamed from: j, reason: collision with root package name */
    private final e f2365j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.work.impl.m.d f2366k;
    private PowerManager.WakeLock n;
    private boolean o = false;
    private int m = 0;
    private final Object l = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, int i2, String str, e eVar) {
        this.f2362g = context;
        this.f2363h = i2;
        this.f2365j = eVar;
        this.f2364i = str;
        this.f2366k = new androidx.work.impl.m.d(context, eVar.f(), this);
    }

    private void c() {
        synchronized (this.l) {
            this.f2366k.e();
            this.f2365j.h().c(this.f2364i);
            PowerManager.WakeLock wakeLock = this.n;
            if (wakeLock != null && wakeLock.isHeld()) {
                androidx.work.n.c().a(f2361f, String.format("Releasing wakelock %s for WorkSpec %s", this.n, this.f2364i), new Throwable[0]);
                this.n.release();
            }
        }
    }

    private void g() {
        synchronized (this.l) {
            if (this.m < 2) {
                this.m = 2;
                androidx.work.n c2 = androidx.work.n.c();
                String str = f2361f;
                c2.a(str, String.format("Stopping work for WorkSpec %s", this.f2364i), new Throwable[0]);
                Intent g2 = b.g(this.f2362g, this.f2364i);
                e eVar = this.f2365j;
                eVar.k(new e.b(eVar, g2, this.f2363h));
                if (this.f2365j.e().g(this.f2364i)) {
                    androidx.work.n.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f2364i), new Throwable[0]);
                    Intent f2 = b.f(this.f2362g, this.f2364i);
                    e eVar2 = this.f2365j;
                    eVar2.k(new e.b(eVar2, f2, this.f2363h));
                } else {
                    androidx.work.n.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f2364i), new Throwable[0]);
                }
            } else {
                androidx.work.n.c().a(f2361f, String.format("Already stopped work for %s", this.f2364i), new Throwable[0]);
            }
        }
    }

    @Override // androidx.work.impl.utils.n.b
    public void a(String str) {
        androidx.work.n.c().a(f2361f, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // androidx.work.impl.m.c
    public void b(List<String> list) {
        g();
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        androidx.work.n.c().a(f2361f, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        c();
        if (z) {
            Intent f2 = b.f(this.f2362g, this.f2364i);
            e eVar = this.f2365j;
            eVar.k(new e.b(eVar, f2, this.f2363h));
        }
        if (this.o) {
            Intent a = b.a(this.f2362g);
            e eVar2 = this.f2365j;
            eVar2.k(new e.b(eVar2, a, this.f2363h));
        }
    }

    @Override // androidx.work.impl.m.c
    public void e(List<String> list) {
        if (list.contains(this.f2364i)) {
            synchronized (this.l) {
                if (this.m == 0) {
                    this.m = 1;
                    androidx.work.n.c().a(f2361f, String.format("onAllConstraintsMet for %s", this.f2364i), new Throwable[0]);
                    if (this.f2365j.e().j(this.f2364i)) {
                        this.f2365j.h().b(this.f2364i, 600000L, this);
                    } else {
                        c();
                    }
                } else {
                    androidx.work.n.c().a(f2361f, String.format("Already started work for %s", this.f2364i), new Throwable[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.n = j.b(this.f2362g, String.format("%s (%s)", this.f2364i, Integer.valueOf(this.f2363h)));
        androidx.work.n c2 = androidx.work.n.c();
        String str = f2361f;
        c2.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.n, this.f2364i), new Throwable[0]);
        this.n.acquire();
        p m = this.f2365j.g().t().j().m(this.f2364i);
        if (m == null) {
            g();
            return;
        }
        boolean b2 = m.b();
        this.o = b2;
        if (!b2) {
            androidx.work.n.c().a(str, String.format("No constraints for %s", this.f2364i), new Throwable[0]);
            e(Collections.singletonList(this.f2364i));
        } else {
            this.f2366k.d(Collections.singletonList(m));
        }
    }
}
