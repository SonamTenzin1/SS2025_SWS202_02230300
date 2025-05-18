package io.sentry.android.core;

import android.content.Context;
import io.sentry.Integration;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AnrIntegrationFactory.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class o0 {
    public static Integration a(Context context, s0 s0Var) {
        if (s0Var.d() >= 30) {
            return new AnrV2Integration(context);
        }
        return new AnrIntegration(context);
    }
}
