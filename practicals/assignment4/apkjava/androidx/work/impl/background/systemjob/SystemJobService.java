package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import androidx.work.impl.j;
import androidx.work.n;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements androidx.work.impl.b {

    /* renamed from: f, reason: collision with root package name */
    private static final String f2380f = n.f("SystemJobService");

    /* renamed from: g, reason: collision with root package name */
    private j f2381g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, JobParameters> f2382h = new HashMap();

    private static String a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        JobParameters remove;
        n.c().a(f2380f, String.format("%s executed on JobScheduler", str), new Throwable[0]);
        synchronized (this.f2382h) {
            remove = this.f2382h.remove(str);
        }
        if (remove != null) {
            jobFinished(remove, z);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            j p = j.p(getApplicationContext());
            this.f2381g = p;
            p.r().c(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                n.c().h(f2380f, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f2381g;
        if (jVar != null) {
            jVar.r().i(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.f2381g == null) {
            n.c().a(f2380f, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        String a = a(jobParameters);
        if (TextUtils.isEmpty(a)) {
            n.c().b(f2380f, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f2382h) {
            if (this.f2382h.containsKey(a)) {
                n.c().a(f2380f, String.format("Job is already being executed by SystemJobService: %s", a), new Throwable[0]);
                return false;
            }
            n.c().a(f2380f, String.format("onStartJob for %s", a), new Throwable[0]);
            this.f2382h.put(a, jobParameters);
            WorkerParameters.a aVar = null;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                aVar = new WorkerParameters.a();
                if (jobParameters.getTriggeredContentUris() != null) {
                    aVar.f2283b = Arrays.asList(jobParameters.getTriggeredContentUris());
                }
                if (jobParameters.getTriggeredContentAuthorities() != null) {
                    aVar.a = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                }
                if (i2 >= 28) {
                    aVar.f2284c = jobParameters.getNetwork();
                }
            }
            this.f2381g.A(a, aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f2381g == null) {
            n.c().a(f2380f, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String a = a(jobParameters);
        if (TextUtils.isEmpty(a)) {
            n.c().b(f2380f, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        n.c().a(f2380f, String.format("onStopJob for %s", a), new Throwable[0]);
        synchronized (this.f2382h) {
            this.f2382h.remove(a);
        }
        this.f2381g.C(a);
        return !this.f2381g.r().f(a);
    }
}
