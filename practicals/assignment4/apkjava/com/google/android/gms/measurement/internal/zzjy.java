package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzh;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzjy extends f7 {

    /* renamed from: d, reason: collision with root package name */
    private final AlarmManager f18206d;

    /* renamed from: e, reason: collision with root package name */
    private final f f18207e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f18208f;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzjy(zzkc zzkcVar) {
        super(zzkcVar);
        this.f18206d = (AlarmManager) f().getSystemService("alarm");
        this.f18207e = new e7(this, zzkcVar.g0(), zzkcVar);
    }

    private final PendingIntent A() {
        Context f2 = f();
        return PendingIntent.getBroadcast(f2, 0, new Intent().setClassName(f2, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    @TargetApi(24)
    private final void y() {
        JobScheduler jobScheduler = (JobScheduler) f().getSystemService("jobscheduler");
        int z = z();
        h().P().b("Cancelling job. JobID", Integer.valueOf(z));
        jobScheduler.cancel(z);
    }

    private final int z() {
        if (this.f18208f == null) {
            String valueOf = String.valueOf(f().getPackageName());
            this.f18208f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f18208f.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ q7 o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzkg p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ c q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.h7
    public final /* bridge */ /* synthetic */ zzfr r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        this.f18206d.cancel(A());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        y();
        return false;
    }

    public final void w(long j2) {
        t();
        G();
        Context f2 = f();
        if (!zzfn.b(f2)) {
            h().O().a("Receiver not registered/enabled");
        }
        if (!zzkk.U(f2, false)) {
            h().O().a("Service not registered/enabled");
        }
        x();
        long b2 = j().b() + j2;
        if (j2 < Math.max(0L, zzap.E.a(null).longValue()) && !this.f18207e.d()) {
            h().P().a("Scheduling upload with DelayedRunnable");
            this.f18207e.c(j2);
        }
        G();
        if (Build.VERSION.SDK_INT >= 24) {
            h().P().a("Scheduling upload with JobScheduler");
            Context f3 = f();
            ComponentName componentName = new ComponentName(f3, "com.google.android.gms.measurement.AppMeasurementJobService");
            int z = z();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            JobInfo build = new JobInfo.Builder(z, componentName).setMinimumLatency(j2).setOverrideDeadline(j2 << 1).setExtras(persistableBundle).build();
            h().P().b("Scheduling job. JobID", Integer.valueOf(z));
            zzh.b(f3, build, "com.google.android.gms", "UploadAlarm");
            return;
        }
        h().P().a("Scheduling upload with AlarmManager");
        this.f18206d.setInexactRepeating(2, b2, Math.max(zzap.z.a(null).longValue(), j2), A());
    }

    public final void x() {
        t();
        this.f18206d.cancel(A());
        this.f18207e.e();
        if (Build.VERSION.SDK_INT >= 24) {
            y();
        }
    }
}
