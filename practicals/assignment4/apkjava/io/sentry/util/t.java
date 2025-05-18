package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: SampleRateUtils.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class t {
    public static boolean a(Double d2) {
        return b(d2, true);
    }

    private static boolean b(Double d2, boolean z) {
        return d2 == null ? z : !d2.isNaN() && d2.doubleValue() >= 0.0d && d2.doubleValue() <= 1.0d;
    }

    public static boolean c(Double d2) {
        return b(d2, true);
    }

    public static boolean d(Double d2) {
        return e(d2, true);
    }

    public static boolean e(Double d2, boolean z) {
        return b(d2, z);
    }
}
