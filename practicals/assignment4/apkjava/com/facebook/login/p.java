package com.facebook.login;

import java.util.Arrays;

/* compiled from: CodeChallengeMethod.kt */
/* loaded from: classes2.dex */
public enum p {
    S256("S256"),
    PLAIN("plain");

    p(String str) {
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static p[] valuesCustom() {
        p[] valuesCustom = values();
        return (p[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
