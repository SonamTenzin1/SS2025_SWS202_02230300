package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: App.java */
/* loaded from: classes2.dex */
public final class a implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22554f;

    /* renamed from: g, reason: collision with root package name */
    private Date f22555g;

    /* renamed from: h, reason: collision with root package name */
    private String f22556h;

    /* renamed from: i, reason: collision with root package name */
    private String f22557i;

    /* renamed from: j, reason: collision with root package name */
    private String f22558j;

    /* renamed from: k, reason: collision with root package name */
    private String f22559k;
    private String l;
    private Map<String, String> m;
    private List<String> n;
    private Boolean o;
    private Map<String, Object> p;

    /* compiled from: App.java */
    /* renamed from: io.sentry.protocol.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0308a implements l2<a> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            a aVar = new a();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1898053579:
                        if (B.equals("device_app_hash")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1524619986:
                        if (B.equals("view_names")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -901870406:
                        if (B.equals("app_version")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -650544995:
                        if (B.equals("in_foreground")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -470395285:
                        if (B.equals("build_type")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 746297735:
                        if (B.equals("app_identifier")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 791585128:
                        if (B.equals("app_start_time")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1133704324:
                        if (B.equals("permissions")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1167648233:
                        if (B.equals("app_name")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1826866896:
                        if (B.equals("app_build")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        aVar.f22556h = n2Var.N0();
                        break;
                    case 1:
                        List<String> list = (List) n2Var.K0();
                        if (list == null) {
                            break;
                        } else {
                            aVar.s(list);
                            break;
                        }
                    case 2:
                        aVar.f22559k = n2Var.N0();
                        break;
                    case 3:
                        aVar.o = n2Var.p0();
                        break;
                    case 4:
                        aVar.f22557i = n2Var.N0();
                        break;
                    case 5:
                        aVar.f22554f = n2Var.N0();
                        break;
                    case 6:
                        aVar.f22555g = n2Var.q0(w1Var);
                        break;
                    case 7:
                        aVar.m = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case '\b':
                        aVar.f22558j = n2Var.N0();
                        break;
                    case '\t':
                        aVar.l = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            aVar.r(concurrentHashMap);
            n2Var.j();
            return aVar;
        }
    }

    public a() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return io.sentry.util.q.a(this.f22554f, aVar.f22554f) && io.sentry.util.q.a(this.f22555g, aVar.f22555g) && io.sentry.util.q.a(this.f22556h, aVar.f22556h) && io.sentry.util.q.a(this.f22557i, aVar.f22557i) && io.sentry.util.q.a(this.f22558j, aVar.f22558j) && io.sentry.util.q.a(this.f22559k, aVar.f22559k) && io.sentry.util.q.a(this.l, aVar.l) && io.sentry.util.q.a(this.m, aVar.m) && io.sentry.util.q.a(this.o, aVar.o) && io.sentry.util.q.a(this.n, aVar.n);
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22554f, this.f22555g, this.f22556h, this.f22557i, this.f22558j, this.f22559k, this.l, this.m, this.o, this.n);
    }

    public Boolean j() {
        return this.o;
    }

    public void k(String str) {
        this.l = str;
    }

    public void l(String str) {
        this.f22554f = str;
    }

    public void m(String str) {
        this.f22558j = str;
    }

    public void n(Date date) {
        this.f22555g = date;
    }

    public void o(String str) {
        this.f22559k = str;
    }

    public void p(Boolean bool) {
        this.o = bool;
    }

    public void q(Map<String, String> map) {
        this.m = map;
    }

    public void r(Map<String, Object> map) {
        this.p = map;
    }

    public void s(List<String> list) {
        this.n = list;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22554f != null) {
            h3Var.k("app_identifier").b(this.f22554f);
        }
        if (this.f22555g != null) {
            h3Var.k("app_start_time").g(w1Var, this.f22555g);
        }
        if (this.f22556h != null) {
            h3Var.k("device_app_hash").b(this.f22556h);
        }
        if (this.f22557i != null) {
            h3Var.k("build_type").b(this.f22557i);
        }
        if (this.f22558j != null) {
            h3Var.k("app_name").b(this.f22558j);
        }
        if (this.f22559k != null) {
            h3Var.k("app_version").b(this.f22559k);
        }
        if (this.l != null) {
            h3Var.k("app_build").b(this.l);
        }
        Map<String, String> map = this.m;
        if (map != null && !map.isEmpty()) {
            h3Var.k("permissions").g(w1Var, this.m);
        }
        if (this.o != null) {
            h3Var.k("in_foreground").h(this.o);
        }
        if (this.n != null) {
            h3Var.k("view_names").g(w1Var, this.n);
        }
        Map<String, Object> map2 = this.p;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                h3Var.k(str).g(w1Var, this.p.get(str));
            }
        }
        h3Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(a aVar) {
        this.l = aVar.l;
        this.f22554f = aVar.f22554f;
        this.f22558j = aVar.f22558j;
        this.f22555g = aVar.f22555g;
        this.f22559k = aVar.f22559k;
        this.f22557i = aVar.f22557i;
        this.f22556h = aVar.f22556h;
        this.m = io.sentry.util.i.b(aVar.m);
        this.o = aVar.o;
        this.n = io.sentry.util.i.a(aVar.n);
        this.p = io.sentry.util.i.b(aVar.p);
    }
}
