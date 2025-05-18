package androidx.work.impl.utils;

import android.os.Build;
import android.text.TextUtils;
import androidx.work.e;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.impl.n.s;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.q;
import androidx.work.x;
import androidx.work.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: EnqueueRunnable.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private static final String f2567f = androidx.work.n.f("EnqueueRunnable");

    /* renamed from: g, reason: collision with root package name */
    private final androidx.work.impl.g f2568g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.work.impl.c f2569h = new androidx.work.impl.c();

    public b(androidx.work.impl.g gVar) {
        this.f2568g = gVar;
    }

    private static boolean b(androidx.work.impl.g gVar) {
        boolean c2 = c(gVar.g(), gVar.f(), (String[]) androidx.work.impl.g.l(gVar).toArray(new String[0]), gVar.d(), gVar.b());
        gVar.k();
        return c2;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e1 A[LOOP:5: B:86:0x01db->B:88:0x01e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x020a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(androidx.work.impl.j jVar, List<? extends z> list, String[] strArr, String str, androidx.work.g gVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j2;
        int i2;
        Iterator<String> it;
        boolean z5;
        androidx.work.impl.n.b bVar;
        androidx.work.impl.j jVar2 = jVar;
        String[] strArr2 = strArr;
        long currentTimeMillis = System.currentTimeMillis();
        WorkDatabase t = jVar.t();
        boolean z6 = strArr2 != null && strArr2.length > 0;
        if (z6) {
            z = true;
            z2 = false;
            z3 = false;
            for (String str2 : strArr2) {
                p m = t.j().m(str2);
                if (m == null) {
                    androidx.work.n.c().b(f2567f, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                x.a aVar = m.f2526d;
                z &= aVar == x.a.SUCCEEDED;
                if (aVar == x.a.FAILED) {
                    z3 = true;
                } else if (aVar == x.a.CANCELLED) {
                    z2 = true;
                }
            }
        } else {
            z = true;
            z2 = false;
            z3 = false;
        }
        boolean z7 = !TextUtils.isEmpty(str);
        if (z7 && !z6) {
            List<p.b> c2 = t.j().c(str);
            if (!c2.isEmpty()) {
                if (gVar != androidx.work.g.APPEND && gVar != androidx.work.g.APPEND_OR_REPLACE) {
                    if (gVar == androidx.work.g.KEEP) {
                        Iterator<p.b> it2 = c2.iterator();
                        while (it2.hasNext()) {
                            x.a aVar2 = it2.next().f2534b;
                            if (aVar2 == x.a.ENQUEUED || aVar2 == x.a.RUNNING) {
                                return false;
                            }
                        }
                    }
                    a.c(str, jVar2, false).run();
                    q j3 = t.j();
                    Iterator<p.b> it3 = c2.iterator();
                    while (it3.hasNext()) {
                        j3.delete(it3.next().a);
                    }
                    z4 = true;
                    for (z zVar : list) {
                        p c3 = zVar.c();
                        if (!z6 || z) {
                            if (!c3.d()) {
                                c3.p = currentTimeMillis;
                            } else {
                                j2 = currentTimeMillis;
                                c3.p = 0L;
                                i2 = Build.VERSION.SDK_INT;
                                if (i2 < 23 && i2 <= 25) {
                                    g(c3);
                                } else if (i2 <= 22 && h(jVar2, "androidx.work.impl.background.gcm.GcmScheduler")) {
                                    g(c3);
                                }
                                if (c3.f2526d == x.a.ENQUEUED) {
                                    z4 = true;
                                }
                                t.j().f(c3);
                                if (z6) {
                                    for (String str3 : strArr2) {
                                        t.b().a(new androidx.work.impl.n.a(zVar.a(), str3));
                                    }
                                }
                                it = zVar.b().iterator();
                                while (it.hasNext()) {
                                    t.k().a(new s(it.next(), zVar.a()));
                                }
                                if (!z7) {
                                    t.h().a(new androidx.work.impl.n.j(str, zVar.a()));
                                }
                                jVar2 = jVar;
                                currentTimeMillis = j2;
                            }
                        } else if (z3) {
                            c3.f2526d = x.a.FAILED;
                        } else if (z2) {
                            c3.f2526d = x.a.CANCELLED;
                        } else {
                            c3.f2526d = x.a.BLOCKED;
                        }
                        j2 = currentTimeMillis;
                        i2 = Build.VERSION.SDK_INT;
                        if (i2 < 23) {
                        }
                        if (i2 <= 22) {
                            g(c3);
                        }
                        if (c3.f2526d == x.a.ENQUEUED) {
                        }
                        t.j().f(c3);
                        if (z6) {
                        }
                        it = zVar.b().iterator();
                        while (it.hasNext()) {
                        }
                        if (!z7) {
                        }
                        jVar2 = jVar;
                        currentTimeMillis = j2;
                    }
                    return z4;
                }
                androidx.work.impl.n.b b2 = t.b();
                List arrayList = new ArrayList();
                for (p.b bVar2 : c2) {
                    if (b2.d(bVar2.a)) {
                        bVar = b2;
                    } else {
                        x.a aVar3 = bVar2.f2534b;
                        bVar = b2;
                        boolean z8 = (aVar3 == x.a.SUCCEEDED) & z;
                        if (aVar3 == x.a.FAILED) {
                            z3 = true;
                        } else if (aVar3 == x.a.CANCELLED) {
                            z2 = true;
                        }
                        arrayList.add(bVar2.a);
                        z = z8;
                    }
                    b2 = bVar;
                }
                if (gVar == androidx.work.g.APPEND_OR_REPLACE && (z2 || z3)) {
                    q j4 = t.j();
                    Iterator<p.b> it4 = j4.c(str).iterator();
                    while (it4.hasNext()) {
                        j4.delete(it4.next().a);
                    }
                    arrayList = Collections.emptyList();
                    z5 = false;
                    z2 = false;
                } else {
                    z5 = z3;
                }
                strArr2 = (String[]) arrayList.toArray(strArr2);
                z6 = strArr2.length > 0;
                z3 = z5;
            }
        }
        z4 = false;
        while (r7.hasNext()) {
        }
        return z4;
    }

    private static boolean e(androidx.work.impl.g gVar) {
        List<androidx.work.impl.g> e2 = gVar.e();
        boolean z = false;
        if (e2 != null) {
            boolean z2 = false;
            for (androidx.work.impl.g gVar2 : e2) {
                if (!gVar2.j()) {
                    z2 |= e(gVar2);
                } else {
                    androidx.work.n.c().h(f2567f, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar2.c())), new Throwable[0]);
                }
            }
            z = z2;
        }
        return b(gVar) | z;
    }

    private static void g(p pVar) {
        androidx.work.c cVar = pVar.l;
        String str = pVar.f2527e;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (cVar.f() || cVar.i()) {
            e.a aVar = new e.a();
            aVar.c(pVar.f2529g).f("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f2527e = ConstraintTrackingWorker.class.getName();
            pVar.f2529g = aVar.a();
        }
    }

    private static boolean h(androidx.work.impl.j jVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            Iterator<androidx.work.impl.e> it = jVar.s().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next().getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase t = this.f2568g.g().t();
        t.beginTransaction();
        try {
            boolean e2 = e(this.f2568g);
            t.setTransactionSuccessful();
            return e2;
        } finally {
            t.endTransaction();
        }
    }

    public androidx.work.q d() {
        return this.f2569h;
    }

    public void f() {
        androidx.work.impl.j g2 = this.f2568g.g();
        androidx.work.impl.f.b(g2.n(), g2.t(), g2.s());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!this.f2568g.h()) {
                if (a()) {
                    d.a(this.f2568g.g().m(), RescheduleReceiver.class, true);
                    f();
                }
                this.f2569h.a(androidx.work.q.a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f2568g));
        } catch (Throwable th) {
            this.f2569h.a(new q.b.a(th));
        }
    }
}
