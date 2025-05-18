package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.j;
import androidx.work.impl.n.g;
import androidx.work.impl.n.h;
import androidx.work.impl.n.k;
import androidx.work.impl.n.p;
import androidx.work.impl.n.q;
import androidx.work.impl.n.t;
import androidx.work.n;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {
    private static final String a = n.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String a(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", pVar.f2525c, pVar.f2527e, num, pVar.f2526d.name(), str, str2);
    }

    private static String c(k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (p pVar : list) {
            Integer num = null;
            g c2 = hVar.c(pVar.f2525c);
            if (c2 != null) {
                num = Integer.valueOf(c2.f2515b);
            }
            sb.append(a(pVar, TextUtils.join(",", kVar.b(pVar.f2525c)), num, TextUtils.join(",", tVar.b(pVar.f2525c))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a doWork() {
        WorkDatabase t = j.p(getApplicationContext()).t();
        q j2 = t.j();
        k h2 = t.h();
        t k2 = t.k();
        h g2 = t.g();
        List<p> d2 = j2.d(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<p> i2 = j2.i();
        List<p> s = j2.s(200);
        if (d2 != null && !d2.isEmpty()) {
            n c2 = n.c();
            String str = a;
            c2.d(str, "Recently completed work:\n\n", new Throwable[0]);
            n.c().d(str, c(h2, k2, g2, d2), new Throwable[0]);
        }
        if (i2 != null && !i2.isEmpty()) {
            n c3 = n.c();
            String str2 = a;
            c3.d(str2, "Running work:\n\n", new Throwable[0]);
            n.c().d(str2, c(h2, k2, g2, i2), new Throwable[0]);
        }
        if (s != null && !s.isEmpty()) {
            n c4 = n.c();
            String str3 = a;
            c4.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            n.c().d(str3, c(h2, k2, g2, s), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
