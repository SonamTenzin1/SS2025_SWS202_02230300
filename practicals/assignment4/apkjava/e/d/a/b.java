package e.d.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.flurry.sdk.a;
import com.flurry.sdk.b0;
import com.flurry.sdk.c2;
import com.flurry.sdk.d1;
import com.flurry.sdk.e7;
import com.flurry.sdk.k0;
import com.flurry.sdk.m2;
import com.flurry.sdk.w4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: j, reason: collision with root package name */
        private e.d.a.a f20697j;
        private c a = null;

        /* renamed from: b, reason: collision with root package name */
        private boolean f20689b = false;

        /* renamed from: c, reason: collision with root package name */
        private int f20690c = 5;

        /* renamed from: d, reason: collision with root package name */
        private long f20691d = 10000;

        /* renamed from: e, reason: collision with root package name */
        private boolean f20692e = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f20693f = true;

        /* renamed from: g, reason: collision with root package name */
        private boolean f20694g = false;

        /* renamed from: h, reason: collision with root package name */
        private int f20695h = f.a;

        /* renamed from: i, reason: collision with root package name */
        private List<e> f20696i = new ArrayList();

        /* renamed from: k, reason: collision with root package name */
        private boolean f20698k = false;
        private boolean l = false;

        public void a(Context context, String str) {
            boolean z;
            if (b.a()) {
                if (!TextUtils.isEmpty(str)) {
                    b0.b(context);
                    k0.a().f10860c = str;
                    com.flurry.sdk.a v = com.flurry.sdk.a.v();
                    c cVar = this.a;
                    boolean z2 = this.f20689b;
                    int i2 = this.f20690c;
                    long j2 = this.f20691d;
                    boolean z3 = this.f20692e;
                    boolean z4 = this.f20693f;
                    boolean z5 = this.f20694g;
                    int i3 = this.f20695h;
                    List<e> list = this.f20696i;
                    e.d.a.a aVar = this.f20697j;
                    boolean z6 = this.f20698k;
                    boolean z7 = this.l;
                    if (com.flurry.sdk.a.o.get()) {
                        d1.n("FlurryAgentImpl", "Invalid call to Init. Flurry is already initialized");
                        return;
                    }
                    d1.n("FlurryAgentImpl", "Initializing Flurry SDK");
                    if (com.flurry.sdk.a.o.get()) {
                        d1.n("FlurryAgentImpl", "Invalid call to register. Flurry is already initialized");
                    } else {
                        v.q = list;
                    }
                    m2.a();
                    v.m(new a.b(context, list));
                    w4 a = w4.a();
                    e7 a2 = e7.a();
                    if (a2 != null) {
                        z = z6;
                        a2.f10723b.v(a.f11127h);
                        a2.f10724c.v(a.f11128i);
                        a2.f10725d.v(a.f11125f);
                        a2.f10726e.v(a.f11126g);
                        a2.f10727f.v(a.l);
                        a2.f10728g.v(a.f11123d);
                        a2.f10729h.v(a.f11124e);
                        a2.f10730i.v(a.f11130k);
                        a2.f10731j.v(a.f11121b);
                        a2.f10732k.v(a.f11129j);
                        a2.l.v(a.f11122c);
                        a2.m.v(a.m);
                        a2.o.v(a.n);
                        a2.p.v(a.o);
                        a2.q.v(a.p);
                    } else {
                        z = z6;
                    }
                    k0.a().c();
                    e7.a().f10731j.a();
                    e7.a().f10728g.q = z3;
                    if (aVar != null) {
                        e7.a().m.x(aVar);
                    }
                    if (z2) {
                        d1.g();
                    } else {
                        d1.a();
                    }
                    d1.b(i2);
                    v.m(new a.C0156a(j2, cVar));
                    v.m(new a.g(z4, z5));
                    v.m(new a.d(i3, context));
                    v.m(new a.e(z));
                    com.flurry.sdk.a.o.set(true);
                    if (z7) {
                        d1.n("FlurryAgentImpl", "Force start session");
                        v.w(context.getApplicationContext());
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("API key not specified");
            }
        }

        public a b(boolean z) {
            this.f20692e = z;
            return this;
        }

        public a c(boolean z) {
            this.f20693f = z;
            return this;
        }

        public a d(boolean z) {
            this.f20689b = z;
            return this;
        }

        public a e(int i2) {
            this.f20695h = i2;
            return this;
        }
    }

    /* renamed from: e.d.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0255b {
        public static void a(String str, String str2) {
            if (b.a()) {
                com.flurry.sdk.a v = com.flurry.sdk.a.v();
                if (!com.flurry.sdk.a.o.get()) {
                    d1.n("FlurryAgentImpl", "Invalid call to UserProperties.add. Flurry is not initialized");
                } else {
                    v.m(new a.c(str, str2));
                }
            }
        }
    }

    static /* synthetic */ boolean a() {
        return b();
    }

    private static boolean b() {
        if (c2.g(16)) {
            return true;
        }
        d1.j("FlurryAgent", String.format(Locale.getDefault(), "Device SDK Version older than %d", 16));
        return false;
    }

    public static d c(String str) {
        return !b() ? d.kFlurryEventFailed : com.flurry.sdk.a.v().u(str, Collections.emptyMap(), false, false);
    }

    public static d d(String str, Map<String, String> map) {
        d dVar = d.kFlurryEventFailed;
        if (!b()) {
            return dVar;
        }
        if (str == null) {
            d1.j("FlurryAgent", "String eventId passed to logEvent was null.");
            return dVar;
        }
        if (map == null) {
            d1.l("FlurryAgent", "String parameters passed to logEvent was null.");
        }
        return com.flurry.sdk.a.v().u(str, map, false, false);
    }

    public static void e(Context context) {
        if (b()) {
            com.flurry.sdk.a v = com.flurry.sdk.a.v();
            if (context instanceof Activity) {
                d1.e("FlurryAgentImpl", "Activity's session is controlled by Flurry SDK");
            } else if (!com.flurry.sdk.a.o.get()) {
                d1.n("FlurryAgentImpl", "Invalid call to onStartSession. Flurry is not initialized");
            } else {
                v.m(new a.h());
            }
        }
    }

    public static void f(String str, String str2, Throwable th, Map<String, String> map) {
        if (b()) {
            com.flurry.sdk.a v = com.flurry.sdk.a.v();
            if (!com.flurry.sdk.a.o.get()) {
                d1.n("FlurryAgentImpl", "Invalid call to onError. Flurry is not initialized");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            v.m(new a.j(str, currentTimeMillis, str2, th, hashMap));
        }
    }

    public static void g(Context context) {
        if (b()) {
            com.flurry.sdk.a.v().w(context);
        }
    }
}
