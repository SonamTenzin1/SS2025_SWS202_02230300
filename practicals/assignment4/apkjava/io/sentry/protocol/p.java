package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.protocol.i;
import io.sentry.protocol.v;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SentryException.java */
/* loaded from: classes2.dex */
public final class p implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22639f;

    /* renamed from: g, reason: collision with root package name */
    private String f22640g;

    /* renamed from: h, reason: collision with root package name */
    private String f22641h;

    /* renamed from: i, reason: collision with root package name */
    private Long f22642i;

    /* renamed from: j, reason: collision with root package name */
    private v f22643j;

    /* renamed from: k, reason: collision with root package name */
    private i f22644k;
    private Map<String, Object> l;

    /* compiled from: SentryException.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<p> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p a(n2 n2Var, w1 w1Var) throws Exception {
            p pVar = new p();
            n2Var.b();
            HashMap hashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1562235024:
                        if (B.equals("thread_id")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1068784020:
                        if (B.equals("module")) {
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
                    case 111972721:
                        if (B.equals("value")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1225089881:
                        if (B.equals("mechanism")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 2055832509:
                        if (B.equals("stacktrace")) {
                            c2 = 5;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        pVar.f22642i = n2Var.G0();
                        break;
                    case 1:
                        pVar.f22641h = n2Var.N0();
                        break;
                    case 2:
                        pVar.f22639f = n2Var.N0();
                        break;
                    case 3:
                        pVar.f22640g = n2Var.N0();
                        break;
                    case 4:
                        pVar.f22644k = (i) n2Var.M0(w1Var, new i.a());
                        break;
                    case 5:
                        pVar.f22643j = (v) n2Var.M0(w1Var, new v.a());
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        n2Var.R0(w1Var, hashMap, B);
                        break;
                }
            }
            n2Var.j();
            pVar.o(hashMap);
            return pVar;
        }
    }

    public i g() {
        return this.f22644k;
    }

    public Long h() {
        return this.f22642i;
    }

    public String i() {
        return this.f22639f;
    }

    public void j(i iVar) {
        this.f22644k = iVar;
    }

    public void k(String str) {
        this.f22641h = str;
    }

    public void l(v vVar) {
        this.f22643j = vVar;
    }

    public void m(Long l) {
        this.f22642i = l;
    }

    public void n(String str) {
        this.f22639f = str;
    }

    public void o(Map<String, Object> map) {
        this.l = map;
    }

    public void p(String str) {
        this.f22640g = str;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22639f != null) {
            h3Var.k("type").b(this.f22639f);
        }
        if (this.f22640g != null) {
            h3Var.k("value").b(this.f22640g);
        }
        if (this.f22641h != null) {
            h3Var.k("module").b(this.f22641h);
        }
        if (this.f22642i != null) {
            h3Var.k("thread_id").e(this.f22642i);
        }
        if (this.f22643j != null) {
            h3Var.k("stacktrace").g(w1Var, this.f22643j);
        }
        if (this.f22644k != null) {
            h3Var.k("mechanism").g(w1Var, this.f22644k);
        }
        Map<String, Object> map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.l.get(str));
            }
        }
        h3Var.d();
    }
}
