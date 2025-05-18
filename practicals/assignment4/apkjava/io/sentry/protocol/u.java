package io.sentry.protocol;

import cm.aptoide.pt.downloadmanager.Constants;
import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.t4;
import io.sentry.w1;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SentryStackFrame.java */
/* loaded from: classes2.dex */
public final class u implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22660f;

    /* renamed from: g, reason: collision with root package name */
    private String f22661g;

    /* renamed from: h, reason: collision with root package name */
    private String f22662h;

    /* renamed from: i, reason: collision with root package name */
    private Integer f22663i;

    /* renamed from: j, reason: collision with root package name */
    private Integer f22664j;

    /* renamed from: k, reason: collision with root package name */
    private String f22665k;
    private String l;
    private Boolean m;
    private String n;
    private Boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private Map<String, Object> u;
    private String v;
    private t4 w;

    /* compiled from: SentryStackFrame.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<u> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a(n2 n2Var, w1 w1Var) throws Exception {
            u uVar = new u();
            n2Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1443345323:
                        if (B.equals("image_addr")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1184392185:
                        if (B.equals("in_app")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1113875953:
                        if (B.equals("raw_function")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1102671691:
                        if (B.equals("lineno")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1068784020:
                        if (B.equals("module")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1052618729:
                        if (B.equals("native")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -887523944:
                        if (B.equals("symbol")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -807062458:
                        if (B.equals(Constants.PACKAGE)) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -734768633:
                        if (B.equals("filename")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -330260936:
                        if (B.equals("symbol_addr")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 3327275:
                        if (B.equals("lock")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 94842689:
                        if (B.equals("colno")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 410194178:
                        if (B.equals("instruction_addr")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case 1116694660:
                        if (B.equals("context_line")) {
                            c2 = '\r';
                            break;
                        }
                        break;
                    case 1380938712:
                        if (B.equals("function")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case 1713445842:
                        if (B.equals("abs_path")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case 1874684019:
                        if (B.equals("platform")) {
                            c2 = 16;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        uVar.q = n2Var.N0();
                        break;
                    case 1:
                        uVar.m = n2Var.p0();
                        break;
                    case 2:
                        uVar.v = n2Var.N0();
                        break;
                    case 3:
                        uVar.f22663i = n2Var.E0();
                        break;
                    case 4:
                        uVar.f22662h = n2Var.N0();
                        break;
                    case 5:
                        uVar.o = n2Var.p0();
                        break;
                    case 6:
                        uVar.t = n2Var.N0();
                        break;
                    case 7:
                        uVar.n = n2Var.N0();
                        break;
                    case '\b':
                        uVar.f22660f = n2Var.N0();
                        break;
                    case '\t':
                        uVar.r = n2Var.N0();
                        break;
                    case '\n':
                        uVar.w = (t4) n2Var.M0(w1Var, new t4.a());
                        break;
                    case 11:
                        uVar.f22664j = n2Var.E0();
                        break;
                    case '\f':
                        uVar.s = n2Var.N0();
                        break;
                    case '\r':
                        uVar.l = n2Var.N0();
                        break;
                    case 14:
                        uVar.f22661g = n2Var.N0();
                        break;
                    case 15:
                        uVar.f22665k = n2Var.N0();
                        break;
                    case 16:
                        uVar.p = n2Var.N0();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            uVar.z(concurrentHashMap);
            n2Var.j();
            return uVar;
        }
    }

    public void r(String str) {
        this.f22660f = str;
    }

    public void s(String str) {
        this.f22661g = str;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22660f != null) {
            h3Var.k("filename").b(this.f22660f);
        }
        if (this.f22661g != null) {
            h3Var.k("function").b(this.f22661g);
        }
        if (this.f22662h != null) {
            h3Var.k("module").b(this.f22662h);
        }
        if (this.f22663i != null) {
            h3Var.k("lineno").e(this.f22663i);
        }
        if (this.f22664j != null) {
            h3Var.k("colno").e(this.f22664j);
        }
        if (this.f22665k != null) {
            h3Var.k("abs_path").b(this.f22665k);
        }
        if (this.l != null) {
            h3Var.k("context_line").b(this.l);
        }
        if (this.m != null) {
            h3Var.k("in_app").h(this.m);
        }
        if (this.n != null) {
            h3Var.k(Constants.PACKAGE).b(this.n);
        }
        if (this.o != null) {
            h3Var.k("native").h(this.o);
        }
        if (this.p != null) {
            h3Var.k("platform").b(this.p);
        }
        if (this.q != null) {
            h3Var.k("image_addr").b(this.q);
        }
        if (this.r != null) {
            h3Var.k("symbol_addr").b(this.r);
        }
        if (this.s != null) {
            h3Var.k("instruction_addr").b(this.s);
        }
        if (this.v != null) {
            h3Var.k("raw_function").b(this.v);
        }
        if (this.t != null) {
            h3Var.k("symbol").b(this.t);
        }
        if (this.w != null) {
            h3Var.k("lock").g(w1Var, this.w);
        }
        Map<String, Object> map = this.u;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.u.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public void t(Boolean bool) {
        this.m = bool;
    }

    public void u(Integer num) {
        this.f22663i = num;
    }

    public void v(t4 t4Var) {
        this.w = t4Var;
    }

    public void w(String str) {
        this.f22662h = str;
    }

    public void x(Boolean bool) {
        this.o = bool;
    }

    public void y(String str) {
        this.n = str;
    }

    public void z(Map<String, Object> map) {
        this.u = map;
    }
}
