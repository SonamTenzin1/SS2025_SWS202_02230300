package io.sentry.config;

import io.sentry.s4;
import io.sentry.w1;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* compiled from: ClasspathPropertiesLoader.java */
/* loaded from: classes2.dex */
final class b {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final ClassLoader f22366b;

    /* renamed from: c, reason: collision with root package name */
    private final w1 f22367c;

    public b(String str, ClassLoader classLoader, w1 w1Var) {
        this.a = str;
        this.f22366b = io.sentry.util.h.a(classLoader);
        this.f22367c = w1Var;
    }

    public Properties a() {
        try {
            InputStream resourceAsStream = this.f22366b.getResourceAsStream(this.a);
            if (resourceAsStream == null) {
                if (resourceAsStream != null) {
                }
                return null;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    resourceAsStream.close();
                    return properties;
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } finally {
                try {
                    resourceAsStream.close();
                } catch (Throwable unused2) {
                }
            }
        } catch (IOException e2) {
            this.f22367c.a(s4.ERROR, e2, "Failed to load Sentry configuration from classpath resource: %s", this.a);
            return null;
        }
    }

    public b(w1 w1Var) {
        this("sentry.properties", b.class.getClassLoader(), w1Var);
    }
}
