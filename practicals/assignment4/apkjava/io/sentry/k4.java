package io.sentry;

import io.sentry.r4;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: SentryEnvelopeItemHeader.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class k4 implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final String f22464f;

    /* renamed from: g, reason: collision with root package name */
    private final String f22465g;

    /* renamed from: h, reason: collision with root package name */
    private final r4 f22466h;

    /* renamed from: i, reason: collision with root package name */
    private final int f22467i;

    /* renamed from: j, reason: collision with root package name */
    private final Callable<Integer> f22468j;

    /* renamed from: k, reason: collision with root package name */
    private final String f22469k;
    private Map<String, Object> l;

    /* compiled from: SentryEnvelopeItemHeader.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<k4> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0085 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x005b A[SYNTHETIC] */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public k4 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            HashMap hashMap = null;
            r4 r4Var = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1106363674:
                        if (B.equals("length")) {
                            c2 = 0;
                        }
                        switch (c2) {
                            case 0:
                                i2 = n2Var.z();
                                break;
                            case 1:
                                str2 = n2Var.N0();
                                break;
                            case 2:
                                str3 = n2Var.N0();
                                break;
                            case 3:
                                r4Var = (r4) n2Var.M0(w1Var, new r4.a());
                                break;
                            case 4:
                                str = n2Var.N0();
                                break;
                            default:
                                if (hashMap == null) {
                                    hashMap = new HashMap();
                                }
                                n2Var.R0(w1Var, hashMap, B);
                                break;
                        }
                    case -734768633:
                        if (B.equals("filename")) {
                            c2 = 1;
                        }
                        switch (c2) {
                        }
                        break;
                    case -672977706:
                        if (B.equals("attachment_type")) {
                            c2 = 2;
                        }
                        switch (c2) {
                        }
                        break;
                    case 3575610:
                        if (B.equals("type")) {
                            c2 = 3;
                        }
                        switch (c2) {
                        }
                        break;
                    case 831846208:
                        if (B.equals("content_type")) {
                            c2 = 4;
                        }
                        switch (c2) {
                        }
                        break;
                    default:
                        switch (c2) {
                        }
                        break;
                }
            }
            if (r4Var != null) {
                k4 k4Var = new k4(r4Var, i2, str, str2, str3);
                k4Var.c(hashMap);
                n2Var.j();
                return k4Var;
            }
            throw c("type", w1Var);
        }
    }

    @ApiStatus.Internal
    public k4(r4 r4Var, int i2, String str, String str2, String str3) {
        this.f22466h = (r4) io.sentry.util.q.c(r4Var, "type is required");
        this.f22464f = str;
        this.f22467i = i2;
        this.f22465g = str2;
        this.f22468j = null;
        this.f22469k = str3;
    }

    public int a() {
        Callable<Integer> callable = this.f22468j;
        if (callable != null) {
            try {
                return callable.call().intValue();
            } catch (Throwable unused) {
                return -1;
            }
        }
        return this.f22467i;
    }

    public r4 b() {
        return this.f22466h;
    }

    public void c(Map<String, Object> map) {
        this.l = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22464f != null) {
            h3Var.k("content_type").b(this.f22464f);
        }
        if (this.f22465g != null) {
            h3Var.k("filename").b(this.f22465g);
        }
        h3Var.k("type").g(w1Var, this.f22466h);
        if (this.f22469k != null) {
            h3Var.k("attachment_type").b(this.f22469k);
        }
        h3Var.k("length").a(a());
        Map<String, Object> map = this.l;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.l.get(str);
                h3Var.k(str);
                h3Var.g(w1Var, obj);
            }
        }
        h3Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k4(r4 r4Var, Callable<Integer> callable, String str, String str2, String str3) {
        this.f22466h = (r4) io.sentry.util.q.c(r4Var, "type is required");
        this.f22464f = str;
        this.f22467i = -1;
        this.f22465g = str2;
        this.f22468j = callable;
        this.f22469k = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k4(r4 r4Var, Callable<Integer> callable, String str, String str2) {
        this(r4Var, callable, str, str2, (String) null);
    }
}
