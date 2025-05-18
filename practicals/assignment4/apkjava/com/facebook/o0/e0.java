package com.facebook.o0;

import java.util.Arrays;

/* compiled from: FlushResult.kt */
/* loaded from: classes.dex */
public enum e0 {
    SUCCESS,
    SERVER_ERROR,
    NO_CONNECTIVITY,
    UNKNOWN_ERROR;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static e0[] valuesCustom() {
        e0[] valuesCustom = values();
        return (e0[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
