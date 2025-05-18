package io.sentry.protocol;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: TransactionNameSource.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public enum z {
    CUSTOM,
    URL,
    ROUTE,
    VIEW,
    COMPONENT,
    TASK;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
