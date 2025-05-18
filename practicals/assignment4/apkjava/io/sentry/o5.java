package io.sentry;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment;
import io.sentry.protocol.q;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: TraceContext.java */
@ApiStatus.Experimental
/* loaded from: classes2.dex */
public final class o5 implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final io.sentry.protocol.q f22528f;

    /* renamed from: g, reason: collision with root package name */
    private final String f22529g;

    /* renamed from: h, reason: collision with root package name */
    private final String f22530h;

    /* renamed from: i, reason: collision with root package name */
    private final String f22531i;

    /* renamed from: j, reason: collision with root package name */
    private final String f22532j;

    /* renamed from: k, reason: collision with root package name */
    private final String f22533k;
    private final String l;
    private final String m;
    private final String n;
    private Map<String, Object> o;

    /* compiled from: TraceContext.java */
    /* loaded from: classes2.dex */
    public static final class b implements l2<o5> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00f3  */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public o5 a(n2 n2Var, w1 w1Var) throws Exception {
            String str;
            String str2;
            n2Var.b();
            c cVar = null;
            String str3 = null;
            io.sentry.protocol.q qVar = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (true) {
                String str11 = str10;
                if (n2Var.N() != io.sentry.vendor.gson.stream.b.NAME) {
                    if (qVar == null) {
                        throw c("trace_id", w1Var);
                    }
                    if (str5 != null) {
                        if (cVar != null) {
                            if (str3 == null) {
                                str3 = cVar.a();
                            }
                            if (str4 == null) {
                                str2 = cVar.b();
                                str = str3;
                                o5 o5Var = new o5(qVar, str5, str6, str7, str, str2, str8, str9, str11);
                                o5Var.b(concurrentHashMap);
                                n2Var.j();
                                return o5Var;
                            }
                        }
                        str = str3;
                        str2 = str4;
                        o5 o5Var2 = new o5(qVar, str5, str6, str7, str, str2, str8, str9, str11);
                        o5Var2.b(concurrentHashMap);
                        n2Var.j();
                        return o5Var2;
                    }
                    throw c("public_key", w1Var);
                }
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -795593025:
                        if (B.equals("user_segment")) {
                            c2 = 0;
                        }
                        switch (c2) {
                            case 0:
                                str4 = n2Var.N0();
                                break;
                            case 1:
                                str3 = n2Var.N0();
                                break;
                            case 2:
                                str7 = n2Var.N0();
                                break;
                            case 3:
                                cVar = (c) n2Var.M0(w1Var, new c.a());
                                break;
                            case 4:
                                str9 = n2Var.N0();
                                break;
                            case 5:
                                str6 = n2Var.N0();
                                break;
                            case 6:
                                qVar = new q.a().a(n2Var, w1Var);
                                break;
                            case 7:
                                str10 = n2Var.N0();
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                                continue;
                            case '\b':
                                str5 = n2Var.J();
                                break;
                            case '\t':
                                str8 = n2Var.N0();
                                break;
                            default:
                                if (concurrentHashMap == null) {
                                    concurrentHashMap = new ConcurrentHashMap();
                                }
                                n2Var.R0(w1Var, concurrentHashMap, B);
                                break;
                        }
                        str10 = str11;
                    case -147132913:
                        if (B.equals(TimeLineFollowFragment.BundleKeys.USER_ID)) {
                            c2 = 1;
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case -85904877:
                        if (B.equals("environment")) {
                            c2 = 2;
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case 3599307:
                        if (B.equals("user")) {
                            c2 = 3;
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case 153193045:
                        if (B.equals("sample_rate")) {
                            c2 = 4;
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case 1090594823:
                        if (B.equals("release")) {
                            c2 = 5;
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case 1270300245:
                        if (B.equals("trace_id")) {
                            c2 = 6;
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case 1864843258:
                        if (B.equals("sampled")) {
                            c2 = 7;
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case 1904812937:
                        if (B.equals("public_key")) {
                            c2 = '\b';
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    case 2141246174:
                        if (B.equals("transaction")) {
                            c2 = '\t';
                        }
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                    default:
                        switch (c2) {
                        }
                        str10 = str11;
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraceContext.java */
    @Deprecated
    /* loaded from: classes2.dex */
    public static final class c {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private String f22534b;

        /* renamed from: c, reason: collision with root package name */
        private Map<String, Object> f22535c;

        /* compiled from: TraceContext.java */
        /* loaded from: classes2.dex */
        public static final class a implements l2<c> {
            @Override // io.sentry.l2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(n2 n2Var, w1 w1Var) throws Exception {
                n2Var.b();
                String str = null;
                String str2 = null;
                ConcurrentHashMap concurrentHashMap = null;
                while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                    String B = n2Var.B();
                    B.hashCode();
                    if (B.equals(DeepLinkIntentReceiver.DeepLinksKeys.ID)) {
                        str = n2Var.N0();
                    } else if (!B.equals("segment")) {
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        n2Var.R0(w1Var, concurrentHashMap, B);
                    } else {
                        str2 = n2Var.N0();
                    }
                }
                c cVar = new c(str, str2);
                cVar.c(concurrentHashMap);
                n2Var.j();
                return cVar;
            }
        }

        public String a() {
            return this.a;
        }

        public String b() {
            return this.f22534b;
        }

        public void c(Map<String, Object> map) {
            this.f22535c = map;
        }

        private c(String str, String str2) {
            this.a = str;
            this.f22534b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o5(io.sentry.protocol.q qVar, String str) {
        this(qVar, str, null, null, null, null, null, null, null);
    }

    public String a() {
        return this.m;
    }

    public void b(Map<String, Object> map) {
        this.o = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("trace_id").g(w1Var, this.f22528f);
        h3Var.k("public_key").b(this.f22529g);
        if (this.f22530h != null) {
            h3Var.k("release").b(this.f22530h);
        }
        if (this.f22531i != null) {
            h3Var.k("environment").b(this.f22531i);
        }
        if (this.f22532j != null) {
            h3Var.k(TimeLineFollowFragment.BundleKeys.USER_ID).b(this.f22532j);
        }
        if (this.f22533k != null) {
            h3Var.k("user_segment").b(this.f22533k);
        }
        if (this.l != null) {
            h3Var.k("transaction").b(this.l);
        }
        if (this.m != null) {
            h3Var.k("sample_rate").b(this.m);
        }
        if (this.n != null) {
            h3Var.k("sampled").b(this.n);
        }
        Map<String, Object> map = this.o;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.o.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o5(io.sentry.protocol.q qVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f22528f = qVar;
        this.f22529g = str;
        this.f22530h = str2;
        this.f22531i = str3;
        this.f22532j = str4;
        this.f22533k = str5;
        this.l = str6;
        this.m = str7;
        this.n = str8;
    }
}
