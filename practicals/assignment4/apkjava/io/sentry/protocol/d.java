package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.n;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DebugMeta.java */
/* loaded from: classes2.dex */
public final class d implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private n f22579f;

    /* renamed from: g, reason: collision with root package name */
    private List<DebugImage> f22580g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Object> f22581h;

    /* compiled from: DebugMeta.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<d> {
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(n2 n2Var, w1 w1Var) throws Exception {
            d dVar = new d();
            n2Var.b();
            HashMap hashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                if (B.equals("images")) {
                    dVar.f22580g = n2Var.F0(w1Var, new DebugImage.a());
                } else if (B.equals("sdk_info")) {
                    dVar.f22579f = (n) n2Var.M0(w1Var, new n.a());
                } else {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    n2Var.R0(w1Var, hashMap, B);
                }
            }
            n2Var.j();
            dVar.e(hashMap);
            return dVar;
        }
    }

    public List<DebugImage> c() {
        return this.f22580g;
    }

    public void d(List<DebugImage> list) {
        this.f22580g = list != null ? new ArrayList(list) : null;
    }

    public void e(Map<String, Object> map) {
        this.f22581h = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22579f != null) {
            h3Var.k("sdk_info").g(w1Var, this.f22579f);
        }
        if (this.f22580g != null) {
            h3Var.k("images").g(w1Var, this.f22580g);
        }
        Map<String, Object> map = this.f22581h;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22581h.get(str));
            }
        }
        h3Var.d();
    }
}
