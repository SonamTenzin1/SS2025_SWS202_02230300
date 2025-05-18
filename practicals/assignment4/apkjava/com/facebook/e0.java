package com.facebook;

import java.util.Arrays;

/* compiled from: HttpMethod.kt */
/* loaded from: classes.dex */
public enum e0 {
    GET,
    POST,
    DELETE;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static e0[] valuesCustom() {
        e0[] valuesCustom = values();
        return (e0[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
