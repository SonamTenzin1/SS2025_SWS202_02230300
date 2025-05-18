package io.sentry.util;

import io.sentry.s4;
import io.sentry.w1;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: LogUtils.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class p {
    public static void a(Class<?> cls, Object obj, w1 w1Var) {
        s4 s4Var = s4.DEBUG;
        Object[] objArr = new Object[2];
        objArr[0] = obj != null ? obj.getClass().getCanonicalName() : "Hint";
        objArr[1] = cls.getCanonicalName();
        w1Var.c(s4Var, "%s is not %s", objArr);
    }
}
