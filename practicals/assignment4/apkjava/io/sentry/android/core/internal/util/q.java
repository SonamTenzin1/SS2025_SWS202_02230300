package io.sentry.android.core.internal.util;

import android.content.Context;
import android.os.Process;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: Permissions.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class q {
    public static boolean a(Context context, String str) {
        io.sentry.util.q.c(context, "The application context is required.");
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
