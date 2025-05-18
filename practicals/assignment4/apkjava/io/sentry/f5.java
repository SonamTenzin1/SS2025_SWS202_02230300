package io.sentry;

import io.sentry.h5;
import io.sentry.j5;
import io.sentry.protocol.q;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: SpanContext.java */
/* loaded from: classes2.dex */
public class f5 implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final io.sentry.protocol.q f22410f;

    /* renamed from: g, reason: collision with root package name */
    private final h5 f22411g;

    /* renamed from: h, reason: collision with root package name */
    private final h5 f22412h;

    /* renamed from: i, reason: collision with root package name */
    private transient q5 f22413i;

    /* renamed from: j, reason: collision with root package name */
    protected String f22414j;

    /* renamed from: k, reason: collision with root package name */
    protected String f22415k;
    protected j5 l;
    protected Map<String, String> m;
    protected String n;
    private Map<String, Object> o;

    /* compiled from: SpanContext.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<f5> {
        /* JADX WARN: Removed duplicated region for block: B:31:0x008a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0096 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00a9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00b7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00be A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00c5 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00d3 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x007f A[SYNTHETIC] */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public f5 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            String str = null;
            io.sentry.protocol.q qVar = null;
            h5 h5Var = null;
            h5 h5Var2 = null;
            ConcurrentHashMap concurrentHashMap = null;
            String str2 = null;
            j5 j5Var = null;
            String str3 = null;
            Map<String, String> map = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
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
                                break;
                            case 1:
                                h5Var2 = (h5) n2Var.M0(w1Var, new h5.a());
                                break;
                            case 2:
                                str2 = n2Var.J();
                                break;
                            case 3:
                                str3 = n2Var.J();
                                break;
                            case 4:
                                j5Var = (j5) n2Var.M0(w1Var, new j5.a());
                                break;
                            case 5:
                                str = n2Var.J();
                                break;
                            case 6:
                                map = io.sentry.util.i.b((Map) n2Var.K0());
                                break;
                            case 7:
                                qVar = new q.a().a(n2Var, w1Var);
                                break;
                            default:
                                if (concurrentHashMap == null) {
                                    concurrentHashMap = new ConcurrentHashMap();
                                }
                                n2Var.R0(w1Var, concurrentHashMap, B);
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
                    case -1008619738:
                        if (B.equals("origin")) {
                            c2 = 3;
                        }
                        switch (c2) {
                        }
                        break;
                    case -892481550:
                        if (B.equals("status")) {
                            c2 = 4;
                        }
                        switch (c2) {
                        }
                        break;
                    case 3553:
                        if (B.equals("op")) {
                            c2 = 5;
                        }
                        switch (c2) {
                        }
                        break;
                    case 3552281:
                        if (B.equals("tags")) {
                            c2 = 6;
                        }
                        switch (c2) {
                        }
                        break;
                    case 1270300245:
                        if (B.equals("trace_id")) {
                            c2 = 7;
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
            if (qVar == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                w1Var.b(s4.ERROR, "Missing required field \"trace_id\"", illegalStateException);
                throw illegalStateException;
            }
            if (h5Var != null) {
                f5 f5Var = new f5(qVar, h5Var, str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str, h5Var2, null);
                f5Var.l(str2);
                f5Var.o(j5Var);
                f5Var.m(str3);
                if (map != null) {
                    f5Var.m = map;
                }
                f5Var.p(concurrentHashMap);
                n2Var.j();
                return f5Var;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
            w1Var.b(s4.ERROR, "Missing required field \"span_id\"", illegalStateException2);
            throw illegalStateException2;
        }
    }

    public f5(String str) {
        this(new io.sentry.protocol.q(), new h5(), str, null, null);
    }

    public String a() {
        return this.f22415k;
    }

    public String b() {
        return this.f22414j;
    }

    public String c() {
        return this.n;
    }

    public h5 d() {
        return this.f22412h;
    }

    public Boolean e() {
        q5 q5Var = this.f22413i;
        if (q5Var == null) {
            return null;
        }
        return q5Var.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f5)) {
            return false;
        }
        f5 f5Var = (f5) obj;
        return this.f22410f.equals(f5Var.f22410f) && this.f22411g.equals(f5Var.f22411g) && io.sentry.util.q.a(this.f22412h, f5Var.f22412h) && this.f22414j.equals(f5Var.f22414j) && io.sentry.util.q.a(this.f22415k, f5Var.f22415k) && this.l == f5Var.l;
    }

    public Boolean f() {
        q5 q5Var = this.f22413i;
        if (q5Var == null) {
            return null;
        }
        return q5Var.c();
    }

    public q5 g() {
        return this.f22413i;
    }

    public h5 h() {
        return this.f22411g;
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22410f, this.f22411g, this.f22412h, this.f22414j, this.f22415k, this.l);
    }

    public j5 i() {
        return this.l;
    }

    public Map<String, String> j() {
        return this.m;
    }

    public io.sentry.protocol.q k() {
        return this.f22410f;
    }

    public void l(String str) {
        this.f22415k = str;
    }

    public void m(String str) {
        this.n = str;
    }

    @ApiStatus.Internal
    public void n(q5 q5Var) {
        this.f22413i = q5Var;
    }

    public void o(j5 j5Var) {
        this.l = j5Var;
    }

    public void p(Map<String, Object> map) {
        this.o = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("trace_id");
        this.f22410f.serialize(h3Var, w1Var);
        h3Var.k("span_id");
        this.f22411g.serialize(h3Var, w1Var);
        if (this.f22412h != null) {
            h3Var.k("parent_span_id");
            this.f22412h.serialize(h3Var, w1Var);
        }
        h3Var.k("op").b(this.f22414j);
        if (this.f22415k != null) {
            h3Var.k("description").b(this.f22415k);
        }
        if (this.l != null) {
            h3Var.k("status").g(w1Var, this.l);
        }
        if (this.n != null) {
            h3Var.k("origin").g(w1Var, this.n);
        }
        if (!this.m.isEmpty()) {
            h3Var.k("tags").g(w1Var, this.m);
        }
        Map<String, Object> map = this.o;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.o.get(str));
            }
        }
        h3Var.d();
    }

    public f5(io.sentry.protocol.q qVar, h5 h5Var, String str, h5 h5Var2, q5 q5Var) {
        this(qVar, h5Var, h5Var2, str, null, q5Var, null, "manual");
    }

    @ApiStatus.Internal
    public f5(io.sentry.protocol.q qVar, h5 h5Var, h5 h5Var2, String str, String str2, q5 q5Var, j5 j5Var, String str3) {
        this.m = new ConcurrentHashMap();
        this.n = "manual";
        this.f22410f = (io.sentry.protocol.q) io.sentry.util.q.c(qVar, "traceId is required");
        this.f22411g = (h5) io.sentry.util.q.c(h5Var, "spanId is required");
        this.f22414j = (String) io.sentry.util.q.c(str, "operation is required");
        this.f22412h = h5Var2;
        this.f22413i = q5Var;
        this.f22415k = str2;
        this.l = j5Var;
        this.n = str3;
    }

    public f5(f5 f5Var) {
        this.m = new ConcurrentHashMap();
        this.n = "manual";
        this.f22410f = f5Var.f22410f;
        this.f22411g = f5Var.f22411g;
        this.f22412h = f5Var.f22412h;
        this.f22413i = f5Var.f22413i;
        this.f22414j = f5Var.f22414j;
        this.f22415k = f5Var.f22415k;
        this.l = f5Var.l;
        Map<String, String> b2 = io.sentry.util.i.b(f5Var.m);
        if (b2 != null) {
            this.m = b2;
        }
    }
}
