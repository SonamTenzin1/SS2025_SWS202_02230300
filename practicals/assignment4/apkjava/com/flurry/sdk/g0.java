package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.v3;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class g0 {
    private static boolean a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10767b = false;

    /* renamed from: c, reason: collision with root package name */
    private static g0 f10768c;

    /* renamed from: d, reason: collision with root package name */
    private int f10769d = p2.e("invalid.payload.count", 0);

    /* loaded from: classes2.dex */
    public static class a {
        int a;

        /* renamed from: b, reason: collision with root package name */
        Set<s6> f10770b;

        /* renamed from: c, reason: collision with root package name */
        int f10771c;

        public a() {
            if (g0.f10767b) {
                this.a = p2.e("drop.frame.count", 0);
                this.f10770b = new TreeSet();
                String g2 = p2.g("drop.frame.types", HttpUrl.FRAGMENT_ENCODE_SET);
                if (!TextUtils.isEmpty(g2)) {
                    for (String str : g2.split(",")) {
                        try {
                            this.f10770b.add(s6.g(Integer.parseInt(str)));
                        } catch (NumberFormatException e2) {
                            d1.c(5, "SDKLogManager", "Cannot retrieve frame type from preferences: " + e2.getMessage());
                        }
                    }
                }
                this.f10771c = p2.e("auto.end.timed.events", 0);
            }
        }

        public final synchronized void a() {
            if (g0.f10767b) {
                int i2 = this.f10771c + 1;
                this.f10771c = i2;
                p2.b("auto.end.timed.events", i2);
            }
        }

        public final synchronized void b(s6 s6Var) {
            if (g0.f10767b) {
                this.a++;
                this.f10770b.add(s6Var);
                p2.b("drop.frame.count", this.a);
                StringBuilder sb = new StringBuilder();
                for (s6 s6Var2 : this.f10770b) {
                    if (sb.length() != 0) {
                        sb.append(',');
                    }
                    sb.append(s6Var2.T);
                }
                p2.d("drop.frame.types", sb.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum b {
        UNKNOWN(0),
        SUCCEED(1),
        IOEXCEPTION(2),
        EOF(3),
        PAYLOAD_ERROR(4),
        FRAME_MISSING(5);

        private final int m;
        public String n = null;
        public int o = 0;
        public int p = 0;
        public List<s6> q = null;
        public Set<s6> r = null;

        b(int i2) {
            this.m = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        int a = 0;

        public final void a(int i2) {
            this.a += i2;
        }
    }

    private g0() {
    }

    public static synchronized g0 a() {
        g0 g0Var;
        synchronized (g0.class) {
            if (f10768c == null) {
                f10768c = new g0();
            }
            g0Var = f10768c;
        }
        return g0Var;
    }

    public static void c(String str, String str2, Throwable th) {
        Map emptyMap = Collections.emptyMap();
        if (com.flurry.sdk.a.x()) {
            e.d.a.b.f(str, str2, th, emptyMap);
            d1.c(4, "SDKLogManager", "Log SDK internal errors. " + str2 + "SDKLogManager");
        }
    }

    public static void d(String str, Map<String, String> map) {
        if (f10767b && com.flurry.sdk.a.x()) {
            com.flurry.sdk.a.v().s(str, v3.a.SDK_LOG, map);
            d1.c(4, "SDKLogManager", "Log SDK events: " + str + " with " + map);
        }
    }

    public static void f(String str, Map<String, String> map) {
        if (a && com.flurry.sdk.a.x()) {
            com.flurry.sdk.a.v().s(str, v3.a.SDK_LOG, map);
            d1.c(4, "SDKLogManager", "Log SDK internal events. " + str + "SDKLogManager");
        }
    }

    public final synchronized void b(b bVar) {
        s6 s6Var;
        if (f10767b) {
            HashMap hashMap = new HashMap();
            hashMap.put("fl.length", String.valueOf(bVar.o));
            hashMap.put("fl.frame.count", String.valueOf(bVar.p));
            List<s6> list = bVar.q;
            if (list == null || list.isEmpty()) {
                s6Var = s6.UNKNOWN;
            } else {
                s6Var = bVar.q.get(r1.size() - 1);
            }
            hashMap.put("fl.last.frame.type", String.valueOf(s6Var));
            hashMap.put("fl.failure.type", String.valueOf(bVar));
            hashMap.put("fl.failure.reason", bVar.n);
            hashMap.put("fl.mandatory.frames", String.valueOf(bVar.r));
            bVar.n = null;
            bVar.o = 0;
            bVar.p = 0;
            bVar.q = null;
            bVar.r = null;
            int i2 = this.f10769d + 1;
            this.f10769d = i2;
            p2.b("invalid.payload.count", i2);
            d("Flurry.SDKReport.PayloadError", hashMap);
        }
    }

    public final synchronized void e() {
        if (f10767b) {
            c d2 = m2.a().f10915d.d();
            a d3 = m2.a().f10913b.a.d();
            HashMap hashMap = new HashMap();
            hashMap.put("fl.invalid.payload.count", String.valueOf(this.f10769d));
            hashMap.put("fl.payload.queue.size", String.valueOf(d2.a));
            hashMap.put("fl.drop.frame.count", String.valueOf(d3.a));
            hashMap.put("fl.drop.frame.types", String.valueOf(d3.f10770b));
            hashMap.put("fl.auto.end.timed.events", String.valueOf(d3.f10771c));
            this.f10769d = 0;
            d2.a = 0;
            d3.a = 0;
            d3.f10770b.clear();
            d3.f10771c = 0;
            p2.b("invalid.payload.count", 0);
            p2.b("drop.frame.count", 0);
            p2.d("drop.frame.types", HttpUrl.FRAGMENT_ENCODE_SET);
            p2.b("auto.end.timed.events", 0);
            d("Flurry.SDKReport.SessionSummary", hashMap);
        }
    }
}
