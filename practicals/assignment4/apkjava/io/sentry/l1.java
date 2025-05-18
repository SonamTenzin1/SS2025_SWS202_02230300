package io.sentry;

import io.sentry.x4;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ExternalOptions.java */
/* loaded from: classes2.dex */
public final class l1 {
    private List<String> A;
    private Boolean B;
    private String a;

    /* renamed from: b, reason: collision with root package name */
    private String f22478b;

    /* renamed from: c, reason: collision with root package name */
    private String f22479c;

    /* renamed from: d, reason: collision with root package name */
    private String f22480d;

    /* renamed from: e, reason: collision with root package name */
    private String f22481e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f22482f;

    /* renamed from: g, reason: collision with root package name */
    private Boolean f22483g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f22484h;

    /* renamed from: i, reason: collision with root package name */
    private Boolean f22485i;

    /* renamed from: j, reason: collision with root package name */
    private Double f22486j;

    /* renamed from: k, reason: collision with root package name */
    private Double f22487k;
    private x4.f l;
    private x4.e n;
    private String s;
    private Long t;
    private Boolean v;
    private Boolean w;
    private Boolean y;
    private Boolean z;
    private final Map<String, String> m = new ConcurrentHashMap();
    private final List<String> o = new CopyOnWriteArrayList();
    private final List<String> p = new CopyOnWriteArrayList();
    private List<String> q = null;
    private final List<String> r = new CopyOnWriteArrayList();
    private final Set<Class<? extends Throwable>> u = new CopyOnWriteArraySet();
    private Set<String> x = new CopyOnWriteArraySet();

