package io.sentry;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SentryLockReason.java */
/* loaded from: classes2.dex */
public final class t4 implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private int f22714f;

    /* renamed from: g, reason: collision with root package name */
    private String f22715g;

    /* renamed from: h, reason: collision with root package name */
    private String f22716h;

    /* renamed from: i, reason: collision with root package name */
    private String f22717i;

    /* renamed from: j, reason: collision with root package name */
    private Long f22718j;

    /* renamed from: k, reason: collision with root package name */
    private Map<String, Object> f22719k;

    /* compiled from: SentryLockReason.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<t4> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public t4 a(n2 n2Var, w1 w1Var) throws Exception {
            t4 t4Var = new t4();
            n2Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1877165340:
                        if (B.equals("package_name")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1562235024:
                        if (B.equals("thread_id")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1147692044:
                        if (B.equals("address")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -290474766:
                        if (B.equals("class_name")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3575610:
                        if (B.equals("type")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        t4Var.f22716h = n2Var.N0();
                        break;
                    case 1:
                        t4Var.f22718j = n2Var.G0();
                        break;
                    case 2:
                        t4Var.f22715g = n2Var.N0();
                        break;
                    case 3:
                        t4Var.f22717i = n2Var.N0();
                        break;
                    case 4:
                        t4Var.f22714f = n2Var.z();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            t4Var.m(concurrentHashMap);
            n2Var.j();
            return t4Var;
        }
    }

    public t4() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t4.class != obj.getClass()) {
            return false;
        }
        return io.sentry.util.q.a(this.f22715g, ((t4) obj).f22715g);
    }

    public String f() {
        return this.f22715g;
    }

    public int g() {
        return this.f22714f;
    }

    public void h(String str) {
        this.f22715g = str;
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22715g);
    }

    public void i(String str) {
        this.f22717i = str;
    }

    public void j(String str) {
        this.f22716h = str;
    }

    public void k(Long l) {
        this.f22718j = l;
    }

    public void l(int i2) {
        this.f22714f = i2;
    }

    public void m(Map<String, Object> map) {
        this.f22719k = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("type").a(this.f22714f);
        if (this.f22715g != null) {
            h3Var.k("address").b(this.f22715g);
        }
        if (this.f22716h != null) {
            h3Var.k("package_name").b(this.f22716h);
        }
        if (this.f22717i != null) {
            h3Var.k("class_name").b(this.f22717i);
        }
        if (this.f22718j != null) {
            h3Var.k("thread_id").e(this.f22718j);
        }
        Map<String, Object> map = this.f22719k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22719k.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public t4(t4 t4Var) {
        this.f22714f = t4Var.f22714f;
        this.f22715g = t4Var.f22715g;
        this.f22716h = t4Var.f22716h;
        this.f22717i = t4Var.f22717i;
        this.f22718j = t4Var.f22718j;
        this.f22719k = io.sentry.util.i.b(t4Var.f22719k);
    }
}
