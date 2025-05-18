package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.x;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private static final String f2554f = androidx.work.n.f("ForceStopRunnable");

    /* renamed from: g, reason: collision with root package name */
    private static final long f2555g = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: h, reason: collision with root package name */
    private final Context f2556h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.work.impl.j f2557i;

    /* renamed from: j, reason: collision with root package name */
    private int f2558j = 0;

    /* loaded from: classes.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String a = androidx.work.n.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            androidx.work.n.c().g(a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(Context context, androidx.work.impl.j jVar) {
        this.f2556h = context.getApplicationContext();
        this.f2557i = jVar;
    }

    static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent d(Context context, int i2) {
        return PendingIntent.getBroadcast(context, -1, c(context), i2);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent d2 = d(context, androidx.core.os.a.c() ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + f2555g;
        if (alarmManager != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, currentTimeMillis, d2);
            } else {
                alarmManager.set(0, currentTimeMillis, d2);
            }
        }
    }

    public boolean a() {
        boolean h2 = Build.VERSION.SDK_INT >= 23 ? androidx.work.impl.background.systemjob.b.h(this.f2556h, this.f2557i) : false;
        WorkDatabase t = this.f2557i.t();
        q j2 = t.j();
        androidx.work.impl.n.n i2 = t.i();
        t.beginTransaction();
        try {
            List<p> i3 = j2.i();
            boolean z = (i3 == null || i3.isEmpty()) ? false : true;
            if (z) {
                for (p pVar : i3) {
                    j2.a(x.a.ENQUEUED, pVar.f2525c);
                    j2.b(pVar.f2525c, -1L);
                }
            }
            i2.a();
            t.setTransactionSuccessful();
            return z || h2;
        } finally {
            t.endTransaction();
        }
    }

    public void b() {
        boolean a = a();
        if (h()) {
            androidx.work.n.c().a(f2554f, "Rescheduling Workers.", new Throwable[0]);
            this.f2557i.x();
            this.f2557i.q().c(false);
        } else if (e()) {
            androidx.work.n.c().a(f2554f, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f2557i.x();
        } else if (a) {
            androidx.work.n.c().a(f2554f, "Found unfinished work, scheduling it.", new Throwable[0]);
            androidx.work.impl.f.b(this.f2557i.n(), this.f2557i.t(), this.f2557i.s());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        try {
            PendingIntent d2 = d(this.f2556h, androidx.core.os.a.c() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (d2 != null) {
                    d2.cancel();
                }
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f2556h.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i2 = 0; i2 < historicalProcessExitReasons.size(); i2++) {
                        if (historicalProcessExitReasons.get(i2).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (d2 == null) {
                g(this.f2556h);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e2) {
            androidx.work.n.c().h(f2554f, "Ignoring exception", e2);
            return true;
        }
    }

    public boolean f() {
        androidx.work.b n = this.f2557i.n();
        if (TextUtils.isEmpty(n.c())) {
            androidx.work.n.c().a(f2554f, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean b2 = f.b(this.f2556h, n);
        androidx.work.n.c().a(f2554f, String.format("Is default app process = %s", Boolean.valueOf(b2)), new Throwable[0]);
        return b2;
    }

    boolean h() {
        return this.f2557i.q().a();
    }

    public void i(long j2) {
        try {
            Thread.sleep(j2);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2;
        try {
            if (f()) {
                while (true) {
                    androidx.work.impl.i.e(this.f2556h);
                    androidx.work.n.c().a(f2554f, "Performing cleanup operations.", new Throwable[0]);
                    try {
                        b();
                        break;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e2) {
                        i2 = this.f2558j + 1;
                        this.f2558j = i2;
                        if (i2 >= 3) {
                            androidx.work.n c2 = androidx.work.n.c();
                            String str = f2554f;
                            c2.b(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                            IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e2);
                            androidx.work.j d2 = this.f2557i.n().d();
                            if (d2 != null) {
                                androidx.work.n.c().a(str, "Routing exception to the specified exception handler", illegalStateException);
                                d2.a(illegalStateException);
                            } else {
                                throw illegalStateException;
                            }
                        } else {
                            androidx.work.n.c().a(f2554f, String.format("Retrying after %s", Long.valueOf(i2 * 300)), e2);
                            i(this.f2558j * 300);
                        }
                    }
                    androidx.work.n.c().a(f2554f, String.format("Retrying after %s", Long.valueOf(i2 * 300)), e2);
                    i(this.f2558j * 300);
                }
            }
        } finally {
            this.f2557i.w();
        }
    }
}
