package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import e.e.b.a.i.b0.j.j0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* compiled from: JobInfoScheduler.java */
/* loaded from: classes2.dex */
public class s implements y {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f11348b;

    /* renamed from: c, reason: collision with root package name */
    private final t f11349c;

    public s(Context context, j0 j0Var, t tVar) {
        this.a = context;
        this.f11348b = j0Var;
        this.f11349c = tVar;
    }

    private boolean d(JobScheduler jobScheduler, int i2, int i3) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i4 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i2) {
                return i4 >= i3;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.y
    public void a(e.e.b.a.i.q qVar, int i2) {
        b(qVar, i2, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.y
    public void b(e.e.b.a.i.q qVar, int i2, boolean z) {
        ComponentName componentName = new ComponentName(this.a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int c2 = c(qVar);
        if (!z && d(jobScheduler, c2, i2)) {
            e.e.b.a.i.z.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", qVar);
            return;
        }
        long W0 = this.f11348b.W0(qVar);
        JobInfo.Builder c3 = this.f11349c.c(new JobInfo.Builder(c2, componentName), qVar.d(), W0, i2);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", qVar.b());
        persistableBundle.putInt("priority", e.e.b.a.i.d0.a.a(qVar.d()));
        if (qVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(qVar.c(), 0));
        }
        c3.setExtras(persistableBundle);
        e.e.b.a.i.z.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", qVar, Integer.valueOf(c2), Long.valueOf(this.f11349c.g(qVar.d(), W0, i2)), Long.valueOf(W0), Integer.valueOf(i2));
        jobScheduler.schedule(c3.build());
    }

    int c(e.e.b.a.i.q qVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(qVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(e.e.b.a.i.d0.a.a(qVar.d())).array());
        if (qVar.c() != null) {
            adler32.update(qVar.c());
        }
        return (int) adler32.getValue();
    }
}
