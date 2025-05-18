package com.facebook;

import java.util.Arrays;

/* compiled from: LoggingBehavior.kt */
/* loaded from: classes.dex */
public enum g0 {
    REQUESTS,
    INCLUDE_ACCESS_TOKENS,
    INCLUDE_RAW_RESPONSES,
    CACHE,
    APP_EVENTS,
    DEVELOPER_ERRORS,
    GRAPH_API_DEBUG_WARNING,
    GRAPH_API_DEBUG_INFO;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static g0[] valuesCustom() {
        g0[] valuesCustom = values();
        return (g0[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
