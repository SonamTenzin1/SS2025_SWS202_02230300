package io.sentry.protocol;

import io.sentry.a1;
import io.sentry.e5;
import io.sentry.h3;
import io.sentry.h5;
import io.sentry.j5;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.protocol.q;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: SentrySpan.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class t implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final Double f22654f;

    /* renamed from: g, reason: collision with root package name */
    private final Double f22655g;

    /* renamed from: h, reason: collision with root package name */
    private final q f22656h;

    /* renamed from: i, reason: collision with root package name */
    private final h5 f22657i;

    /* renamed from: j, reason: collision with root package name */
    private final h5 f22658j;

    /* renamed from: k, reason: collision with root package name */
    private final String f22659k;
    private final String l;
    private final j5 m;
    private final String n;
    private final Map<String, String> o;
    private final Map<String, Object> p;
    private Map<String, Object> q;

    /* compiled from: SentrySpan.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<t> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00b5. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x013d  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public t a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            Map map = null;
            Double d2 = null;
            Double d3 = null;
            q qVar = null;
            h5 h5Var = null;
            h5 h5Var2 = null;
            String str = null;
            String str2 = null;
            j5 j5Var = null;
            String str3 = null;
            ConcurrentHashMap concurrentHashMap = null;
            Map map2 = null;
            while (true) {
                Map map3 = map2;
                String str4 = str3;
                j5 j5Var2 = j5Var;
                String str5 = str2;
                if (n2Var.N() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (d2 == null) {
                        throw c("start_timestamp", w1Var);
                    }
                    if (qVar == null) {
                        throw c("trace_id", w1Var);
                    }
                    if (h5Var == null) {
                        throw c("span_id", w1Var);
                    }
                    if (str != null) {
                        t tVar = new t(d2, d3, qVar, h5Var, h5Var2, str, str5, j5Var2, str4, map == null ? new HashMap() : map, map3);
                        tVar.c(concurrentHashMap);
                        n2Var.j();
                        return tVar;
                    }
                    throw c("op", w1Var);
                }
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -2011840976:
                        if (B.equals("span_id")) {
                            c2 = 0;
                        }
                        switch (c2) {
                            case 0:
                                h5Var = new h5.a().a(n2Var, w1Var);
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case 1:
                                h5Var2 = (h5) n2Var.M0(w1Var, new h5.a());
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case 2:
                                str2 = n2Var.N0();
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                break;
                            case 3:
                                try {
                                    d2 = n2Var.t0();
                                } catch (NumberFormatException unused) {
                                    Date q0 = n2Var.q0(w1Var);
                                    d2 = q0 != null ? Double.valueOf(a1.b(q0)) : null;
                                }
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case 4:
                                str3 = n2Var.N0();
                                map2 = map3;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case 5:
                                j5Var = (j5) n2Var.M0(w1Var, new j5.a());
                                map2 = map3;
                                str3 = str4;
                                str2 = str5;
                                break;
                            case 6:
                                str = n2Var.N0();
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case 7:
                                map2 = (Map) n2Var.K0();
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case '\b':
                                map = (Map) n2Var.K0();
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case '\t':
                                try {
                                    d3 = n2Var.t0();
                                } catch (NumberFormatException unused2) {
                                    Date q02 = n2Var.q0(w1Var);
                                    d3 = q02 != null ? Double.valueOf(a1.b(q02)) : null;
                                }
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            case '\n':
                                qVar = new q.a().a(n2Var, w1Var);
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                            default:
                                if (concurrentHashMap == null) {
                                    concurrentHashMap = new ConcurrentHashMap();
                                }
                                n2Var.R0(w1Var, concurrentHashMap, B);
                                map2 = map3;
                                str3 = str4;
                                j5Var = j5Var2;
                                str2 = str5;
                                break;
                        }
                    case -1757797477:
                        if (B.equals("parent_span_id")) {
                            c2 = 1;
                        }
                        switch (c2) {
                        }
                        break;
                    case -1724546052:
                        if (B.equals("description")) {
                            c2 = 2;
                        }
                        switch (c2) {
                        }
                        break;
                    case -1526966919:
                        if (B.equals("start_timestamp")) {
                            c2 = 3;
                        }
                        switch (c2) {
                        }
                        break;
                    case -1008619738:
                        if (B.equals("origin")) {
                            c2 = 4;
                        }
                        switch (c2) {
                        }
                        break;
                    case -892481550:
                        if (B.equals("status")) {
                            c2 = 5;
                        }
                        switch (c2) {
                        }
                        break;
                    case 3553:
                        if (B.equals("op")) {
                            c2 = 6;
                        }
                        switch (c2) {
                        }
                        break;
                    case 3076010:
                        if (B.equals("data")) {
                            c2 = 7;
                        }
                        switch (c2) {
                        }
                        break;
                    case 3552281:
                        if (B.equals("tags")) {
                            c2 = '\b';
                        }
                        switch (c2) {
                        }
                        break;
                    case 55126294:
                        if (B.equals("timestamp")) {
                            c2 = '\t';
                        }
                        switch (c2) {
                        }
                        break;
                    case 1270300245:
                        if (B.equals("trace_id")) {
                            c2 = '\n';
                        }
                        switch (c2) {
                        }
                        break;
                    default:
                        switch (c2) {
                        }
                        break;
                }
            }
        }
    }

    public t(e5 e5Var) {
        this(e5Var, e5Var.r());
    }

    private BigDecimal a(Double d2) {
        return BigDecimal.valueOf(d2.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public String b() {
        return this.f22659k;
    }

    public void c(Map<String, Object> map) {
        this.q = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("start_timestamp").g(w1Var, a(this.f22654f));
        if (this.f22655g != null) {
            h3Var.k("timestamp").g(w1Var, a(this.f22655g));
        }
        h3Var.k("trace_id").g(w1Var, this.f22656h);
        h3Var.k("span_id").g(w1Var, this.f22657i);
        if (this.f22658j != null) {
            h3Var.k("parent_span_id").g(w1Var, this.f22658j);
        }
        h3Var.k("op").b(this.f22659k);
        if (this.l != null) {
            h3Var.k("description").b(this.l);
        }
        if (this.m != null) {
            h3Var.k("status").g(w1Var, this.m);
        }
        if (this.n != null) {
            h3Var.k("origin").g(w1Var, this.n);
        }
        if (!this.o.isEmpty()) {
            h3Var.k("tags").g(w1Var, this.o);
        }
        if (this.p != null) {
            h3Var.k("data").g(w1Var, this.p);
        }
        Map<String, Object> map = this.q;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.q.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    @ApiStatus.Internal
    public t(e5 e5Var, Map<String, Object> map) {
        io.sentry.util.q.c(e5Var, "span is required");
        this.l = e5Var.getDescription();
        this.f22659k = e5Var.t();
        this.f22657i = e5Var.x();
        this.f22658j = e5Var.v();
        this.f22656h = e5Var.z();
        this.m = e5Var.getStatus();
        this.n = e5Var.m().c();
        Map<String, String> b2 = io.sentry.util.i.b(e5Var.y());
        this.o = b2 == null ? new ConcurrentHashMap<>() : b2;
        this.f22655g = Double.valueOf(a1.l(e5Var.q().v(e5Var.n())));
        this.f22654f = Double.valueOf(a1.l(e5Var.q().x()));
        this.p = map;
    }

    @ApiStatus.Internal
    public t(Double d2, Double d3, q qVar, h5 h5Var, h5 h5Var2, String str, String str2, j5 j5Var, String str3, Map<String, String> map, Map<String, Object> map2) {
        this.f22654f = d2;
        this.f22655g = d3;
        this.f22656h = qVar;
        this.f22657i = h5Var;
        this.f22658j = h5Var2;
        this.f22659k = str;
        this.l = str2;
        this.m = j5Var;
        this.o = map;
        this.p = map2;
        this.n = str3;
    }
}
