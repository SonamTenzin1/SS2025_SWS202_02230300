package io.sentry.transport;

import io.sentry.h4;
import io.sentry.j4;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.util.m;
import io.sentry.x4;
import io.sentry.z0;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;

/* compiled from: RateLimiter.java */
/* loaded from: classes2.dex */
public final class y {
    private final q a;

    /* renamed from: b, reason: collision with root package name */
    private final x4 f22752b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<z0, Date> f22753c;

    public y(q qVar, x4 x4Var) {
        this.f22753c = new ConcurrentHashMap();
        this.a = qVar;
        this.f22752b = x4Var;
    }

    private void a(z0 z0Var, Date date) {
        Date date2 = this.f22753c.get(z0Var);
        if (date2 == null || date.after(date2)) {
            this.f22753c.put(z0Var, date);
        }
    }

    private z0 c(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1963501277:
                if (str.equals("attachment")) {
                    c2 = 0;
                    break;
                }
                break;
            case -309425751:
                if (str.equals("profile")) {
                    c2 = 1;
                    break;
                }
                break;
            case 96891546:
                if (str.equals("event")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1984987798:
                if (str.equals("session")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2141246174:
                if (str.equals("transaction")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return z0.Attachment;
            case 1:
                return z0.Profile;
            case 2:
                return z0.Error;
            case 3:
                return z0.Session;
            case 4:
                return z0.Transaction;
            default:
                return z0.Unknown;
        }
    }

    private boolean d(String str) {
        Date date;
        z0 c2 = c(str);
        Date date2 = new Date(this.a.a());
        Date date3 = this.f22753c.get(z0.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (z0.Unknown.equals(c2) || (date = this.f22753c.get(c2)) == null) {
            return false;
        }
        return !date2.after(date);
    }

    private static void g(n1 n1Var, final boolean z) {
        io.sentry.util.m.k(n1Var, io.sentry.hints.p.class, new m.a() { // from class: io.sentry.transport.l
            @Override // io.sentry.util.m.a
            public final void a(Object obj) {
                ((io.sentry.hints.p) obj).c(false);
            }
        });
        io.sentry.util.m.k(n1Var, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.k
            @Override // io.sentry.util.m.a
            public final void a(Object obj) {
                ((io.sentry.hints.k) obj).d(z);
            }
        });
    }

    private long h(String str) {
        if (str != null) {
            try {
                return (long) (Double.parseDouble(str) * 1000.0d);
            } catch (NumberFormatException unused) {
            }
        }
        return 60000L;
    }

    public h4 b(h4 h4Var, n1 n1Var) {
        ArrayList arrayList = null;
        for (j4 j4Var : h4Var.c()) {
            if (d(j4Var.i().b().getItemType())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(j4Var);
                this.f22752b.getClientReportRecorder().d(io.sentry.clientreport.e.RATELIMIT_BACKOFF, j4Var);
            }
        }
        if (arrayList == null) {
            return h4Var;
        }
        this.f22752b.getLogger().c(s4.INFO, "%d items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        for (j4 j4Var2 : h4Var.c()) {
            if (!arrayList.contains(j4Var2)) {
                arrayList2.add(j4Var2);
            }
        }
        if (arrayList2.isEmpty()) {
            this.f22752b.getLogger().c(s4.INFO, "Envelope discarded due all items rate limited.", new Object[0]);
            g(n1Var, false);
            return null;
        }
        return new h4(h4Var.b(), arrayList2);
    }

    public void i(String str, String str2, int i2) {
        if (str == null) {
            if (i2 == 429) {
                a(z0.All, new Date(this.a.a() + h(str2)));
                return;
            }
            return;
        }
        int i3 = -1;
        String[] split = str.split(",", -1);
        int length = split.length;
        int i4 = 0;
        while (i4 < length) {
            String[] split2 = split[i4].replace(" ", HttpUrl.FRAGMENT_ENCODE_SET).split(":", i3);
            if (split2.length > 0) {
                long h2 = h(split2[0]);
                if (split2.length > 1) {
                    String str3 = split2[1];
                    Date date = new Date(this.a.a() + h2);
                    if (str3 != null && !str3.isEmpty()) {
                        for (String str4 : str3.split(";", i3)) {
                            z0 z0Var = z0.Unknown;
                            try {
                                String b2 = io.sentry.util.u.b(str4);
                                if (b2 != null) {
                                    z0Var = z0.valueOf(b2);
                                } else {
                                    this.f22752b.getLogger().c(s4.ERROR, "Couldn't capitalize: %s", str4);
                                }
                            } catch (IllegalArgumentException e2) {
                                this.f22752b.getLogger().a(s4.INFO, e2, "Unknown category: %s", str4);
                            }
                            if (!z0.Unknown.equals(z0Var)) {
                                a(z0Var, date);
                            }
                        }
                    } else {
                        a(z0.All, date);
                    }
                }
            }
            i4++;
            i3 = -1;
        }
    }

    public y(x4 x4Var) {
        this(o.b(), x4Var);
    }
}
