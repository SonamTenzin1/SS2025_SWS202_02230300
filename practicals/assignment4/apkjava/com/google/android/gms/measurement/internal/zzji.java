package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzji<T extends Context & zzjm> {
    private final T a;

    public zzji(T t) {
        Preconditions.k(t);
        this.a = t;
    }

    private final void f(Runnable runnable) {
        zzkc c2 = zzkc.c(this.a);
        c2.g().z(new s6(this, c2, runnable));
    }

    private final zzet j() {
        return zzfx.a(this.a, null).h();
    }

    public final int a(final Intent intent, int i2, final int i3) {
        zzfx a = zzfx.a(this.a, null);
        final zzet h2 = a.h();
        if (intent == null) {
            h2.K().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        a.G();
        h2.P().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            f(new Runnable(this, i3, h2, intent) { // from class: com.google.android.gms.measurement.internal.r6

                /* renamed from: f, reason: collision with root package name */
                private final zzji f17934f;

                /* renamed from: g, reason: collision with root package name */
                private final int f17935g;

                /* renamed from: h, reason: collision with root package name */
                private final zzet f17936h;

                /* renamed from: i, reason: collision with root package name */
                private final Intent f17937i;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f17934f = this;
                    this.f17935g = i3;
                    this.f17936h = h2;
                    this.f17937i = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f17934f.d(this.f17935g, this.f17936h, this.f17937i);
                }
            });
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            j().H().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgc(zzkc.c(this.a));
        }
        j().K().b("onBind received unknown action", action);
        return null;
    }

    public final void c() {
        zzfx a = zzfx.a(this.a, null);
        zzet h2 = a.h();
        a.G();
        h2.P().a("Local AppMeasurementService is starting up");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(int i2, zzet zzetVar, Intent intent) {
        if (this.a.d(i2)) {
            zzetVar.P().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            j().P().a("Completed wakeful intent.");
            this.a.a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(zzet zzetVar, JobParameters jobParameters) {
        zzetVar.P().a("AppMeasurementJobService processed last upload request.");
        this.a.b(jobParameters, false);
    }

    @TargetApi(24)
    public final boolean g(final JobParameters jobParameters) {
        zzfx a = zzfx.a(this.a, null);
        final zzet h2 = a.h();
        String string = jobParameters.getExtras().getString("action");
        a.G();
        h2.P().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        f(new Runnable(this, h2, jobParameters) { // from class: com.google.android.gms.measurement.internal.t6

            /* renamed from: f, reason: collision with root package name */
            private final zzji f17967f;

            /* renamed from: g, reason: collision with root package name */
            private final zzet f17968g;

            /* renamed from: h, reason: collision with root package name */
            private final JobParameters f17969h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17967f = this;
                this.f17968g = h2;
                this.f17969h = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f17967f.e(this.f17968g, this.f17969h);
            }
        });
        return true;
    }

    public final void h() {
        zzfx a = zzfx.a(this.a, null);
        zzet h2 = a.h();
        a.G();
        h2.P().a("Local AppMeasurementService is shutting down");
    }

    public final boolean i(Intent intent) {
        if (intent == null) {
            j().H().a("onUnbind called with null intent");
            return true;
        }
        j().P().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void k(Intent intent) {
        if (intent == null) {
            j().H().a("onRebind called with null intent");
        } else {
            j().P().b("onRebind called. action", intent.getAction());
        }
    }
}
