package io.sentry.android.core.internal.util;

import org.jetbrains.annotations.ApiStatus;

/* compiled from: ClassUtil.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public class j {
    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        return canonicalName != null ? canonicalName : obj.getClass().getSimpleName();
    }
}
