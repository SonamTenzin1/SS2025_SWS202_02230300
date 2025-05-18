package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.j;
import androidx.work.impl.n.g;
import androidx.work.impl.n.h;
import androidx.work.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Alarms.java */
/* loaded from: classes.dex */
public class a {
    private static final String a = n.f("Alarms");

    public static void a(Context context, j jVar, String str) {
        h g2 = jVar.t().g();
        g c2 = g2.c(str);
        if (c2 != null) {
            b(context, str, c2.f2515b);
            n.c().a(a, String.format("Removing SystemIdInfo for workSpecId (%s)", str), new Throwable[0]);
            g2.d(str);
        }
    }

    private static void b(Context context, String str, int i2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i2, b.b(context, str), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        n.c().a(a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", str, Integer.valueOf(i2)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void c(Context context, j jVar, String str, long j2) {
        WorkDatabase t = jVar.t();
        h g2 = t.g();
        g c2 = g2.c(str);
        if (c2 != null) {
            b(context, str, c2.f2515b);
            d(context, str, c2.f2515b, j2);
        } else {
            int b2 = new androidx.work.impl.utils.c(t).b();
            g2.b(new g(str, b2));
            d(context, str, b2, j2);
        }
    }

    private static void d(Context context, String str, int i2, long j2) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i3 = Build.VERSION.SDK_INT;
        PendingIntent service = PendingIntent.getService(context, i2, b.b(context, str), i3 >= 23 ? 201326592 : 134217728);
        if (alarmManager != null) {
            if (i3 >= 19) {
                alarmManager.setExact(0, j2, service);
            } else {
                alarmManager.set(0, j2, service);
            }
        }
    }
}
