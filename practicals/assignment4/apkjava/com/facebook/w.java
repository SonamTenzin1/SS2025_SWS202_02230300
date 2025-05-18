package com.facebook;

import java.util.Arrays;

/* compiled from: AccessTokenSource.kt */
/* loaded from: classes.dex */
public enum w {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true),
    INSTAGRAM_APPLICATION_WEB(true),
    INSTAGRAM_CUSTOM_CHROME_TAB(true),
    INSTAGRAM_WEB_VIEW(true);

    private final boolean s;

    w(boolean z) {
        this.s = z;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static w[] valuesCustom() {
        w[] valuesCustom = values();
        return (w[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final boolean k() {
        return this.s;
    }
}
