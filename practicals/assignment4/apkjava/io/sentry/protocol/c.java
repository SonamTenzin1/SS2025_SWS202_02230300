package io.sentry.protocol;

import io.sentry.f5;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.protocol.a;
import io.sentry.protocol.b;
import io.sentry.protocol.e;
import io.sentry.protocol.g;
import io.sentry.protocol.k;
import io.sentry.protocol.m;
import io.sentry.protocol.s;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Contexts.java */
/* loaded from: classes2.dex */
public final class c extends ConcurrentHashMap<String, Object> implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final Object f22572f = new Object();

    /* compiled from: Contexts.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<c> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001c. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(n2 n2Var, w1 w1Var) throws Exception {
            c cVar = new c();
            n2Var.b();
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1335157162:
                        if (B.equals("device")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -340323263:
                        if (B.equals("response")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3556:
                        if (B.equals("os")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 96801:
                        if (B.equals("app")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 102572:
                        if (B.equals("gpu")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 110620997:
                        if (B.equals("trace")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 150940456:
                        if (B.equals("browser")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1550962648:
                        if (B.equals("runtime")) {
                            c2 = 7;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        cVar.i(new e.a().a(n2Var, w1Var));
                        break;
                    case 1:
                        cVar.l(new m.a().a(n2Var, w1Var));
                        break;
                    case 2:
                        cVar.k(new k.a().a(n2Var, w1Var));
                        break;
                    case 3:
                        cVar.f(new a.C0308a().a(n2Var, w1Var));
                        break;
                    case 4:
                        cVar.j(new g.a().a(n2Var, w1Var));
                        break;
                    case 5:
                        cVar.n(new f5.a().a(n2Var, w1Var));
                        break;
                    case 6:
                        cVar.h(new b.a().a(n2Var, w1Var));
                        break;
                    case 7:
                        cVar.m(new s.a().a(n2Var, w1Var));
                        break;
                    default:
                        Object K0 = n2Var.K0();
                        if (K0 == null) {
                            break;
                        } else {
                            cVar.put(B, K0);
                            break;
                        }
                }
            }
            n2Var.j();
            return cVar;
        }
    }

    public c() {
    }

    private <T> T o(String str, Class<T> cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public io.sentry.protocol.a a() {
        return (io.sentry.protocol.a) o("app", io.sentry.protocol.a.class);
    }

    public e b() {
        return (e) o("device", e.class);
    }

    public k c() {
        return (k) o("os", k.class);
    }

    public s d() {
        return (s) o("runtime", s.class);
    }

    public f5 e() {
        return (f5) o("trace", f5.class);
    }

    public void f(io.sentry.protocol.a aVar) {
        put("app", aVar);
    }

    public void h(b bVar) {
        put("browser", bVar);
    }

    public void i(e eVar) {
        put("device", eVar);
    }

    public void j(g gVar) {
        put("gpu", gVar);
    }

    public void k(k kVar) {
        put("os", kVar);
    }

    public void l(m mVar) {
        synchronized (this.f22572f) {
            put("response", mVar);
        }
    }

    public void m(s sVar) {
        put("runtime", sVar);
    }

    public void n(f5 f5Var) {
        io.sentry.util.q.c(f5Var, "traceContext is required");
        put("trace", f5Var);
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        ArrayList<String> list = Collections.list(keys());
        Collections.sort(list);
        for (String str : list) {
            Object obj = get(str);
            if (obj != null) {
                h3Var.k(str).g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public c(c cVar) {
        for (Map.Entry<String, Object> entry : cVar.entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if ("app".equals(entry.getKey()) && (value instanceof io.sentry.protocol.a)) {
                    f(new io.sentry.protocol.a((io.sentry.protocol.a) value));
                } else if ("browser".equals(entry.getKey()) && (value instanceof b)) {
                    h(new b((b) value));
                } else if ("device".equals(entry.getKey()) && (value instanceof e)) {
                    i(new e((e) value));
                } else if ("os".equals(entry.getKey()) && (value instanceof k)) {
                    k(new k((k) value));
                } else if ("runtime".equals(entry.getKey()) && (value instanceof s)) {
                    m(new s((s) value));
                } else if ("gpu".equals(entry.getKey()) && (value instanceof g)) {
                    j(new g((g) value));
                } else if ("trace".equals(entry.getKey()) && (value instanceof f5)) {
                    n(new f5((f5) value));
                } else if ("response".equals(entry.getKey()) && (value instanceof m)) {
                    l(new m((m) value));
                } else {
                    put(entry.getKey(), value);
                }
            }
        }
    }
}
