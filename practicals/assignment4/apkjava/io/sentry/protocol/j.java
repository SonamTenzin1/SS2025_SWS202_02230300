package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Message.java */
/* loaded from: classes2.dex */
public final class j implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22607f;

    /* renamed from: g, reason: collision with root package name */
    private String f22608g;

    /* renamed from: h, reason: collision with root package name */
    private List<String> f22609h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22610i;

    /* compiled from: Message.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<j> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            j jVar = new j();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -995427962:
                        if (B.equals("params")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 954925063:
                        if (B.equals("message")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1811591356:
                        if (B.equals("formatted")) {
                            c2 = 2;
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
                            jVar.f22609h = list;
                            break;
                        }
                    case 1:
                        jVar.f22608g = n2Var.N0();
                        break;
                    case 2:
                        jVar.f22607f = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            jVar.f(concurrentHashMap);
            n2Var.j();
            return jVar;
        }
    }

    public void d(String str) {
        this.f22607f = str;
    }

    public void e(String str) {
        this.f22608g = str;
    }

    public void f(Map<String, Object> map) {
        this.f22610i = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22607f != null) {
            h3Var.k("formatted").b(this.f22607f);
        }
        if (this.f22608g != null) {
            h3Var.k("message").b(this.f22608g);
        }
        List<String> list = this.f22609h;
        if (list != null && !list.isEmpty()) {
            h3Var.k("params").g(w1Var, this.f22609h);
        }
        Map<String, Object> map = this.f22610i;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f22610i.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }
}
