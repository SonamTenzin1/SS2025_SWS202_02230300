package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import io.sentry.android.core.t0;
import io.sentry.c4;
import io.sentry.f5;
import io.sentry.j1;
import io.sentry.l4;
import io.sentry.m4;
import io.sentry.n1;
import io.sentry.protocol.DebugImage;
import io.sentry.s4;
import io.sentry.v0;
import io.sentry.z4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AnrV2EventProcessor.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class p0 implements io.sentry.t0 {

    /* renamed from: f, reason: collision with root package name */
    private final Context f22248f;

    /* renamed from: g, reason: collision with root package name */
    private final SentryAndroidOptions f22249g;

    /* renamed from: h, reason: collision with root package name */
    private final s0 f22250h;

    /* renamed from: i, reason: collision with root package name */
    private final m4 f22251i;

    public p0(Context context, SentryAndroidOptions sentryAndroidOptions, s0 s0Var) {
        this.f22248f = context;
        this.f22249g = sentryAndroidOptions;
        this.f22250h = s0Var;
        this.f22251i = new m4(new z4(sentryAndroidOptions));
    }

    private void A(c4 c4Var) {
        if (c4Var.J() == null) {
            c4Var.Y((String) io.sentry.cache.s.v(this.f22249g, "release.json", String.class));
        }
    }

    private void B(c4 c4Var) {
        if (c4Var.K() == null) {
            c4Var.Z((io.sentry.protocol.l) io.sentry.cache.t.q(this.f22249g, "request.json", io.sentry.protocol.l.class));
        }
    }

    private void C(c4 c4Var) {
        Map map = (Map) io.sentry.cache.t.q(this.f22249g, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (c4Var.N() == null) {
            c4Var.d0(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!c4Var.N().containsKey(entry.getKey())) {
                c4Var.c0((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void D(c4 c4Var) {
        if (c4Var.L() == null) {
            c4Var.a0((io.sentry.protocol.o) io.sentry.cache.s.v(this.f22249g, "sdk-version.json", io.sentry.protocol.o.class));
        }
    }

    private void E(c4 c4Var) {
        try {
            t0.a p = t0.p(this.f22248f, this.f22249g.getLogger(), this.f22250h);
            if (p != null) {
                for (Map.Entry<String, String> entry : p.a().entrySet()) {
                    c4Var.c0(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f22249g.getLogger().b(s4.ERROR, "Error getting side loaded info.", th);
        }
    }

    private void F(l4 l4Var) {
        m(l4Var);
        E(l4Var);
    }

    private void G(l4 l4Var) {
        f5 f5Var = (f5) io.sentry.cache.t.q(this.f22249g, "trace.json", f5.class);
        if (l4Var.C().e() != null || f5Var == null || f5Var.h() == null || f5Var.k() == null) {
            return;
        }
        l4Var.C().n(f5Var);
    }

    private void H(l4 l4Var) {
        String str = (String) io.sentry.cache.t.q(this.f22249g, "transaction.json", String.class);
        if (l4Var.t0() == null) {
            l4Var.E0(str);
        }
    }

    private void I(c4 c4Var) {
        if (c4Var.Q() == null) {
            c4Var.e0((io.sentry.protocol.a0) io.sentry.cache.t.q(this.f22249g, "user.json", io.sentry.protocol.a0.class));
        }
    }

    private void a(l4 l4Var, Object obj) {
        A(l4Var);
        t(l4Var);
        s(l4Var);
        q(l4Var);
        D(l4Var);
        n(l4Var, obj);
        y(l4Var);
    }

    private void c(l4 l4Var) {
        B(l4Var);
        I(l4Var);
        C(l4Var);
        o(l4Var);
        v(l4Var);
        p(l4Var);
        H(l4Var);
        w(l4Var);
        x(l4Var);
        G(l4Var);
    }

    private io.sentry.protocol.w d(List<io.sentry.protocol.w> list) {
        if (list == null) {
            return null;
        }
        for (io.sentry.protocol.w wVar : list) {
            String m = wVar.m();
            if (m != null && m.equals("main")) {
                return wVar;
            }
        }
        return null;
    }

    private io.sentry.protocol.a0 f() {
        io.sentry.protocol.a0 a0Var = new io.sentry.protocol.a0();
        a0Var.n(h());
        return a0Var;
    }

    @SuppressLint({"NewApi"})
    private io.sentry.protocol.e g() {
        io.sentry.protocol.e eVar = new io.sentry.protocol.e();
        if (this.f22249g.isSendDefaultPii()) {
            eVar.g0(t0.d(this.f22248f, this.f22250h));
        }
        eVar.c0(Build.MANUFACTURER);
        eVar.Q(Build.BRAND);
        eVar.V(t0.f(this.f22249g.getLogger()));
        eVar.e0(Build.MODEL);
        eVar.f0(Build.ID);
        eVar.M(t0.c(this.f22250h));
        ActivityManager.MemoryInfo h2 = t0.h(this.f22248f, this.f22249g.getLogger());
        if (h2 != null) {
            eVar.d0(i(h2));
        }
        eVar.p0(this.f22250h.f());
        DisplayMetrics e2 = t0.e(this.f22248f, this.f22249g.getLogger());
        if (e2 != null) {
            eVar.o0(Integer.valueOf(e2.widthPixels));
            eVar.n0(Integer.valueOf(e2.heightPixels));
            eVar.l0(Float.valueOf(e2.density));
            eVar.m0(Integer.valueOf(e2.densityDpi));
        }
        if (eVar.J() == null) {
            eVar.Y(h());
        }
        List<Integer> c2 = io.sentry.android.core.internal.util.m.a().c();
        if (!c2.isEmpty()) {
            eVar.k0(Double.valueOf(((Integer) Collections.max(c2)).doubleValue()));
            eVar.j0(Integer.valueOf(c2.size()));
        }
        return eVar;
    }

    private String h() {
        try {
            return a1.a(this.f22248f);
        } catch (Throwable th) {
            this.f22249g.getLogger().b(s4.ERROR, "Error getting installationId.", th);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    private Long i(ActivityManager.MemoryInfo memoryInfo) {
        if (this.f22250h.d() >= 16) {
            return Long.valueOf(memoryInfo.totalMem);
        }
        return Long.valueOf(Runtime.getRuntime().totalMemory());
    }

    private io.sentry.protocol.k j() {
        io.sentry.protocol.k kVar = new io.sentry.protocol.k();
        kVar.j("Android");
        kVar.m(Build.VERSION.RELEASE);
        kVar.h(Build.DISPLAY);
        try {
            kVar.i(t0.g(this.f22249g.getLogger()));
        } catch (Throwable th) {
            this.f22249g.getLogger().b(s4.ERROR, "Error getting OperatingSystem.", th);
        }
        return kVar;
    }

    private boolean k(Object obj) {
        if (obj instanceof io.sentry.hints.b) {
            return "anr_background".equals(((io.sentry.hints.b) obj).f());
        }
        return false;
    }

    private void l(c4 c4Var) {
        String str;
        io.sentry.protocol.k c2 = c4Var.C().c();
        c4Var.C().k(j());
        if (c2 != null) {
            String g2 = c2.g();
            if (g2 == null || g2.isEmpty()) {
                str = "os_1";
            } else {
                str = "os_" + g2.trim().toLowerCase(Locale.ROOT);
            }
            c4Var.C().put(str, c2);
        }
    }

    private void m(c4 c4Var) {
        if (this.f22249g.isSendDefaultPii()) {
            if (c4Var.Q() == null) {
                io.sentry.protocol.a0 a0Var = new io.sentry.protocol.a0();
                a0Var.o("{{auto}}");
                c4Var.e0(a0Var);
            } else if (c4Var.Q().l() == null) {
                c4Var.Q().o("{{auto}}");
            }
        }
        io.sentry.protocol.a0 Q = c4Var.Q();
        if (Q == null) {
            c4Var.e0(f());
        } else if (Q.k() == null) {
            Q.n(h());
        }
    }

    private void n(c4 c4Var, Object obj) {
        String str;
        io.sentry.protocol.a a = c4Var.C().a();
        if (a == null) {
            a = new io.sentry.protocol.a();
        }
        a.m(t0.b(this.f22248f, this.f22249g.getLogger()));
        a.p(Boolean.valueOf(!k(obj)));
        PackageInfo j2 = t0.j(this.f22248f, this.f22249g.getLogger(), this.f22250h);
        if (j2 != null) {
            a.l(j2.packageName);
        }
        if (c4Var.J() != null) {
            str = c4Var.J();
        } else {
            str = (String) io.sentry.cache.s.v(this.f22249g, "release.json", String.class);
        }
        if (str != null) {
            try {
                String substring = str.substring(str.indexOf(64) + 1, str.indexOf(43));
                String substring2 = str.substring(str.indexOf(43) + 1);
                a.o(substring);
                a.k(substring2);
            } catch (Throwable unused) {
                this.f22249g.getLogger().c(s4.WARNING, "Failed to parse release from scope cache: %s", str);
            }
        }
        c4Var.C().f(a);
    }

    private void o(c4 c4Var) {
        List list = (List) io.sentry.cache.t.r(this.f22249g, "breadcrumbs.json", List.class, new v0.a());
        if (list == null) {
            return;
        }
        if (c4Var.B() == null) {
            c4Var.R(new ArrayList(list));
        } else {
            c4Var.B().addAll(list);
        }
    }

    private void p(c4 c4Var) {
        io.sentry.protocol.c cVar = (io.sentry.protocol.c) io.sentry.cache.t.q(this.f22249g, "contexts.json", io.sentry.protocol.c.class);
        if (cVar == null) {
            return;
        }
        io.sentry.protocol.c C = c4Var.C();
        for (Map.Entry<String, Object> entry : new io.sentry.protocol.c(cVar).entrySet()) {
            Object value = entry.getValue();
            if (!"trace".equals(entry.getKey()) || !(value instanceof f5)) {
                if (!C.containsKey(entry.getKey())) {
                    C.put(entry.getKey(), value);
                }
            }
        }
    }

    private void q(c4 c4Var) {
        io.sentry.protocol.d D = c4Var.D();
        if (D == null) {
            D = new io.sentry.protocol.d();
        }
        if (D.c() == null) {
            D.d(new ArrayList());
        }
        List<DebugImage> c2 = D.c();
        if (c2 != null) {
            String str = (String) io.sentry.cache.s.v(this.f22249g, "proguard-uuid.json", String.class);
            if (str != null) {
                DebugImage debugImage = new DebugImage();
                debugImage.setType(DebugImage.PROGUARD);
                debugImage.setUuid(str);
                c2.add(debugImage);
            }
            c4Var.S(D);
        }
    }

    private void r(c4 c4Var) {
        if (c4Var.C().b() == null) {
            c4Var.C().i(g());
        }
    }

    private void s(c4 c4Var) {
        String str;
        if (c4Var.E() == null) {
            c4Var.T((String) io.sentry.cache.s.v(this.f22249g, "dist.json", String.class));
        }
        if (c4Var.E() != null || (str = (String) io.sentry.cache.s.v(this.f22249g, "release.json", String.class)) == null) {
            return;
        }
        try {
            c4Var.T(str.substring(str.indexOf(43) + 1));
        } catch (Throwable unused) {
            this.f22249g.getLogger().c(s4.WARNING, "Failed to parse release from scope cache: %s", str);
        }
    }

    private void t(c4 c4Var) {
        if (c4Var.F() == null) {
            String str = (String) io.sentry.cache.s.v(this.f22249g, "environment.json", String.class);
            if (str == null) {
                str = this.f22249g.getEnvironment();
            }
            c4Var.U(str);
        }
    }

    private void u(l4 l4Var, Object obj) {
        io.sentry.protocol.i iVar = new io.sentry.protocol.i();
        if (!((io.sentry.hints.d) obj).a()) {
            iVar.j("HistoricalAppExitInfo");
        } else {
            iVar.j("AppExitInfo");
        }
        String str = "ANR";
        if (k(obj)) {
            str = "Background ANR";
        }
        ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(str, Thread.currentThread());
        io.sentry.protocol.w d2 = d(l4Var.s0());
        if (d2 == null) {
            d2 = new io.sentry.protocol.w();
            d2.y(new io.sentry.protocol.v());
        }
        l4Var.x0(this.f22251i.e(d2, iVar, applicationNotResponding));
    }

    private void v(c4 c4Var) {
        Map map = (Map) io.sentry.cache.t.q(this.f22249g, "extras.json", Map.class);
        if (map == null) {
            return;
        }
        if (c4Var.H() == null) {
            c4Var.W(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!c4Var.H().containsKey(entry.getKey())) {
                c4Var.H().put((String) entry.getKey(), entry.getValue());
            }
        }
    }

    private void w(l4 l4Var) {
        List<String> list = (List) io.sentry.cache.t.q(this.f22249g, "fingerprint.json", List.class);
        if (l4Var.p0() == null) {
            l4Var.y0(list);
        }
    }

    private void x(l4 l4Var) {
        s4 s4Var = (s4) io.sentry.cache.t.q(this.f22249g, "level.json", s4.class);
        if (l4Var.q0() == null) {
            l4Var.z0(s4Var);
        }
    }

    private void y(c4 c4Var) {
        Map map = (Map) io.sentry.cache.s.v(this.f22249g, "tags.json", Map.class);
        if (map == null) {
            return;
        }
        if (c4Var.N() == null) {
            c4Var.d0(new HashMap(map));
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!c4Var.N().containsKey(entry.getKey())) {
                c4Var.c0((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void z(c4 c4Var) {
        if (c4Var.I() == null) {
            c4Var.X("java");
        }
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        Object c2 = io.sentry.util.m.c(n1Var);
        if (!(c2 instanceof io.sentry.hints.d)) {
            this.f22249g.getLogger().c(s4.WARNING, "The event is not Backfillable, but has been passed to BackfillingEventProcessor, skipping.", new Object[0]);
            return l4Var;
        }
        u(l4Var, c2);
        z(l4Var);
        l(l4Var);
        r(l4Var);
        if (!((io.sentry.hints.d) c2).a()) {
            this.f22249g.getLogger().c(s4.DEBUG, "The event is Backfillable, but should not be enriched, skipping.", new Object[0]);
            return l4Var;
        }
        c(l4Var);
        a(l4Var, c2);
        F(l4Var);
        return l4Var;
    }

    @Override // io.sentry.k1
    public /* synthetic */ io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        return j1.a(this, xVar, n1Var);
    }
}
