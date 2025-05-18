package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.n;
import java.util.Iterator;
import java.util.List;

/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public class f {
    private static final String a = n.f("Schedulers");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(Context context, j jVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            androidx.work.impl.background.systemjob.b bVar = new androidx.work.impl.background.systemjob.b(context, jVar);
            androidx.work.impl.utils.d.a(context, SystemJobService.class, true);
            n.c().a(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return bVar;
        }
        e c2 = c(context);
        if (c2 != null) {
            return c2;
        }
        androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
        androidx.work.impl.utils.d.a(context, SystemAlarmService.class, true);
        n.c().a(a, "Created SystemAlarmScheduler", new Throwable[0]);
        return fVar;
    }

    public static void b(androidx.work.b bVar, WorkDatabase workDatabase, List<e> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        q j2 = workDatabase.j();
        workDatabase.beginTransaction();
        try {
            List<p> e2 = j2.e(bVar.h());
            List<p> s = j2.s(200);
            if (e2 != null && e2.size() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<p> it = e2.iterator();
                while (it.hasNext()) {
                    j2.b(it.next().f2525c, currentTimeMillis);
                }
            }
            workDatabase.setTransactionSuccessful();
            if (e2 != null && e2.size() > 0) {
                p[] pVarArr = (p[]) e2.toArray(new p[e2.size()]);
                for (e eVar : list) {
                    if (eVar.c()) {
                        eVar.a(pVarArr);
                    }
                }
            }
            if (s == null || s.size() <= 0) {
                return;
            }
            p[] pVarArr2 = (p[]) s.toArray(new p[s.size()]);
            for (e eVar2 : list) {
                if (!eVar2.c()) {
                    eVar2.a(pVarArr2);
                }
            }
        } finally {
            workDatabase.endTransaction();
        }
    }

    private static e c(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            n.c().a(a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return eVar;
        } catch (Throwable th) {
            n.c().a(a, "Unable to create GCM Scheduler", th);
            return null;
        }
    }
}
