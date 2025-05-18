package com.facebook.login;

import java.util.Arrays;

/* compiled from: DefaultAudience.kt */
/* loaded from: classes2.dex */
public enum r {
    NONE(null),
    ONLY_ME("only_me"),
    FRIENDS("friends"),
    EVERYONE("everyone");


    /* renamed from: k, reason: collision with root package name */
    private final String f10029k;

    r(String str) {
        this.f10029k = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static r[] valuesCustom() {
        r[] valuesCustom = values();
        return (r[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final String k() {
        return this.f10029k;
    }
}
