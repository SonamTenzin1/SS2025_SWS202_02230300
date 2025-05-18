package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.n.p;
import androidx.work.n;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommandHandler.java */
/* loaded from: classes.dex */
public class b implements androidx.work.impl.b {

    /* renamed from: f, reason: collision with root package name */
    private static final String f2353f = n.f("CommandHandler");

    /* renamed from: g, reason: collision with root package name */
    private final Context f2354g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, androidx.work.impl.b> f2355h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Object f2356i = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f2354g = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent c(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent e(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_RESCHEDULE");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent f(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent g(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    private void h(Intent intent, int i2, e eVar) {
        n.c().a(f2353f, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new c(this.f2354g, i2, eVar).a();
    }

    private void i(Intent intent, int i2, e eVar) {
        Bundle extras = intent.getExtras();
        synchronized (this.f2356i) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            n c2 = n.c();
            String str = f2353f;
            c2.a(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (!this.f2355h.containsKey(string)) {
                d dVar = new d(this.f2354g, i2, string, eVar);
                this.f2355h.put(string, dVar);
                dVar.f();
            } else {
                n.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            }
        }
    }

    private void j(Intent intent, int i2) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z = extras.getBoolean("KEY_NEEDS_RESCHEDULE");
        n.c().a(f2353f, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
        d(string, z);
    }

    private void k(Intent intent, int i2, e eVar) {
        n.c().a(f2353f, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(i2)), new Throwable[0]);
        eVar.g().x();
    }

    private void l(Intent intent, int i2, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        n c2 = n.c();
        String str = f2353f;
        c2.a(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase t = eVar.g().t();
        t.beginTransaction();
        try {
            p m = t.j().m(string);
            if (m == null) {
                n.c().h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (m.f2526d.g()) {
                n.c().h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                return;
            }
            long a = m.a();
            if (!m.b()) {
                n.c().a(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(a)), new Throwable[0]);
                a.c(this.f2354g, eVar.g(), string, a);
            } else {
                n.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(a)), new Throwable[0]);
                a.c(this.f2354g, eVar.g(), string, a);
                eVar.k(new e.b(eVar, a(this.f2354g), i2));
            }
            t.setTransactionSuccessful();
        } finally {
            t.endTransaction();
        }
    }

    private void m(Intent intent, e eVar) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        n.c().a(f2353f, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        eVar.g().C(string);
        a.a(this.f2354g, eVar.g(), string);
        eVar.d(string, false);
    }

    private static boolean n(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.work.impl.b
    public void d(String str, boolean z) {
        synchronized (this.f2356i) {
            androidx.work.impl.b remove = this.f2355h.remove(str);
            if (remove != null) {
                remove.d(str, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        boolean z;
        synchronized (this.f2356i) {
            z = !this.f2355h.isEmpty();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Intent intent, int i2, e eVar) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            h(intent, i2, eVar);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            k(intent, i2, eVar);
            return;
        }
        if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            n.c().b(f2353f, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            l(intent, i2, eVar);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            i(intent, i2, eVar);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            m(intent, eVar);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            j(intent, i2);
        } else {
            n.c().h(f2353f, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
