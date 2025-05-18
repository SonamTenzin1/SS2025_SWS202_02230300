package io.sentry.util;

/* compiled from: ClassLoaderUtils.java */
/* loaded from: classes2.dex */
public final class h {
    public static ClassLoader a(ClassLoader classLoader) {
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }
}
