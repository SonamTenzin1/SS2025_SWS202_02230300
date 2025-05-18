package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.s4;
import io.sentry.w1;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SentryPackage.java */
/* loaded from: classes2.dex */
public final class r implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22647f;

    /* renamed from: g, reason: collision with root package name */
    private String f22648g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Object> f22649h;

    /* compiled from: SentryPackage.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<r> {
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public r a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            String str = null;
            String str2 = null;
            HashMap hashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                if (B.equals("name")) {
                    str = n2Var.J();
                } else if (!B.equals("version")) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    n2Var.R0(w1Var, hashMap, B);
                } else {
                    str2 = n2Var.J();
                }
            }
            n2Var.j();
            if (str == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                w1Var.b(s4.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (str2 != null) {
                r rVar = new r(str, str2);
                rVar.a(hashMap);
                return rVar;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
            w1Var.b(s4.ERROR, "Missing required field \"version\"", illegalStateException2);
            throw illegalStateException2;
        }
    }

    public r(String str, String str2) {
        this.f22647f = (String) io.sentry.util.q.c(str, "name is required.");
        this.f22648g = (String) io.sentry.util.q.c(str2, "version is required.");
    }

    public void a(Map<String, Object> map) {
        this.f22649h = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return c.i.j.c.a(this.f22647f, rVar.f22647f) && c.i.j.c.a(this.f22648g, rVar.f22648g);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f22647f, this.f22648g});
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("name").b(this.f22647f);
        h3Var.k("version").b(this.f22648g);
        Map<String, Object> map = this.f22649h;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22649h.get(str));
            }
        }
        h3Var.d();
    }
}
