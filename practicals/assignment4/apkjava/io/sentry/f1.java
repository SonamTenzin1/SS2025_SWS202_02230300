package io.sentry;

import cm.aptoide.pt.dataprovider.BuildConfig;
import java.net.URI;

/* compiled from: Dsn.java */
/* loaded from: classes2.dex */
final class f1 {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22406b;

    /* renamed from: c, reason: collision with root package name */
    private final String f22407c;

    /* renamed from: d, reason: collision with root package name */
    private final String f22408d;

    /* renamed from: e, reason: collision with root package name */
    private final URI f22409e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1(String str) throws IllegalArgumentException {
        try {
            io.sentry.util.q.c(str, "The DSN is required.");
            URI normalize = new URI(str).normalize();
            String scheme = normalize.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equalsIgnoreCase(scheme)) {
                throw new IllegalArgumentException("Invalid DSN scheme: " + scheme);
            }
            String userInfo = normalize.getUserInfo();
            if (userInfo != null && !userInfo.isEmpty()) {
                String[] split = userInfo.split(":", -1);
                String str2 = split[0];
                this.f22408d = str2;
                if (str2 != null && !str2.isEmpty()) {
                    this.f22407c = split.length > 1 ? split[1] : null;
                    String path = normalize.getPath();
                    path = path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
                    int lastIndexOf = path.lastIndexOf("/") + 1;
                    String substring = path.substring(0, lastIndexOf);
                    if (!substring.endsWith("/")) {
                        substring = substring + "/";
                    }
                    this.f22406b = substring;
                    String substring2 = path.substring(lastIndexOf);
                    this.a = substring2;
                    if (!substring2.isEmpty()) {
                        this.f22409e = new URI(scheme, null, normalize.getHost(), normalize.getPort(), substring + "api/" + substring2, null, null);
                        return;
                    }
                    throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
                }
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            throw new IllegalArgumentException("Invalid DSN: No public key provided.");
        } catch (Throwable th) {
            throw new IllegalArgumentException(th);
        }
    }

    public String a() {
        return this.f22408d;
    }

    public String b() {
        return this.f22407c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public URI c() {
        return this.f22409e;
    }
}
