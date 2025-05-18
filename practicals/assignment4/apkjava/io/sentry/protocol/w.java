package io.sentry.protocol;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.protocol.v;
import io.sentry.r2;
import io.sentry.t4;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SentryThread.java */
/* loaded from: classes2.dex */
public final class w implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private Long f22670f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f22671g;

    /* renamed from: h, reason: collision with root package name */
    private String f22672h;

    /* renamed from: i, reason: collision with root package name */
    private String f22673i;

    /* renamed from: j, reason: collision with root package name */
    private Boolean f22674j;

    /* renamed from: k, reason: collision with root package name */
    private Boolean f22675k;
    private Boolean l;
    private Boolean m;
    private v n;
    private Map<String, t4> o;
    private Map<String, Object> p;

    /* compiled from: SentryThread.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<w> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a(n2 n2Var, w1 w1Var) throws Exception {
            w wVar = new w();
            n2Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1339353468:
                        if (B.equals("daemon")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1165461084:
                        if (B.equals("priority")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -502917346:
                        if (B.equals("held_locks")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3355:
                        if (B.equals(DeepLinkIntentReceiver.DeepLinksKeys.ID)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3343801:
                        if (B.equals("main")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 3373707:
                        if (B.equals("name")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 109757585:
                        if (B.equals("state")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1025385094:
                        if (B.equals("crashed")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1126940025:
                        if (B.equals("current")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 2055832509:
                        if (B.equals("stacktrace")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        wVar.l = n2Var.p0();
                        break;
                    case 1:
                        wVar.f22671g = n2Var.E0();
                        break;
                    case 2:
                        Map J0 = n2Var.J0(w1Var, new t4.a());
                        if (J0 == null) {
                            break;
                        } else {
                            wVar.o = new HashMap(J0);
                            break;
                        }
                    case 3:
                        wVar.f22670f = n2Var.G0();
                        break;
                    case 4:
                        wVar.m = n2Var.p0();
                        break;
                    case 5:
                        wVar.f22672h = n2Var.N0();
                        break;
                    case 6:
                        wVar.f22673i = n2Var.N0();
                        break;
                    case 7:
                        wVar.f22674j = n2Var.p0();
                        break;
                    case '\b':
                        wVar.f22675k = n2Var.p0();
                        break;
                    case '\t':
                        wVar.n = (v) n2Var.M0(w1Var, new v.a());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            wVar.A(concurrentHashMap);
            n2Var.j();
            return wVar;
        }
    }

    public void A(Map<String, Object> map) {
        this.p = map;
    }

    public Map<String, t4> k() {
        return this.o;
    }

    public Long l() {
        return this.f22670f;
    }

    public String m() {
        return this.f22672h;
    }

    public v n() {
        return this.n;
    }

    public Boolean o() {
        return this.f22675k;
    }

    public Boolean p() {
        return this.m;
    }

    public void q(Boolean bool) {
        this.f22674j = bool;
    }

    public void r(Boolean bool) {
        this.f22675k = bool;
    }

    public void s(Boolean bool) {
        this.l = bool;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22670f != null) {
            h3Var.k(DeepLinkIntentReceiver.DeepLinksKeys.ID).e(this.f22670f);
        }
        if (this.f22671g != null) {
            h3Var.k("priority").e(this.f22671g);
        }
        if (this.f22672h != null) {
            h3Var.k("name").b(this.f22672h);
        }
        if (this.f22673i != null) {
            h3Var.k("state").b(this.f22673i);
        }
        if (this.f22674j != null) {
            h3Var.k("crashed").h(this.f22674j);
        }
        if (this.f22675k != null) {
            h3Var.k("current").h(this.f22675k);
        }
        if (this.l != null) {
            h3Var.k("daemon").h(this.l);
        }
        if (this.m != null) {
            h3Var.k("main").h(this.m);
        }
        if (this.n != null) {
            h3Var.k("stacktrace").g(w1Var, this.n);
        }
        if (this.o != null) {
            h3Var.k("held_locks").g(w1Var, this.o);
        }
        Map<String, Object> map = this.p;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.p.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public void t(Map<String, t4> map) {
        this.o = map;
    }

    public void u(Long l) {
        this.f22670f = l;
    }

    public void v(Boolean bool) {
        this.m = bool;
    }

    public void w(String str) {
        this.f22672h = str;
    }

    public void x(Integer num) {
        this.f22671g = num;
    }

    public void y(v vVar) {
        this.n = vVar;
    }

    public void z(String str) {
        this.f22673i = str;
    }
}
