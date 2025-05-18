package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.m;

/* compiled from: exceptionUtils.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(Throwable th) {
        m.f(th, "<this>");
        Class<?> cls = th.getClass();
        while (!m.a(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException b(Throwable th) {
        m.f(th, "e");
        throw th;
    }
}
