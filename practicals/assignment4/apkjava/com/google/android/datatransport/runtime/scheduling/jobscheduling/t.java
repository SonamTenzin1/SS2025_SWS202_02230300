package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import cm.aptoide.pt.notification.PullingContentService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.r;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: SchedulerConfig.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class t {

    /* compiled from: SchedulerConfig.java */
    /* loaded from: classes2.dex */
    public static class a {
        private e.e.b.a.i.c0.a a;

        /* renamed from: b, reason: collision with root package name */
        private Map<e.e.b.a.d, b> f11350b = new HashMap();

        public a a(e.e.b.a.d dVar, b bVar) {
            this.f11350b.put(dVar, bVar);
            return this;
        }

        public t b() {
            if (this.a != null) {
                if (this.f11350b.keySet().size() >= e.e.b.a.d.values().length) {
                    Map<e.e.b.a.d, b> map = this.f11350b;
                    this.f11350b = new HashMap();
                    return t.d(this.a, map);
                }
                throw new IllegalStateException("Not all priorities have been configured");
            }
            throw new NullPointerException("missing required property: clock");
        }

        public a c(e.e.b.a.i.c0.a aVar) {
            this.a = aVar;
            return this;
        }
    }

    /* compiled from: SchedulerConfig.java */
    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class b {

        /* compiled from: SchedulerConfig.java */
        @AutoValue.Builder
        /* loaded from: classes2.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j2);

            public abstract a c(Set<c> set);

            public abstract a d(long j2);
        }

        public static a a() {
            return new r.b().c(Collections.emptySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<c> c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long d();
    }

    /* compiled from: SchedulerConfig.java */
    /* loaded from: classes2.dex */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i2, long j2) {
        int i3 = i2 - 1;
        double max = Math.max(1.0d, Math.log(10000.0d) / Math.log((j2 > 1 ? j2 : 2L) * i3));
        double pow = Math.pow(3.0d, i3);
        double d2 = j2;
        Double.isNaN(d2);
        return (long) (pow * d2 * max);
    }

    public static a b() {
        return new a();
    }

    static t d(e.e.b.a.i.c0.a aVar, Map<e.e.b.a.d, b> map) {
        return new q(aVar, map);
    }

    public static t f(e.e.b.a.i.c0.a aVar) {
        return b().a(e.e.b.a.d.DEFAULT, b.a().b(30000L).d(PullingContentService.UPDATES_INTERVAL).a()).a(e.e.b.a.d.HIGHEST, b.a().b(1000L).d(PullingContentService.UPDATES_INTERVAL).a()).a(e.e.b.a.d.VERY_LOW, b.a().b(PullingContentService.UPDATES_INTERVAL).d(PullingContentService.UPDATES_INTERVAL).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    private void j(JobInfo.Builder builder, Set<c> set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public JobInfo.Builder c(JobInfo.Builder builder, e.e.b.a.d dVar, long j2, int i2) {
        builder.setMinimumLatency(g(dVar, j2, i2));
        j(builder, h().get(dVar).c());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract e.e.b.a.i.c0.a e();

    public long g(e.e.b.a.d dVar, long j2, int i2) {
        long a2 = j2 - e().a();
        b bVar = h().get(dVar);
        return Math.min(Math.max(a(i2, bVar.b()), a2), bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map<e.e.b.a.d, b> h();
}
