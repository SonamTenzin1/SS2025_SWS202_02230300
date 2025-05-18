package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.b5;
import io.sentry.c4;
import io.sentry.e5;
import io.sentry.f5;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.protocol.h;
import io.sentry.protocol.t;
import io.sentry.protocol.y;
import io.sentry.q5;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: SentryTransaction.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class x extends c4 implements r2 {
    private y A;
    private Map<String, Object> B;
    private String u;
    private Double v;
    private Double w;
    private final List<t> x;
    private final String y;
    private final Map<String, h> z;

    /* compiled from: SentryTransaction.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<x> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0041. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            x xVar = new x(HttpUrl.FRAGMENT_ENCODE_SET, Double.valueOf(0.0d), null, new ArrayList(), new HashMap(), new y(z.CUSTOM.apiName()));
            c4.a aVar = new c4.a();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1526966919:
                        if (B.equals("start_timestamp")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -362243017:
                        if (B.equals("measurements")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3575610:
                        if (B.equals("type")) {
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
                    case 109638249:
                        if (B.equals("spans")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 508716399:
                        if (B.equals("transaction_info")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 2141246174:
                        if (B.equals("transaction")) {
                            c2 = 6;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        try {
                            Double t0 = n2Var.t0();
                            if (t0 == null) {
                                break;
                            } else {
                                xVar.v = t0;
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            Date q0 = n2Var.q0(w1Var);
                            if (q0 == null) {
                                break;
                            } else {
                                xVar.v = Double.valueOf(a1.b(q0));
                                break;
                            }
                        }
                    case 1:
                        Map J0 = n2Var.J0(w1Var, new h.a());
                        if (J0 == null) {
                            break;
                        } else {
                            xVar.z.putAll(J0);
                            break;
                        }
                    case 2:
                        n2Var.J();
                        break;
                    case 3:
                        try {
                            Double t02 = n2Var.t0();
                            if (t02 == null) {
                                break;
                            } else {
                                xVar.w = t02;
                                break;
                            }
                        } catch (NumberFormatException unused2) {
                            Date q02 = n2Var.q0(w1Var);
                            if (q02 == null) {
                                break;
                            } else {
                                xVar.w = Double.valueOf(a1.b(q02));
                                break;
                            }
                        }
                    case 4:
                        List F0 = n2Var.F0(w1Var, new t.a());
                        if (F0 == null) {
                            break;
                        } else {
                            xVar.x.addAll(F0);
                            break;
                        }
                    case 5:
                        xVar.A = new y.a().a(n2Var, w1Var);
                        break;
                    case 6:
                        xVar.u = n2Var.N0();
                        break;
                    default:
                        if (!aVar.a(xVar, B, n2Var, w1Var)) {
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
            xVar.r0(concurrentHashMap);
            n2Var.j();
            return xVar;
        }
    }

    public x(b5 b5Var) {
        super(b5Var.k());
        this.x = new ArrayList();
        this.y = "transaction";
        this.z = new HashMap();
        io.sentry.util.q.c(b5Var, "sentryTracer is required");
        this.v = Double.valueOf(a1.l(b5Var.q().x()));
        this.w = Double.valueOf(a1.l(b5Var.q().v(b5Var.n())));
        this.u = b5Var.getName();
        for (e5 e5Var : b5Var.x()) {
            if (Boolean.TRUE.equals(e5Var.B())) {
                this.x.add(new t(e5Var));
            }
        }
        c C = C();
        C.putAll(b5Var.y());
        f5 m = b5Var.m();
        C.n(new f5(m.k(), m.h(), m.d(), m.b(), m.a(), m.g(), m.i(), m.c()));
        for (Map.Entry<String, String> entry : m.j().entrySet()) {
            c0(entry.getKey(), entry.getValue());
        }
        Map<String, Object> z = b5Var.z();
        if (z != null) {
            for (Map.Entry<String, Object> entry2 : z.entrySet()) {
                V(entry2.getKey(), entry2.getValue());
            }
        }
        this.A = new y(b5Var.p().apiName());
    }

    private BigDecimal l0(Double d2) {
        return BigDecimal.valueOf(d2.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public Map<String, h> m0() {
        return this.z;
    }

    public q5 n0() {
        f5 e2 = C().e();
        if (e2 == null) {
            return null;
        }
        return e2.g();
    }

    public List<t> o0() {
        return this.x;
    }

    public boolean p0() {
        return this.w != null;
    }

    public boolean q0() {
        q5 n0 = n0();
        if (n0 == null) {
            return false;
        }
        return n0.c().booleanValue();
    }

    public void r0(Map<String, Object> map) {
        this.B = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.u != null) {
            h3Var.k("transaction").b(this.u);
        }
        h3Var.k("start_timestamp").g(w1Var, l0(this.v));
        if (this.w != null) {
            h3Var.k("timestamp").g(w1Var, l0(this.w));
        }
        if (!this.x.isEmpty()) {
            h3Var.k("spans").g(w1Var, this.x);
        }
        h3Var.k("type").b("transaction");
        if (!this.z.isEmpty()) {
            h3Var.k("measurements").g(w1Var, this.z);
        }
        h3Var.k("transaction_info").g(w1Var, this.A);
        new c4.b().a(this, h3Var, w1Var);
        Map<String, Object> map = this.B;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.B.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    @ApiStatus.Internal
    public x(String str, Double d2, Double d3, List<t> list, Map<String, h> map, y yVar) {
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        this.y = "transaction";
        HashMap hashMap = new HashMap();
        this.z = hashMap;
        this.u = str;
        this.v = d2;
        this.w = d3;
        arrayList.addAll(list);
        hashMap.putAll(map);
        this.A = yVar;
    }
}
