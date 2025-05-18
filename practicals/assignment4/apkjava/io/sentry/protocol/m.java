package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Response.java */
/* loaded from: classes2.dex */
public final class m implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22623f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f22624g;

    /* renamed from: h, reason: collision with root package name */
    private Integer f22625h;

    /* renamed from: i, reason: collision with root package name */
    private Long f22626i;

    /* renamed from: j, reason: collision with root package name */
    private Object f22627j;

    /* renamed from: k, reason: collision with root package name */
    private Map<String, Object> f22628k;

    /* compiled from: Response.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<m> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            m mVar = new m();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -891699686:
                        if (B.equals("status_code")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3076010:
                        if (B.equals("data")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 795307910:
                        if (B.equals("headers")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 952189583:
                        if (B.equals("cookies")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1252988030:
                        if (B.equals("body_size")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        mVar.f22625h = n2Var.E0();
                        break;
                    case 1:
                        mVar.f22627j = n2Var.K0();
                        break;
                    case 2:
                        Map map = (Map) n2Var.K0();
                        if (map == null) {
                            break;
                        } else {
                            mVar.f22624g = io.sentry.util.i.b(map);
                            break;
                        }
                    case 3:
                        mVar.f22623f = n2Var.N0();
                        break;
                    case 4:
                        mVar.f22626i = n2Var.G0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            mVar.f(concurrentHashMap);
            n2Var.j();
            return mVar;
        }
    }

    public m() {
    }

    public void f(Map<String, Object> map) {
        this.f22628k = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22623f != null) {
            h3Var.k("cookies").b(this.f22623f);
        }
        if (this.f22624g != null) {
            h3Var.k("headers").g(w1Var, this.f22624g);
        }
        if (this.f22625h != null) {
            h3Var.k("status_code").g(w1Var, this.f22625h);
        }
        if (this.f22626i != null) {
            h3Var.k("body_size").g(w1Var, this.f22626i);
        }
        if (this.f22627j != null) {
            h3Var.k("data").g(w1Var, this.f22627j);
        }
        Map<String, Object> map = this.f22628k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22628k.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public m(m mVar) {
        this.f22623f = mVar.f22623f;
        this.f22624g = io.sentry.util.i.b(mVar.f22624g);
        this.f22628k = io.sentry.util.i.b(mVar.f22628k);
        this.f22625h = mVar.f22625h;
        this.f22626i = mVar.f22626i;
        this.f22627j = mVar.f22627j;
    }
}
