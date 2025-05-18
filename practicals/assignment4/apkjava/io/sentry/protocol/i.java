package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Mechanism.java */
/* loaded from: classes2.dex */
public final class i implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final transient Thread f22601f;

    /* renamed from: g, reason: collision with root package name */
    private String f22602g;

    /* renamed from: h, reason: collision with root package name */
    private String f22603h;

    /* renamed from: i, reason: collision with root package name */
    private String f22604i;

    /* renamed from: j, reason: collision with root package name */
    private Boolean f22605j;

    /* renamed from: k, reason: collision with root package name */
    private Map<String, Object> f22606k;
    private Map<String, Object> l;
    private Boolean m;
    private Map<String, Object> n;

    /* compiled from: Mechanism.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<i> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(n2 n2Var, w1 w1Var) throws Exception {
            i iVar = new i();
            n2Var.b();
            HashMap hashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1724546052:
                        if (B.equals("description")) {
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
                    case 3347973:
                        if (B.equals("meta")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3575610:
                        if (B.equals("type")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 692803388:
                        if (B.equals("handled")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 989128517:
                        if (B.equals("synthetic")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1297152568:
                        if (B.equals("help_link")) {
                            c2 = 6;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        iVar.f22603h = n2Var.N0();
                        break;
                    case 1:
                        iVar.l = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case 2:
                        iVar.f22606k = io.sentry.util.i.b((Map) n2Var.K0());
                        break;
                    case 3:
                        iVar.f22602g = n2Var.N0();
                        break;
                    case 4:
                        iVar.f22605j = n2Var.p0();
                        break;
                    case 5:
                        iVar.m = n2Var.p0();
                        break;
                    case 6:
                        iVar.f22604i = n2Var.N0();
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
            iVar.k(hashMap);
            return iVar;
        }
    }

    public i() {
        this(null);
    }

    public Boolean h() {
        return this.f22605j;
    }

    public void i(Boolean bool) {
        this.f22605j = bool;
    }

    public void j(String str) {
        this.f22602g = str;
    }

    public void k(Map<String, Object> map) {
        this.n = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22602g != null) {
            h3Var.k("type").b(this.f22602g);
        }
        if (this.f22603h != null) {
            h3Var.k("description").b(this.f22603h);
        }
        if (this.f22604i != null) {
            h3Var.k("help_link").b(this.f22604i);
        }
        if (this.f22605j != null) {
            h3Var.k("handled").h(this.f22605j);
        }
        if (this.f22606k != null) {
            h3Var.k("meta").g(w1Var, this.f22606k);
        }
        if (this.l != null) {
            h3Var.k("data").g(w1Var, this.l);
        }
        if (this.m != null) {
            h3Var.k("synthetic").h(this.m);
        }
        Map<String, Object> map = this.n;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.n.get(str));
            }
        }
        h3Var.d();
    }

    public i(Thread thread) {
        this.f22601f = thread;
    }
}
