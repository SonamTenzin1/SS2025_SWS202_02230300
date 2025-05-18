package cm.aptoide.pt.sync.alarm;

import android.content.Context;
import androidx.work.e;
import androidx.work.f;
import androidx.work.g;
import androidx.work.p;
import androidx.work.s;
import androidx.work.y;
import cm.aptoide.pt.notification.NotificationWorker;
import cm.aptoide.pt.sync.Sync;
import cm.aptoide.pt.sync.SyncScheduler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AlarmSyncScheduler implements SyncScheduler {
    public static final String ACTION_SYNC = "cm.aptoide.pt.sync.alarm.action.SYNC";
    public static final String EXTRA_RESCHEDULE = "cm.aptoide.pt.sync.alarm.extra.RESCHEDULE";
    private final Context context;
    private final SyncStorage syncStorage;

    public AlarmSyncScheduler(Context context, SyncStorage syncStorage) {
        this.context = context;
        this.syncStorage = syncStorage;
    }

    private void scheduleOneOffSync(Sync sync) {
        this.syncStorage.save(sync);
        setOneOffWorker(sync);
    }

    private void schedulePeriodicSync(Sync sync) {
        this.syncStorage.save(sync);
        setPeriodicWorker(sync);
    }

    private void setOneOffWorker(Sync sync) {
        y.h(this.context).f(sync.getId(), g.REPLACE, new p.a(NotificationWorker.class).g(new e.a().f("sync_id", sync.getId()).f("action", ACTION_SYNC).e(EXTRA_RESCHEDULE, false).a()).b());
    }

    private void setPeriodicWorker(Sync sync) {
        e a = new e.a().f("sync_id", sync.getId()).f("action", ACTION_SYNC).e(EXTRA_RESCHEDULE, false).a();
        long interval = sync.getInterval();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        y.h(this.context).e(sync.getId(), f.KEEP, new s.a(NotificationWorker.class, interval, timeUnit).g(a).f(sync.getInterval(), timeUnit).b());
    }

    @Override // cm.aptoide.pt.sync.SyncScheduler
    public void cancel(String str) {
        y.h(this.context).b(str);
        this.syncStorage.remove(str);
    }

    @Override // cm.aptoide.pt.sync.SyncScheduler
    public void reschedule(Sync sync) {
        schedule(sync);
    }

    @Override // cm.aptoide.pt.sync.SyncScheduler
    public void schedule(Sync sync) {
        if (sync.isPeriodic()) {
            schedulePeriodicSync(sync);
        } else {
            scheduleOneOffSync(sync);
        }
    }
}