    /* JADX WARN: Multi-variable type inference failed */
    public static l1 g(io.sentry.config.g gVar, w1 w1Var) {
        l1 l1Var = new l1();
        l1Var.K(gVar.b("dsn"));
        l1Var.Q(gVar.b("environment"));
        l1Var.Y(gVar.b("release"));
        l1Var.J(gVar.b("dist"));
        l1Var.b0(gVar.b("servername"));
        l1Var.O(gVar.c("uncaught.handler.enabled"));
        l1Var.U(gVar.c("uncaught.handler.print-stacktrace"));
        l1Var.N(gVar.c("enable-tracing"));
        l1Var.d0(gVar.e("traces-sample-rate"));
        l1Var.V(gVar.e("profiles-sample-rate"));
        l1Var.I(gVar.c("debug"));
        l1Var.L(gVar.c("enable-deduplication"));
        l1Var.Z(gVar.c("send-client-reports"));
        String b2 = gVar.b("max-request-body-size");
        if (b2 != null) {
            l1Var.T(x4.f.valueOf(b2.toUpperCase(Locale.ROOT)));
        }
        for (Map.Entry<String, String> entry : gVar.a("tags").entrySet()) {
            l1Var.c0(entry.getKey(), entry.getValue());
        }
        String b3 = gVar.b("proxy.host");
        String b4 = gVar.b("proxy.user");
        String b5 = gVar.b("proxy.pass");
        String f2 = gVar.f("proxy.port", "80");
        if (b3 != null) {
            l1Var.X(new x4.e(b3, f2, b4, b5));
        }
        Iterator<String> it = gVar.g("in-app-includes").iterator();
        while (it.hasNext()) {
            l1Var.e(it.next());
        }
        Iterator<String> it2 = gVar.g("in-app-excludes").iterator();
        while (it2.hasNext()) {
            l1Var.d(it2.next());
        }
        List<String> g2 = gVar.b("trace-propagation-targets") != null ? gVar.g("trace-propagation-targets") : null;
        if (g2 == null && gVar.b("tracing-origins") != null) {
            g2 = gVar.g("tracing-origins");
        }
        if (g2 != null) {
            Iterator<String> it3 = g2.iterator();
            while (it3.hasNext()) {
                l1Var.f(it3.next());
            }
        }
        Iterator<String> it4 = gVar.g("context-tags").iterator();
        while (it4.hasNext()) {
            l1Var.b(it4.next());
        }
        l1Var.W(gVar.b("proguard-uuid"));
        Iterator<String> it5 = gVar.g("bundle-ids").iterator();
        while (it5.hasNext()) {
            l1Var.a(it5.next());
        }
        l1Var.R(gVar.d("idle-timeout"));
        l1Var.P(gVar.c("enabled"));
        l1Var.M(gVar.c("enable-pretty-serialization-output"));
        l1Var.a0(gVar.c("send-modules"));
        l1Var.S(gVar.g("ignored-checkins"));
        for (String str : gVar.g("ignored-exceptions-for-type")) {
            try {
                Class<?> cls = Class.forName(str);
                if (Throwable.class.isAssignableFrom(cls)) {
                    l1Var.c(cls);
                } else {
                    w1Var.c(s4.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", str, str);
                }
            } catch (ClassNotFoundException unused) {
                w1Var.c(s4.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", str, str);
            }
        }
        return l1Var;
    }

    public Boolean A() {
        return this.w;
    }

    public String B() {
        return this.f22481e;
    }

    public Map<String, String> C() {
        return this.m;
    }

    public List<String> D() {
        return this.q;
    }

    public Double E() {
        return this.f22486j;
    }

    public Boolean F() {
        return this.z;
    }

    public Boolean G() {
        return this.y;
    }

    public Boolean H() {
        return this.B;
    }

    public void I(Boolean bool) {
        this.f22483g = bool;
    }

    public void J(String str) {
        this.f22480d = str;
    }

    public void K(String str) {
        this.a = str;
    }

    public void L(Boolean bool) {
        this.f22484h = bool;
    }

    public void M(Boolean bool) {
        this.z = bool;
    }

    public void N(Boolean bool) {
        this.f22485i = bool;
    }

    public void O(Boolean bool) {
        this.f22482f = bool;
    }

    public void P(Boolean bool) {
        this.y = bool;
    }

    public void Q(String str) {
        this.f22478b = str;
    }

    public void R(Long l) {
        this.t = l;
    }

    @ApiStatus.Experimental
    public void S(List<String> list) {
        this.A = list;
    }

    public void T(x4.f fVar) {
        this.l = fVar;
    }

    public void U(Boolean bool) {
        this.v = bool;
    }

    public void V(Double d2) {
        this.f22487k = d2;
    }

    public void W(String str) {
        this.s = str;
    }

    public void X(x4.e eVar) {
        this.n = eVar;
    }

    public void Y(String str) {
        this.f22479c = str;
    }

    public void Z(Boolean bool) {
        this.w = bool;
    }

    public void a(String str) {
        this.x.add(str);
    }

    public void a0(Boolean bool) {
        this.B = bool;
    }

    public void b(String str) {
        this.r.add(str);
    }

    public void b0(String str) {
        this.f22481e = str;
    }

    public void c(Class<? extends Throwable> cls) {
        this.u.add(cls);
    }

    public void c0(String str, String str2) {
        this.m.put(str, str2);
    }

    public void d(String str) {
        this.o.add(str);
    }

    public void d0(Double d2) {
        this.f22486j = d2;
    }

    public void e(String str) {
        this.p.add(str);
    }

    public void f(String str) {
        if (this.q == null) {
            this.q = new CopyOnWriteArrayList();
        }
        if (str.isEmpty()) {
            return;
        }
        this.q.add(str);
    }

    public Set<String> h() {
        return this.x;
    }

    public List<String> i() {
        return this.r;
    }

    public Boolean j() {
        return this.f22483g;
    }

    public String k() {
        return this.f22480d;
    }

    public String l() {
        return this.a;
    }

    public Boolean m() {
        return this.f22484h;
    }

    public Boolean n() {
        return this.f22485i;
    }

    public Boolean o() {
        return this.f22482f;
    }

    public String p() {
        return this.f22478b;
    }

    public Long q() {
        return this.t;
    }

    @ApiStatus.Experimental
    public List<String> r() {
        return this.A;
    }

    public Set<Class<? extends Throwable>> s() {
        return this.u;
    }

    public List<String> t() {
        return this.o;
    }

    public List<String> u() {
        return this.p;
    }

    public Boolean v() {
        return this.v;
    }

    public Double w() {
        return this.f22487k;
    }

    public String x() {
        return this.s;
    }

    public x4.e y() {
        return this.n;
    }

    public String z() {
        return this.f22479c;
    }
}
