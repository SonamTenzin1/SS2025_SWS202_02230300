package io.sentry.protocol;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.protocol.f;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: User.java */
/* loaded from: classes2.dex */
public final class a0 implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22560f;

    /* renamed from: g, reason: collision with root package name */
    private String f22561g;

    /* renamed from: h, reason: collision with root package name */
    private String f22562h;

    /* renamed from: i, reason: collision with root package name */
    private String f22563i;

    /* renamed from: j, reason: collision with root package name */
    private String f22564j;

    /* renamed from: k, reason: collision with root package name */
    private String f22565k;
    private f l;
    private Map<String, String> m;
    private Map<String, Object> n;

    /* compiled from: User.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<a0> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a0 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            a0 a0Var = new a0();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -265713450:
                        if (B.equals("username")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3355:
                        if (B.equals(DeepLinkIntentReceiver.DeepLinksKeys.ID)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 102225:
                        if (B.equals("geo")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3076010:
                        if (B.equals("data")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3373707:
                        if (B.equals("name")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 96619420:
                        if (B.equals("email")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 106069776:
                        if (B.equals("other")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1480014044:
                        if (B.equals("ip_address")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1973722931:
                        if (B.equals("segment")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        a0Var.f22562h = n2Var.N0();
                        break;
                    case 1:
                        a0Var.f22561g = n2Var.N0();
                        break;
                    case 2:
                        a0Var.l = new f.a().a(n2Var, w1Var);
                        break;
                    case 3:
                        a0Var.m = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case 4:
                        a0Var.f22565k = n2Var.N0();
                        break;
                    case 5:
                        a0Var.f22560f = n2Var.N0();
                        break;
                    case 6:
                        if (a0Var.m != null && !a0Var.m.isEmpty()) {
                            break;
                        } else {
                            a0Var.m = io.sentry.util.i.b((Map) n2Var.K0());
                            break;
                        }
                    case 7:
                        a0Var.f22564j = n2Var.N0();
                        break;
                    case '\b':
                        a0Var.f22563i = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            a0Var.p(concurrentHashMap);
            n2Var.j();
            return a0Var;
        }
    }

    public a0() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return io.sentry.util.q.a(this.f22560f, a0Var.f22560f) && io.sentry.util.q.a(this.f22561g, a0Var.f22561g) && io.sentry.util.q.a(this.f22562h, a0Var.f22562h) && io.sentry.util.q.a(this.f22563i, a0Var.f22563i) && io.sentry.util.q.a(this.f22564j, a0Var.f22564j);
    }

    public int hashCode() {
        return io.sentry.util.q.b(this.f22560f, this.f22561g, this.f22562h, this.f22563i, this.f22564j);
    }

    public Map<String, String> j() {
        return this.m;
    }

    public String k() {
        return this.f22561g;
    }

    public String l() {
        return this.f22564j;
    }

    public String m() {
        return this.f22563i;
    }

    public void n(String str) {
        this.f22561g = str;
    }

    public void o(String str) {
        this.f22564j = str;
    }

    public void p(Map<String, Object> map) {
        this.n = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22560f != null) {
            h3Var.k("email").b(this.f22560f);
        }
        if (this.f22561g != null) {
            h3Var.k(DeepLinkIntentReceiver.DeepLinksKeys.ID).b(this.f22561g);
        }
        if (this.f22562h != null) {
            h3Var.k("username").b(this.f22562h);
        }
        if (this.f22563i != null) {
            h3Var.k("segment").b(this.f22563i);
        }
        if (this.f22564j != null) {
            h3Var.k("ip_address").b(this.f22564j);
        }
        if (this.f22565k != null) {
            h3Var.k("name").b(this.f22565k);
        }
        if (this.l != null) {
            h3Var.k("geo");
            this.l.serialize(h3Var, w1Var);
        }
        if (this.m != null) {
            h3Var.k("data").g(w1Var, this.m);
        }
        Map<String, Object> map = this.n;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.n.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public a0(a0 a0Var) {
        this.f22560f = a0Var.f22560f;
        this.f22562h = a0Var.f22562h;
        this.f22561g = a0Var.f22561g;
        this.f22564j = a0Var.f22564j;
        this.f22563i = a0Var.f22563i;
        this.f22565k = a0Var.f22565k;
        this.l = a0Var.l;
        this.m = io.sentry.util.i.b(a0Var.m);
        this.n = io.sentry.util.i.b(a0Var.n);
    }
}
