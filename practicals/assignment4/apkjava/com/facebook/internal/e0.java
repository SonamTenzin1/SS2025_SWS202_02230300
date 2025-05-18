package com.facebook.internal;

import java.util.Arrays;

/* compiled from: FacebookGamingAction.kt */
/* loaded from: classes2.dex */
public enum e0 {
    ContextChoose("context_choose"),
    JoinTournament("join_tournament");


    /* renamed from: i, reason: collision with root package name */
    private final String f9769i;

    e0(String str) {
        this.f9769i = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static e0[] valuesCustom() {
        e0[] valuesCustom = values();
        return (e0[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final String k() {
        return this.f9769i;
    }
}
