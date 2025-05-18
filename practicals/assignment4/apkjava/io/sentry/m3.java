package io.sentry;

import io.sentry.n3;
import io.sentry.profilemeasurements.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ProfilingTraceData.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class m3 implements r2 {
    private String A;
    private String B;
    private String C;
    private String D;
    private final Map<String, io.sentry.profilemeasurements.a> E;
    private String F;
    private Map<String, Object> G;

    /* renamed from: f, reason: collision with root package name */
    private final File f22494f;

    /* renamed from: g, reason: collision with root package name */
    private final Callable<List<Integer>> f22495g;

    /* renamed from: h, reason: collision with root package name */
    private int f22496h;

    /* renamed from: i, reason: collision with root package name */
    private String f22497i;

    /* renamed from: j, reason: collision with root package name */
    private String f22498j;

    /* renamed from: k, reason: collision with root package name */
    private String f22499k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private String p;
    private List<Integer> q;
    private String r;
    private String s;
    private String t;
    private List<n3> u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* compiled from: ProfilingTraceData.java */
    /* loaded from: classes2.dex */
    public static final class b implements l2<m3> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m3 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            ConcurrentHashMap concurrentHashMap = null;
            m3 m3Var = new m3();
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -2133529830:
                        if (B.equals("device_manufacturer")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1981468849:
                        if (B.equals("android_api_level")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1430655860:
                        if (B.equals("build_id")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1172160413:
                        if (B.equals("device_locale")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1102636175:
                        if (B.equals("profile_id")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -716656436:
                        if (B.equals("device_os_build_number")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -591076352:
                        if (B.equals("device_model")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -512511455:
                        if (B.equals("device_is_emulator")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -478065584:
                        if (B.equals("duration_ns")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -362243017:
                        if (B.equals("measurements")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -332426004:
                        if (B.equals("device_physical_memory_bytes")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case -212264198:
                        if (B.equals("device_cpu_frequencies")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case -102985484:
                        if (B.equals("version_code")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case -102670958:
                        if (B.equals("version_name")) {
                            c2 = '\r';
                            break;
                        }
                        break;
                    case -85904877:
                        if (B.equals("environment")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case 508853068:
                        if (B.equals("transaction_name")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case 796476189:
                        if (B.equals("device_os_name")) {
                            c2 = 16;
                            break;
                        }
                        break;
                    case 839674195:
                        if (B.equals("architecture")) {
                            c2 = 17;
                            break;
                        }
                        break;
                    case 1010584092:
                        if (B.equals("transaction_id")) {
                            c2 = 18;
                            break;
                        }
                        break;
                    case 1052553990:
                        if (B.equals("device_os_version")) {
                            c2 = 19;
                            break;
                        }
                        break;
                    case 1163928186:
                        if (B.equals("truncation_reason")) {
                            c2 = 20;
                            break;
                        }
                        break;
                    case 1270300245:
                        if (B.equals("trace_id")) {
                            c2 = 21;
                            break;
                        }
                        break;
                    case 1874684019:
                        if (B.equals("platform")) {
                            c2 = 22;
                            break;
                        }
                        break;
                    case 1953158756:
                        if (B.equals("sampled_profile")) {
                            c2 = 23;
                            break;
                        }
                        break;
                    case 1954122069:
                        if (B.equals("transactions")) {
                            c2 = 24;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        String N0 = n2Var.N0();
                        if (N0 == null) {
                            break;
                        } else {
                            m3Var.f22498j = N0;
                            break;
                        }
                    case 1:
                        Integer E0 = n2Var.E0();
                        if (E0 == null) {
                            break;
                        } else {
                            m3Var.f22496h = E0.intValue();
                            break;
                        }
                    case 2:
                        String N02 = n2Var.N0();
                        if (N02 == null) {
                            break;
                        } else {
                            m3Var.t = N02;
                            break;
                        }
                    case 3:
                        String N03 = n2Var.N0();
                        if (N03 == null) {
                            break;
                        } else {
                            m3Var.f22497i = N03;
                            break;
                        }
                    case 4:
                        String N04 = n2Var.N0();
                        if (N04 == null) {
                            break;
                        } else {
                            m3Var.B = N04;
                            break;
                        }
                    case 5:
                        String N05 = n2Var.N0();
                        if (N05 == null) {
                            break;
                        } else {
                            m3Var.l = N05;
                            break;
                        }
                    case 6:
                        String N06 = n2Var.N0();
                        if (N06 == null) {
                            break;
                        } else {
                            m3Var.f22499k = N06;
                            break;
                        }
                    case 7:
                        Boolean p0 = n2Var.p0();
                        if (p0 == null) {
                            break;
                        } else {
                            m3Var.o = p0.booleanValue();
                            break;
                        }
                    case '\b':
                        String N07 = n2Var.N0();
                        if (N07 == null) {
                            break;
                        } else {
                            m3Var.w = N07;
                            break;
                        }
                    case '\t':
                        Map J0 = n2Var.J0(w1Var, new a.C0307a());
                        if (J0 == null) {
                            break;
                        } else {
                            m3Var.E.putAll(J0);
                            break;
                        }
                    case '\n':
                        String N08 = n2Var.N0();
                        if (N08 == null) {
                            break;
                        } else {
                            m3Var.r = N08;
                            break;
                        }
                    case 11:
                        List list = (List) n2Var.K0();
                        if (list == null) {
                            break;
                        } else {
                            m3Var.q = list;
                            break;
                        }
                    case '\f':
                        String N09 = n2Var.N0();
                        if (N09 == null) {
                            break;
                        } else {
                            m3Var.x = N09;
                            break;
                        }
                    case '\r':
                        String N010 = n2Var.N0();
                        if (N010 == null) {
                            break;
                        } else {
                            m3Var.y = N010;
                            break;
                        }
                    case 14:
                        String N011 = n2Var.N0();
                        if (N011 == null) {
                            break;
                        } else {
                            m3Var.C = N011;
                            break;
                        }
                    case 15:
                        String N012 = n2Var.N0();
                        if (N012 == null) {
                            break;
                        } else {
                            m3Var.v = N012;
                            break;
                        }
                    case 16:
                        String N013 = n2Var.N0();
                        if (N013 == null) {
                            break;
                        } else {
                            m3Var.m = N013;
                            break;
                        }
                    case 17:
                        String N014 = n2Var.N0();
                        if (N014 == null) {
                            break;
                        } else {
                            m3Var.p = N014;
                            break;
                        }
                    case 18:
                        String N015 = n2Var.N0();
                        if (N015 == null) {
                            break;
                        } else {
                            m3Var.z = N015;
                            break;
                        }
                    case 19:
                        String N016 = n2Var.N0();
                        if (N016 == null) {
                            break;
                        } else {
                            m3Var.n = N016;
                            break;
                        }
                    case 20:
                        String N017 = n2Var.N0();
                        if (N017 == null) {
                            break;
                        } else {
                            m3Var.D = N017;
                            break;
                        }
                    case 21:
                        String N018 = n2Var.N0();
                        if (N018 == null) {
                            break;
                        } else {
                            m3Var.A = N018;
                            break;
                        }
                    case 22:
                        String N019 = n2Var.N0();
                        if (N019 == null) {
                            break;
                        } else {
                            m3Var.s = N019;
                            break;
                        }
                    case 23:
                        String N020 = n2Var.N0();
                        if (N020 == null) {
                            break;
                        } else {
                            m3Var.F = N020;
                            break;
                        }
                    case 24:
                        List F0 = n2Var.F0(w1Var, new n3.a());
                        if (F0 == null) {
                            break;
                        } else {
                            m3Var.u.addAll(F0);
                            break;
                        }
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                        break;
                }
            }
            m3Var.F(concurrentHashMap);
            n2Var.j();
            return m3Var;
        }
    }

    private boolean B() {
        return this.D.equals("normal") || this.D.equals("timeout") || this.D.equals("backgrounded");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List C() throws Exception {
        return new ArrayList();
    }

    public File A() {
        return this.f22494f;
    }

    public void D() {
        try {
            this.q = this.f22495g.call();
        } catch (Throwable unused) {
        }
    }

    public void E(String str) {
        this.F = str;
    }

    public void F(Map<String, Object> map) {
        this.G = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("android_api_level").g(w1Var, Integer.valueOf(this.f22496h));
        h3Var.k("device_locale").g(w1Var, this.f22497i);
        h3Var.k("device_manufacturer").b(this.f22498j);
        h3Var.k("device_model").b(this.f22499k);
        h3Var.k("device_os_build_number").b(this.l);
        h3Var.k("device_os_name").b(this.m);
        h3Var.k("device_os_version").b(this.n);
        h3Var.k("device_is_emulator").c(this.o);
        h3Var.k("architecture").g(w1Var, this.p);
        h3Var.k("device_cpu_frequencies").g(w1Var, this.q);
        h3Var.k("device_physical_memory_bytes").b(this.r);
        h3Var.k("platform").b(this.s);
        h3Var.k("build_id").b(this.t);
        h3Var.k("transaction_name").b(this.v);
        h3Var.k("duration_ns").b(this.w);
        h3Var.k("version_name").b(this.y);
        h3Var.k("version_code").b(this.x);
        if (!this.u.isEmpty()) {
            h3Var.k("transactions").g(w1Var, this.u);
        }
        h3Var.k("transaction_id").b(this.z);
        h3Var.k("trace_id").b(this.A);
        h3Var.k("profile_id").b(this.B);
        h3Var.k("environment").b(this.C);
        h3Var.k("truncation_reason").b(this.D);
        if (this.F != null) {
            h3Var.k("sampled_profile").b(this.F);
        }
        h3Var.k("measurements").g(w1Var, this.E);
        Map<String, Object> map = this.G;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.G.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    public String z() {
        return this.B;
    }

    private m3() {
        this(new File("dummy"), d3.r());
    }

    public m3(File file, e2 e2Var) {
        this(file, new ArrayList(), e2Var, "0", 0, HttpUrl.FRAGMENT_ENCODE_SET, new Callable() { // from class: io.sentry.r
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m3.C();
            }
        }, null, null, null, null, null, null, null, null, "normal", new HashMap());
    }

    public m3(File file, List<n3> list, e2 e2Var, String str, int i2, String str2, Callable<List<Integer>> callable, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, Map<String, io.sentry.profilemeasurements.a> map) {
        this.q = new ArrayList();
        this.F = null;
        this.f22494f = file;
        this.p = str2;
        this.f22495g = callable;
        this.f22496h = i2;
        this.f22497i = Locale.getDefault().toString();
        String str11 = HttpUrl.FRAGMENT_ENCODE_SET;
        this.f22498j = str3 != null ? str3 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.f22499k = str4 != null ? str4 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.n = str5 != null ? str5 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.o = bool != null ? bool.booleanValue() : false;
        this.r = str6 != null ? str6 : "0";
        this.l = HttpUrl.FRAGMENT_ENCODE_SET;
        this.m = "android";
        this.s = "android";
        this.t = str7 != null ? str7 : HttpUrl.FRAGMENT_ENCODE_SET;
        this.u = list;
        this.v = e2Var.getName();
        this.w = str;
        this.x = HttpUrl.FRAGMENT_ENCODE_SET;
        this.y = str8 != null ? str8 : str11;
        this.z = e2Var.k().toString();
        this.A = e2Var.m().k().toString();
        this.B = UUID.randomUUID().toString();
        this.C = str9 != null ? str9 : "production";
        this.D = str10;
        if (!B()) {
            this.D = "normal";
        }
        this.E = map;
    }
}
