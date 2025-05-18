package io.sentry.protocol;

import io.sentry.h3;
import io.sentry.l2;
import io.sentry.n2;
import io.sentry.r2;
import io.sentry.w1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SdkInfo.java */
/* loaded from: classes2.dex */
public final class n implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private String f22629f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f22630g;

    /* renamed from: h, reason: collision with root package name */
    private Integer f22631h;

    /* renamed from: i, reason: collision with root package name */
    private Integer f22632i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Object> f22633j;

    /* compiled from: SdkInfo.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<n> {
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public n a(n2 n2Var, w1 w1Var) throws Exception {
            n nVar = new n();
            n2Var.b();
            HashMap hashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case 270207856:
                        if (B.equals("sdk_name")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 696101379:
                        if (B.equals("version_patchlevel")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1111241618:
                        if (B.equals("version_major")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1111483790:
                        if (B.equals("version_minor")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        nVar.f22629f = n2Var.N0();
                        break;
                    case 1:
                        nVar.f22632i = n2Var.E0();
                        break;
                    case 2:
                        nVar.f22630g = n2Var.E0();
                        break;
                    case 3:
                        nVar.f22631h = n2Var.E0();
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
            nVar.e(hashMap);
            return nVar;
        }
    }

    public void e(Map<String, Object> map) {
        this.f22633j = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        if (this.f22629f != null) {
            h3Var.k("sdk_name").b(this.f22629f);
        }
        if (this.f22630g != null) {
            h3Var.k("version_major").e(this.f22630g);
        }
        if (this.f22631h != null) {
            h3Var.k("version_minor").e(this.f22631h);
        }
        if (this.f22632i != null) {
            h3Var.k("version_patchlevel").e(this.f22632i);
        }
        Map<String, Object> map = this.f22633j;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22633j.get(str));
            }
        }
        h3Var.d();
    }
}
