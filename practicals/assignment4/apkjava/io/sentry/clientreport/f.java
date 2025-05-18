package io.sentry.clientreport;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: DiscardedEvent.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class f implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final String f22361f;

    /* renamed from: g, reason: collision with root package name */
    private final String f22362g;

    /* renamed from: h, reason: collision with root package name */
    private final Long f22363h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Object> f22364i;

    /* compiled from: DiscardedEvent.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<f> {
        private Exception c(String str, w1 w1Var) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            w1Var.b(s4.ERROR, str2, illegalStateException);
            return illegalStateException;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0042 A[SYNTHETIC] */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public f a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            String str = null;
            String str2 = null;
            Long l = null;
            HashMap hashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -1285004149:
                        if (B.equals("quantity")) {
                            c2 = 0;
                        }
                        switch (c2) {
                            case 0:
                                l = n2Var.G0();
                                break;
                            case 1:
                                str = n2Var.N0();
                                break;
                            case 2:
                                str2 = n2Var.N0();
                                break;
                            default:
                                if (hashMap == null) {
                                    hashMap = new HashMap();
                                }
                                n2Var.R0(w1Var, hashMap, B);
                                break;
                        }
                    case -934964668:
                        if (B.equals("reason")) {
                            c2 = 1;
                        }
                        switch (c2) {
                        }
                        break;
                    case 50511102:
                        if (B.equals("category")) {
                            c2 = 2;
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
            n2Var.j();
            if (str == null) {
                throw c("reason", w1Var);
            }
            if (str2 == null) {
                throw c("category", w1Var);
            }
            if (l != null) {
                f fVar = new f(str, str2, l);
                fVar.d(hashMap);
                return fVar;
            }
            throw c("quantity", w1Var);
        }
    }

    public f(String str, String str2, Long l) {
        this.f22361f = str;
        this.f22362g = str2;
        this.f22363h = l;
    }

    public String a() {
        return this.f22362g;
    }

    public Long b() {
        return this.f22363h;
    }

    public String c() {
        return this.f22361f;
    }

    public void d(Map<String, Object> map) {
        this.f22364i = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("reason").b(this.f22361f);
        h3Var.k("category").b(this.f22362g);
        h3Var.k("quantity").e(this.f22363h);
        Map<String, Object> map = this.f22364i;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22364i.get(str));
            }
        }
        h3Var.d();
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.f22361f + "', category='" + this.f22362g + "', quantity=" + this.f22363h + '}';
    }
}
