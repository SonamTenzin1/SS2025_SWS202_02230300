package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import e.e.b.a.i.q;

/* loaded from: classes2.dex */
public class JobInfoSchedulerService extends JobService {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        e.e.b.a.i.u.f(getApplicationContext());
        q.a d2 = e.e.b.a.i.q.a().b(string).d(e.e.b.a.i.d0.a.b(i2));
        if (string2 != null) {
            d2.c(Base64.decode(string2, 0));
        }
        e.e.b.a.i.u.c().e().v(d2.a(), i3, new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.c
            @Override // java.lang.Runnable
            public final void run() {
                JobInfoSchedulerService.this.b(jobParameters);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
