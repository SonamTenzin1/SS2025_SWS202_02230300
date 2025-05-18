package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.e;
import androidx.work.impl.j;
import androidx.work.impl.n.g;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.impl.utils.c;
import androidx.work.n;
import androidx.work.r;
import androidx.work.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: SystemJobScheduler.java */
/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: f, reason: collision with root package name */
    private static final String f2384f = n.f("SystemJobScheduler");

    /* renamed from: g, reason: collision with root package name */
    private final Context f2385g;

    /* renamed from: h, reason: collision with root package name */
    private final JobScheduler f2386h;

    /* renamed from: i, reason: collision with root package name */
    private final j f2387i;

    /* renamed from: j, reason: collision with root package name */
    private final a f2388j;

    public b(Context context, j jVar) {
        this(context, jVar, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public static void b(Context context) {
        List<JobInfo> f2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (f2 = f(context, jobScheduler)) == null || f2.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it = f2.iterator();
        while (it.hasNext()) {
            d(jobScheduler, it.next().getId());
        }
    }

    private static void d(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            n.c().b(f2384f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i2)), th);
        }
    }

    private static List<Integer> e(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> f2 = f(context, jobScheduler);
        if (f2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : f2) {
            if (str.equals(g(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List<JobInfo> f(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            n.c().b(f2384f, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static String g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean h(Context context, j jVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> f2 = f(context, jobScheduler);
        List<String> a = jVar.t().g().a();
        boolean z = false;
        HashSet hashSet = new HashSet(f2 != null ? f2.size() : 0);
        if (f2 != null && !f2.isEmpty()) {
            for (JobInfo jobInfo : f2) {
                String g2 = g(jobInfo);
                if (!TextUtils.isEmpty(g2)) {
                    hashSet.add(g2);
                } else {
                    d(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator<String> it = a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (!hashSet.contains(it.next())) {
                n.c().a(f2384f, "Reconciling jobs", new Throwable[0]);
                z = true;
                break;
            }
        }
        if (z) {
            WorkDatabase t = jVar.t();
            t.beginTransaction();
            try {
                q j2 = t.j();
                Iterator<String> it2 = a.iterator();
                while (it2.hasNext()) {
                    j2.b(it2.next(), -1L);
                }
                t.setTransactionSuccessful();
            } finally {
                t.endTransaction();
            }
        }
        return z;
    }

    @Override // androidx.work.impl.e
    public void a(p... pVarArr) {
        int d2;
        List<Integer> e2;
        int d3;
        WorkDatabase t = this.f2387i.t();
        c cVar = new c(t);
        for (p pVar : pVarArr) {
            t.beginTransaction();
            try {
                p m = t.j().m(pVar.f2525c);
                if (m == null) {
                    n.c().h(f2384f, "Skipping scheduling " + pVar.f2525c + " because it's no longer in the DB", new Throwable[0]);
                    t.setTransactionSuccessful();
                } else if (m.f2526d != x.a.ENQUEUED) {
                    n.c().h(f2384f, "Skipping scheduling " + pVar.f2525c + " because it is no longer enqueued", new Throwable[0]);
                    t.setTransactionSuccessful();
                } else {
                    g c2 = t.g().c(pVar.f2525c);
                    if (c2 != null) {
                        d2 = c2.f2515b;
                    } else {
                        d2 = cVar.d(this.f2387i.n().i(), this.f2387i.n().g());
                    }
                    if (c2 == null) {
                        this.f2387i.t().g().b(new g(pVar.f2525c, d2));
                    }
                    i(pVar, d2);
                    if (Build.VERSION.SDK_INT == 23 && (e2 = e(this.f2385g, this.f2386h, pVar.f2525c)) != null) {
                        int indexOf = e2.indexOf(Integer.valueOf(d2));
                        if (indexOf >= 0) {
                            e2.remove(indexOf);
                        }
                        if (!e2.isEmpty()) {
                            d3 = e2.get(0).intValue();
                        } else {
                            d3 = cVar.d(this.f2387i.n().i(), this.f2387i.n().g());
                        }
                        i(pVar, d3);
                    }
                    t.setTransactionSuccessful();
                }
                t.endTransaction();
            } catch (Throwable th) {
                t.endTransaction();
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.e
    public boolean c() {
        return true;
    }

    @Override // androidx.work.impl.e
    public void cancel(String str) {
        List<Integer> e2 = e(this.f2385g, this.f2386h, str);
        if (e2 == null || e2.isEmpty()) {
            return;
        }
        Iterator<Integer> it = e2.iterator();
        while (it.hasNext()) {
            d(this.f2386h, it.next().intValue());
        }
        this.f2387i.t().g().d(str);
    }

    public void i(p pVar, int i2) {
        JobInfo a = this.f2388j.a(pVar, i2);
        n c2 = n.c();
        String str = f2384f;
        c2.a(str, String.format("Scheduling work ID %s Job ID %s", pVar.f2525c, Integer.valueOf(i2)), new Throwable[0]);
        try {
            if (this.f2386h.schedule(a) == 0) {
                n.c().h(str, String.format("Unable to schedule work ID %s", pVar.f2525c), new Throwable[0]);
                if (pVar.s && pVar.t == r.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    pVar.s = false;
                    n.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", pVar.f2525c), new Throwable[0]);
                    i(pVar, i2);
                }
            }
        } catch (IllegalStateException e2) {
            List<JobInfo> f2 = f(this.f2385g, this.f2386h);
            String format = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(f2 != null ? f2.size() : 0), Integer.valueOf(this.f2387i.t().j().g().size()), Integer.valueOf(this.f2387i.n().h()));
            n.c().b(f2384f, format, new Throwable[0]);
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            n.c().b(f2384f, String.format("Unable to schedule %s", pVar), th);
        }
    }

    public b(Context context, j jVar, JobScheduler jobScheduler, a aVar) {
        this.f2385g = context;
        this.f2387i = jVar;
        this.f2386h = jobScheduler;
        this.f2388j = aVar;
    }
}
