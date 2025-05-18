package io.sentry.android.core.internal.util;

import io.sentry.protocol.e;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: DeviceOrientations.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class o {
    public static e.b a(int i2) {
        if (i2 == 1) {
            return e.b.PORTRAIT;
        }
        if (i2 != 2) {
            return null;
        }
        return e.b.LANDSCAPE;
    }
}
