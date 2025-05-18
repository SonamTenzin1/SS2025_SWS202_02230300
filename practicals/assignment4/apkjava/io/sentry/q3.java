package io.sentry;

import java.net.URI;
import java.util.HashMap;
import okhttp3.HttpUrl;

/* compiled from: RequestDetailsResolver.java */
/* loaded from: classes2.dex */
final class q3 {
    private final x4 a;

    public q3(x4 x4Var) {
        this.a = (x4) io.sentry.util.q.c(x4Var, "options is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3 a() {
        String str;
        f1 f1Var = new f1(this.a.getDsn());
        URI c2 = f1Var.c();
        String uri = c2.resolve(c2.getPath() + "/envelope/").toString();
        String a = f1Var.a();
        String b2 = f1Var.b();
        StringBuilder sb = new StringBuilder();
        sb.append("Sentry sentry_version=7,sentry_client=");
        sb.append(this.a.getSentryClientName());
        sb.append(",sentry_key=");
        sb.append(a);
        if (b2 == null || b2.length() <= 0) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str = ",sentry_secret=" + b2;
        }
        sb.append(str);
        String sb2 = sb.toString();
        String sentryClientName = this.a.getSentryClientName();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", sentryClientName);
        hashMap.put("X-Sentry-Auth", sb2);
        return new p3(uri, hashMap);
    }
}
