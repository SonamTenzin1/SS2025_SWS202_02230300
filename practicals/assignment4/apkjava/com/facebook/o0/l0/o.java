package com.facebook.o0.l0;

import java.util.Arrays;

/* compiled from: AppEventsCAPIManager.kt */
/* loaded from: classes.dex */
public enum o {
    URL("endpoint"),
    ENABLED("is_enabled"),
    DATASETID("dataset_id"),
    ACCESSKEY("access_key");


    /* renamed from: k, reason: collision with root package name */
    private final String f10246k;

    o(String str) {
        this.f10246k = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static o[] valuesCustom() {
        o[] valuesCustom = values();
        return (o[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final String k() {
        return this.f10246k;
    }
}
