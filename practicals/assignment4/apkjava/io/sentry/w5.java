package io.sentry;

import io.sentry.protocol.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UserFeedback.java */
/* loaded from: classes2.dex */
public final class w5 implements r2 {

    /* renamed from: f, reason: collision with root package name */
    private final io.sentry.protocol.q f22809f;

    /* renamed from: g, reason: collision with root package name */
    private String f22810g;

    /* renamed from: h, reason: collision with root package name */
    private String f22811h;

    /* renamed from: i, reason: collision with root package name */
    private String f22812i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Object> f22813j;

    /* compiled from: UserFeedback.java */
    /* loaded from: classes2.dex */
    public static final class a implements l2<w5> {
        /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0063 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0068 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x004e A[SYNTHETIC] */
        @Override // io.sentry.l2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public w5 a(n2 n2Var, w1 w1Var) throws Exception {
            n2Var.b();
            io.sentry.protocol.q qVar = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            HashMap hashMap = null;
            while (n2Var.N() == io.sentry.vendor.gson.stream.b.NAME) {
                String B = n2Var.B();
                B.hashCode();
                char c2 = 65535;
                switch (B.hashCode()) {
                    case -602415628:
                        if (B.equals("comments")) {
                            c2 = 0;
                        }
                        switch (c2) {
                            case 0:
                                str3 = n2Var.N0();
                                break;
                            case 1:
                                str = n2Var.N0();
                                break;
                            case 2:
                                str2 = n2Var.N0();
                                break;
                            case 3:
                                qVar = new q.a().a(n2Var, w1Var);
                                break;
                            default:
                                if (hashMap == null) {
                                    hashMap = new HashMap();
                                }
                                n2Var.R0(w1Var, hashMap, B);
                                break;
                        }
                    case 3373707:
                        if (B.equals("name")) {
                            c2 = 1;
                        }
                        switch (c2) {
                        }
                        break;
                    case 96619420:
                        if (B.equals("email")) {
                            c2 = 2;
                        }
                        switch (c2) {
                        }
                        break;
                    case 278118624:
                        if (B.equals("event_id")) {
                            c2 = 3;
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
            if (qVar != null) {
                w5 w5Var = new w5(qVar, str, str2, str3);
                w5Var.a(hashMap);
                return w5Var;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
            w1Var.b(s4.ERROR, "Missing required field \"event_id\"", illegalStateException);
            throw illegalStateException;
        }
    }

    public w5(io.sentry.protocol.q qVar, String str, String str2, String str3) {
        this.f22809f = qVar;
        this.f22810g = str;
        this.f22811h = str2;
        this.f22812i = str3;
    }

    public void a(Map<String, Object> map) {
        this.f22813j = map;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.f();
        h3Var.k("event_id");
        this.f22809f.serialize(h3Var, w1Var);
        if (this.f22810g != null) {
            h3Var.k("name").b(this.f22810g);
        }
        if (this.f22811h != null) {
            h3Var.k("email").b(this.f22811h);
        }
        if (this.f22812i != null) {
            h3Var.k("comments").b(this.f22812i);
        }
        Map<String, Object> map = this.f22813j;
        if (map != null) {
            for (String str : map.keySet()) {
                h3Var.k(str).g(w1Var, this.f22813j.get(str));
            }
        }
        h3Var.d();
    }

    public String toString() {
        return "UserFeedback{eventId=" + this.f22809f + ", name='" + this.f22810g + "', email='" + this.f22811h + "', comments='" + this.f22812i + "'}";
    }
}
