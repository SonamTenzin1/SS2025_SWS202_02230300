package com.facebook.o0;

import java.util.Arrays;

/* compiled from: FlushReason.kt */
/* loaded from: classes.dex */
public enum d0 {
    EXPLICIT,
    TIMER,
    SESSION_CHANGE,
    PERSISTED_EVENTS,
    EVENT_THRESHOLD,
    EAGER_FLUSHING_EVENT;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static d0[] valuesCustom() {
        d0[] valuesCustom = values();
        return (d0[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
