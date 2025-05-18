package io.sentry;

import io.sentry.c4;
import io.sentry.protocol.j;
import io.sentry.protocol.p;
import io.sentry.protocol.w;
import io.sentry.s4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SentryEvent.java */
/* loaded from: classes2.dex */
public final class l4 extends c4 implements r2 {
    private String A;
    private List<String> B;
    private Map<String, Object> C;
    private Map<String, String> D;
    private Date u;
    private io.sentry.protocol.j v;
    private String w;
    private c5<io.sentry.protocol.w> x;
    private c5<io.sentry.protocol.p> y;
    private s4 z;

    /* compiled from: SentryEvent.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<l4> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0022. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l4 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            l4 l4Var = new l4();
            c4.a aVar = new c4.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1375934236:
                        if (B.equals("fingerprint")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1337936983:
                        if (B.equals("threads")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1097337456:
                        if (B.equals("logger")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 55126294:
                        if (B.equals("timestamp")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 102865796:
                        if (B.equals("level")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 954925063:
                        if (B.equals("message")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1227433863:
                        if (B.equals("modules")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1481625679:
                        if (B.equals("exception")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 2141246174:
                        if (B.equals("transaction")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        List list = (List) n2Var.K0();
                        if (list == null) {
                            break;
                        } else {
                            l4Var.B = list;
                            break;
                        }
                    case 1:
                        n2Var.b();
                        n2Var.B();
                        l4Var.x = new c5(n2Var.F0(w1Var, new w.a()));
                        n2Var.j();
                        break;
                    case 2:
                        l4Var.w = n2Var.N0();
                        break;
                    case 3:
                        Date q0 = n2Var.q0(w1Var);
                        if (q0 == null) {
                            break;
                        } else {
                            l4Var.u = q0;
                            break;
                        }
                    case 4:
                        l4Var.z = (s4) n2Var.M0(w1Var, new s4.a());
                        break;
                    case 5:
                        l4Var.v = (io.sentry.protocol.j) n2Var.M0(w1Var, new j.a());
                        break;
                    case 6:
                        l4Var.D = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case 7:
                        n2Var.b();
                        n2Var.B();
                        l4Var.y = new c5(n2Var.F0(w1Var, new p.a()));
                        n2Var.j();
                        break;
                    case '\b':
                        l4Var.A = n2Var.N0();
                        break;
                    default:
                        if (!aVar.a(l4Var, B, n2Var, w1Var)) {
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap();
                            }
                            n2Var.R0(w1Var, concurrentHashMap, B);
                            break;
                        } else {
                            break;
                        }
                }
            }
            l4Var.F0(concurrentHashMap);
            n2Var.j();
            return l4Var;
        }
    }

    l4(io.sentry.protocol.q qVar, Date date) {
        super(qVar);
        this.u = date;
    }

    public void A0(io.sentry.protocol.j jVar) {
        this.v = jVar;
    }

    public void B0(Map<String, String> map) {
        this.D = io.sentry.util.i.c(map);
    }

    public void C0(List<io.sentry.protocol.w> list) {
        this.x = new c5<>(list);
    }

    public void D0(Date date) {
        this.u = date;
    }

    public void E0(String str) {
        this.A = str;
    }

    public void F0(Map<String, Object> map) {
        this.C = map;
    }

    public List<io.sentry.protocol.p> o0() {
        c5<io.sentry.protocol.p> c5Var = this.y;
        if (c5Var == null) {
            return null;
        }
        return c5Var.a();
    }

    public List<String> p0() {
        return this.B;
    }

    public s4 q0() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> r0() {
        return this.D;
    }

    public List<io.sentry.protocol.w> s0() {
        c5<io.sentry.protocol.w> c5Var = this.x;
        if (c5Var != null) {
            return c5Var.a();
        }
        return null;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("timestamp").g(w1Var, this.u);
        if (this.v != null) {
            h3Var.k("message").g(w1Var, this.v);
        }
        if (this.w != null) {
            h3Var.k("logger").b(this.w);
        }
        c5<io.sentry.protocol.w> c5Var = this.x;
        if (c5Var != null && !c5Var.a().isEmpty()) {
            h3Var.k("threads");
            h3Var.f();
            h3Var.k("values").g(w1Var, this.x.a());
            h3Var.d();
        }
        c5<io.sentry.protocol.p> c5Var2 = this.y;
        if (c5Var2 != null && !c5Var2.a().isEmpty()) {
            h3Var.k("exception");
            h3Var.f();
            h3Var.k("values").g(w1Var, this.y.a());
            h3Var.d();
        }
        if (this.z != null) {
            h3Var.k("level").g(w1Var, this.z);
        }
        if (this.A != null) {
            h3Var.k("transaction").b(this.A);
        }
        if (this.B != null) {
            h3Var.k("fingerprint").g(w1Var, this.B);
        }
        if (this.D != null) {
            h3Var.k("modules").g(w1Var, this.D);
        }
        new c4.b().a(this, h3Var, w1Var);
        Map<String, Object> map = this.C;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.C.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public String t0() {
        return this.A;
    }

    public io.sentry.protocol.p u0() {
        c5<io.sentry.protocol.p> c5Var = this.y;
        if (c5Var == null) {
            return null;
        }
        for (io.sentry.protocol.p pVar : c5Var.a()) {
            if (pVar.g() != null && pVar.g().h() != null && !pVar.g().h().booleanValue()) {
                return pVar;
            }
        }
        return null;
    }

    public boolean v0() {
        return u0() != null;
    }

    public boolean w0() {
        c5<io.sentry.protocol.p> c5Var = this.y;
        return (c5Var == null || c5Var.a().isEmpty()) ? false : true;
    }

    public void x0(List<io.sentry.protocol.p> list) {
        this.y = new c5<>(list);
    }

    public void y0(List<String> list) {
        this.B = list != null ? new ArrayList(list) : null;
    }

    public void z0(s4 s4Var) {
        this.z = s4Var;
    }

    public l4(Throwable th) {
        this();
        this.o = th;
    }

    public l4() {
        this(new io.sentry.protocol.q(), a1.c());
    }
}
