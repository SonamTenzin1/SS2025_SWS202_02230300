package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public final class GmsLogger {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11988b;

    @KeepForSdk
    public GmsLogger(String str) {
        this(str, null);
    }

    @KeepForSdk
    public GmsLogger(String str, String str2) {
        Preconditions.l(str, "log tag cannot be null");
        Preconditions.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f11988b = null;
        } else {
            this.f11988b = str2;
        }
    }
}
